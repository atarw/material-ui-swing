/*
 * MIT License
 *
 * Copyright (c) 2019 Vincent Palazzo vincenzopalazzodev@gmail.com
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package mdlaf.components.tabbedpane;

import mdlaf.utils.MaterialColors;
import mdlaf.utils.MaterialDrawingUtils;

import javax.swing.*;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.UIResource;
import javax.swing.plaf.basic.BasicArrowButton;
import javax.swing.plaf.basic.BasicTabbedPaneUI;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

/**
 * @author https://github.com/vincenzopalazzo
 */
public class MaterialTabbedPaneUI extends BasicTabbedPaneUI {

	public static ComponentUI createUI(JComponent c) {
		return new MaterialTabbedPaneUI();
	}

	protected JTabbedPane component;
	protected ColorUIResource selectedForeground;
	protected ColorUIResource areaContentBackground;
	protected ColorUIResource selectedAreaContentBackground;
	protected ColorUIResource disableAreaContentBackground;
	protected ColorUIResource foreground;
	protected int positionYLine;
	protected int positionXLine;
	protected int widthLine;
	protected int heightLine;
	protected int arcLine;
	protected boolean tabsOverlapBorder;

	@Override
	public void installUI(JComponent c) {
		super.installUI(c);

		JTabbedPane tabbedPane = (JTabbedPane) c;
		tabbedPane.setOpaque(false);
		tabbedPane.setFont(UIManager.getFont("TabbedPane.font"));
		tabbedPane.setBackground(UIManager.getColor("TabbedPane.background"));
		this.foreground = new ColorUIResource(UIManager.getColor("TabbedPane.foreground"));
		tabbedPane.setForeground(foreground);
		this.selectedForeground = new ColorUIResource(UIManager.getColor("TabbedPane.selectionForeground"));
		this.areaContentBackground = new ColorUIResource(UIManager.getColor("TabbedPane.contentAreaColor"));
		this.disableAreaContentBackground = new ColorUIResource(UIManager.getColor("TabbedPane.disableContentAreaColor"));
		this.selectedAreaContentBackground = new ColorUIResource(UIManager.getColor("TabbedPane[focus].colorLine"));
		tabbedPane.setBorder(UIManager.getBorder("TabbedPane.border"));
		darkShadow = UIManager.getColor("TabbedPane.darkShadow");
		shadow = UIManager.getColor("TabbedPane.shadow");
		lightHighlight = UIManager.getColor("TabbedPane.highlight");
		this.positionYLine = UIManager.getInt("TabbedPane.linePositionY");
		this.positionXLine = UIManager.getInt("TabbedPane.linePositionX");
		this.widthLine = UIManager.getInt("TabbedPane.lineWidth");
		this.heightLine = UIManager.getInt("TabbedPane.lineHeight");
		this.arcLine = UIManager.getInt("TabbedPane.lineArch");
		tabsOverlapBorder = UIManager.getBoolean("TabbedPane.tabsOverlapBorder");
		this.component = tabbedPane;
	}

	@Override
	public void uninstallUI(JComponent c) {

		JTabbedPane tabbedPane = (JTabbedPane) c;
		tabbedPane.setFont(null);
		tabbedPane.setBackground(null);
		tabbedPane.setForeground(null);
		tabbedPane.setBorder(null);

		darkShadow = null;
		shadow = null;
		lightHighlight = null;

		component = null;

		super.uninstallDefaults();
		super.uninstallUI(c);
	}

	//
	// This method was inspired me for this style, special thank https://github.com/davidsommer/material-JTabbedPane
	//
	@Override
	protected void paintTabBackground(Graphics g, int tabPlacement, int tabIndex, int x, int y, int w, int h, boolean isSelected) {
		Graphics2D g2D = (Graphics2D) g;

		if (isSelected) {
			g2D.setColor(selectedAreaContentBackground);
			g2D.setPaint(selectedAreaContentBackground);
			tabPane.setForegroundAt(tabIndex, selectedForeground);

		} else {
			if (tabPane.isEnabled() && tabPane.isEnabledAt(tabIndex)) {
				g2D.setColor(this.component.getBackground());
				g2D.setPaint(this.component.getBackground());
			} else {
				g2D.setColor(disableAreaContentBackground);
				g2D.setPaint(disableAreaContentBackground);
			}
			tabPane.setForegroundAt(tabIndex, foreground);
		}

		if (tabPane.getTabLayoutPolicy() != JTabbedPane.SCROLL_TAB_LAYOUT) {
			int width = tabPane.getWidth();
			int height = tabPane.getHeight();
			Insets insets = tabPane.getInsets();
			Insets tabAreaInsets = getTabAreaInsets(tabPlacement);

			int xl = insets.left;
			int yl = insets.top;
			int wl = width - insets.right - insets.left;
			int hl = height - insets.top - insets.bottom;
			if (tabPlacement == TOP) {
				yl += calculateTabAreaHeight(tabPlacement, runCount, maxTabHeight);
				g.setColor(selectedAreaContentBackground);
				g.drawLine(xl, yl, wl, yl);
			} else {
				int xp[];
				int yp[];
				Polygon shape = null;
				Rectangle shapeRect = null;
				if (tabPlacement == BOTTOM) {
					y += 20;
					xp = new int[]{x, x, x, x + w, x + w, x + w, x + w, x};
					yp = new int[]{(y + heightLine), y, y, y, y, y, y + heightLine, y + heightLine};
					shape = new Polygon(xp, yp, xp.length);
				} else if (tabPlacement == LEFT) {
					//xp = new int[]{0, 0, 0, h, h, h, h, 0};
					x += 5;
					//yp = new int[]{(y + heightLine), y, y, y, y, y, y + heightLine, y + heightLine};
					shapeRect = new Rectangle(x, y, heightLine, w / (tabPane.getTabCount()));
				} else {
					x -= 5;
					//super.paintTabBackground(g, tabPlacement, tabIndex, x, y, w, h, isSelected);
					shapeRect = new Rectangle(x + w - heightLine, y + (heightLine), heightLine, w / (tabPane.getTabCount()));
				}

				if (shape != null) {
					g2D.fill(shape);
				} else if (shapeRect != null) {
					g2D.fill(shapeRect);
				}
			}
		} else {

           /* Rectangle rectangle = rects[tabIndex];

            x = rectangle.x;
            y = rectangle.y;
            w = rectangle.width;
            h = rectangle.height;*/
			//System.out.println("****Scroll View: x: " + x + " y: " + y + " w: " + w + " h: " + h);

			int xp[];
			int yp[];
			Polygon shape = null;
			Rectangle shapeRect = null;
			if (tabPlacement == TOP) {
				xp = new int[]{x, x, x, x + w, x + w, x + w, x + w, x};
				yp = new int[]{(y + positionYLine + heightLine), y + positionYLine, y + positionYLine, y + positionYLine, y + positionYLine, y + positionYLine, y + positionYLine + heightLine, y + positionYLine + heightLine};
				shape = new Polygon(xp, yp, xp.length);
			} else if (tabPlacement == BOTTOM) {
				y += 20;
				xp = new int[]{x, x, x, x + w, x + w, x + w, x + w, x};
				yp = new int[]{(y + heightLine), y, y, y, y, y, y + heightLine, y + heightLine};
				shape = new Polygon(xp, yp, xp.length);
			} else if (tabPlacement == LEFT) {
				//xp = new int[]{0, 0, 0, h, h, h, h, 0};
				//yp = new int[]{(y + heightLine), y, y, y, y, y, y + heightLine, y + heightLine};
				shapeRect = new Rectangle(x, y, heightLine, w / (tabPane.getTabCount()));
			} else {
				//super.paintTabBackground(g, tabPlacement, tabIndex, x, y, w, h, isSelected);
				shapeRect = new Rectangle(x + w - heightLine, y + (heightLine), heightLine, w / (tabPane.getTabCount()));
			}

			if (shape != null) {
				g2D.fill(shape);
			} else if (shapeRect != null) {
				g2D.fill(shapeRect);
			}
		}

	}


	@Override
	protected int calculateTabHeight(int tabPlacement, int tabIndex, int fontHeight) {
		if (tabPlacement == LEFT || tabPlacement == RIGHT) {
			return super.calculateTabHeight(tabPlacement, tabIndex, fontHeight);
		} else {
			return 18 + super.calculateTabHeight(tabPlacement, tabIndex, fontHeight);
		}
	}

	@Override
	protected void paintTab(Graphics g, int tabPlacement, Rectangle[] rects, int tabIndex, Rectangle iconRect, Rectangle textRect) {
		// for some reason tabs aren't painted properly by paint()
		super.paintTab(MaterialDrawingUtils.getAliasedGraphics(g), tabPlacement, rects, tabIndex, iconRect, textRect);
		if (UIManager.getBoolean("TabbedPane[MouseHover].enable")) {
			component.addMouseMotionListener(new MouseHoverTab(rects));
		}
	}

	@Override
	protected void paintTabBorder(Graphics g, int tabPlacement, int tabIndex, int x, int y, int w, int h, boolean isSelected) {
		// do nothing
	}

	@Override
	protected void paintFocusIndicator(Graphics g, int tabPlacement, Rectangle[] rects, int tabIndex, Rectangle iconRect, Rectangle textRect, boolean isSelected) {
		// do thing, the method paintBackground painted the focus indicator.
	}

	@Override //TODO debuggin this method, look the issue inside JMARS,
	protected void paintContentBorder(Graphics g, int tabPlacement, int selectedIndex) {
		//TODO I'm working here.
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

		if (tabPane.getTabCount() > 0 && tabPane.isOpaque()) {
			// Fill region behind content area
			Color color = UIManager.getColor("TabbedPane.contentAreaColor");
			if (color != null) {
				g.setColor(color);
			} else if (selectedAreaContentBackground == null || selectedIndex == -1) {
				g.setColor(tabPane.getBackground());
			} else {
				g.setColor(selectedAreaContentBackground);
			}
			//g.drawLine(x, y, w, y);
		}
		//TODO i'm work here
		if (tabPlacement == TOP) {
			paintContentBorderTopEdge(g, tabPlacement, selectedIndex, x, y, w, h);
		}/* else if (tabPlacement == BOTTOM) {
            paintContentBorderBottomEdge(g, tabPlacement, selectedIndex, x, y, w, h);
        } else if (tabPlacement == LEFT) {
            paintContentBorderLeftEdge(g, tabPlacement, selectedIndex, x, y, w, h);
        } else if (tabPlacement == RIGHT) {
            paintContentBorderRightEdge(g, tabPlacement, selectedIndex, x, y, w, h);
        }*/
	}

	@Override
	public void paint(Graphics g, JComponent c) {
		super.paint(g, c);
	}

	@Override
	protected LayoutManager createLayoutManager() {
		if (tabPane.getTabLayoutPolicy() == JTabbedPane.SCROLL_TAB_LAYOUT) {
			return super.createLayoutManager();
		}
		return new MaterialTabbedPaneLayout();
	}

	@Override
	protected JButton createScrollButton(int direction) {
		return new MaterialArrowButton(direction);
	}

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
				throw new IllegalArgumentException("The spacer inside the " +
						this.getClass().getSimpleName() + " must be a not negative value");
			}

			super.calculateTabRects(tabPlacement, tabCount);
			if (tabPlacement == TOP || tabPlacement == BOTTOM) {
				for (int i = 0; i < rects.length; i++) {
					rects[i].x += i * spacer + indent;
				}
			}
		}
	}

	protected class MouseHoverTab implements MouseMotionListener {

		private Rectangle[] rectangles;

		public MouseHoverTab(Rectangle[] rectangles) {
			this.rectangles = rectangles;
		}

		@Override
		public void mouseDragged(MouseEvent e) {
		}

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
	}

	//TODO I will work on this
	protected class MaterialArrowButton extends BasicArrowButton implements UIResource,
			SwingConstants {

		public MaterialArrowButton(int direction, Color background, Color shadow, Color darkShadow, Color highlight) {
			super(direction, background, shadow, darkShadow, highlight);
		}

		public MaterialArrowButton(int direction) {
			super(direction);
		}

		@Override
		public void paint(Graphics g) {
			super.paint(g);
			g.setColor(MaterialColors.COSMO_MEDIUM_GRAY);
			this.setBackground(MaterialColors.GRAY_300);
		}

		@Override
		public void paintTriangle(Graphics g, int x, int y, int size, int direction, boolean isEnabled) {
			super.paintTriangle(g, x, y, size, direction, isEnabled);
			g.setColor(MaterialColors.COSMO_STRONG_GRAY);
		}
	}
}