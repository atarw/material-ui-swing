package mdlaf.components.slider;

import mdlaf.utils.MaterialColors;
import mdlaf.utils.MaterialDrawingUtils;

import javax.swing.JComponent;
import javax.swing.JSlider;
import javax.swing.UIManager;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicSliderUI;
import java.awt.Dimension;
import java.awt.Graphics;

//TODO cambio grafica slider
public class MaterialSliderUI extends BasicSliderUI {

	private static final int NORMAL_THUMB_RADIUS = 7;
	private static final int DRAG_THUMB_RADIUS = 14;
	private static final Dimension THUMB_SIZE = new Dimension (DRAG_THUMB_RADIUS * 2, DRAG_THUMB_RADIUS * 2);

	public MaterialSliderUI (JSlider slider) {
		super (slider);
	}

	public static ComponentUI createUI (JComponent c) {
		return new MaterialSliderUI ((JSlider) c);
	}

	private static void drawCircle (Graphics g, int x, int y, int radius) {
		g.fillOval (x - radius, y - radius, radius * 2, radius * 2);
	}

	@Override
	public void installUI (JComponent c) {
		super.installUI (c);

		JSlider slider = (JSlider) c;
		slider.setFont (UIManager.getFont ("Slider.font"));
		slider.setBackground (UIManager.getColor ("Slider.background"));
		slider.setForeground (UIManager.getColor ("Slider.foreground"));
		slider.setBorder (UIManager.getBorder ("Slider.border"));
	}

	@Override
	public Dimension getThumbSize () {
		return THUMB_SIZE;
	}

	@Override
	public void paintThumb (Graphics g) {
		g = MaterialDrawingUtils.getAliasedGraphics (g);

		int cx = thumbRect.x + thumbRect.width / 2;
		int cy = thumbRect.y + thumbRect.height / 2;

		if (isDragging ()) {
			g.setColor (MaterialColors.bleach (slider.getForeground (), 0.5f));
			drawCircle (g, cx, cy, DRAG_THUMB_RADIUS);
		}

		g.setColor (slider.getForeground ());
		drawCircle (g, cx, cy, NORMAL_THUMB_RADIUS);

		// need to redraw loaded part of progress line
		Line loaded = getTrack (true);
		g.drawLine (loaded.x1, loaded.y1, loaded.x2, loaded.y2);
	}

	@Override
	public void paintTrack (Graphics g) {
		g = MaterialDrawingUtils.getAliasedGraphics (g);

		g.setColor (UIManager.getColor ("Slider.trackColor"));
		Line unloaded = getTrack (false);
		g.drawLine (unloaded.x1, unloaded.y1, unloaded.x2, unloaded.y2);

		g.setColor (slider.getForeground ());
		Line loaded = getTrack (true);
		g.drawLine (loaded.x1, loaded.y1, loaded.x2, loaded.y2);
	}

	private Line getTrack (boolean loaded) {
		if (slider.getOrientation () == JSlider.HORIZONTAL) {
			Line left = new Line (trackRect.x, thumbRect.y + thumbRect.height / 2, thumbRect.x + thumbRect.width / 2, thumbRect.y + thumbRect.height / 2);
			Line right = new Line (thumbRect.x + thumbRect.width / 2, thumbRect.y + thumbRect.height / 2, trackRect.x + trackRect.width, thumbRect.y + thumbRect.height / 2);

			if (loaded) {
				return slider.getInverted () ? right : left;
			}
			else {
				return slider.getInverted () ? left : right;
			}
		}
		else {
			Line top = new Line (thumbRect.x + thumbRect.width / 2, trackRect.y, thumbRect.x + thumbRect.width / 2, thumbRect.y + thumbRect.height / 2);
			Line bottom = new Line (thumbRect.x + thumbRect.width / 2, thumbRect.y + thumbRect.height / 2, thumbRect.x + thumbRect.width / 2, trackRect.y + trackRect.height);

			if (loaded) {
				return slider.getInverted () ? top : bottom;
			}
			else {
				return slider.getInverted () ? bottom : top;
			}
		}
	}

	@Override
	public void paintFocus (Graphics g) {

	}

	@Override
	public void paint (Graphics g, JComponent c) {
		super.paint (MaterialDrawingUtils.getAliasedGraphics (g), c);
	}

	private static class Line {

		int x1, y1, x2, y2;

		Line (int x1, int y1, int x2, int y2) {
			this.x1 = x1;
			this.y1 = y1;
			this.x2 = x2;
			this.y2 = y2;
		}
	}
}
