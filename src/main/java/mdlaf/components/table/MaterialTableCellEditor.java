package mdlaf.components.table;

import mdlaf.components.textfield.MaterialTextFieldUI;
import mdlaf.utils.MaterialColors;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import java.awt.*;

public class MaterialTableCellEditor extends DefaultCellEditor {

    private static JTextField init() {
        JTextField textField = new JTextField();
        textField.setUI(new MaterialTextFieldUI(false));
        return textField;
    }

    private static JTextField init(JTextField textField) {
        textField = new JTextField();
        textField.setUI(new MaterialTextFieldUI(false));
        return textField;
    }

    public MaterialTableCellEditor() {
        super(init());
    }

    public MaterialTableCellEditor(JComboBox comboBox) {
        super(comboBox);
    }

    public MaterialTableCellEditor(JCheckBox checkBox) {
        super(checkBox);
    }

    public MaterialTableCellEditor(JTextField textField) {
        super(init(textField));
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {

        boolean alternativeRow = UIManager.getBoolean("Table.alternateRowColor");
        Color alternativeRowColor = UIManager.getColor("Table.alternateRowBackground");
        Color normalColor = UIManager.getColor("Table.background");
        if(alternativeRow){
            if(!isSelected){
                if(row%2 == 1) {
                    editorComponent.setBackground(alternativeRowColor);
                }else{
                    editorComponent.setBackground(normalColor);
                }
            }
        }

        return editorComponent;
    }
}
