/*
 * Copyright (c) 1997, 2015, Oracle and/or its affiliates. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation.  Oracle designates this
 * particular file as subject to the "Classpath" exception as provided
 * by Oracle in the LICENSE file that accompanied this code.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 *
 * You should have received a copy of the GNU General Public License version
 * 2 along with this work; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * Please contact Oracle, 500 Oracle Parkway, Redwood Shores, CA 94065 USA
 * or visit www.oracle.com if you need additional information or have any
 * questions.
 */
package mdlaf.components.rootpane;

import mdlaf.components.titlepane.MaterialTitlePaneUI;

import javax.swing.*;
import javax.swing.event.MouseInputListener;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicRootPaneUI;
import java.awt.*;
import java.awt.event.*;
import java.beans.PropertyChangeEvent;

/**
 * @author Terry Kellerman
 * // This code is inside the Open JDK
 * @author https://github.com/vincenzopalazzo
 */
public class MaterialRootPaneUI extends BasicRootPaneUI {

    protected static final String[] borderKeys = new String[]{
            null, "RootPane.frameBorder", "RootPane.plainDialogBorder",
            "RootPane.informationDialogBorder",
            "RootPane.errorDialogBorder", "RootPane.colorChooserDialogBorder",
            "RootPane.fileChooserDialogBorder", "RootPane.questionDialogBorder",
            "RootPane.warningDialogBorder"
    };

    public static ComponentUI createUI(JComponent c) {
        return new MaterialRootPaneUI();
    }

    protected Cursor myLastCursor = Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR);

    protected Window window;

    protected JComponent titlePane;

    protected MaterialHandler materialHandler;

    protected LayoutManager layoutManager;

    protected LayoutManager savedOldLayout;

    protected JRootPane root;

    private boolean dragging = false;

    private boolean resizing = false;

    /**
     * With this dimension is set the absolute space dragging
     * What is the space inside the display/displays to move the component
     */
    protected Dimension dimensionDevices;

    /**
     * With this dimension is defined the dimension of dragging
     * component
     */
    protected Dimension parentBounds;

    public MaterialRootPaneUI() {
        super();
        int devideWithd = 0;
        int deviceHeight = 0;
        GraphicsDevice graphicDevices[] = GraphicsEnvironment.getLocalGraphicsEnvironment().getScreenDevices();
        for (GraphicsDevice graphicsDevice : graphicDevices) {
            devideWithd += graphicsDevice.getDisplayMode().getWidth();
            deviceHeight += graphicsDevice.getDisplayMode().getHeight();
        }
        this.dimensionDevices = new Dimension(devideWithd, deviceHeight);
        this.parentBounds = this.dimensionDevices;
    }

    private void cancelResize(Window w) {
        if (resizing) {
            if (materialHandler != null) {
                materialHandler.finishMouseReleased(w);
            }
        }
    }

    protected void setupDragMode(Window f) {
    }

    public void beginDraggingFrame(Window f) {
        setupDragMode(f);
    }

    public void dragFrame(Window w, int newX, int newY) {
        setBoundsForFrame(w, newX, newY, w.getWidth(), w.getHeight());
    }

    public void endDraggingFrame(Window f) {
    }

    public void beginResizingFrame(Window f, int direction) {
        setupDragMode(f);
    }

    public void resizeFrame(Window f, int newX, int newY, int newWidth, int newHeight) {
        setBoundsForFrame(f, newX, newY, newWidth, newHeight);
    }

    public void endResizingFrame(Window f) {}

    public void setBoundsForFrame(Window f, int newX, int newY, int newWidth, int newHeight) {
        f.setBounds(newX, newY, newWidth, newHeight);
        // we must validate the hierarchy to not break the hw/lw mixing
        f.revalidate();
    }

    @Override
    protected void installListeners(JRootPane root) {
        super.installListeners(root);
    }

    @Override
    protected void uninstallListeners(JRootPane root) {
        super.uninstallListeners(root);
    }

    public void installUI(JComponent c) {
        super.installUI(c);
        root = (JRootPane) c;
        root.setBackground(UIManager.getColor("RootPane.background"));
        int style = root.getWindowDecorationStyle();
        if (style != JRootPane.NONE) {
            installClientDecorations(root);
        }
    }

    public void uninstallUI(JComponent c) {
        super.uninstallUI(c);
        uninstallClientDecorations(root);

        layoutManager = null;
        materialHandler = null;
        root = null;
    }

    protected void uninstallBorder(JRootPane root) {
        LookAndFeel.uninstallBorder(root);
    }


    protected void installWindowListeners(JRootPane root, Component parent) {
        if (parent instanceof Window) {
            window = (Window) parent;
        } else {
            window = SwingUtilities.getWindowAncestor(parent);
        }
        if (window != null) {
            if (materialHandler == null) {
                materialHandler = createWindowHandler(root);
            }

            window.addMouseListener(materialHandler);
            window.addMouseMotionListener(materialHandler);

            window.addWindowFocusListener(materialHandler);
            window.addWindowListener(materialHandler);
        }
    }

    protected void uninstallWindowListeners(JRootPane root) {
        if (window != null) {
            window.removeMouseListener(materialHandler);
            window.removeMouseMotionListener(materialHandler);
            window.removeWindowFocusListener(materialHandler);
            window.removeWindowListener(materialHandler);
        }
    }

    protected void installLayout(JRootPane root) {
        if (layoutManager == null) {
            layoutManager = createLayoutManager();
        }
        savedOldLayout = root.getLayout();
        root.setLayout(layoutManager);
    }

    protected void uninstallLayout(JRootPane root) {
        if (savedOldLayout != null) {
            root.setLayout(savedOldLayout);
            savedOldLayout = null;
        }
    }

    protected void installClientDecorations(JRootPane root) {
        installBorder(root);

        JComponent titlePane = createTitlePane(root);

        setTitlePane(root, titlePane);
        installWindowListeners(root, root.getParent());
        installLayout(root);
        if (window != null) {
            root.revalidate();
            root.repaint();
        }
    }

    protected void uninstallClientDecorations(JRootPane root) {
        uninstallBorder(root);
        uninstallWindowListeners(root);
        setTitlePane(root, null);
        uninstallLayout(root);
        int style = root.getWindowDecorationStyle();
        if (style == JRootPane.NONE) {
            root.repaint();
            root.revalidate();
        }
        if (window != null) {
            window.setCursor(Cursor.getPredefinedCursor
                    (Cursor.DEFAULT_CURSOR));
        }
        window = null;
    }

    protected JComponent createTitlePane(JRootPane root) {
        return new MaterialTitlePaneUI(root);
    }

    protected MaterialHandler createWindowHandler(JRootPane root) {
        return new MaterialRootPaneUI.MaterialHandler();
    }

    protected LayoutManager createLayoutManager() {
        return new MaterialLayout();
    }

    protected void setTitlePane(JRootPane root, JComponent titlePane) {
        JLayeredPane layeredPane = root.getLayeredPane();
        JComponent oldTitlePane = getTitlePane();

        if (oldTitlePane != null) {
            oldTitlePane.setVisible(false);
            layeredPane.remove(oldTitlePane);
        }
        if (titlePane != null) {
            layeredPane.add(titlePane, JLayeredPane.FRAME_CONTENT_LAYER);
            titlePane.setVisible(true);
        }
        this.titlePane = titlePane;
    }

    protected JComponent getTitlePane() {
        return titlePane;
    }

    protected JRootPane getRootPane() {
        return root;
    }

    public void propertyChange(PropertyChangeEvent e) {
        super.propertyChange(e);

        String propertyName = e.getPropertyName();
        if (propertyName == null) {
            return;
        }

        if (propertyName.equals("windowDecorationStyle")) {
            JRootPane root = (JRootPane) e.getSource();
            int style = root.getWindowDecorationStyle();

            // This is potentially more than needs to be done,
            // but it rarely happens and makes the install/uninstall process
            // simpler. MetalTitlePane also assumes it will be recreated if
            // the decoration style changes.
            uninstallClientDecorations(root);
            if (style != JRootPane.NONE) {
                installClientDecorations(root);
            }
        } else if (propertyName.equals("ancestor")) {
            uninstallWindowListeners(root);
            if (((JRootPane) e.getSource()).getWindowDecorationStyle() !=
                    JRootPane.NONE) {
                installWindowListeners(root, root.getParent());
            }
        }
    }

    protected static class MaterialLayout implements LayoutManager2 {

        public Dimension preferredLayoutSize(Container parent) {

            Dimension cpd, mbd, tpd;
            int cpWidth = 0;
            int cpHeight = 0;
            int mbWidth = 0;
            int mbHeight = 0;
            int tpWidth = 0;
            int tpHeight = 0;
            Insets i = parent.getInsets();
            JRootPane root = (JRootPane) parent;

            if (root.getContentPane() != null) {
                cpd = root.getContentPane().getPreferredSize();
            } else {
                cpd = root.getSize();
            }
            if (cpd != null) {
                cpWidth = cpd.width;
                cpHeight = cpd.height;
            }

            if (root.getJMenuBar() != null) {
                mbd = root.getJMenuBar().getPreferredSize();
                if (mbd != null) {
                    mbWidth = mbd.width;
                    mbHeight = mbd.height;
                }
            }

            if (root.getWindowDecorationStyle() != JRootPane.NONE &&
                    (root.getUI() instanceof MaterialRootPaneUI)) {
                JComponent titlePane = ((MaterialRootPaneUI) root.getUI()).getTitlePane();
                if (titlePane != null) {
                    tpd = titlePane.getPreferredSize();
                    if (tpd != null) {
                        tpWidth = tpd.width;
                        tpHeight = tpd.height;
                    }
                }
            }

            return new Dimension(Math.max(Math.max(cpWidth, mbWidth), tpWidth) + i.left + i.right,
                    cpHeight + mbHeight + tpWidth + i.top + i.bottom);
        }

        public Dimension minimumLayoutSize(Container parent) {
            Dimension cpd, mbd, tpd;
            int cpWidth = 0;
            int cpHeight = 0;
            int mbWidth = 0;
            int mbHeight = 0;
            int tpWidth = 0;
            int tpHeight = 0;
            Insets i = parent.getInsets();
            JRootPane root = (JRootPane) parent;

            if (root.getContentPane() != null) {
                cpd = root.getContentPane().getMinimumSize();
            } else {
                cpd = root.getSize();
            }
            if (cpd != null) {
                cpWidth = cpd.width;
                cpHeight = cpd.height;
            }

            if (root.getJMenuBar() != null) {
                mbd = root.getJMenuBar().getMinimumSize();
                if (mbd != null) {
                    mbWidth = mbd.width;
                    mbHeight = mbd.height;
                }
            }
            if (root.getWindowDecorationStyle() != JRootPane.NONE &&
                    (root.getUI() instanceof MaterialRootPaneUI)) {
                JComponent titlePane = ((MaterialRootPaneUI) root.getUI()).getTitlePane();
                if (titlePane != null) {
                    tpd = titlePane.getMinimumSize();
                    if (tpd != null) {
                        tpWidth = tpd.width;
                        tpHeight = tpd.height;
                    }
                }
            }

            return new Dimension(Math.max(Math.max(cpWidth, mbWidth), tpWidth) + i.left + i.right,
                    cpHeight + mbHeight + tpWidth + i.top + i.bottom);
        }

        public Dimension maximumLayoutSize(Container target) {
            Dimension cpd, mbd, tpd;
            int cpWidth = Integer.MAX_VALUE;
            int cpHeight = Integer.MAX_VALUE;
            int mbWidth = Integer.MAX_VALUE;
            int mbHeight = Integer.MAX_VALUE;
            int tpWidth = Integer.MAX_VALUE;
            int tpHeight = Integer.MAX_VALUE;
            Insets i = target.getInsets();
            JRootPane root = (JRootPane) target;

            if (root.getContentPane() != null) {
                cpd = root.getContentPane().getMaximumSize();
                if (cpd != null) {
                    cpWidth = cpd.width;
                    cpHeight = cpd.height;
                }
            }

            if (root.getJMenuBar() != null) {
                mbd = root.getJMenuBar().getMaximumSize();
                if (mbd != null) {
                    mbWidth = mbd.width;
                    mbHeight = mbd.height;
                }
            }

            if (root.getWindowDecorationStyle() != JRootPane.NONE &&
                    (root.getUI() instanceof MaterialRootPaneUI)) {
                JComponent titlePane = ((MaterialRootPaneUI) root.getUI()).
                        getTitlePane();
                if (titlePane != null) {
                    tpd = titlePane.getMaximumSize();
                    if (tpd != null) {
                        tpWidth = tpd.width;
                        tpHeight = tpd.height;
                    }
                }
            }

            int maxHeight = Math.max(Math.max(cpHeight, mbHeight), tpHeight);
            if (maxHeight != Integer.MAX_VALUE) {
                maxHeight = cpHeight + mbHeight + tpHeight + i.top + i.bottom;
            }

            int maxWidth = Math.max(Math.max(cpWidth, mbWidth), tpWidth);
            if (maxWidth != Integer.MAX_VALUE) {
                maxWidth += i.left + i.right;
            }

            return new Dimension(maxWidth, maxHeight);
        }

        public void layoutContainer(Container parent) {
            JRootPane root = (JRootPane) parent;
            Rectangle b = root.getBounds();
            Insets i = root.getInsets();
            int nextY = 0;
            int w = b.width - i.right - i.left;
            int h = b.height - i.top - i.bottom;

            if (root.getLayeredPane() != null) {
                root.getLayeredPane().setBounds(i.left, i.top, w, h);
            }
            if (root.getGlassPane() != null) {
                root.getGlassPane().setBounds(i.left, i.top, w, h);
            }
            if (root.getWindowDecorationStyle() != JRootPane.NONE &&
                    (root.getUI() instanceof MaterialRootPaneUI)) {
                JComponent titlePane = ((MaterialRootPaneUI) root.getUI()).
                        getTitlePane();
                if (titlePane != null) {
                    Dimension tpd = titlePane.getPreferredSize();
                    if (tpd != null) {
                        int tpHeight = tpd.height;
                        titlePane.setBounds(0, 0, w, tpHeight);
                        nextY += tpHeight;
                    }
                }
            }
            if (root.getJMenuBar() != null) {
                Dimension mbd = root.getJMenuBar().getPreferredSize();
                root.getJMenuBar().setBounds(0, nextY, w, mbd.height);
                nextY += mbd.height;
            }
            if (root.getContentPane() != null) {
                Dimension cpd = root.getContentPane().getPreferredSize();
                root.getContentPane().setBounds(0, nextY, w,
                        h < nextY ? 0 : h - nextY);
            }
        }

        public void addLayoutComponent(String name, Component comp) {
        }

        public void removeLayoutComponent(Component comp) {
        }

        public void addLayoutComponent(Component comp, Object constraints) {
        }

        public float getLayoutAlignmentX(Container target) {
            return 0.0f;
        }

        public float getLayoutAlignmentY(Container target) {
            return 0.0f;
        }

        public void invalidateLayout(Container target) {
        }
    }

    public void setMaximized() {
        Component tla = root.getTopLevelAncestor();
        //GraphicsConfiguration gc = (currentRootPaneGC != null) ? currentRootPaneGC : tla.getGraphicsConfiguration();
        GraphicsConfiguration gc = tla.getGraphicsConfiguration();
        Rectangle screenBounds = gc.getBounds();
        screenBounds.x = 0;
        screenBounds.y = 0;
        Insets screenInsets = Toolkit.getDefaultToolkit().getScreenInsets(gc);
        Rectangle maxBounds = new Rectangle(
                (screenBounds.x + screenInsets.left),
                (screenBounds.y + screenInsets.top), screenBounds.width
                - ((screenInsets.left + screenInsets.right)),
                screenBounds.height
                        - ((screenInsets.top + screenInsets.bottom)));
        if (tla instanceof JFrame) {
            ((JFrame) tla).setMaximizedBounds(maxBounds);
        }
    }

    protected class MaterialHandler implements MouseInputListener, WindowListener, WindowFocusListener, SwingConstants {
        // are the mousePressed location in absolute coordinate system
        int absoluteX, absoluteY;
        // are the mousePressed location in source view's coordinate system
        int windiwNowX, windowNowY;
        Rectangle startingBounds;
        int resizeDir;
        protected final int RESIZE_NONE = 0;
        private boolean discardRelease = false;
        int resizeCornerSize = 5;

        void updateFrameCursor(Window w) {
            if (resizing) {
                return;
            }
            Cursor s = myLastCursor;
            if (s == null) {
                s = Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR);
            }
            w.setCursor(s);
        }

        void finishMouseReleased(Window w) {
            if (discardRelease) {
                discardRelease = false;
                return;
            }
            if (resizeDir == RESIZE_NONE) {
                endDraggingFrame(w);
                dragging = false;
            } else {
                endResizingFrame(w);
                resizing = false;
                updateFrameCursor(w);
            }
            absoluteX = 0;
            absoluteY = 0;
            windiwNowX = 0;
            windowNowY = 0;
            startingBounds = null;
            resizeDir = RESIZE_NONE;
            // Set discardRelease to true, so that only a mousePressed()
            // which sets it to false, will allow entry to the above code
            // for finishing a resize.
            discardRelease = true;
        }

        public void mousePressed(MouseEvent ev) {
            windiwNowX = ev.getX();
            windowNowY = ev.getY();
            //fix
            Point mouseCurent = MouseInfo.getPointerInfo().getLocation();
            absoluteX = mouseCurent.x;
            absoluteY = mouseCurent.y;
            //_x = p.x;
            //_y = p.y;
            resizeDir = RESIZE_NONE;
            discardRelease = false;
            JRootPane rootPane = getRootPane();

            if (rootPane.getWindowDecorationStyle() == JRootPane.NONE) {
                return;
            }
            Point dragWindowOffset = ev.getPoint();
            Window w = (Window) ev.getSource();
            if (w != null) {
                w.toFront();
            }
            startingBounds = w.getBounds();
            Insets i = w.getInsets();
            Point ep = new Point(windiwNowX, windowNowY);
            //Point convertedDragWindowOffset = SwingUtilities.convertPoint(w, dragWindowOffset, getTitlePane());
            boolean resizable = false;
            boolean maximized = false;
            if (w instanceof Frame) {
                Frame f = (Frame) w;
                resizable = f.isResizable();
                maximized = (f.getExtendedState() & Frame.MAXIMIZED_BOTH) == 0;
            } else if (w instanceof Dialog) {
                Dialog d = (Dialog) w;
                resizable = d.isResizable();
            }

            if (getTitlePane().getBounds().contains(ev.getPoint())) {
                if (ev.getX() > i.left + resizeCornerSize &&
                        ev.getX() < w.getWidth() - i.right - resizeCornerSize &&
                        ev.getY() > i.top + resizeCornerSize) {
                    beginDraggingFrame(w);
                    dragging = true;
                    return;
                }
            }
            if (!resizable || maximized) {
                return;
            }

            if (ep.x <= i.left + resizeCornerSize) {
                if (ep.y < resizeCornerSize + i.top) {
                    resizeDir = NORTH_WEST;
                } else if (ep.y > w.getHeight()
                        - resizeCornerSize - i.bottom) {
                    resizeDir = SOUTH_WEST;
                } else {
                    resizeDir = WEST;
                }
            } else if (ep.x >= w.getWidth() - i.right - resizeCornerSize) {
                if (ep.y < resizeCornerSize + i.top) {
                    resizeDir = NORTH_EAST;
                } else if (ep.y > w.getHeight()
                        - resizeCornerSize - i.bottom) {
                    resizeDir = SOUTH_EAST;
                } else {
                    resizeDir = EAST;
                }
            } else if (ep.y <= i.top + resizeCornerSize) {
                if (ep.x < resizeCornerSize + i.left) {
                    resizeDir = NORTH_WEST;
                } else if (ep.x > w.getWidth()
                        - resizeCornerSize - i.right) {
                    resizeDir = NORTH_EAST;
                } else {
                    resizeDir = NORTH;
                }
            } else if (ep.y >= w.getHeight() - i.bottom - resizeCornerSize) {
                if (ep.x < resizeCornerSize + i.left) {
                    resizeDir = SOUTH_WEST;
                } else if (ep.x > w.getWidth()
                        - resizeCornerSize - i.right) {
                    resizeDir = SOUTH_EAST;
                } else {
                    resizeDir = SOUTH;
                }
            } else {
             /* the mouse press happened inside the frame, not in the
                border */
                discardRelease = true;
                return;
            }
            Cursor s = Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR);
            switch (resizeDir) {
                case SOUTH:
                    s = Cursor.getPredefinedCursor(Cursor.S_RESIZE_CURSOR);
                    break;
                case NORTH:
                    s = Cursor.getPredefinedCursor(Cursor.N_RESIZE_CURSOR);
                    break;
                case WEST:
                    s = Cursor.getPredefinedCursor(Cursor.W_RESIZE_CURSOR);
                    break;
                case EAST:
                    s = Cursor.getPredefinedCursor(Cursor.E_RESIZE_CURSOR);
                    break;
                case SOUTH_EAST:
                    s = Cursor.getPredefinedCursor(Cursor.SE_RESIZE_CURSOR);
                    break;
                case SOUTH_WEST:
                    s = Cursor.getPredefinedCursor(Cursor.SW_RESIZE_CURSOR);
                    break;
                case NORTH_WEST:
                    s = Cursor.getPredefinedCursor(Cursor.NW_RESIZE_CURSOR);
                    break;
                case NORTH_EAST:
                    s = Cursor.getPredefinedCursor(Cursor.NE_RESIZE_CURSOR);
                    break;
            }
            beginResizingFrame(w, resizeDir);
            w.setCursor(s);
            resizing = true;
            // return;
        }

        public void mouseReleased(MouseEvent ev) {
            Window w = (Window) ev.getSource();
            finishMouseReleased(w);
        }

        public void mouseMoved(MouseEvent ev) {
            JRootPane root = getRootPane();
            if (root.getWindowDecorationStyle() == JRootPane.NONE) {
                return;
            }

            Window w = (Window) ev.getSource();

            boolean undecorated = false;
            boolean resizable = false;
            boolean maximized = false;

            if (w instanceof Frame) {
                Frame f = (Frame) w;
                undecorated = f.isUndecorated();
                resizable = f.isResizable();
                maximized = (f.getExtendedState() & Frame.MAXIMIZED_BOTH) == 0;
            } else if (w instanceof Dialog) {
                Dialog d = (Dialog) w;
                undecorated = d.isUndecorated();
                resizable = d.isResizable();
            }

            Insets i = w.getInsets();
            Point ep = new Point(ev.getX(), ev.getY());
            //Set correct cursor for resize windows
            if (resizable && !maximized) {
                if (ep.x <= i.left + resizeCornerSize) {
                    if (ep.y < resizeCornerSize + i.top)
                        w.setCursor(Cursor.getPredefinedCursor(Cursor.NW_RESIZE_CURSOR));
                    else if (ep.y > w.getHeight() - resizeCornerSize - i.bottom)
                        w.setCursor(Cursor.getPredefinedCursor(Cursor.SW_RESIZE_CURSOR));
                    else
                        w.setCursor(Cursor.getPredefinedCursor(Cursor.W_RESIZE_CURSOR));
                } else if (ep.x >= w.getWidth() - i.right - resizeCornerSize) {
                    if (ev.getY() < resizeCornerSize + i.top)
                        w.setCursor(Cursor.getPredefinedCursor(Cursor.NE_RESIZE_CURSOR));
                    else if (ep.y > w.getHeight() - resizeCornerSize - i.bottom)
                        w.setCursor(Cursor.getPredefinedCursor(Cursor.SE_RESIZE_CURSOR));
                    else
                        w.setCursor(Cursor.getPredefinedCursor(Cursor.E_RESIZE_CURSOR));
                } else if (ep.y <= i.top + resizeCornerSize) {
                    if (ep.x < resizeCornerSize + i.left)
                        w.setCursor(Cursor.getPredefinedCursor(Cursor.NW_RESIZE_CURSOR));
                    else if (ep.x > w.getWidth() - resizeCornerSize - i.right)
                        w.setCursor(Cursor.getPredefinedCursor(Cursor.NE_RESIZE_CURSOR));
                    else
                        w.setCursor(Cursor.getPredefinedCursor(Cursor.N_RESIZE_CURSOR));
                } else if (ep.y >= w.getHeight() - i.bottom - resizeCornerSize) {
                    if (ep.x < resizeCornerSize + i.left)
                        w.setCursor(Cursor.getPredefinedCursor(Cursor.SW_RESIZE_CURSOR));
                    else if (ep.x > w.getWidth() - resizeCornerSize - i.right)
                        w.setCursor(Cursor.getPredefinedCursor(Cursor.SE_RESIZE_CURSOR));
                    else
                        w.setCursor(Cursor.getPredefinedCursor(Cursor.S_RESIZE_CURSOR));
                } else {
                    updateFrameCursor(w);
                }
            } else {
                updateFrameCursor(w);
            }
        }

        @SuppressWarnings("unchecked")
        public void mouseDragged(MouseEvent e) {
            if (startingBounds == null) {
                // (STEVE) Yucky work around for bug ID 4106552
                return;
            }
            Window window = (Window) e.getSource();
            //Point p = SwingUtilities.convertPoint(window, window.getX(), window.getY(), null);

            Point mouseCurent = MouseInfo.getPointerInfo().getLocation();
            //fix
            int deltaX = absoluteX - mouseCurent.x;
            int deltaY = absoluteY - mouseCurent.y;
            //int deltaX = _x - p.x;
            //int deltaY = _y - p.y;
            Dimension min = window.getMinimumSize();
            Dimension max = window.getMaximumSize();
            int newX, newY, newW, newH;
            Insets windows = window.getInsets();


            boolean resizable = false;
            boolean maximized = false;

            if (window instanceof Frame) {
                Frame f = (Frame) window;
                resizable = f.isResizable();
                maximized = (f.getExtendedState() & Frame.MAXIMIZED_BOTH) == 0;
            } else if (window instanceof Dialog) {
                Dialog d = (Dialog) window;
                resizable = d.isResizable();
            }

            // Handle a MOVE
            // TODO Should be move in a future version the getModifiers and BUTTON1_MASK to BUTTON1_DOWN_MASK and  getModifiersEx()
            // reference https://docs.oracle.com/javase/9/docs/api/java/awt/event/InputEvent.html
            if (dragging) {
                if (maximized || ((e.getModifiers() &
                        InputEvent.BUTTON1_MASK) !=
                        InputEvent.BUTTON1_MASK)) {
                    // don't allow moving of frames if maximixed or left mouse
                    // button was not used.
                    return;
                }
                int pWidth, pHeight;
                // Dimension dimensioDevices = Toolkit.getDefaultToolkit().getScreenSize();
               /* GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
                int width = gd.getDisplayMode().getWidth();
                int height = gd.getDisplayMode().getHeight();
                Dimension dimensioDevices = new Dimension(width, height);*/

                pWidth = dimensionDevices.width;
                pHeight = dimensionDevices.height;

                newX = startingBounds.x - deltaX;
                newY = startingBounds.y - deltaY;

                /**
                //TODO see this point because with two display not worked well (Resolved -> testing)
                // Make sure we stay in-bounds
                if (newX + windows.left <= -windiwNowX) {
                    //What operation do this?
                    newX = -windiwNowX - windows.left + 1;
                } else if (newY + windows.top <= -windowNowY) {
                    //What operation do this?
                    newY = -windowNowY - windows.top + 1;
                } else if (newX + windiwNowX + windows.right >= pWidth) {
                    //What operation do this?
                    newX = pWidth - windiwNowX - windows.right - 1;
                } else if (newY + windowNowY + windows.bottom >= pHeight) {
                    //What operation do this?
                    newY = pHeight - windowNowY - windows.bottom - 1;
                } **/
                //System.out.printf("(%03d, %03d) -> (%03d, %03d)\n", viewX, viewY, newX, newY);
                dragFrame(window, newX, newY);
                return;
            }

            if (!resizable) {
                return;
            }

            newX = window.getX();
            newY = window.getY();
            newW = window.getWidth();
            newH = window.getHeight();

            //This mean when the windows start to resize and not dragged
            switch (resizeDir) {
               // case RESIZE_NONE:
                 //   return; //TODO can be removed (Resolved => Testing)
                case NORTH:
                    if (startingBounds.height + deltaY < min.height)
                        deltaY = -(startingBounds.height - min.height);
                    else if (startingBounds.height + deltaY > max.height)
                        deltaY = max.height - startingBounds.height;
                    if (startingBounds.y - deltaY < 0) {
                        deltaY = startingBounds.y;
                    }

                    newX = startingBounds.x;
                    newY = startingBounds.y - deltaY;
                    newW = startingBounds.width;
                    newH = startingBounds.height + deltaY;
                    break;
                case NORTH_EAST:
                    if (startingBounds.height + deltaY < min.height)
                        deltaY = -(startingBounds.height - min.height);
                    else if (startingBounds.height + deltaY > max.height)
                        deltaY = max.height - startingBounds.height;
                    if (startingBounds.y - deltaY < 0) {
                        deltaY = startingBounds.y;
                    }

                    if (startingBounds.width - deltaX < min.width)
                        deltaX = startingBounds.width - min.width;
                    else if (startingBounds.width - deltaX > max.width)
                        deltaX = -(max.width - startingBounds.width);
                    if (startingBounds.x + startingBounds.width - deltaX >
                            parentBounds.width) {
                        deltaX = startingBounds.x + startingBounds.width -
                                parentBounds.width;
                    }

                    newX = startingBounds.x;
                    newY = startingBounds.y - deltaY;
                    newW = startingBounds.width - deltaX;
                    newH = startingBounds.height + deltaY;
                    break;
                case EAST:
                    if (startingBounds.width - deltaX < min.width)
                        deltaX = startingBounds.width - min.width;
                    else if (startingBounds.width - deltaX > max.width)
                        deltaX = -(max.width - startingBounds.width);
                    if (startingBounds.x + startingBounds.width - deltaX >
                            parentBounds.width) {
                        deltaX = startingBounds.x + startingBounds.width -
                                parentBounds.width;
                    }

                    newW = startingBounds.width - deltaX;
                    newH = startingBounds.height;
                    break;
                case SOUTH_EAST:
                    if (startingBounds.width - deltaX < min.width)
                        deltaX = startingBounds.width - min.width;
                    else if (startingBounds.width - deltaX > max.width)
                        deltaX = -(max.width - startingBounds.width);
                    if (startingBounds.x + startingBounds.width - deltaX >
                            parentBounds.width) {
                        deltaX = startingBounds.x + startingBounds.width -
                                parentBounds.width;
                    }

                    if (startingBounds.height - deltaY < min.height)
                        deltaY = startingBounds.height - min.height;
                    else if (startingBounds.height - deltaY > max.height)
                        deltaY = -(max.height - startingBounds.height);
                    if (startingBounds.y + startingBounds.height - deltaY >
                            parentBounds.height) {
                        deltaY = startingBounds.y + startingBounds.height -
                                parentBounds.height;
                    }

                    newW = startingBounds.width - deltaX;
                    newH = startingBounds.height - deltaY;
                    break;
                case SOUTH:
                    if (startingBounds.height - deltaY < min.height)
                        deltaY = startingBounds.height - min.height;
                    else if (startingBounds.height - deltaY > max.height)
                        deltaY = -(max.height - startingBounds.height);
                    if (startingBounds.y + startingBounds.height - deltaY >
                            parentBounds.height) {
                        deltaY = startingBounds.y + startingBounds.height -
                                parentBounds.height;
                    }

                    newW = startingBounds.width;
                    newH = startingBounds.height - deltaY;
                    break;
                case SOUTH_WEST:
                    if (startingBounds.height - deltaY < min.height)
                        deltaY = startingBounds.height - min.height;
                    else if (startingBounds.height - deltaY > max.height)
                        deltaY = -(max.height - startingBounds.height);
                    if (startingBounds.y + startingBounds.height - deltaY >
                            parentBounds.height) {
                        deltaY = startingBounds.y + startingBounds.height -
                                parentBounds.height;
                    }

                    if (startingBounds.width + deltaX < min.width)
                        deltaX = -(startingBounds.width - min.width);
                    else if (startingBounds.width + deltaX > max.width)
                        deltaX = max.width - startingBounds.width;
                    if (startingBounds.x - deltaX < 0) {
                        deltaX = startingBounds.x;
                    }

                    newX = startingBounds.x - deltaX;
                    newY = startingBounds.y;
                    newW = startingBounds.width + deltaX;
                    newH = startingBounds.height - deltaY;
                    break;
                case WEST:
                    if (startingBounds.width + deltaX < min.width)
                        deltaX = -(startingBounds.width - min.width);
                    else if (startingBounds.width + deltaX > max.width)
                        deltaX = max.width - startingBounds.width;
                    if (startingBounds.x - deltaX < 0) {
                        deltaX = startingBounds.x;
                    }

                    newX = startingBounds.x - deltaX;
                    newY = startingBounds.y;
                    newW = startingBounds.width + deltaX;
                    newH = startingBounds.height;
                    break;
                case NORTH_WEST:
                    if (startingBounds.width + deltaX < min.width)
                        deltaX = -(startingBounds.width - min.width);
                    else if (startingBounds.width + deltaX > max.width)
                        deltaX = max.width - startingBounds.width;
                    if (startingBounds.x - deltaX < 0) {
                        deltaX = startingBounds.x;
                    }

                    if (startingBounds.height + deltaY < min.height)
                        deltaY = -(startingBounds.height - min.height);
                    else if (startingBounds.height + deltaY > max.height)
                        deltaY = max.height - startingBounds.height;
                    if (startingBounds.y - deltaY < 0) {
                        deltaY = startingBounds.y;
                    }

                    newX = startingBounds.x - deltaX;
                    newY = startingBounds.y - deltaY;
                    newW = startingBounds.width + deltaX;
                    newH = startingBounds.height + deltaY;
                    break;
                default:
                    return;
            }
            resizeFrame(window, newX, newY, newW, newH);
        }

        public void mouseEntered(MouseEvent ev) {
            Window w = (Window) ev.getSource();
            updateFrameCursor(w);
            /*if (cursorState == CursorState.EXITED || cursorState == CursorState.NIL) {
                myLastCursor = w.getCursor();
            }
            cursorState = CursorState.ENTERED;
            mouseMoved(ev);*/
        }

        public void mouseExited(MouseEvent ev) {
            Window w = (Window) ev.getSource();
            updateFrameCursor(w);
            //w.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
            //cursorState = CursorState.EXITED;
        }

        public void mouseClicked(MouseEvent ev) {
            Window w = (Window) ev.getSource();
            Frame f;

            if (w instanceof Frame) {
                f = (Frame) w;
            } else {
                return;
            }

            JComponent windowTitlePane = getTitlePane();
            if (windowTitlePane == null) {
                return;
            }

            Point convertedPoint = SwingUtilities.convertPoint(w, ev.getPoint(), windowTitlePane);

            int state = f.getExtendedState();
            if (windowTitlePane.contains(convertedPoint)) {
                if (((ev.getClickCount() % 2) == 0)
                        && ((ev.getModifiers() & InputEvent.BUTTON1_MASK) != 0)) {
                    if (f.isResizable()) {
                        if ((state & Frame.MAXIMIZED_BOTH) != 0) {
                            setMaximized();
                            f.setExtendedState(state & ~Frame.MAXIMIZED_BOTH);
                        } else {
                            setMaximized();
                            f.setExtendedState(state | Frame.MAXIMIZED_BOTH);
                        }
                    }
                }
            }
        }

        @Override
        public void windowOpened(WindowEvent e) {
        }

        @Override
        public void windowClosing(WindowEvent e) {
        }

        @Override
        public void windowClosed(WindowEvent e) {
            cancelResize(e.getWindow());
        }

        @Override
        public void windowIconified(WindowEvent e) {
        }

        @Override
        public void windowDeiconified(WindowEvent e) {

        }

        @Override
        public void windowActivated(WindowEvent e) {

        }

        @Override
        public void windowDeactivated(WindowEvent e) {

        }

        @Override
        public void windowGainedFocus(WindowEvent e) {

        }

        @Override
        public void windowLostFocus(WindowEvent e) {
            cancelResize(e.getWindow());
        }
    }

    protected void installBorder(JRootPane root) {
        int style = root.getWindowDecorationStyle();

        if (style == JRootPane.NONE) {
            LookAndFeel.uninstallBorder(root);
        } else {
            LookAndFeel.installBorder(root, borderKeys[style]);
        }
    }
}
