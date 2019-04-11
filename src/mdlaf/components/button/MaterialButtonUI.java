package mdlaf.components.button;

import mdlaf.animation.MaterialUIMovement;
import mdlaf.utils.MaterialDrawingUtils;
import javax.swing.*;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.metal.MetalButtonUI;
import java.awt.*;

/**
 * @contributor https://github.com/vincenzopalazzo
 */
//TODO clean old code.
public class MaterialButtonUI extends MetalButtonUI {
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
            driveLine(g, b);
        }
    }

    @Override
    protected void paintText(Graphics g, JComponent c, Rectangle textRect, String text) {
        super.paintText(g, c, textRect, text);
    }

    @Override
    protected void paintFocus(Graphics g, AbstractButton b, Rectangle viewRect, Rectangle textRect, Rectangle iconRect) {
        //super.paintFocus(g, b, viewRect, textRect, iconRect);
        //changeColorOnUnfocus(b);
        driveLine(g, (JButton) b);

    }

    @Override
    public void update(Graphics g, JComponent c) {
        c.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        super.update(g, c);
    }

    @Deprecated
    private void changeColorOnUnfocus(JComponent component) {
        JButton button = (JButton) component;
        Color foregroundComponent = button.getForeground();
        Color backgroundComponent = button.getBackground();
        if (foregroundComponent.equals(this.focusableForeground) &&
                backgroundComponent.equals(this.focusableBackground)) {
            button.setBackground(this.background);
            button.setForeground(this.foreground);
        }
        if(!button.isDefaultButton()){
            // button.setBackground(background);
        }
    }

    @Override
    protected void paintText(Graphics g, AbstractButton b, Rectangle textRect, String text) {
        super.paintText(g, b, textRect, text);
    }

    private void driveLine(Graphics g, JButton b){
        g.setColor(UIManager.getColor("Button[focus].color"));
        g.drawLine(20 , (b.getHeight() / 2) + 10, b.getWidth() - 20, (b.getHeight() / 2) + 10);
    }


}