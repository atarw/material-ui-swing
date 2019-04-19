package mdlaf.components.rootpane;

import mdlaf.components.titlepane.MaterialTitlePaneUI;
import javax.swing.*;
import javax.swing.event.MouseInputListener;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.metal.MetalRootPaneUI;
import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;

/**
 * @author https://github.com/vincenzopalazzo
 */
public class MaterialRootPaneUI extends MetalRootPaneUI {

    private static final String[] borderKeys = new String[] {
            null, "RootPane.frameBorder", "RootPane.plainDialogBorder",
            "RootPane.informationDialogBorder",
            "RootPane.errorDialogBorder", "RootPane.colorChooserDialogBorder",
            "RootPane.fileChooserDialogBorder", "RootPane.questionDialogBorder",
            "RootPane.warningDialogBorder"
    };

    private static final int CORNER_DRAG_WIDTH = 16;

    private static final int BORDER_DRAG_THICKNESS = 5;

    private Window window;

    private JComponent titlePane;

    private MouseInputListener mouseInputListener;

    private LayoutManager layoutManager;

    private LayoutManager savedOldLayout;

    private JRootPane root;

    private Cursor lastCursor =
            Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR);

    public static ComponentUI createUI(JComponent c) {
        return new MaterialRootPaneUI();
    }

    public void installUI(JComponent c) {
        super.installUI(c);
        root = (JRootPane)c;
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
        mouseInputListener = null;
        root = null;
    }

    void installBorder(JRootPane root) {
        int style = root.getWindowDecorationStyle();

        if (style == JRootPane.NONE) {
            LookAndFeel.uninstallBorder(root);
        }
        else {
            LookAndFeel.installBorder(root, borderKeys[style]);
        }
    }

    private void uninstallBorder(JRootPane root) {
        LookAndFeel.uninstallBorder(root);
    }

    private void installWindowListeners(JRootPane root, Component parent) {
        if (parent instanceof Window) {
            window = (Window)parent;
        }
        else {
            window = SwingUtilities.getWindowAncestor(parent);
        }
        if (window != null) {
            if (mouseInputListener == null) {
                mouseInputListener = createWindowMouseInputListener(root);
            }
            window.addMouseListener(mouseInputListener);
            window.addMouseMotionListener(mouseInputListener);
        }
    }

    private void uninstallWindowListeners(JRootPane root) {
        if (window != null) {
            window.removeMouseListener(mouseInputListener);
            window.removeMouseMotionListener(mouseInputListener);
        }
    }

    private void installLayout(JRootPane root) {
        if (layoutManager == null) {
            layoutManager = createLayoutManager();
        }
        savedOldLayout = root.getLayout();
        root.setLayout(layoutManager);
    }

    private void uninstallLayout(JRootPane root) {
        if (savedOldLayout != null) {
            root.setLayout(savedOldLayout);
            savedOldLayout = null;
        }
    }

    private void installClientDecorations(JRootPane root) {
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

    private void uninstallClientDecorations(JRootPane root) {
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

    private JComponent createTitlePane(JRootPane root) {
        return new MaterialTitlePaneUI(root);
    }

    private MouseInputListener createWindowMouseInputListener(JRootPane root) {
        return new MaterialRootPaneUI.MouseInputHandler();
    }

    private LayoutManager createLayoutManager() {
        return new MaterialLayaut();

    }

    private void setTitlePane(JRootPane root, JComponent titlePane) {
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

    private JComponent getTitlePane() {
        return titlePane;
    }

    private JRootPane getRootPane() {
        return root;
    }

    public void propertyChange(PropertyChangeEvent e) {
        super.propertyChange(e);

        String propertyName = e.getPropertyName();
        if(propertyName == null) {
            return;
        }

        if(propertyName.equals("windowDecorationStyle")) {
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
        }
        else if (propertyName.equals("ancestor")) {
            uninstallWindowListeners(root);
            if (((JRootPane)e.getSource()).getWindowDecorationStyle() !=
                    JRootPane.NONE) {
                installWindowListeners(root, root.getParent());
            }
        }
        return;
    }

    private static class MaterialLayaut implements LayoutManager2 {

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

            if(root.getContentPane() != null) {
                cpd = root.getContentPane().getPreferredSize();
            } else {
                cpd = root.getSize();
            }
            if (cpd != null) {
                cpWidth = cpd.width;
                cpHeight = cpd.height;
            }

            if(root.getJMenuBar() != null) {
                mbd = root.getJMenuBar().getPreferredSize();
                if (mbd != null) {
                    mbWidth = mbd.width;
                    mbHeight = mbd.height;
                }
            }

            if (root.getWindowDecorationStyle() != JRootPane.NONE &&
                    (root.getUI() instanceof MaterialRootPaneUI)) {
                JComponent titlePane = ((MaterialRootPaneUI)root.getUI()).getTitlePane();
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

            if(root.getContentPane() != null) {
                cpd = root.getContentPane().getMinimumSize();
            } else {
                cpd = root.getSize();
            }
            if (cpd != null) {
                cpWidth = cpd.width;
                cpHeight = cpd.height;
            }

            if(root.getJMenuBar() != null) {
                mbd = root.getJMenuBar().getMinimumSize();
                if (mbd != null) {
                    mbWidth = mbd.width;
                    mbHeight = mbd.height;
                }
            }
            if (root.getWindowDecorationStyle() != JRootPane.NONE &&
                    (root.getUI() instanceof MaterialRootPaneUI)) {
                JComponent titlePane = ((MaterialRootPaneUI)root.getUI()).getTitlePane();
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

            if(root.getContentPane() != null) {
                cpd = root.getContentPane().getMaximumSize();
                if (cpd != null) {
                    cpWidth = cpd.width;
                    cpHeight = cpd.height;
                }
            }

            if(root.getJMenuBar() != null) {
                mbd = root.getJMenuBar().getMaximumSize();
                if (mbd != null) {
                    mbWidth = mbd.width;
                    mbHeight = mbd.height;
                }
            }

            if (root.getWindowDecorationStyle() != JRootPane.NONE &&
                    (root.getUI() instanceof MaterialRootPaneUI)) {
                JComponent titlePane = ((MaterialRootPaneUI)root.getUI()).
                        getTitlePane();
                if (titlePane != null)
                {
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

            if(root.getLayeredPane() != null) {
                root.getLayeredPane().setBounds(i.left, i.top, w, h);
            }
            if(root.getGlassPane() != null) {
                root.getGlassPane().setBounds(i.left, i.top, w, h);
            }
            if (root.getWindowDecorationStyle() != JRootPane.NONE &&
                    (root.getUI() instanceof MaterialRootPaneUI)) {
                JComponent titlePane = ((MaterialRootPaneUI)root.getUI()).
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
            if(root.getJMenuBar() != null) {
                Dimension mbd = root.getJMenuBar().getPreferredSize();
                root.getJMenuBar().setBounds(0, nextY, w, mbd.height);
                nextY += mbd.height;
            }
            if(root.getContentPane() != null) {
                Dimension cpd = root.getContentPane().getPreferredSize();
                root.getContentPane().setBounds(0, nextY, w,
                        h < nextY ? 0 : h - nextY);
            }
        }

        public void addLayoutComponent(String name, Component comp) {}
        public void removeLayoutComponent(Component comp) {}
        public void addLayoutComponent(Component comp, Object constraints) {}
        public float getLayoutAlignmentX(Container target) { return 0.0f; }
        public float getLayoutAlignmentY(Container target) { return 0.0f; }
        public void invalidateLayout(Container target) {}
    }

    private static final int[] cursorMapping = new int[]
            { Cursor.NW_RESIZE_CURSOR, Cursor.NW_RESIZE_CURSOR, Cursor.N_RESIZE_CURSOR,
                    Cursor.NE_RESIZE_CURSOR, Cursor.NE_RESIZE_CURSOR,
                    Cursor.NW_RESIZE_CURSOR, 0, 0, 0, Cursor.NE_RESIZE_CURSOR,
                    Cursor.W_RESIZE_CURSOR, 0, 0, 0, Cursor.E_RESIZE_CURSOR,
                    Cursor.SW_RESIZE_CURSOR, 0, 0, 0, Cursor.SE_RESIZE_CURSOR,
                    Cursor.SW_RESIZE_CURSOR, Cursor.SW_RESIZE_CURSOR, Cursor.S_RESIZE_CURSOR,
                    Cursor.SE_RESIZE_CURSOR, Cursor.SE_RESIZE_CURSOR,
                    Cursor.HAND_CURSOR, Cursor.DEFAULT_CURSOR, Cursor.MOVE_CURSOR
            };

    private class MouseInputHandler implements MouseInputListener {

        private boolean isMovingWindow;

        private int dragCursor;

        private int dragOffsetX;

        private int dragOffsetY;

        private int dragWidth;

        private int dragHeight;

        public void mousePressed(MouseEvent ev) {
            JRootPane rootPane = getRootPane();

            if (rootPane.getWindowDecorationStyle() == JRootPane.NONE) {
                return;
            }
            Point dragWindowOffset = ev.getPoint();
            Window w = (Window)ev.getSource();
            if (w != null) {
                w.toFront();
            }
            Point convertedDragWindowOffset = SwingUtilities.convertPoint(
                    w, dragWindowOffset, getTitlePane());

            Frame f = null;
            Dialog d = null;

            if (w instanceof Frame) {
                f = (Frame)w;
            } else if (w instanceof Dialog) {
                d = (Dialog)w;
            }

            int frameState = (f != null) ? f.getExtendedState() : 0;

            if (getTitlePane() != null &&
                    getTitlePane().contains(convertedDragWindowOffset)) {
                if ((f != null && ((frameState & Frame.MAXIMIZED_BOTH) == 0)
                        || (d != null))
                        && dragWindowOffset.y >= BORDER_DRAG_THICKNESS
                        && dragWindowOffset.x >= BORDER_DRAG_THICKNESS
                        && dragWindowOffset.x < w.getWidth()
                        - BORDER_DRAG_THICKNESS) {
                    isMovingWindow = true;
                    dragOffsetX = dragWindowOffset.x;
                    dragOffsetY = dragWindowOffset.y;
                }
            }
            else if (f != null && f.isResizable()
                    && ((frameState & Frame.MAXIMIZED_BOTH) == 0)
                    || (d != null && d.isResizable())) {
                dragOffsetX = dragWindowOffset.x;
                dragOffsetY = dragWindowOffset.y;
                dragWidth = w.getWidth();
                dragHeight = w.getHeight();
                dragCursor = getCursor(calculateCorner(
                        w, dragWindowOffset.x, dragWindowOffset.y));
            }
        }

        public void mouseReleased(MouseEvent ev) {
            if (dragCursor != 0 && window != null && !window.isValid()) {
                window.validate();
                getRootPane().repaint();
            }
            isMovingWindow = false;
            dragCursor = 0;
        }

        public void mouseMoved(MouseEvent ev) {
            JRootPane root = getRootPane();

            if (root.getWindowDecorationStyle() == JRootPane.NONE) {
                return;
            }

            Window w = (Window)ev.getSource();

            Frame f = null;
            Dialog d = null;

            if (w instanceof Frame) {
                f = (Frame)w;
            } else if (w instanceof Dialog) {
                d = (Dialog)w;
            }

            // Update the cursor
            int cursor = getCursor(calculateCorner(w, ev.getX(), ev.getY()));

            if (cursor != 0 && ((f != null && (f.isResizable() &&
                    (f.getExtendedState() & Frame.MAXIMIZED_BOTH) == 0))
                    || (d != null && d.isResizable()))) {
                w.setCursor(Cursor.getPredefinedCursor(cursor));
            }
            else {
                w.setCursor(lastCursor);
            }
        }

        private void adjust(Rectangle bounds, Dimension min, int deltaX,
                            int deltaY, int deltaWidth, int deltaHeight) {
            bounds.x += deltaX;
            bounds.y += deltaY;
            bounds.width += deltaWidth;
            bounds.height += deltaHeight;
            if (min != null) {
                if (bounds.width < min.width) {
                    int correction = min.width - bounds.width;
                    if (deltaX != 0) {
                        bounds.x -= correction;
                    }
                    bounds.width = min.width;
                }
                if (bounds.height < min.height) {
                    int correction = min.height - bounds.height;
                    if (deltaY != 0) {
                        bounds.y -= correction;
                    }
                    bounds.height = min.height;
                }
            }
        }

        public void mouseDragged(MouseEvent ev) {
            Window w = (Window)ev.getSource();
            Point pt = ev.getPoint();

            if (isMovingWindow) {
                Point eventLocationOnScreen = ev.getLocationOnScreen();
                w.setLocation(eventLocationOnScreen.x - dragOffsetX,
                        eventLocationOnScreen.y - dragOffsetY);
            }
            else if (dragCursor != 0) {
                Rectangle r = w.getBounds();
                Rectangle startBounds = new Rectangle(r);
                Dimension min = w.getMinimumSize();

                switch (dragCursor) {
                    case Cursor.E_RESIZE_CURSOR:
                        adjust(r, min, 0, 0, pt.x + (dragWidth - dragOffsetX) -
                                r.width, 0);
                        break;
                    case Cursor.S_RESIZE_CURSOR:
                        adjust(r, min, 0, 0, 0, pt.y + (dragHeight - dragOffsetY) -
                                r.height);
                        break;
                    case Cursor.N_RESIZE_CURSOR:
                        adjust(r, min, 0, pt.y -dragOffsetY, 0,
                                -(pt.y - dragOffsetY));
                        break;
                    case Cursor.W_RESIZE_CURSOR:
                        adjust(r, min, pt.x - dragOffsetX, 0,
                                -(pt.x - dragOffsetX), 0);
                        break;
                    case Cursor.NE_RESIZE_CURSOR:
                        adjust(r, min, 0, pt.y - dragOffsetY,
                                pt.x + (dragWidth - dragOffsetX) - r.width,
                                -(pt.y - dragOffsetY));
                        break;
                    case Cursor.SE_RESIZE_CURSOR:
                        adjust(r, min, 0, 0,
                                pt.x + (dragWidth - dragOffsetX) - r.width,
                                pt.y + (dragHeight - dragOffsetY) -
                                        r.height);
                        break;
                    case Cursor.NW_RESIZE_CURSOR:
                        adjust(r, min, pt.x - dragOffsetX,
                                pt.y - dragOffsetY,
                                -(pt.x - dragOffsetX),
                                -(pt.y - dragOffsetY));
                        break;
                    case Cursor.SW_RESIZE_CURSOR:
                        adjust(r, min, pt.x - dragOffsetX, 0,
                                -(pt.x - dragOffsetX),
                                pt.y + (dragHeight - dragOffsetY) - r.height);
                        break;
                    default:
                        break;
                }
                if (!r.equals(startBounds)) {
                    w.setBounds(r);
                    // Defer repaint/validate on mouseReleased unless dynamic
                    // layout is active.
                    if (Toolkit.getDefaultToolkit().isDynamicLayoutActive()) {
                        w.validate();
                        getRootPane().repaint();
                    }
                }
            }
        }

        public void mouseEntered(MouseEvent ev) {
            Window w = (Window)ev.getSource();
            lastCursor = w.getCursor();
            mouseMoved(ev);
        }

        public void mouseExited(MouseEvent ev) {
            Window w = (Window)ev.getSource();
            w.setCursor(lastCursor);
        }

        public void mouseClicked(MouseEvent ev) {
            Window w = (Window)ev.getSource();
            Frame f = null;

            if (w instanceof Frame) {
                f = (Frame)w;
            } else {
                return;
            }

            Point convertedPoint = SwingUtilities.convertPoint(
                    w, ev.getPoint(), getTitlePane());

            int state = f.getExtendedState();
            if (getTitlePane() != null &&
                    getTitlePane().contains(convertedPoint)) {
                if ((ev.getClickCount() % 2) == 0 &&
                        ((ev.getModifiers() & InputEvent.BUTTON1_MASK) != 0)) {
                    if (f.isResizable()) {
                        if ((state & Frame.MAXIMIZED_BOTH) != 0) {
                            f.setExtendedState(state & ~Frame.MAXIMIZED_BOTH);
                        }
                        else {
                            f.setExtendedState(state | Frame.MAXIMIZED_BOTH);
                        }
                        return;
                    }
                }
            }
        }

        private int calculateCorner(Window w, int x, int y) {
            Insets insets = w.getInsets();
            int xPosition = calculatePosition(x - insets.left,
                    w.getWidth() - insets.left - insets.right);
            int yPosition = calculatePosition(y - insets.top,
                    w.getHeight() - insets.top - insets.bottom);

            if (xPosition == -1 || yPosition == -1) {
                return -1;
            }
            return yPosition * 5 + xPosition;
        }

        private int getCursor(int corner) {
            if (corner == -1) {
                return 0;
            }
            return cursorMapping[corner];
        }

        private int calculatePosition(int spot, int width) {
            if (spot < BORDER_DRAG_THICKNESS) {
                return 0;
            }
            if (spot < CORNER_DRAG_WIDTH) {
                return 1;
            }
            if (spot >= (width - BORDER_DRAG_THICKNESS)) {
                return 4;
            }
            if (spot >= (width - CORNER_DRAG_WIDTH)) {
                return 3;
            }
            return 2;
        }
    }
}
