package mdlaf.components.combobox;

import java.awt.Component;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JList;
import javax.swing.plaf.basic.BasicComboBoxRenderer;

import com.sun.prism.Material;

import mdlaf.resources.MaterialBorders;
import mdlaf.resources.MaterialColors;
import mdlaf.resources.MaterialFonts;

/**
 * 
 * @author https://github.com/vincenzopalazzo
 *
 */

public class MaterialComboBoxRender extends BasicComboBoxRenderer{

	@Override
	public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected,
			boolean cellHasFocus) {
		JComponent component = (JComponent) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
		if(isSelected || cellHasFocus) {
			component.setForeground(MaterialColors.WHITE);
			component.setFont(MaterialFonts.BOLD);
			component.setBackground(MaterialColors.LIGHT_BLUE_400);
		}else {
			component.setForeground(MaterialColors.GRAY_600);
			component.setBackground(MaterialColors.GRAY_300);
			component.setFont(MaterialFonts.BOLD);
		}
		component.setBorder(MaterialBorders.LIGHT_LINE_BORDER);
		return component;
	}
	
	

}
