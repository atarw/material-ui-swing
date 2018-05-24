package mdlaf.table;

import javax.swing.DefaultCellEditor;
import javax.swing.JTable;
import javax.swing.JTextField;
import java.awt.Component;

public class MaterialTableCellEditor extends DefaultCellEditor {

	@Override
	public Component getTableCellEditorComponent (JTable table, Object value, boolean isSelected, int rowIndex, int vColIndex) {
		JTextField textField = (JTextField) super.getTableCellEditorComponent (table, value, isSelected, rowIndex, vColIndex);
		textField.setText ((String) value);

		return textField;
	}

	public MaterialTableCellEditor () {
		super (new JTextField ());
	}
}
