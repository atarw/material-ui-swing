package mdlaf.components.table;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

public class MaterialTableHeaderCellRenderer extends DefaultTableCellRenderer {

	@Override
	public Component getTableCellRendererComponent (JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
		JComponent component = (JComponent) super.getTableCellRendererComponent (table, value, isSelected, hasFocus, row, column);
		component.setBorder (UIManager.getBorder ("TableHeader.cellBorder"));
		component.setFont (UIManager.getFont ("TableHeader.font"));
		component.setBackground (UIManager.getColor ("TableHeader.background"));
		component.setForeground(UIManager.getColor("TableHeader.foreground"));

		this.setHorizontalAlignment (SwingConstants.CENTER);
		this.setVerticalAlignment (SwingConstants.CENTER);

		return component;
	}
}
