package mdlaf.components.progressbar;

import mdlaf.utils.MaterialBorders;
import mdlaf.utils.MaterialColors;
import mdlaf.utils.MaterialDrawingUtils;

import javax.swing.JComponent;
import javax.swing.JProgressBar;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicProgressBarUI;
import java.awt.Graphics;

/**
 * @author https://github.com/vincenzopalazzo
 */

public class MaterialProgressBarUI extends BasicProgressBarUI {

	public static ComponentUI createUI (JComponent c) {
		return new MaterialProgressBarUI ();
	}

	@Override
	public void installUI (JComponent c) {
		super.installUI (c);

		JProgressBar progressBar = (JProgressBar) c;
		progressBar.setBorder (MaterialBorders.LIGHT_LINE_BORDER);
		progressBar.setBackground (MaterialColors.GRAY_200);
		progressBar.setForeground (MaterialColors.LIGHT_BLUE_400);
	}

	@Override
	public void paint (Graphics g, JComponent c) {
		super.paint (MaterialDrawingUtils.getAliasedGraphics (g), c);
	}

}
