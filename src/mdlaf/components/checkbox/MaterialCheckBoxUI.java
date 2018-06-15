package mdlaf.components.checkbox;

import mdlaf.resources.MaterialDrawingUtils;
import mdlaf.resources.MaterialFonts;
import mdlaf.resources.MaterialImages;

import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicCheckBoxUI;
import java.awt.Color;
import java.awt.Graphics;

public class MaterialCheckBoxUI extends BasicCheckBoxUI {

	public static ComponentUI createUI (JComponent c) {
		return new MaterialCheckBoxUI ();
	}

	@Override
	public void installUI (JComponent c) {
		super.installUI (c);

		JCheckBox checkBox = (JCheckBox) c;
		checkBox.setFont (MaterialFonts.REGULAR);
		checkBox.setBackground (Color.WHITE);
		checkBox.setForeground (Color.BLACK);
		checkBox.setIcon (new ImageIcon (MaterialImages.UNCHECKED_BOX));
		checkBox.setSelectedIcon (new ImageIcon (MaterialImages.PAINTED_CHECKED_BOX));
	}

	@Override
	public void paint (Graphics g, JComponent c) {
		super.paint (MaterialDrawingUtils.getAliasedGraphics (g), c);
	}
}
