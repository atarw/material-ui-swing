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
package mdlaf.components.radiobutton;

import mdlaf.utils.MaterialDrawingUtils;

import javax.swing.JComponent;
import javax.swing.JRadioButton;
import javax.swing.UIManager;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.metal.MetalRadioButtonUI;
import java.awt.*;

/**
 * @author https://github.com/vincenzopalazzo
 * @author https://github.com/atarw
 * @author https://github.com/downToHell
 */
public class MaterialRadioButtonUI extends MetalRadioButtonUI {

	public static ComponentUI createUI (JComponent c) {
		return new MaterialRadioButtonUI ();
	}

	@Override
	public void installUI (JComponent c) {
		super.installUI (c);
		JRadioButton radioButton = (JRadioButton) c;
		/*radioButton.setFont (UIManager.getFont ("RadioButton.font"));
		radioButton.setBackground (UIManager.getColor ("RadioButton.background"));
		radioButton.setForeground (UIManager.getColor ("RadioButton.foreground"));*/
		radioButton.setIcon (UIManager.getIcon ("RadioButton.icon"));
		radioButton.setSelectedIcon (UIManager.getIcon ("RadioButton.selectedIcon"));
		c.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	}

	@Override
	public void uninstallUI(JComponent c) {

	/*	c.setFont (null);
		c.setBackground (null);
		c.setForeground (null);
		c.setBorder (null);*/
		c.setCursor(Cursor.getDefaultCursor());

		/*JRadioButton radioButton = (JRadioButton) c;
		radioButton.setIcon(null);
		radioButton.setSelectedIcon(null);*/

		super.uninstallUI(c);
	}

	@Override
	protected void paintFocus(Graphics g, Rectangle t, Dimension d) {
		//do nothing
	}
}