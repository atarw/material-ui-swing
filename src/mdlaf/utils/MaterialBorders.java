package mdlaf.utils;

import mdlaf.shadows.DropShadowBorder;

import javax.swing.BorderFactory;
import javax.swing.border.Border;
import java.awt.*;

public class MaterialBorders {

	public static final Border LIGHT_LINE_BORDER = BorderFactory.createLineBorder (MaterialColors.GRAY_200, 1);
	public static final Border RECTANGLE_ROUND_BORDER = new RoundedBorder();
	public static final Border LIGHT_SHADOW_BORDER = new DropShadowBorder (Color.BLACK, 0, 4, 0.3f, 12, true, true, true, true);
	public static final Border DEFAULT_SHADOW_BORDER = new DropShadowBorder (Color.BLACK, 5, 5, 0.3f, 12, true, true, true, true);


	private MaterialBorders () {}

	private static class RoundedBorder implements Border {

		private int radius = 7;

		@Override
		public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
			g.drawRoundRect(0, 0, c.getWidth(), c.getHeight(), radius, radius);
		}

		@Override
		public Insets getBorderInsets(Component c) {
			return new Insets(0, 0,0, 0);
		}

		@Override
		public boolean isBorderOpaque() {
			return true;
		}
	}
}
