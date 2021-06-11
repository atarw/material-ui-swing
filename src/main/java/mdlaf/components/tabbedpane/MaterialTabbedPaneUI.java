/**
 * MIT License
 *
 * <p>Copyright (c) 2018 atharva washimkar, Copyright (c) 2018-2021 Vincenzo Palazzo
 * vincenzopalazzo1996@gmail.com
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
package mdlaf.components.tabbedpane;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.Map;
import javax.swing.*;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.UIResource;
import javax.swing.plaf.basic.BasicArrowButton;
import javax.swing.plaf.basic.BasicTabbedPaneUI;
import mdlaf.animation.MaterialMouseHover;
import mdlaf.components.button.MaterialButtonUI;
import mdlaf.utils.MaterialDrawingUtils;

/** @author https://github.com/vincenzopalazzo */
public class MaterialTabbedPaneUI extends BasicTabbedPaneUI {

  public static ComponentUI createUI(JComponent c) {
    return new MaterialTabbedPaneUI();
  }

  protected Color selectedForeground;
  protected Color disabledForeground;
  protected Color areaContentBackground;
  protected Color selectedAreaContentBackground;
  protected Color disableAreaContentBackground;
  protected Color foreground;
  protected int positionYLine;
  protected int positionXLine;
  protected int widthLine;
  protected int heightLine;
  protected int arcLine;
  protected int margin;
  protected int heightTab;
  protected boolean tabsOverlapBorder;
  protected Map<Integer, Boolean> mouseHoverInitialized;
  protected Boolean mouseHoverEnabled;
  protected MaterialMouseHoverOnTab mouseHoverTab;

  public MaterialTabbedPaneUI() {
    mouseHoverInitialized = new HashMap<>();
  }

  @Override
  public void installUI(JComponent c) {
    super.installUI(c);

    tabPane.setOpaque(false);
    this.foreground = new ColorUIResource(UIManager.getColor("TabbedPane.foreground"));
    this.selectedForeground =
        new ColorUIResource(UIManager.getColor("TabbedPane.selectionForeground"));
    this.disabledForeground = UIManager.getColor("TabbedPane.disabledForeground");
    this.areaContentBackground =
        new ColorUIResource(UIManager.getColor("TabbedPane.contentAreaColor"));
    this.disableAreaContentBackground =
        new ColorUIResource(UIManager.getColor("TabbedPane.disableContentAreaColor"));
    this.selectedAreaContentBackground =
        new ColorUIResource(UIManager.getColor("TabbedPane[focus].colorLine"));
    darkShadow = UIManager.getColor("TabbedPane.darkShadow");
    shadow = UIManager.getColor("TabbedPane.shadow");
    lightHighlight = UIManager.getColor("TabbedPane.highlight");
    this.widthLine = UIManager.getInt("TabbedPane.lineWidth");
    this.heightLine = UIManager.getInt("TabbedPane.lineHeight");
    this.arcLine = UIManager.getInt("TabbedPane.lineArch");
    this.margin = UIManager.getInt("TabbedPane[focus].margin");
    this.heightTab = UIManager.getInt("TabbedPane[tab].height");
    this.tabsOverlapBorder = UIManager.getBoolean("TabbedPane.tabsOverlapBorder");
    this.mouseHoverEnabled = UIManager.getBoolean("TabbedPane[MouseHover].enable");
  }

  @Override
  public void uninstallUI(JComponent c) {
    darkShadow = null;
    shadow = null;
    lightHighlight = null;
    super.uninstallUI(c);
  }

  @Override
  protected void paintText(
      Graphics g,
      int tabPlacement,
      Font font,
      FontMetrics metrics,
      int tabIndex,
      String title,
      Rectangle textRect,
      boolean isSelected) {
    g = MaterialDrawingUtils.getAliasedGraphics(g);
    if (!tabPane.isEnabledAt(tabIndex)) {
      int mnemIndex = this.tabPane.getDisplayedMnemonicIndexAt(tabIndex);
      MaterialDrawingUtils.drawString(
          tabPane, g, title, textRect, mnemIndex, 0, disabledForeground);
    } else {
      super.paintText(g, tabPlacement, font, metrics, tabIndex, title, textRect, isSelected);
    }
  }

  @Override
  protected void paintTabBackground(
      Graphics g, int tabPlacement, int tabIndex, int x, int y, int w, int h, boolean isSelected) {
    Graphics2D g2D = (Graphics2D) g;

    if (isSelected) {
      g2D.setColor(selectedAreaContentBackground);
      g2D.setPaint(selectedAreaContentBackground);
      tabPane.setForegroundAt(tabIndex, selectedForeground);
    } else {
      if (tabPane.isEnabled() && tabPane.isEnabledAt(tabIndex)) {
        g2D.setColor(this.tabPane.getBackground());
        g2D.setPaint(this.tabPane.getBackground());
      } else {
        g2D.setColor(disableAreaContentBackground);
        g2D.setPaint(disableAreaContentBackground);
      }
      if (tabPane.isEnabledAt(tabIndex)) {
        tabPane.setForegroundAt(tabIndex, foreground);
      } else {
        tabPane.setForegroundAt(tabIndex, disabledForeground);
      }
    }
    // this.installMouseHover(tabIndex);
  }

  @Override
  protected int calculateTabHeight(int tabPlacement, int tabIndex, int fontHeight) {
    /* if (tabPlacement == LEFT || tabPlacement == RIGHT) {
        return super.calculateTabHeight(tabPlacement, tabIndex, fontHeight);
    } else {
        return 18 + super.calculateTabHeight(tabPlacement, tabIndex, fontHeight);
    }*/
    return heightTab + super.calculateTabHeight(tabPlacement, tabIndex, fontHeight);
  }

  @Override
  protected void paintTab(
      Graphics g,
      int tabPlacement,
      Rectangle[] rects,
      int tabIndex,
      Rectangle iconRect,
      Rectangle textRect) {
    // for some reason tabs aren't painted properly by paint()
    super.paintTab(g, tabPlacement, rects, tabIndex, iconRect, textRect);
    if (mouseHoverEnabled != null && mouseHoverEnabled && mouseHoverTab == null) {
      mouseHoverTab = new MaterialMouseHoverOnTab(rects);
      tabPane.addMouseMotionListener(mouseHoverTab);
    }
  }

  @Override
  protected void paintTabBorder(
      Graphics g, int tabPlacement, int tabIndex, int x, int y, int w, int h, boolean isSelected) {
    // do nothing
    // TODO look the super method, with this method, should be calculate the select line,
    // but there is problem with dimension pass from function
  }

  @Override
  protected void paintFocusIndicator(
      Graphics g,
      int tabPlacement,
      Rectangle[] rects,
      int tabIndex,
      Rectangle iconRect,
      Rectangle textRect,
      boolean isSelected) {
    // do thing, the method paintBackground painted the focus indicator.
  }

  @Override
  protected void paintContentBorder(Graphics g, int tabPlacement, int selectedIndex) {
    // super.paintContentBorder(g, tabPlacement, selectedIndex);
    int width = tabPane.getWidth();
    int height = tabPane.getHeight();
    Insets insets = tabPane.getInsets();
    Insets tabAreaInsets = getTabAreaInsets(tabPlacement);

    int x = insets.left;
    int y = insets.top;
    int w = width - insets.right - insets.left;
    int h = height - insets.top - insets.bottom;

    switch (tabPlacement) {
      case LEFT:
        x += calculateTabAreaWidth(tabPlacement, runCount, maxTabWidth);
        if (tabsOverlapBorder) {
          x -= tabAreaInsets.right;
        }
        w -= (x - insets.left);
        break;
      case RIGHT:
        w -= calculateTabAreaWidth(tabPlacement, runCount, maxTabWidth);
        if (tabsOverlapBorder) {
          w += tabAreaInsets.left;
        }
        break;
      case BOTTOM:
        h -= calculateTabAreaHeight(tabPlacement, runCount, maxTabHeight);
        if (tabsOverlapBorder) {
          h += tabAreaInsets.top;
        }
        break;
      case TOP:
      default:
        y += calculateTabAreaHeight(tabPlacement, runCount, maxTabHeight);
        if (tabsOverlapBorder) {
          y -= tabAreaInsets.bottom;
        }
        h -= (y - insets.top);
    }

    if (tabPlacement == TOP) {
      this.paintContentBorderTopEdge(g, tabPlacement, selectedIndex, x, y, w, h);
    } else if (tabPlacement == BOTTOM) {
      this.paintContentBorderBottomEdge(g, tabPlacement, selectedIndex, x, y, w, h);
    } else if (tabPlacement == LEFT) {
      this.paintContentBorderLeftEdge(g, tabPlacement, selectedIndex, x, y, w, h);
    } else if (tabPlacement == RIGHT) {
      this.paintContentBorderRightEdge(g, tabPlacement, selectedIndex, x, y, w, h);
    }
  }

  @Override
  protected void paintContentBorderBottomEdge(
      Graphics g, int tabPlacement, int selectedIndex, int x, int y, int w, int h) {
    Rectangle selRect = selectedIndex < 0 ? null : getTabBounds(selectedIndex, calcRect);

    g.setColor(lightHighlight);

    // Draw unbroken line if tabs are not on BOTTOM, OR
    // selected tab is not in run adjacent to content, OR
    // selected tab is not visible (SCROLL_TAB_LAYOUT)
    //
    if (tabPlacement != BOTTOM
        || selectedIndex < 0
        || (selRect.y - 1 > h)
        || (selRect.x < x || selRect.x > x + w)) {
      g.drawLine(x + 1, y + h - 2, x + w - 2, y + h - 2);
      g.setColor(darkShadow);
      g.drawLine(x, y + h - 1, x + w - 1, y + h - 1);
    } else {
      // Break line to show visual connection to selected tab
      g.drawLine(x + 1, y + h - 2, selRect.x - 1, y + h - 2);
      // g.setColor(areaContentBackground);
      // g.drawLine(x, y+h-1, selRect.x - 1, y+h-1);
      g.setColor(selectedAreaContentBackground);
      // g.drawLine(selRect.x - 1, y+h-2, selRect.x + selRect.width, y+h-2);
      g.fillRect(selRect.x, y + h - 2, selRect.width, heightLine);
      if (selRect.x + selRect.width < x + w - 2) {
        g.setColor(lightHighlight);
        g.drawLine(selRect.x + selRect.width, y + h - 2, x + w - 2, y + h - 2);
        // g.setColor(darkShadow);
        // g.drawLine(selRect.x + selRect.width, y+h-1, x+w-1, y+h-1);
      }
    }
  }

  @Override
  protected void paintContentBorderLeftEdge(
      Graphics g, int tabPlacement, int selectedIndex, int x, int y, int w, int h) {
    // super.paintContentBorderLeftEdge(g, tabPlacement, selectedIndex, x, y, w, h);

    Rectangle selRect = selectedIndex < 0 ? null : getTabBounds(selectedIndex, calcRect);

    g.setColor(lightHighlight);

    // Draw unbroken line if tabs are not on LEFT, OR
    // selected tab is not in run adjacent to content, OR
    // selected tab is not visible (SCROLL_TAB_LAYOUT)
    //
    if (tabPlacement != LEFT
        || selectedIndex < 0
        || (selRect.x + selRect.width + 1 < x)
        || (selRect.y < y || selRect.y > y + h)) {
      g.drawLine(x, y, x, y + h - 2);
    } else {
      // Break line to show visual connection to selected tab
      /*g.drawLine(x, y, x, selRect.y - 1);
      if (selRect.y + selRect.height < y + h - 2) {
          g.drawLine(x, selRect.y + selRect.height,
                  x, y+h-2);
      }*/
      g.setColor(selectedAreaContentBackground);
      g.fillRect(selRect.x + heightLine, selRect.y, heightLine, selRect.height);
      // g.fillRect(tabPane.getX() + heightLine, selRect.y, heightLine, selRect.height);
    }
  }

  @Override
  protected void paintContentBorderRightEdge(
      Graphics g, int tabPlacement, int selectedIndex, int x, int y, int w, int h) {
    // super.paintContentBorderRightEdge(g, tabPlacement, selectedIndex, x, y, w, h);
    Rectangle selRect = selectedIndex < 0 ? null : getTabBounds(selectedIndex, calcRect);

    g.setColor(lightHighlight);

    // Draw unbroken line if tabs are not on RIGHT, OR
    // selected tab is not in run adjacent to content, OR
    // selected tab is not visible (SCROLL_TAB_LAYOUT)
    //
    if (tabPlacement != RIGHT
        || selectedIndex < 0
        || (selRect.x - 1 > w)
        || (selRect.y < y || selRect.y > y + h)) {
      g.drawLine(x + w - 2, y + 1, x + w - 2, y + h - 3);
      g.setColor(darkShadow);
      g.drawLine(x + w - 1, y, x + w - 1, y + h - 1);
    } else {
      // Break line to show visual connection to selected tab
      // g.drawLine(x+w-2, y+1, x+w-2, selRect.y - 1);
      // g.setColor(darkShadow);
      // g.drawLine(x+w-1, y, x+w-1, selRect.y - 1);

      /*if (selRect.y + selRect.height < y + h - 2) {
          g.setColor(shadow);
          g.drawLine(x+w-2, selRect.y + selRect.height,
                  x+w-2, y+h-2);
          g.setColor(darkShadow);
          g.drawLine(x+w-1, selRect.y + selRect.height,
                  x+w-1, y+h-2);
      }*/
      // g.drawLine(x + w + selRect.width - (heightLine * 2), y, (selRect.x + selRect.width -
      // heightLine) - heightLine, selRect.y);
      // g.drawLine(x + w + selRect.width - (heightLine * 2), selRect.y + selRect.height, x + w +
      // selRect.width - (heightLine * 2), y + h);
      g.setColor(selectedAreaContentBackground);
      g.fillRect(
          (selRect.x + selRect.width - heightLine) - heightLine,
          selRect.y,
          heightLine,
          selRect.height);
    }
  }

  @Override
  protected void paintContentBorderTopEdge(
      Graphics g, int tabPlacement, int selectedIndex, int x, int y, int w, int h) {
    // super.paintContentBorderTopEdge(g, tabPlacement, selectedIndex, x, y, w, h);
    Rectangle selRect = selectedIndex < 0 ? null : getTabBounds(selectedIndex, calcRect);

    g.setColor(lightHighlight);

    // Draw unbroken line if tabs are not on TOP, OR
    // selected tab is not in run adjacent to content, OR
    // selected tab is not visible (SCROLL_TAB_LAYOUT)
    //
    if (tabPlacement != TOP
        || selectedIndex < 0
        || (selRect.y + selRect.height + 1 < y)
        || (selRect.x < x || selRect.x > x + w)) {
      g.drawLine(x, y, x + w - 2, y);
    } else {
      // Line to left selected line
      g.drawLine(x, y, selRect.x - 1, y);
      // line to right selected line
      if (selRect.x + selRect.width < x + w - 2) {
        g.drawLine(selRect.x + selRect.width, y, x + w - 2, y);
      } /*else {
            //g.setColor(shadow);
            //g.drawLine(x+w-2, y, x+w-2, y);
            //g.setColor(selectedAreaContentBackground);
            //g.drawRect(selRect.x - 1, y+h-2, selRect.width, heightLine);
        }*/
      g.setColor(selectedAreaContentBackground);
      g.fillRect(selRect.x, y - heightLine + 1, selRect.width, heightLine);
      // g.drawLine(x, y, x+w-2, y);
    }
  }

  // TODO remove this methods inside the version 1.2 of library.
  // The implementation inside this method was deprecated because cause
  // this issue: https://github.com/vincenzopalazzo/material-ui-swing/issues/109
  // I'm deprecating this implementation with an if-else and inside the version 1.2 of the library
  // the implementation of this method was removed such as the Implementation of
  // MaterialTabbedPaneLayout
  // MaterialTabbedPaneLayout was declared deprecated.
  /*@Override
  protected LayoutManager createLayoutManager() {
      if (tabPane.getTabLayoutPolicy() == JTabbedPane.SCROLL_TAB_LAYOUT) {
          return super.createLayoutManager();
      }else{
          return super.createLayoutManager();
      }
      //return new MaterialTabbedPaneLayout();
  }*/

  @Override
  protected void uninstallListeners() {
    super.uninstallListeners();
    super.tabPane.removeMouseMotionListener(mouseHoverTab);
  }

  @Override
  protected JButton createScrollButton(int direction) {
    return new ArrowButtonTabbedPane(direction);
  }

  /** @deprecated remove this implementation inside the version 1.2 of the library. */
  @Deprecated
  protected class MaterialTabbedPaneLayout extends BasicTabbedPaneUI.TabbedPaneLayout {

    protected int spacer; // should be non-negative
    protected int indent;

    public MaterialTabbedPaneLayout() {
      this.spacer = UIManager.getInt("TabbedPane.spacer");
      this.indent = UIManager.getInt("TabbedPane.indent");
    }

    @Override
    protected void calculateTabRects(int tabPlacement, int tabCount) {
      if (spacer < 0) {
        throw new IllegalArgumentException(
            "The spacer inside the "
                + this.getClass().getSimpleName()
                + " must be a not negative value");
      }

      super.calculateTabRects(tabPlacement, tabCount);
      if (tabPlacement == TOP || tabPlacement == BOTTOM) {
        for (int i = 0; i < rects.length; i++) {
          rects[i].x += i * spacer + indent;
        }
      }
    }
  }

  /**
   * This class implement the mouse hover effect on TabbedPane, is a mouseMotion listener and is run
   * on all JTabbedPane component, when the mouse is hover aver the tab this event change the
   * cursor.
   *
   * <p>P.S: This event is run every time and it can be hide exception client logic, before to open
   * the issue about the library make more test with the mouse hover on TabbedPane disabled. You can
   * disable the mouse hover effect with this code UIManager.put("TabbedPane[MouseHover].enable",
   * false) after the code for setLookAndFell()
   */
  protected class MaterialMouseHoverOnTab implements MaterialMouseHover {

    private Rectangle[] rectangles;

    public MaterialMouseHoverOnTab(Rectangle[] rectangles) {
      this.rectangles = rectangles;
    }

    @Override
    public void mouseDragged(MouseEvent e) {}

    @Override
    public void mouseMoved(MouseEvent e) {
      JComponent mouseGenerate = (JComponent) e.getSource();
      if (!mouseGenerate.isEnabled()) {
        return;
      }
      if (mouseGenerate.getCursor().equals(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR))) {
        return;
      }
      Point point = e.getPoint();
      for (Rectangle r : rectangles) {
        if (r.contains(point)) {
          mouseGenerate.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
          return;
        }
      }
      mouseGenerate.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    }

    @Override
    public void mouseClicked(MouseEvent e) {
      // do nothing
    }

    @Override
    public void mousePressed(MouseEvent e) {
      // do nothing
    }

    @Override
    public void mouseReleased(MouseEvent e) {
      // do nothing
    }

    @Override
    public void mouseEntered(MouseEvent e) {
      // do nothing
    }

    @Override
    public void mouseExited(MouseEvent e) {
      // do nothing
    }

    @Override
    public boolean isRunning() {
      return false;
    }
  }

  protected class ArrowButtonTabbedPane extends JButton implements UIResource {

    private static final String PREFIX = "TabbedPane[scrollButton]";

    protected int direction;
    protected Icon disabled;
    protected Icon enabled;

    public ArrowButtonTabbedPane(int direction) {
      setUI(new ArrowButtonTabbedPaneUI(direction));
      this.direction = direction;
      switch (direction) {
          // TODO TOP? Button?
        case BasicArrowButton.WEST:
          // Leaft icon
          this.disabled = UIManager.getIcon(getPREFIX() + ".iconLeft");
          this.enabled = UIManager.getIcon(getPREFIX() + ".disabledIconLeft");
          break;
        case BasicArrowButton.EAST:
          // Right icon
          this.disabled = UIManager.getIcon(getPREFIX() + ".disabledIconRight");
          this.enabled = UIManager.getIcon(getPREFIX() + ".iconRight");
          break;
        case BasicArrowButton.SOUTH:
          // Bottom icon
          this.disabled = UIManager.getIcon(getPREFIX() + ".disabledBottomRight");
          this.enabled = UIManager.getIcon(getPREFIX() + ".iconBottom");
          break;
        default:
          // TOP icon
          this.disabled = UIManager.getIcon(getPREFIX() + ".disabledIconTop");
          this.enabled = UIManager.getIcon(getPREFIX() + ".iconTop");
          break;
      }
      this.setIcon(enabled);
      this.setDisabledIcon(disabled);
    }

    public String getPREFIX() {
      return PREFIX;
    }

    @Override
    public void updateUI() {
      setUI(new ArrowButtonTabbedPaneUI(this.direction));
    }

    protected class ArrowButtonTabbedPaneUI extends MaterialButtonUI {

      protected int direction;

      public ArrowButtonTabbedPaneUI(int direction) {
        this.direction = direction;
      }

      @Override
      public void installUI(JComponent c) {
        super.mouseHoverEnabled = false;
        super.installUI(c);
        super.background = UIManager.getColor("TabbedPane.background");
        super.disabledBackground = super.background;
        super.borderEnabled = false;
        c.setBorder(BorderFactory.createMatteBorder(5, 5, 10, 5, super.background));
      }

      @Override
      protected void paintBackground(Graphics g, JComponent c) {
        super.paintBackground(g, c);
      }

      @Override
      protected void paintFocus(
          Graphics g,
          AbstractButton b,
          Rectangle viewRect,
          Rectangle textRect,
          Rectangle iconRect) {}

      @Override
      protected void paintFocusRing(Graphics g, JButton b) {}
    }
  }
}
