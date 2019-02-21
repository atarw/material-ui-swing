package mdlaf.components.taskpane;

import mdlaf.utils.MaterialDrawingUtils;
import org.jdesktop.swingx.plaf.basic.BasicTaskPaneUI;

import javax.swing.*;
import javax.swing.plaf.ComponentUI;
import java.awt.*;

/**
 * @author https://github.com/vincenzopalazzo
 */
public class MaterialTaskPane extends BasicTaskPaneUI {


    @SuppressWarnings({"MethodOverridesStaticMethodOfSuperclass", "UnusedDeclaration"})
    public static ComponentUI createUI(JComponent c) {
        return new MaterialTaskPane();
    }

    @Override
    public void installUI(JComponent c) {
        super.installUI(c);
    }

    @Override
    public void paint(Graphics g, JComponent c) {
        super.paint(MaterialDrawingUtils.getAliasedGraphics(g), c);
    }
}
