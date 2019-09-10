package mdlaf.components.progressbar;

import mdlaf.utils.MaterialDrawingUtils;

import javax.swing.*;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicProgressBarUI;
import java.awt.*;

/**
 * @author https://github.com/vincenzopalazzo
 */
public class MaterialProgressBarUI extends BasicProgressBarUI {

	public static ComponentUI createUI (JComponent c) {
		return new MaterialProgressBarUI ();
	}

	@Override
	public void installUI (JComponent c) {
		super.installUI (c);

		JProgressBar progressBar = (JProgressBar) c;
		progressBar.setBorder (UIManager.getBorder("ProgressBar.border"));
		progressBar.setBackground (UIManager.getColor("ProgressBar.background"));
		progressBar.setForeground (UIManager.getColor("ProgressBar.foreground"));
	}

	@Override
	public void uninstallUI(JComponent c) {

		c.setFont (null);
		c.setBackground (null);
		c.setForeground (null);
		c.setBorder (null);
		c.setCursor(null);

		super.uninstallUI(c);
	}

	@Override
	public void paint (Graphics g, JComponent c) {
		super.paint (MaterialDrawingUtils.getAliasedGraphics (g), c);
	}
}
