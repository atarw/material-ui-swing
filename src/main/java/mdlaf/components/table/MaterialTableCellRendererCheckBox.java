/**
 * MIT License
 * <p>
 * Copyright (c) 2018-2020 atharva washimkar, Vincenzo Palazzo vincenzopalazzo1996@gmail.com
 * <p>
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * <p>
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 * <p>
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package mdlaf.components.table;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import java.awt.*;

/**
 * @author https://github.com/vincenzopalazzo
 */
class MaterialTableCellRendererCheckBox extends JCheckBox implements TableCellRenderer {

    protected Icon unchecked = UIManager.getIcon("Table[CheckBox].unchecked");
    protected Icon checked = UIManager.getIcon("Table[CheckBox].checked");
    protected Icon uncheckedSelectionRow = UIManager.getIcon("Table[CheckBox].selectionUnchecked");
    protected Icon checkedSelectionRow = UIManager.getIcon("Table[CheckBox].selectionChecked");

    public MaterialTableCellRendererCheckBox() {
        setLayout(new GridBagLayout());
        setMargin(new Insets(0, 0, 0, 0));
        setHorizontalAlignment(JLabel.CENTER);
        setIcon(unchecked);
        setSelectedIcon(checked);
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        if (value instanceof Boolean) {
            setSelected((Boolean) value);
        }
        Color alternateRowColor = UIManager.getColor("Table.alternateRowColor");
        if(alternateRowColor != null){
            if(!isSelected){
                this.setIcon(unchecked);
                this.setSelectedIcon(checked);
                if(row%2 == 1) {
                    this.setBackground(alternateRowColor);
                }else{
                    this.setBackground(table.getBackground());
                }
                this.setForeground(table.getForeground());
            }else{
                this.setIcon(uncheckedSelectionRow);
                this.setSelectedIcon(checkedSelectionRow);
                this.setForeground(table.getSelectionForeground());
                this.setBackground(table.getSelectionBackground());
            }
        }
        //Old version code restored for JMars official version
        /*
        boolean alternativeRow = UIManager.getBoolean("Table.alternateRowColor");
        Color alternativeRowColor = UIManager.getColor("Table.alternateRowBackground");
        Color normalColor = UIManager.getColor("Table.background");
        if (alternativeRow) {
            if (!isSelected) {
                setIcon(unchecked);
                setSelectedIcon(checked);
                if (row % 2 == 1) {
                    this.setBackground(alternativeRowColor);
                } else {
                    this.setBackground(normalColor);
                }
                this.setForeground(table.getForeground());
            } else {
                setIcon(uncheckedSelectionRow);
                setSelectedIcon(checkedSelectionRow);
                this.setForeground(table.getSelectionForeground());
                this.setBackground(table.getSelectionBackground());
            }
        }*/
        return this;
    }
}
