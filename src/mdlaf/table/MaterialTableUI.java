package mdlaf.table;

import mdlaf.MaterialBorders;
import mdlaf.MaterialColors;
import mdlaf.MaterialFonts;

import javax.swing.JComponent;
import javax.swing.JTable;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicTableUI;
import java.awt.Color;
import java.awt.Graphics;

public class MaterialTableUI extends BasicTableUI {

	public static ComponentUI createUI (final JComponent c) {
		return new MaterialTableUI ();
	}

	@Override
	public void installUI (JComponent c) {
		super.installUI (c);

		JTable table = (JTable) c;
		table.setOpaque (false);
		table.setSelectionBackground (MaterialColors.LIGHT_GRAY);
		table.setSelectionForeground (Color.BLACK);
		table.setBackground (Color.WHITE);
		table.setFont (MaterialFonts.REGULAR);

		table.getTableHeader ().setResizingAllowed (true);
		table.setRowHeight (table.getRowHeight () + 25);

		//table.setFillsViewportHeight (true);
		//table.setPreferredScrollableViewportSize (table.getPreferredSize ());

		table.setBorder (MaterialBorders.LIGHT_LINE_BORDER);
		table.setGridColor (MaterialColors.LIGHT_GRAY);

		table.setSelectionBackground (MaterialColors.bleach (MaterialColors.LIGHT_GRAY, 0.5f));

		table.setDefaultRenderer (Object.class, new MaterialTableCellRenderer ());
		table.setDefaultEditor (Object.class, new MaterialTableCellEditor ());
	}

	@Override
	public void paint (Graphics g, JComponent c) {
		super.paint (g, c);
	}
}
