package mdlaf.components.table;

import mdlaf.utils.MaterialDrawingUtils;

import javax.swing.JComponent;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.event.MouseInputListener;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicTableUI;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class MaterialTableUI extends BasicTableUI {

	private boolean isClicched = false;

	public static ComponentUI createUI (JComponent c) {
		return new MaterialTableUI ();
	}

	@Override
	public void installUI (JComponent c) {
		super.installUI (c);

		JTable table = (JTable) c;
		table.setOpaque (false);
		table.setSelectionForeground (UIManager.getColor ("Table.selectionForeground"));
		table.setBackground (UIManager.getColor ("Table.background"));
		table.setFont (UIManager.getFont ("Table.font"));
		table.setBorder (UIManager.getBorder ("Table.border"));
		table.setGridColor (UIManager.getColor ("Table.gridColor"));
		table.setSelectionBackground (UIManager.getColor ("Table.selectionBackground"));

		table.getTableHeader ().setResizingAllowed (true);
		int rowHeight = UIManager.getInt ("Table.rowHeight");
		if (rowHeight > 0) {
			table.setRowHeight (rowHeight);
		}
		else {
			table.setRowHeight (table.getRowHeight () + 25);
		}

		table.setDefaultRenderer (Object.class, new MaterialTableCellRenderer ());
		table.setDefaultEditor (Object.class, new MaterialTableCellEditor ());
		table.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	}

	@Override
	protected MouseInputListener createMouseInputListener() {
		return new MouseHoverEffect();
	}

	@Override
	public void paint (Graphics g, JComponent c) {
		super.paint (MaterialDrawingUtils.getAliasedGraphics (g), c);
	}

	private class MouseHoverEffect  implements MouseListener, MouseMotionListener, MouseInputListener {

		@Override
		public void mouseDragged(MouseEvent e) {

		}

		public void mouseMoved(MouseEvent e){
			if (isClicched){
				return;
			}
			JTable table = (JTable) e.getSource();
			if(!table.isEnabled()){
				return;
			}
			int row = table.rowAtPoint(e.getPoint());

			if (row > -1){
				table.clearSelection();
				table.setSelectionBackground(UIManager.getColor("Table.selectionBackground"));
				table.setSelectionForeground(UIManager.getColor("Table.selectionForeground"));
				table.setRowSelectionInterval(row, row);
			}else{
				table.setSelectionBackground(UIManager.getColor("Table.background"));
				table.setSelectionForeground(UIManager.getColor("Table.foreground"));
			}
		}

		@Override
		public void mouseClicked(MouseEvent e) {

		}

		@Override
		public void mousePressed(MouseEvent e) {
			if(isClicched){
				isClicched = false;
				mouseMoved(e);
				return;
			}
			isClicched = true;
		}

		@Override
		public void mouseReleased(MouseEvent e) {

		}

		@Override
		public void mouseEntered(MouseEvent e) {
		}

		@Override
		public void mouseExited(MouseEvent e) {
			JTable table = (JTable) e.getSource();
			if(!table.isEnabled() || isClicched){
				return;
			}
			table.clearSelection();
		}
	}
}
