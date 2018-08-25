package mdlaf.components.panel;

import mdlaf.utils.MaterialDrawingUtils;

import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicPanelUI;
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
		panel.setFont (UIManager.getFont ("Panel.font"));
		panel.setBackground (UIManager.getColor ("Panel.background"));
		panel.setBorder (UIManager.getBorder ("Panel.border"));
	}

	@Override
	public void paint (Graphics g, JComponent c) {
		super.paint (MaterialDrawingUtils.getAliasedGraphics (g), c);
	}
}
