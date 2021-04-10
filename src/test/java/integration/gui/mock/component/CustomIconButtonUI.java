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
package integration.gui.mock.component;

import java.awt.*;
import javax.swing.*;
import mdlaf.components.button.MaterialButtonUI;
import mdlaf.utils.MaterialColors;

/** @author https://github.com/vincenzopalazzo */
public class CustomIconButtonUI extends MaterialButtonUI {

  @Override
  public void installUI(JComponent c) {
    this.mouseHoverEnabled = false;
    super.installUI(c);
    this.buttonBorderToAll = false;
    this.borderEnabled = false;
    this.background = MaterialColors.PINK_700;
    this.button.setFocusable(false);
    this.disabledBackground = this.background;
    this.button.setBackground(this.background);
  }

  @Override // Make sure that you disable the focus paint from the button.
  protected void paintFocusRing(Graphics g, JButton b) {}
}
