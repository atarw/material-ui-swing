package mdlaf.components.optionpane;

import mdlaf.utils.MaterialImageFactory;

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
        JOptionPane pane = (JOptionPane) c;
        int type = pane.getMessageType();
        if(type == JOptionPane.ERROR_MESSAGE){
            optionPane.setIcon(new ImageIcon(MaterialImageFactory.getIstance().getImage(MaterialImageFactory.ERROR)));
        }
        if(type == JOptionPane.INFORMATION_MESSAGE){
            optionPane.setIcon(new ImageIcon(MaterialImageFactory.getIstance().getImage(MaterialImageFactory.INFORMATION)));
        }
        if(type == JOptionPane.QUESTION_MESSAGE){
            optionPane.setIcon(new ImageIcon(MaterialImageFactory.getIstance().getImage(MaterialImageFactory.QUESTION)));
        }
        if(type == JOptionPane.WARNING_MESSAGE){
            optionPane.setIcon(new ImageIcon(MaterialImageFactory.getIstance().getImage(MaterialImageFactory.WARNING)));
        }
    }





}
