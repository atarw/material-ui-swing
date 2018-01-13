package mdlaf;

import java.awt.Color;

public class MaterialColors {

	public static final Color LIGHT_GRAY = new Color (230, 230, 230);
	public static final Color LIGHT_BLUE = new Color (25, 181, 254);

	public static Color bleach (Color color, float amount) {
		int red = (int) ((color.getRed () * (1 - amount) / 255 + amount) * 255);
		int green = (int) ((color.getGreen () * (1 - amount) / 255 + amount) * 255);
		int blue = (int) ((color.getBlue () * (1 - amount) / 255 + amount) * 255);
		return new Color (red, green, blue);
	}
}
