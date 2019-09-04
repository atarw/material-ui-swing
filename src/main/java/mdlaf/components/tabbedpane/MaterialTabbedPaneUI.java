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

import mdlaf.utils.MaterialDrawingUtils;

import javax.swing.*;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicTabbedPaneUI;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

/**
 * @contributor https://github.com/vincenzopalazzo
 */
public class MaterialTabbedPaneUI extends BasicTabbedPaneUI {

	public static ComponentUI createUI(JComponent c) {
		return new MaterialTabbedPaneUI();
	}

	protected JTabbedPane component;
	protected Color selectedForeground;
	protected Color foreground;
	protected int positionYLine;
	protected int positionXLine;
	protected int widthLine;
	protected int heightLine;
	protected int arcLine;

	@Override
	public void installUI(JComponent c) {
		super.installUI(c);

		JTabbedPane tabbedPane = (JTabbedPane) c;
		tabbedPane.setOpaque(false);
		tabbedPane.setFont(UIManager.getFont("TabbedPane.font"));
		tabbedPane.setBackground(UIManager.getColor("TabbedPane.background"));
		this.foreground = (UIManager.getColor("TabbedPane.foreground"));
		tabbedPane.setForeground(foreground);
		this.selectedForeground = UIManager.getColor("TabbedPane.selectionForeground");
		tabbedPane.setBorder(UIManager.getBorder("TabbedPane.border"));
		darkShadow = UIManager.getColor("TabbedPane.darkShadow");
		shadow = UIManager.getColor("TabbedPane.shadow");
		lightHighlight = UIManager.getColor("TabbedPane.highlight");
		this.positionYLine = UIManager.getInt("TabbedPane.linePositionY");
		this.positionXLine = UIManager.getInt("TabbedPane.linePositionX");
		this.widthLine = UIManager.getInt("TabbedPane.lineWidth");
		this.heightLine = UIManager.getInt("TabbedPane.lineHeight");
		this.arcLine = UIManager.getInt("TabbedPane.lineArch");
		component = tabbedPane;
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

	@Override
	public void paint(Graphics g, JComponent c) {
		super.paint(MaterialDrawingUtils.getAliasedGraphics(g), c);
	}

	@Override
	protected void paintTabBackground(Graphics g, int tabPlacement, int tabIndex, int x, int y, int w, int h, boolean isSelected) {
		g.setColor(isSelected ? lightHighlight : tabPane.getBackground());
		g.fillRect(x, y, w, h);
		if (isSelected) {
			paintLine(g, x, y, w, h);
			this.tabPane.setForegroundAt(tabIndex, selectedForeground);
		} else {
			this.tabPane.setForegroundAt(tabIndex, foreground);
		}
	}

	@Override
	protected void paintTabBorder(Graphics g, int tabPlacement, int tabIndex, int x, int y, int w, int h, boolean isSelected) {
		//do nothing
	}

	@Override
	protected void paintFocusIndicator(Graphics g, int tabPlacement, Rectangle[] rects, int tabIndex, Rectangle iconRect, Rectangle textRect, boolean isSelected) {
		//do nothing
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
	protected void paintTabArea(Graphics g, int tabPlacement, int selectedIndex) {
		super.paintTabArea(MaterialDrawingUtils.getAliasedGraphics(g), tabPlacement, selectedIndex);
	}

	@Override
	protected void paintText(Graphics g, int tabPlacement, Font font, FontMetrics metrics, int tabIndex, String title, Rectangle textRect, boolean isSelected) {
		super.paintText(g, tabPlacement, font, metrics, tabIndex, title, textRect, isSelected);
		if (isSelected) {
			//paintLine(g, textRect.x - 10, textRect.y, textRect.width + 18, textRect.height);
		}
	}

	@Override
	protected LayoutManager createLayoutManager() {
		return new MaterialTabbedPaneLayout();
	}

	protected void paintLine(Graphics graphics, int x, int y, int w, int h) {
		if (graphics == null) {
			return;
		}
		graphics.setColor(UIManager.getColor("TabbedPane[focus].colorLine"));
		graphics.fillRoundRect(x + positionXLine, y + positionYLine, w - widthLine, heightLine, arcLine, arcLine);
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

}