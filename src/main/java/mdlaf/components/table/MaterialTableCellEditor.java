/*
 * MIT License
 *
 * Copyright (c) 2018-2019 atharva washimkar,
 * Copyright (c) 2019 Vincent Palazzo vincenzopalazzodev@gmail.com
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package mdlaf.components.table;

import mdlaf.components.textfield.MaterialTextFieldUI;

import javax.swing.*;
import java.awt.*;

/**
 * @author https://github.com/vincenzopalazzo
 * @author https://github.com/atarw
 */
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
        JComponent component = (JComponent) super.getTableCellEditorComponent(table, value, isSelected, row, column);
        boolean alternativeRow = UIManager.getBoolean("Table.alternateRowColor");
        Color alternativeRowColor = UIManager.getColor("Table.alternateRowBackground");
        Color normalColor = UIManager.getColor("Table.background");
        if(alternativeRow){
            if(!isSelected){
                if(row%2 == 1) {
                    component.setBackground(alternativeRowColor);
                }else{
                    component.setBackground(normalColor);
                }
            }
        }
        return component;
    }
}
