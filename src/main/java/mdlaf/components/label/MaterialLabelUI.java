/**
 * MIT License
 *
 * Copyright (c) 2018-2020 atharva washimkar, Vincenzo Palazzo vincenzopalazzo1996@gmail.com
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
package mdlaf.components.label;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.UIManager;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicGraphicsUtils;
import javax.swing.plaf.basic.BasicLabelUI;
import java.awt.*;

/**
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

        JLabel label = (JLabel) c;
        label.setOpaque(UIManager.getBoolean("Label.opaque"));
        label.setFont(UIManager.getFont("Label.font"));
        label.setBackground(UIManager.getColor("Label.background"));
        label.setForeground(UIManager.getColor("Label.foreground"));
        label.setBorder(UIManager.getBorder("Label.border"));
    }

    @Override
    public void uninstallUI(JComponent c) {

        JLabel label = (JLabel) c;
        label.setFont(null);
        label.setBackground(null);
        label.setForeground(null);
        label.setBorder(null);

        super.uninstallUI(c);
    }

    @Override
    protected void paintDisabledText(JLabel l, Graphics g, String s, int textX, int textY) {
        int mnemIndex = l.getDisplayedMnemonicIndex();
        g.setColor(UIManager.getColor("Label.disabledForeground"));
       // SwingUtilities2.drawStringUnderlineCharAt(l, g, s, mnemIndex, textX, textY);
        BasicGraphicsUtils.drawStringUnderlineCharAt(g, s, mnemIndex, textX, textY); //This isn't deprecated
    }
}