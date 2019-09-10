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
	public Component getTableCellRendererComponent (JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
		JComponent component = (JComponent) super.getTableCellRendererComponent (table, value, isSelected, hasFocus, row, column);
		// hides yellow selection highlight
		this.setHorizontalAlignment (SwingConstants.CENTER);
		this.setVerticalAlignment (SwingConstants.CENTER);

		if(value instanceof Boolean){
			TableCellRenderer renderer = new MaterialTableCellRendererCheckBox();
			return renderer.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
		}

		boolean alternativeRow = UIManager.getBoolean("Table.alternateRowColor");
		Color alternativeRowColor = UIManager.getColor("Table.alternateRowBackground");
		Color normalColor = UIManager.getColor("Table.background");
		if(alternativeRow){
			if(!isSelected){
				if(row%2 == 1) {
					component.setBackground(alternativeRowColor);
					setDefaultCellRenderWithAllType(table, value, isSelected, hasFocus, row, column, alternativeRowColor);
				}else{
					component.setBackground(normalColor);
					setDefaultCellRenderWithAllType(table, value, isSelected, hasFocus, row, column, normalColor);
				}
				component.setForeground(table.getSelectionForeground());
			}
		}
		return component;
	}

	  // This method setting a MaterialCellRender at the particular class
	  // With this class not working correctly the color alternate in the Jtable
	  // in particular the IconImage without this code the cell is painted not correctly or
	  // in the cell did print the path of the image

	protected void setDefaultCellRenderWithAllType(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column, Color color) {
		if(table == null){
			throw new IllegalArgumentException("Table is null");
		}

		Component component = table.getDefaultRenderer(ImageIcon.class).getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
		component.setBackground(color);
	}
}
