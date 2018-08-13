package mdlaf.components.combobox;

import mdlaf.resources.MaterialDrawingUtils;

import javax.swing.*;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicArrowButton;
import javax.swing.plaf.basic.BasicComboBoxUI;
import java.awt.*;

public class MaterialComboBoxUI extends BasicComboBoxUI {

	public static ComponentUI createUI (JComponent c) {
		return new MaterialComboBoxUI ();
	}

	@Override
	public void installUI (JComponent c) {
		super.installUI (c);

		JComboBox<?> comboBox = (JComboBox<?>) c;
		comboBox.setFont (UIManager.getFont ("ComboBox.font"));
		comboBox.setBackground (UIManager.getColor ("ComboBox.background"));
		comboBox.setForeground (UIManager.getColor ("ComboBox.foreground"));
		comboBox.setBorder (UIManager.getBorder ("ComboBox.border"));
		comboBox.setLightWeightPopupEnabled (true);
		comboBox.setRenderer (new MaterialComboBoxRenderer ());
	}

	@Override
	protected JButton createArrowButton () {
		Icon icon = UIManager.getIcon("ComboBox.buttonIcon");
		JButton button;
		if (icon != null) {
			button = new JButton(icon);
		} else {
			button = new BasicArrowButton(SwingConstants.SOUTH);
		}
		button.setOpaque (true);
		button.setBackground (UIManager.getColor ("ComboBox.buttonBackground"));
		button.setBorder (BorderFactory.createEmptyBorder ());

		return button;
	}

	@Override
	public void paint (Graphics g, JComponent c) {
		super.paint (MaterialDrawingUtils.getAliasedGraphics (g), c);
	}
}
