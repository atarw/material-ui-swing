package mdlaf.components.tree;

import mdlaf.components.textfield.MaterialTextFieldUI;

import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeCellEditor;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.TreeCellEditor;
import java.awt.Component;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class MaterialTreeCellEditor extends DefaultTreeCellEditor {

	private JTextField textField;

	public MaterialTreeCellEditor (JTree tree, DefaultTreeCellRenderer renderer) {
		super (tree, renderer);
		init ();
	}

	public MaterialTreeCellEditor (JTree tree, DefaultTreeCellRenderer renderer, TreeCellEditor editor) {
		super (tree, renderer, editor);
		init ();
	}

	private void init () {
		textField = new JTextField ();
		textField.setUI (new MaterialTextFieldUI ());

		textField.addKeyListener (new KeyAdapter () {
			@Override
			public void keyTyped (KeyEvent e) {
				if (e.getKeyChar () == KeyEvent.VK_ENTER)
					stopCellEditing ();
			}
		});
	}

	@Override
	public Component getTreeCellEditorComponent (JTree tree, Object value, boolean isSelected, boolean expanded, boolean leaf, int row) {
		textField.setText (value.toString ());
		return textField;
	}

	@Override
	public Object getCellEditorValue () {
		return textField.getText ();
	}
}
