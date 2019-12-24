package mdlaf.components.toolbar;

import mdlaf.utils.MaterialDrawingUtils;

import javax.swing.JComponent;
import javax.swing.JToolBar;
import javax.swing.UIManager;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicToolBarUI;
import java.awt.Graphics;

/**
 * @author https://github.com/vincenzopalazzo
 * @author https://github.com/atarw
 */
public class MaterialToolBarUI extends BasicToolBarUI {

	public static ComponentUI createUI (JComponent c) {
		return new MaterialToolBarUI ();
	}

	@Override
	public void installUI (JComponent c) {
		super.installUI (c);
		JToolBar toolBar = (JToolBar) c;

		toolBar.setFont (UIManager.getFont ("ToolBar.font"));
		toolBar.setBackground (UIManager.getColor ("ToolBar.background"));
		toolBar.setForeground (UIManager.getColor ("ToolBar.foreground"));
		toolBar.setBorder (UIManager.getBorder ("ToolBar.border"));

		this.dockingBorderColor = null;
		this.floatingBorderColor = null;
		this.dockingColor = UIManager.getColor ("ToolBar.dockingBackground");
		this.floatingColor = UIManager.getColor ("ToolBar.floatingBackground");
	}

	@Override
	public void uninstallUI(JComponent c) {

		c.setFont (null);
		c.setBackground (null);
		c.setForeground (null);
		c.setBorder (null);
		c.setCursor(null);

		this.dockingColor = null;
		this.floatingColor = null;
		super.uninstallUI(c);
	}

	@Override
	public void paint (Graphics g, JComponent c) {
		super.paint (MaterialDrawingUtils.getAliasedGraphics (g), c);
	}
}
