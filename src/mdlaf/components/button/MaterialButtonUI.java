package mdlaf.components.button;

import mdlaf.resources.MaterialColors;
import mdlaf.resources.MaterialDrawingUtils;
import mdlaf.resources.MaterialFonts;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicButtonUI;
import java.awt.Color;
import java.awt.Graphics;

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
		g = MaterialDrawingUtils.getAliasedGraphics (g);
		paintBackground (g, b);
		super.paint (g, c);
	}

	private void paintBackground (Graphics g, JComponent c) {
		g.setColor (c.getBackground ());
		g.fillRoundRect (0, 0, c.getWidth (), c.getHeight (), 7, 7);
	}

	@Override
	public String getPropertyPrefix () {
		return "Button";
	}
}