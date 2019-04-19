package mdlaf.components.scrollbar;

import mdlaf.animation.MaterialUIMovement;
import mdlaf.utils.*;
import javax.swing.*;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicScrollBarUI;
import java.awt.*;

/*
 * @contributor by https://github.com/downToHell
 * @contributor for refactoring by https://github.com/vincenzopalazzo
 */
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

	@Override
	protected void configureScrollBarColors() {
		super.configureScrollBarColors();
		thumbDarkShadowColor = UIManager.getColor ("ScrollBar.thumbDarkShadow");
		thumbHighlightColor = UIManager.getColor ("ScrollBar.thumbHighlight");
		thumbLightShadowColor = UIManager.getColor ("ScrollBar.thumbShadow");
	}

	private void setIconArrowButton(JButton button, int orientation) {
		if(button == null){
			throw new IllegalArgumentException("Input null");
		}
		if (orientation == SwingConstants.NORTH){
			button.setIcon(new ImageIcon(MaterialImageFactory.getInstance().getImage(MaterialImageFactory.UP_ARROW)));
			return;
		}else if(orientation == SwingConstants.SOUTH){
			button.setIcon(new ImageIcon(MaterialImageFactory.getInstance().getImage(MaterialImageFactory.DOWN_ARROW)));
			return;
		}else if(orientation == SwingConstants.EAST){
			button.setIcon(new ImageIcon(MaterialImageFactory.getInstance().getImage(MaterialImageFactory.RIGHT_ARROW)));
			return;
		}else if(orientation == SwingConstants.WEST){
			button.setIcon(new ImageIcon(MaterialImageFactory.getInstance().getImage(MaterialImageFactory.LEFT_ARROW)));
			return;
		}
		throw new IllegalArgumentException("orientation not valid");
	}

	private void createInvisibleButton(JComponent component){
		if(component == null){
			throw new IllegalArgumentException("Argument function null");
		}
		component.setPreferredSize(new Dimension(0, 0));
		component.setMinimumSize(new Dimension(0, 0));
		component.setMaximumSize(new Dimension(0, 0));
	}

	protected JButton installButton(int orientation){
		JButton button = new JButton();
		MaterialManagerListener.removeAllMouseListener(button);
		button.setOpaque (true);
		button.setBackground (UIManager.getColor ("ScrollBar.arrowButtonBackground"));
		if(!UIManager.getBoolean("ScrollBar.enableArrow")){
			createInvisibleButton(button);
			return button;
		}
		setIconArrowButton(button, orientation);
		if(UIManager.getBoolean("ScrollBar[MouseHover].enable")){
			button.addMouseListener(MaterialUIMovement.getStaticMovement(button,UIManager.getColor("ScrollBar[MouseHover].color"),
					UIManager.getColor("ScrollBar[OnClick].color")));
		}
		button.setBorder (UIManager.getBorder("ScrollBar.arrowButtonBorder"));
		return button;
	}
}