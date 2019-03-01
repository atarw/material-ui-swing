package mdlaf.components.table;

import mdlaf.animation.MaterialUIMovement;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

public class MaterialTableCellRenderer extends DefaultTableCellRenderer {

	@Override
	public Component getTableCellRendererComponent (JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
		JComponent component = (JComponent) super.getTableCellRendererComponent (table, value, isSelected, hasFocus, row, column);

		// hides yellow selection highlight
		component.setBorder (BorderFactory.createEmptyBorder ());

		this.setHorizontalAlignment (SwingConstants.CENTER);
		this.setVerticalAlignment (SwingConstants.CENTER);

		return component;
	}

	@Override
	public void setBackground(Color c) {
		super.setBackground(UIManager.getColor("Table.background"));
	}

	@Override
	public void setForeground(Color c) {
		super.setForeground(UIManager.getColor("Table.foreground"));
	}
}
