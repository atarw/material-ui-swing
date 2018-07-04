package mdlaf.components.scrollbar;

import javafx.scene.paint.Material;
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
import java.awt.Color;
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
		thumbColor = MaterialColors.LIGHT_GRAY;
	}

	@Override
	public void paint (Graphics g, JComponent c) {
		super.paint (MaterialDrawingUtils.getAliasedGraphics (g), c);
	}

	@Override
	protected JButton createDecreaseButton (int orientation) {
		JButton button = new JButton (new ImageIcon (MaterialImages.UP_ARROW));

		button.setOpaque (true);
		button.setBackground (MaterialColors.LIGHT_GRAY);
		button.setBorder (BorderFactory.createEmptyBorder ());

		return button;
	}

	@Override
	protected JButton createIncreaseButton (int orientation) {
		JButton button = new JButton (new ImageIcon (MaterialImages.DOWN_ARROW));

		button.setOpaque (true);
		button.setBackground (MaterialColors.LIGHT_GRAY);
		button.setBorder (BorderFactory.createEmptyBorder ());

		return button;
	}

	/*@Override
	protected void paintTrack (Graphics g, JComponent c, Rectangle trackBounds) {
		g.setColor (Color.RED);
		g.fillRect (trackBounds.x, trackBounds.y, trackBounds.width, trackBounds.height);
	}*/

	/*@Override
	protected void paintThumb (Graphics g, JComponent c, Rectangle thumbBounds) {

	}*/
}