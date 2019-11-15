package mdlaf.utils;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.util.Map;

public class MaterialDrawingUtils {

    static {
        System.setProperty("awt.useSystemAAFontSettings", "on");
        System.setProperty("swing.aatext", "true");
        System.setProperty("sun.java2d.xrender", "true");
    }

    public static Graphics getAliasedGraphics(Graphics g) {
        Map<RenderingHints.Key, Object> hints = (Map<RenderingHints.Key, Object>) Toolkit.getDefaultToolkit ().getDesktopProperty ("awt.font.desktophints");

		if(hints != null){
			hints.put(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			hints.put(RenderingHints.KEY_RENDERING,	RenderingHints.VALUE_RENDER_DEFAULT);
			hints.put(RenderingHints.KEY_COLOR_RENDERING,	RenderingHints.VALUE_COLOR_RENDER_DEFAULT);
			hints.put(RenderingHints.KEY_TEXT_ANTIALIASING,	RenderingHints.VALUE_TEXT_ANTIALIAS_LCD_HRGB);

			Graphics2D g2d = (Graphics2D) g;
			g2d.addRenderingHints(hints);
			return g2d;
		}
		
		//g2d.addRenderingHints (new RenderingHints (RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON));
		return g;
    }
}
