package mdlaf.components.menubar;

import mdlaf.utils.MaterialDrawingUtils;

import javax.swing.JComponent;
import javax.swing.JMenuBar;
import javax.swing.UIManager;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicMenuBarUI;
import javax.swing.plaf.metal.MetalMenuBarUI;
import java.awt.*;

/**
 * @author https://github.com/vincenzopalazzo
 * @author https://github.com/atarw
 */
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
		menuBar.setForeground (UIManager.getColor ("MenuBar.foreground"));
		menuBar.setBorder (UIManager.getBorder ("MenuBar.border"));
	}

	@Override
	public void uninstallUI(JComponent c) {
		JMenuBar menuBar = (JMenuBar) c;
		menuBar.setFont (null);
		menuBar.setBackground (null);
		menuBar.setBorder (null);
		menuBar.setForeground (null);

		super.uninstallUI(c);
	}

	@Override
	public void paint (Graphics g, JComponent c) {
		super.paint (MaterialDrawingUtils.getAliasedGraphics (g), c);
	}
}
