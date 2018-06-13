package mdlaf.components.menu;

import mdlaf.components.menuitem.MaterialMenuItemUI;
import mdlaf.resources.MaterialDrawingUtils;
import mdlaf.resources.MaterialFonts;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JMenu;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicMenuUI;
import java.awt.Color;
import java.awt.Graphics;

public class MaterialMenuUI extends BasicMenuUI {

	public static ComponentUI createUI (final JComponent c) {
		return new MaterialMenuUI ();
	}

	@Override
	public void installUI (JComponent c) {
		super.installUI (c);

		JMenu menu = (JMenu) c;
		menu.setFont (MaterialFonts.BOLD);
		menu.setBorder (BorderFactory.createEmptyBorder (5, 5, 5, 5));
		menu.setBackground (Color.WHITE);
		menu.setForeground (Color.BLACK);
		menu.setOpaque (true);
	}

	@Override
	public void paint (Graphics g, JComponent c) {
		super.paint (MaterialDrawingUtils.getAliasedGraphics (g), c);
	}
}
