package mdlaf.components.menubar;

import mdlaf.utils.MaterialDrawingUtils;

import javax.swing.JComponent;
import javax.swing.JMenuBar;
import javax.swing.UIManager;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicMenuBarUI;
import java.awt.Graphics;

public class MaterialMenuBarUI extends BasicMenuBarUI {

	public static ComponentUI createUI (JComponent c) {
		return new MaterialMenuBarUI ();
	}

	@Override
	public void installUI (JComponent c) {
		super.installUI (c);

		JMenuBar menuBar = (JMenuBar) c;
		menuBar.setFont (UIManager.getFont ("MenuBar.font"));
		menuBar.setBackground (UIManager.getColor ("MenuBar.background"));
		menuBar.setBorder (UIManager.getBorder ("MenuBar.border"));
		menuBar.setForeground (UIManager.getColor ("MenuBar.foreground"));
	}

	@Override
	public void paint (Graphics g, JComponent c) {
		super.paint (MaterialDrawingUtils.getAliasedGraphics (g), c);
	}
}
