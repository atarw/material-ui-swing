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

    private static final String PATH_RESOUSES = "/resources/imgs";

    //Icon black
    public static final String RIGHT_ARROW = PATH_RESOUSES + "/right_arrow.png";
    public static final String LEFT_ARROW = PATH_RESOUSES + "/left_arrow.png";
    public static final String DOWN_ARROW = PATH_RESOUSES + "/down_arrow.png";
    public static final String UP_ARROW = PATH_RESOUSES + "/up_arrow.png";
    public static final String CHECKED_BLACK_BOX = PATH_RESOUSES + "/painted_checked_box.png";
    public static final String UNCHECKED_BLACK_BOX = PATH_RESOUSES + "/unchecked_box.png";
    public static final String RADIO_BUTTON_BLACK_ON = PATH_RESOUSES + "/radio_button_on.png";
    public static final String RADIO_BUTTON_BLACK_OFF = PATH_RESOUSES + "/radio_button_off.png";
    public static final String TOGGLE_BUTTON_BLACK_ON = PATH_RESOUSES + "/toggle_on.png";
    public static final String TOGGLE_BUTTON_BLACK_OFF = PATH_RESOUSES + "/toggle_off.png";
    public static final String BACK_ARROW_BLACK = "/resources/imgs/back_arrow.png";
    public static final String COMPUTER_BLACK = "/resources/imgs/computer.png";
    public static final String FILE_BLACK = "/resources/imgs/file.png";
    public static final String FLOPPY_DRIVE_BLACK = "/resources/imgs/floppy_drive.png";
    public static final String FOLDER_BLACK = "/resources/imgs/folder.png";
    public static final String HARD_DRIVE_BLACK = "/resources/imgs/hard_drive.png";
    public static final String HOME_BLACK = "/resources/imgs/home.png";
    public static final String LIST_BLACK = "/resources/imgs/list.png";
    public static final String NEW_FOLDER_BLACK = "/resources/imgs/new_folder.png";
    public static final String DETAILS_BLACK = "/resources/imgs/details.png";
    public static final String YES_COLLAPSED = "/resources/imgs/yes-collapsed.png";
    public static final String NO_COLLAPSED = "/resources/imgs/no-collapsed.png";
    public static final String ERROR = "/resources/imgs/error.png";
    public static final String WARNING = "/resources/imgs/warning.png";
    public static final String QUESTION = "/resources/imgs/question.png";
    public static final String INFORMATION = "/resources/imgs/information.png";
    public static final String CLOSE_WINDOWS_BLACK = "/resources/imgs/close-button.png";
    public static final String MAXIMIZE_WINDOWS = "/resources/imgs/maximize.png";
    public static final String MINIIMIZE_WINDOWS = "/resources/imgs/minimize.png";
    public static final String ICONIFY_WINDOWS = "/resources/imgs/restore.png";

    //Icon White
    public static final String RADIO_BUTTON_WHITE_OFF = "/resources/imgs/white/radio_unchecked-white.png";
    public static final String CHECKED_WHITE_BOX = "/resources/imgs/white/checked_white.png";
    public static final String RADIO_BUTTON_WHITE_ON = "/resources/imgs/white/radio-checked-white.png";
    public static final String UNCHECKED_WHITE_BOX = "/resources/imgs/white/unchecked_white.png";
    public static final String BACK_ARROW_WHITE = "/resources/imgs/white/back_arrow.png";
    public static final String COMPUTER_WHITE = "/resources/imgs/white/computer.png";
    public static final String FILE_WHITE = "/resources/imgs/white/file.png";
    public static final String FLOPPY_DRIVE_WHITE = "/resources/imgs/white/floppy_drive.png";
    public static final String FOLDER_WHITE = "/resources/imgs/white/folder.png";
    public static final String HARD_DRIVE_WHITE = "/resources/imgs/white/hard_drive.png";
    public static final String HOME_WHITE = "/resources/imgs/white/home.png";
    public static final String LIST_WHITE = "/resources/imgs/white/list.png";
    public static final String NEW_FOLDER_WHITE = "/resources/imgs/white/new_folder.png";
    public static final String DETAILS_WHITE = "/resources/imgs/white/details.png";
    public static final String CLOSE_WINDOWS_WHITE = "/resources/imgs/white/close-button.png";
    public static final String TOGGLE_BUTTON_ON_WHITE = PATH_RESOUSES + "/white/toggle_on.png";
    public static final String TOGGLE_BUTTON_OFF_WHITE = PATH_RESOUSES + "/white/toggle_off.png";

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
        try (InputStream inputStream = MaterialImageFactory.class.getResourceAsStream(key)) {
            BufferedImage image = ImageIO.read(inputStream);
            cachaImage.put(key, image);
            return cachaImage.get(key);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Image " + key + " wasn't loaded");
        }
    }
}
