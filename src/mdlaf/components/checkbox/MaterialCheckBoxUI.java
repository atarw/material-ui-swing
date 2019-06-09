package mdlaf.components.checkbox;

import mdlaf.utils.MaterialDrawingUtils;
import javax.swing.*;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.metal.MetalCheckBoxUI;
import java.awt.*;

//TODO cambio colore icone combo box
public class MaterialCheckBoxUI extends MetalCheckBoxUI {

	private Color disabledColorText;

	public static ComponentUI createUI (JComponent c) {
		return new MaterialCheckBoxUI ();
	}

	@Override
	public void installUI (JComponent c) {
		super.installUI (c);

		JCheckBox checkBox = (JCheckBox) c;
		checkBox.setFont (UIManager.getFont ("CheckBox.font"));
		checkBox.setBackground (UIManager.getColor ("CheckBox.background"));
		checkBox.setForeground (UIManager.getColor ("CheckBox.foreground"));
		checkBox.setIcon (UIManager.getIcon ("CheckBox.icon"));
		checkBox.setSelectedIcon (UIManager.getIcon ("CheckBox.selectedIcon"));
		checkBox.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		disabledColorText = UIManager.getColor("CheckBox[disabled].foreground");
	}

	@Override
	public void paint (Graphics g, JComponent c) {
		super.paint (MaterialDrawingUtils.getAliasedGraphics (g), c);
	}

	//TODO support change icon for future
	@Override
	protected void paintFocus(Graphics g, Rectangle textRect, Dimension size) {
		//super.paintFocus(g, textRect, size);
	}

}
