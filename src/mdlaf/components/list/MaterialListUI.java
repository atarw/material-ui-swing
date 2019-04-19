/*
 * MIT License
 *
 * Copyright (c) 2019 Vincent Palazzo vincenzopalazzodev@gmail.com
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
package mdlaf.components.list;

import javax.swing.*;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicListUI;
import java.awt.*;

/**
 * @author https://github.com/vincenzopalazzo
 */
public class MaterialListUI extends BasicListUI {

    @SuppressWarnings({"MethodOverridesStaticMethodOfSuperclass", "UnusedDeclaration"})
    public static ComponentUI createUI(JComponent c) {
        return new MaterialListUI();
    }

    @Override
    public void installUI(JComponent c) {
        super.installUI(c);

        list = (JList) c;
        list.setBackground(UIManager.getColor("List.background"));
        list.setForeground(UIManager.getColor("List.foreground"));
        list.setBorder(UIManager.getBorder("List.border"));
        list.setFont(UIManager.getFont("List.font"));
        list.setSelectionBackground(UIManager.getColor("List.selectionBackground"));
        list.setSelectionForeground(UIManager.getColor("List.selectionForeground"));
        list.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        list.setFocusable(UIManager.getBoolean("List.focusable"));
    }

}
