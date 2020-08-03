/*
 * MIT License
 *
 * Copyright (c) 2019-2020 Vincenzo Palazzo vincenzopalazzo1996@gmail.com
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
package integration.gui.mock.component;

import mdlaf.animation.MaterialUIMovement;
import mdlaf.components.button.MaterialButtonUI;
import mdlaf.utils.MaterialColors;

import javax.swing.*;

/**
 * @author https://github.com/vincenzopalazzo
 */
public class JButtonNoMouseHoverNative extends JButton {

    public JButtonNoMouseHoverNative() {
    }

    public JButtonNoMouseHoverNative(Icon icon) {
        super(icon);
    }

    public JButtonNoMouseHoverNative(String text) {
        super(text);
    }

    public JButtonNoMouseHoverNative(Action a) {
        super(a);
    }

    public JButtonNoMouseHoverNative(String text, Icon icon) {
        super(text, icon);
    }

    @Override
    protected void init(String text, Icon icon) {
        super.init(text, icon);
        setUI(new JButtonNoMouseHoverUI());
    }

    private static class JButtonNoMouseHoverUI extends MaterialButtonUI{

        @Override
        public void installUI(JComponent c) {
            mouseHoverEnabled = false;
            super.installUI(c);
            if (mouseHoverEnabled != null) {
                JButton b = (JButton) button;
                if (!b.isDefaultButton()) {
                    button.addMouseListener(MaterialUIMovement.getMovement(button, MaterialColors.COSMO_DARK_GRAY));
                }
            }
        }
    }
}
