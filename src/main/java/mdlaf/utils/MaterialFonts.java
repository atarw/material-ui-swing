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

	public static final Font BOLD = loadFont("/fonts/DejavuSans/DejaVuSans-Bold.ttf");
    public static final Font ITALIC = loadFont("/fonts/DejavuSans/DejaVuSans-Oblique.ttf");
    public static final Font LIGHT = loadFont("/fonts/DejavuSans/DejaVuSans-ExtraLight.ttf");
	public static final Font MEDIUM = loadFont("/fonts/DejavuSans/DejaVuSansCondensed.ttf");
	public static final Font REGULAR = loadFont("/fonts/DejavuSans/DejaVuSans.ttf");

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
