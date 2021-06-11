/**
 * MIT License
 *
 * <p>Copyright (c) 2019-2021 Vincenzo Palazzo vincenzopalazzo1996@gmail.com
 *
 * <p>Permission is hereby granted, free of charge, to any person obtaining a copy of this software
 * and associated documentation files (the "Software"), to deal in the Software without restriction,
 * including without limitation the rights to use, copy, modify, merge, publish, distribute,
 * sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * <p>The above copyright notice and this permission notice shall be included in all copies or
 * substantial portions of the Software.
 *
 * <p>THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING
 * BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM,
 * DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package mdlaf.components.tree;

import java.awt.Component;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeCellEditor;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.TreeCellEditor;
import mdlaf.components.textfield.MaterialTextFieldUI;

/** @author https://github.com/vincenzopalazzo */
public class MaterialTreeCellEditor extends DefaultTreeCellEditor {

  private JTextField textField;

  public MaterialTreeCellEditor(JTree tree, DefaultTreeCellRenderer renderer) {
    super(tree, renderer);
    init();
  }

  public MaterialTreeCellEditor(
      JTree tree, DefaultTreeCellRenderer renderer, TreeCellEditor editor) {
    super(tree, renderer, editor);
    init();
  }

  private void init() {
    textField = new JTextField();
    textField.setUI(new MaterialTextFieldUI());

    textField.addKeyListener(
        new KeyAdapter() {
          @Override
          public void keyTyped(KeyEvent e) {
            if (e.getKeyChar() == KeyEvent.VK_ENTER) stopCellEditing();
          }
        });
  }

  @Override
  public Component getTreeCellEditorComponent(
      JTree tree, Object value, boolean isSelected, boolean expanded, boolean leaf, int row) {
    textField.setText(value.toString());
    return textField;
  }

  @Override
  public Object getCellEditorValue() {
    return textField.getText();
  }
}
