package mdlaf.components.scrollbar;

import mdlaf.resources.MaterialDrawingUtils;

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
	
	private static boolean DEBUG = false;

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
	
	/**
	 * @author https://github.com/vincenzopalazzo
	 * The method takes an integer variable that for the createDecreaseButton 
	 * method takes 7 if the scrollbar is horizontal and 1 if vertical
	 */
	@Override
	protected JButton createDecreaseButton (int orientation) {
		JButton button = new BasicArrowButton (orientation);

		button.setOpaque (true);
		button.setBackground (UIManager.getColor ("ScrollBar.arrowButtonBackground"));
		button.setBorder (UIManager.getBorder ("ScrollBar.arrowButtonBorder"));

		return button;
	}

	/**
	 * @author https://github.com/vincenzopalazzo
	 * The method takes an integer variable that for the createIncreaseButton 
	 * method takes 5 if the scrollbar is horizontal and 3 if vertical
	 */
	@Override
	protected JButton createIncreaseButton (int orientation) {
		JButton button = new BasicArrowButton (orientation);

		button.setOpaque (true);
		button.setBackground (UIManager.getColor ("ScrollBar.arrowButtonBackground"));
		button.setBorder (UIManager.getBorder ("ScrollBar.arrowButtonBorder"));

		return button;
	}
}