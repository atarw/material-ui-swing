package mdlaf.components.tree;

import mdlaf.utils.MaterialColors;
import mdlaf.utils.MaterialDrawingUtils;
import mdlaf.utils.MaterialImageFactory;

import javax.swing.*;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicTreeUI;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.TreeCellEditor;
import java.awt.*;

public class MaterialTreeUI extends BasicTreeUI {

	public static ComponentUI createUI (JComponent c) {
		return new MaterialTreeUI ();
	}

	@Override
	public void installUI (JComponent c) {
		super.installUI (c);
		JTree tree = (JTree) c;

		DefaultTreeCellRenderer renderer = new MaterialTreeCellRenderer ();
		TreeCellEditor editor = new MaterialTreeCellEditor (tree, renderer);

		tree.setCellRenderer (renderer);
		tree.setCellEditor (editor);

		tree.setFont (UIManager.getFont ("Tree.font"));
		tree.setRowHeight (0);
		tree.setInvokesStopCellEditing (true);

		MaterialTreeUI ui = (MaterialTreeUI) tree.getUI ();
		ui.setLeftChildIndent (10);
		ui.setRightChildIndent (10);

		c.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	}

	@Override
	public void paint (Graphics g, JComponent c) {
		g = MaterialDrawingUtils.getAliasedGraphics (g);
		super.paint (g, c);
	}

	@Override
	public Icon getExpandedIcon() {
		return new ImageIcon(MaterialImageFactory.getIstance().getImage(MaterialImageFactory.DOWN_ARROW));
	}

	@Override
	public Icon getCollapsedIcon() {
		return new ImageIcon(MaterialImageFactory.getIstance().getImage(MaterialImageFactory.RIGHT_ARROW));
	}

	@Override
	protected void paintDropLine(Graphics g) {
		super.paintDropLine(MaterialDrawingUtils.getAliasedGraphics(g));
	}
}