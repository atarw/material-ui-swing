/**
 * MIT License
 * <p>
 * Copyright (c) 2018-2020 atharva washimkar, Vincenzo Palazzo vincenzopalazzo1996@gmail.com
 * Copyright (c) 2021 Vincenzo Palazzo vincenzopalazzodev@gmail.com
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
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import java.awt.*;

/**
 * @author https://github.com/vincenzopalazzo
 * @author https://github.com/atarw
 */
public class MaterialTableCellRenderer extends DefaultTableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        // hides yellow selection highlight
        this.setHorizontalAlignment(SwingConstants.CENTER);
        this.setVerticalAlignment(SwingConstants.CENTER);

        if (value instanceof Boolean) {
            TableCellRenderer renderer = new MaterialTableCellRendererCheckBox();
            return renderer.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        }

        //OLD version code restored for JMars offical version
		/*
		boolean alternativeRow = UIManager.getBoolean("Table.alternateRowColor");
		Color alternateRowColor = UIManager.getColor("Table.alternateRowBackground");
		Color normalColor = UIManager.getColor("Table.background");
		if(alternativeRow){
			if(!isSelected){
				if(row%2 == 1) {
					component.setBackground(alternateRowColor);
					setDefaultCellRenderWithAllType(table, value, isSelected, hasFocus, row, column, alternateRowColor);
				}else{
					component.setBackground(normalColor);
					setDefaultCellRenderWithAllType(table, value, isSelected, hasFocus, row, column, normalColor);
				}
				component.setForeground(table.getForeground());
			}else {
				component.setForeground(table.getSelectionForeground());
			}
		}*/

        //new version of the code release in pre-release6.1
        //TODO should be removed? post on StackOverflow
        Color alternateRowColor = UIManager.getColor("Table.alternateRowColor");
        Color normalColor = UIManager.getColor("Table.background");
        if (row % 2 == 1) {
            //setDefaultCellRenderWithAllType(table, value, isSelected, hasFocus, row, column, alternateRowColor);
        } else {
            //setDefaultCellRenderWithAllType(table, value, isSelected, hasFocus, row, column, normalColor);
        }
        return this;
    }

    // This method setting a MaterialCellRender at the particular class
    // With this class not working correctly the color alternate in the Jtable
    // in particular the IconImage without this code the cell is painted not correctly or
    // in the cell did print the path of the image
    protected void setDefaultCellRenderWithAllType(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column, Color color) {
        if (table == null) {
            throw new IllegalArgumentException("Table is null");
        }

        Component component = table.getDefaultRenderer(ImageIcon.class).getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        component.setBackground(color);
    }
}
