package mdlaf.components.popupmenu;

import mdlaf.resources.MaterialBorders;
import mdlaf.resources.MaterialDrawingUtils;

import javax.swing.JComponent;
import javax.swing.JPopupMenu;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicPopupMenuUI;
import java.awt.Color;
import java.awt.Graphics;

public class MaterialPopupMenuUI extends BasicPopupMenuUI {

	public static ComponentUI createUI (JComponent c) {
		return new MaterialPopupMenuUI ();
	}

	@Override
	public void installUI (JComponent c) {
		super.installUI (c);

		JPopupMenu popupMenu = (JPopupMenu) c;
		popupMenu.setBorder (MaterialBorders.LIGHT_LINE_BORDER);
		popupMenu.setBackground (Color.WHITE);
		popupMenu.setForeground (Color.BLACK);
	}

	@Override
	public void paint (Graphics g, JComponent c) {
		super.paint (MaterialDrawingUtils.getAliasedGraphics (g), c);
	}
}
