package mdlaf.components.radiobutton;

import mdlaf.utils.MaterialDrawingUtils;

import javax.swing.JComponent;
import javax.swing.JRadioButton;
import javax.swing.UIManager;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.metal.MetalRadioButtonUI;
import java.awt.*;

/**
 * @author https://github.com/vincenzopalazzo
 * @author https://github.com/atarw
 * @author https://github.com/downToHell
 */
public class MaterialRadioButtonUI extends MetalRadioButtonUI {

	public static ComponentUI createUI (JComponent c) {
		return new MaterialRadioButtonUI ();
	}

	@Override
	public void installUI (JComponent c) {
		super.installUI (c);
		JRadioButton radioButton = (JRadioButton) c;
		radioButton.setFont (UIManager.getFont ("RadioButton.font"));
		radioButton.setBackground (UIManager.getColor ("RadioButton.background"));
		radioButton.setForeground (UIManager.getColor ("RadioButton.foreground"));
		radioButton.setIcon (UIManager.getIcon ("RadioButton.icon"));
		radioButton.setSelectedIcon (UIManager.getIcon ("RadioButton.selectedIcon"));
		c.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	}

	@Override
	public void uninstallUI(JComponent c) {

		c.setFont (null);
		c.setBackground (null);
		c.setForeground (null);
		c.setBorder (null);
		c.setCursor(null);

		JRadioButton radioButton = (JRadioButton) c;
		radioButton.setIcon(null);
		radioButton.setSelectedIcon(null);

		super.uninstallUI(c);
	}

	@Override
	public void paint (Graphics g, JComponent c) {
		super.paint (MaterialDrawingUtils.getAliasedGraphics (g), c);
	}

	@Override
	protected void paintFocus(Graphics g, Rectangle t, Dimension d) {
		//do nothing
	}
}