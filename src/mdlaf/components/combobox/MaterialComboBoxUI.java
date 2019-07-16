package mdlaf.components.combobox;

import mdlaf.animation.MaterialUIMovement;
import mdlaf.utils.MaterialBorders;
import mdlaf.utils.MaterialManagerListener;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicArrowButton;
import javax.swing.plaf.basic.BasicComboBoxUI;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

/**
 * @contributor https://github.com/vincenzopalazzo
 */
public class MaterialComboBoxUI extends BasicComboBoxUI {

    public static ComponentUI createUI(JComponent c) {
        return new MaterialComboBoxUI();
    }

    @Override
    public void installUI(JComponent c) {
        super.installUI(c);

        JComboBox<?> comboBox = (JComboBox<?>) c;
        comboBox.setFont(UIManager.getFont("ComboBox.font"));
        comboBox.setBackground(UIManager.getColor("ComboBox.background"));
        comboBox.setForeground(UIManager.getColor("ComboBox.foreground"));
        comboBox.setBorder(UIManager.getBorder("ComboBox.border"));
        comboBox.setLightWeightPopupEnabled(true);
        comboBox.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }

    @Override
    protected JButton createArrowButton() {
        Icon icon = UIManager.getIcon("ComboBox.buttonIcon");
        JButton button;
        if (icon != null) {
            button = new JButton(icon);
        } else {
            button = new BasicArrowButton(SwingConstants.SOUTH);
        }
        MaterialManagerListener.removeAllMaterialMouseListener(button);
        button.setOpaque(true);
        button.setBackground(UIManager.getColor("ComboBox.buttonBackground"));
        if (UIManager.getBoolean("ComboBox.mouseHoverEnabled")) {
            button.addMouseListener(MaterialUIMovement.getMovement(button, UIManager.getColor("ComboBox.mouseHoverColor")));
        }
        button.setBorder(UIManager.getBorder("ComboBox[button].border"));
        return button;
    }

    @Override
    public void update(Graphics g, JComponent c) {
        super.update(g, c);
    }

    @Override
    public void paint(Graphics g, JComponent c) {
        super.paint(g, c);
    }

    @Override
    protected ListCellRenderer createRenderer() {
        return new MaterialComboBoxRenderer();
    }

    @Override
    protected FocusListener createFocusListener() {
        comboBox.addFocusListener(new FocusListenerColor());
        return super.createFocusListener();
    }

    protected class FocusListenerColor implements FocusListener {

        private Border focus;
        private Border unfocus;

        public FocusListenerColor() {
            focus = MaterialBorders.roundedLineColorBorder(UIManager.getColor("ComboBox.focusColor"));
            unfocus = MaterialBorders.roundedLineColorBorder(UIManager.getColor("ComboBox.unfocusColor"));
        }

        @Override
        public void focusGained(FocusEvent e) {
            if (focus != null) {
                comboBox.setBorder(focus);
            }
        }

        @Override
        public void focusLost(FocusEvent e) {
            if (unfocus != null) {
                comboBox.setBorder(unfocus);
            }
        }
    }
}
