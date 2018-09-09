package mdlaf.components.scrollbar;

import mdlaf.utils.MaterialDrawingUtils;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JScrollBar;
import javax.swing.UIManager;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicArrowButton;
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
		scrollBar.setFont (UIManager.getFont ("ScrollBar.font"));
		trackColor = UIManager.getColor ("ScrollBar.track");
		thumbColor = UIManager.getColor ("ScrollBar.thumb");
		thumbDarkShadowColor = UIManager.getColor ("ScrollBar.thumbDarkShadow");
		thumbHighlightColor = UIManager.getColor ("ScrollBar.thumbHighlight");
		thumbLightShadowColor = UIManager.getColor ("ScrollBar.thumbShadow");
	}

	@Override
	public void paint (Graphics g, JComponent c) {
		super.paint (MaterialDrawingUtils.getAliasedGraphics (g), c);
	}

	@Override
	protected JButton createDecreaseButton (int orientation) {
		JButton button = new BasicArrowButton (orientation);

		button.setOpaque (true);
		button.setBackground (UIManager.getColor ("ScrollBar.arrowButtonBackground"));
		button.setBorder (UIManager.getBorder ("ScrollBar.arrowButtonBorder"));

		return button;
	}

	@Override
	protected JButton createIncreaseButton (int orientation) {
		JButton button = new BasicArrowButton (orientation);

		button.setOpaque (true);
		button.setBackground (UIManager.getColor ("ScrollBar.arrowButtonBackground"));
		button.setBorder (UIManager.getBorder ("ScrollBar.arrowButtonBorder"));

		return button;
	}
}