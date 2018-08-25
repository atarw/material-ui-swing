package mdlaf.utils;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.font.TextAttribute;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class MaterialFonts {

	private static final Map<TextAttribute, Object> fontSettings = new HashMap<TextAttribute, Object> ();

	public static final Font BLACK = loadFont ("/resources/fonts/Roboto-Black.ttf");
	public static final Font BLACK_ITALIC = loadFont ("/resources/fonts/Roboto-BlackItalic.ttf");
	public static final Font BOLD = loadFont ("/resources/fonts/Roboto-Bold.ttf");
	public static final Font BOLD_ITALIC = loadFont ("/resources/fonts/Roboto-BoldItalic.ttf");
	public static final Font ITALIC = loadFont ("/resources/fonts/Roboto-Italic.ttf");
	public static final Font LIGHT = loadFont ("/resources/fonts/Roboto-Light.ttf");
	public static final Font LIGHT_ITALIC = loadFont ("/resources/fonts/Roboto-LightItalic.ttf");
	public static final Font MEDIUM = loadFont ("/resources/fonts/Roboto-Medium.ttf");
	public static final Font MEDIUM_ITALIC = loadFont ("/resources/fonts/Roboto-MediumItalic.ttf");
	public static final Font REGULAR = loadFont ("/resources/fonts/Roboto-Regular.ttf");
	public static final Font THIN = loadFont ("/resources/fonts/Roboto-Thin.ttf");
	public static final Font THIN_ITALIC = loadFont ("/resources/fonts/Roboto-ThinItalic.ttf");

	private static Font loadFont (String fontPath) {
		if (fontSettings.isEmpty ()) {
			fontSettings.put (TextAttribute.SIZE, 14f);
			fontSettings.put (TextAttribute.KERNING, TextAttribute.KERNING_ON);
		}

		try (InputStream inputStream = MaterialFonts.class.getResourceAsStream (fontPath)) {
			return Font.createFont (Font.TRUETYPE_FONT, inputStream).deriveFont (fontSettings);
		}
		catch (IOException | FontFormatException e) {
			e.printStackTrace ();
			throw new RuntimeException ("Font " + fontPath + " wasn't loaded");
		}
	}
}
