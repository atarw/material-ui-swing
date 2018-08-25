package mdlaf.utils;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

public class MaterialImages {

	public static final BufferedImage RIGHT_ARROW = loadImg ("/resources/imgs/right_arrow.png");
	public static final BufferedImage DOWN_ARROW = loadImg ("/resources/imgs/down_arrow.png");
	public static final BufferedImage UP_ARROW = loadImg ("/resources/imgs/up_arrow.png");
	public static final BufferedImage PAINTED_CHECKED_BOX = loadImg ("/resources/imgs/painted_checked_box.png");
	public static final BufferedImage OUTLINED_CHECKED_BOX = loadImg ("/resources/imgs/outlined_checked_box.png");
	public static final BufferedImage UNCHECKED_BOX = loadImg ("/resources/imgs/unchecked_box.png");
	public static final BufferedImage RADIO_BUTTON_ON = loadImg ("/resources/imgs/radio_button_on.png");
	public static final BufferedImage RADIO_BUTTON_OFF = loadImg ("/resources/imgs/radio_button_off.png");
	public static final BufferedImage TOGGLE_BUTTON_ON = loadImg ("/resources/imgs/toggle_on.png");
	public static final BufferedImage TOGGLE_BUTTON_OFF = loadImg ("/resources/imgs/toggle_off.png");
	public static final BufferedImage BACK_ARROW = loadImg ("/resources/imgs/back_arrow.png");
	public static final BufferedImage COMPUTER = loadImg ("/resources/imgs/computer.png");
	public static final BufferedImage FILE = loadImg ("/resources/imgs/file.png");
	public static final BufferedImage FLOPPY_DRIVE = loadImg ("/resources/imgs/floppy_drive.png");
	public static final BufferedImage FOLDER = loadImg ("/resources/imgs/folder.png");
	public static final BufferedImage HARD_DRIVE = loadImg ("/resources/imgs/hard_drive.png");
	public static final BufferedImage HOME = loadImg ("/resources/imgs/home.png");
	public static final BufferedImage LIST = loadImg ("/resources/imgs/list.png");
	public static final BufferedImage NEW_FOLDER = loadImg ("/resources/imgs/new_folder.png");
	public static final BufferedImage DETAILS = loadImg ("/resources/imgs/details.png");

	private MaterialImages () {}

	private static BufferedImage loadImg (String imgPath) {
		try (InputStream inputStream = MaterialImages.class.getResourceAsStream (imgPath)) {
			return ImageIO.read (inputStream);
		}
		catch (IOException e) {
			e.printStackTrace ();
			throw new RuntimeException ("Image " + imgPath + " wasn't loaded");
		}
	}
}
