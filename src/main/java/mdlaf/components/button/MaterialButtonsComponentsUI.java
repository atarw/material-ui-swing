/*
 * MIT License
 *
 * Copyright (c) 2019-2020 Vincenzo Palazzo vincenzopalazzo1996@gmail.com
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package mdlaf.components.button;

import java.awt.*;
import javax.swing.*;

/**
 * This component is a helper component to make a button that is without border in any case this
 * type of component it is useful in the library because help us to refactoring the code in only one
 * class and have the power to make the change in one place.
 *
 * <p>The component that use this helper component are - JSpinner - JComboBox - TitlePane buttons -
 * other minors component around the library.
 *
 * @author https://github.com/vincenzopalazzo
 */
public class MaterialButtonsComponentsUI extends MaterialButtonUI {

  @Override
  public void installUI(JComponent c) {
    borderEnabled = false;
    mouseHoverEnabled = false;
    super.installUI(c);
    buttonBorderToAll = false;
  }

  @Override
  protected void paintFocus(
      Graphics g, AbstractButton b, Rectangle viewRect, Rectangle textRect, Rectangle iconRect) {}

  @Override
  protected void paintBorderButton(Graphics graphics, JComponent b) {}
}
