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

import jiconfont.IconCode;
import jiconfont.swing.IconFontSwing;
import mdlaf.utils.icons.IMaterialIconCode;
import mdlaf.utils.icons.MaterialIconFont;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.plaf.IconUIResource;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * @author https://github.com/vincenzopalazzo
 */
public class MaterialImageFactory{

    static {
        //IconFontSwing.register(GoogleMaterialDesignIcons.getIconFont());
        IconFontSwing.register(MaterialIconFont.getIconFont());
    }

    public static void registerIcons(IconCode iconCode){
        if(iconCode == null){
            String errorMessage = "\n- Icon code null you can found the name icon here: " +
                    "https://jiconfont.github.io/\n" +
                    "An example can be this IconFontSwing.register(GoogleMaterialDesignIcons.getIconFont());";
            throw new IllegalArgumentException(errorMessage);
        }
    }

    private static MaterialImageFactory SINGLETON;

    private static final String PATH_RESOUSES = "/imgs/";

    // blank image
    public static final String BLANK = "blank";

    /**
     * @deprecated Use iconfont, look the documentation here
     * https://github.com/vincenzopalazzo/material-ui-swing/blob/master/docs/CHANGELOG.md#used-iconfontswing-library-for-add-other-icons
     */
    @Deprecated
    public static final String RIGHT_ARROW = "right_arrow";
    /**
     * @deprecated Use iconfont, look the documentation here
     * https://github.com/vincenzopalazzo/material-ui-swing/blob/master/docs/CHANGELOG.md#used-iconfontswing-library-for-add-other-icons
     */
    @Deprecated
    public static final String LEFT_ARROW = "left_arrow";
    /**
     * @deprecated Use iconfont, look the documentation here
     * https://github.com/vincenzopalazzo/material-ui-swing/blob/master/docs/CHANGELOG.md#used-iconfontswing-library-for-add-other-icons
     */
    @Deprecated
    public static final String DOWN_ARROW = "down_arrow";
    /**
     * @deprecated Use iconfont, look the documentation here
     * https://github.com/vincenzopalazzo/material-ui-swing/blob/master/docs/CHANGELOG.md#used-iconfontswing-library-for-add-other-icons
     */
    @Deprecated
    public static final String UP_ARROW = "up_arrow";

    public static final String ERROR = "error";
    public static final String WARNING = "warning";
    public static final String QUESTION = "question";
    public static final String INFORMATION = "information";


    private Map<String, IconUIResource> cacheImage = new HashMap<>();

    public static MaterialImageFactory getInstance() {
        if (SINGLETON == null) {
            SINGLETON = new MaterialImageFactory();
        }
        return SINGLETON;
    }

    private MaterialImageFactory() {
    }

    public IconUIResource getImage(String key) {
        if (key == null) {
            throw new IllegalArgumentException("Argument null");
        }
        String path = PATH_RESOUSES.trim() + key.trim() + ".png".trim();
        if (cacheImage.containsKey(path)) {
            return cacheImage.get(path);
        }
        try (InputStream inputStream = MaterialImageFactory.class.getResourceAsStream(path)) {
            BufferedImage image = ImageIO.read(inputStream);
            cacheImage.put(path, new IconUIResource(new ImageIcon(image)));
            return cacheImage.get(path);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Image " + path + " wasn't loaded");
        }
    }

    /**
     * This method utilized this library for make the icons https://jiconfont.github.io/swing
     * by default the material-ui-swing utilized the Google font https://jiconfont.github.io/swing
     * but you can set other type of font with method
     * param iconCode
     * param dimension: Is the dimension of icons, by default this library used dimension = 20
     * param color: Is the color of icons, by default this library used color = MaterialColors.BLACK;
     */
    public IconUIResource getImage(IMaterialIconCode iconCode, int dimension, Color color){
        if(iconCode == null || dimension <= 0){
            String errorMessage = "Don't know motivation this exceptions";
            if(iconCode == null){
                if(errorMessage.contains("Don\'t know motivation this exceptions")){
                    errorMessage = "";
                }
                errorMessage += "\n- Icon code null, you can found the name icon color here: " +
                        "https://material.io/resources/icons/?style=baseline\n" +
                        "an valid code can be this: " +
                        "MaterialImageFactory.getInstance().getImage(" +
                        "GoogleMaterialDesignIcons.KEYBOARD_ARROW_RIGHT, Color.BLUE);";
            }
            if(dimension <= 0){
                if(errorMessage.contains("Don\'t know motivation this exceptions")){
                    errorMessage = "";
                }
                errorMessage += "\n- Dimension of icon doesn't valid, you should insert the dimension > 0";
            }
            errorMessage += "\n\n";
            throw new IllegalArgumentException(errorMessage);
        }
        String key;
        if(color == null){
            color = MaterialColors.BLACK;
        }
        key = iconCode.name() + dimension + color.toString();

        if(cacheImage.containsKey(key)){
            return cacheImage.get(key);
        }

        IconUIResource icon = new IconUIResource(new ImageIcon(IconFontSwing.buildImage(iconCode, dimension, color)));
        cacheImage.put(key, icon);
        return icon;
    }

    public IconUIResource getImage(IMaterialIconCode iconCode, int dimension){
        return getImage(iconCode, dimension, null);
    }

    public IconUIResource getImage(IMaterialIconCode iconCode){
        return getImage(iconCode, 20, null);
    }

    public IconUIResource getImage(IMaterialIconCode iconCode, Color color){
        return getImage(iconCode, 20, color);
    }
}
