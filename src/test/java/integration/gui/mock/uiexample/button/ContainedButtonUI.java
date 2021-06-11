package integration.gui.mock.uiexample.button;

import javax.swing.*;
import mdlaf.animation.MaterialUIMovement;
import mdlaf.components.button.MaterialButtonUI;
import mdlaf.utils.MaterialColors;

public class ContainedButtonUI extends MaterialButtonUI {

  // The propriety order inside the method installUI is important
  // because some propriety should be override
  @Override
  public void installUI(JComponent c) {
    super.mouseHoverEnabled = false;
    super.installUI(c);
    super.mouseHoverEnabled = true;
    super.colorMouseHoverNormalButton = MaterialColors.PURPLE_500;
    super.background = MaterialColors.PURPLE_700;
    c.setBackground(super.background);

    if (super.mouseHoverEnabled) {
      c.addMouseListener(MaterialUIMovement.getMovement(c, this.colorMouseHoverNormalButton));
    }
    // If you want use this style also for Default button
    // super.defaultBackground = MaterialColors.PURPLE_700;
    // super.colorMouseHoverDefaultButton = MaterialColors.PURPLE_500;
    super.borderEnabled = false;
  }
}
