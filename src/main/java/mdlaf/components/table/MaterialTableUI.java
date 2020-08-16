/**
 * MIT License
 *
 * Copyright (c) 2018-2020 atharva washimkar, Vincenzo Palazzo vincenzopalazzo1996@gmail.com
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

import mdlaf.utils.*;

import javax.swing.*;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicTableUI;
import java.awt.*;
import java.util.Date;

/**
 * @author https://github.com/vincenzopalazzo
 * @author https://github.com/atarw
 */
public class MaterialTableUI extends BasicTableUI {


	public static ComponentUI createUI (JComponent c) {
		return new MaterialTableUI();
	}

	@Override
	public void installUI (JComponent c) {
		super.installUI (c);
		table.setBorder(UIManager.getBorder("Table.border"));
		table.setOpaque (UIManager.getBoolean("Table.opaque"));
		table.setSelectionForeground (UIManager.getColor ("Table.selectionForeground"));
		table.setGridColor (UIManager.getColor ("Table.gridColor"));
		table.setSelectionBackground (UIManager.getColor ("Table.selectionBackground"));
		table.setFocusable (UIManager.getBoolean ("Table.focusable"));
		table.setRowHeight(UIManager.getInt("Table[row].height"));
		table.setShowHorizontalLines(UIManager.getBoolean("Table.showHorizontalLines"));
		table.setShowVerticalLines(UIManager.getBoolean("Table.showVerticalLines"));
		table.setShowGrid(UIManager.getBoolean("Table.showHorizontalLines") && UIManager.getBoolean("Table.showVerticalLines"));
		table.setRowHeight(UIManager.getInt("Table[row].height"));
		table.setIntercellSpacing(UIManager.getDimension("Table.intercellSpacing"));
		table.getTableHeader().setResizingAllowed (true);
		int rowHeight = UIManager.getInt ("Table.rowHeight");
		if (rowHeight > 0) {
			table.setRowHeight (rowHeight);
		}else {
			table.setRowHeight (table.getRowHeight () + 25);
		}

		this.setDefaultCellRenderWithType(table);

		table.setDefaultEditor(Object.class, new MaterialTableCellEditor());
		table.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	}

	@Override
	protected void uninstallDefaults() {
		super.uninstallDefaults();
	}

	@Override
	public void paint (Graphics g, JComponent c) {
		super.paint (MaterialDrawingUtils.getAliasedGraphics (g), c);
	}

	@Override
	public void update(Graphics g, JComponent c) {
		super.update(g, c);
	}

	 //This method setting a MaterialCellRender at the particular class
	 // With this class not working correctly the color alternate in the Jtable
	protected void setDefaultCellRenderWithType(JTable table) {
		if(table == null){
			throw new IllegalArgumentException("Table is null");
		}

		table.setDefaultRenderer(Object.class, new MaterialTableCellRenderer());
		table.setDefaultRenderer(String.class, new MaterialTableCellRenderer());
		table.setDefaultRenderer(Integer.class, new MaterialTableCellRenderer());
		table.setDefaultRenderer(Double.class, new MaterialTableCellRenderer());
		table.setDefaultRenderer(Float.class, new MaterialTableCellRenderer());
		table.setDefaultRenderer(Boolean.class, new MaterialTableCellRenderer());
		table.setDefaultRenderer(Date.class, new MaterialTableCellRenderer());
		table.setDefaultRenderer(Long.class, new MaterialTableCellRenderer());
	}
}
