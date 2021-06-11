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
package mdlaf.components.radiobutton;

import java.awt.*;
import java.awt.event.MouseEvent;
import javax.swing.*;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.UIResource;
import javax.swing.plaf.metal.MetalRadioButtonUI;
import mdlaf.animation.MaterialMouseHover;
import mdlaf.utils.MaterialDrawingUtils;

/**
 * @author https://github.com/vincenzopalazzo
 * @author https://github.com/atarw
 * @author https://github.com/downToHell
 */
public class MaterialRadioButtonUI extends MetalRadioButtonUI {

  public static ComponentUI createUI(JComponent c) {
    return new MaterialRadioButtonUI();
  }

  protected JRadioButton radioButton;
  protected Boolean mouseHoverEnable;
  protected Color mouseHoverColor;
  protected boolean isHover;
  protected MaterialMouseHover mouseHover;

  @Override
  public void installUI(JComponent c) {
    super.installUI(c);
    this.radioButton = (JRadioButton) c;
    c.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    this.mouseHoverColor = UIManager.getColor("RadioButton.mouseHoverColor");
    icon = new MaterialRadioButtonIcon(this.getPropertyPrefix());
  }

  @Override
  public void installDefaults(AbstractButton b) {
    super.installDefaults(b);
    this.mouseHoverEnable = UIManager.getBoolean("RadioButton.mouseHoverEnabled");
    if (this.mouseHoverEnable) {
      this.mouseHover = new MouseHoverEvent();
    }
  }

  @Override
  public void uninstallUI(JComponent c) {
    c.setCursor(Cursor.getDefaultCursor());
    super.uninstallUI(c);
  }

  @Override
  public synchronized void paint(Graphics g, JComponent c) {
    super.paint(g, c);
    /*if(this.mouseHoverEnable && this.isHover){
    	paintFocusEffect(g);
    }*/
  }

  @Override
  protected void paintFocus(Graphics g, Rectangle t, Dimension d) {
    // do nothing
    // paintFocusEffect(g);
  }

  protected void paintFocusEffect(Graphics g) {
    Color color =
        this.radioButton.isSelected() ? this.mouseHoverColor : this.radioButton.getForeground();
    MaterialDrawingUtils.drawCircle(g, 0, 0, 14, color);
  }

  @Override
  protected void installListeners(AbstractButton button) {
    super.installListeners(button);
    if (this.mouseHoverEnable) {
      button.addMouseListener(this.mouseHover);
    }
  }

  @Override
  protected void uninstallListeners(AbstractButton button) {
    super.uninstallListeners(button);
    if (this.mouseHoverEnable) {
      button.removeMouseListener(this.mouseHover);
    }
  }

  protected class MouseHoverEvent implements MaterialMouseHover {

    @Override
    public void mouseClicked(MouseEvent e) {}

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {
      isHover = true;
      radioButton.repaint();
    }

    @Override
    public void mouseExited(MouseEvent e) {
      isHover = false;
      radioButton.repaint();
    }

    @Override
    public void mouseDragged(MouseEvent e) {}

    @Override
    public void mouseMoved(MouseEvent e) {}

    @Override
    public boolean isRunning() {
      return isHover;
    }
  }

  protected class MaterialRadioButtonIcon implements Icon, UIResource {

    protected Icon unselectedIcon;
    protected Icon selectedIcon;
    protected Icon disabledIcon;
    protected Icon disabledSelectedIcon;

    public MaterialRadioButtonIcon(String componentPrefix) {
      unselectedIcon = UIManager.getIcon(componentPrefix + "icon");
      selectedIcon = UIManager.getIcon(componentPrefix + "selectedIcon");
      disabledIcon = UIManager.getIcon(componentPrefix + "disabledIcon");
      disabledSelectedIcon = UIManager.getIcon(componentPrefix + "disabledSelectedIcon");
    }

    @Override
    public void paintIcon(Component c, Graphics g, int x, int y) {
      if (radioButton.isEnabled()) {
        if (radioButton.isSelected()) {
          this.selectedIcon.paintIcon(c, g, x, y);
        } else {
          this.unselectedIcon.paintIcon(c, g, x, y);
        }
      } else {
        if (radioButton.isSelected()) {
          this.disabledSelectedIcon.paintIcon(c, g, x, y);
        } else {
          this.disabledIcon.paintIcon(c, g, x, y);
        }
      }
    }

    @Override
    public int getIconWidth() {
      return selectedIcon.getIconWidth();
    }

    @Override
    public int getIconHeight() {
      return selectedIcon.getIconHeight();
    }
  }

  protected class AnimatedIconAdapter implements Icon, UIResource {

    private Icon adapter;
    private Color color;

    public AnimatedIconAdapter(Icon adapter, Color color) {
      this.adapter = adapter;
      this.color = color;
    }

    @Override
    public void paintIcon(Component c, Graphics g, int x, int y) {
      adapter.paintIcon(c, g, x, y);
      if (mouseHoverEnable && (isHover || c.hasFocus())) {
        Graphics g2 = g.create();
        MaterialDrawingUtils.drawCircle(g2, x, y, 12, color);
        g2.dispose();
      }
    }

    @Override
    public int getIconWidth() {
      return adapter.getIconWidth();
    }

    @Override
    public int getIconHeight() {
      return adapter.getIconHeight();
    }
  }
}
