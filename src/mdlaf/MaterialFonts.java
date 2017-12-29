package mdlaf;

import java.awt.Font;
import java.awt.FontFormatException;
import java.io.IOException;
import java.io.InputStream;

public class MaterialFonts {

	private static final float DEFAULT_FONT_SIZE = 14f;

	public static final Font BLACK = loadFont ("/fonts/Roboto-Black.ttf").deriveFont (DEFAULT_FONT_SIZE);
	public static final Font BLACK_ITALIC = loadFont ("/fonts/Roboto-BlackItalic.ttf").deriveFont (DEFAULT_FONT_SIZE);
	public static final Font BOLD = loadFont ("/fonts/Roboto-Bold.ttf").deriveFont (DEFAULT_FONT_SIZE);
	public static final Font BOLD_ITALIC = loadFont ("/fonts/Roboto-BoldItalic.ttf").deriveFont (DEFAULT_FONT_SIZE);
	public static final Font ITALIC = loadFont ("/fonts/Roboto-Italic.ttf").deriveFont (DEFAULT_FONT_SIZE);
	public static final Font LIGHT = loadFont ("/fonts/Roboto-Light.ttf").deriveFont (DEFAULT_FONT_SIZE);
	public static final Font LIGHT_ITALIC = loadFont ("/fonts/Roboto-LightItalic.ttf").deriveFont (DEFAULT_FONT_SIZE);
	public static final Font MEDIUM = loadFont ("/fonts/Roboto-Medium.ttf").deriveFont (DEFAULT_FONT_SIZE);
	public static final Font MEDIUM_ITALIC = loadFont ("/fonts/Roboto-MediumItalic.ttf").deriveFont (DEFAULT_FONT_SIZE);
	public static final Font REGULAR = loadFont ("/fonts/Roboto-Regular.ttf").deriveFont (DEFAULT_FONT_SIZE);
	public static final Font THIN = loadFont ("/fonts/Roboto-Thin.ttf").deriveFont (DEFAULT_FONT_SIZE);
	public static final Font THIN_ITALIC = loadFont ("/fonts/Roboto-ThinItalic.ttf").deriveFont (DEFAULT_FONT_SIZE);

	private static Font loadFont (String fontPath) {
		try (InputStream inputStream = MaterialFonts.class.getResourceAsStream (fontPath)) {
			return Font.createFont (Font.TRUETYPE_FONT, inputStream);
		}
		catch (IOException | FontFormatException e) {
			e.printStackTrace ();
			throw new RuntimeException ("Font " + fontPath + " wasn't loaded");
		}
	}
}
