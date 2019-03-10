package mdlaf.components.tabbedpane;

import mdlaf.utils.MaterialDrawingUtils;

import javax.swing.JComponent;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicTabbedPaneUI;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class MaterialTabbedPaneUI extends BasicTabbedPaneUI {

	public static ComponentUI createUI (JComponent c) {
		return new MaterialTabbedPaneUI ();
	}

	private JComponent component;

	@Override
	public void installUI (JComponent c) {
		super.installUI (c);

		JTabbedPane tabbedPane = (JTabbedPane) c;
		tabbedPane.setOpaque (false);
		tabbedPane.setFont (UIManager.getFont ("TabbedPane.font"));
		tabbedPane.setBackground (UIManager.getColor ("TabbedPane.background"));
		tabbedPane.setForeground (UIManager.getColor ("TabbedPane.foreground"));
		tabbedPane.setBorder (UIManager.getBorder ("TabbedPane.border"));

		darkShadow = UIManager.getColor ("TabbedPane.darkShadow");
		shadow = UIManager.getColor ("TabbedPane.shadow");
		lightHighlight = UIManager.getColor ("TabbedPane.highlight");

		component = tabbedPane;
	}

	@Override
	public void paint (Graphics g, JComponent c) {
		super.paint (MaterialDrawingUtils.getAliasedGraphics (g), c);
	}

	@Override
	protected void paintTabBackground (Graphics g, int tabPlacement, int tabIndex, int x, int y, int w, int h, boolean isSelected) {
		g.setColor (isSelected ? lightHighlight : tabPane.getBackground ());
		g.fillRect (x, y, w, h);
	}

	@Override
	protected void paintTabBorder (Graphics g, int tabPlacement, int tabIndex, int x, int y, int w, int h, boolean isSelected) {
		g.setColor (UIManager.getColor ("TabbedPane.borderHighlightColor"));
		g.drawRect (x, y, w, h);
	}

	@Override
	protected void paintFocusIndicator (Graphics g, int tabPlacement, Rectangle[] rects, int tabIndex, Rectangle iconRect, Rectangle textRect, boolean isSelected) {
		// do nothing
	}

	@Override
	protected void paintTab (Graphics g, int tabPlacement, Rectangle[] rects, int tabIndex, Rectangle iconRect, Rectangle textRect) {
		// for some reason tabs aren't painted properly by paint()
		super.paintTab (MaterialDrawingUtils.getAliasedGraphics (g), tabPlacement, rects, tabIndex, iconRect, textRect);
		component.addMouseMotionListener(new MouseHoverTab(rects));
	}

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
