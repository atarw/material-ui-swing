package mdlaf.animation;

import javax.swing.JComponent;
import java.awt.Color;

public class MaterialUIMovement {

	private MaterialUIMovement () {}

	public static void add (JComponent c, Color fadeTo, int steps, int interval) {
		new MaterialUITimer (c, fadeTo, steps, interval);
	}

	public static void add (JComponent c, Color fadeTo) {
		add (c, fadeTo, 5, 1000 / 30);
	}
}
