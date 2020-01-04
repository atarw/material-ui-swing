package integration.gui.mock;

import mdlaf.components.button.MaterialButtonUI;
import mdlaf.utils.MaterialColors;
import mdlaf.utils.MaterialFontFactory;

import javax.swing.*;
import javax.swing.plaf.ComponentUI;
import java.awt.*;

/**
 * @author https://github.com/vincenzopalazzo
 */
public class PersonalButtonUI extends MaterialButtonUI {


    @SuppressWarnings({"MethodOverridesStaticMethodOfSuperclass", "UnusedDeclaration"})
    public static ComponentUI createUI(JComponent c) {
        return new PersonalButtonUI();
    }

    @Override
    public void installUI(JComponent c) {
        super.installUI(c);
        super.disabledBackground = MaterialColors.LIGHT_BLUE_600;
        super.disabledForeground = MaterialColors.WHITE;
        c.setFont(MaterialFontFactory.getInstance().getFont(MaterialFontFactory.BOLD));
    }

    public void setColorDisableBackground(Color newColor){
        if(newColor == null){
            throw new IllegalArgumentException("argument null");
        }
        super.disabledBackground = newColor;
        //This is bad operation because recall the paint method of the component
        //With an wrong implementation this code can be cause the paint loop.
        this.button.repaint();
    }
}
