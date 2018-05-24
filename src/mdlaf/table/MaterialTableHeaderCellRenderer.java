package mdlaf.table;

import mdlaf.MaterialBorders;
import mdlaf.MaterialColors;
import mdlaf.MaterialFonts;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.Component;

public class MaterialTableHeaderCellRenderer extends DefaultTableCellRenderer {

	@Override
	public Component getTableCellRendererComponent (JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
		JComponent component = (JComponent) super.getTableCellRendererComponent (table, value, isSelected, hasFocus, row, column);
		component.setBorder (BorderFactory.createCompoundBorder (MaterialBorders.LIGHT_LINE_BORDER, BorderFactory.createEmptyBorder (10, 10, 10, 10)));
		component.setFont (MaterialFonts.BOLD);
		component.setBackground (MaterialColors.LIGHT_GRAY);

		this.setHorizontalAlignment (SwingConstants.CENTER);
		this.setVerticalAlignment (SwingConstants.CENTER);

		return component;
	}
}
