/**
 * MIT License
 *
 * <p>Copyright (c) 2018-2020 atharva washimkar, Vincenzo Palazzo vincenzopalazzo1996@gmail.com
 * Copyright (c) 2021 Vincenzo Palazzo vincenzopalazzodev@gmail.com
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
package mdlaf.components.combobox;

import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.UIResource;
import javax.swing.plaf.basic.BasicComboBoxUI;
import javax.swing.plaf.basic.BasicComboPopup;
import javax.swing.plaf.basic.ComboPopup;
import mdlaf.animation.MaterialUIMovement;
import mdlaf.components.button.MaterialButtonsComponentsUI;
import mdlaf.utils.MaterialBorders;
import mdlaf.utils.MaterialDrawingUtils;

/**
 * @author https://github.com/vincenzopalazzo
 * @author https://github.com/atarw
 */
public class MaterialComboBoxUI extends BasicComboBoxUI {

  public static ComponentUI createUI(JComponent c) {
    return new MaterialComboBoxUI();
  }

  protected JButton arrowButton;
  protected Color background;
  protected FocusListenerColor focusListener;
  protected int arc = 10; // default value
  protected Border disabledBorder;

  @Override
  public void installUI(JComponent c) {
    super.installUI(c);
    background = UIManager.getColor("ComboBox.background");
    comboBox.setLightWeightPopupEnabled(true);
    comboBox.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    comboBox.setFocusable(UIManager.getBoolean("ComboBox.focusable"));
    this.disabledBorder =
        MaterialBorders.roundedLineColorBorder(UIManager.getColor("ComboBox.disabledColor"), arc);
  }

  @Override
  protected void installDefaults() {
    super.installDefaults();
    this.arc = UIManager.getInt("ComboBox.arc");
  }

  @Override
  public void uninstallUI(JComponent c) {
    super.uninstallUI(comboBox);
  }

  @Override
  public void paint(Graphics g, JComponent c) {
    super.paint(g, c);
    if (!c.isEnabled()) {
      c.setBorder(this.disabledBorder);
    }
  }

  @Override
  protected JButton createArrowButton() {
    this.arrowButton = new ArrowButtonComboBox();
    return arrowButton;
  }

  @Override
  protected ComboPopup createPopup() {
    return new MaterialComboBoxPopup(comboBox);
  }

  @Override
  public void unconfigureArrowButton() {
    super.unconfigureArrowButton();
  }

  @Override
  protected void installListeners() {
    super.installListeners();
    focusListener = new FocusListenerColor();
    comboBox.addFocusListener(focusListener);
  }

  @Override
  protected void uninstallListeners() {
    if (focusListener != null) {
      this.comboBox.removeFocusListener(focusListener);
    }
    super.uninstallListeners();
  }

  @Override
  public void update(Graphics g, JComponent c) {
    g = MaterialDrawingUtils.getAliasedGraphics(g);
    g.setColor(c.getBackground());
    g.fillRoundRect(0, 0, comboBox.getWidth(), comboBox.getHeight(), arc, arc);
    paint(g, c);
  }

  @Override
  public void paintCurrentValue(Graphics g, Rectangle bounds, boolean hasFocus) {
    ListCellRenderer renderer = comboBox.getRenderer();
    Component c;

    if (hasFocus && !isPopupVisible(comboBox)) {
      c =
          renderer.getListCellRendererComponent(
              listBox, comboBox.getSelectedItem(), -1, true, false);
    } else {
      c =
          renderer.getListCellRendererComponent(
              listBox, comboBox.getSelectedItem(), -1, false, false);
      c.setBackground(UIManager.getColor("ComboBox.background"));
    }
    c.setFont(comboBox.getFont());

    if (comboBox.isEnabled()) {
      c.setForeground(comboBox.getForeground());
      c.setBackground(comboBox.getBackground());
    } else {
      c.setForeground(UIManager.getColor("ComboBox.disabledForeground"));
      c.setBackground(UIManager.getColor("ComboBox.disabledBackground"));
    }

    // Fix for 4238829: should lay out the JPanel.
    boolean shouldValidate = false;
    if (c instanceof JPanel) {
      shouldValidate = true;
    }

    int x = bounds.x, y = bounds.y, w = bounds.width, h = bounds.height;
    if (padding != null) {
      x = bounds.x + padding.left;
      y = bounds.y + padding.top;
      w = bounds.width - (padding.left + padding.right);
      h = bounds.height - (padding.top + padding.bottom);
    }

    currentValuePane.paintComponent(g, c, comboBox, x, y, w, h, shouldValidate);
  }

  @Override
  protected ListCellRenderer createRenderer() {
    return new MaterialComboBoxRenderer();
  }

  @Override
  protected ComboBoxEditor createEditor() {
    return new MaterialComboBoxEditor();
  }

  @Override
  protected FocusListener createFocusListener() {
    if (comboBox.isFocusable()) {
      comboBox.addFocusListener(focusListener);
    }
    return super.createFocusListener();
  }

  protected class FocusListenerColor implements FocusListener {

    protected Border focus;
    protected Border unfocus;
    protected Border disabled;

    public FocusListenerColor() {
      focus =
          MaterialBorders.roundedLineColorBorder(UIManager.getColor("ComboBox.focusColor"), arc);
      unfocus =
          MaterialBorders.roundedLineColorBorder(UIManager.getColor("ComboBox.unfocusColor"), arc);
    }

    @Override
    public void focusGained(FocusEvent e) {
      if (e.getComponent() == null) {
        return;
      }
      JComboBox cb = (JComboBox) e.getComponent();
      if (focus != null) {
        cb.setBorder(focus);
        cb.revalidate();
      }
    }

    @Override
    public void focusLost(FocusEvent e) {
      if (e.getComponent() == null) {
        return;
      }
      JComboBox cb = (JComboBox) e.getComponent();
      if (unfocus != null) {
        cb.setBorder(unfocus);
        cb.revalidate();
      }
    }
  }

  protected class MaterialComboBoxPopup extends BasicComboPopup {

    public MaterialComboBoxPopup(JComboBox<?> combo) {
      super(combo);
      setBorder(UIManager.getBorder("ComboBox[listItem].border"));
    }

    @Override
    public void show() {
      super.show();
      if (arrowButton != null) {
        arrowButton.repaint();
      }
    }

    @Override
    public void hide() {
      super.hide();
      if (arrowButton != null) {
        arrowButton.repaint();
      }
    }

    @Override
    protected void firePopupMenuCanceled() {
      super.firePopupMenuCanceled();
      if (arrowButton != null) {
        arrowButton.repaint();
      }
    }
  }

  protected class ArrowButtonComboBox extends JButton {

    @Override
    public void updateUI() {
      this.setUI(new ArrowButtonComboboxBoxUI());
    }

    protected class ArrowButtonComboboxBoxUI extends MaterialButtonsComponentsUI {

      @Override
      public void installUI(JComponent c) {
        super.installUI(c);
        super.background = UIManager.getColor("ComboBox.buttonBackground");
        super.disabledBackground = super.background;
        c.setBackground(super.background);
        mouseHoverEnabled = UIManager.getBoolean("ComboBox.mouseHoverEnabled");
        if (mouseHoverEnabled) {
          c.addMouseListener(
              MaterialUIMovement.getMovement(
                  arrowButton, UIManager.getColor("ComboBox.mouseHoverColor")));
        }
        this.button.setIcon(new ArrowIcon("ComboBox."));
        c.setBorder(UIManager.getBorder("ComboBox[button].border"));
      }
    }

    protected class ArrowIcon implements Icon, UIResource {

      protected Icon unselectedIcon;
      protected Icon selectedIcon;
      protected Icon disabledIcon;

      public ArrowIcon(String prefix) {
        this.unselectedIcon = UIManager.getIcon(prefix + "buttonIcon");
        this.disabledIcon = UIManager.getIcon(prefix + "buttonDisabledIcon");
        this.selectedIcon = UIManager.getIcon(prefix + "buttonSelectIcon");
      }

      @Override
      public void paintIcon(Component c, Graphics g, int x, int y) {
        if (comboBox.isEnabled()) {
          if (comboBox.isPopupVisible()) {
            this.selectedIcon.paintIcon(c, g, x, y);
          } else {
            this.unselectedIcon.paintIcon(c, g, x, y);
          }
        } else {
          this.disabledIcon.paintIcon(c, g, x, y);
        }
      }

      @Override
      public int getIconWidth() {
        return unselectedIcon.getIconWidth();
      }

      @Override
      public int getIconHeight() {
        return unselectedIcon.getIconHeight();
      }
    }
  }
}
