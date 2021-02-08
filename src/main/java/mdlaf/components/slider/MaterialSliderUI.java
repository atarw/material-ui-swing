/**
 * MIT License
 * <p>
 * Copyright (c) 2018-2020 atharva washimkar, Vincenzo Palazzo vincenzopalazzo1996@gmail.com
 * Copyright (c) 2021 Vincenzo Palazzo vincenzopalazzodev@gmail.com
 * <p>
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * <p>
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 * <p>
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package mdlaf.components.slider;

import mdlaf.utils.MaterialDrawingUtils;

import javax.swing.JComponent;
import javax.swing.JSlider;
import javax.swing.UIManager;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicSliderUI;
import java.awt.*;

/**
 * @author https://github.com/vincenzopalazzo
 * @author https://github.com/atarw
 */
public class MaterialSliderUI extends BasicSliderUI {

    private static final int NORMAL_THUMB_RADIUS = 7;
    private static final int DRAG_THUMB_RADIUS = 14;
    private static final Dimension THUMB_SIZE = new Dimension(DRAG_THUMB_RADIUS * 2, DRAG_THUMB_RADIUS * 2);

    public MaterialSliderUI(JSlider slider) {
        super(slider);
    }

    public static ComponentUI createUI(JComponent c) {
        return new MaterialSliderUI((JSlider) c);
    }

    @Override
    public void installUI(JComponent c) {
        super.installUI(c);
        c.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }

    @Override
    public void uninstallUI(JComponent c) {
        super.uninstallUI(c);
    }

    @Override
    public Dimension getThumbSize() {
        return THUMB_SIZE;
    }

    @Override
    public void paintThumb(Graphics g) {
        g = MaterialDrawingUtils.getAliasedGraphics(g);

        int cx = thumbRect.x + thumbRect.width / 2;
        int cy = thumbRect.y + thumbRect.height / 2;

        if (isDragging()) {
            g.setColor(UIManager.getColor("Slider[halo].color"));
            drawCircle(g, cx, cy, DRAG_THUMB_RADIUS);
        }
        if (slider.isEnabled()) {
            g.setColor(slider.getForeground());
        } else {
            g.setColor(UIManager.getColor("Slider.disable"));
        }
        drawCircle(g, cx, cy, NORMAL_THUMB_RADIUS);

        // need to redraw loaded part of progress line
        Line loaded = getTrack(true);
        g.drawLine(loaded.x1, loaded.y1, loaded.x2, loaded.y2);
    }

    @Override
    public void paintTrack(Graphics g) {
        g = MaterialDrawingUtils.getAliasedGraphics(g);

        g.setColor(UIManager.getColor("Slider.trackColor"));
        g.setColor(UIManager.getColor("Slider.disableTrackColor"));
        Line unloaded = getTrack(false);
        g.drawLine(unloaded.x1, unloaded.y1, unloaded.x2, unloaded.y2);

        if (slider.isEnabled()) {
            g.setColor(slider.getForeground());
        } else {
            g.setColor(UIManager.getColor("Slider.disable"));
        }
        Line loaded = getTrack(true);
        g.drawLine(loaded.x1, loaded.y1, loaded.x2, loaded.y2);
    }

    private Line getTrack(boolean loaded) {
        if (slider.getOrientation() == JSlider.HORIZONTAL) {
            Line left = new Line(trackRect.x, thumbRect.y + thumbRect.height / 2, thumbRect.x + thumbRect.width / 2, thumbRect.y + thumbRect.height / 2);
            Line right = new Line(thumbRect.x + thumbRect.width / 2, thumbRect.y + thumbRect.height / 2, trackRect.x + trackRect.width, thumbRect.y + thumbRect.height / 2);
            if (loaded) {
                return slider.getInverted() ? right : left;
            } else {
                return slider.getInverted() ? left : right;
            }
        } else {
            Line top = new Line(thumbRect.x + thumbRect.width / 2, trackRect.y, thumbRect.x + thumbRect.width / 2, thumbRect.y + thumbRect.height / 2);
            Line bottom = new Line(thumbRect.x + thumbRect.width / 2, thumbRect.y + thumbRect.height / 2, thumbRect.x + thumbRect.width / 2, trackRect.y + trackRect.height);

            if (loaded) {
                return slider.getInverted() ? top : bottom;
            } else {
                return slider.getInverted() ? bottom : top;
            }
        }
    }

    @Override
    public void paintFocus(Graphics g) { }

    @Override
    public void paint(Graphics g, JComponent c) {
        super.paint(MaterialDrawingUtils.getAliasedGraphics(g), c);
    }

    protected void drawCircle(Graphics g, int x, int y, int radius) {
        g = MaterialDrawingUtils.getAliasedGraphics(g);
        g.fillOval(x - radius, y - radius, radius * 2, radius * 2);
    }

    private static class Line {

        int x1, y1, x2, y2;

        Line(int x1, int y1, int x2, int y2) {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
        }
    }
}
