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

import java.awt.Color;
import java.awt.Cursor;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicGraphicsUtils;
import javax.swing.plaf.basic.BasicToggleButtonUI;

import mdlaf.utils.MaterialDrawingUtils;

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
    protected Color withoutIconSelectedBackground;
    protected Color withoutIconSelectedForeground;
    protected Color withoutIconBackground;
    protected Color withoutIconForeground;
    protected Border withoutIconSelectedBorder;
    protected Border withoutIconBorder;

    public static ComponentUI createUI(JComponent c) {
        return new MaterialToggleButtonUI();
    }

    @Override
    public void installUI(JComponent c) {
        super.installUI(c);
        toggleButton = (JToggleButton) c;
       //toggleButton.setFont(UIManager.getFont("ToggleButton.font"));
        //toggleButton.setBackground(UIManager.getColor("ToggleButton.background"));
        //toggleButton.setForeground(UIManager.getColor("ToggleButton.foreground"));
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
                withoutIconSelectedBorder = UIManager.getBorder("ToggleButton[withoutIcon].selectedBorder");
                withoutIconBorder = UIManager.getBorder("ToggleButton[withoutIcon].border");
                withoutIconSelectedBackground = UIManager.getColor("ToggleButton[withoutIcon].selectedBackground");
                withoutIconSelectedForeground = UIManager.getColor("ToggleButton[withoutIcon].selectedForeground");
                withoutIconBackground = UIManager.getColor("ToggleButton[withoutIcon].background");
                withoutIconForeground = UIManager.getColor("ToggleButton[withoutIcon].foreground");
                if(toggleButton.isSelected()){
                    toggleButton.setBorder(withoutIconSelectedBorder);
                }else{
                    toggleButton.setBorder(withoutIconBorder);
                }
            }else{
                LookAndFeel.installBorder(toggleButton,"ToggleButton.border");
            }
        }else{
            LookAndFeel.installBorder(toggleButton,"ToggleButton.border" );
            this.withoutIcon = Boolean.FALSE;
        }



    }

    @Override
    public void uninstallUI(JComponent c) {
       JToggleButton toggleButton = (JToggleButton) c;
        toggleButton.setIcon(null);
        toggleButton.setSelectedIcon(null);
        /* toggleButton.setBorder(null);
        toggleButton.setBackground(null);
        toggleButton.setForeground(null);*/
        super.uninstallUI(c);
    }

    @Override
    //TODO I'm working here
    public void paint(Graphics g, JComponent c) {
        super.paint(g, c);

        if(withoutIcon != null && withoutIcon && isNotNullColor(withoutIcon)){
            AbstractButton button = (AbstractButton) c;
            if(button.isSelected()){
                button.setBackground(withoutIconSelectedBackground);
                button.setForeground(withoutIconSelectedForeground);
                button.setBorder(withoutIconSelectedBorder); //TODO set thickness from UIManager
            }else{
                button.setBackground(withoutIconBackground);
                button.setForeground(withoutIconForeground);
                button.setBorder(withoutIconBorder);
            }
        }
    }

    private boolean isNotNullColor(boolean withoutIcon) {
        if(withoutIcon){
            boolean selectedColorNotNull = withoutIconSelectedBackground != null && withoutIconSelectedForeground != null;
            boolean unselectColorNotNull = withoutIconBackground != null && withoutIconForeground != null;
            boolean borderNotNull = withoutIconBorder != null && withoutIconSelectedBorder != null;
            return  selectedColorNotNull && unselectColorNotNull && borderNotNull;
        }
        //TODO complete this logic
        return true;
    }

    @Override //TODO implement this effect
    protected void paintFocus(Graphics g, AbstractButton b, Rectangle viewRect, Rectangle textRect, Rectangle iconRect) {
        //do nothing
    }

    @Override
    protected void paintText(Graphics g, JComponent c, Rectangle textRect, String text) {
        AbstractButton b = (AbstractButton) c;
        ButtonModel model = b.getModel();
        FontMetrics fm = g.getFontMetrics(c.getFont());
        int mnemonicIndex = b.getDisplayedMnemonicIndex();

        /* Draw the Text */
        if (model.isEnabled()) {
            /*** paint the text normally */
            g.setColor(b.getForeground());
            BasicGraphicsUtils.drawStringUnderlineCharAt(g, text, mnemonicIndex,
                    textRect.x + getTextShiftOffset(),
                    textRect.y + fm.getAscent() + getTextShiftOffset());
        } else {
            /*** paint the text disabled ***/
            g.setColor(UIManager.getColor("ToggleButton.disabledText").brighter());
            BasicGraphicsUtils.drawStringUnderlineCharAt(g, text, mnemonicIndex,
                    textRect.x, textRect.y + fm.getAscent());
            g.setColor(UIManager.getColor("ToggleButton.disabledText").darker());
            BasicGraphicsUtils.drawStringUnderlineCharAt(g, text, mnemonicIndex,
                    textRect.x - 1, textRect.y + fm.getAscent() - 1);
        }
    }
}
