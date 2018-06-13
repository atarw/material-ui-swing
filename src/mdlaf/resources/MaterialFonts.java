package mdlaf.resources;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.font.TextAttribute;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class MaterialFonts {

	private static final Map<TextAttribute, Object> fontSettings = new HashMap<TextAttribute, Object> ();

	// executes after static block in MaterialLookAndFeel
	static {
		fontSettings.put (TextAttribute.SIZE, 14f);
		fontSettings.put (TextAttribute.KERNING, TextAttribute.KERNING_ON);
	}

	public static final Font BLACK = loadFont ("/fonts/Roboto-Black.ttf");
	public static final Font BLACK_ITALIC = loadFont ("/fonts/Roboto-BlackItalic.ttf");
	public static final Font BOLD = loadFont ("/fonts/Roboto-Bold.ttf");
	public static final Font BOLD_ITALIC = loadFont ("/fonts/Roboto-BoldItalic.ttf");
	public static final Font ITALIC = loadFont ("/fonts/Roboto-Italic.ttf");
	public static final Font LIGHT = loadFont ("/fonts/Roboto-Light.ttf");
	public static final Font LIGHT_ITALIC = loadFont ("/fonts/Roboto-LightItalic.ttf");
	public static final Font MEDIUM = loadFont ("/fonts/Roboto-Medium.ttf");
	public static final Font MEDIUM_ITALIC = loadFont ("/fonts/Roboto-MediumItalic.ttf");
	public static final Font REGULAR = loadFont ("/fonts/Roboto-Regular.ttf");
	public static final Font THIN = loadFont ("/fonts/Roboto-Thin.ttf");
	public static final Font THIN_ITALIC = loadFont ("/fonts/Roboto-ThinItalic.ttf");

	private static Font loadFont (String fontPath) {
		try (InputStream inputStream = MaterialFonts.class.getResourceAsStream (fontPath)) {
			return Font.createFont (Font.TRUETYPE_FONT, inputStream).deriveFont (fontSettings);
		}
		catch (IOException | FontFormatException e) {
			e.printStackTrace ();
			throw new RuntimeException ("Font " + fontPath + " wasn't loaded");
		}
	}

	private MaterialFonts () {}
}
