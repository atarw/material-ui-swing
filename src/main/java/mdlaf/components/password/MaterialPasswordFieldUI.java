/*
 * MIT License
 *
 * Copyright (c) 2019 Vincent Palazzo vincenzopalazzodev@gmail.com
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package mdlaf.components.password;

import mdlaf.utils.MaterialDrawingUtils;
import javax.swing.*;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicPasswordFieldUI;
import javax.swing.text.Element;
import javax.swing.text.PasswordView;
import javax.swing.text.View;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 * @contributor https://github.com/vincenzopalazzo
 */
public class MaterialPasswordFieldUI extends BasicPasswordFieldUI {

    protected static final String PROPERTY_LINE_COLOR = "lineColor";
    protected static final String PROPERTY_SELECTION_COLOR = "selectionColor";
    protected static final String PROPERTY_SELECTION_TEXT_COLOR = "selectedTextColor";

    protected boolean drawLine;
    protected Color activeBackground;
    protected Color activeForeground;
    protected Color inactiveBackground;
    protected Color inactiveForeground;
    protected Color colorLineInactive;
    protected Color colorLineActive;
    protected Color colorLine;
    protected Color background;
    protected FocusListener focusListenerColorLine;
    protected PropertyChangeListener propertyChangeListener;
    protected PropertyChangeSupport propertyChangeSupport;

    public MaterialPasswordFieldUI() {
        this(true);
    }

    public MaterialPasswordFieldUI(boolean drawLine) {
        super();
        this.drawLine = drawLine;
        this.focusListenerColorLine = new FocusListenerColorLine();
        this.propertyChangeListener = new MaterialPropertyChangeListener();
        this.propertyChangeSupport = new PropertyChangeSupport(this);
    }

    public static ComponentUI createUI(JComponent c) {
        return new MaterialPasswordFieldUI();
    }

    @Override
    public void installUI(JComponent c) {
        super.installUI(c);
        JPasswordField passwordField = (JPasswordField) c;
        passwordField.setEchoChar('\u2022');
    }

    @Override
    protected void installDefaults() {
        super.installDefaults();
        installMyDefaults();
    }

    @Override
    public void uninstallUI(JComponent c) {

        c.setFont (null);
        c.setBackground (null);
        c.setForeground (null);
        c.setBorder (null);
        c.setCursor(null);

        super.uninstallUI(c);
    }

    @Override
    protected void uninstallDefaults() {
        super.uninstallDefaults();
        getComponent().setBorder(null);
    }

    @Override
    protected void installListeners() {
        super.installListeners();
        getComponent().addFocusListener(focusListenerColorLine);
        getComponent().addPropertyChangeListener(propertyChangeListener);
        propertyChangeSupport.addPropertyChangeListener(propertyChangeListener);
    }

    @Override
    protected void uninstallListeners() {
        getComponent().removeFocusListener(focusListenerColorLine);
        getComponent().removePropertyChangeListener(propertyChangeListener);
        propertyChangeSupport.removePropertyChangeListener(propertyChangeListener);
        super.uninstallListeners();
    }

    @Override
    protected void paintBackground(Graphics g) {
        super.paintBackground(MaterialDrawingUtils.getAliasedGraphics(g));
    }

    /**
     * Paint line when the component is focused
     */
    @Override
    public void paintSafely(Graphics g) {
        super.paintSafely(g);

        paintLine(g);
    }

    protected void logicForChangeColorOnFocus(JComponent component, Color background, Color foreground){
        if(background == null || foreground == null){
            throw new IllegalArgumentException("Argument function null");
        }
        JPasswordField passField = (JPasswordField) component;
        passField.setForeground(foreground);
        passField.setSelectionColor(background);
        passField.setSelectedTextColor(foreground);
    }

    protected void installMyDefaults() {
        this.background = UIManager.getColor("PasswordField.background");
        this.activeBackground = UIManager.getColor("PasswordField.selectionBackground");
        this.activeForeground = UIManager.getColor("PasswordField.selectionForeground");
        this.inactiveBackground = UIManager.getColor("PasswordField.inactiveBackground");
        this.inactiveForeground = UIManager.getColor("PasswordField.inactiveForeground");
        colorLineInactive = UIManager.getColor("PasswordField[Line].inactiveColor");
        colorLineActive = UIManager.getColor("PasswordField[Line].activeColor");
        getComponent().setFont(UIManager.getFont("PasswordField.font"));
        colorLine = getComponent().hasFocus() && getComponent().isEditable() ? colorLineActive : colorLineInactive;
        getComponent().setSelectionColor(getComponent().hasFocus() && getComponent().isEnabled() ? activeBackground : inactiveBackground);
        getComponent().setSelectedTextColor(getComponent().hasFocus() && getComponent().isEnabled() ? activeForeground : inactiveForeground);
        getComponent().setForeground(getComponent().hasFocus() && getComponent().isEnabled() ? activeForeground : inactiveForeground);
        getComponent().setBorder(UIManager.getBorder("PasswordField.border"));
    }

    protected void logicForPropertyChange(Color newColor, boolean isForeground){
        if(newColor == null){
            throw new IllegalArgumentException("The input argument is null");
        }
        if (isForeground && !newColor.equals(activeForeground) && !newColor.equals(inactiveForeground)) {
            this.activeForeground = newColor;
            getComponent().repaint();
        }
        if (!isForeground && !newColor.equals(activeBackground) && !newColor.equals(inactiveBackground)) {
            this.activeBackground = newColor;
            getComponent().repaint();
        }
    }

    protected void changeColorOnFocus(boolean hasFocus) {
        JPasswordField c = (JPasswordField) getComponent();
        if(c == null){
            return;
        }
        if(hasFocus && (activeBackground != null) && (activeForeground != null)){
            logicForChangeColorOnFocus(c, activeBackground, activeForeground);
            //TODO create a new changePropriety
            paintLine(c.getGraphics());
        }

        if(!hasFocus && (inactiveBackground != null) && (inactiveForeground != null)){
            logicForChangeColorOnFocus(c, inactiveBackground, inactiveForeground);
            paintLine(c.getGraphics());
        }
        if(c.getGraphics() != null){
            c.paint(c.getGraphics());
        }
    }

    protected synchronized void firePropertyChange(String propertyName, Object oldValue, Object newValue){
        if((propertyName == null || propertyName.isEmpty()) || oldValue == null || newValue == null){
            throw new IllegalArgumentException("Some property null");
        }
        if (propertyChangeSupport == null || (oldValue != null && newValue != null && oldValue.equals(newValue))) {
            return;
        }
        if (propertyChangeSupport == null || oldValue == newValue) {
            return;
        }
        propertyChangeSupport.firePropertyChange(propertyName, oldValue, newValue);
    }

    protected void paintLine(Graphics graphics){
        if( graphics == null){
            return;
        }
        JPasswordField c = (JPasswordField) getComponent();

        if (drawLine) {
            int x = c.getInsets().left;
            int y = c.getInsets().top;
            int w = c.getWidth() - c.getInsets().left - c.getInsets().right;
            graphics.setColor(colorLine);

            graphics.fillRect(x, c.getHeight() - y, w, 1);
        }
    }

    protected class FocusListenerColorLine implements FocusListener{

        @Override
        public void focusGained(FocusEvent e) {
            firePropertyChange(PROPERTY_LINE_COLOR, colorLineInactive, colorLineActive);
            changeColorOnFocus(true);
        }

        @Override
        public void focusLost(FocusEvent e) {
            firePropertyChange(PROPERTY_LINE_COLOR, colorLineActive, colorLineInactive);
            changeColorOnFocus(false);
        }
    }

    protected class MaterialPropertyChangeListener implements PropertyChangeListener{

        @Override
        public void propertyChange(PropertyChangeEvent pce) {
            if(getComponent() == null){
                return;
            }
            if (pce.getPropertyName().equals(PROPERTY_SELECTION_COLOR)) {
                Color newColor = (Color) pce.getNewValue();
                logicForPropertyChange(newColor, false);
            }

            if (pce.getPropertyName().equals(PROPERTY_SELECTION_TEXT_COLOR)) {
                Color newColor = (Color) pce.getNewValue();
                logicForPropertyChange(newColor, true);
            }

            if (pce.getPropertyName().equals(PROPERTY_LINE_COLOR)) {
                Color newColor = (Color) pce.getNewValue();
                colorLine = newColor;
                getComponent().repaint();
            }

            if (pce.getPropertyName().equals("background")) {
                getComponent().repaint();
            }
        }
    }

    //Creating View
    @Override
    public View create(Element elem) {
        return new MaterialPasswordView(elem);
    }

    protected class MaterialPasswordView extends PasswordView {

        private MaterialPasswordView(Element elem) {
            super(elem);
        }

        // depreciated in Java 9 and above - replace method with float drawEchoCharacter(Graphics2D g, float x, float y, char c)
        @Override
        protected int drawEchoCharacter(Graphics g, int x, int y, char c) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            FontMetrics fm = g2.getFontMetrics();
            int r = fm.charWidth(c) - 2;

            g2.setPaint(getComponent().hasFocus() && getComponent().isEnabled() ? activeForeground : inactiveForeground);
            g2.fillOval(x + 1, y + 5 - fm.getAscent(), r, r);
            g2.dispose();

            return x + fm.charWidth(c);
        }
    }
}