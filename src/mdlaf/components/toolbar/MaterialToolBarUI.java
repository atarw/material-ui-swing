package mdlaf.components.toolbar;
import java.awt.Graphics;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JToolBar;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicToolBarUI;
import mdlaf.resources.MaterialBorders;
import mdlaf.resources.MaterialColors;
import mdlaf.resources.MaterialDrawingUtils;
import mdlaf.resources.MaterialFonts;

/**
 * 
 * @author https://github.com/vincenzopalazzo
 *
 */

public class MaterialToolBarUI extends BasicToolBarUI{
	
	private static final boolean DEBUG = false;
	
	public static ComponentUI createUI (JComponent c) {
		return new MaterialToolBarUI();
	}

	@Override
	public void installUI(JComponent c) {
		if(!(c instanceof JToolBar)) {
			if(DEBUG) System.out.println("Ok il componente non è un JtollBar di MaterialtoolBar");
			return;
		}
		super.installUI(c);
		if(DEBUG) System.out.println("Ok mi trovo nell istallUI di MaterialtoolBar");
		JToolBar toolBar = (JToolBar)c;
		toolBar.setFont(MaterialFonts.REGULAR);
		toolBar.setBackground(MaterialColors.WHITE);
		toolBar.setForeground(MaterialColors.BLACK);
		toolBar.setBorder (BorderFactory.createCompoundBorder(MaterialBorders.LIGHT_SHADOW_BORDER, BorderFactory.createEmptyBorder(2, 2, 2, 2)));
		
		//Cosa sto facendo ora??
		this.dockingBorderColor = null;
		this.floatingBorderColor = null;
		this.dockingColor = MaterialColors.LIGHT_GREEN_A100;
		this.floatingColor = MaterialColors.GRAY_200;
	}

	@Override
	public void paint(Graphics g, JComponent c) {
		super.paint(MaterialDrawingUtils.getAliasedGraphics(g), c);
	}
}
