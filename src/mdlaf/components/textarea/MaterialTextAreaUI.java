package mdlaf.components.textarea;

import mdlaf.utils.MaterialDrawingUtils;

import javax.swing.*;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicTextAreaUI;
import java.awt.*;

/**
 * @author https://github.com/vincenzopalazzo
 */
public class MaterialTextAreaUI extends BasicTextAreaUI {


    @SuppressWarnings({"MethodOverridesStaticMethodOfSuperclass", "UnusedDeclaration"})
    public static ComponentUI createUI(JComponent c) {
        return new MaterialTextAreaUI();
    }

    @Override
    public void installUI(JComponent c) {
        super.installUI(c);

        JTextArea textArea = (JTextArea) c;
        textArea.setBackground(UIManager.getColor("TextArea.background"));
        textArea.setForeground(UIManager.getColor("TextArea.foreground"));
        textArea.setFont(UIManager.getFont("TextArea.font"));
        textArea.setBorder(UIManager.getBorder("TextArea.border"));

        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true); 
    }

    @Override
    public void update(Graphics g, JComponent c) {
        super.update(MaterialDrawingUtils.getAliasedGraphics(g), c);
    }
}
