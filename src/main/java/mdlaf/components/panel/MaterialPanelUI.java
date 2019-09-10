package mdlaf.components.panel;

import mdlaf.utils.MaterialDrawingUtils;

import javax.swing.*;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicPanelUI;
import java.awt.*;

/**
 * @author https://github.com/vincenzopalazzo
 * @author https://github.com/atarw
 */
public class MaterialPanelUI extends BasicPanelUI {

	public static ComponentUI createUI (JComponent c) {
		return new MaterialPanelUI ();
	}

	@Override
	public void installUI (JComponent c) {
		super.installUI (c);

		JPanel panel = (JPanel) c;
		panel.setOpaque (true);
		panel.setFont (UIManager.getFont ("Panel.font"));
		panel.setBackground (UIManager.getColor ("Panel.background"));
		panel.setBorder (UIManager.getBorder ("Panel.border"));

	}

	@Override
	public void uninstallUI(JComponent c) {

		c.setFont (null);
		c.setBackground (null);
		c.setForeground (null);
		c.setBorder (null);
		c.setCursor(null);

		super.uninstallUI(c);
	}

	@Override
	public void paint (Graphics g, JComponent c) {
		super.paint (MaterialDrawingUtils.getAliasedGraphics (g), c);
	}
}
