/**
 * MIT License
 *
 * Copyright (c) 2018-2020 atharva washimkar, Vincenzo Palazzo vincenzopalazzo1996@gmail.com
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package mdlaf.components.menu;

import mdlaf.animation.MaterialUIMovement;
import mdlaf.utils.MaterialDrawingUtils;
import mdlaf.utils.MaterialManagerListener;

import javax.swing.*;
import javax.swing.event.ChangeListener;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicLookAndFeel;
import javax.swing.plaf.basic.BasicMenuUI;
import javax.swing.plaf.basic.BasicToolBarUI;
import javax.swing.plaf.metal.MetalMenuBarUI;
import javax.swing.plaf.metal.MetalToolBarUI;
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

	private MouseListener mouseHover = new MouseHover();

	@Override
	public void installUI (JComponent c) {
		super.installUI (c);

		//JMenu menu = (JMenu) c;
		//menu.setFont (UIManager.getFont ("Menu.font"));
		//menu.setBorder (UIManager.getBorder ("Menu.border"));
		//menu.setBackground (UIManager.getColor ("Menu.background"));
		//menu.setForeground (UIManager.getColor ("Menu.foreground"));
		//menu.setOpaque (UIManager.getBoolean ("Menu.opaque"));
		c.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		/*if(UIManager.getBoolean("Menu[MouseOver].enable")){ //TODO testing
			menu.addMouseMotionListener(MaterialUIMovement.getMovement(menu, Color.red));
		}*/

	}

	@Override
	public void uninstallUI(JComponent c) {

		/*menuItem.setFont (null);
		menuItem.setBackground (null);
		menuItem.setForeground (null);
		menuItem.setBorder (null);*/
		menuItem.setCursor(Cursor.getDefaultCursor());

//		c.removeMouseListener(mouseHover);
//		MaterialManagerListener.removeAllMaterialMouseListener(menuItem);

		super.uninstallUI(menuItem);
	}

	@Override
	public void paint (Graphics g, JComponent c) {
		super.paint (MaterialDrawingUtils.getAliasedGraphics (g), c);
	}

	@Override
	protected ChangeListener createChangeListener(JComponent c) {
		//if(UIManager.getBoolean("Menu[MouseOver].enable")){ //TODO Testing
		//	c.addMouseListener(mouseHover);
		//}
		return super.createChangeListener(c);
	}

	/**
	 * @author https://github.com/vincenzopalazzo
	 */
	//TODO can deprecate this?
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
