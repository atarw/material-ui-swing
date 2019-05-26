package mdlaf.components.table;

import mdlaf.components.textfield.MaterialTextFieldUI;

import javax.swing.*;
import java.awt.*;

public class MaterialTableCellEditor extends DefaultCellEditor {

    public MaterialTableCellEditor() {
        super(init());
    }

    private static JTextField init() {
        JTextField textField = new JTextField();
        textField.setUI(new MaterialTextFieldUI(false));
        return textField;
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int rowIndex, int vColIndex) {
       return editorComponent;
    }




}
