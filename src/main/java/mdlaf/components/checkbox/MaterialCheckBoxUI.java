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
package mdlaf.components.checkbox;

import javax.swing.*;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.metal.MetalCheckBoxUI;
import java.awt.*;

/**
 * @author https://github.com/vincenzopalazzo
 * @author https://github.com/atarw
 */
public class MaterialCheckBoxUI extends MetalCheckBoxUI {

    public static ComponentUI createUI(JComponent c) {
        return new MaterialCheckBoxUI();
    }


    @Override
    public void installUI(JComponent c) {
        super.installUI(c);

        JCheckBox checkBox = (JCheckBox) c;
        //checkBox.setFont(UIManager.getFont("CheckBox.font"));
        //checkBox.setBackground(UIManager.getColor("CheckBox.background"));
        //checkBox.setForeground(UIManager.getColor("CheckBox.foreground"));
        checkBox.setIcon(UIManager.getIcon("CheckBox.icon"));
        checkBox.setSelectedIcon(UIManager.getIcon("CheckBox.selectedIcon"));
        checkBox.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }

    @Override
    public void uninstallUI(JComponent c) {

       // JCheckBox checkBox = (JCheckBox) c;
       // checkBox.setFont(null);
        //checkBox.setBackground(null);
        //checkBox.setForeground(null);
        //checkBox.setIcon(null);
        //checkBox.setSelectedIcon(null);
        c.setCursor(Cursor.getDefaultCursor());

        super.uninstallUI(c);
    }

    @Override
    public void paint(Graphics g, JComponent c) {
        super.paint(g, c);
    }


    @Override //TODO support change icon for future when is focus
    protected void paintFocus(Graphics g, Rectangle textRect, Dimension size) {
        //super.paintFocus(g, textRect, size);
    }

}
