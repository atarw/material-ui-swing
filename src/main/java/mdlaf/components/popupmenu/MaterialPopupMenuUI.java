package mdlaf.components.popupmenu;

import mdlaf.utils.MaterialDrawingUtils;

import javax.swing.JComponent;
import javax.swing.JPopupMenu;
import javax.swing.UIManager;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicPopupMenuUI;
import java.awt.Graphics;

/**
 * @author https://github.com/vincenzopalazzo
 * @author https://github.com/atarw
 */
public class MaterialPopupMenuUI extends BasicPopupMenuUI {

	public static ComponentUI createUI (JComponent c) {
		return new MaterialPopupMenuUI ();
	}

	@Override
	public void installUI (JComponent c) {
		super.installUI (c);

		JPopupMenu popupMenu = (JPopupMenu) c;
		popupMenu.setBorder (UIManager.getBorder ("PopupMenu.border"));
		popupMenu.setBackground (UIManager.getColor ("PopupMenu.background"));
		popupMenu.setForeground (UIManager.getColor ("PopupMenu.foreground"));
	}

	@Override
	public void uninstallUI(JComponent c) {

		c.setFont (null);
		c.setBackground (null);
		c.setForeground (null);
		c.setBorder (null);
		c.setCursor(null);

		super.uninstallUI(c);
	}

	@Override
	public void paint (Graphics g, JComponent c) {
		super.paint (MaterialDrawingUtils.getAliasedGraphics (g), c);
	}
}
