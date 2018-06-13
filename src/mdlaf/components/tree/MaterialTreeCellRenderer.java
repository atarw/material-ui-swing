package mdlaf.components.tree;

import mdlaf.resources.MaterialColors;
import mdlaf.resources.MaterialFonts;
import mdlaf.resources.MaterialImages;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeCellRenderer;
import java.awt.Color;
import java.awt.Component;

public class MaterialTreeCellRenderer extends DefaultTreeCellRenderer {

	@Override
	public Component getTreeCellRendererComponent (JTree tree, Object value, boolean isSelected, boolean expanded, boolean leaf, int row, boolean hasFocus) {
		JComponent component = (JComponent) super.getTreeCellRendererComponent (tree, value, isSelected, expanded, leaf, row, hasFocus);
		component.setBorder (BorderFactory.createEmptyBorder (5, 2, 5, 2));

		return component;
	}

	public MaterialTreeCellRenderer () {
		setTextSelectionColor (Color.BLACK);
		setTextNonSelectionColor (Color.BLACK);

		setBackgroundSelectionColor (MaterialColors.LIGHT_GRAY);
		setBackgroundNonSelectionColor (Color.WHITE);

		setBorderSelectionColor (null);

		setClosedIcon (new ImageIcon (MaterialImages.RIGHT_ARROW));
		setOpenIcon (new ImageIcon (MaterialImages.DOWN_ARROW));

		setFont (MaterialFonts.REGULAR);
	}
}
