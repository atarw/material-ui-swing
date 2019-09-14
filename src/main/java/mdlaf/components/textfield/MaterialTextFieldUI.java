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
package mdlaf.components.textfield;

import mdlaf.utils.MaterialDrawingUtils;
import javax.swing.*;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicTextFieldUI;
import javax.swing.plaf.metal.MetalTextFieldUI;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 * @author https://github.com/vincenzopalazzo
 * @author https://github.com/atarw
 */
public class MaterialTextFieldUI extends MetalTextFieldUI {

    protected static final String PROPERTY_LINE_COLOR = "lineColor";
    protected static final String PROPERTY_SELECTION_COLOR = "selectionColor";
    protected static final String PROPERTY_SELECTION_TEXT_COLOR = "selectedTextColor";

    protected boolean drawLine;
    protected JTextField textField;
    protected Color background;
    protected Color foreground;
    protected Color activeBackground;
    protected Color activeForeground;
    protected Color inactiveBackground;
    protected Color inactiveForeground;
    protected Color colorLineInactive;
    protected Color colorLineActive;
    protected Color colorLine;
    protected FocusListener focusListenerColorLine;
    protected PropertyChangeListener propertyChangeListener;
    protected PropertyChangeSupport propertyChangeSupport;

    public MaterialTextFieldUI() {
        this(true);
    }

    public MaterialTextFieldUI(boolean drawLine) {
        super();
        this.drawLine = drawLine;
        this.focusListenerColorLine = new FocusListenerColorLine();
        this.propertyChangeListener = new MaterialPropertyChangeListener();
        this.propertyChangeSupport = new PropertyChangeSupport(this);
    }

    public static ComponentUI createUI(JComponent c) {
        return new MaterialTextFieldUI();
    }

    @Override
    public void installUI(JComponent c) {
        super.installUI(c);
        this.textField = (JTextField) c;
    }

    @Override
    protected void installDefaults() {
        super.installDefaults();
        installMyDefaults();
    }

    @Override
    public void uninstallUI(JComponent c) {
        super.uninstallUI(c);

        c.setFont (null);
        c.setBackground (null);
        c.setForeground (null);
        c.setBorder (null);
        c.setCursor(null);

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

    @Override
    public void paintSafely(Graphics g) {
        super.paintSafely(g);

        paintLine(g);
    }

    protected void logicForChangeColorOnFocus(JComponent component, Color background, Color foreground){
        if(background == null || foreground == null){
            throw new IllegalArgumentException("Argument function null");
        }
        JTextField textField = (JTextField) component;
        if(!this.activeForeground.equals(foreground)){ //TODO this comment resolve the issue but I don't not if it introduce some bug
            textField.setSelectedTextColor(inactiveForeground);
        }else{
            textField.setSelectedTextColor(foreground);
        }
        textField.setSelectionColor(background);
    }

    protected void installMyDefaults() {
        this.background = UIManager.getColor("TextField.background");
        this.foreground = UIManager.getColor("TextField.foreground");
        this.activeBackground = UIManager.getColor("TextField.selectionBackground");
        this.activeForeground = UIManager.getColor("TextField.selectionForeground");
        this.inactiveBackground = UIManager.getColor("TextField.inactiveBackground");
        this.inactiveForeground = UIManager.getColor("TextField.inactiveForeground");
        colorLineInactive = UIManager.getColor("TextField[Line].inactiveColor");
        colorLineActive = UIManager.getColor("TextField[Line].activeColor");
        getComponent().setFont(UIManager.getFont("TextField.font"));
        colorLine = getComponent().hasFocus() && getComponent().isEditable() ? colorLineActive : colorLineInactive;
        getComponent().setSelectionColor(getComponent().hasFocus() && getComponent().isEnabled() ? activeBackground : inactiveBackground);
        getComponent().setSelectedTextColor(getComponent().hasFocus() && getComponent().isEnabled() ? activeForeground : inactiveForeground);
        getComponent().setForeground(getComponent().hasFocus() && getComponent().isEnabled() ? activeForeground : inactiveForeground);
        getComponent().setBorder(UIManager.getBorder("TextField.border"));
    }

    protected void logicForPropertyChange(Color newColor, boolean isForeground){
        if(newColor == null){
           return;
        }
        if (isForeground && (!newColor.equals(activeForeground) && !newColor.equals(inactiveForeground))) {
            this.activeForeground = newColor;
            getComponent().repaint();
        }
        if (!isForeground && !newColor.equals(activeBackground) && !newColor.equals(inactiveBackground)) {
            this.activeBackground = newColor;
            getComponent().repaint();
        }
    }

    protected void changeColorOnFocus(boolean hasFocus) {
        JTextField c = (JTextField) getComponent();
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
        //TODO refectoring this code
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
        JTextField c = (JTextField) getComponent();

        if(drawLine){
            int x = c.getInsets().left;
            int y = c.getInsets().top;
            int w = c.getWidth() - c.getInsets().left - c.getInsets().right;
            graphics.setColor(colorLine);

            graphics.fillRect(x, c.getHeight() - y, w, 1);
        }
    }

    public class FocusListenerColorLine implements FocusListener{

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

    public class MaterialPropertyChangeListener implements PropertyChangeListener{

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

}