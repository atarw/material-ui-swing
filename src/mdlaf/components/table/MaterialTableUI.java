package mdlaf.components.table;

import mdlaf.resources.MaterialBorders;
import mdlaf.resources.MaterialColors;
import mdlaf.resources.MaterialDrawingUtils;
import mdlaf.resources.MaterialFonts;

import javax.swing.JComponent;
import javax.swing.JTable;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicTableUI;
import java.awt.Color;
import java.awt.Graphics;

public class MaterialTableUI extends BasicTableUI {

	public static ComponentUI createUI (JComponent c) {
		return new MaterialTableUI ();
	}

	@Override
	public void installUI (JComponent c) {
		super.installUI (c);

		JTable table = (JTable) c;
		table.setOpaque (false);
		table.setSelectionBackground (MaterialColors.GRAY_200);
		table.setSelectionForeground (Color.BLACK);
		table.setBackground (Color.WHITE);
		table.setFont (MaterialFonts.REGULAR);

		table.getTableHeader ().setResizingAllowed (true);
		table.setRowHeight (table.getRowHeight () + 25);

		//table.setFillsViewportHeight (true);
		//table.setPreferredScrollableViewportSize (table.getPreferredSize ());

		table.setBorder (MaterialBorders.LIGHT_LINE_BORDER);
		table.setGridColor (MaterialColors.GRAY_200);

		table.setSelectionBackground (MaterialColors.bleach (MaterialColors.GRAY_200, 0.5f));

		table.setDefaultRenderer (Object.class, new MaterialTableCellRenderer ());
		table.setDefaultEditor (Object.class, new MaterialTableCellEditor ());
	}

	@Override
	public void paint (Graphics g, JComponent c) {
		super.paint (MaterialDrawingUtils.getAliasedGraphics (g), c);
	}
}
