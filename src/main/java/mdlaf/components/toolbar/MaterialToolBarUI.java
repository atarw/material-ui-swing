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
package mdlaf.components.toolbar;

import javax.swing.*;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicToolBarUI;

/**
 * @author https://github.com/vincenzopalazzo
 * @author https://github.com/atarw
 */
public class MaterialToolBarUI extends BasicToolBarUI {

    public static ComponentUI createUI(JComponent c) {
        return new MaterialToolBarUI();
    }

    @Override
    public void installUI(JComponent c) {
        super.installUI(c);
       // JToolBar toolBar = (JToolBar) c;
		/*toolBar.setFont (UIManager.getFont ("ToolBar.font"));
		toolBar.setBackground (UIManager.getColor ("ToolBar.background"));
		toolBar.setForeground (UIManager.getColor ("ToolBar.foreground"));
		toolBar.setBorder (UIManager.getBorder ("ToolBar.border"));*/

        this.dockingBorderColor = UIManager.getColor("ToolBar.dockingBackground");
        this.floatingBorderColor = UIManager.getColor("ToolBar.floatingBackground");
        this.dockingColor = UIManager.getColor("ToolBar.dockingBackground");
        this.floatingColor = UIManager.getColor("ToolBar.floatingBackground");
    }

    @Override
    public void uninstallUI(JComponent c) {

		/*c.setFont (null);
		c.setBackground (null);
		c.setForeground (null);
		c.setBorder (null);
		c.setCursor(null);*/

        this.dockingColor = null;
        this.floatingColor = null;
        super.uninstallUI(c);
    }
}
