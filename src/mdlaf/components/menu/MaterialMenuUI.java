package mdlaf.components.menu;


import mdlaf.utils.MaterialDrawingUtils;

import javax.swing.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicMenuUI;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MaterialMenuUI extends BasicMenuUI {

	public static ComponentUI createUI (JComponent c) {
		return new MaterialMenuUI ();
	}

	@Override
	public void installUI (JComponent c) {
		super.installUI (c);

		JMenu menu = (JMenu) c;
		menu.setFont (UIManager.getFont ("Menu.font"));
		menu.setBorder (UIManager.getBorder ("Menu.border"));
		menu.setBackground (UIManager.getColor ("Menu.background"));
		menu.setForeground (UIManager.getColor ("Menu.foreground"));
		menu.setOpaque (UIManager.getBoolean ("Menu.opaque"));
		c.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		menu.addMouseListener(new MouseOverEffect());

	}

	@Override
	public void paint (Graphics g, JComponent c) {
		super.paint (MaterialDrawingUtils.getAliasedGraphics (g), c);
	}

	/**
	 * @author https://github.com/vincenzopalazzo
	 */
	private class MouseOverEffect extends MouseAdapter{

		@Override
		public void mouseEntered(MouseEvent e) {
			JMenu menu = (JMenu) e.getSource();
			menu.setSelected(true);
		}

		@Override
		public void mouseExited(MouseEvent e) {
			JMenu menu = (JMenu) e.getSource();
			menu.setSelected(false);
		}
	}
}
