package mdlaf.components.table;

import mdlaf.utils.MaterialDrawingUtils;

import javax.swing.*;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicTableHeaderUI;
import javax.swing.table.JTableHeader;
import java.awt.Graphics;

public class MaterialTableHeaderUI extends BasicTableHeaderUI {

	public static ComponentUI createUI (JComponent c) {
		return new MaterialTableHeaderUI ();
	}

	@Override
	public void installUI (JComponent c) {
		super.installUI (c);

		JTableHeader header = (JTableHeader) c;
		header.setDefaultRenderer (new MaterialTableHeaderCellRenderer ());
		header.setBackground(UIManager.getColor("TableHeader.background"));
		header.setForeground(UIManager.getColor("TableHeader.foreground"));
		header.setFont(UIManager.getFont("TableHeader.font"));
		header.setBorder(UIManager.getBorder("TableHeader.border"));
	}

	@Override
	public void paint (Graphics g, JComponent c) {
		super.paint (MaterialDrawingUtils.getAliasedGraphics (g), c);
	}
}
