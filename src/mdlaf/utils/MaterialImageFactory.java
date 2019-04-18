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

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * @author https://github.com/vincenzopalazzo
 */
public class MaterialImageFactory {

    private static MaterialImageFactory SINGLETON;

    public static final String RIGHT_ARROW = "/resources/imgs/right_arrow.png";
    public static final String LEFT_ARROW = "/resources/imgs/left_arrow.png";
    public static final String DOWN_ARROW = "/resources/imgs/down_arrow.png";
    public static final String UP_ARROW = "/resources/imgs/up_arrow.png";
    public static final String CHECKED_BLACK_BOX = "/resources/imgs/painted_checked_box.png";
    public static final String CHECKED_WHITE_BOX = "/resources/imgs/checked_white.png";
    public static final String UNCHECKED_BLACK_BOX = "/resources/imgs/unchecked_box.png";
    public static final String UNCHECKED_WHITE_BOX = "/resources/imgs/unchecked_white.png";
    public static final String RADIO_BUTTON_BLACK_ON = "/resources/imgs/radio_button_on.png";
    public static final String RADIO_BUTTON_WHITE_ON = "/resources/imgs/radio-checked-white.png";
    public static final String RADIO_BUTTON_BLACK_OFF = "/resources/imgs/radio_button_off.png";
    public static final String RADIO_BUTTON_WHITE_OFF = "/resources/imgs/radio_unchecked-white.png";
    public static final String TOGGLE_BUTTON_BLACK_ON = "/resources/imgs/toggle_on.png";
    public static final String TOGGLE_BUTTON_BLACK_OFF = "/resources/imgs/toggle_off.png";
    public static final String BACK_ARROW = "/resources/imgs/back_arrow.png";
    public static final String COMPUTER = "/resources/imgs/computer.png";
    public static final String FILE = "/resources/imgs/file.png";
    public static final String FLOPPY_DRIVE = "/resources/imgs/floppy_drive.png";
    public static final String FOLDER = "/resources/imgs/folder.png";
    public static final String HARD_DRIVE = "/resources/imgs/hard_drive.png";
    public static final String HOME = "/resources/imgs/home.png";
    public static final String LIST = "/resources/imgs/list.png";
    public static final String NEW_FOLDER = "/resources/imgs/new_folder.png";
    public static final String DETAILS = "/resources/imgs/details.png";
    public static final String YES_COLLASSED = "/resources/imgs/yes-collassed.png";
    public static final String NO_COLLASSED = "/resources/imgs/no-collassed.png";
    public static final String ERROR = "/resources/imgs/error.png";
    public static final String WARNING = "/resources/imgs/warning.png";
    public static final String QUESTION = "/resources/imgs/question.png";
    public static final String INFORMATION = "/resources/imgs/information.png";
    public static final String CLOSE_WINDOWS = "/resources/imgs/close-button.png";
    public static final String MAXIMIZE_WINDOWS = "/resources/imgs/maximize.png";
    public static final String MINIIMIZE_WINDOWS = "/resources/imgs/minimize.png";
    public static final String ICONIFY_WINDOWS = "/resources/imgs/restore.png";

    private Map<String, BufferedImage> cachaImage = new HashMap<>();

    public static MaterialImageFactory getInstance() {
        if (SINGLETON == null) {
            SINGLETON = new MaterialImageFactory();
        }
        return SINGLETON;
    }

    private MaterialImageFactory() {
    }

    public BufferedImage getImage(String key) {
        if (key == null) {
            throw new IllegalArgumentException("Argument nulled");
        }
        if (cachaImage.containsKey(key)) {
            return cachaImage.get(key);
        }
        try (InputStream inputStream = MaterialImages.class.getResourceAsStream(key)) {
            BufferedImage image = ImageIO.read(inputStream);
            cachaImage.put(key, image);
            return cachaImage.get(key);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Image " + key + " wasn't loaded");
        }
    }
}
