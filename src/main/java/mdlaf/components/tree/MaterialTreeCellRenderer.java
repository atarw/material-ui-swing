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
		JComponent component = (JComponent) super.getTreeCellRendererComponent (tree, value, isSelected, expanded, leaf, row, hasFocus);
		component.setBorder (BorderFactory.createEmptyBorder (5, 2, 5, 2));

		if(isSelected){
			setBackground(selectedBackground);
			setForeground(selectedForeground);
		}else{
			setBackground(background);
			setForeground(foreground);
		}

		return component;
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
