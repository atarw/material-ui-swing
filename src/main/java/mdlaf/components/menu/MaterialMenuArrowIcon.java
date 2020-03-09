/**
 * MIT License
 * <p>
 * Copyright (c) 2019-2020 Vincenzo Palazzo vincenzopalazzo1996@gmail.com
 * <p>
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * <p>
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 * <p>
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package mdlaf.components.menu;

import javax.swing.*;
import javax.swing.plaf.metal.MetalLookAndFeel;
import java.awt.*;

/**
 * @author https://github.com/vincenzopalazzo
 */
public class MaterialMenuArrowIcon implements Icon {

    @Override
    public void paintIcon(Component c, Graphics g, int x, int y) {
        JMenuItem b = (JMenuItem) c;
        ButtonModel model = b.getModel();

        g.translate(x, y);
        if (!model.isEnabled()) {
            g.setColor(UIManager.getColor(""));
        } else {
            if (model.isArmed() || (c instanceof JMenu && model.isSelected())) {
                g.setColor(UIManager.getColor("Menu[arrowIcon].hoverColor"));
            } else {
                g.setColor(UIManager.getColor("Menu[arrowIcon].color"));
            }
        }
        int[] xPoints = {0, 3, 3, 0};
        int[] yPoints = {0, 3, 4, 7};
        g.fillPolygon(xPoints, yPoints, 4);
        g.drawPolygon(xPoints, yPoints, 4);
        g.translate(-x, -y);
    }

    @Override
    public int getIconWidth() {
        return UIManager.getInt("Menu[arrowIcon].width");
    }

    @Override
    public int getIconHeight() {
        return UIManager.getInt("Menu[arrowIcon].height");
    }
}
