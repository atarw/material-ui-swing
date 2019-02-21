package mdlaf.utils;

import java.awt.*;
import java.awt.font.TextAttribute;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Map;

public class MaterialFonts {

    private static final Map<TextAttribute, Object> fontSettings = new HashMap<TextAttribute, Object>();

    public static final Font BOLD = loadFont("/resources/fonts/DejavuSans/DejaVuSans-Bold.ttf");

    public static final Font ITALIC = loadFont("/resources/fonts/DejavuSans/DejaVuSansCondensed.ttf");

    public static final Font MEDIUM = loadFont("/resources/fonts/DejavuSans/DejaVuSansCondensed.ttf");

    public static final Font REGULAR = loadFont("/resources/fonts/DejavuSans/DejaVuSans.ttf");

    private static Font loadFont(String fontPath) {
        if (fontSettings.isEmpty()) {
            fontSettings.put(TextAttribute.SIZE, 14f);
            fontSettings.put(TextAttribute.KERNING, TextAttribute.KERNING_ON);
        }

        try (InputStream inputStream = MaterialFonts.class.getResourceAsStream(fontPath)) {
            return Font.createFont(Font.TRUETYPE_FONT, inputStream).deriveFont(fontSettings);
        } catch (IOException | FontFormatException e) {
            e.printStackTrace();
            throw new RuntimeException("Font " + fontPath + " wasn't loaded");
        }
    }
}
