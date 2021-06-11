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
package mdlaf.components.textfield;

import java.awt.*;
import javax.swing.*;
import javax.swing.plaf.ComponentUI;

/**
 * @author https://github.com/vincenzopalazzo
 * @author https://github.com/atarw
 */
public class MaterialTextFieldUI extends MaterialComponentField {

  protected static final String ProprietyPrefix = "TextField";

  public MaterialTextFieldUI() {
    this(true);
  }

  public MaterialTextFieldUI(boolean drawLine) {
    super();
    this.drawLine = drawLine;
  }

  @Override
  protected String getPropertyPrefix() {
    return ProprietyPrefix;
  }

  public static ComponentUI createUI(JComponent c) {
    return new MaterialTextFieldUI();
  }

  @Override
  public void installUI(JComponent c) {
    super.installUI(c);
    installMyDefaults(c);
  }

  @Override
  protected void installDefaults() {
    super.installDefaults();
  }

  @Override
  public void uninstallUI(JComponent c) {
    super.uninstallUI(c);
    c.setCursor(Cursor.getDefaultCursor());
  }

  @Override
  protected void uninstallDefaults() {
    super.uninstallDefaults();
    getComponent().setBorder(null);
  }

  @Override
  protected void installListeners() {
    super.installListeners();
    getComponent().addFocusListener(focusListenerColorLine);
    getComponent().addPropertyChangeListener(propertyChangeListener);
    propertyChangeSupport.addPropertyChangeListener(propertyChangeListener);
  }

  @Override
  protected void uninstallListeners() {
    getComponent().removeFocusListener(focusListenerColorLine);
    getComponent().removePropertyChangeListener(propertyChangeListener);
    propertyChangeSupport.removePropertyChangeListener(propertyChangeListener);
    super.uninstallListeners();
  }

  @Override
  public void paintSafely(Graphics g) {
    super.paintSafely(g);
    paintLine(g);
    changeColorOnFocus(g);
  }
}
