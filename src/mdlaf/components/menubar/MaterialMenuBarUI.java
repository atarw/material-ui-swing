package mdlaf.components.menubar;

import mdlaf.resources.MaterialBorders;
import mdlaf.resources.MaterialDrawingUtils;
import mdlaf.resources.MaterialFonts;

import javax.swing.JComponent;
import javax.swing.JMenuBar;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicMenuBarUI;
import java.awt.Color;
import java.awt.Graphics;

public class MaterialMenuBarUI extends BasicMenuBarUI {

	public static ComponentUI createUI (JComponent c) {
		return new MaterialMenuBarUI ();
	}

	@Override
	public void installUI (JComponent c) {
		super.installUI (c);

		JMenuBar menuBar = (JMenuBar) c;
		menuBar.setFont (MaterialFonts.BOLD);
		menuBar.setBackground (Color.WHITE);
		menuBar.setBorder (MaterialBorders.LIGHT_LINE_BORDER);
		menuBar.setForeground (Color.BLACK);
	}

	@Override
	public void paint (Graphics g, JComponent c) {
		super.paint (MaterialDrawingUtils.getAliasedGraphics (g), c);
	}
}
