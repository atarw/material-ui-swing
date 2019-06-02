package mdlaf.components.label;

import sun.swing.SwingUtilities2;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.UIManager;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicLabelUI;
import java.awt.*;

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
		label.setOpaque (UIManager.getBoolean("Label.opaque"));
		label.setFont (UIManager.getFont ("Label.font"));
		label.setBackground (UIManager.getColor ("Label.background"));
		label.setForeground (UIManager.getColor ("Label.foreground"));
		label.setBorder (UIManager.getBorder ("Label.border"));
	}

	@Override
	public void paint (Graphics g, JComponent c) {
		super.paint (g, c);
	}

	@Override
	protected void paintDisabledText(JLabel l, Graphics g, String s, int textX, int textY) {
		int mnemIndex = l.getDisplayedMnemonicIndex();
		g.setColor(UIManager.getColor("Label.disabledForeground"));
		SwingUtilities2.drawStringUnderlineCharAt(l, g, s, mnemIndex, textX, textY);
	}
}