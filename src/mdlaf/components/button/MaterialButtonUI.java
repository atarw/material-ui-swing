package mdlaf.components.button;

import mdlaf.animation.MaterialUIMovement;
import mdlaf.utils.MaterialColors;
import mdlaf.utils.MaterialDrawingUtils;

import javax.swing.*;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicButtonUI;
import javax.swing.plaf.metal.MetalButtonUI;
import java.awt.*;

/**
 * @contributor https://github.com/vincenzopalazzo
 */

public class MaterialButtonUI extends BasicButtonUI {
    public static ComponentUI createUI(final JComponent c) {
        return new MaterialButtonUI();
    }

    private Color focusableBackground;
    private Color focusableForeground;
    private Color foreground;
    private Color background;

    @Override
    public void installUI(JComponent c) {
        super.installUI(c);

        AbstractButton button = (AbstractButton) c;
        button.setOpaque(UIManager.getBoolean("Button.opaque"));
        button.setBorder(UIManager.getBorder("Button.border"));
        focusableBackground = UIManager.getColor("Button[focus].background");
        focusableForeground = UIManager.getColor("Button[focus].foreground");
        foreground = UIManager.getColor("Button.foreground");
        background = UIManager.getColor("Button.background");
        button.setBackground(background);
        button.setForeground(foreground);
        button.setFont(UIManager.getFont("Button.font"));
        button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        button.addMouseListener(MaterialUIMovement.getMovement(button, UIManager.getColor("Button.mouseHoverColor")));
        button.setFocusable(UIManager.getBoolean("Button.focusable"));
    }

    @Override
    public void paint(Graphics g, JComponent c) {
        JButton b = (JButton) c;
        g = MaterialDrawingUtils.getAliasedGraphics(g);
        if (b.isContentAreaFilled()) {
            paintBackground(MaterialDrawingUtils.getAliasedGraphics(g), b);
        }

        super.paint(MaterialDrawingUtils.getAliasedGraphics(g), c);
    }

    private void changeColorOnUnfocus(JComponent component) {
        JButton button = (JButton) component;
        Color foregroundComponent = button.getForeground();
        Color backgroundComponent = button.getBackground();
        if (foregroundComponent.equals(this.focusableForeground) && backgroundComponent.equals(this.focusableBackground)) {
            button.setBackground(this.background);
            button.setForeground(this.foreground);
        }
        if(!button.isDefaultButton()){
           // button.setBackground(background);
        }
    }

    //Fix to #73 border were pixeled, fixde by https://github.com/vincenzopalazzo
    private void paintBackground(Graphics g, JComponent c) {
        //g.setColor(c.getBackground());
        //g.fillRoundRect(0, 0, c.getWidth(), c.getHeight(), 7, 7);
        Graphics2D graphics2D = (Graphics2D) g;
        graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g = graphics2D;
        g.setColor(c.getBackground());
        g.fillRoundRect(0, 0, c.getWidth(), c.getHeight(), 7, 7);
        JButton b = (JButton) c;
        if(b.isDefaultButton()){
           // b.setBackground(MaterialColors.GREEN_900);
        }
    }

    @Override
    protected void paintText(Graphics g, JComponent c, Rectangle textRect, String text) {
        super.paintText(g, c, textRect, text);
        changeColorOnUnfocus(c);
    }

    @Override
    protected void paintFocus(Graphics g, AbstractButton b, Rectangle viewRect, Rectangle textRect, Rectangle iconRect) {
        if(!((JButton)b).isFocusable()){
            return;
        }
        super.paintFocus(g, b, viewRect, textRect, iconRect);
        this.background = b.getBackground();
        this.foreground = b.getForeground();
        b.setForeground(this.focusableForeground);
        b.setBackground(this.focusableBackground);
    }

    @Override
    public void update(Graphics g, JComponent c) {
        super.update(g, c);
        c.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }
}