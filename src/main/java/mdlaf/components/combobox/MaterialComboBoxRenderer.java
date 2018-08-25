package mdlaf.components.combobox;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JList;
import javax.swing.UIManager;
import javax.swing.plaf.basic.BasicComboBoxRenderer;
import java.awt.Component;

public class MaterialComboBoxRenderer extends BasicComboBoxRenderer {

	@Override
	public Component getListCellRendererComponent (JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
		JComponent component = (JComponent) super.getListCellRendererComponent (list, value, index, isSelected, cellHasFocus);

		component.setBorder (BorderFactory.createEmptyBorder (5, 5, 5, 5));
		component.setForeground (UIManager.getColor ("ComboBox.foreground"));
		component.setBackground (isSelected || cellHasFocus ?
		                         UIManager.getColor ("ComboBox.selectedInDropDownBackground") :
		                         UIManager.getColor ("ComboBox.background"));

		return component;
	}
}
