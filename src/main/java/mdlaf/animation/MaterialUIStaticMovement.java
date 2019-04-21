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
package mdlaf.animation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * This class recreate a effect mouse hover static,
 * This component not implement a wake effect, and is util in all component for click, an example: The button for JSpinner, JCombobox, JScroolbar
 * @author https://github.com/vincenzopalazzo
 */
class MaterialUIStaticMovement implements MouseListener {

    private Color before;
    private Color after;
    private Color strongOnClick;

    public MaterialUIStaticMovement(Color before, Color after, Color strongOnClick) {
        this.before = before;
        this.after = after;
        this.strongOnClick = strongOnClick;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
      // do nothing
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if(e == null){
            throw new IllegalArgumentException("MouseEvent null");
        }
        setColorComponent(e, strongOnClick);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if(e == null){
            throw new IllegalArgumentException("MouseEvent null");
        }
        setColorComponent(e, after);
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if(e == null){
            throw new IllegalArgumentException("MouseEvent null");
        }
        setColorComponent(e, after);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if(e == null){
            throw new IllegalArgumentException("MouseEvent null");
        }
        setColorComponent(e, before);
    }

    /**
     * This is service method for recicle code
     */
    private void setColorComponent(MouseEvent e, Color colorComponent){
        if(e == null || colorComponent == null){
            throw new IllegalArgumentException("The argument function is/are null");
        }
        JComponent component = (JComponent) e.getSource();
        if(component.isEnabled()){
            component.setBackground(colorComponent);
        }
    }
}
