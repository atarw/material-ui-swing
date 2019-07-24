package mdlaf.components.separator;

import mdlaf.utils.MaterialDrawingUtils;

import javax.swing.JComponent;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicSeparatorUI;
import java.awt.Graphics;

/**
 * @author https://github.com/vincenzopalazzo
 */

public class MaterialSeparatorUI extends BasicSeparatorUI {

	public static ComponentUI createUI (JComponent c) {
		return new MaterialSeparatorUI ();
	}

	@Override
	public void installUI (JComponent c) {
		super.installUI (c);
	}

	@Override
	public void paint (Graphics g, JComponent c) {
		super.paint (MaterialDrawingUtils.getAliasedGraphics (g), c);
	}
}
