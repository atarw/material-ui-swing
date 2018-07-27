package mdlaf.components.combobox;

import mdlaf.resources.MaterialBorders;
import mdlaf.resources.MaterialColors;
import mdlaf.resources.MaterialDrawingUtils;
import mdlaf.resources.MaterialFonts;
import mdlaf.resources.MaterialImages;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicComboBoxUI;
import java.awt.Color;
import java.awt.Graphics;

public class MaterialComboBoxUI extends BasicComboBoxUI {

	public static ComponentUI createUI (JComponent c) {
		return new MaterialComboBoxUI ();
	}

	@Override
	public void installUI (JComponent c) {
		super.installUI (c);

		JComboBox<?> comboBox = (JComboBox<?>) c;
		comboBox.setFont (MaterialFonts.REGULAR);
		comboBox.setBackground (Color.WHITE);
		comboBox.setForeground (Color.BLACK);
		comboBox.setBorder (BorderFactory.createCompoundBorder (MaterialBorders.LIGHT_LINE_BORDER, BorderFactory.createEmptyBorder (0, 5, 0, 0)));
		comboBox.setLightWeightPopupEnabled (true);
		comboBox.setRenderer (new MaterialComboBoxRenderer ());
	}

	@Override
	protected JButton createArrowButton () {
		JButton button = new JButton (new ImageIcon (MaterialImages.DOWN_ARROW));

		button.setOpaque (true);
		button.setBackground (MaterialColors.GRAY_300);
		button.setBorder (BorderFactory.createEmptyBorder ());

		return button;
	}

	@Override
	public void paint (Graphics g, JComponent c) {
		super.paint (MaterialDrawingUtils.getAliasedGraphics (g), c);
	}
}
