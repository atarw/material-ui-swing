package mdlaf.components.splitpane;

import javax.swing.*;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicSplitPaneDivider;
import javax.swing.plaf.basic.BasicSplitPaneUI;
import javax.swing.plaf.metal.MetalSplitPaneUI;
import java.awt.*;
//TODO sincronize this component with master
/**
 * @author https://github.com/vincenzopalazzo
 */
public class MaterialSplitPaneUI extends MetalSplitPaneUI {


    @SuppressWarnings({"MethodOverridesStaticMethodOfSuperclass", "UnusedDeclaration"})
    public static ComponentUI createUI(JComponent c) {
        return new MaterialSplitPaneUI();
    }

    @Override
    public void installUI(JComponent c) {
        super.installUI(c);

        this.divider.setBackground(UIManager.getColor("SplitPaneDivider.background"));
    }

    @Override
    public BasicSplitPaneDivider createDefaultDivider() {
        return new MaterialSplitPaneDivider(this);
    }

    protected class MaterialSplitPaneDivider extends BasicSplitPaneDivider{

        /**
         * Creates an instance of BasicSplitPaneDivider. Registers this
         * instance for mouse events and mouse dragged events.
         *
         * @param ui
         */
        public MaterialSplitPaneDivider(BasicSplitPaneUI ui) {
            super(ui);
        }

        @Override
        public void paintAll(Graphics g) {
            //g.setColor(UIManager.getColor("SplitPaneDivider.background"));
            super.paintAll(g);
        }
    }

}
