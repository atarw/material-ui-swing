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
package mdlaf.components.togglebutton;

import mdlaf.utils.MaterialColors;
import mdlaf.utils.MaterialDrawingUtils;
import sun.swing.SwingUtilities2;

import javax.swing.*;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicToggleButtonUI;
import java.awt.*;

/**
 * @author https://github.com/vincenzopalazzo
 * @author https://github.com/atarw
 * @author https://github.com/downToHell
 */
public class MaterialToggleButtonUI extends BasicToggleButtonUI {

    protected Boolean withoutIcon;
    protected Integer widthWithoutIcon;
    protected Integer heightWithoutIcon;
    protected Integer originalWidth;
    protected Integer originalHeight;
    protected JToggleButton toggleButton;

    public static ComponentUI createUI(JComponent c) {
        return new MaterialToggleButtonUI();
    }

    @Override
    public void installUI(JComponent c) {
        super.installUI(c);
        toggleButton = (JToggleButton) c;
        toggleButton.setFont(UIManager.getFont("ToggleButton.font"));
        toggleButton.setBackground(UIManager.getColor("ToggleButton.background"));
        toggleButton.setForeground(UIManager.getColor("ToggleButton.foreground"));
        c.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        /*
        If the expression toggleButton.getIcon() == null && toggleButton.getSelectedIcon() == null is false the JToggleButton have the
        personal icon, how inside the JFileChooser. Now the are two cases
         1. The previous expression is true, so for this class, this event is a normal JToggleButton;
         with these cases is possible another two cases like:
         1.1 The variable withoutIcon is false, so the effect like this:
         1.1 The variable withoutIcon if true, so the effect like this:
         2. if the expression toggleButton.getIcon() == null && toggleButton.getSelectedIcon() == null is false, for this class
            the JToggleButton has the icon set, an example is JFileChooser.
            To default, this class will set the variable without an icon to false and toggle button border to UIManager propriety.
         */
        if (toggleButton.getIcon() == null && toggleButton.getSelectedIcon() == null){
            toggleButton.setIcon(UIManager.getIcon("ToggleButton.icon"));
            toggleButton.setSelectedIcon(UIManager.getIcon("ToggleButton.selectedIcon"));
            this.withoutIcon = UIManager.getBoolean("ToggleButton.withoutIcon");
            if(withoutIcon){
                toggleButton.setBorder(BorderFactory.createLineBorder(MaterialColors.COSMO_STRONG_GRAY));
                this.originalHeight = toggleButton.getHeight();
                this.originalWidth = toggleButton.getWidth();
            }else{
                toggleButton.setBorder(UIManager.getBorder("ToggleButton.border"));
            }
        }else{
            toggleButton.setBorder(UIManager.getBorder("ToggleButton.border"));
            this.withoutIcon = Boolean.FALSE;
        }

    }

    @Override
    public void uninstallUI(JComponent c) {
        JToggleButton toggleButton = (JToggleButton) c;
        toggleButton.setIcon(null);
        toggleButton.setSelectedIcon(null);
        toggleButton.setBorder(null);
        toggleButton.setBackground(null);
        toggleButton.setForeground(null);
        super.uninstallUI(c);
    }

    @Override
    //TODO I'm working here
    public void paint(Graphics g, JComponent c) {
        super.paint(MaterialDrawingUtils.getAliasedGraphics(g), c);

        if(withoutIcon != null && withoutIcon){
            AbstractButton button = (AbstractButton) c;
            if(button.isSelected()){
                button.setBackground(MaterialColors.COSMO_DARK_GRAY);
                button.setBorder(BorderFactory.createLineBorder(MaterialColors.DARKLY_GRAY));
            }else{
                button.setBackground(MaterialColors.COSMO_LIGTH_GRAY);
                button.setBorder(BorderFactory.createLineBorder(MaterialColors.COSMO_STRONG_GRAY));
            }
        }
    }

    @Override
    protected void paintFocus(Graphics g, AbstractButton b, Rectangle viewRect, Rectangle textRect, Rectangle iconRect) {
        //do nothing
    }

    @Override
    protected void paintText(Graphics g, JComponent c, Rectangle textRect, String text) {
        AbstractButton b = (AbstractButton) c;
        ButtonModel model = b.getModel();
        FontMetrics fm = SwingUtilities2.getFontMetrics(c, g);
        int mnemonicIndex = b.getDisplayedMnemonicIndex();

        /* Draw the Text */
        if (model.isEnabled()) {
            /*** paint the text normally */
            g.setColor(b.getForeground());
            SwingUtilities2.drawStringUnderlineCharAt(c, g, text, mnemonicIndex,
                    textRect.x + getTextShiftOffset(),
                    textRect.y + fm.getAscent() + getTextShiftOffset());
        } else {
            /*** paint the text disabled ***/
            g.setColor(UIManager.getColor("ToggleButton.disabledText").brighter());
            SwingUtilities2.drawStringUnderlineCharAt(c, g, text, mnemonicIndex,
                    textRect.x, textRect.y + fm.getAscent());
            g.setColor(UIManager.getColor("ToggleButton.disabledText").darker());
            SwingUtilities2.drawStringUnderlineCharAt(c, g, text, mnemonicIndex,
                    textRect.x - 1, textRect.y + fm.getAscent() - 1);
        }
    }


    @Override //TODO this method contains an bug
    public Dimension getPreferredSize(JComponent c) {
        if(this.withoutIcon != null && this.withoutIcon){
            if(this.widthWithoutIcon == null && this.heightWithoutIcon == null){
                this.widthWithoutIcon = c.getWidth() + 25;
                this.heightWithoutIcon = c.getHeight() + 25;
            }
            return new Dimension(this.widthWithoutIcon, this.heightWithoutIcon);
        }
        return super.getPreferredSize(c);
    }
}
