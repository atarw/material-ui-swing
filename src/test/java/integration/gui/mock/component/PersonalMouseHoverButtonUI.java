package integration.gui.mock.component;

import mdlaf.animation.MaterialUIMovement;
import mdlaf.components.button.MaterialButtonUI;
import mdlaf.utils.MaterialColors;

import javax.swing.*;
import javax.swing.plaf.ComponentUI;
import java.awt.*;

public class PersonalMouseHoverButtonUI extends MaterialButtonUI {

    @SuppressWarnings({"MethodOverridesStaticMethodOfSuperclass", "UnusedDeclaration"})
    public static ComponentUI createUI(JComponent c) {
        return new PersonalMouseHoverButtonUI();
    }

    @Override
    public void installUI(JComponent c) {
        super.mouseHoverEnabled = Boolean.FALSE;
        super.installUI(c);
        super.mouseHoverEnabled = Boolean.TRUE;
        JButton button = (JButton) c;
        button.addMouseListener(MaterialUIMovement.getMovement(button, MaterialColors.PINK_500));
    }

    @Override
    protected void paintFocusRing(Graphics g, JButton b) {
        //do nothing
        //This disable the focus effect
    }
}
