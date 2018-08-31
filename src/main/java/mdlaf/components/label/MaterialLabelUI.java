package mdlaf.components.label;

import mdlaf.utils.MaterialDrawingUtils;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.UIManager;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicLabelUI;
import java.awt.Graphics;

public class MaterialLabelUI extends BasicLabelUI {

	public static ComponentUI createUI (JComponent c) {
		return new MaterialLabelUI ();
	}

	@Override
	public void installUI (JComponent c) {
		super.installUI (c);

		JLabel label = (JLabel) c;
		label.setOpaque (false);
		label.setFont (UIManager.getFont ("Label.font"));
		label.setBackground (UIManager.getColor ("Label.background"));
		label.setForeground (UIManager.getColor ("Label.foreground"));
		label.setBorder (UIManager.getBorder ("Label.border"));
	}

	@Override
	public void paint (Graphics g, JComponent c) {
		super.paint (MaterialDrawingUtils.getAliasedGraphics (g), c);
	}
}
