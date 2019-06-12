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
public class MaterialButtonUI extends MetalButtonUI {

    public static ComponentUI createUI(final JComponent c) {
        return new MaterialButtonUI();
    }

    private Color foreground;
    private Color background;
    private AbstractButton button;

    @Override
    public void installUI(JComponent c) {
        super.installUI(c);

        AbstractButton button = (AbstractButton) c;
        button.setOpaque(UIManager.getBoolean("Button.opaque"));
        button.setBorder(UIManager.getBorder("Button.border"));
        foreground = UIManager.getColor("Button.foreground");
        background = UIManager.getColor("Button.background");
        button.setBackground(background);
        button.setForeground(foreground);
        button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        button.addMouseListener(MaterialUIMovement.getMovement(button, UIManager.getColor("Button.mouseHoverColor")));
        button.setFocusable(UIManager.getBoolean("Button.focusable"));

        this.button = button;
    }

    @Override
    public void paint(Graphics g, JComponent c) {
        JButton b = (JButton) c;
        if (b.isContentAreaFilled()) {
            paintBackground(g, b);
        }
        super.paint(g, c);
    }

    private void paintBackground(Graphics g, JComponent c) {
        Graphics2D graphics2D = (Graphics2D) g;
        graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g = graphics2D;
        g.setColor(c.getBackground());
        g.fillRoundRect(0, 0, c.getWidth(), c.getHeight(), 7, 7);

        paintStateButton(c, g);
    }

    @Override
    protected void paintFocus(Graphics g, AbstractButton b, Rectangle viewRect, Rectangle textRect, Rectangle iconRect) {
        paintFocusRing(g, (JButton) b);
    }

    @Override
    public void update(Graphics g, JComponent c) {
        super.update(g, c);
        //c.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }

    @Override
    protected void paintButtonPressed(Graphics g, AbstractButton b) {
        g.fillRoundRect(0, 0, b.getWidth(), b.getHeight(), 7, 7);
        background = b.getBackground();
        foreground = b.getForeground();
    }

    protected void driveLine(Graphics g, JButton b){
        g.setColor(UIManager.getColor("Button[focus].color"));
        g.drawLine(20 , (b.getHeight() / 2) + 10, b.getWidth() - 20, (b.getHeight() / 2) + 10);
    }

    protected void paintFocusRing(Graphics g, JButton b){
        Stroke dashed = new BasicStroke(1, BasicStroke.CAP_SQUARE, BasicStroke.JOIN_MITER, 10.0f, new float[] { 0f, 3f }, 10.0f);
        //Stroke dashed = new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{9}, 0);
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setStroke(dashed);
        g2.setColor(UIManager.getColor("Button[focus].color"));
        g2.drawRoundRect(5, 5, b.getWidth() - 10, b.getHeight() - 10, 7, 7);

        g2.dispose();
    }

    protected void paintStateButton(JComponent component, Graphics graphics) {
        if(component == null || graphics == null){
            throw new IllegalArgumentException("Input null");
        }
        JButton b = (JButton) component;
        JButton buttonOne = (JButton) button;
        if(buttonOne.isDefaultButton()){
           driveLine(graphics, b);
        }
    }
}