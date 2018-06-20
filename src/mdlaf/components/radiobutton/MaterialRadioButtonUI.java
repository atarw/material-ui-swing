package mdlaf.components.radiobutton;

import mdlaf.resources.MaterialDrawingUtils;
import mdlaf.resources.MaterialFonts;
import mdlaf.resources.MaterialImages;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JRadioButton;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicRadioButtonUI;
import java.awt.Color;
import java.awt.Graphics;

/*
 * Contributed by https://github.com/downToHell
 * */

public class MaterialRadioButtonUI extends BasicRadioButtonUI {

	public static ComponentUI createUI (JComponent c) {
		return new MaterialRadioButtonUI ();
	}

	@Override
	public void installUI (JComponent c) {
		super.installUI (c);

		JRadioButton radioButton = (JRadioButton) c;
		radioButton.setFont (MaterialFonts.REGULAR);
		radioButton.setBackground (Color.WHITE);
		radioButton.setForeground (Color.BLACK);
		radioButton.setIcon (new ImageIcon (MaterialImages.RADIO_BUTTON_OFF));
		radioButton.setSelectedIcon (new ImageIcon (MaterialImages.RADIO_BUTTON_ON));
	}

	@Override
	public void paint (Graphics g, JComponent c) {
		super.paint (MaterialDrawingUtils.getAliasedGraphics (g), c);
	}
}