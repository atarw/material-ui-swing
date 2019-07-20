package mdlaf.utils;

import mdlaf.shadows.DropShadowBorder;
import mdlaf.shadows.RoundedCornerBorder;
import mdlaf.utils.MaterialColors;

import javax.swing.BorderFactory;
import javax.swing.border.Border;
import java.awt.*;

public class MaterialBorders {

    public static final Border LIGHT_LINE_BORDER = BorderFactory.createLineBorder(MaterialColors.GRAY_200, 1);
    public static final Border LIGHT_SHADOW_BORDER =
            new DropShadowBorder(Color.BLACK, 0, 4, 0.3f, 12,
                    true, true, true, true);
    public static final Border DEFAULT_SHADOW_BORDER =
            new DropShadowBorder(Color.BLACK, 5, 5, 0.3f, 12,
                    true, true, true, true);
    public static final Border ROUNDED_CORNER_BORDER = new RoundedCornerBorder();

    private MaterialBorders() {
    }

    public static Border roundedLineColorBorder(Color colorLine){
        if(colorLine == null){
            throw new IllegalArgumentException("The color line is null");
        }
        return new RoundedCornerBorder(colorLine);
       // return new RoundedCornerBorder();
    }
}

