/**
 * MIT License
 *
 * Copyright (c) 2017 atharva washimkar
 * Copyright (c) 2018 Vincent Palazzo
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
package mdlaf.components.formattertextfield;

import mdlaf.utils.MaterialDrawingUtils;

import javax.swing.*;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicFormattedTextFieldUI;
import java.awt.*;

/**
 * @author https://github.com/vincenzopalazzo
 */
public class MaterialFormattedTextFieldUI extends BasicFormattedTextFieldUI {


    @SuppressWarnings({"MethodOverridesStaticMethodOfSuperclass", "UnusedDeclaration"})
    public static ComponentUI createUI(JComponent c) {
        return new MaterialFormattedTextFieldUI();
    }

    @Override
    public void installUI(JComponent c) {
        super.installUI(c);
        JFormattedTextField formattedTextField = (JFormattedTextField) c;
        formattedTextField.setSelectionColor(UIManager.getColor("FormattedTextField.selectionBackground"));
        formattedTextField.setSelectedTextColor(UIManager.getColor("FormattedTextField.selectionForeground"));
        formattedTextField.setBackground(UIManager.getColor("FormattedTextField.inactiveBackground"));
        formattedTextField.setForeground(UIManager.getColor("FormattedTextField.inactiveForeground"));
        formattedTextField.setFont(UIManager.getFont("FormattedTextField.font"));
        formattedTextField.setBorder(UIManager.getBorder("FormattedTextField.border"));
    }

    @Override
    public void uninstallUI(JComponent c) {

        JFormattedTextField formattedTextField = (JFormattedTextField) c;
        formattedTextField.setSelectionColor(null);
        formattedTextField.setSelectedTextColor(null);
        formattedTextField.setBackground(null);
        formattedTextField.setForeground(null);
        formattedTextField.setFont(null);
        formattedTextField.setBorder(null);

        super.uninstallUI(c);
    }

    @Override
    protected void paintBackground(Graphics g) {
        super.paintBackground(MaterialDrawingUtils.getAliasedGraphics(g));
    }

    @Override
    public void update(Graphics g, JComponent c) {
        super.update(MaterialDrawingUtils.getAliasedGraphics(g), c);
    }
}
