/**
 * MIT License
 * <p>
 * Copyright (c) 2018-2019 atharva washimkar
 * Copyright (c) 2018-2021 Vincenzo Palazzo vincenzopalazzodev@gmail.com
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
import javax.swing.plaf.UIResource;
import javax.swing.plaf.basic.BasicCheckBoxUI;
import java.awt.*;
import java.awt.event.MouseEvent;

/**
 * @author https://github.com/vincenzopalazzo
 */
public class MaterialCheckBoxUI extends BasicCheckBoxUI {

    public static ComponentUI createUI(JComponent c) {
        return new MaterialCheckBoxUI();
    }

    protected JCheckBox checkBox;
    protected Color disabledForeground;
    protected boolean isHover;
    protected boolean mouseHoverEnable;
    protected Color hoverColor;
    protected MaterialMouseHover mouseHover;


    @Override
    public void installUI(JComponent c) {
        super.installUI(c);
        this.checkBox = (JCheckBox) c;
        c.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }

    @Override
    protected void installDefaults(AbstractButton b) {
        super.installDefaults(b);
        icon = new MaterialCheckBoxIcon(this.getPropertyPrefix());
        this.mouseHoverEnable = UIManager.getBoolean(this.getPropertyPrefix() + "mouseHoverEnabled");
        this.hoverColor = UIManager.getColor(this.getPropertyPrefix() + "mouseHoverColor");
        this.disabledForeground = UIManager.getColor(this.getPropertyPrefix() + "disabledText");
        if (this.mouseHoverEnable) {
            mouseHover = new MouseHoverEvent();
        }
    }

    @Override
    public synchronized void paint(Graphics g, JComponent c) {
        super.paint(g, c);
    }

    @Override
    protected void paintText(Graphics g, JComponent c, Rectangle textRect, String text) {
        AbstractButton b = (AbstractButton) c;
        ButtonModel model = b.getModel();

        if (model.isEnabled()) {
            MaterialDrawingUtils.drawString(c, g, text, textRect, b.getDisplayedMnemonicIndex(), getTextShiftOffset(), b.getForeground());
        } else {
            MaterialDrawingUtils.drawString(c, g, text, textRect, b.getDisplayedMnemonicIndex(), getTextShiftOffset(), disabledForeground);
        }
    }

    @Override
    public void uninstallUI(JComponent c) {
        c.setCursor(Cursor.getDefaultCursor());
        this.hoverColor = null;
        super.uninstallUI(c);
    }

    @Override
    protected void installListeners(AbstractButton button) {
        super.installListeners(button);
    }

    @Override
    protected void uninstallListeners(AbstractButton button) {
        super.uninstallListeners(button);
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

        @Override
        public boolean isRunning() {
            return isHover;
        }
    }

    protected class MaterialCheckBoxIcon implements  Icon, UIResource{

        protected Icon unselectedIcon;
        protected Icon selectedIcon;
        protected Icon disabledIcon;
        protected Icon disabledSelectedIcon;

        public MaterialCheckBoxIcon(String componentPrefix) {
            unselectedIcon = UIManager.getIcon(componentPrefix + "icon");
            selectedIcon = UIManager.getIcon(componentPrefix + "selectedIcon");
            disabledIcon = UIManager.getIcon(componentPrefix + "disabledIcon");
            disabledSelectedIcon = UIManager.getIcon(componentPrefix + "disabledSelectedIcon");
        }

        @Override
        public void paintIcon(Component c, Graphics g, int x, int y) {
            if(checkBox.isEnabled()){
                if(checkBox.isSelected()){
                    this.selectedIcon.paintIcon(c, g, x, y);
                }else{
                    this.unselectedIcon.paintIcon(c, g, x, y);
                }
            }else{
                if(checkBox.isSelected()){
                    this.disabledSelectedIcon.paintIcon(c, g, x, y);
                }else{
                    this.disabledIcon.paintIcon(c, g, x, y);
                }
            }
        }

        @Override
        public int getIconWidth() {
            return unselectedIcon.getIconWidth();
        }

        @Override
        public int getIconHeight() {
            return unselectedIcon.getIconHeight();
        }
    }
}
