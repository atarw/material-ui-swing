package mdlaf.components.toolbar;

import mdlaf.resources.MaterialBorders;
import mdlaf.resources.MaterialColors;
import mdlaf.resources.MaterialDrawingUtils;
import mdlaf.resources.MaterialFonts;

import javax.swing.JComponent;
import javax.swing.JToolBar;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicToolBarUI;
import java.awt.Color;
import java.awt.Graphics;

public class MaterialToolBarUI extends BasicToolBarUI {

	public static ComponentUI createUI (JComponent c) {
		return new MaterialToolBarUI ();
	}

	@Override
	public void installUI (JComponent c) {
		super.installUI (c);
		JToolBar toolBar = (JToolBar) c;

		toolBar.setFont (MaterialFonts.REGULAR);
		toolBar.setBackground (Color.WHITE);
		toolBar.setForeground (Color.BLACK);
		toolBar.setBorder (MaterialBorders.LIGHT_SHADOW_BORDER);

		this.dockingBorderColor = null;
		this.floatingBorderColor = null;
		this.dockingColor = MaterialColors.LIGHT_GREEN_A100;
		this.floatingColor = MaterialColors.GRAY_200;
	}

	@Override
	public void paint (Graphics g, JComponent c) {
		super.paint (MaterialDrawingUtils.getAliasedGraphics (g), c);
	}
}
