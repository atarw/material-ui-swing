/*
 * MIT License
 *
 * Copyright (c) 2019 Vincent Palazzo vincenzopalazzodev@gmail.com
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package mdlaf.components.tabbedpane;

import mdlaf.utils.MaterialDrawingUtils;

import javax.swing.*;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicTabbedPaneUI;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

/**
 * @author  https://github.com/vincenzopalazzo
 */
public class MaterialTabbedPaneUI extends BasicTabbedPaneUI {

    public static ComponentUI createUI(JComponent c) {
        return new MaterialTabbedPaneUI();
    }

    protected JTabbedPane component;
    protected ColorUIResource selectedForeground;
    protected ColorUIResource areaContentBackground;
    protected ColorUIResource selectedAreaContentBackground;
    protected ColorUIResource disableAreaContentBackground;
    protected ColorUIResource foreground;
    protected int positionYLine;
    protected int positionXLine;
    protected int widthLine;
    protected int heightLine;
    protected int arcLine;

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
        component = tabbedPane;
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
    /**
     * This method was inspired me for this style, special thank https://github.com/davidsommer/material-JTabbedPane
     */
    protected void paintTabBackground(Graphics g, int tabPlacement, int tabIndex, int x, int y, int w, int h, boolean isSelected) {
        Graphics2D g2D = (Graphics2D) g;
        int xp[];
        int yp[];
        Polygon shape = null;
        Rectangle shapeRect = null;
        //Todo remove the shape and used the shapeRect
        if(tabPlacement == TOP){
            xp = new int[]{x, x, x, x + w, x + w, x + w, x + w, x};
            yp = new int[]{(y + positionYLine + heightLine), y + positionYLine, y + positionYLine, y + positionYLine, y + positionYLine, y + positionYLine, y + positionYLine + heightLine, y + positionYLine + heightLine};
            shape = new Polygon(xp, yp, xp.length);
        }else if(tabPlacement == BOTTOM){
            y += 20;
            xp = new int[]{x, x, x, x + w, x + w, x + w, x + w, x};
            yp = new int[]{(y + heightLine), y, y, y, y, y, y + heightLine, y + heightLine};
            shape = new Polygon(xp, yp, xp.length);
        }else if(tabPlacement == LEFT){
            //xp = new int[]{0, 0, 0, h, h, h, h, 0};
            //yp = new int[]{(y + heightLine), y, y, y, y, y, y + heightLine, y + heightLine};
            shapeRect = new Rectangle(x + heightLine - 2, y + (heightLine), heightLine, w / (tabPane.getTabCount()));
        }else{
            //super.paintTabBackground(g, tabPlacement, tabIndex, x, y, w, h, isSelected);
            shapeRect = new Rectangle(x + w - heightLine, y + (heightLine), heightLine, w / (tabPane.getTabCount()));
        }

        if (isSelected) {
            g2D.setColor(selectedAreaContentBackground);
            g2D.setPaint(selectedAreaContentBackground);
            tabPane.setForegroundAt(tabIndex, selectedForeground);

        } else {
            if (tabPane.isEnabled() && tabPane.isEnabledAt(tabIndex)) {
                g2D.setColor(areaContentBackground);
                g2D.setPaint(areaContentBackground);
            } else {
                g2D.setColor(disableAreaContentBackground);
                g2D.setPaint(disableAreaContentBackground);
            }
            tabPane.setForegroundAt(tabIndex, foreground);
        }
        if(shape != null){
            g2D.fill(shape);
        }else if (shapeRect != null){
            g2D.fill(shapeRect);
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
        if (UIManager.getBoolean("TabbedPane[MouseHover].enable")) {
            component.addMouseMotionListener(new MouseHoverTab(rects));
        }
    }

    @Override
    protected void paintTabBorder(Graphics g, int tabPlacement, int tabIndex, int x, int y, int w, int h, boolean isSelected) { }

    @Override
    protected void paintFocusIndicator(Graphics g, int tabPlacement, Rectangle[] rects, int tabIndex, Rectangle iconRect, Rectangle textRect, boolean isSelected) { }

    @Override
    protected void paintContentBorder(Graphics graphics, int i, int i1) { }


    @Override
    protected LayoutManager createLayoutManager() {
        return new MaterialTabbedPaneLayout();
    }

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
}