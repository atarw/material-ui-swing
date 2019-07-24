package mdlaf.components.table;

import mdlaf.components.textfield.MaterialTextFieldUI;

import javax.swing.*;

public class MaterialTableCellEditor extends DefaultCellEditor {

    public MaterialTableCellEditor() {
        super(init());
    }

    private static JTextField init() {
        JTextField textField = new JTextField();
        textField.setUI(new MaterialTextFieldUI(false));
        return textField;
    }
}
