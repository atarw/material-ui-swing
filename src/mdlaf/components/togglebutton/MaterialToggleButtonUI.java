package mdlaf.components.togglebutton;

import mdlaf.utils.MaterialDrawingUtils;
import sun.swing.SwingUtilities2;

import javax.swing.*;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicToggleButtonUI;
import javax.swing.plaf.metal.MetalToggleButtonUI;
import java.awt.*;

/*
 * Contributed by https://github.com/downToHell
 * */
//TODO cambio icone del togle button soprattutto il colore
public class MaterialToggleButtonUI extends BasicToggleButtonUI {

    public static ComponentUI createUI(JComponent c) {
        return new MaterialToggleButtonUI();
    }

    @Override
    public void installUI(JComponent c) {
        super.installUI(c);

        JToggleButton toggleButton = (JToggleButton) c;
        toggleButton.setBorder(UIManager.getBorder("ToggleButton.border"));
        toggleButton.setFont(UIManager.getFont("ToggleButton.font"));
        toggleButton.setBackground(UIManager.getColor("ToggleButton.background"));
        toggleButton.setForeground(UIManager.getColor("ToggleButton.foreground"));
        c.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        if (toggleButton.getIcon() == null && toggleButton.getSelectedIcon() == null) {
            toggleButton.setIcon(UIManager.getIcon("ToggleButton.icon"));
            toggleButton.setSelectedIcon(UIManager.getIcon("ToggleButton.selectedIcon"));
        }
    }

    @Override
    public void paint(Graphics g, JComponent c) {
        super.paint(MaterialDrawingUtils.getAliasedGraphics(g), c);
    }

    @Override
    protected void paintFocus(Graphics g, AbstractButton b, Rectangle viewRect, Rectangle textRect, Rectangle iconRect) {
        //do nothing
    }

    @Override
    protected void paintText(Graphics g, JComponent c, Rectangle textRect, String text) {
        AbstractButton b = (AbstractButton) c;
        ButtonModel model = b.getModel();
        FontMetrics fm = SwingUtilities2.getFontMetrics(c, g);
        int mnemonicIndex = b.getDisplayedMnemonicIndex();

        /* Draw the Text */
        if (model.isEnabled()) {
            /*** paint the text normally */
            g.setColor(b.getForeground());
            SwingUtilities2.drawStringUnderlineCharAt(c, g, text, mnemonicIndex,
                    textRect.x + getTextShiftOffset(),
                    textRect.y + fm.getAscent() + getTextShiftOffset());
        } else {
            /*** paint the text disabled ***/
            g.setColor(UIManager.getColor("ToggleButton.disabledText").brighter());
            SwingUtilities2.drawStringUnderlineCharAt(c, g, text, mnemonicIndex,
                    textRect.x, textRect.y + fm.getAscent());
            g.setColor(UIManager.getColor("ToggleButton.disabledText").darker());
            SwingUtilities2.drawStringUnderlineCharAt(c, g, text, mnemonicIndex,
                    textRect.x - 1, textRect.y + fm.getAscent() - 1);
        }
    }
}
