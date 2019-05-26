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
package mdlaf.utils;

import mdlaf.animation.MaterialUITimer;
import mdlaf.components.tabbedpane.MaterialTabbedPaneUI;

import javax.swing.*;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

/**
 * @author https://github.com/vincenzopalazzo
 */
public class MaterialManagerListener {

    /**
     * Look this if you would change this function
     * https://bugs.java.com/bugdatabase/view_bug.do?bug_id=4380536
     * @Deprecated because this method remove all listener and this is bad
     */
    @Deprecated
    public static void removeAllMouseListener(JButton button){
        if(button == null){
            throw new IllegalArgumentException("Argument is null");
        }
        for(MouseListener mouseListener : button.getListeners(MouseListener.class)){
            button.removeMouseListener(mouseListener);
        }
    }

    /*
     * Look this if you would change this function
     * https://bugs.java.com/bugdatabase/view_bug.do?bug_id=4380536
     */
    public static void removeAllMaterialMouseListener(JComponent component){
        if(component == null){
            throw new IllegalArgumentException("Argument is null");
        }
        for(MouseListener mouseListener : component.getListeners(MouseListener.class)){
            if (mouseListener instanceof MaterialUITimer){
                component.removeMouseListener(mouseListener);
            }
        }
    }
}
