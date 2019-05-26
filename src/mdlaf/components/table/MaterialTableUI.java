package mdlaf.components.table;

import mdlaf.utils.MaterialDrawingUtils;

import javax.swing.*;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicTableUI;
import java.awt.*;

/**
 * @contributor https://github.com/vincenzopalazzo
 */
public class MaterialTableUI extends BasicTableUI {

	private JTable table;

	public static ComponentUI createUI (JComponent c) {
		return new MaterialTableUI ();
	}

	@Override
	public void installUI (JComponent c) {
		super.installUI (c);

		table = (JTable) c;
		table.setOpaque (false);
		table.setSelectionForeground (UIManager.getColor ("Table.selectionForeground"));
		table.setBackground (UIManager.getColor ("Table.background"));
		table.setFont (UIManager.getFont ("Table.font"));
		table.setBorder (UIManager.getBorder ("Table.border"));
		table.setGridColor (UIManager.getColor ("Table.gridColor"));
		table.setSelectionBackground (UIManager.getColor ("Table.selectionBackground"));
		table.setFocusable (UIManager.getBoolean ("Table.focusable"));

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
		table.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		settingIconToTable();
	}

	@Override
	public void paint (Graphics g, JComponent c) {
		super.paint (MaterialDrawingUtils.getAliasedGraphics (g), c);
	}

	/**
	 * This method do possibility change icon into JTable, you setting a icon with this constant input
	 * UIManager.getIcon("Table[CheckBox].unchecked") and UIManager.getIcon("Table[CheckBox].checked")
	 */
	protected void settingIconToTable(){

		JCheckBox check = (JCheckBox) table.getDefaultRenderer(Boolean.class);
		check.setIcon(UIManager.getIcon("Table[CheckBox].unchecked"));
		check.setSelectedIcon(UIManager.getIcon("Table[CheckBox].checked"));

		DefaultCellEditor editor = (DefaultCellEditor) table.getDefaultEditor(Boolean.class);
		((JCheckBox)editor.getComponent()).setIcon(UIManager.getIcon("Table[CheckBox].unchecked"));
		((JCheckBox)editor.getComponent()).setSelectedIcon(UIManager.getIcon("Table[CheckBox].checked"));
	}
}
