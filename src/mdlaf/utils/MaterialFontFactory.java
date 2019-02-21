package mdlaf.utils;

import java.awt.*;
import java.awt.font.TextAttribute;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * @author https://github.com/vincenzopalazzo
 */
public class MaterialFontFactory {

    //OS supported
    private static final String[] SISTEM_SUPPORTED = {"linux", "windows", "mac"};
    private static final Map<TextAttribute, Object> fontSettings = new HashMap<TextAttribute, Object>();
    /**
     * Tipe Font supported
     * @author https://github.com/vincenzopalazzo
     * REGULAR, ITALIC, BOLD, MEDIUM
     */
    public static final String REGULAR = "REGULAR";
    public static final String BOLD = "BOLD";
    public static final String ITALIC = "ITALIC";
    public static final String MEDIUM = "MEDIUM";

    private static MaterialFontFactory SINGLETON;

    public static MaterialFontFactory getIstance() {
        if (SINGLETON == null) {
            SINGLETON = new MaterialFontFactory();
        }
        return SINGLETON;
    }

    private Properties properties = new Properties();
    private Map<String, Font> cacheFont = new HashMap<>();

    private MaterialFontFactory() {
        try {
            loadOsPropries();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadOsPropries() throws IOException {
        String os = System.getProperty("os.name", "generic").toLowerCase();
        String pathProperties = "/resources/config/font-" + os + ".properties";
        if (isOsSupportted(os)) {
            properties.load(getClass().getResourceAsStream(pathProperties));
            return;
        }
        properties.load(getClass().getResourceAsStream("resources/config/font-linux.properties"));
    }

    private boolean isOsSupportted(String os) {
        for (int i = 0; i < SISTEM_SUPPORTED.length; i++) {
            if (os.equals(SISTEM_SUPPORTED[i])) {
                return true;
            }
        }
        return false;
    }

    public Font getFont(String typeFont){
        if(typeFont == null){
            throw new IllegalArgumentException("Argument null");
        }
        if(cacheFont.containsKey(typeFont)){
            return cacheFont.get(typeFont);
        }
        String propieties =properties.getProperty(typeFont);
        Font font = loadFont(propieties);
        cacheFont.put(typeFont, font);
        return cacheFont.get(typeFont);
    }

    private Font loadFont(String fontPath) {
        if (fontSettings.isEmpty()) {
            fontSettings.put(TextAttribute.SIZE, 14f);
            fontSettings.put(TextAttribute.KERNING, TextAttribute.KERNING_ON);
        }

        try {
            Font font = Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream(fontPath)).deriveFont(fontSettings);
            font.deriveFont(12f);
            return font;
        } catch (IOException | FontFormatException e) {
            e.printStackTrace();
            throw new RuntimeException("Font " + fontPath + " wasn't loaded");
        }
    }
}
