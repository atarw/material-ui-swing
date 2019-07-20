package mdlaf.components.combobox;

import mdlaf.animation.MaterialUIMovement;
import mdlaf.utils.MaterialBorders;
import mdlaf.utils.MaterialDrawingUtils;
import mdlaf.utils.MaterialManagerListener;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicArrowButton;
import javax.swing.plaf.basic.BasicComboBoxUI;
import java.awt.*;
import java.awt.event.*;


/**
 * @contributor https://github.com/vincenzopalazzo
 */
public class MaterialComboBoxUI extends BasicComboBoxUI {

    public static ComponentUI createUI(JComponent c) {
        return new MaterialComboBoxUI();
    }

    protected Color background;

    @Override
    public void installUI(JComponent c) {
        super.installUI(c);

        JComboBox<?> comboBox = (JComboBox<?>) c;
        comboBox.setFont(UIManager.getFont("ComboBox.font"));
        background = UIManager.getColor("ComboBox.background");
        comboBox.setBackground(background);
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
        return button;
    }

    @Override
    public void configureArrowButton() {
        super.configureArrowButton();

        MaterialManagerListener.removeAllMaterialMouseListener(arrowButton);
        arrowButton.setOpaque(true);
        arrowButton.setBackground(UIManager.getColor("ComboBox.buttonBackground"));
        if (UIManager.getBoolean("ComboBox.mouseHoverEnabled")) {
            arrowButton.addMouseListener(MaterialUIMovement.getMovement(arrowButton, UIManager.getColor("ComboBox.mouseHoverColor")));
        }
        arrowButton.setBorder(UIManager.getBorder("ComboBox[button].border"));
    }

    @Override
    public void unconfigureArrowButton() {
        MaterialManagerListener.removeAllMaterialMouseListener(arrowButton);
        super.unconfigureArrowButton();
    }

    @Override
    public void update(Graphics g, JComponent c) {
        //super.update(g, c);
        g = MaterialDrawingUtils.getAliasedGraphics(g);
        g.setColor(c.getBackground());
        g.fillRoundRect(0, 0, comboBox.getWidth(), comboBox.getHeight(), 12, 12);
        paint(g, c);
    }

    @Override
    protected ListCellRenderer createRenderer() {
        return new MaterialComboBoxRenderer();
    }

    @Override
    protected ComboBoxEditor createEditor() {
        return new MaterialComboBoxEditor();
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
            if (e.getComponent() == null) {
                return;
            }
            JComboBox cb = (JComboBox) e.getComponent();
            if (focus != null) {
                cb.setBorder(focus);
                cb.repaint();
            }
        }

        @Override
        public void focusLost(FocusEvent e) {
            if (e.getComponent() == null) {
                return;
            }
            JComboBox cb = (JComboBox) e.getComponent();
            if (unfocus != null) {
                cb.setBorder(unfocus);
                cb.repaint();
            }
        }
    }
}
