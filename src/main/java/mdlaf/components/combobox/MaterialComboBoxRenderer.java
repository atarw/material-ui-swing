package mdlaf.components.combobox;

import javax.swing.*;
import javax.swing.plaf.basic.BasicComboBoxRenderer;
import java.awt.*;

/**
 * @contributor https://github.com/vincenzopalazzo
 */
public class MaterialComboBoxRenderer extends BasicComboBoxRenderer {

	@Override
	public Component getListCellRendererComponent (JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
		super.getListCellRendererComponent (list, value, index, isSelected, cellHasFocus);

		setBorder((UIManager.getBorder("ComboBox.borderItems")));
		setForeground (UIManager.getColor ("ComboBox.foreground"));
		setBackground (isSelected || cellHasFocus ?
		                         UIManager.getColor ("ComboBox.selectedInDropDownBackground") :
		                         UIManager.getColor ("ComboBox.background"));

		return this;
	}
}
