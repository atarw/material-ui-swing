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
	
	private static boolean DEBUG = false;

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
	
	/**
	 * @author https://github.com/vincenzopalazzo
	 * The method takes an integer variable that for the createDecreaseButton 
	 * method takes 7 if the scrollbar is horizontal and 1 if vertical
	 */
	@Override
	protected JButton createDecreaseButton (int orientation) {
		JButton button = new JButton ();
		if(DEBUG == true) System.out.println("orientation decrese: " + orientation);
		if(orientation == 7) {
			if(DEBUG == true) System.out.println("orientation decrese down: " + orientation);
			button = new JButton (new ImageIcon (MaterialImages.LEFTH_ARROW));
		}else {
			if(DEBUG == true) System.out.println("orientation decrese right: " + orientation);
			button = new JButton (new ImageIcon (MaterialImages.UP_ARROW));
		}

		button.setOpaque (true);
		button.setBackground (MaterialColors.GRAY_300);
		button.setBorder (BorderFactory.createEmptyBorder ());

		return button;
	}

	/**
	 * @author https://github.com/vincenzopalazzo
	 * The method takes an integer variable that for the createIncreaseButton 
	 * method takes 5 if the scrollbar is horizontal and 3 if vertical
	 */
	@Override
	protected JButton createIncreaseButton (int orientation) {
		JButton button = new JButton ();
		if(DEBUG == true) System.out.println("orientation increse: " + orientation);
		if(orientation == 5) {
			if(DEBUG == true) System.out.println("orientation decrese up: " + orientation);
			button = new JButton (new ImageIcon (MaterialImages.DOWN_ARROW));
		}else {
			if(DEBUG == true) System.out.println("orientation decrese lefth: " + orientation);
			button = new JButton (new ImageIcon (MaterialImages.RIGHT_ARROW));
		}
		button.setOpaque (true);
		button.setBackground (MaterialColors.GRAY_300);
		button.setBorder (BorderFactory.createEmptyBorder ());

		return button;
	}
}