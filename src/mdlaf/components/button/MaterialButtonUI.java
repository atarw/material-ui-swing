package mdlaf.components.button;

import mdlaf.animation.MaterialUIMovement;
import mdlaf.utils.MaterialBorders;
import mdlaf.utils.MaterialColors;
import mdlaf.utils.MaterialDrawingUtils;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicButtonUI;
import java.awt.*;
import java.awt.geom.Rectangle2D;

/**
 * @contributor https://github.com/vincenzopalazzo
 */
public class MaterialButtonUI extends BasicButtonUI {

    public static ComponentUI createUI(final JComponent c) {
        return new MaterialButtonUI();
    }

    @Override
    public void installUI(JComponent c) {
        super.installUI(c);

        AbstractButton button = (AbstractButton) c;
        button.setOpaque(UIManager.getBoolean("Button.opaque"));
        button.setBorder(UIManager.getBorder("Button.border"));
        button.setBackground(UIManager.getColor("Button.background"));
        button.setForeground(UIManager.getColor("Button.foreground"));
        button.setFont(UIManager.getFont("Button.font"));
        button.setFocusable(UIManager.getBoolean("Button.focusable"));
        button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        button.addMouseListener(MaterialUIMovement.getMovement(button, UIManager.getColor("Button.mouseHoverColor")));
    }

    @Override
    public void paint(Graphics g, JComponent c) {
        AbstractButton b = (AbstractButton) c;
        g = MaterialDrawingUtils.getAliasedGraphics(g);
        if (b.isContentAreaFilled()) {
            paintBackground(MaterialDrawingUtils.getAliasedGraphics(g), b);
        }
        super.paint(MaterialDrawingUtils.getAliasedGraphics(g), c);
    }

    private void paintBackground(Graphics g, JComponent c) {
        //g.setColor(c.getBackground());
        //g.fillRoundRect(0, 0, c.getWidth(), c.getHeight(), 7, 7);
        Graphics2D graphics2D = (Graphics2D) g;
        graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g = graphics2D;
        g.setColor(c.getBackground());
        g.fillRoundRect(0, 0, c.getWidth(), c.getHeight(), 7, 7);
    }

    @Override
    protected void paintText(Graphics g, JComponent c, Rectangle textRect, String text) {
        if (((JButton) c).isDefaultButton()) {
            // g.fillRoundRect(0, 0, c.getWidth(), c.getHeight(), 7, 7);
            int width = c.getWidth();
            int height = c.getHeight();
            Graphics2D graphics = (Graphics2D) g;

            graphics.setColor(c.getBackground());
            graphics.fillRoundRect(0, 0, width - 2, height - 2, 7, 7);//paint background
            graphics.setColor(MaterialColors.BLACK);
            graphics.drawRoundRect(0, 0, width - 2, height - 2, 7, 7);//paint border
            graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        }
        super.paintText(g, c, textRect, text);
    }

    @Override
    protected void paintFocus(Graphics g, AbstractButton b, Rectangle viewRect, Rectangle textRect, Rectangle iconRect) {
        super.paintFocus(g, b, viewRect, textRect, iconRect);
    }



    @Override
    protected void paintButtonPressed(Graphics g, AbstractButton b) {
        super.paintButtonPressed(g, b);
    }

    @Override
    public void update(Graphics g, JComponent c) {
        super.update(g, c);
        c.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }


}