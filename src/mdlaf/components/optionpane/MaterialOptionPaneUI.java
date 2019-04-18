package mdlaf.components.optionpane;


import javax.swing.*;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicOptionPaneUI;
import java.awt.*;

/**
 * @author https://github.com/vincenzopalazzo
 */
public class MaterialOptionPaneUI extends BasicOptionPaneUI {


    @SuppressWarnings({"MethodOverridesStaticMethodOfSuperclass", "UnusedDeclaration"})
    public static ComponentUI createUI(JComponent c) {
        return new MaterialOptionPaneUI();
    }



    @Override
    public void update(Graphics g, JComponent c) {
        super.update(g, c);
    }

    @Override
    protected Icon getIconForType(int messageType) {
        if(!UIManager.getBoolean("OptionPane.enableIcon")){
            return null;
        }
        return super.getIconForType(messageType);
    }

    @Override
    protected void addButtonComponents(Container container, Object[] buttons, int initialIndex) {
        super.addButtonComponents(container, buttons, initialIndex);

    }
}
