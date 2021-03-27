package integration.gui.mock.component;

import java.awt.*;
import javax.swing.*;
import javax.swing.plaf.ComponentUI;
import mdlaf.components.button.MaterialButtonUI;
import mdlaf.utils.MaterialColors;

/** @author https://github.com/vincenzopalazzo */
public class PersonalButtonUI extends MaterialButtonUI {

  @SuppressWarnings({"MethodOverridesStaticMethodOfSuperclass", "UnusedDeclaration"})
  public static ComponentUI createUI(JComponent c) {
    return new PersonalButtonUI();
  }

  @Override
  public void installUI(JComponent c) {
    super.installUI(c);
    super.borderEnabled = false;
    super.disabledBackground = MaterialColors.LIGHT_BLUE_600;
    super.disabledForeground = MaterialColors.WHITE;
  }

  public void setColorDisableBackground(Color newColor) {
    if (newColor == null) {
      return;
      // throw new IllegalArgumentException("argument null");
    }
    super.disabledBackground = newColor;
    // This is bad operation because recall the paint method of the component
    // With an wrong implementation this code can be cause the paint loop.
    this.button.repaint();
  }
}
