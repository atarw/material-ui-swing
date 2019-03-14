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
        if(messageType == JOptionPane.ERROR_MESSAGE){
            return UIManager.getIcon("OptionPaneUI.errorIcon");
        }
        if(messageType == JOptionPane.INFORMATION_MESSAGE){
            return UIManager.getIcon("OptionPaneUI.informationIcon");
        }
        if(messageType == JOptionPane.QUESTION_MESSAGE){
            return UIManager.getIcon("OptionPaneUI.questionIcon");
        }
        if(messageType == JOptionPane.WARNING_MESSAGE){
            return UIManager.getIcon("OptionPaneUI.warningIcon");
        }
        return super.getIconForType(messageType);
    }
}
