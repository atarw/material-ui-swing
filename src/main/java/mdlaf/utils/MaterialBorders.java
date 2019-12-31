/**
 * MIT License
 *
 * Copyright (c) 2018-2020 atharva washimkar, Vincenzo Palazzo vincenzopalazzo1996@gmail.com
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

import mdlaf.shadows.DropShadowBorder;
import mdlaf.shadows.RoundedCornerBorder;
import mdlaf.utils.MaterialColors;

import javax.swing.BorderFactory;
import javax.swing.border.Border;
import javax.swing.plaf.BorderUIResource;
import java.awt.*;

/**
 * @author https://github.com/vincenzopalazzo
 * @author https://github.com/atarw
 */
public class MaterialBorders {

    public static final BorderUIResource LIGHT_LINE_BORDER = new BorderUIResource(BorderFactory.createLineBorder(MaterialColors.GRAY_200, 1));
    public static final BorderUIResource DARK_LINE_BORDER = new BorderUIResource(BorderFactory.createLineBorder(MaterialColors.COSMO_BLACK, 1));
    public static final BorderUIResource OCEAN_LINE_BORDER = new BorderUIResource(BorderFactory.createLineBorder(MaterialColors.DARKLY_STRONG_BLUE, 1));
    public static final BorderUIResource LIGHT_SHADOW_BORDER = new BorderUIResource(
            new DropShadowBorder(Color.BLACK, 0, 4, 0.3f, 12,
                    true, true, true, true));
    public static final BorderUIResource DEFAULT_SHADOW_BORDER = new BorderUIResource(
            new DropShadowBorder(Color.BLACK, 5, 5, 0.3f, 12,
                    true, true, true, true));
    public static final BorderUIResource ROUNDED_CORNER_BORDER = new BorderUIResource(new RoundedCornerBorder());

    private MaterialBorders() {
    }

    public static BorderUIResource roundedLineColorBorder(Color colorLine){
        if(colorLine == null){
            throw new IllegalArgumentException("The color line is null");
        }
        return roundedLineColorBorder(colorLine, 12);
    }

    public static BorderUIResource roundedLineColorBorder(Color colorLine, int arch){
        if(colorLine == null){
            throw new IllegalArgumentException("The color line is null");
        }
        return new BorderUIResource(new RoundedCornerBorder(colorLine, arch));
    }
}

