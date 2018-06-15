package mdlaf.components.menuitem;

import mdlaf.resources.MaterialDrawingUtils;
import mdlaf.resources.MaterialFonts;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JMenuItem;
import javax.swing.SwingConstants;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicMenuItemUI;
import java.awt.Color;
import java.awt.Graphics;

public class MaterialMenuItemUI extends BasicMenuItemUI {

	public static ComponentUI createUI (JComponent c) {
		return new MaterialMenuItemUI ();
	}

	@Override
	public void installUI (JComponent c) {
		super.installUI (c);

		JMenuItem menuItem = (JMenuItem) c;
		menuItem.setFont (MaterialFonts.MEDIUM);
		menuItem.setBackground (Color.WHITE);
		menuItem.setForeground (Color.BLACK);
		menuItem.setHorizontalAlignment (SwingConstants.LEFT);
		menuItem.setVerticalAlignment (SwingConstants.CENTER);
		menuItem.setBorder (BorderFactory.createEmptyBorder (5, 0, 5, 0));
	}

	@Override
	public void paint (Graphics g, JComponent c) {
		super.paint (MaterialDrawingUtils.getAliasedGraphics (g), c);
	}
}
