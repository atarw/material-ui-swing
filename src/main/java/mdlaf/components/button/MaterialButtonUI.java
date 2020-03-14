/**
 * MIT License
 * <p>
 * Copyright (c) 2018-2020 atharva washimkar, Vincenzo Palazzo vincenzopalazzo1996@gmail.com
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

import mdlaf.animation.MaterialUIMovement;
import mdlaf.utils.MaterialDrawingUtils;
import mdlaf.utils.MaterialManagerListener;

import javax.swing.*;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicButtonListener;
import javax.swing.plaf.basic.BasicButtonUI;
import javax.swing.plaf.basic.BasicGraphicsUtils;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
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
    //protected Color disabledDefaultBackground;
    //protected Color disabledDefaultForeground;
    protected Color borderColor;
    protected Boolean defaultButton;
    protected Boolean borderEnabled;
    protected int arch = 7;
    protected PropertyChangeListener enableButton = new MaterialListenerButtonEvent();
    //protected boolean paintedDisabled = false;
    protected boolean buttonBorderToAll = false;
    protected boolean mouseHoverRunning = false;

    protected MaterialButtonMouseListener mouseListener = new MaterialButtonMouseListener();

    @Override
    public void installUI(JComponent c) {
        super.installUI(c);

        AbstractButton button = (AbstractButton) c;
        button.setOpaque(UIManager.getBoolean("Button.opaque"));
        button.setBorder(UIManager.getBorder("Button.border"));
        foreground = UIManager.getColor("Button.foreground");
        background = UIManager.getColor("Button.background");
        disabledBackground = UIManager.getColor("Button.disabledBackground");
        disabledForeground = UIManager.getColor("Button.disabledForeground");
        defaultBackground = UIManager.getColor("Button[Default].background");
        defaultForeground = UIManager.getColor("Button[Default].foreground");
        colorMouseHoverNormalButton = UIManager.getColor("Button.mouseHoverColor");
        colorMouseHoverDefaultButton = UIManager.getColor("Button[Default].mouseHoverColor");
        //disabledDefaultBackground = UIManager.getColor("Button[Default].disabledBackground");
        //disabledDefaultForeground = UIManager.getColor("Button[Default].disabledForeground");
        borderColor = UIManager.getColor("Button[border].color");
        borderEnabled = UIManager.getBoolean("Button[border].enable");
        buttonBorderToAll = UIManager.getBoolean("Button[border].toAll");
        if (mouseHoverEnabled == null) {
            mouseHoverEnabled = UIManager.getBoolean("Button.mouseHoverEnable");
        }
        button.setBackground(background);
        button.setForeground(foreground);
        this.arch = UIManager.getInt("Button.arc");
        //button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        if (mouseHoverEnabled) {
            JButton b = (JButton) button;
            if (!b.isDefaultButton()) {
                button.addMouseListener(MaterialUIMovement.getMovement(button, colorMouseHoverNormalButton));
            }
        }
        button.setFocusable(UIManager.getBoolean("Button.focusable"));
        this.button = button;
    }

    @Override
    public void uninstallUI(JComponent c) {
        super.uninstallUI(c);

        AbstractButton button = (AbstractButton) c;
        button.setBorder(null);
        foreground = null;
        background = null;
        disabledBackground = null;
        disabledForeground = null;
        defaultBackground = null;
        defaultForeground = null;
        button.setBackground(null);
        button.setForeground(null);
        button.setCursor(null);

        MaterialManagerListener.removeAllMaterialMouseListener(button);
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
                    MaterialManagerListener.removeAllMaterialMouseListener(b);
                    b.addMouseListener(MaterialUIMovement.getMovement(b, colorMouseHoverDefaultButton));
                }
                //paintBackground(g, c);
                b.setBackground(defaultBackground);
                b.setForeground(defaultForeground);
            }
        }
        super.paint(g, c);
    }

    @Override
    protected void paintText(Graphics g, JComponent c, Rectangle textRect, String text) {
        AbstractButton b = (AbstractButton) c;
        ButtonModel model = b.getModel();
        FontMetrics fm = g.getFontMetrics(c.getFont());
        int mnemonicIndex = b.getDisplayedMnemonicIndex();

        if (model.isEnabled()) {
            g.setColor(b.getForeground());
            BasicGraphicsUtils.drawStringUnderlineCharAt(g, text, mnemonicIndex,
                    textRect.x + getTextShiftOffset(),
                    textRect.y + fm.getAscent() + getTextShiftOffset());
        } else {
            g.setColor(disabledForeground);
            BasicGraphicsUtils.drawStringUnderlineCharAt(g, text, mnemonicIndex,
                    textRect.x + getTextShiftOffset(),
                    textRect.y + fm.getAscent() + getTextShiftOffset());
        }
    }

    /**
     * This method paint background, inside it will paint the border to buttons.
     *
     * @param g Graphics Object, with this object is possible paint the component JButton
     * @param c Component Object, rappresent the button, if possible use this object or the propriety
     *          called button inside this class
     */
    //TODO tested this
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
        JButton b = (JButton) c;
        if (borderEnabled != null && borderEnabled) {
            if (buttonBorderToAll && !b.isDefaultButton()) {
                paintBorderButton(graphics, b);
            } else if (b.getIcon() == null && !b.isDefaultButton()) {
                paintBorderButton(graphics, b);
            }
        }
        //paintStateButton(c, g);
        //paintStateButton(c, g, StateButton.DISABLE);
    }

    @Override
    protected void paintFocus(Graphics g, AbstractButton b, Rectangle viewRect, Rectangle textRect, Rectangle iconRect) {
        // driveLine(g, (JButton) b);
        paintFocusRing(g, (JButton) b);
        paintBorderButton(g, b);
        //paintShadow(MaterialDrawingUtils.getAliasedGraphics(g), button);
    }

    @Override
    public void update(Graphics g, JComponent c) {
        super.update(g, c);
        //c.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }

    @Override
    protected void paintButtonPressed(Graphics g, AbstractButton b) {
        //if the mouse hover is enabled I can set the mouse hover color when the button is pressed
        if(mouseHoverEnabled){
            if (b.isEnabled()) {
                if (defaultButton) {
                    g.setColor(colorMouseHoverDefaultButton);
                } else {
                    g.setColor(colorMouseHoverNormalButton);
                }
            } else {
                g.setColor(disabledBackground);
            }
        }else {
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
        b.addMouseListener(mouseListener);
    }

    @Override
    protected void uninstallListeners(AbstractButton b) {
        b.removePropertyChangeListener(enableButton);
        super.uninstallListeners(b);
        b.removeMouseListener(mouseListener);
    }

    protected void paintFocusRing(Graphics g, JButton b) {
        Stroke dashed = new BasicStroke(1, BasicStroke.CAP_SQUARE, BasicStroke.JOIN_MITER, 10.0f, new float[]{0f, 3f}, 10.0f);
        //Stroke dashed = new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{9}, 0);
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
        }else if(!buttonBorderToAll && ((JButton)b).getIcon() != null){
            return;
        }else if(this.isDefaultButton()){
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
     * This method is used inside the MaterialUITimer for reset the color at the particular event
     *
     * @param color
     */
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

    //Getter and setter propriety
    public Color getForeground() {
        return foreground;
    }

    public void setForeground(Color foreground) {
        this.foreground = foreground;
    }

    public Color getBackground() {
        return background;
    }

    public Color getDisabledBackground() {
        return disabledBackground;
    }

    public void setDisabledBackground(Color disabledBackground) {
        this.disabledBackground = disabledBackground;
    }

    public Color getDisabledForeground() {
        return disabledForeground;
    }

    public void setDisabledForeground(Color disabledForeground) {
        this.disabledForeground = disabledForeground;
    }

    public Color getDefaultBackground() {
        return defaultBackground;
    }

    public void setDefaultBackground(Color defaultBackground) {
        this.defaultBackground = defaultBackground;
    }

    public Color getDefaultForeground() {
        return defaultForeground;
    }

    public void setDefaultForeground(Color defaultForeground) {
        this.defaultForeground = defaultForeground;
    }

    public Color getColorMouseHoverDefaultButton() {
        return colorMouseHoverDefaultButton;
    }

    public void setColorMouseHoverDefaultButton(Color colorMouseHoverDefaultButton) {
        this.colorMouseHoverDefaultButton = colorMouseHoverDefaultButton;
    }

    public Color getColorMouseHoverNormalButton() {
        return colorMouseHoverNormalButton;
    }

    public void setColorMouseHoverNormalButton(Color colorMouseHoverNormalButton) {
        this.colorMouseHoverNormalButton = colorMouseHoverNormalButton;
    }

    public Boolean isDefaultButton() {
        return defaultButton != null && defaultButton;
    }


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
                if(defaultButton != null && defaultButton){
                    button.setBackground(defaultBackground);
                    button.setForeground(defaultForeground);
                }else{
                    button.setBackground(background);
                    button.setForeground(foreground);
                }
            }
            /* TODO but on mouse hover fixed but I open another bug, now doesn't is possible personalize the background
            There is an bug inside this, so the mouse hover called setBackground of the component
            and this change the background color.
            I do remove this bug but I need to restore this code because isn't possible work with the personal
            color on the button.
            */
            else if(evt.getPropertyName().equals(BACKGROUND_EVENT) && !mouseHoverRunning){
                //When on the JButton call the method setBackground
                background = (Color) evt.getNewValue();
            }else if(evt.getPropertyName().equals(FOREGROUND_EVENT) && !mouseHoverRunning){
                //When on the JButton call the method setForeground
                foreground = (Color) evt.getNewValue();
            }

            /*else if (evt.getPropertyName().equals(proprietyNameEnableEvent) && !(boolean) evt.getNewValue()) {
                background = button.getBackground();
                foreground = button.getForeground();
            }*/
        }
    }

    /**
     * This Internal class is used to send feedback to mouse hover inside the JButton
     * With this solution I can try to fix the issues on mouse hover t JButton.
     */
    protected class MaterialButtonMouseListener implements MouseListener, MouseMotionListener{

        @Override
        public void mouseClicked(MouseEvent mouseEvent) {
            //do nothing
        }

        @Override
        public void mousePressed(MouseEvent mouseEvent) {
            //do nothing
        }

        @Override
        public void mouseReleased(MouseEvent mouseEvent) {
            //do nothing
        }

        @Override
        public void mouseEntered(MouseEvent mouseEvent) {
            mouseHoverRunning = true;
        }

        @Override
        public void mouseExited(MouseEvent mouseEvent) {
            mouseHoverRunning = false;
        }

        @Override
        public void mouseDragged(MouseEvent mouseEvent) {
            //do nothing
        }

        @Override
        public void mouseMoved(MouseEvent mouseEvent) {
            //do nothing
        }
    }
}