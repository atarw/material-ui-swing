/*
 * MIT License
 *
 * Copyright (c) 2018-2021 Vincenzo Palazzo vincenzopalazzodev@gmail.com
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
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import javax.swing.plaf.FontUIResource;

/**
 * This class managed the font inside the library and inside the Look and Feel, in fact this class
 * uses a flyweight pattern to minimized the font instance created from the library. In fact on a
 * lot of components you have only 4 instance of font in a normal use case.
 *
 * @author https://github.com/vincenzopalazzo
 */
public class MaterialFontFactory {

  private static final Map<TextAttribute, Object> fontSettings = new HashMap<>();

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

  /**
   * @deprecated this method will be removed in the version 1.2, this method is not really util fot
   *     the library.
   */
  @Deprecated
  public static Font fontUtilsDisplayable(String textDisplayable, Font withFont) {
    if (textDisplayable == null || withFont == null) {
      throw new IllegalArgumentException(
          "Argument at the fontUtilsDisplayable function are/is null");
    }

    if (withFont.canDisplayUpTo(textDisplayable) < 0) {
      return withFont;
    }

    return new FontUIResource(Font.SANS_SERIF, withFont.getStyle(), withFont.getSize());
  }

  /**
   * The path font was load from a proprieties file. This can permit the user to change the font
   * also with a proprieties file see The file inside resources/config/fonts.properties
   */
  protected Properties properties = new Properties();

  protected Map<String, FontUIResource> cacheFont = new HashMap<>();
  protected float defaultSize = 14f;
  protected boolean withPersonalSettings = true;

  private MaterialFontFactory() {
    try {
      loadOsProprieties();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * This method load the font from a String path, in common this method should be use to load the
   * personal font in a personal location.
   */
  public FontUIResource getFontWithPath(String path) {
    return this.getFontWithPath(path, this.withPersonalSettings);
  }

  /**
   * This method load the font from a input resource, in common this method should be use to load
   * the personal font in a personal resource.
   */
  public FontUIResource getFontWithStream(InputStream stream) {
    return this.getFontWithStream(stream, this.withPersonalSettings);
  }

  /**
   * This method load the library default font, at this moment this is a Noto Sans font, you can
   * load 4 different dimension of font, @see MaterialTypeFont
   */
  public FontUIResource getFont(MaterialTypeFont typeFont) {
    return this.getFont(typeFont, this.withPersonalSettings);
  }

  /**
   * This method load the library default font, at this moment this is a Noto Sans font, you can
   * load 4 different dimension of font, @see MaterialTypeFont
   *
   * <p>In addition, this method have the boolean (by default this propriety is true) called
   * withPersonalSettings to jump the personal font setting. This is util when you have other
   * library that work with font and you want take the control on your code
   */
  public FontUIResource getFont(MaterialTypeFont typeFont, boolean withPersonalSettings) {
    if (typeFont == null) {
      throw new IllegalArgumentException("\n- Parameter type font null.\n");
    }
    String typeFontString = typeFont.toString();
    if (cacheFont.containsKey(typeFontString)) {
      return cacheFont.get(typeFontString);
    }
    String proprieties = properties.getProperty(typeFontString);
    FontUIResource font = getFontWithPath(proprieties);
    cacheFont.put(typeFontString, font);
    return font;
  }

  /**
   * This method load the font from a String path, in common this method should be use to load the
   * personal font in a personal location.
   *
   * <p>In addition, this method have the boolean (by default this propriety is true) called
   * withPersonalSettings to jump the personal font setting. This is util when you have other
   * library that work with font and you want take the control on your code
   */
  public FontUIResource getFontWithPath(String path, boolean withPersonalSettings) {
    if (path == null || path.isEmpty()) {
      throw new IllegalArgumentException("\n- The path to load personal fort is null or empty");
    }
    InputStream stream = getClass().getResourceAsStream(path);
    return loadFont(stream, withPersonalSettings);
  }

  /**
   * This method load the font from a input resource, in common this method should be use to load
   * the personal font in a personal resource. In addition, this method have the boolean (by default
   * this propriety is true) called withPersonalSettings to jump the personal font setting. This is
   * util when you have other library that work with font and you want take the control on your code
   */
  public FontUIResource getFontWithStream(InputStream stream, boolean withPersonalSettings) {
    if (stream == null) {
      throw new IllegalArgumentException("\n- The stream to load personal fort is null");
    }
    return loadFont(stream, withPersonalSettings);
  }

  /**
   * The JDK 8 paint with fin with pixel, this effect is not present in JDK version > 9 But this
   * library try to support the all JDK version and with the calculate dimension form resolution
   * screen resolve in part the pixelated effect. This is the resource that report the optimizing
   * font
   * https://stackoverflow.com/questions/5829703/java-getting-a-font-with-a-specific-height-in-pixels
   */
  private FontUIResource loadFont(InputStream inputStream, boolean withPersonalSettings) {
    float size =
        withPersonalSettings ? this.doOptimizingDimensionFont(this.defaultSize) : this.defaultSize;
    if (withPersonalSettings && fontSettings.isEmpty()) {
      fontSettings.put(TextAttribute.SIZE, size);
      fontSettings.put(TextAttribute.KERNING, TextAttribute.KERNING_ON);
    }
    try {
      Font font;
      if (withPersonalSettings) {
        font = Font.createFont(Font.TRUETYPE_FONT, inputStream).deriveFont(fontSettings);
        return new FontUIResource(font);
      }
      font = Font.createFont(Font.TRUETYPE_FONT, inputStream).deriveFont(size);
      return new FontUIResource(font);
    } catch (IOException | FontFormatException e) {
      e.printStackTrace();
      throw new RuntimeException("Font " + inputStream.toString() + " wasn't loaded");
    }
  }

  /**
   * In this method optimizing the font dimension with the display resolution This method to
   * calculate the font dimension is bad, We now but the JDK 8 display the font very bad and at the
   * moment with the JDK 8 the dimension of the font is calculate with the screen resolution and
   * with the JDK9+ the font set with the defaultSize @see defaultSize
   *
   * @param dimension is the dimension font that you want optimizing
   */
  public float doOptimizingDimensionFont(float dimension) {
    if (defaultSize <= 0) {
      throw new IllegalArgumentException("\n- The dimension should be positive (>= 0)");
    }
    if (Utils.isJavaVersionUnderJava9()) {
      float dimensionOptimized =
          11f * Math.min(Toolkit.getDefaultToolkit().getScreenResolution(), 96) / 72;
      if (dimensionOptimized <= (dimension - 3)) {
        // ON OSX with display 4k in some cases the font dimension is equal to 5.
        return (11f * 96) / 72;
      }
      return dimensionOptimized;
    }
    return dimension;
  }

  /**
   * This method was to change the font based on the operating system because there was a bug for
   * the well-known font, it was tinted pixeled, but now this problem has been solved and therefore
   * there is no need to carry around Many dependencies, native fonts are removed from the project
   * but this method remains for furious purposes
   *
   * @throws IOException
   */
  private void loadOsProprieties() throws IOException {
    properties.load(getClass().getResourceAsStream("/config/fonts.properties"));
  }

  /**
   * Enum class that. This constant is to set the library font inside the material type as, REGULAR,
   * BOLD, ITALIC, MEDIUM
   */
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
