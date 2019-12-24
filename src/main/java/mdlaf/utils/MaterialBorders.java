package mdlaf.utils;

import mdlaf.shadows.DropShadowBorder;
import mdlaf.shadows.RoundedCornerBorder;
import mdlaf.utils.MaterialColors;

import javax.swing.BorderFactory;
import javax.swing.border.Border;
import javax.swing.plaf.BorderUIResource;
import java.awt.*;

/**
 * @author https://github.com/vincenzopalazzo
 * @author https://github.com/atarw
 */
public class MaterialBorders {

	public static final BorderUIResource LIGHT_LINE_BORDER = new BorderUIResource(BorderFactory.createLineBorder(MaterialColors.GRAY_200, 1));
	public static final BorderUIResource DARK_LINE_BORDER = new BorderUIResource(BorderFactory.createLineBorder(MaterialColors.COSMO_BLACK, 1));
	public static final BorderUIResource OCEAN_LINE_BORDER = new BorderUIResource(BorderFactory.createLineBorder(MaterialColors.DARKLY_STRONG_BLUE, 1));
	public static final BorderUIResource LIGHT_SHADOW_BORDER = new BorderUIResource(
			new DropShadowBorder(Color.BLACK, 0, 4, 0.3f, 12,
					true, true, true, true));
	public static final BorderUIResource DEFAULT_SHADOW_BORDER = new BorderUIResource(
			new DropShadowBorder(Color.BLACK, 5, 5, 0.3f, 12,
					true, true, true, true));
	public static final BorderUIResource ROUNDED_CORNER_BORDER = new BorderUIResource(new RoundedCornerBorder());

	private MaterialBorders() {
	}

	public static BorderUIResource roundedLineColorBorder(Color colorLine){
		if(colorLine == null){
			throw new IllegalArgumentException("The color line is null");
		}
		return roundedLineColorBorder(colorLine, 12);
	}

	public static BorderUIResource roundedLineColorBorder(Color colorLine, int arch){
		if(colorLine == null){
			throw new IllegalArgumentException("The color line is null");
		}
		return new BorderUIResource(new RoundedCornerBorder(colorLine, arch));
	}
}

