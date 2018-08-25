package mdlaf.components.tabbedpane;

import mdlaf.utils.MaterialDrawingUtils;

import javax.swing.JComponent;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicTabbedPaneUI;
import java.awt.Graphics;
import java.awt.Rectangle;

public class MaterialTabbedPaneUI extends BasicTabbedPaneUI {

	public static ComponentUI createUI (JComponent c) {
		return new MaterialTabbedPaneUI ();
	}

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
	}
}
