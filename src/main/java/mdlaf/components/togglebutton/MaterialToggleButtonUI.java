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
package mdlaf.components.togglebutton;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.UIResource;
import javax.swing.plaf.basic.BasicToggleButtonUI;
import mdlaf.utils.MaterialDrawingUtils;

/**
 * @author https://github.com/vincenzopalazzo
 * @author https://github.com/atarw
 * @author https://github.com/downToHell
 */
public class MaterialToggleButtonUI extends BasicToggleButtonUI {

  protected Boolean withoutIcon;
  protected JToggleButton toggleButton;
  protected Color withoutIconSelectedBackground;
  protected Color withoutIconSelectedForeground;
  protected Color withoutIconBackground;
  protected Color withoutIconForeground;
  protected Color disabledForeground;
  protected Icon selected;
  protected Icon unselected;
  protected Border withoutIconSelectedBorder;
  protected Border withoutIconBorder;

  public static ComponentUI createUI(JComponent c) {
    return new MaterialToggleButtonUI();
  }

  @Override
  public void installUI(JComponent c) {
    super.installUI(c);
    toggleButton = (JToggleButton) c;
    this.disabledForeground = UIManager.getColor("RadioButton.disabledText");
    c.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    /*
    If the expression toggleButton.getIcon() == null && toggleButton.getSelectedIcon() == null is false the JToggleButton have the
    personal icon, how inside the JFileChooser. Now the are two cases
     1. The previous expression is true, so for this class, this event is a normal material JToggleButton;
     with these cases is possible another two cases like:
     1.1 The variable withoutIcon is false, so the effect like this:
     1.1 The variable withoutIcon if true, so the effect like this:
     2. if the expression toggleButton.getIcon() == null && toggleButton.getSelectedIcon() == null is false, for this class
        the JToggleButton has the icon set, an example is JFileChooser.
        To default, this class will set the variable without an icon to false and toggle button border to UIManager propriety.
     */
    if (toggleButton.getIcon() == null && toggleButton.getSelectedIcon() == null) {
      this.unselected = new MaterialToggleButtonIcon(this.getPropertyPrefix());
      this.withoutIcon = UIManager.getBoolean("ToggleButton.withoutIcon");
      if (withoutIcon) {
        withoutIconSelectedBorder = UIManager.getBorder("ToggleButton[withoutIcon].selectedBorder");
        withoutIconBorder = UIManager.getBorder("ToggleButton[withoutIcon].border");
        withoutIconSelectedBackground =
            UIManager.getColor("ToggleButton[withoutIcon].selectedBackground");
        withoutIconSelectedForeground =
            UIManager.getColor("ToggleButton[withoutIcon].selectedForeground");
        withoutIconBackground = UIManager.getColor("ToggleButton[withoutIcon].background");
        withoutIconForeground = UIManager.getColor("ToggleButton[withoutIcon].foreground");
        if (toggleButton.isSelected()) {
          LookAndFeel.installBorder(toggleButton, "ToggleButton[withoutIcon].background");
        } else {
          LookAndFeel.installBorder(toggleButton, "ToggleButton[withoutIcon].selectedForeground");
        }
      } else {
        toggleButton.setIcon(this.unselected);
        LookAndFeel.installBorder(toggleButton, "ToggleButton.border");
      }
    } else {
      LookAndFeel.installBorder(toggleButton, "ToggleButton.border");
      this.withoutIcon = Boolean.FALSE;
    }
  }

  @Override
  public void uninstallUI(JComponent c) {
    super.uninstallUI(c);
    JToggleButton toggleButton = (JToggleButton) c;
    boolean removeIcon =
        this.unselected == toggleButton.getIcon()
            && this.selected == toggleButton.getSelectedIcon();
    if (removeIcon) {
      toggleButton.setIcon(null);
      toggleButton.setSelectedIcon(null);
    }
  }

  @Override
  public void paint(Graphics g, JComponent c) {
    super.paint(g, c);

    if (withoutIcon != null && withoutIcon && isNotNullColor(withoutIcon)) {
      AbstractButton button = (AbstractButton) c;
      if (button.isSelected()) {
        button.setBackground(withoutIconSelectedBackground);
        button.setForeground(withoutIconSelectedForeground);
        button.setBorder(withoutIconSelectedBorder);
      } else {
        button.setBackground(withoutIconBackground);
        button.setForeground(withoutIconForeground);
        button.setBorder(withoutIconBorder);
      }
    }
  }

  private boolean isNotNullColor(boolean withoutIcon) {
    if (withoutIcon) {
      boolean selectedColorNotNull =
          withoutIconSelectedBackground != null && withoutIconSelectedForeground != null;
      boolean unselectColorNotNull = withoutIconBackground != null && withoutIconForeground != null;
      boolean borderNotNull = withoutIconBorder != null && withoutIconSelectedBorder != null;
      return selectedColorNotNull && unselectColorNotNull && borderNotNull;
    }
    // TODO complete this logic
    return true;
  }

  @Override
  protected void paintFocus(
      Graphics g, AbstractButton b, Rectangle viewRect, Rectangle textRect, Rectangle iconRect) {}

  @Override
  protected void paintText(Graphics g, JComponent c, Rectangle textRect, String text) {
    ButtonModel model = toggleButton.getModel();
    if (model.isEnabled()) {
      MaterialDrawingUtils.drawString(
          c,
          g,
          text,
          textRect,
          toggleButton.getDisplayedMnemonicIndex(),
          getTextShiftOffset(),
          toggleButton.getForeground());
      return;
    }
    MaterialDrawingUtils.drawString(
        c,
        g,
        text,
        textRect,
        toggleButton.getDisplayedMnemonicIndex(),
        getTextShiftOffset(),
        disabledForeground);
  }

  protected class MaterialToggleButtonIcon implements Icon, UIResource {

    protected Icon unselectedIcon;
    protected Icon selectedIcon;
    protected Icon disabledIcon;
    protected Icon disabledSelectedIcon;

    public MaterialToggleButtonIcon(String componentPrefix) {
      unselectedIcon = UIManager.getIcon(componentPrefix + "icon");
      selectedIcon = UIManager.getIcon(componentPrefix + "selectedIcon");
      disabledIcon = UIManager.getIcon(componentPrefix + "disabledIcon");
      disabledSelectedIcon = UIManager.getIcon(componentPrefix + "disabledSelectedIcon");
    }

    @Override
    public void paintIcon(Component c, Graphics g, int x, int y) {
      if (toggleButton.isEnabled()) {
        if (toggleButton.isSelected()) {
          this.selectedIcon.paintIcon(c, g, x, y);
        } else {
          this.unselectedIcon.paintIcon(c, g, x, y);
        }
      } else {
        if (toggleButton.isSelected()) {
          this.disabledSelectedIcon.paintIcon(c, g, x, y);
        } else {
          this.disabledIcon.paintIcon(c, g, x, y);
        }
      }
    }

    @Override
    public int getIconWidth() {
      return selectedIcon.getIconWidth();
    }

    @Override
    public int getIconHeight() {
      return selectedIcon.getIconHeight();
    }
  }
}
