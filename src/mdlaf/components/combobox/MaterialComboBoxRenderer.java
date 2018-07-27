package mdlaf.components.combobox;

import mdlaf.resources.MaterialColors;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JList;
import javax.swing.plaf.basic.BasicComboBoxRenderer;
import java.awt.Color;
import java.awt.Component;

public class MaterialComboBoxRenderer extends BasicComboBoxRenderer {

	@Override
	public Component getListCellRendererComponent (JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
		JComponent component = (JComponent) super.getListCellRendererComponent (list, value, index, isSelected, cellHasFocus);

		component.setForeground (Color.BLACK);
		component.setBackground (isSelected || cellHasFocus ? MaterialColors.GRAY_200 : Color.WHITE);
		component.setBorder (BorderFactory.createEmptyBorder (5, 5, 5, 5));

		return component;
	}
}
