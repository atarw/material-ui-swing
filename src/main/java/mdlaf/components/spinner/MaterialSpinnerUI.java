/**
 * MIT License
 * <p>
 * Copyright (c) 2018-2020 atharva washimkar, Vincenzo Palazzo vincenzopalazzo1996@gmail.com
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
package mdlaf.components.spinner;

import mdlaf.animation.MaterialUIMovement;
import mdlaf.components.button.MaterialButtonUI;

import javax.swing.*;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicSpinnerUI;
import java.awt.*;

/**
 * @author https://github.com/vincenzopalazzo
 * @author https://github.com/atarw
 */
public class MaterialSpinnerUI extends BasicSpinnerUI {

    public static ComponentUI createUI(JComponent c) {
        return new MaterialSpinnerUI();
    }

    //protected JButton upArrowButton;
    //protected JButton downArrowButton;

    @Override
    public void installUI(JComponent c) {
        super.installUI(c);
        /*
        JSpinner spinner = (JSpinner) c;
        //spinner.setOpaque(false);
        spinner.setFont(UIManager.getFont("Spinner.font"));
        spinner.setBackground(UIManager.getColor("Spinner.background"));
        spinner.setForeground(UIManager.getColor("Spinner.foreground"));
        spinner.getEditor().setBorder(UIManager.getBorder("Spinner.border"));
        //c.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
 */
    }

    @Override
    public void uninstallUI(JComponent c) {
        c.setCursor(Cursor.getDefaultCursor());
        /*spinner.setFont(null);
        spinner.setBackground(null);
        spinner.setForeground(null);*/
        //spinner.getEditor().setBorder(null);

        super.uninstallUI(c);
    }

    @Override
    public void paint(Graphics g, JComponent c) {
        super.paint(g, c);

    }


    @Override
    protected Component createNextButton() {
        Icon icon = UIManager.getIcon("Spinner.nextButtonIcon");
        JButton button = this.configureLocalButton(icon);
        installNextButtonListeners(button);
        return button;
    }

    @Override
    protected Component createPreviousButton() {
        Icon icon = UIManager.getIcon("Spinner.previousButtonIcon");
        JButton button = this.configureLocalButton(icon);
        installPreviousButtonListeners(button);
        return button;
    }

    protected JButton configureLocalButton(Icon icon) {
        JButton arrowButton = new JButton(icon);
        arrowButton.setUI(new SpinnerButtonUI());
        return arrowButton;
    }

    /**
     * This class use the MaterialButtonUI API to create the custom button for the icon
     */
    protected static class SpinnerButtonUI extends MaterialButtonUI {

        @Override
        public void installUI(JComponent c) {
            super.mouseHoverEnabled = null;
            super.installUI(c);
            super.mouseHoverEnabled = UIManager.getBoolean("Spinner.mouseHoverEnabled");
            super.background = UIManager.getColor("Spinner.arrowButtonBackground");
            LookAndFeel.installColors(super.button, "Spinner.arrowButtonBackground", "Button.foreground");
            super.button.setBorder(BorderFactory.createLineBorder(super.background));
            if (super.mouseHoverEnabled) {
                super.mouseHover = MaterialUIMovement.getMovement(button, UIManager.getColor("Spinner.mouseHoverColor"));
                super.button.addMouseListener(super.mouseHover);
            }
        }

        @Override
        protected void paintFocusRing(Graphics g, JButton b) {
            //doNothing
        }
    }
}
