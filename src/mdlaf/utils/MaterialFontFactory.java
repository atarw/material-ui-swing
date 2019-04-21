/*
 * MIT License
 *
 * Copyright (c) 2018 Vincent Palazzo vincenzopalazzodev@gmail.com
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package mdlaf.utils;

import java.awt.*;
import java.awt.font.TextAttribute;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * @author https://github.com/vincenzopalazzo
 */
public class MaterialFontFactory {

    /**
     * Tipe OS supported
     * @author https://github.com/vincenzopalazzo
     * LINUX, WINDOWS, MAC
     */
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

    public static MaterialFontFactory getInstance() {
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

    /**
     * This method was to change the font based on the operating system because there
     * was a bug for the well-known font, it was tinted pixeled,
     * but now this problem has been solved and therefore there is no need to carry around
     * Many dependencies, native fonts are removed from the project but this method remains for furious purposes
     * @throws IOException
     */
    private void loadOsPropries() throws IOException {
        String os = System.getProperty("os.name", "generic").toLowerCase();
        String osSupport = osSupportted(os);
        osSupport = null; //TODO DISABLE FONT NATIVE, AND ENABLE NOTO FONT
        if (osSupport != null) {
            String pathProperties = "/resources/config/font-" + osSupport + ".properties";
            properties.load(getClass().getResourceAsStream(pathProperties));
            return;
        }
        properties.load(getClass().getResourceAsStream("/resources/config/font-all-language.properties"));
    }

    private String osSupportted(String os) {
        for (int i = 0; i < SISTEM_SUPPORTED.length; i++) {
            if (os.contains(SISTEM_SUPPORTED[i])) {
                return SISTEM_SUPPORTED[i];
            }
        }
        return null;
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

    /**
     * Fix the problem with this post
     * https://stackoverflow.com/questions/5829703/java-getting-a-font-with-a-specific-height-in-pixels
     * @author https://github.com/vincenzopalazzo
     */
    private Font loadFont(String fontPath) {
        if (fontSettings.isEmpty()) {
            fontSettings.put (TextAttribute.SIZE, new Float( 11 * Toolkit.getDefaultToolkit().getScreenResolution() / 72.0));
            //fontSettings.put (TextAttribute.SIZE, new Float( 14f));
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
