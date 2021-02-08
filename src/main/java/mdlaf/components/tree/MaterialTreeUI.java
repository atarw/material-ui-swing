/**
 * MIT License
 * <p>
 * Copyright (c) 2019-2021 Vincenzo Palazzo vincenzopalazzo1996@gmail.com
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
package mdlaf.components.tree;

import mdlaf.utils.MaterialDrawingUtils;

import javax.swing.*;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicTreeUI;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.TreeCellEditor;
import java.awt.*;

/**
 * @author https://github.com/vincenzopalazzo
 */
public class MaterialTreeUI extends BasicTreeUI {

    public static ComponentUI createUI(JComponent c) {
        return new MaterialTreeUI();
    }

    @Override
    public void installUI(JComponent c) {
        super.installUI(c);

        DefaultTreeCellRenderer renderer = new MaterialTreeCellRenderer();
        TreeCellEditor editor = new MaterialTreeCellEditor(tree, renderer);

        tree.setCellRenderer(renderer);
        tree.setCellEditor(editor);
        tree.setRowHeight(0);
        tree.setInvokesStopCellEditing(true);

        setLeftChildIndent(10);
        setRightChildIndent(10);

        tree.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }

    @Override
    public void uninstallUI(JComponent c) {
        tree.setCursor(Cursor.getDefaultCursor());
        super.uninstallUI(c);
    }

    @Override
    public void paint(Graphics g, JComponent c) {
        g = MaterialDrawingUtils.getAliasedGraphics(g);
        super.paint(g, c);
    }


    @Override
    protected void paintVerticalLine(Graphics g, JComponent c, int x, int top, int bottom) {
    }

    @Override
    protected void paintHorizontalLine(Graphics g, JComponent c, int y, int left, int right) {
    }

}