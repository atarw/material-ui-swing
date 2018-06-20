package mdlaf.components.togglebutton;

import mdlaf.resources.MaterialDrawingUtils;
import mdlaf.resources.MaterialFonts;
import mdlaf.resources.MaterialImages;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JToggleButton;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicToggleButtonUI;
import java.awt.Color;
import java.awt.Graphics;

/*
 * Contributed by https://github.com/downToHell
 * */

public class MaterialToggleButtonUI extends BasicToggleButtonUI {

	public static ComponentUI createUI (JComponent c) {
		return new MaterialToggleButtonUI ();
	}

	@Override
	public void installUI (JComponent c) {
		super.installUI (c);

		JToggleButton button = (JToggleButton) c;
		button.setBorder (BorderFactory.createEmptyBorder ());
		button.setFont (MaterialFonts.REGULAR);
		button.setBackground (Color.WHITE);
		button.setForeground (Color.BLACK);
		button.setIcon (new ImageIcon (MaterialImages.TOGGLE_BUTTON_OFF));
		button.setSelectedIcon (new ImageIcon (MaterialImages.TOGGLE_BUTTON_ON));
	}

	@Override
	public void paint (Graphics g, JComponent c) {
		super.paint (MaterialDrawingUtils.getAliasedGraphics (g), c);
	}
}
