package mdlaf.utils;

import java.awt.*;
import java.awt.font.TextAttribute;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class MaterialFonts {

	private static final Map<TextAttribute, Object> fontSettings = new HashMap<TextAttribute, Object> ();

	public static final Font BLACK = loadFont (mdlaf.MaterialLookAndFeel.getMaterialResurceManager().getStringResource("BLACK"));
	public static final Font BLACK_ITALIC = loadFont (mdlaf.MaterialLookAndFeel.getMaterialResurceManager().getStringResource("BLACK_ITALIC"));
	public static final Font BOLD = loadFont (mdlaf.MaterialLookAndFeel.getMaterialResurceManager().getStringResource("BOLD"));
	public static final Font BOLD_ITALIC = loadFont (mdlaf.MaterialLookAndFeel.getMaterialResurceManager().getStringResource("BOLD_ITALIC"));
	public static final Font ITALIC = loadFont (mdlaf.MaterialLookAndFeel.getMaterialResurceManager().getStringResource("ITALIC"));
	public static final Font LIGHT = loadFont (mdlaf.MaterialLookAndFeel.getMaterialResurceManager().getStringResource("LIGHT"));
	public static final Font LIGHT_ITALIC = loadFont (mdlaf.MaterialLookAndFeel.getMaterialResurceManager().getStringResource("LIGHT_ITALIC"));
	public static final Font MEDIUM = loadFont (mdlaf.MaterialLookAndFeel.getMaterialResurceManager().getStringResource("MEDIUM"));
	public static final Font MEDIUM_ITALIC = loadFont (mdlaf.MaterialLookAndFeel.getMaterialResurceManager().getStringResource("MEDIUM_ITALIC"));
	public static final Font REGULAR = loadFont (mdlaf.MaterialLookAndFeel.getMaterialResurceManager().getStringResource("REGULAR"));
	public static final Font THIN = loadFont (mdlaf.MaterialLookAndFeel.getMaterialResurceManager().getStringResource("THIN"));
	public static final Font THIN_ITALIC = loadFont (mdlaf.MaterialLookAndFeel.getMaterialResurceManager().getStringResource("THIN_ITALIC"));

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
