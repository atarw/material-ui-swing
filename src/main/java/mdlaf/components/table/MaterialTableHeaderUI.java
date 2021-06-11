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
package mdlaf.components.table;

import java.awt.Graphics;
import javax.swing.*;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicTableHeaderUI;
import javax.swing.table.JTableHeader;
import mdlaf.utils.MaterialDrawingUtils;

/**
 * @author https://github.com/vincenzopalazzo
 * @author https://github.com/atarw
 */
public class MaterialTableHeaderUI extends BasicTableHeaderUI {

  public static ComponentUI createUI(JComponent c) {
    return new MaterialTableHeaderUI();
  }

  @Override
  public void installUI(JComponent c) {
    super.installUI(c);

    JTableHeader header = (JTableHeader) c;
    header.setDefaultRenderer(new MaterialTableHeaderCellRenderer());
    header.setBackground(UIManager.getColor("TableHeader.background"));
    header.setForeground(UIManager.getColor("TableHeader.foreground"));
    header.setFont(UIManager.getFont("TableHeader.font"));
    LookAndFeel.installBorder(c, "TableHeader.border");
  }

  @Override
  public void uninstallUI(JComponent c) {

    JTableHeader header = (JTableHeader) c;
    header.setDefaultRenderer(null);
    header.setBackground(null);
    header.setForeground(null);
    header.setFont(null);
    header.setBorder(null);

    super.uninstallUI(c);
  }

  @Override
  public void paint(Graphics g, JComponent c) {
    super.paint(MaterialDrawingUtils.getAliasedGraphics(g), c);
  }
}
