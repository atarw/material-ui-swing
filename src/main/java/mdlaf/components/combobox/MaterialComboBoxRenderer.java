package mdlaf.components.combobox;

import mdlaf.utils.MaterialColors;

import javax.swing.*;
import javax.swing.plaf.basic.BasicComboBoxRenderer;
import java.awt.*;

/**
 * @author https://github.com/vincenzopalazzo
 * @author https://github.com/atarw
 */
public class MaterialComboBoxRenderer extends BasicComboBoxRenderer {

	@Override
	public Component getListCellRendererComponent (JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
		super.getListCellRendererComponent (list, value, index, isSelected, cellHasFocus);

		setBorder((UIManager.getBorder("ComboBox.borderItems")));
		if(isSelected){
			setForeground(UIManager.getColor("ComboBox[item].selectionForeground"));
		}else{
			setForeground (UIManager.getColor ("ComboBox.foreground"));
		}
		setBackground (isSelected || cellHasFocus ?
				UIManager.getColor ("ComboBox.selectedInDropDownBackground") :
				UIManager.getColor ("ComboBox.background"));

		return this;
	}
}
