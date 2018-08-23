package mdlaf.components.table;

import mdlaf.utils.MaterialDrawingUtils;

import javax.swing.JComponent;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicTableUI;
import java.awt.Graphics;

public class MaterialTableUI extends BasicTableUI {

	public static ComponentUI createUI (JComponent c) {
		return new MaterialTableUI ();
	}

	@Override
	public void installUI (JComponent c) {
		super.installUI (c);

		JTable table = (JTable) c;
		table.setOpaque (false);
		table.setSelectionForeground (UIManager.getColor ("Table.selectionForeground"));
		table.setBackground (UIManager.getColor ("Table.background"));
		table.setFont (UIManager.getFont ("Table.font"));
		table.setBorder (UIManager.getBorder ("Table.border"));
		table.setGridColor (UIManager.getColor ("Table.gridColor"));
		table.setSelectionBackground (UIManager.getColor ("Table.selectionBackground"));

		table.getTableHeader ().setResizingAllowed (true);
		int rowHeight = UIManager.getInt ("Table.rowHeight");
		if (rowHeight > 0) {
			table.setRowHeight (rowHeight);
		}
		else {
			table.setRowHeight (table.getRowHeight () + 25);
		}

		table.setDefaultRenderer (Object.class, new MaterialTableCellRenderer ());
		table.setDefaultEditor (Object.class, new MaterialTableCellEditor ());
	}

	@Override
	public void paint (Graphics g, JComponent c) {
		super.paint (MaterialDrawingUtils.getAliasedGraphics (g), c);
	}
}
