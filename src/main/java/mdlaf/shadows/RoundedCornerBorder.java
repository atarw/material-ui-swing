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
package mdlaf.shadows;

import java.awt.*;
import java.awt.geom.Area;
import java.awt.geom.RoundRectangle2D;
import java.util.Objects;
import javax.swing.*;
import javax.swing.border.AbstractBorder;
import mdlaf.utils.MaterialColors;
import mdlaf.utils.MaterialDrawingUtils;

/** @author https://github.com/vincenzopalazzo */
public class RoundedCornerBorder extends AbstractBorder {

  protected int arch = 12; // default value
  protected Color colorLine;
  protected float withBorder = 1.2f;

  public RoundedCornerBorder() {
    colorLine = MaterialColors.LIGHT_BLUE_400;
  }

  public RoundedCornerBorder(Color colorLine) {
    this.colorLine = colorLine;
  }

  public RoundedCornerBorder(Color colorLine, int arch) {
    this.colorLine = colorLine;
    this.arch = arch;
  }

  public RoundedCornerBorder(int arch, Color colorLine, float withBorder) {
    this.arch = arch;
    this.colorLine = colorLine;
    this.withBorder = withBorder;
  }

  @Override
  public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
    g = MaterialDrawingUtils.getAliasedGraphics(g);
    Graphics2D g2 = (Graphics2D) g.create();
    g2.setStroke(new BasicStroke(withBorder));
    int r = arch;
    int w = width - 1;
    int h = height - 1;

    Area round = new Area(new RoundRectangle2D.Double(x, y, w, h, r, r));
    if (c instanceof JPopupMenu) {
      g2.setPaint(c.getBackground());
      g2.fill(round);
    } else {
      Container parent = c.getParent();
      if (Objects.nonNull(parent)) {
        g2.setPaint(parent.getBackground());
        Area corner = new Area(new RoundRectangle2D.Float(x, y, width, height, r, r));
        corner.subtract(round);
        g2.fill(corner);
      }
    }
    g2.setPaint(colorLine);
    g2.draw(round);
    g2.dispose();
  }

  @Override
  public Insets getBorderInsets(Component c) {
    return new Insets(4, 8, 4, 8);
  }

  @Override
  public Insets getBorderInsets(Component c, Insets insets) {
    insets.set(4, 8, 4, 8);
    return insets;
  }
}
