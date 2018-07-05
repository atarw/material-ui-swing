package mdlaf.components.scrollbar;

import mdlaf.resources.MaterialColors;
import mdlaf.resources.MaterialDrawingUtils;
import mdlaf.resources.MaterialFonts;
import mdlaf.resources.MaterialImages;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JScrollBar;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicScrollBarUI;
import java.awt.Graphics;

/*
 * Contributed by https://github.com/downToHell
 * */

public class MaterialScrollBarUI extends BasicScrollBarUI {

	public static ComponentUI createUI (JComponent c) {
		return new MaterialScrollBarUI ();
	}

	@Override
	public void installUI (JComponent c) {
		super.installUI (c);

		JScrollBar scrollBar = (JScrollBar) c;
		scrollBar.setFont (MaterialFonts.REGULAR);
		trackColor = MaterialColors.GRAY_200;
		thumbColor = thumbDarkShadowColor = thumbHighlightColor = thumbLightShadowColor = MaterialColors.GRAY_300;
	}

	@Override
	public void paint (Graphics g, JComponent c) {
		super.paint (MaterialDrawingUtils.getAliasedGraphics (g), c);
	}

	@Override
	protected JButton createDecreaseButton (int orientation) {
		JButton button = new JButton (new ImageIcon (MaterialImages.UP_ARROW));

		button.setOpaque (true);
		button.setBackground (MaterialColors.GRAY_300);
		button.setBorder (BorderFactory.createEmptyBorder ());

		return button;
	}

	@Override
	protected JButton createIncreaseButton (int orientation) {
		JButton button = new JButton (new ImageIcon (MaterialImages.DOWN_ARROW));

		button.setOpaque (true);
		button.setBackground (MaterialColors.GRAY_300);
		button.setBorder (BorderFactory.createEmptyBorder ());

		return button;
	}
}