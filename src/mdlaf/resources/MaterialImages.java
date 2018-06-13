package mdlaf.resources;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

public class MaterialImages {

	public static final BufferedImage RIGHT_ARROW = loadImg ("/imgs/right_arrow.png");
	public static final BufferedImage DOWN_ARROW = loadImg ("/imgs/down_arrow.png");
	public static final BufferedImage UP_ARROW = loadImg ("/imgs/up_arrow.png");

	private static BufferedImage loadImg (String imgPath) {
		try (InputStream inputStream = MaterialImages.class.getResourceAsStream (imgPath)) {
			return ImageIO.read (inputStream);
		}
		catch (IOException e) {
			e.printStackTrace ();
			throw new RuntimeException ("Image " + imgPath + " wasn't loaded");
		}
	}

	private MaterialImages () {}
}
