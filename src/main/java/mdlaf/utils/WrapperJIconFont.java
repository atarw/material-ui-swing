package mdlaf.utils;

import jiconfont.IconCode;
import jiconfont.IconFont;
import jiconfont.icons.google_material_design_icons.GoogleMaterialDesignIcons;

import java.io.InputStream;

public enum WrapperJIconFont  implements IconCode {

    TOGGLE_ON('\uE9F6'),
    TOGGLE_OFF('\uE9F5'),
    MINIMIZE('\uE931');


    private final char character;

    WrapperJIconFont(char character) {
        this.character = character;
    }

    @Override
    public char getUnicode() {
        return character;
    }

    @Override
    public String getFontFamily() {
        return "Material Icons";
    }

    public static IconFont getIconFont() {
        return new IconFont() {
            @Override
            public String getFontFamily() {
                return "Material Icons";
            }

            @Override
            public InputStream getFontInputStream() {
                return GoogleMaterialDesignIcons.class.getResourceAsStream("/fonts/google_material_design_icons/MaterialIcons-Regular.ttf");
            }
        };
    }
}
