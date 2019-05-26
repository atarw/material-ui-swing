package mdlaf.components.menu;

import mdlaf.animation.MaterialUIMovement;
import mdlaf.utils.MaterialColors;
import mdlaf.utils.MaterialDrawingUtils;
import javax.swing.*;
import javax.swing.event.ChangeListener;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicMenuUI;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * @author https://github.com/vincenzopalazzo
 * @author https://github.com/atarw
 */

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
		if(UIManager.getBoolean("Menu[MouseOver].enable")){ //TODO testing
			menu.addMouseMotionListener(MaterialUIMovement.getMovement(menu, Color.black));
		}

	}

	@Override
	public void paint (Graphics g, JComponent c) {
		super.paint (MaterialDrawingUtils.getAliasedGraphics (g), c);
	}

	@Override
	protected ChangeListener createChangeListener(JComponent c) {
		if(UIManager.getBoolean("Menu[MouseOver].enable")){ //TODO Testing
			c.addMouseListener(new MouseHover());
		}
		return super.createChangeListener(c);
	}

	/**
	 * @author https://github.com/vincenzopalazzo
	 */
	private class MouseHover implements MouseListener {


		@Override
		public void mouseClicked(MouseEvent e) {
		}

		@Override
		public void mousePressed(MouseEvent e) {

		}

		@Override
		public void mouseReleased(MouseEvent e) {

		}

		@Override
		public void mouseEntered(MouseEvent e) {

			if(e.getSource() instanceof  JMenu){
				JMenu menu = (JMenu) e.getSource();
				if(menu.isEnabled()){
					menu.setSelected(true);
				}

			}
		}

		@Override
		public void mouseExited(MouseEvent e) {
			if(e.getSource() instanceof  JMenu){
				JMenu menu = (JMenu) e.getSource();
				if(menu.isEnabled()){
					menu.setSelected(false);
				}

			}
		}
	}
}
