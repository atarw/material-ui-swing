package mdlaf.components.tabbedpane;

import mdlaf.utils.MaterialDrawingUtils;
import sun.swing.SwingUtilities2;
import javax.swing.*;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicTabbedPaneUI;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class MaterialTabbedPaneUI extends BasicTabbedPaneUI {

    public static ComponentUI createUI(JComponent c) {
        return new MaterialTabbedPaneUI();
    }

    private JTabbedPane component;

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
        //super.paintFocusIndicator(g, tabPlacement, rects, tabIndex, iconRect, textRect, isSelected);
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

       /* Rectangle rectangleSelected = rects[tabIndex];
        int forCenterPoint = (int) ((component.getWidth() / 2.5));
        Point position = new Point(rectangleSelected.x + forCenterPoint, rectangleSelected.y);
        rectangleSelected.setLocation(position);
        int selectedIndex = tabPane.getSelectedIndex();
        boolean isSelected = selectedIndex == tabIndex;

        if (tabPane.isOpaque()) {
            paintTabBackground(g, tabPlacement, tabIndex, rectangleSelected.x, rectangleSelected.y,
                    rectangleSelected.width, rectangleSelected.height, isSelected);
        }

        paintTabBorder(g, tabPlacement, tabIndex, rectangleSelected.x, rectangleSelected.y,
                rectangleSelected.width, rectangleSelected.height, isSelected);

        String title = tabPane.getTitleAt(tabIndex);
        Font font = tabPane.getFont();
        FontMetrics metrics = SwingUtilities2.getFontMetrics(tabPane, g, font);
        Icon icon = getIconForTab(tabIndex);

        layoutLabel(tabPlacement, metrics, tabIndex, title, icon, rectangleSelected, iconRect, textRect, isSelected);

        if (tabPane.getTabComponentAt(tabIndex) == null) {
            String clippedTitle = title;

            paintText(g, tabPlacement, font, metrics,
                    tabIndex, clippedTitle, textRect, isSelected);

            paintIcon(g, tabPlacement, tabIndex, icon, iconRect, isSelected);
        }
        paintFocusIndicator(g, tabPlacement, rects, tabIndex,
                iconRect, textRect, isSelected);

*/
        component.addMouseMotionListener(new MouseHoverTab(rects));
    }


    @Override
    protected void paintTabArea(Graphics g, int tabPlacement, int selectedIndex) {
        super.paintTabArea(MaterialDrawingUtils.getAliasedGraphics(g), tabPlacement, selectedIndex);
    }

    @Override
    protected void paintText(Graphics g, int tabPlacement, Font font, FontMetrics metrics, int tabIndex, String title, Rectangle textRect, boolean isSelected) {
        super.paintText(g, tabPlacement, font, metrics, tabIndex, title, textRect, isSelected);

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
