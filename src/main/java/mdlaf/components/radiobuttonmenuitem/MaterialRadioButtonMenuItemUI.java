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
package mdlaf.components.radiobuttonmenuitem;

import java.awt.*;
import javax.swing.*;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicRadioButtonMenuItemUI;
import mdlaf.utils.MaterialDrawingUtils;

/** @author https://github.com/vincenzopalazzo */
public class MaterialRadioButtonMenuItemUI extends BasicRadioButtonMenuItemUI {

  public static ComponentUI createUI(JComponent c) {
    return new MaterialRadioButtonMenuItemUI();
  }

  @Override
  public void installUI(JComponent c) {
    super.installUI(c);
    c.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
  }

  @Override
  public void uninstallUI(JComponent c) {
    c.setCursor(Cursor.getDefaultCursor());
    super.uninstallUI(c);
  }

  @Override
  public void paint(Graphics g, JComponent c) {
    super.paint(MaterialDrawingUtils.getAliasedGraphics(g), c);
  }

  @Override
  protected void paintMenuItem(
      Graphics g,
      JComponent c,
      Icon checkIcon,
      Icon arrowIcon,
      Color background,
      Color foreground,
      int defaultTextIconGap) {
    JRadioButtonMenuItem j = (JRadioButtonMenuItem) c;
    g = MaterialDrawingUtils.getAliasedGraphics(g);
    if (j.isSelected()) {
      super.paintMenuItem(
          g,
          c,
          UIManager.getIcon("RadioButtonMenuItem.selectedCheckIcon"),
          arrowIcon,
          background,
          foreground,
          defaultTextIconGap);
      return;
    }
    super.paintMenuItem(
        g,
        c,
        UIManager.getIcon("RadioButtonMenuItem.checkIcon"),
        arrowIcon,
        background,
        foreground,
        defaultTextIconGap);
  }
}
