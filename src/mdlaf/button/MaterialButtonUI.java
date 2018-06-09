package mdlaf.button;

import mdlaf.MaterialColors;
import mdlaf.MaterialFonts;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicButtonUI;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

public class MaterialButtonUI extends BasicButtonUI {

	public static ComponentUI createUI (final JComponent c) {
		return new MaterialButtonUI ();
	}

	@Override
	public void installUI (JComponent c) {
		super.installUI (c);

		AbstractButton button = (AbstractButton) c;
		button.setOpaque (false);
		button.setBorder (BorderFactory.createEmptyBorder (7, 17, 7, 17));

		button.setBackground (MaterialColors.LIGHT_BLUE);
		button.setForeground (Color.WHITE);
		button.setFont (MaterialFonts.MEDIUM);
	}

	@Override
	public void paint (Graphics g, JComponent c) {
		AbstractButton b = (AbstractButton) c;
		paintBackground (g, b);
		super.paint (g, c);
	}

	private void paintBackground (final Graphics g, final JComponent c) {
		Graphics2D g2 = (Graphics2D) g;

		g2.addRenderingHints (new RenderingHints (RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON));

		g.setColor (c.getBackground ());
		g.fillRoundRect (0, 0, c.getWidth (), c.getHeight (), 7, 7);
	}

	@Override
	public String getPropertyPrefix () {
		return "Button";
	}
}