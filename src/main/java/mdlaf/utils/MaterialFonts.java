package mdlaf.utils;

import java.awt.*;
import java.awt.font.TextAttribute;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class MaterialFonts {

	private static final Map<TextAttribute, Object> fontSettings = new HashMap<TextAttribute, Object> ();

	public static final Font BLACK = loadFont ("/main/resources/fonts/NotoSansDisplay/NotoSansDisplay-Black.ttf");
	public static final Font BLACK_ITALIC = loadFont ("/main/resources/fonts/NotoSansDisplay/NotoSansDisplay-BlackItalic.ttf");
	public static final Font BOLD = loadFont ("/main/resources/fonts/NotoSansDisplay/NotoSansDisplay-Bold.ttf");
	public static final Font BOLD_ITALIC = loadFont ("/main/resources/fonts/NotoSansDisplay/NotoSansDisplay-BoldItalic.ttf");
	public static final Font ITALIC = loadFont ("/main/resources/fonts/NotoSansDisplay/NotoSansDisplay-Italic.ttf");
	public static final Font LIGHT = loadFont ("/main/resources/fonts/NotoSansDisplay/NotoSansDisplay-Light.ttf");
	public static final Font LIGHT_ITALIC = loadFont ("/main/resources/fonts/NotoSansDisplay/NotoSansDisplay-LightItalic.ttf");
	public static final Font MEDIUM = loadFont ("/main/resources/fonts/NotoSansDisplay/NotoSansDisplay-Medium.ttf");
	public static final Font MEDIUM_ITALIC = loadFont ("/main/resources/fonts/NotoSansDisplay/NotoSansDisplay-MediumItalic.ttf");
	public static final Font REGULAR = loadFont ("/main/resources/fonts/NotoSansDisplay/NotoSansDisplay-Regular.ttf");
	public static final Font THIN = loadFont ("/main/resources/fonts/NotoSansDisplay/NotoSansDisplay-Thin.ttf");
	public static final Font THIN_ITALIC = loadFont ("/main/resources/fonts/NotoSansDisplay/NotoSansDisplay-ThinItalic.ttf");

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
