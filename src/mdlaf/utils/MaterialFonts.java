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

    /*public static final String BLACK = "Black";
    public static final String BLACK_ITALIC = "Black Italian";
    public static final String BOLD = "Bold";
    public static final String BOLD_ITALIC = "Bold Italic";
    public static final String ITALIC = "Italic";
    public static final String LIGHT = "Light";
    public static final String LIGHT_ITALIC = "Light Italic";
    public static final String MEDIUM = "Medium";
    public static final String MEDIUM_ITALIC = "Medium Italic";
    public static final String REGULAR = "Regular";
    public static final String THIN = "Thin";
    public static final String THIN_ITALIC = "Thin Italic";*/

   /* static {
        try {
            //Noto sans
            Font black = Font.createFont(Font.TRUETYPE_FONT, new File("src/main/resources/fonts/NotoSans/NotoSans-Black.ttf"));
            Font blackItalic = Font.createFont(Font.TRUETYPE_FONT, new File("src/main/resources/fonts/NotoSans/NotoSans-BlackItalic.ttf"));
            Font bold = Font.createFont(Font.TRUETYPE_FONT, new File("src/main/resources/fonts/NotoSans/NotoSans-Bold.ttf"));
            Font boldItalic = Font.createFont(Font.TRUETYPE_FONT, new File("src/main/resources/fonts/NotoSans/NotoSans-BoldItalic.ttf"));
            Font italic = Font.createFont(Font.TRUETYPE_FONT, new File("src/main/resources/fonts/NotoSans/NotoSans-Italic.ttf"));
            Font light = Font.createFont(Font.TRUETYPE_FONT, new File("src/main/resources/fonts/NotoSans/NotoSans-Light.ttf"));
            Font lightItalic = Font.createFont(Font.TRUETYPE_FONT, new File("src/main/resources/fonts/NotoSans/NotoSans-LightItalic.ttf"));
            Font medium = Font.createFont(Font.TRUETYPE_FONT, new File("src/main/resources/fonts/NotoSans/NotoSans-Medium.ttf"));
            Font mediumItalic = Font.createFont(Font.TRUETYPE_FONT, new File("src/main/resources/fonts/NotoSans/NotoSans-MediumItalic.ttf"));
            Font regular = Font.createFont(Font.TRUETYPE_FONT, new File("src/main/resources/fonts/NotoSans/NotoSans-Regular.ttf"));
            Font thin = Font.createFont(Font.TRUETYPE_FONT, new File("src/main/resources/fonts/NotoSans/NotoSans-Thin.ttf"));
            Font thinItalic = Font.createFont(Font.TRUETYPE_FONT, new File("src/main/resources/fonts/NotoSans/NotoSans-ThinItalic.ttf"));
            //Register font
            GraphicsEnvironment graphicsEnvironment = GraphicsEnvironment.getLocalGraphicsEnvironment();
            graphicsEnvironment.registerFont(black);
            graphicsEnvironment.registerFont(blackItalic);
            graphicsEnvironment.registerFont(bold);
            graphicsEnvironment.registerFont(boldItalic);
            graphicsEnvironment.registerFont(italic);
            graphicsEnvironment.registerFont(light);
            graphicsEnvironment.registerFont(lightItalic);
            graphicsEnvironment.registerFont(medium);
            graphicsEnvironment.registerFont(mediumItalic);
            graphicsEnvironment.registerFont(regular);
            graphicsEnvironment.registerFont(thin);
            graphicsEnvironment.registerFont(thinItalic);

            black = Font.createFont(Font.TRUETYPE_FONT, new File("src/main/resources/fonts/Roboto/Roboto-Black.ttf"));
            //blackItalic = Font.createFont(Font.TRUETYPE_FONT, new File("src/main/resources/Roboto/Roboto-BlackItalic.ttf"));
            bold = Font.createFont(Font.TRUETYPE_FONT, new File("src/main/resources/fonts/Roboto/Roboto-Bold.ttf"));
            boldItalic = Font.createFont(Font.TRUETYPE_FONT, new File("src/main/resources/fonts/Roboto/Roboto-BoldItalic.ttf"));
            italic = Font.createFont(Font.TRUETYPE_FONT, new File("src/main/resources/fonts/Roboto/Roboto-Italic.ttf"));
            light = Font.createFont(Font.TRUETYPE_FONT, new File("src/main/resources/fonts/Roboto/Roboto-Light.ttf"));
            lightItalic = Font.createFont(Font.TRUETYPE_FONT, new File("src/main/resources/fonts/Roboto/Roboto-LightItalic.ttf"));
            medium = Font.createFont(Font.TRUETYPE_FONT, new File("src/main/resources/fonts/Roboto/Roboto-Medium.ttf"));
            mediumItalic = Font.createFont(Font.TRUETYPE_FONT, new File("src/main/resources/fonts/Roboto/Roboto-MediumItalic.ttf"));
            regular = Font.createFont(Font.TRUETYPE_FONT, new File("src/main/resources/fonts/Roboto/Roboto-Regular.ttf"));
            thin = Font.createFont(Font.TRUETYPE_FONT, new File("src/main/resources/fonts/Roboto/Roboto-Thin.ttf"));
            thinItalic = Font.createFont(Font.TRUETYPE_FONT, new File("src/main/resources/fonts/Roboto/Roboto-ThinItalic.ttf"));

            //register font
            graphicsEnvironment.registerFont(black);
            //graphicsEnvironment.registerFont(blackItalic);
            graphicsEnvironment.registerFont(bold);
            graphicsEnvironment.registerFont(boldItalic);
            graphicsEnvironment.registerFont(italic);
            graphicsEnvironment.registerFont(light);
            graphicsEnvironment.registerFont(lightItalic);
            graphicsEnvironment.registerFont(medium);
            graphicsEnvironment.registerFont(mediumItalic);
            graphicsEnvironment.registerFont(regular);
            graphicsEnvironment.registerFont(thin);
            graphicsEnvironment.registerFont(thinItalic);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (FontFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/

   /* public static Font getFont(String textCompatibily, String tipeFont){
        String familyFontRoboto = "Roboto";
        String familyFontNotoSans = "Noto Sans";
        GraphicsEnvironment graphicsEnvironment = GraphicsEnvironment.getLocalGraphicsEnvironment();
        //System.out.println(familyFontRoboto + " " + tipeFont);
        for(Font font : graphicsEnvironment.getAllFonts()){
            if(font.canDisplayUpTo(textCompatibily) < 0){
                if(font.getName().equals(familyFontRoboto + " " + tipeFont)){
                    System.out.println("Roboto ok");
                    System.out.println(font.toString());
                    return font;
                }
            }
        }
        for(Font font : graphicsEnvironment.getAllFonts()){
            if(font.canDisplayUpTo(textCompatibily) < 0){
                if(font.getName().equals(familyFontNotoSans + " " + tipeFont)){
                    System.out.println("noto sans ok");
                    return font;
                }
            }
        }
        System.out.print("ops");
        return graphicsEnvironment.getAllFonts()[0];
    }*/

  // public static final Font BLACK = loadFont("/main/resources/fonts/SanFrancisco/SF-Pro-Text-Bold.otf");
    //public static final Font BLACK_ITALIC = loadFont("/main/resources/fonts/SanFrancisco/SF-Pro-Display-BlackItalic.otf");
    public static final Font BOLD = loadFont("/resources/fonts/DejavuSans/DejaVuSans-Bold.ttf");
    /*public static final Font BOLD_ITALIC = loadFont("/main/resources/fonts/DejavuSans/DejaVuSans-BoldOblique.ttf");
    public static final Font ITALIC = loadFont("/main/resources/fonts/SanFrancisco/SF-Pro-Display-Heavy.otf");
    public static final Font LIGHT = loadFont("/main/resources/fonts/SanFrancisco/SF-Pro-Display-Light.otf");
    public static final Font LIGHT_ITALIC = loadFont("/main/resources/fonts/SanFrancisco/SF-Pro-Display-LightItalic.otf");*/
    public static final Font MEDIUM = loadFont("/resources/fonts/DejavuSans/DejaVuSansCondensed.ttf");
    //public static final Font MEDIUM_ITALIC = loadFont("/main/resources/fonts/SanFrancisco/SF-Pro-Display-MediumItalic.otf");
    public static final Font REGULAR = loadFont("/resources/fonts/DejavuSans/DejaVuSans.ttf");
    /*public static final Font THIN = loadFont("/main/resources/fonts/DejavuSans/DejaVuSans-ExtraLight.ttf");
    public static final Font THIN_ITALIC = loadFont("/main/resources/fonts/DejavuSans/SF-Pro-Display-ThinItalic.otf");*/

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
