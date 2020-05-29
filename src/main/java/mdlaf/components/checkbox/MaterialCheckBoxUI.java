/**
 * MIT License
 * <p>
 * Copyright (c) 2018-2019 atharva washimkar
 * Copyright (c) 2018-2020 Vincenzo Palazzo vincenzopalazzodev@gmail.com
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
package mdlaf.components.checkbox;

import mdlaf.animation.MaterialMouseHover;
import mdlaf.utils.MaterialDrawingUtils;

import javax.swing.*;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicCheckBoxUI;
import java.awt.*;
import java.awt.event.MouseEvent;

/**
 * @author https://github.com/vincenzopalazzo
 */
public class MaterialCheckBoxUI extends BasicCheckBoxUI {

    protected static final int DRAG_RADIUS = 14;

    public static ComponentUI createUI(JComponent c) {
        return new MaterialCheckBoxUI();
    }

    protected JCheckBox checkBox;
    protected boolean isHover;
    protected boolean mouseHoverEnable;
    protected Color hoverColor;
    protected MaterialMouseHover mouseHover;


    @Override
    public void installUI(JComponent c) {
        super.installUI(c);

        checkBox = (JCheckBox) c;
        //checkBox.setFont(UIManager.getFont("CheckBox.font"));
        //checkBox.setBackground(UIManager.getColor("CheckBox.background"));
        //checkBox.setForeground(UIManager.getColor("CheckBox.foreground"));
        checkBox.setIcon(UIManager.getIcon("CheckBox.icon"));
        checkBox.setSelectedIcon(UIManager.getIcon("CheckBox.selectedIcon"));
        checkBox.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        this.hoverColor = UIManager.getColor("CheckBox.mouseHoverColor");

    }

    @Override
    protected void installDefaults(AbstractButton b) {
        super.installDefaults(b);
        this.mouseHoverEnable = UIManager.getBoolean("CheckBox.mouseHoverEnabled");
        if (this.mouseHoverEnable) {
            mouseHover = new MouseHoverEvent();
        }
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
        this.hoverColor = null;
        super.uninstallUI(c);
    }

    @Override
    protected void installListeners(AbstractButton button) {
        super.installListeners(button);
        if (mouseHover != null) {
            button.addMouseListener(mouseHover);
        }
    }

    @Override
    protected void uninstallListeners(AbstractButton button) {
        super.uninstallListeners(button);
        if (mouseHover != null) {
            button.removeMouseListener(mouseHover);
        }
    }

    @Override
    public void paint(Graphics g, JComponent c) {
        super.paint(g, c);
        if (isHover) {
            Color color = checkBox.isSelected() ? hoverColor : checkBox.getForeground();
            MaterialDrawingUtils.drawCircle(g, 0, 0, DRAG_RADIUS, color);
        }
    }

    @Override
    protected void paintFocus(Graphics g, Rectangle textRect, Dimension size) {
        //super.paintFocus(g, textRect, size);
        Color color = checkBox.isSelected() ? hoverColor : checkBox.getForeground();
        MaterialDrawingUtils.drawCircle(g, 0, 0, DRAG_RADIUS, color);
    }

    protected class MouseHoverEvent implements MaterialMouseHover {

        @Override
        public void mouseClicked(MouseEvent e) {

        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {
            isHover = true;
            checkBox.repaint();
        }

        @Override
        public void mouseExited(MouseEvent e) {
            isHover = false;
            checkBox.repaint();
        }

        @Override
        public void mouseDragged(MouseEvent e) {

        }

        @Override
        public void mouseMoved(MouseEvent e) {

        }
    }
}
