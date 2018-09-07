package mdlaf.utils;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

public class MaterialImages {

	public static final BufferedImage RIGHT_ARROW = loadImg ("/imgs/right_arrow.png");
	public static final BufferedImage DOWN_ARROW = loadImg ("/imgs/down_arrow.png");
	public static final BufferedImage UP_ARROW = loadImg ("/imgs/up_arrow.png");
	public static final BufferedImage PAINTED_CHECKED_BOX = loadImg ("/imgs/painted_checked_box.png");
	public static final BufferedImage OUTLINED_CHECKED_BOX = loadImg ("/imgs/outlined_checked_box.png");
	public static final BufferedImage UNCHECKED_BOX = loadImg ("/imgs/unchecked_box.png");
	public static final BufferedImage RADIO_BUTTON_ON = loadImg ("/imgs/radio_button_on.png");
	public static final BufferedImage RADIO_BUTTON_OFF = loadImg ("/imgs/radio_button_off.png");
	public static final BufferedImage TOGGLE_BUTTON_ON = loadImg ("/imgs/toggle_on.png");
	public static final BufferedImage TOGGLE_BUTTON_OFF = loadImg ("/imgs/toggle_off.png");
	public static final BufferedImage BACK_ARROW = loadImg ("/imgs/back_arrow.png");
	public static final BufferedImage COMPUTER = loadImg ("/imgs/computer.png");
	public static final BufferedImage FILE = loadImg ("/imgs/file.png");
	public static final BufferedImage FLOPPY_DRIVE = loadImg ("/imgs/floppy_drive.png");
	public static final BufferedImage FOLDER = loadImg ("/imgs/folder.png");
	public static final BufferedImage HARD_DRIVE = loadImg ("/imgs/hard_drive.png");
	public static final BufferedImage HOME = loadImg ("/imgs/home.png");
	public static final BufferedImage LIST = loadImg ("/imgs/list.png");
	public static final BufferedImage NEW_FOLDER = loadImg ("/imgs/new_folder.png");
	public static final BufferedImage DETAILS = loadImg ("/imgs/details.png");

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
