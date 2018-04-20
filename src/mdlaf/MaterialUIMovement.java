package mdlaf;

import javax.swing.JComponent;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public class MaterialUIMovement {

	private static List<Color> getColors (Color background, Color fadeTo, int steps) {
		List<Color> colors = new ArrayList<Color> (steps + 1);
		colors.add (background);

		int rDelta = (background.getRed () - fadeTo.getRed ()) / steps;
		int gDelta = (background.getGreen () - fadeTo.getGreen ()) / steps;
		int bDelta = (background.getBlue () - fadeTo.getBlue ()) / steps;
		int aDelta = (background.getAlpha () - fadeTo.getAlpha ()) / steps;

		for (int i = 1; i < steps; ++i) {
			int rValue = background.getRed () - (i * rDelta);
			int gValue = background.getGreen () - (i * gDelta);
			int bValue = background.getBlue () - (i * bDelta);
			int aValue = background.getAlpha () - (i * aDelta);

			colors.add (new Color (rValue, gValue, bValue, aValue));
		}

		colors.add (fadeTo);

		return colors;
	}

	public static void add (JComponent c, Color fadeTo, int steps, int interval) {
		new MaterialUITimer (getColors (c.getBackground (), fadeTo, steps), c, interval);
	}

	private MaterialUIMovement () {}
}
