/*
 * MIT License
 *
 * Copyright (c) 2018-2020 Vincenzo Palazzo vincenzopalazzodev@gmail.com
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

import sun.swing.SwingUtilities2;

import javax.swing.*;
import javax.swing.plaf.FontUIResource;
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

    private static final Map<TextAttribute, Object> fontSettings = new HashMap<TextAttribute, Object>();

    public static final MaterialTypeFont REGULAR = MaterialTypeFont.REGULAR;
    public static final MaterialTypeFont BOLD = MaterialTypeFont.BOLD;
    public static final MaterialTypeFont ITALIC = MaterialTypeFont.ITALIC;
    public static final MaterialTypeFont MEDIUM = MaterialTypeFont.MEDIUM;

    private static MaterialFontFactory SINGLETON;

    public static MaterialFontFactory getInstance() {
        if (SINGLETON == null) {
            SINGLETON = new MaterialFontFactory();
        }
        return SINGLETON;
    }

    public static Font fontUtilsDisplayable(String textDisplayable, Font withFont){
        if(textDisplayable == null || withFont == null){
            throw new IllegalArgumentException("Argument at the fontUtilsDisplayable function are/is null");
        }

        if(withFont.canDisplayUpTo(textDisplayable) < 0){
            return withFont;
        }

        return new FontUIResource(Font.SANS_SERIF, withFont.getStyle(), withFont.getSize());
    }

    protected Properties properties = new Properties();
    protected Map<String, FontUIResource> cacheFont = new HashMap<>();
    protected int defaultSize = 12;

    private MaterialFontFactory() {
        try {
            loadOsPropries();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public FontUIResource getFont(MaterialTypeFont typeFont){
        if(typeFont == null){
            throw new IllegalArgumentException("Argument null");
        }
        String typeFontString = typeFont.toString();
        if(cacheFont.containsKey(typeFontString)){
            return new FontUIResource(cacheFont.get(typeFontString));
        }
        String propieties = properties.getProperty(typeFontString);
        FontUIResource font = getFontWithPath(propieties);
        cacheFont.put(typeFontString, font);
        return new FontUIResource(font);
    }

    public FontUIResource getFontWithPath(String path){
        if(path == null || path.isEmpty()){
            throw new IllegalArgumentException("The path to load personal fort is null or empty");
        }
        InputStream stream = getClass().getResourceAsStream(path);
        return loadFont(stream);
    }

    public FontUIResource getFontWithStream(InputStream stream){
        if(stream == null){
            throw new IllegalArgumentException("The stream to load personal fort is null");
        }
        return loadFont(stream);
    }

    /**
     * Fix the problem with this post
     * https://stackoverflow.com/questions/5829703/java-getting-a-font-with-a-specific-height-in-pixels
     * @author https://github.com/vincenzopalazzo
     */
    private FontUIResource loadFont(InputStream inputStream) {
        float size = defaultSize * Math.min(Toolkit.getDefaultToolkit().getScreenResolution(), 96) /72;
        if (fontSettings.isEmpty()) {
            fontSettings.put (TextAttribute.SIZE, size);
            //fontSettings.put (TextAttribute.SIZE, new Float( 14f));
            fontSettings.put(TextAttribute.KERNING, TextAttribute.KERNING_ON);
        }

        try {
            Font font = Font.createFont(Font.TRUETYPE_FONT, inputStream).deriveFont(fontSettings);
            return new FontUIResource(font);
        } catch (IOException | FontFormatException e) {
            e.printStackTrace();
            throw new RuntimeException("Font " + inputStream.toString() + " wasn't loaded");
        }
    }

    /**
     * This is only on test, I will remove if in the next release this don't work
     * @param component
     * @param font
     * @return
     */
    public FontUIResource doOptimizingCode(JComponent component, Font font){
        //TODO if is null?
        FontMetrics m = component.getGraphics().getFontMetrics(font); // g is your current Graphics object
        float totalSize= defaultSize * (m.getAscent() + m.getDescent()) / m.getAscent();
        FontUIResource fontOptimized= new FontUIResource(font.deriveFont(totalSize));
        return fontOptimized;
    }

    /**
     * This method was to change the font based on the operating system because there
     * was a bug for the well-known font, it was tinted pixeled,
     * but now this problem has been solved and therefore there is no need to carry around
     * Many dependencies, native fonts are removed from the project but this method remains for furious purposes
     * @throws IOException
     */
    private void loadOsPropries() throws IOException {
        properties.load(getClass().getResourceAsStream("/config/font-all-language.properties"));
    }

    protected enum MaterialTypeFont {
        REGULAR("REGULAR"),
        BOLD("BOLD"),
        ITALIC("ITALIC"),
        MEDIUM("MEDIUM");

        private String type;

        MaterialTypeFont(String type) {
            this.type = type;
        }

        @Override
        public String toString() {
            return type;
        }
    }
}
