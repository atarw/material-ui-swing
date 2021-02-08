/**
 * MIT License
 *
 * Copyright (c) 2019-2021 Vincenzo Palazzo vincenzopalazzo1996@gmail.com
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
package mdlaf.components.tree;

import javax.swing.*;
import javax.swing.tree.DefaultTreeCellRenderer;
import java.awt.*;

/**
 * @author https://github.com/vincenzopalazzo
 */
public class MaterialTreeCellRenderer extends DefaultTreeCellRenderer {

	protected Color foreground;
	protected Color background;
	protected Color selectedBackground;
	protected Color selectedForeground;

	public MaterialTreeCellRenderer() {
		installColors();
	}

	@Override
	public Component getTreeCellRendererComponent (JTree tree, Object value, boolean isSelected, boolean expanded, boolean leaf, int row, boolean hasFocus) {
		super.getTreeCellRendererComponent (tree, value, isSelected, expanded, leaf, row, hasFocus);
		setBorder (UIManager.getBorder("Tree.border"));
		//setOpaque(true);
		if(isSelected){
			setBackgroundSelectionColor(selectedBackground);
			setTextSelectionColor(selectedForeground);
		}else{
			setBackgroundNonSelectionColor(background);
			setTextNonSelectionColor(foreground);
		}

		return this;
	}

	@Override
	public Icon getDefaultOpenIcon() {
		return UIManager.getIcon ("Tree.openIcon");
	}

	@Override
	public Icon getDefaultClosedIcon() {
		return UIManager.getIcon ("Tree.closedIcon");
	}

	@Override
	public Icon getDefaultLeafIcon() {
		return UIManager.getIcon ("Tree.leafIcon");
	}

	protected void installColors(){
		background = UIManager.getColor("Tree.background");
		foreground = UIManager.getColor("Tree.foreground");
		selectedBackground = UIManager.getColor("Tree.selectionBackground");
		selectedForeground = UIManager.getColor("Tree.selectionForeground");
	}
}
