package mdlaf.components.radiobutton;

import mdlaf.utils.MaterialDrawingUtils;

import javax.swing.JComponent;
import javax.swing.JRadioButton;
import javax.swing.UIManager;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicRadioButtonUI;
import java.awt.Graphics;

/*
 * Contributed by https://github.com/downToHell
 * */
//TODO cambio colore del radio button.
public class MaterialRadioButtonUI extends BasicRadioButtonUI {

	public static ComponentUI createUI (JComponent c) {
		return new MaterialRadioButtonUI ();
	}

	@Override
	public void installUI (JComponent c) {
		super.installUI (c);

		JRadioButton radioButton = (JRadioButton) c;
		radioButton.setFont (UIManager.getFont ("RadioButton.font"));
		radioButton.setBackground (UIManager.getColor ("RadioButton.background"));
		radioButton.setForeground (UIManager.getColor ("RadioButton.foreground"));
		radioButton.setIcon (UIManager.getIcon ("RadioButton.icon"));
		radioButton.setSelectedIcon (UIManager.getIcon ("RadioButton.selectedIcon"));
	}

	@Override
	public void paint (Graphics g, JComponent c) {
		super.paint (MaterialDrawingUtils.getAliasedGraphics (g), c);
	}
}