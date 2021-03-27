/**
 * MIT License
 *
 * <p>Copyright (c) 2018-2020 atharva washimkar, Vincenzo Palazzo vincenzopalazzo1996@gmail.com
 * Copyright (c) 2021 Vincenzo Palazzo vincenzopalazzodev@gmail.com
 *
 * <p>Permission is hereby granted, free of charge, to any person obtaining a copy of this software
 * and associated documentation files (the "Software"), to deal in the Software without restriction,
 * including without limitation the rights to use, copy, modify, merge, publish, distribute,
 * sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * <p>The above copyright notice and this permission notice shall be included in all copies or
 * substantial portions of the Software.
 *
 * <p>THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING
 * BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM,
 * DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package mdlaf.components.internalframe;

import java.awt.*;
import javax.swing.*;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import mdlaf.components.button.MaterialButtonUI;

/** @author https://github.com/vincenzopalazzo */
public class MaterialInternalFrameTitlePane extends BasicInternalFrameTitlePane {

  public MaterialInternalFrameTitlePane(JInternalFrame f) {
    super(f);
  }

  @Override
  protected void installDefaults() {
    super.installDefaults();
  }

  @Override
  protected void paintBorder(Graphics g) {
    // super.paintBorder(g);
    /*  int w = getWidth();
      int h = getHeight();

      Color top = UIManager.getColor("InternalFrameTitlePane.borderColorTop");
      Color left = UIManager.getColor("InternalFrameTitlePane.borderColorLeft");
      Color bottom = UIManager.getColor("InternalFrameTitlePane.borderColorBottom");
      if (frame.isSelected()) {
          top = UIManager.getColor("InternalFrameTitlePane.selected.borderColorTop");
          left = UIManager.getColor("InternalFrameTitlePane.selected.borderColorLeft");
          bottom = UIManager.getColor("InternalFrameTitlePane.selected.borderColorBottom");
      }

    //  g.setColor(MaterialColors.GRAY_50);
      g.drawLine(2, 0, w, 0);
      g.setColor(left);
      g.drawLine(0, 1, 0, h);
      g.setColor(bottom);
      g.drawLine(2, h, w, h);*/
  }

  @Override
  public void paintComponent(Graphics g) {
    super.paintTitleBackground(g);
  }

  @Override
  protected void createButtons() {
    super.createButtons();
    closeButton.setUI(new ButtonTitlePane());
    maxButton.setUI(new ButtonTitlePane());
    iconButton.setUI(new ButtonTitlePane());
  }

  protected class ButtonTitlePane extends MaterialButtonUI {

    @Override
    public void installUI(JComponent c) {
      super.mouseHoverEnabled = false;
      super.borderEnabled = false;
      super.installUI(c);
    }
  }
}
