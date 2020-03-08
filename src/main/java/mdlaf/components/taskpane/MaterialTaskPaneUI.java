/**
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
package mdlaf.components.taskpane;

import mdlaf.utils.MaterialDrawingUtils;
import org.jdesktop.swingx.JXTaskPane;
import org.jdesktop.swingx.plaf.basic.BasicTaskPaneUI;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.plaf.ComponentUI;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import static org.jdesktop.swingx.SwingXUtilities.isUIInstallable;

/**
 * @author https://github.com/vincenzopalazzo
 */
public class MaterialTaskPaneUI extends BasicTaskPaneUI {


    @SuppressWarnings({"MethodOverridesStaticMethodOfSuperclass", "UnusedDeclaration"})
    public static ComponentUI createUI(JComponent c) {
        return new MaterialTaskPaneUI();
    }

    private MouseListener changeIcon;
    private JXTaskPane taskPane;

    public MaterialTaskPaneUI() {
        changeIcon = new ChangeIconOnClick();
    }

    @Override
    public void installUI(JComponent c) {
        super.installUI(c);
        JXTaskPane jxTaskPane = (JXTaskPane) c;
        jxTaskPane.addMouseListener(changeIcon);
        jxTaskPane.setIcon(jxTaskPane.isCollapsed() ? UIManager.getIcon("TaskPane.yesCollapsed") : UIManager.getIcon("TaskPane.noCollapsed"));
        jxTaskPane.getContentPane().setBackground(UIManager.getColor("TaskPane.contentBackground"));

        this.taskPane = jxTaskPane;
    }

    @Override
    public void uninstallUI(JComponent c) {

        c.setFont (null);
        c.setBackground (null);
        c.setForeground (null);
        c.setBorder (null);
        c.setCursor(null);

        super.uninstallUI(c);
    }

    @Override
    public void update(Graphics g, JComponent c) {
        super.update(g, c);
        JXTaskPane jxTaskPane = (JXTaskPane) c;
        jxTaskPane.setIcon(jxTaskPane.isCollapsed() ? UIManager.getIcon("TaskPane.yesCollapsed") : UIManager.getIcon("TaskPane.noCollapsed"));
        jxTaskPane.getContentPane().setBackground(UIManager.getColor("TaskPane.contentBackground"));
    }

    protected void installDefaults() {
        LookAndFeel.installColorsAndFont(group, "TaskPane.background",
                "TaskPane.foreground", "TaskPane.font");
        LookAndFeel.installProperty(group, "opaque", false);

        if (isUIInstallable(group.getBorder())) {
            group.setBorder(createPaneBorder());
        }

        if (group.getContentPane() instanceof JComponent) {
            JComponent content = (JComponent) group.getContentPane();

            LookAndFeel.installColorsAndFont(content,
                    "TaskPane.background", "TaskPane.foreground", "TaskPane.font");

            if (isUIInstallable(content.getBorder())) {
                content.setBorder(createContentPaneBorder());
            }
        }
    }

    @Override
    protected void uninstallListeners() {
        taskPane.removeMouseListener(changeIcon);
        super.uninstallListeners();
    }

    protected Border createContentPaneBorder() {
        Color borderColor = UIManager.getColor("TaskPane.borderColor");
        return new CompoundBorder(new ContentPaneBorder(borderColor),
                UIManager.getBorder("TaskPane.border"));
    }

    @Override
    protected Border createPaneBorder() {
        return new MaterialPaneBorder();
    }

    @Override
    public void paint(Graphics g, JComponent c) {
        super.paint(MaterialDrawingUtils.getAliasedGraphics(g), c);
    }


    protected class MaterialPaneBorder extends PaneBorder{

        protected void paintTitleBackground(JXTaskPane group, Graphics g) {
            MaterialDrawingUtils.getAliasedGraphics(g);
            this.label.setBackground(UIManager.getColor("TaskPane.background"));
            if (group.isSpecial()) {
                g.setColor(specialTitleBackground);
            } else {
                g.setColor(titleBackgroundGradientStart);
            }
            Graphics2D graphics2D = (Graphics2D) g;
            graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g = graphics2D;
            g.fillRoundRect( -2, 0, group.getWidth(), group.getHeight(), 15, 15);
        }

        @Override
        protected boolean isMouseOverBorder() {
            return true;
        }

        @Override
        public boolean isBorderOpaque() {
            return true;
        }

        @Override
        public Dimension getPreferredSize(JXTaskPane group) {
            this.configureLabel(group);
            Dimension dim = this.label.getPreferredSize();
            dim.width += getTitleHeight(group);
            dim.height = getTitleHeight(group);
            return dim;
        }
    }

    /**
     * Action change icon on click
     * @author https://github.com/vincenzopalazzo
     */
    protected class ChangeIconOnClick implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            if(taskPane.isCollapsed()){
                taskPane.setIcon(UIManager.getIcon("TaskPane.yesCollapsed"));
                return;
            }
            taskPane.setIcon(UIManager.getIcon("TaskPane.noCollapsed"));
        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    }
}
