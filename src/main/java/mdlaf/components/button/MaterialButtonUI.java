package mdlaf.components.button;

import mdlaf.animation.MaterialUIMovement;
import mdlaf.utils.MaterialDrawingUtils;
import mdlaf.utils.MaterialManagerListener;

import javax.swing.*;
import javax.swing.event.ChangeListener;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicButtonListener;
import javax.swing.plaf.metal.MetalButtonUI;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 * @contributor https://github.com/vincenzopalazzo
 */
public class MaterialButtonUI extends MetalButtonUI {

    public static ComponentUI createUI(final JComponent c) {
        return new MaterialButtonUI();
    }

    private AbstractButton button;
    private Color foreground;
    private Color background;
    private Color disabledBackground;
    private Color disabledForeground;
    private Color defaultBackground;
    private Color defaultForeground;
    private Boolean isDefaultButton = null;
    private PropertyChangeListener enableButton = new EventEnableButton();

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
        button.setBackground(background);
        button.setForeground(foreground);
        button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        if (UIManager.getBoolean("Button.mouseHoverEnable")) {
            JButton b = (JButton) button;
            if (!b.isDefaultButton()) {
                button.addMouseListener(MaterialUIMovement.getMovement(button, UIManager.getColor("Button.mouseHoverColor")));
            }
        }
        button.setFocusable(UIManager.getBoolean("Button.focusable"));

        this.button = button;
    }

    @Override
    public void uninstallUI(JComponent c) {

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

        super.uninstallDefaults((AbstractButton) c);
        super.uninstallUI(c);
    }

    @Override
    public void paint(Graphics g, JComponent c) {
        JButton b = (JButton) c;
        if (b.isContentAreaFilled()) {
            paintBackground(g, b);
        }
        if (isDefaultButton == null && b.isEnabled()) {
            isDefaultButton = ((JButton) button).isDefaultButton();
            if (isDefaultButton) {
                if (UIManager.getBoolean("Button.mouseHoverEnable")) {
                    MaterialManagerListener.removeAllMaterialMouseListener(b);
                    b.addMouseListener(MaterialUIMovement.getMovement(b, UIManager.getColor("Button[Default].mouseHoverColor")));
                }
                paintStateButton(c, g);
            }
        }
        super.paint(g, c);
    }

    private void paintBackground(Graphics g, JComponent c) {
        g = MaterialDrawingUtils.getAliasedGraphics(g);
        Graphics2D graphics = (Graphics2D) g.create();
        g.setColor(c.getBackground());
        JButton b = (JButton) c;
        if (!UIManager.getBoolean("Button[border].toAll") && (button.getIcon() != null)) {
            g.fillRoundRect(0, 0, c.getWidth(), c.getHeight(), 7, 7);
        } else {
            g.fillRoundRect(0, 0, c.getWidth(), c.getHeight(), 7, 7);
            if (isDefaultButton != null && isDefaultButton) {
                g.setColor(UIManager.getColor("Button[Default].background"));
                if(UIManager.getBoolean("Button[Default].shadowEnable")){
                    paintShadow(MaterialDrawingUtils.getAliasedGraphics(g), button);
                }
                return;
            }

            if(UIManager.getBoolean("Button[border].enable")){
                paintBorderButton(graphics, b);
            }
        }

        paintStateButton(c, g, StateButton.DISABLE);

    }

    @Override
    protected void paintFocus(Graphics g, AbstractButton b, Rectangle viewRect, Rectangle textRect, Rectangle iconRect) {
        // driveLine(g, (JButton) b);
        paintFocusRing(g, (JButton) b);
        //paintShadow(MaterialDrawingUtils.getAliasedGraphics(g), button);
    }

    @Override
    public void update(Graphics g, JComponent c) {
        super.update(g, c);
        //c.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }

    @Override
    protected void paintButtonPressed(Graphics g, AbstractButton b) {
        g.fillRoundRect(0, 0, b.getWidth(), b.getHeight(), 7, 7);
    }

    @Override
    protected BasicButtonListener createButtonListener(AbstractButton b) {
        b.addPropertyChangeListener(enableButton);
        return super.createButtonListener(b);
    }

    @Override
    protected void uninstallListeners(AbstractButton b) {
        b.removePropertyChangeListener(enableButton);
        super.uninstallListeners(b);
    }

    protected void paintFocusRing(Graphics g, JButton b) {
        Stroke dashed = new BasicStroke(1, BasicStroke.CAP_SQUARE, BasicStroke.JOIN_MITER, 10.0f, new float[]{0f, 3f}, 10.0f);
        //Stroke dashed = new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{9}, 0);
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setStroke(dashed);
        if (isDefaultButton) {
            g2.setColor(UIManager.getColor("Button[Default][focus].color"));
        } else {
            g2.setColor(UIManager.getColor("Button[focus].color"));
        }

        g2.drawRoundRect(5, 5, b.getWidth() - 10, b.getHeight() - 10, 7, 7);

        g2.dispose();
    }

    protected void paintShadow(Graphics g, JComponent c) {
        int topOpacity = 80;
        int pixels = UIManager.getInt("Button[Default].shadowPixel");
        JButton b = (JButton) c;
        int valueRed = 255;
        int valueGreen = 255;
        int valueBlue = 255;
        for (int i = pixels; i >= 0; i--) {
            if(valueBlue > 70){
                valueRed -= 70;
                valueGreen -= 70;
                valueBlue -= 70;
            }else{
                valueBlue -= valueBlue;
                valueGreen -= valueGreen;
                valueRed -= valueRed;
            }

            Color result = new Color(valueRed, valueGreen, valueBlue, topOpacity);
            g.setColor(result);
            g.drawRoundRect(i, i, b.getWidth() - ((i * 2) + 1), b.getHeight() - ((i * 2) + 1), 7, 7);
        }

    }

    protected void paintBorderButton(Graphics2D graphics, JButton b) {
        graphics.setStroke(new BasicStroke(2f));

        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        int w = b.getWidth() - 1;
        int h = b.getHeight() - 1;
        int arc = 7;

        graphics.setColor(UIManager.getColor("Button[border].color"));
        graphics.drawRoundRect(0, 0, w, h, arc, arc);
    }

    protected void paintStateButton(JComponent component, Graphics graphics) {
        if (component == null || graphics == null) {
            throw new IllegalArgumentException("Input null");
        }
        JButton b = (JButton) component;
        if (b.isEnabled() && (isDefaultButton != null && isDefaultButton) && !b.isSelected()) {
            //MaterialManagerListener.removeAllMaterialMouseListener(b);
            //b.addMouseListener(MaterialUIMovement.getMovement(b, MaterialColors.LIGHT_BLUE_100));
            b.setBackground(defaultBackground);
            b.setForeground(defaultForeground);
            return;
        }
        if (!b.isEnabled()) {
            b.setBackground(disabledBackground);
            b.setForeground(disabledForeground);
            return;
        }
    }


    protected void paintStateButton(JComponent c, Graphics g, StateButton disable) {
        if (StateButton.DISABLE.equals(disable)) {
            if (!c.isEnabled()) {
                paintStateButton(c, g);
            }
        }
    }

    protected class EventEnableButton implements PropertyChangeListener {

        private String proprietyNameEnableEvent = "enabled";
        private String proprietyNameDefaultEvent = "defaultButton";

        @Override
        public void propertyChange(PropertyChangeEvent evt) {
            if (evt == null) {
                throw new IllegalArgumentException("The event null");
            }

            if (evt.getPropertyName().equals(proprietyNameEnableEvent) && (boolean) evt.getNewValue()) {
                button.setBackground(background);
                button.setForeground(foreground);
            } else if (evt.getPropertyName().equals(proprietyNameEnableEvent) && !(boolean) evt.getNewValue()) {
                background = button.getBackground();
                foreground = button.getForeground();
            } else if (evt.getPropertyName().equals(proprietyNameDefaultEvent) && (boolean) evt.getNewValue()) {
                background = button.getBackground();
                foreground = button.getForeground();
            }
        }
    }
}