package mdlaf.components.label;

import mdlaf.utils.MaterialDrawingUtils;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.UIManager;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicLabelUI;
import java.awt.Graphics;

/**
 * @contributor https://github.com/vincenzopalazzo
 */
public class MaterialLabelUI extends BasicLabelUI {

	public static ComponentUI createUI (JComponent c) {
		return new MaterialLabelUI ();
	}

	@Override
	public void installUI (JComponent c) {
		super.installUI (c);

		JLabel label = (JLabel) c;
		label.setOpaque (true);
		label.setFont (UIManager.getFont ("Label.font"));
		label.setBackground (UIManager.getColor ("Label.background"));
		label.setForeground (UIManager.getColor ("Label.foreground"));
		label.setBorder (UIManager.getBorder ("Label.border"));
	}

	@Override
	public void paint (Graphics g, JComponent c) {
		super.paint (MaterialDrawingUtils.getAliasedGraphics (g), c);
	}

	@Override
	protected void paintEnabledText(JLabel l, Graphics g, String s, int textX, int textY) {
		super.paintEnabledText(l, g, s, textX, textY);

		l.setOpaque (UIManager.getBoolean("Label.opaque"));
		l.setFont (UIManager.getFont ("Label.font"));
		l.setBackground (UIManager.getColor ("Label.background"));
		l.setForeground (UIManager.getColor ("Label.foreground"));
		l.setBorder (UIManager.getBorder ("Label.border"));
	}

	@Override
	protected void paintDisabledText(JLabel l, Graphics g, String s, int textX, int textY) {
		super.paintDisabledText(l, g, s, textX, textY);

		l.setForeground(UIManager.getColor("Label[disabled].foreground"));
		l.setBackground(UIManager.getColor("Label[disabled].background"));
		l.setFont(UIManager.getFont("Label[disabled].font"));
	}
}
