package mdlaf.components.internalframe;

import mdlaf.utils.MaterialBorders;
import mdlaf.utils.MaterialColors;

import javax.swing.*;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import java.awt.*;

/**
 * @author https://github.com/vincenzopalazzo
 */
public class MaterialInternalFrameUI extends BasicInternalFrameUI {

    public MaterialInternalFrameUI(JInternalFrame b) {
        super(b);
    }

    @SuppressWarnings({"MethodOverridesStaticMethodOfSuperclass", "UnusedDeclaration"})
    public static ComponentUI createUI(JComponent c) {
        return new MaterialInternalFrameUI((JInternalFrame) c);
    }

    @Override
    protected JComponent createNorthPane(JInternalFrame w) {
        this.titlePane = new MaterialInternalFrameTitlePane(w);
        w.setBackground(MaterialColors.COSMO_BLUE);
        this.titlePane.setBorder(MaterialBorders.DEFAULT_SHADOW_BORDER);
        return this.titlePane;
    }

    @Override
    public void paint(Graphics g, JComponent c) {
        super.paint(g, c);
        g.setColor(UIManager.getColor("MenuItem.background"));
        g.fillRect(0, 0, c.getWidth(), c.getHeight());
    }


}
