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
import javax.swing.border.Border;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicToolBarUI;
import java.awt.*;
import java.awt.event.ContainerEvent;
import java.awt.event.ContainerListener;

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
        this.dockingBorderColor = UIManager.getColor("ToolBar.dockingBackground");
        this.floatingBorderColor = UIManager.getColor("ToolBar.floatingBackground");
        this.dockingColor = UIManager.getColor("ToolBar.dockingBackground");
        this.floatingColor = UIManager.getColor("ToolBar.floatingBackground");
    }

    @Override
    public void uninstallUI(JComponent c) {
        this.dockingColor = null;
        this.floatingColor = null;
        super.uninstallUI(c);
    }

    @Override
    protected ContainerListener createToolBarContListener() {
        return new ToolBarContListener() {
            @Override
            public void componentAdded( ContainerEvent e ) {
                super.componentAdded( e );

                Component c = e.getChild();
                if( c instanceof AbstractButton )
                    c.setFocusable( false );
            }

            @Override
            public void componentRemoved( ContainerEvent e ) {
                super.componentRemoved( e );

                Component c = e.getChild();
                if( c instanceof AbstractButton )
                    c.setFocusable( true );
            }
        };
    }

    @Override
    protected void setBorderToRollover( Component c ) {}

    @Override
    protected void setBorderToNonRollover( Component c ) {}

    @Override
    protected void setBorderToNormal( Component c ) {}

    @Override
    protected void installRolloverBorders( JComponent c ) {}

    @Override
    protected void installNonRolloverBorders( JComponent c ) {}

    @Override
    protected void installNormalBorders( JComponent c ) {}

    @Override
    protected Border createRolloverBorder() { return null; }

    @Override
    protected Border createNonRolloverBorder() { return null; }
}
