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

    @Override
    public void installUI(JComponent c) {
        super.installUI(c);
        JXTaskPane jxTaskPane = (JXTaskPane) c;
        jxTaskPane.addMouseListener(new ChangeIconOnClick(jxTaskPane));
        jxTaskPane.setIcon(jxTaskPane.isCollapsed() ? UIManager.getIcon("TaskPane.yesCollassed") : UIManager.getIcon("TaskPane.noCollassed"));
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
            if (group.isSpecial()) {
                g.setColor(specialTitleBackground);
            } else {
                g.setColor(titleBackgroundGradientStart);
            }
            g.fillRoundRect(0, 0, group.getWidth(), getTitleHeight(group) -1 , 15, 15);
        }

        @Override
        protected boolean isMouseOverBorder() {
            return true;
        }

        @Override
        public boolean isBorderOpaque() {
            return true;
        }
    }

    /**
     * Action change icon on clic
     * @author @author https://github.com/vincenzopalazzo
     */

    private class ChangeIconOnClick implements MouseListener {

        JXTaskPane taskPane;

        public ChangeIconOnClick(JXTaskPane taskPane) {
            this.taskPane = taskPane;
        }


        @Override
        public void mouseClicked(MouseEvent e) {
            if(taskPane.isCollapsed()){
                taskPane.setIcon(UIManager.getIcon("TaskPane.yesCollassed"));
                return;
            }
            taskPane.setIcon(UIManager.getIcon("TaskPane.noCollassed"));
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
