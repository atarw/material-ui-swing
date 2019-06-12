package mdlaf.components.table;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

public class MaterialTableCellRenderer extends DefaultTableCellRenderer {

	@Override
	public Component getTableCellRendererComponent (JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
		JComponent component = (JComponent) super.getTableCellRendererComponent (table, value, isSelected, hasFocus, row, column);
		// hides yellow selection highlight
		this.setHorizontalAlignment (SwingConstants.CENTER);
		this.setVerticalAlignment (SwingConstants.CENTER);
		//component.setForeground(UIManager.getColor("Table.foreground"));
		return component;
	}
}
