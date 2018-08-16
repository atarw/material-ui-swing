package mdlaf.components.tree;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JTree;
import javax.swing.UIManager;
import javax.swing.tree.DefaultTreeCellRenderer;
import java.awt.Component;

public class MaterialTreeCellRenderer extends DefaultTreeCellRenderer {

	public MaterialTreeCellRenderer () {
		setTextSelectionColor (UIManager.getColor ("Tree.selectionForeground"));
		setTextNonSelectionColor (UIManager.getColor ("Tree.foreground"));

		setBackgroundSelectionColor (UIManager.getColor ("Tree.selectionBackground"));
		setBackgroundNonSelectionColor (UIManager.getColor ("Tree.background"));

		setBorderSelectionColor (UIManager.getColor ("Tree.selectionBorderColor"));

		setClosedIcon (UIManager.getIcon ("Tree.closedIcon"));
		setOpenIcon (UIManager.getIcon ("Tree.openIcon"));
		setLeafIcon (null);


		setFont (UIManager.getFont ("Tree.font"));
	}

	@Override
	public Component getTreeCellRendererComponent (JTree tree, Object value, boolean isSelected, boolean expanded, boolean leaf, int row, boolean hasFocus) {
		JComponent component = (JComponent) super.getTreeCellRendererComponent (tree, value, isSelected, expanded, leaf, row, hasFocus);
		component.setBorder (BorderFactory.createEmptyBorder (5, 2, 5, 2));

		return component;
	}
}
