package mdlaf.components.taskpane;

import mdlaf.utils.MaterialColors;
import mdlaf.utils.MaterialDrawingUtils;
import org.jdesktop.swingx.JXHyperlink;
import org.jdesktop.swingx.JXTaskPane;
import org.jdesktop.swingx.plaf.TaskPaneUI;
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

    @Override
    public void installUI(JComponent c) {
        super.installUI(c);
        JXTaskPane jxTaskPane = (JXTaskPane) c;
        jxTaskPane.addMouseListener(new ChangeIconOnClick(jxTaskPane));
        jxTaskPane.setIcon(jxTaskPane.isCollapsed() ? UIManager.getIcon("TaskPane.yesCollapsed") : UIManager.getIcon("TaskPane.noCollapsed"));
        jxTaskPane.getContentPane().setBackground(UIManager.getColor("TaskPane.contentBackground"));
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

        JXTaskPane taskPane;

        public ChangeIconOnClick(JXTaskPane taskPane) {
            this.taskPane = taskPane;
        }


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
