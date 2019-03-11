package mdlaf.components.spinner;

import mdlaf.components.textfield.MaterialTextFieldUI;
import mdlaf.components.textpane.MaterialTextPaneUI;
import mdlaf.utils.MaterialDrawingUtils;
import org.jdesktop.swingx.JXTextField;

import javax.swing.*;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicArrowButton;
import javax.swing.plaf.basic.BasicSpinnerUI;
import javax.swing.plaf.basic.BasicTextFieldUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MaterialSpinnerUI extends BasicSpinnerUI {


    public static ComponentUI createUI(JComponent c) {
        return new MaterialSpinnerUI();
    }

    @Override
    public void installUI(JComponent c) {
        super.installUI(c);

        JSpinner spinner = (JSpinner) c;
        spinner.setOpaque(false);
        spinner.setFont(UIManager.getFont("Spinner.font"));
        spinner.setBackground(UIManager.getColor("Spinner.background"));
        spinner.setForeground(UIManager.getColor("Spinner.foreground"));
        spinner.setBorder(UIManager.getBorder("Spinner.border"));
        c.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }



    @Override
    public void paint(Graphics g, JComponent c) {
        super.paint(g, c);

    }

    @Override
    public void update(Graphics g, JComponent c) {
        super.update(MaterialDrawingUtils.getAliasedGraphics(g), c);
    }

    @Override
    protected Component createNextButton() {
        Icon icon = UIManager.getIcon("Spinner.nextButtonIcon");
        JButton button;
        if (icon != null) {
            button = new JButton(icon);
        } else {
            button = new BasicArrowButton(SwingConstants.NORTH);
        }
        button.setOpaque(true);
        button.setBackground(UIManager.getColor("Spinner.arrowButtonBackground"));
        button.setBorder(UIManager.getBorder("Spinner.arrowButtonBorder"));
        installNextButtonListeners(button);
        return button;
    }

    @Override
    protected Component createPreviousButton() {
        Icon icon = UIManager.getIcon("Spinner.previousButtonIcon");
        JButton button;
        if (icon != null) {
            button = new JButton(icon);
        } else {
            button = new BasicArrowButton(SwingConstants.SOUTH);
        }
        button.setOpaque(true);
        button.setBackground(UIManager.getColor("Spinner.arrowButtonBackground"));
        button.setBorder(UIManager.getBorder("Spinner.arrowButtonBorder"));
        installPreviousButtonListeners(button);
        return button;
    }




}
