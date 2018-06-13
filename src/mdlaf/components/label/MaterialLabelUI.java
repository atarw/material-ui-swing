package mdlaf.components.label;

import mdlaf.resources.MaterialDrawingUtils;
import mdlaf.resources.MaterialFonts;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicLabelUI;
import java.awt.Color;
import java.awt.Graphics;

public class MaterialLabelUI extends BasicLabelUI {

	public static ComponentUI createUI (final JComponent c) {
		return new MaterialLabelUI ();
	}

	@Override
	public void installUI (JComponent c) {
		super.installUI (c);

		JLabel label = (JLabel) c;
		label.setFont (MaterialFonts.REGULAR);
		label.setBackground (Color.WHITE);
		label.setForeground (Color.BLACK);
		label.setBorder (BorderFactory.createEmptyBorder ());
	}

	@Override
	public void paint (Graphics g, JComponent c) {
		super.paint (MaterialDrawingUtils.getAliasedGraphics (g), c);
	}
}
