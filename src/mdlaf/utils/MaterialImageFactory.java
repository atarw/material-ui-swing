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
    public static final String DOWN_ARROW = "/resources/imgs/down_arrow.png";
    public static final String UP_ARROW = "/resources/imgs/up_arrow.png";
    public static final String PAINTED_BLACK_CHECKED_BOX = "/resources/imgs/painted_checked_box.png";
    public static final String PAINTED_BLUE_CHECKED_BOX = "/resources/imgs/blue-check-box-with-white-check.png";
    public static final String OUTLINED_CHECKED_BOX = "/resources/imgs/outlined_checked_box.png";
    public static final String UNCHECKED_BOX = "/resources/imgs/unchecked_box.png";
    public static final String RADIO_BUTTON_ON = "/resources/imgs/radio_button_on.png";
    public static final String RADIO_BUTTON_OFF = "/resources/imgs/radio_button_off.png";
    public static final String TOGGLE_BUTTON_ON = "/resources/imgs/toggle_on.png";
    public static final String TOGGLE_BUTTON_OFF = "/resources/imgs/toggle_off.png";
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
    public static final String YES_COLLASSED = "/resources/imgs/yes-collassated.png";
    public static final String NO_COLLASSED = "/resources/imgs/no-collassated.png";

    private Map<String, BufferedImage> cachaImage = new HashMap<>();

    public static MaterialImageFactory getIstance() {
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
