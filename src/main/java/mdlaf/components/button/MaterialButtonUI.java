/**
 * MIT License
 * <p>
 * Copyright (c) 2018-2020 atharva washimkar, Vincenzo Palazzo vincenzopalazzo1996@gmail.com
 * Copyright (c) 2021 Vincenzo Palazzo vincenzopalazzodev@gmail.com
 * <p>
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * <p>
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 * <p>
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package mdlaf.components.button;

import mdlaf.animation.MaterialMouseHover;
import mdlaf.animation.MaterialUIMovement;
import mdlaf.utils.MaterialDrawingUtils;

import javax.swing.*;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicButtonListener;
import javax.swing.plaf.basic.BasicButtonUI;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 * @author https://github.com/vincenzopalazzo
 */
public class MaterialButtonUI extends BasicButtonUI {

    public static ComponentUI createUI(final JComponent c) {
        return new MaterialButtonUI();
    }

    protected AbstractButton button;
    protected Boolean mouseHoverEnabled;
    protected Color foreground;
    protected Color background;
    protected Color disabledBackground;
    protected Color disabledForeground;
    protected Color defaultBackground;
    protected Color defaultForeground;
    protected Color colorMouseHoverDefaultButton;
    protected Color colorMouseHoverNormalButton;
    protected Color borderColor;
    protected Boolean defaultButton;
    protected Boolean borderEnabled;
    protected int arch = 7;
    protected PropertyChangeListener enableButton = new MaterialListenerButtonEvent();
    protected boolean buttonBorderToAll = false;
    protected boolean mouseHoverRunning = false;
    protected boolean buttonToolBarInit = false;
    protected MaterialMouseHover mouseHover;

    /**
     * Inside the installUI method are init only proprieties used inside this component
     * the background or foreground ara managed to BasicButtonUI, @see BasicButtonUI
     */
    @Override
    public void installUI(JComponent c) {
        super.installUI(c);

        AbstractButton button = (AbstractButton) c;
        button.setOpaque(UIManager.getBoolean("Button.opaque"));
        foreground = UIManager.getColor("Button.foreground");
        background = UIManager.getColor("Button.background");
        disabledBackground = UIManager.getColor("Button.disabledBackground");
        disabledForeground = UIManager.getColor("Button.disabledForeground");
        defaultBackground = UIManager.getColor("Button[Default].background");
        defaultForeground = UIManager.getColor("Button[Default].foreground");
        colorMouseHoverNormalButton = UIManager.getColor("Button.mouseHoverColor");
        colorMouseHoverDefaultButton = UIManager.getColor("Button[Default].mouseHoverColor");
        borderColor = UIManager.getColor("Button[border].color");
        borderEnabled = UIManager.getBoolean("Button[border].enable");
        buttonBorderToAll = UIManager.getBoolean("Button[border].toAll");
        if (mouseHoverEnabled == null) {
            mouseHoverEnabled = UIManager.getBoolean("Button.mouseHoverEnable");
        }
        this.arch = UIManager.getInt("Button.arc");
        if (mouseHoverEnabled) {
            JButton b = (JButton) button;
            if (!b.isDefaultButton()) {
                this.mouseHover = MaterialUIMovement.getMovement(button, colorMouseHoverNormalButton);
                button.addMouseListener(this.mouseHover);
            }
        }
        button.setFocusable(UIManager.getBoolean("Button.focusable"));
        this.button = button;
    }

    /**
     * Inside the future version 1.2 this method will contain all component that
     * work with listener, because this method is call before the installListener and I can
     * insert the control of the listener inside the native method.
     * TODO make the button installDefault change
     */
    @Override
    protected void installDefaults(AbstractButton b) {
        super.installDefaults(b);
    }

    @Override
    public void uninstallUI(JComponent c) {
        super.uninstallUI(c);

        AbstractButton button = (AbstractButton) c;
        foreground = null;
        background = null;
        disabledBackground = null;
        disabledForeground = null;
        defaultBackground = null;
        defaultForeground = null;
        buttonToolBarInit = false;
        button.setCursor(Cursor.getDefaultCursor());
    }

    @Override
    public void paint(Graphics g, JComponent c) {
        JButton b = (JButton) c;
        if (b.isContentAreaFilled()) {
            paintBackground(g, b);
        }
        if (defaultButton == null && b.isEnabled()) {
            defaultButton = ((JButton) button).isDefaultButton();
            if (defaultButton) {
                if (mouseHoverEnabled) {
                    b.removeMouseListener(this.mouseHover);
                    this.mouseHover = MaterialUIMovement.getMovement(b, colorMouseHoverDefaultButton);
                    b.addMouseListener(this.mouseHover);
                }
                b.setBackground(defaultBackground);
                b.setForeground(defaultForeground);
            }
        }
        if (borderEnabled != null && borderEnabled) {
            if (buttonBorderToAll && !b.isDefaultButton()) {
                paintBorderButton(g, b);
            } else if (b.getIcon() == null && !b.isDefaultButton()) {
                paintBorderButton(g, b);
            }
        }
        super.paint(g, c);
    }

    @Override
    protected void paintText(Graphics g, JComponent c, Rectangle textRect, String text) {
        AbstractButton b = (AbstractButton) c;
        ButtonModel model = b.getModel();

        if (model.isEnabled()) {
            MaterialDrawingUtils.drawString(c, g, text, textRect, b.getDisplayedMnemonicIndex(), getTextShiftOffset(), b.getForeground());
            return;
        }
        MaterialDrawingUtils.drawString(c, g, text, textRect, b.getDisplayedMnemonicIndex(), getTextShiftOffset(), disabledForeground);
    }

    /**
     * This method paint background, inside it will paint the border to buttons.
     * <p>
     * param g Graphics Object, with this object is possible paint the component JButton
     * param c Component Object, rappresent the button, if possible use this object or the propriety
     * called button inside this class
     */
    protected void paintBackground(Graphics g, JComponent c) {
        g = MaterialDrawingUtils.getAliasedGraphics(g);
        Graphics2D graphics = (Graphics2D) g.create();
        if (c.isEnabled()) {
            if (defaultButton != null && defaultButton) {
                graphics.setColor(defaultBackground);
            }
            graphics.setColor(c.getBackground());
        } else {
            graphics.setColor(disabledBackground);
        }
        graphics.fillRoundRect(0, 0, c.getWidth(), c.getHeight(), arch, arch);
        graphics.dispose();
        if (!buttonToolBarInit && this.isToolBarButton(c)) {
            borderEnabled = false;
            mouseHoverEnabled = UIManager.getBoolean("ToolBar[button].mouseHover");
            c.removeMouseListener(mouseHover);
            c.setBackground(UIManager.getColor("ToolBar.background"));
            if (mouseHoverEnabled) {
                //reset original color inside mouse color
                mouseHover = MaterialUIMovement.getMovement(c, colorMouseHoverNormalButton);
                c.addMouseListener(mouseHover);
            }
            this.buttonToolBarInit = true;
        }
    }

    @Override
    protected void paintFocus(Graphics g, AbstractButton b, Rectangle viewRect, Rectangle textRect, Rectangle iconRect) {
        if (!button.isEnabled()) return;
        paintFocusRing(g, (JButton) b);
    }

    @Override
    public void update(Graphics g, JComponent c) {
        super.update(g, c);
        paintBorderButton(g, c);
    }

    @Override
    protected void paintButtonPressed(Graphics g, AbstractButton b) {
        //if the mouse hover is enabled I can set the mouse hover color when the button is pressed
        if (mouseHoverEnabled && b.getModel().isPressed()) {
            if (b.isEnabled()) {
                if (this.isDefaultButton()) {
                    g.setColor(colorMouseHoverDefaultButton);
                } else {
                    g.setColor(colorMouseHoverNormalButton);
                }
            } else {
                g.setColor(disabledBackground);
            }
        } else {
            g.setColor(background);
        }
        g.fillRoundRect(0, 0, b.getWidth(), b.getHeight(), arch, arch);
        paintBorderButton(g, b);
    }


    @Override
    protected BasicButtonListener createButtonListener(AbstractButton b) {
        b.addPropertyChangeListener(enableButton);
        return super.createButtonListener(b);
    }

    @Override
    protected void installListeners(AbstractButton b) {
        super.installListeners(b);
    }

    @Override
    protected void uninstallListeners(AbstractButton b) {
        b.removePropertyChangeListener(enableButton);
        super.uninstallListeners(b);
        b.removeMouseListener(mouseHover);
    }

    protected void paintFocusRing(Graphics g, JButton b) {
        Stroke dashed = new BasicStroke(1, BasicStroke.CAP_SQUARE, BasicStroke.JOIN_MITER, 10.0f, new float[]{0f, 3f}, 10.0f);
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setStroke(dashed);
        if (defaultButton != null && defaultButton) {
            g2.setColor(UIManager.getColor("Button[Default][focus].color"));
        } else {
            g2.setColor(UIManager.getColor("Button[focus].color"));
        }
        g2.drawRoundRect(5, 5, b.getWidth() - 10, b.getHeight() - 10, arch, arch);
        g2.dispose();
    }

    protected void paintBorderButton(Graphics graphics, JComponent b) {
        if (!b.isEnabled() || !borderEnabled) {
            return;
        } else if (!buttonBorderToAll && ((JButton) b).getIcon() != null) {
            return;
        } else if (this.isDefaultButton()) {
            return;
        }
        Graphics2D graphics2D = (Graphics2D) graphics.create();
        graphics2D.setStroke(new BasicStroke(2f));

        graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        int w = b.getWidth() - 1;
        int h = b.getHeight() - 1;

        graphics2D.setColor(borderColor);
        graphics2D.drawRoundRect(0, 0, w, h, arch + 2, arch + 2);
        graphics2D.dispose();
    }

    /**
     * This method is used inside the TimerUI to set a new MouseHover color.
     * <p>
     * For example: if you set a personal color on the mouseHove effect, you need to create a new mouseHover event on this component
     * with a code as MaterialUIMovement.getMovement(COMPONENT, COLOR);
     * The event creates to previous system call need
     * to refresh the mouseHover color in this class to have the correct effect when the button is pressed
     * <p>
     * This should be remove e override the logic with a listener, but for the moment is implemented only this solution.
     */
    public void setColorMouseHoverDefaultButton(Color colorMouseHoverDefaultButton) {
        this.colorMouseHoverDefaultButton = colorMouseHoverDefaultButton;
    }

    /**
     * This method is used inside the TimerUI to set a new MouseHover color.
     * <p>
     * For example: if you set a personal color on the mouseHove effect, you need to create a new mouseHover event on this component
     * with a code as MaterialUIMovement.getMovement(COMPONENT, COLOR);
     * The event creates to previous system call need
     * to refresh the mouseHover color in this class to have the correct effect when the button is pressed
     * <p>
     * This should be remove e override the logic with a listener, but for the moment is implemented only this solution.
     */
    public void setColorMouseHoverNormalButton(Color colorMouseHoverNormalButton) {
        this.colorMouseHoverNormalButton = colorMouseHoverNormalButton;
    }

    public Boolean isDefaultButton() {
        return defaultButton != null && defaultButton;
    }

    protected boolean isToolBarButton(Component component) {
        Container container = component.getParent();
        if (container instanceof JToolBar) {
            return true;
        } else if (container != null) {
            return this.isToolBarButton(container);
        }
        return false;
    }

    /**
     * This method was used inside the MaterialUITimer for reset the color at the particular event
     *
     * @deprecated This method will be removed inside the version 1.2, it is a old method used inside the Timer to restore the default value
     */
    @Deprecated
    public void setBackground(Color color) {
        if (color == null) {
            throw new IllegalArgumentException("Color null");
        }
        if (this.defaultButton != null && this.defaultButton) {
            this.defaultBackground = color;
        } else {
            this.background = color;
        }
        button.repaint();
    }

    /**
     * This method was used inside the MaterialUITimer for reset the color at the particular event
     *
     * @deprecated This method will be removed inside the version 1.2, it is a old method used inside the Timer to restore the default value
     */
    @Deprecated
    public Color getForeground() {
        return foreground;
    }

    /**
     * This method was used inside the MaterialUITimer for reset the color at the particular event
     *
     * @deprecated This method will be removed inside the version 1.2, it is a old method used inside the Timer to restore the default value
     */
    @Deprecated
    public void setForeground(Color foreground) {
        this.foreground = foreground;
    }

    /**
     * This method was used inside the MaterialUITimer for reset the color at the particular event
     *
     * @deprecated This method will be removed inside the version 1.2, it is a old method used inside the Timer to restore the default value
     */
    @Deprecated
    public Color getBackground() {
        return background;
    }

    /**
     * This method was used inside the MaterialUITimer for reset the color at the particular event
     *
     * @deprecated This method will be removed inside the version 1.2, it is a old method used inside the Timer to restore the default value
     */
    @Deprecated
    public Color getDisabledBackground() {
        return disabledBackground;
    }

    /**
     * This method was used inside the MaterialUITimer for reset the color at the particular event
     *
     * @deprecated This method will be removed inside the version 1.2, it is a old method used inside the Timer to restore the default value
     */
    @Deprecated
    public void setDisabledBackground(Color disabledBackground) {
        this.disabledBackground = disabledBackground;
    }

    /**
     * This method was used inside the MaterialUITimer for reset the color at the particular event
     *
     * @deprecated This method will be removed inside the version 1.2, it is a old method used inside the Timer to restore the default value
     */
    @Deprecated
    public Color getDisabledForeground() {
        return disabledForeground;
    }

    /**
     * This method was used inside the MaterialUITimer for reset the color at the particular event
     *
     * @deprecated This method will be removed inside the version 1.2, it is a old method used inside the Timer to restore the default value
     */
    @Deprecated
    public void setDisabledForeground(Color disabledForeground) {
        this.disabledForeground = disabledForeground;
    }

    /**
     * This method was used inside the MaterialUITimer for reset the color at the particular event
     *
     * @deprecated This method will be removed inside the version 1.2, it is a old method used inside the Timer to restore the default value
     */
    @Deprecated
    public Color getDefaultBackground() {
        return defaultBackground;
    }

    /**
     * This method was used inside the MaterialUITimer for reset the color at the particular event
     *
     * @deprecated This method will be removed inside the version 1.2, it is a old method used inside the Timer to restore the default value
     */
    @Deprecated
    public void setDefaultBackground(Color defaultBackground) {
        this.defaultBackground = defaultBackground;
    }

    /**
     * This method was used inside the MaterialUITimer for reset the color at the particular event
     *
     * @deprecated This method will be removed inside the version 1.2, it is a old method used inside the Timer to restore the default value
     */
    @Deprecated
    public Color getDefaultForeground() {
        return defaultForeground;
    }

    /**
     * This method was used inside the MaterialUITimer for reset the color at the particular event
     *
     * @deprecated This method will be removed inside the version 1.2, it is a old method used inside the Timer to restore the default value
     */
    @Deprecated
    public void setDefaultForeground(Color defaultForeground) {
        this.defaultForeground = defaultForeground;
    }

    /**
     * This method was used inside the MaterialUITimer for reset the color at the particular event
     *
     * @deprecated This method will be removed inside the version 1.2, it is a old method used inside the Timer to restore the default value
     */
    @Deprecated
    public Color getColorMouseHoverDefaultButton() {
        return colorMouseHoverDefaultButton;
    }

    /**
     * This method was used inside the MaterialUITimer for reset the color at the particular event
     *
     * @deprecated This method will be removed inside the version 1.2, it is a old method used inside the Timer to restore the default value
     */
    @Deprecated
    public Color getColorMouseHoverNormalButton() {
        return colorMouseHoverNormalButton;
    }

    /**
     * This class was implement receive the change propriety from button and change the default value inside this component,
     * as, background, foreground.
     * It make the possibility to support the custom color set with component.setBackground
     *
     * @author https://github.com/vincenzopalazzo
     */
    protected class MaterialListenerButtonEvent implements PropertyChangeListener {

        private static final String BACKGROUND_EVENT = "background";
        private static final String FOREGROUND_EVENT = "foreground";
        private static final String ENABLED_EVENT = "enabled";

        @Override
        public void propertyChange(PropertyChangeEvent evt) {
            if (evt == null) {
                throw new IllegalArgumentException("The event null");
            }

            if (evt.getPropertyName().equals(ENABLED_EVENT) && (boolean) evt.getNewValue()) {
                //When on the JButton does call the method setEnable(true)
                if (defaultButton != null && defaultButton) {
                    button.setBackground(defaultBackground);
                    button.setForeground(defaultForeground);
                } else {
                    button.setBackground(background);
                    button.setForeground(foreground);
                }
            }
            else if (evt.getPropertyName().equals(BACKGROUND_EVENT) && button.isEnabled()) {
                //When on the JButton call the method setBackground
                if (mouseHover != null && !mouseHover.isRunning()) {
                    background = (Color) evt.getNewValue();
                }
            } else if (evt.getPropertyName().equals(FOREGROUND_EVENT) && button.isEnabled()) {
                //When on the JButton call the method setForeground
                if (mouseHover != null && !mouseHover.isRunning()) {
                    foreground = (Color) evt.getNewValue();
                }
            }
        }
    }

}