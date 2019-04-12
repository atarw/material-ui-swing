package mdlaf.components.tabbedpane;

import mdlaf.utils.MaterialColors;
import mdlaf.utils.MaterialDrawingUtils;
import org.jdesktop.swingx.plaf.basic.BasicTaskPaneUI;

import javax.swing.JComponent;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicGraphicsUtils;
import javax.swing.plaf.basic.BasicTabbedPaneUI;
import javax.swing.plaf.metal.MetalTabbedPaneUI;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class MaterialTabbedPaneUI extends BasicTabbedPaneUI {

    public static ComponentUI createUI(JComponent c) {
        return new MaterialTabbedPaneUI();
    }

    private JComponent component;

    @Override
    public void installUI(JComponent c) {
        super.installUI(c);

        JTabbedPane tabbedPane = (JTabbedPane) c;
        tabbedPane.setOpaque(false);
        tabbedPane.setFont(UIManager.getFont("TabbedPane.font"));
        tabbedPane.setBackground(UIManager.getColor("TabbedPane.background"));
        tabbedPane.setForeground(UIManager.getColor("TabbedPane.foreground"));
        tabbedPane.setBorder(UIManager.getBorder("TabbedPane.border"));
        darkShadow = UIManager.getColor("TabbedPane.darkShadow");
        shadow = UIManager.getColor("TabbedPane.shadow");
        lightHighlight = UIManager.getColor("TabbedPane.highlight");

        component = tabbedPane;
    }

    @Override
    public void paint(Graphics g, JComponent c) {
        super.paint(MaterialDrawingUtils.getAliasedGraphics(g), c);
    }

    @Override
    protected void paintTabBackground(Graphics g, int tabPlacement, int tabIndex, int x, int y, int w, int h, boolean isSelected) {
        g.setColor(isSelected ? lightHighlight : tabPane.getBackground());
        g.fillRect(x, y, w, h);

    }

    @Override
    protected void paintTabBorder(Graphics g, int tabPlacement, int tabIndex, int x, int y, int w, int h, boolean isSelected) {
        //do nothing
    }

    @Override
    protected void paintFocusIndicator(Graphics g, int tabPlacement, Rectangle[] rects, int tabIndex, Rectangle iconRect, Rectangle textRect, boolean isSelected) {

        Rectangle tabRect = rects[tabIndex];
        if (tabPane.hasFocus() && isSelected) {
            int x, y, w, h;
            if (tabPlacement == LEFT) {
                x = tabRect.x + 3;
                y = tabRect.y + 3;
                w = tabRect.width - 5;
                h = tabRect.height - 6;
            } else if (tabPlacement == RIGHT) {
                x = tabRect.x + 2;
                y = tabRect.y + 3;
                w = tabRect.width - 5;
                h = tabRect.height - 6;
            } else if (tabPlacement == BOTTOM) {
                x = tabRect.x + 3;
                y = tabRect.y + 2;
                w = tabRect.width - 6;
                h = tabRect.height - 5;
            } else {
                x = tabRect.x + 3;
                y = tabRect.y + 3;
                w = tabRect.width - 6;
                h = tabRect.height - 5;
            }
            paintLine(g, x, y, w, h);

        }
    }

    @Override
    protected void paintTab(Graphics g, int tabPlacement, Rectangle[] rects, int tabIndex, Rectangle iconRect, Rectangle textRect) {
        // for some reason tabs aren't painted properly by paint()
        super.paintTab(MaterialDrawingUtils.getAliasedGraphics(g), tabPlacement, rects, tabIndex, iconRect, textRect);
        component.addMouseMotionListener(new MouseHoverTab(rects));
    }


    @Override
    protected void paintTabArea(Graphics g, int tabPlacement, int selectedIndex) {
        super.paintTabArea(MaterialDrawingUtils.getAliasedGraphics(g), tabPlacement, selectedIndex);
    }

    private void paintLine(Graphics graphics, int x, int y, int w, int h) {
        if (graphics == null) {
            throw new IllegalArgumentException("Argument null");
        }
        graphics.setColor(UIManager.getColor("TabbedPane[focus].colorLine"));
        graphics.fillRoundRect(x + 6, y + 19, w - 12, y - 3, 10, 10);
    }

    /**
     * Event listener for mouse hover
     */
    private class MouseHoverTab implements MouseMotionListener {

        private Rectangle[] rectangles;

        public MouseHoverTab(Rectangle[] rectangles) {
            this.rectangles = rectangles;
        }

        @Override
        public void mouseDragged(MouseEvent e) {
        }

        @Override
        public void mouseMoved(MouseEvent e) {
            JComponent mouseGenerate = (JComponent) e.getSource();
            if (!mouseGenerate.isEnabled()) {
                return;
            }
            Point point = e.getPoint();
            for (Rectangle r : rectangles) {
                if (r.contains(point)) {
                    mouseGenerate.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                    return;
                }
            }
            mouseGenerate.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
        }


    }

}
