package mdlaf.components.tree;

import mdlaf.utils.MaterialDrawingUtils;

import javax.swing.*;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicTreeUI;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.TreeCellEditor;
import java.awt.*;

/**
 * @author https://github.com/vincenzopalazzo
 */
public class MaterialTreeUI extends BasicTreeUI {

	public static ComponentUI createUI (JComponent c) {
		return new MaterialTreeUI ();
	}

	@Override
	public void installUI (JComponent c) {
		super.installUI (c);

		DefaultTreeCellRenderer renderer = new MaterialTreeCellRenderer ();
		TreeCellEditor editor = new MaterialTreeCellEditor (tree, renderer);

		tree.setCellRenderer (renderer);
		tree.setCellEditor (editor);

		tree.setFont (UIManager.getFont ("Tree.font"));
		tree.setForeground (UIManager.getColor ("Tree.foreground"));
		tree.setBackground (UIManager.getColor ("Tree.background"));
		tree.setRowHeight (0);
		tree.setInvokesStopCellEditing (true);

		MaterialTreeUI ui = (MaterialTreeUI) tree.getUI ();
		ui.setLeftChildIndent (10);
		ui.setRightChildIndent (10);

		tree.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	}

	@Override
	public void uninstallUI(JComponent c) {

		tree.setCellRenderer (null);
		tree.setCellEditor (null);

		tree.setFont (null);
		tree.setForeground (null);
		tree.setBackground (null);

		tree.setCursor(null);

		super.uninstallUI(c);
	}

	@Override
	public void paint (Graphics g, JComponent c) {
		g = MaterialDrawingUtils.getAliasedGraphics (g);
		super.paint (g, c);
	}


	@Override
	protected void paintDropLine(Graphics g) {
		super.paintDropLine(MaterialDrawingUtils.getAliasedGraphics(g));
	}

	@Override
	protected void paintVerticalLine(Graphics g, JComponent c, int x, int top, int bottom) {
		//do nothing
	}

	@Override
	protected void paintHorizontalLine(Graphics g, JComponent c, int y, int left, int right) {
		//do nothing
	}

}