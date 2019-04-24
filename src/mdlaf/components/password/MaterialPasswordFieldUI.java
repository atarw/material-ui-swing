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

import mdlaf.utils.MaterialColors;
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

/**
 * @contributor https://github.com/vincenzopalazzo
 */
public class MaterialPasswordFieldUI extends BasicPasswordFieldUI implements FocusListener, PropertyChangeListener {

    private boolean drawLine;
    private Color activeBackground;
    private Color activeForeground;
    private Color inactiveBackground;
    private Color inactiveForeground;

    public MaterialPasswordFieldUI() {
        this(true);
    }

    public MaterialPasswordFieldUI(boolean drawLine) {
        super();
        this.drawLine = drawLine;
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
        installMaterialDefault();
    }

    @Override
    protected void uninstallDefaults() {
        getComponent().setBorder(null);
        super.uninstallDefaults();
    }

    @Override
    protected void installListeners() {
        super.installListeners();
        getComponent().addFocusListener(this);
        getComponent().addPropertyChangeListener(this);
    }

    @Override
    protected void uninstallListeners() {
        getComponent().removeFocusListener(this);
        super.uninstallListeners();
    }

    @Override
    protected void paintBackground(Graphics g) {
        super.paintBackground(MaterialDrawingUtils.getAliasedGraphics(g));
    }

    @Override
    public void focusGained(FocusEvent e) {
        changeColorOnFocus(true);
    }

    @Override
    public void focusLost(FocusEvent e) {
        changeColorOnFocus(false);
    }

    @Override
    public void paintSafely(Graphics g) {
        JPasswordField c = (JPasswordField) getComponent();
        super.paintSafely(g);

        if (drawLine) {
            int x = c.getInsets().left;
            int y = c.getInsets().top;
            int w = c.getWidth() - c.getInsets().left - c.getInsets().right;
            g.setColor(c.getSelectionColor());

            g.fillRect(x, c.getHeight() - y, w, 1);
        }

    }

    @Override
    public void propertyChange(PropertyChangeEvent pce) {
        super.propertyChange(pce);

        if (pce.getPropertyName().equals("selectionColor")) {
            Color newColor = (Color) pce.getNewValue();
            logicForPropertyChange(newColor, false);
        }

        if (pce.getPropertyName().equals("selectedTextColor")) {
            Color newColor = (Color) pce.getNewValue();
            logicForPropertyChange(newColor, true);
        }
        if (pce.getPropertyName().equals("background")) {
            getComponent().repaint();
        }

    }

    @Override
    public View create(Element elem) {
        return new MaterialPasswordView(elem);
    }

    protected void installMaterialDefault() {
        this.activeBackground = UIManager.getColor("PasswordField.selectionBackground");
        this.activeForeground = UIManager.getColor("PasswordField.selectionForeground");
        this.inactiveBackground = UIManager.getColor("PasswordField.inactiveBackground");
        this.inactiveForeground = UIManager.getColor("PasswordField.inactiveForeground");
        getComponent().setFont(UIManager.getFont("PasswordField.font"));

        getComponent().setSelectionColor(getComponent().hasFocus() && getComponent().isEnabled() ? activeBackground : inactiveBackground);
        getComponent().setSelectedTextColor(getComponent().hasFocus() && getComponent().isEnabled() ? activeForeground : inactiveForeground);
        getComponent().setForeground(getComponent().hasFocus() && getComponent().isEnabled() ? activeForeground : inactiveForeground);
        getComponent().setBorder(UIManager.getBorder("PasswordField.border"));
    }

    protected void changeColorOnFocus(boolean hasFocus) {
        JPasswordField c = (JPasswordField) getComponent();
        if (c == null) {
            return;
        }
        if (hasFocus && (activeBackground != null) && (activeForeground != null)) {
            logicForChangeColorOnFocus(c, activeBackground, activeForeground);
        }
        if (!hasFocus && (inactiveBackground != null) && (inactiveForeground != null)) {
            logicForChangeColorOnFocus(c, inactiveBackground, inactiveForeground);
        }
        c.paint(c.getGraphics());
    }

    protected void logicForChangeColorOnFocus(JComponent component, Color background, Color foreground) {
        if (background == null || foreground == null) {
            throw new IllegalArgumentException("Argument function null");
        }
        JTextField textField = (JTextField) component;
        textField.setSelectionColor(background);
        textField.setForeground(foreground);
        textField.setSelectedTextColor(foreground);
    }

    protected void logicForPropertyChange(Color newColor, boolean isForeground){
        if(newColor == null){
            throw new IllegalArgumentException("The inpur argument is null");
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