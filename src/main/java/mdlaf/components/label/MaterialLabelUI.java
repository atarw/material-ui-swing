/**
 * MIT License
 *
 * <p>Copyright (c) 2018-2020 atharva washimkar, Vincenzo Palazzo vincenzopalazzodev@gmail.com
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
package mdlaf.components.label;

import java.awt.*;
import javax.swing.*;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicGraphicsUtils;
import javax.swing.plaf.basic.BasicLabelUI;
import mdlaf.utils.MaterialDrawingUtils;

/**
 * The don't set your personal opaque value at the component because This component is used in a lot
 * other component and you can broke somethings. Stack Overflow
 * https://stackoverflow.com/a/2452381/10854225
 *
 * @author https://github.com/vincenzopalazzo
 * @author https://github.com/atarw
 */
public class MaterialLabelUI extends BasicLabelUI {

  public static ComponentUI createUI(JComponent c) {
    return new MaterialLabelUI();
  }

  @Override
  public void installUI(JComponent c) {
    super.installUI(c);
  }

  @Override
  public void uninstallUI(JComponent c) {
    super.uninstallUI(c);
  }

  @Override
  protected void paintEnabledText(JLabel l, Graphics g, String s, int textX, int textY) {

    super.paintEnabledText(l, MaterialDrawingUtils.getAliasedGraphics(g), s, textX, textY);
  }

  @Override
  protected void paintDisabledText(JLabel l, Graphics g, String s, int textX, int textY) {
    int mnemIndex = l.getDisplayedMnemonicIndex();
    g.setColor(UIManager.getColor("Label.disabledForeground"));
    BasicGraphicsUtils.drawStringUnderlineCharAt(
        MaterialDrawingUtils.getAliasedGraphics(g),
        s,
        mnemIndex,
        textX,
        textY); // This isn't deprecated
  }
}
