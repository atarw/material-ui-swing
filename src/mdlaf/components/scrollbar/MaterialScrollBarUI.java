package mdlaf.components.scrollbar;

import mdlaf.animation.MaterialUIMovement;
import mdlaf.utils.MaterialBorders;
import mdlaf.utils.MaterialColors;
import mdlaf.utils.MaterialDrawingUtils;
import mdlaf.utils.MaterialManagerListener;

import javax.swing.*;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicArrowButton;
import javax.swing.plaf.basic.BasicScrollBarUI;
import java.awt.*;

/*
 * Contributed by https://github.com/downToHell
 * Contributed for refactoring by https://github.com/vincenzopalazzo
 * */

public class MaterialScrollBarUI extends BasicScrollBarUI {

	public static ComponentUI createUI (JComponent c) {
		return new MaterialScrollBarUI ();
	}

	@Override
	public void installUI (JComponent c) {
		super.installUI (c);
	}

	@Override
	public void paint (Graphics g, JComponent c) {
		super.paint (MaterialDrawingUtils.getAliasedGraphics (g), c);
	}

	@Override
	protected JButton createDecreaseButton (int orientation) {
		return installButton(orientation);
	}

	@Override
	protected JButton createIncreaseButton (int orientation) {
		return installButton(orientation);
	}

	@Override
	protected void paintTrack(Graphics g, JComponent c, Rectangle trackBounds) {
		super.paintTrack(g, c, trackBounds);
		g.setColor(UIManager.getColor ("ScrollBar.track"));
	}

	@Override
	protected void paintThumb(Graphics g, JComponent c, Rectangle thumbBounds) {
		super.paintThumb(g, c, thumbBounds);
		g.setColor(UIManager.getColor ("ScrollBar.thumb"));

	}

	/**
	 * Method service for not duplicate code
	 * @author https://github.com/vincenzopalazzo
	 * @param orientation
	 * @return JButton with correct orientation
	 */
	private JButton installButton(int orientation){
		JButton button = new BasicArrowButton (orientation);
		MaterialManagerListener.removeAllMouseListener(button);
		button.setOpaque (true);
		button.setBackground (UIManager.getColor ("ScrollBar.arrowButtonBackground"));
		if(UIManager.getBoolean("ScrollBar[MouseHover].enable")){
			button.addMouseListener(MaterialUIMovement.getStaticMovement(button,UIManager.getColor("ScrollBar[MouseHover].color"),
					UIManager.getColor("ScrollBar[OnClick].color")));
		}
		button.setBorder (BorderFactory.createMatteBorder(button.getX() + 1, button.getY() + 1, button.getWidth() + 1, button.getHeight() + 1, button.getBackground()));
		return button;
	}



	@Override
	protected void configureScrollBarColors() {
		super.configureScrollBarColors();
		thumbDarkShadowColor = UIManager.getColor ("ScrollBar.thumbDarkShadow");
		thumbHighlightColor = UIManager.getColor ("ScrollBar.thumbHighlight");
		thumbLightShadowColor = UIManager.getColor ("ScrollBar.thumbShadow");
	}
}