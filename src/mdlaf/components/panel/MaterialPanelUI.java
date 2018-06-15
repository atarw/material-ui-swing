package mdlaf.components.panel;

import mdlaf.resources.MaterialDrawingUtils;
import mdlaf.resources.MaterialFonts;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicPanelUI;
import java.awt.Color;
import java.awt.Graphics;

public class MaterialPanelUI extends BasicPanelUI {

	public static ComponentUI createUI (JComponent c) {
		return new MaterialPanelUI ();
	}

	@Override
	public void installUI (JComponent c) {
		super.installUI (c);

		JPanel panel = (JPanel) c;
		panel.setOpaque (true);
		panel.setFont (MaterialFonts.REGULAR);
		panel.setBackground (Color.WHITE);
		panel.setBorder (BorderFactory.createEmptyBorder ());
	}

	@Override
	public void paint (Graphics g, JComponent c) {
		super.paint (MaterialDrawingUtils.getAliasedGraphics (g), c);
	}
}
