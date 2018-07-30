package mdlaf.components.slider;

import mdlaf.resources.MaterialBorders;
import mdlaf.resources.MaterialDrawingUtils;
import mdlaf.resources.MaterialFonts;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JSlider;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicSliderUI;
import java.awt.Color;
import java.awt.Graphics;

public class MaterialSliderUI extends BasicSliderUI {

	public MaterialSliderUI (JSlider slider) {
		super (slider);
	}

	public static ComponentUI createUI (JComponent c) {
		return new MaterialSliderUI ((JSlider) c);
	}

	@Override
	public void installUI (JComponent c) {
		super.installUI (c);

		JSlider slider = (JSlider) c;
		slider.setFont (MaterialFonts.REGULAR);
		slider.setBackground (Color.RED);
		slider.setForeground (Color.BLACK);
		slider.setBorder (BorderFactory.createCompoundBorder (MaterialBorders.LIGHT_LINE_BORDER, BorderFactory.createEmptyBorder (5, 5, 5, 5)));
	}

	/*@Override
	public void paintThumb (Graphics g) {
		g = MaterialDrawingUtils.getAliasedGraphics (g);
		g.setColor (Color.RED);
		g.fillOval (this.thumbRect.x, this.thumbRect.y, this.getThumbSize ().height, this.getThumbSize ().height);
	}

	@Override
	public void paintTrack (Graphics g) {
		g = MaterialDrawingUtils.getAliasedGraphics (g);
		g.setColor (this.slider.getForeground ());

		g.drawLine (this.trackRect.x, this.trackRect.y + this.trackRect.height / 2, this.trackRect.x + this.trackRect.width, this.trackRect.y + this.trackRect.height / 2);
	}*/

	@Override
	public void paintFocus (Graphics g) {

	}

	@Override
	public void paint (Graphics g, JComponent c) {
		super.paint (MaterialDrawingUtils.getAliasedGraphics (g), c);
	}
}
