package mdlaf.components.menuitem;

import mdlaf.utils.MaterialDrawingUtils;

import javax.swing.JComponent;
import javax.swing.JMenuItem;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicMenuItemUI;
import java.awt.*;

/**
 * @author https://github.com/vincenzopalazzo
 * @author https://github.com/atarw
 */
public class MaterialMenuItemUI extends BasicMenuItemUI {

	public static ComponentUI createUI (JComponent c) {
		return new MaterialMenuItemUI ();
	}

	@Override
	public void installUI (JComponent c) {
		super.installUI (c);

		menuItem.setFont (UIManager.getFont ("MenuItem.font"));
		menuItem.setBackground (UIManager.getColor ("MenuItem.background"));
		menuItem.setForeground (UIManager.getColor ("MenuItem.foreground"));
		menuItem.setHorizontalAlignment (SwingConstants.LEFT);
		menuItem.setVerticalAlignment (SwingConstants.CENTER);
		menuItem.setBorder (UIManager.getBorder ("MenuItem.border"));
		menuItem.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	}

	@Override
	public void uninstallUI(JComponent c) {

		menuItem.setFont (null);
		menuItem.setBackground (null);
		menuItem.setForeground (null);
		menuItem.setBorder (null);
		menuItem.setCursor(null);

		super.uninstallUI(menuItem);
	}

	@Override
	public void paint (Graphics g, JComponent c) {
		super.paint (MaterialDrawingUtils.getAliasedGraphics (g), c);
	}
}
