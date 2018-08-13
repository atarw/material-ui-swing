package mdlaf.components.progressbar;

import java.awt.Graphics;

import javax.swing.JComponent;
import javax.swing.JProgressBar;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicProgressBarUI;

import mdlaf.resources.MaterialBorders;
import mdlaf.resources.MaterialColors;
import mdlaf.resources.MaterialDrawingUtils;

public class MaterialProgressBarUI extends BasicProgressBarUI {
	
	public static ComponentUI createUI(JComponent c) {
		return new MaterialProgressBarUI();
	}

	@Override
	public void installUI(JComponent c) {
		super.installUI(c);
		if(c instanceof JProgressBar) {
			JProgressBar progressBar = (JProgressBar)c;
			progressBar.setBackground(MaterialColors.GRAY_300);
			progressBar.setBorder(MaterialBorders.LIGHT_LINE_BORDER);
			progressBar.setForeground(MaterialColors.LIGHT_BLUE_A400);
		}
		
	}

	@Override
	public void paint(Graphics g, JComponent c) {
		// TODO Auto-generated method stub
		super.paint(MaterialDrawingUtils.getAliasedGraphics(g), c);
	}
	
	

}
