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
package mdlaf.components.tabbedpane;

import mdlaf.utils.MaterialColors;
import mdlaf.utils.MaterialDrawingUtils;
import sun.swing.SwingUtilities2;

import javax.swing.*;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.UIResource;
import javax.swing.plaf.basic.BasicArrowButton;
import javax.swing.plaf.basic.BasicGraphicsUtils;
import javax.swing.plaf.basic.BasicTabbedPaneUI;
import javax.swing.plaf.metal.MetalTabbedPaneUI;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

/**
 * @author https://github.com/vincenzopalazzo
 */
public class MaterialTabbedPaneUI extends BasicTabbedPaneUI {

    public static ComponentUI createUI(JComponent c) {
        return new MaterialTabbedPaneUI();
    }

    protected JTabbedPane component;
    protected Color selectedForeground;
    protected Color disabledForeground;
    protected Color areaContentBackground;
    protected Color selectedAreaContentBackground;
    protected Color disableAreaContentBackground;
    protected Color foreground;
    protected int positionYLine;
    protected int positionXLine;
    protected int widthLine;
    protected int heightLine;
    protected int arcLine;
    protected int margin;
    protected boolean tabsOverlapBorder;

    @Override
    public void installUI(JComponent c) {
        super.installUI(c);

        JTabbedPane tabbedPane = (JTabbedPane) c;
        tabbedPane.setOpaque(false);
        tabbedPane.setFont(UIManager.getFont("TabbedPane.font"));
        tabbedPane.setBackground(UIManager.getColor("TabbedPane.background"));
        this.foreground = new ColorUIResource(UIManager.getColor("TabbedPane.foreground"));
        tabbedPane.setForeground(foreground);
        this.selectedForeground = new ColorUIResource(UIManager.getColor("TabbedPane.selectionForeground"));
        this.disabledForeground = UIManager.getColor("TabbedPane.disabledForeground");
        this.areaContentBackground = new ColorUIResource(UIManager.getColor("TabbedPane.contentAreaColor"));
        this.disableAreaContentBackground = new ColorUIResource(UIManager.getColor("TabbedPane.disableContentAreaColor"));
        this.selectedAreaContentBackground = new ColorUIResource(UIManager.getColor("TabbedPane[focus].colorLine"));
        tabbedPane.setBorder(UIManager.getBorder("TabbedPane.border"));
        darkShadow = UIManager.getColor("TabbedPane.darkShadow");
        shadow = UIManager.getColor("TabbedPane.shadow");
        lightHighlight = UIManager.getColor("TabbedPane.highlight");
        this.positionYLine = UIManager.getInt("TabbedPane.linePositionY");
        this.positionXLine = UIManager.getInt("TabbedPane.linePositionX");
        this.widthLine = UIManager.getInt("TabbedPane.lineWidth");
        this.heightLine = UIManager.getInt("TabbedPane.lineHeight");
        this.arcLine = UIManager.getInt("TabbedPane.lineArch");
        this.margin = UIManager.getInt("TabbedPane[focus].margin");
        this.tabsOverlapBorder = UIManager.getBoolean("TabbedPane.tabsOverlapBorder");
        this.component = tabbedPane;
    }

    @Override
    public void uninstallUI(JComponent c) {

        JTabbedPane tabbedPane = (JTabbedPane) c;
        tabbedPane.setFont(null);
        tabbedPane.setBackground(null);
        tabbedPane.setForeground(null);
        tabbedPane.setBorder(null);

        darkShadow = null;
        shadow = null;
        lightHighlight = null;

        component = null;

        super.uninstallDefaults();
        super.uninstallUI(c);
    }

    @Override
    protected void paintText(Graphics g, int tabPlacement, Font font, FontMetrics metrics, int tabIndex, String title, Rectangle textRect, boolean isSelected) {
        super.paintText(g, tabPlacement, font, metrics, tabIndex, title, textRect, isSelected);
        int mnemIndex = this.tabPane.getDisplayedMnemonicIndexAt(tabIndex);
        if(!tabPane.isEnabledAt(tabIndex)){
            g.setColor(disabledForeground);
            BasicGraphicsUtils.drawStringUnderlineCharAt(g, title, mnemIndex,
                        textRect.x,textRect.y +  metrics.getAscent());
        }
    }

    //
    // This method was inspired me for this style, special thank https://github.com/davidsommer/material-JTabbedPane
    // This method paint the selected line
    @Override
    protected void paintTabBackground(Graphics g, int tabPlacement, int tabIndex, int x, int y, int w, int h, boolean isSelected) {
        Graphics2D g2D = (Graphics2D) g;

        if (isSelected) {
            g2D.setColor(selectedAreaContentBackground);
            g2D.setPaint(selectedAreaContentBackground);
            tabPane.setForegroundAt(tabIndex, selectedForeground);

        } else {
            if (tabPane.isEnabled() && tabPane.isEnabledAt(tabIndex)) {
                g2D.setColor(this.component.getBackground());
                g2D.setPaint(this.component.getBackground());
            } else {
                g2D.setColor(disableAreaContentBackground);
                g2D.setPaint(disableAreaContentBackground);
            }
            if(tabPane.isEnabledAt(tabIndex)){
                tabPane.setForegroundAt(tabIndex, foreground);
            }else{
                tabPane.setForegroundAt(tabIndex, MaterialColors.AMBER_900);
            }
        }
    }

    @Override
    protected int calculateTabHeight(int tabPlacement, int tabIndex, int fontHeight) {
        if (tabPlacement == LEFT || tabPlacement == RIGHT) {
            return super.calculateTabHeight(tabPlacement, tabIndex, fontHeight);
        } else {
            return 18 + super.calculateTabHeight(tabPlacement, tabIndex, fontHeight);
        }
    }

    @Override
    protected void paintTab(Graphics g, int tabPlacement, Rectangle[] rects, int tabIndex, Rectangle iconRect, Rectangle textRect) {
        // for some reason tabs aren't painted properly by paint()
        super.paintTab(MaterialDrawingUtils.getAliasedGraphics(g), tabPlacement, rects, tabIndex, iconRect, textRect);
        //TODO viene aggiunto ogni volta. FIX IT
        if (UIManager.getBoolean("TabbedPane[MouseHover].enable")) {
            component.addMouseMotionListener(new MouseHoverTab(rects));
        }
    }

    @Override
    protected void paintTabBorder(Graphics g, int tabPlacement, int tabIndex, int x, int y, int w, int h, boolean isSelected) {
        // do nothing
    }

    @Override
    protected void paintFocusIndicator(Graphics g, int tabPlacement, Rectangle[] rects, int tabIndex, Rectangle iconRect, Rectangle textRect, boolean isSelected) {
        // do thing, the method paintBackground painted the focus indicator.
    }

    @Override //TODO debuggin this method, look the issue inside JMARS,
    protected void paintContentBorder(Graphics g, int tabPlacement, int selectedIndex) {
        //super.paintContentBorder(g, tabPlacement, selectedIndex);
        int width = tabPane.getWidth();
        int height = tabPane.getHeight();
        Insets insets = tabPane.getInsets();
        Insets tabAreaInsets = getTabAreaInsets(tabPlacement);

        int x = insets.left;
        int y = insets.top;
        int w = width - insets.right - insets.left;
        int h = height - insets.top - insets.bottom;

        switch (tabPlacement) {
            case LEFT:
                x += calculateTabAreaWidth(tabPlacement, runCount, maxTabWidth);
                if (tabsOverlapBorder) {
                    x -= tabAreaInsets.right;
                }
                w -= (x - insets.left);
                break;
            case RIGHT:
                w -= calculateTabAreaWidth(tabPlacement, runCount, maxTabWidth);
                if (tabsOverlapBorder) {
                    w += tabAreaInsets.left;
                }
                break;
            case BOTTOM:
                h -= calculateTabAreaHeight(tabPlacement, runCount, maxTabHeight);
                if (tabsOverlapBorder) {
                    h += tabAreaInsets.top;
                }
                break;
            case TOP:
            default:
                y += calculateTabAreaHeight(tabPlacement, runCount, maxTabHeight);
                if (tabsOverlapBorder) {
                    y -= tabAreaInsets.bottom;
                }
                h -= (y - insets.top);
        }

        if (tabPlacement == TOP) {
            this.paintContentBorderTopEdge(g, tabPlacement, selectedIndex, x, y, w, h);
        } else if (tabPlacement == BOTTOM) {
            this.paintContentBorderBottomEdge(g, tabPlacement, selectedIndex, x, y, w, h);
        } else if (tabPlacement == LEFT) {
            this.paintContentBorderLeftEdge(g, tabPlacement, selectedIndex, x, y, w, h);
        }else if (tabPlacement == RIGHT) {
            this.paintContentBorderRightEdge(g, tabPlacement, selectedIndex, x, y, w, h);
        }
    }

    @Override
    protected void paintContentBorderBottomEdge(Graphics g, int tabPlacement, int selectedIndex, int x, int y, int w, int h) {
        Rectangle selRect = selectedIndex < 0? null :
                getTabBounds(selectedIndex, calcRect);

        g.setColor(lightHighlight);

        // Draw unbroken line if tabs are not on BOTTOM, OR
        // selected tab is not in run adjacent to content, OR
        // selected tab is not visible (SCROLL_TAB_LAYOUT)
        //
        if (tabPlacement != BOTTOM || selectedIndex < 0 ||
                (selRect.y - 1 > h) ||
                (selRect.x < x || selRect.x > x + w)) {
            g.drawLine(x+1, y+h-2, x+w-2, y+h-2);
            g.setColor(darkShadow);
            g.drawLine(x, y+h-1, x+w-1, y+h-1);
        } else {
            // Break line to show visual connection to selected tab
            g.drawLine(x+1, y+h-2, selRect.x - 1, y+h-2);
            //g.setColor(darkShadow);
            //g.drawLine(x, y+h-1, selRect.x - 1, y+h-1);
            g.setColor(selectedAreaContentBackground);
            //g.drawLine(selRect.x - 1, y+h-2, selRect.x + selRect.width, y+h-2);
            g.fillRect(selRect.x, y+h-2, selRect.width, heightLine);
            if (selRect.x + selRect.width < x + w - 2) {
                g.setColor(lightHighlight);
                g.drawLine(selRect.x + selRect.width, y+h-2, x+w-2, y+h-2);
                //g.setColor(darkShadow);
                //g.drawLine(selRect.x + selRect.width, y+h-1, x+w-1, y+h-1);
            }
        }
    }

    @Override
    protected void paintContentBorderLeftEdge(Graphics g, int tabPlacement, int selectedIndex, int x, int y, int w, int h) {
        //super.paintContentBorderLeftEdge(g, tabPlacement, selectedIndex, x, y, w, h);

        Rectangle selRect = selectedIndex < 0? null : getTabBounds(selectedIndex, calcRect);

       // g.setColor(lightHighlight);

        // Draw unbroken line if tabs are not on LEFT, OR
        // selected tab is not in run adjacent to content, OR
        // selected tab is not visible (SCROLL_TAB_LAYOUT)
        //
        if (tabPlacement != LEFT || selectedIndex < 0 ||
                (selRect.x + selRect.width + 1 < x) ||
                (selRect.y < y || selRect.y > y + h)) {
            g.drawLine(x, y, x, y+h-2);
        } else {
            // Break line to show visual connection to selected tab
           /* g.drawLine(x, y, x, selRect.y - 1);
            if (selRect.y + selRect.height < y + h - 2) {
                g.drawLine(x, selRect.y + selRect.height,
                        x, y+h-2);
            }*/
            g.setColor(selectedAreaContentBackground);
            g.fillRect(selRect.x + margin , selRect.y, heightLine, selRect.height);
        }
    }

    @Override
    protected void paintContentBorderRightEdge(Graphics g, int tabPlacement, int selectedIndex, int x, int y, int w, int h) {
        //super.paintContentBorderRightEdge(g, tabPlacement, selectedIndex, x, y, w, h);
        Rectangle selRect = selectedIndex < 0? null : getTabBounds(selectedIndex, calcRect);

        //g.setColor(selectedAreaContentBackground);

        // Draw unbroken line if tabs are not on RIGHT, OR
        // selected tab is not in run adjacent to content, OR
        // selected tab is not visible (SCROLL_TAB_LAYOUT)
        //
        if (tabPlacement != RIGHT || selectedIndex < 0 ||
                (selRect.x - 1 > w) ||
                (selRect.y < y || selRect.y > y + h)) {
            g.drawLine(x+w-2, y+1, x+w-2, y+h-3);
            g.setColor(darkShadow);
            g.drawLine(x+w-1, y, x+w-1, y+h-1);
        } else {
            // Break line to show visual connection to selected tab
           // g.drawLine(x+w-2, y+1, x+w-2, selRect.y - 1);
           /* g.setColor(darkShadow);
            g.drawLine(x+w-1, y, x+w-1, selRect.y - 1);

            if (selRect.y + selRect.height < y + h - 2) {
                g.setColor(shadow);
                g.drawLine(x+w-2, selRect.y + selRect.height,
                        x+w-2, y+h-2);
                g.setColor(darkShadow);
                g.drawLine(x+w-1, selRect.y + selRect.height,
                        x+w-1, y+h-2);
            }*/
           g.setColor(selectedAreaContentBackground);
           g.fillRect((selRect.x + selRect.width - margin) - heightLine, selRect.y, heightLine, selRect.height);
        }
    }

    @Override
    protected void paintContentBorderTopEdge(Graphics g, int tabPlacement, int selectedIndex, int x, int y, int w, int h) {
        //super.paintContentBorderTopEdge(g, tabPlacement, selectedIndex, x, y, w, h);
        Rectangle selRect = selectedIndex < 0 ? null : getTabBounds(selectedIndex, calcRect);

        g.setColor(lightHighlight);

        // Draw unbroken line if tabs are not on TOP, OR
        // selected tab is not in run adjacent to content, OR
        // selected tab is not visible (SCROLL_TAB_LAYOUT)
        //
        if (tabPlacement != TOP || selectedIndex < 0 ||
                (selRect.y + selRect.height + 1 < y) ||
                (selRect.x < x || selRect.x > x + w)) {
            g.drawLine(x, y, x+w-2, y);
        } else {
            // Break line to show visual connection to selected tab
            g.drawLine(x, y, selRect.x - 1, y);
            if (selRect.x + selRect.width < x + w - 2) {
                g.drawLine(selRect.x + selRect.width, y,x+w-2, y);
            } /*else {
                //g.setColor(shadow);
                //g.drawLine(x+w-2, y, x+w-2, y);
                //g.setColor(selectedAreaContentBackground);
                //g.drawRect(selRect.x - 1, y+h-2, selRect.width, heightLine);
            }*/
            g.setColor(selectedAreaContentBackground);
            g.fillRect(selRect.x, y - heightLine + 1, selRect.width, heightLine);
        }
    }

    @Override
    protected void paintTabArea(Graphics g, int tabPlacement, int selectedIndex) {
        super.paintTabArea(g, tabPlacement, selectedIndex);
    }

    @Override
    public void paint(Graphics g, JComponent c) {
        super.paint(g, c);
    }

    //TODO remove this methods inside the version 1.2 of library.
    //The implementation inside this method was deprecated because cause
    //this issue: https://github.com/vincenzopalazzo/material-ui-swing/issues/109
    // I'm deprecating this implementation with an if-else and inside the version 1.2 of the library
    //the implementation of this method was removed such as the Implementation of MaterialTabbedPaneLayout
    //MaterialTabbedPaneLayout was declared deprecated.
    @Override
    protected LayoutManager createLayoutManager() {
        if (tabPane.getTabLayoutPolicy() == JTabbedPane.SCROLL_TAB_LAYOUT) {
            return super.createLayoutManager();
        }else{
            return super.createLayoutManager();
        }
        //return new MaterialTabbedPaneLayout();
    }

    @Override
    protected JButton createScrollButton(int direction) {
        return new MaterialArrowButton(direction);
    }

    @Deprecated //TODO remove this implementation inside the version 1.2 of the library.
    protected class MaterialTabbedPaneLayout extends BasicTabbedPaneUI.TabbedPaneLayout {

        protected int spacer; // should be non-negative
        protected int indent;

        public MaterialTabbedPaneLayout() {
            this.spacer = UIManager.getInt("TabbedPane.spacer");
            this.indent = UIManager.getInt("TabbedPane.indent");
        }

        @Override
        protected void calculateTabRects(int tabPlacement, int tabCount) {
            if (spacer < 0) {
                throw new IllegalArgumentException("The spacer inside the " +
                        this.getClass().getSimpleName() + " must be a not negative value");
            }

            super.calculateTabRects(tabPlacement, tabCount);
            if (tabPlacement == TOP || tabPlacement == BOTTOM) {
                for (int i = 0; i < rects.length; i++) {
                    rects[i].x += i * spacer + indent;
                }
            }
        }
    }

    protected class MouseHoverTab implements MouseMotionListener {

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
            if (mouseGenerate.getCursor().equals(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR))) {
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

    //TODO I will work on this
    protected class MaterialArrowButton extends BasicArrowButton implements UIResource,
            SwingConstants {

        public MaterialArrowButton(int direction, Color background, Color shadow, Color darkShadow, Color highlight) {
            super(direction, background, shadow, darkShadow, highlight);
        }

        public MaterialArrowButton(int direction) {
            super(direction);
        }

        @Override
        public void paint(Graphics g) {
            super.paint(g);
            g.setColor(MaterialColors.COSMO_MEDIUM_GRAY);
            this.setBackground(MaterialColors.GRAY_300);
        }

        @Override
        public void paintTriangle(Graphics g, int x, int y, int size, int direction, boolean isEnabled) {
            super.paintTriangle(g, x, y, size, direction, isEnabled);
            g.setColor(MaterialColors.COSMO_STRONG_GRAY);
        }
    }
}