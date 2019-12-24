package mdlaf.components.checkbox;

import mdlaf.utils.MaterialManagerListener;

import javax.swing.*;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.metal.MetalCheckBoxUI;
import java.awt.*;

/**
 * @author https://github.com/vincenzopalazzo
 * @author https://github.com/atarw
 */
public class MaterialCheckBoxUI extends MetalCheckBoxUI {

	public static ComponentUI createUI(JComponent c) {
		return new MaterialCheckBoxUI();
	}


	@Override
	public void installUI(JComponent c) {
		super.installUI(c);

		JCheckBox checkBox = (JCheckBox) c;
		checkBox.setFont(UIManager.getFont("CheckBox.font"));
		checkBox.setBackground(UIManager.getColor("CheckBox.background"));
		checkBox.setForeground(UIManager.getColor("CheckBox.foreground"));
		checkBox.setIcon(UIManager.getIcon("CheckBox.icon"));
		checkBox.setSelectedIcon(UIManager.getIcon("CheckBox.selectedIcon"));
		checkBox.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	}

	@Override
	public void uninstallUI(JComponent c) {

		JCheckBox checkBox = (JCheckBox) c;
		checkBox.setFont(null);
		checkBox.setBackground(null);
		checkBox.setForeground(null);
		checkBox.setIcon(null);
		checkBox.setSelectedIcon(null);
		checkBox.setCursor(null);

		super.uninstallUI(c);
	}

	@Override
	public void paint(Graphics g, JComponent c) {
		super.paint(g, c);
	}

	//TODO support change icon for future when is focus
	@Override
	protected void paintFocus(Graphics g, Rectangle textRect, Dimension size) {
		//super.paintFocus(g, textRect, size);
	}

}
