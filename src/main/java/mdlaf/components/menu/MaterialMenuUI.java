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

import javax.swing.*;
import javax.swing.event.ChangeListener;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicMenuUI;

import mdlaf.utils.MaterialDrawingUtils;

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

	protected MouseListener mouseHover;
	protected JMenu menu;

	public MaterialMenuUI() {
		mouseHover = new MouseHover();
	}

	@Override
	public void installUI (JComponent c) {
		super.installUI (c);

		menu = (JMenu) c;
		c.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	}

	@Override
	public void uninstallUI(JComponent c) {
		c.setCursor(Cursor.getDefaultCursor());

		super.uninstallUI(menuItem);
	}

	@Override
	public void paint (Graphics g, JComponent c) {
		super.paint (MaterialDrawingUtils.getAliasedGraphics (g), c);
	}

	@Override
	protected ChangeListener createChangeListener(JComponent c) {
		if(UIManager.getBoolean("Menu[MouseOver].enable")){
			c.addMouseListener(mouseHover);
		}
		return super.createChangeListener(c);
	}

	@Override
	protected void uninstallListeners() {
		super.uninstallListeners();
		menu.removeMouseListener(mouseHover);
	}

	/**
	 * This mouse listener is used to selected the MenuTime when the mouse is hover
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
