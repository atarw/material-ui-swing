package mdlaf.components.textfield;

import mdlaf.utils.MaterialDrawingUtils;
import mdlaf.utils.MaterialFonts;

import javax.swing.*;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicTextFieldUI;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 * @contributor https://github.com/vincenzopalazzo
 */
public class MaterialTextFieldUI extends BasicTextFieldUI implements FocusListener, PropertyChangeListener {

    private boolean drawLine;
    private Color activeBackground;
    private Color activeForeground;
    private Color inactiveBackground;
    private Color inactiveForeground;

    public MaterialTextFieldUI() {
        this(true);
    }

    public MaterialTextFieldUI(boolean drawLine) {
        super();
        this.drawLine = drawLine;
    }

    public static ComponentUI createUI(JComponent c) {
        return new MaterialTextFieldUI();
    }

    @Override
    /**
     * This method not override because non paint correct in the JFileChooser
     * @fixed by https://github.com/vincenzopalazzo
     */
    public void installUI(JComponent c) {
        super.installUI(c);

    }

    @Override
    protected void installDefaults() {
        super.installDefaults();
        installMyDefaults();
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

    private void installMyDefaults() {
        this.activeBackground = UIManager.getColor("TextField.selectionBackground");
        this.activeForeground = UIManager.getColor("TextField.selectionForeground");
        this.inactiveBackground = UIManager.getColor("TextField.inactiveBackground");
        this.inactiveForeground = UIManager.getColor("TextField.inactiveForeground");
        getComponent().setFont(UIManager.getFont("TextField.font"));

        getComponent().setSelectionColor(getComponent().hasFocus() && getComponent().isEnabled() ? activeBackground : inactiveBackground);
        getComponent().setSelectedTextColor(getComponent().hasFocus() && getComponent().isEnabled() ? activeForeground : inactiveForeground);
        getComponent().setForeground(getComponent().hasFocus() && getComponent().isEnabled() ? activeForeground : inactiveForeground);
        getComponent().setBorder(UIManager.getBorder("TextField.border"));
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

    private void changeColorOnFocus(boolean hasFocus) {
        JTextField c = (JTextField) getComponent();
        if(c == null){
            return;
        }
        if(hasFocus && (activeBackground != null) && (activeForeground != null)){
            /*c.setSelectionColor(activeBackground);
            c.setForeground(activeForeground);
            c.setSelectedTextColor(activeForeground);
            */
            logicForChangeColorOnFocus(c, activeBackground, activeForeground);
        }

        if(!hasFocus && (inactiveBackground != null) && (inactiveForeground != null)){
            /*c.setSelectionColor(inactiveBackground);
            c.setForeground(inactiveForeground);
            c.setSelectedTextColor(inactiveForeground);*/
            logicForChangeColorOnFocus(c, inactiveBackground, inactiveForeground);
        }
        if(c.getGraphics() != null){
            c.paint(c.getGraphics());
        }
    }
    @Override
    /**
     *This method drive a line button on JTextField
     * @fixed by https://github.com/vincenzopalazzo
     */
    public void paintSafely(Graphics g) {
        JTextField c = (JTextField) getComponent();
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
        if(getComponent() == null){
            return;
        }
        if (pce.getPropertyName().equals("selectionColor")) {
            Color newColor = (Color) pce.getNewValue();
            /*if (!newColor.equals(activeBackground) && !newColor.equals(inactiveBackground)) {
                this.activeBackground = newColor;
                getComponent().repaint();
            }*/
            logicForPropertyChange(newColor);
        }

        if (pce.getPropertyName().equals("selectedTextColor")) {
            Color newColor = (Color) pce.getNewValue();
            /*if (!newColor.equals(activeForeground) && !newColor.equals(inactiveForeground)) {
                this.activeForeground = newColor;
                getComponent().repaint();
            }*/
            logicForPropertyChange(newColor);
        }
        if (pce.getPropertyName().equals("background")) {
            getComponent().repaint();
        }
    }

    /**
     * Methods for recicle code, the code duplicate are bad
     * @param component
     * @param background
     * @param foreground
     */
    protected void logicForChangeColorOnFocus(JComponent component, Color background, Color foreground){
        if(background == null || foreground == null){
            throw new IllegalArgumentException("Argument function null");
        }
        JTextField textField = (JTextField) component;
        textField.setSelectionColor(background);
        textField.setForeground(foreground);
        textField.setSelectedTextColor(foreground);
    }

    protected void logicForPropertyChange(Color newColor){
        if(newColor == null){
            throw new IllegalArgumentException("The inpur argument is null");
        }
        if (!newColor.equals(activeForeground) && !newColor.equals(inactiveForeground)) {
            this.activeForeground = newColor;
            getComponent().repaint();
        }
    }

}