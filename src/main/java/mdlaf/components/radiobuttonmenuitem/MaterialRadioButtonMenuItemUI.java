package mdlaf.components.radiobuttonmenuitem;

import mdlaf.utils.MaterialDrawingUtils;

import javax.swing.Icon;
import javax.swing.JComponent;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.UIManager;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicRadioButtonMenuItemUI;
import java.awt.Color;
import java.awt.Graphics;

/**
 * @author https://github.com/vincenzopalazzo
 */

public class MaterialRadioButtonMenuItemUI extends BasicRadioButtonMenuItemUI {

	public static ComponentUI createUI (JComponent c) {
		return new MaterialRadioButtonMenuItemUI ();
	}

	@Override
	public void installUI (JComponent c) {
		super.installUI (c);
		JRadioButtonMenuItem j = (JRadioButtonMenuItem) c;
		//j.setBackground(MaterialColors.WHITE);
		j.setBorder (UIManager.getBorder ("MenuItem.border"));
	}

	@Override
	public void paint (Graphics g, JComponent c) {
		super.paint (MaterialDrawingUtils.getAliasedGraphics (g), c);
	}

	@Override
	protected void paintMenuItem (Graphics g, JComponent c, Icon checkIcon, Icon arrowIcon, Color background, Color foreground, int defaultTextIconGap) {
		JRadioButtonMenuItem j = (JRadioButtonMenuItem) c;
		if (j.isSelected ()) {
			super.paintMenuItem (MaterialDrawingUtils.getAliasedGraphics (g), c, UIManager.getIcon ("RadioButtonMenuItem.selectedCheckIcon"), arrowIcon, background, foreground, defaultTextIconGap);
			return;
		}
		super.paintMenuItem (MaterialDrawingUtils.getAliasedGraphics (g), c, UIManager.getIcon ("RadioButtonMenuItem.checkIcon"), arrowIcon, background, foreground, defaultTextIconGap);
	}
}
