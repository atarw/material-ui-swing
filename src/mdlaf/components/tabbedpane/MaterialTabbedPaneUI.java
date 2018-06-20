package mdlaf.components.tabbedpane;

import mdlaf.resources.MaterialColors;
import mdlaf.resources.MaterialDrawingUtils;
import mdlaf.resources.MaterialFonts;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JTabbedPane;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicTabbedPaneUI;
import java.awt.Color;
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
		tabbedPane.setFont (MaterialFonts.REGULAR);
		tabbedPane.setBackground (Color.WHITE);
		tabbedPane.setForeground (Color.BLACK);
		tabbedPane.setBorder (BorderFactory.createEmptyBorder ());

		darkShadow = null;
		shadow = null;
		lightHighlight = MaterialColors.LIGHT_GRAY;
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
		g.setColor (Color.LIGHT_GRAY);
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
