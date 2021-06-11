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
package mdlaf.animation;

import java.awt.*;
import javax.swing.*;

/**
 * @author https://github.com/vincenzopalazzo
 * @author https://github.com/atarw
 */
public class MaterialUIMovement {

  private MaterialUIMovement() {}

  /**
   * @deprecated This method will be deprecated inside the version 1.2 of the library. you can @see
   *     getMovement method
   */
  @Deprecated
  public static void add(JComponent c, Color fadeTo, int steps, int interval) {
    new MaterialUITimer(c, fadeTo, steps, interval);
  }

  /**
   * @deprecated This method will be deprecated inside the version 1.2 of the library. you can @see
   *     getMovement method
   */
  @Deprecated
  public static void add(JComponent c, Color fadeTo) {
    add(c, fadeTo, 5, 1000 / 60);
  }

  public static MaterialUITimer getMovement(JComponent c, Color fadeTo, int steps, int interval) {
    return new MaterialUITimer(c, fadeTo, steps, interval);
  }

  public static MaterialUITimer getMovement(JComponent c, Color fadeTo) {
    return getMovement(c, fadeTo, 5, 1000 / 30);
  }

  /**
   * This method create a new effect mouse hover static, not create a wake effect This method is
   * util in all component for click, an example: The button for JSpinner, JCombobox, JScroolbar
   * param c is the component param colorEffect is the color for effect, (For using color, look the
   * MaterialColors class) param colorOnClick is the color of the component on click on it return a
   * new MaterialUIStaticMovement this class implement a only MouseListner for moment
   *
   * @author https://github.com/vincenzopalazzo
   * @deprecated This method will be removed inside the version 1.2, because with the new
   *     MaterialButtonApi, you can create a personal instance of the button, with an personal
   *     Listener, @see MaterialButtonUI
   */
  @Deprecated
  public static MaterialMouseHover getStaticMovement(
      JComponent c, Color colorEffect, Color colorOnClick) {
    if (c == null || colorEffect == null || colorOnClick == null) {
      throw new IllegalArgumentException("Che input arguments is/are null");
    }
    return new MaterialUIStaticMovement(c.getBackground(), colorEffect, colorOnClick);
  }
}
