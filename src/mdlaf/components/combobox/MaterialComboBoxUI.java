package mdlaf.components.combobox;

import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicComboBoxUI;

import com.sun.corba.se.impl.protocol.BootstrapServerRequestDispatcher;

import mdlaf.resources.MaterialBorders;
import mdlaf.resources.MaterialColors;
import mdlaf.resources.MaterialDrawingUtils;
import mdlaf.resources.MaterialFonts;
import mdlaf.resources.MaterialImages;

/**
 * 
 * @author https://github.com/vincenzopalazzo
 *
 */

public class MaterialComboBoxUI extends BasicComboBoxUI{
	
	public static ComponentUI createUI(JComponent c) {
		return new MaterialComboBoxUI();
	}

	@Override
	public void installUI(JComponent c) {
		super.installUI(c);
		JComboBox<?> comboBox = (JComboBox<?>) c;
		comboBox.setFont(MaterialFonts.BLACK_ITALIC);
		comboBox.setBackground(MaterialColors.GRAY_300);
		comboBox.setForeground(MaterialColors.GRAY_800);
		comboBox.setBorder(BorderFactory.createEmptyBorder());
		comboBox.setRenderer(new MaterialComboBoxRender());
	}	

	@Override
	protected JButton createArrowButton() {
		JButton button = new JButton(new ImageIcon(MaterialImages.DOWN_ARROW));
		button.setOpaque(true);
		button.setBorder(BorderFactory.createEmptyBorder());
		button.setBackground(MaterialColors.GRAY_300);
		return button;
	}

	@Override
	public void paint(Graphics g, JComponent c) {
		super.paint(MaterialDrawingUtils.getAliasedGraphics(g), c);
	}
	
	
	
	
	
	
}
