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
package mdlaf.animation;

import mdlaf.components.button.MaterialButtonUI;
import javax.swing.*;
import javax.swing.plaf.ColorUIResource;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

/**
 * This class implement a complex mouse hover event with a timer
 *
 * This event call component.setBackground() inside the timer
 * it should be managed the live cycle more complex
 *
 * @author https://github.com/vincenzopalazzo
 * @author https://github.com/atarw
 */
public class MaterialUITimer implements ActionListener, MaterialMouseHover {

    private Color from;
    private Color to;
    private boolean forward;
    private int alpha;
    private int steps;
    private int[] forwardDeltas;
    private int[] backwardDeltas;
    private JComponent component;
    private Timer timer;
    /**
     * @deprecated This propriety will be remove in the version 1.2, the solution now was resolved to MaterialButtonUI
     * API.
     */
    @Deprecated
    private WrapperInformationsButton wrapperInformationsButton;

    /**
     *  Dont use the !component.isEnabled() how check in the builder if the component
     *  born disabled the mouse hover will never install
     * */
    protected MaterialUITimer(JComponent component, Color to, int steps, int interval) {
        component.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        if (component instanceof JButton) {
            JButton button = (JButton) component;
            if(button.getUI() instanceof MaterialButtonUI){
                MaterialButtonUI materialButtonUI = (MaterialButtonUI) button.getUI();
                if (button.isDefaultButton()) {
                    this.from = UIManager.getColor("Button[Default].background");
                    materialButtonUI.setColorMouseHoverDefaultButton(to);
                } else {
                    this.from = component.getBackground();
                    materialButtonUI.setColorMouseHoverNormalButton(to);
                }
            }
            //wrapperInformationsButton = new WrapperInformationsButton(button);
        } else {
            this.from = component.getBackground();
        }
        this.to = to;

        this.forwardDeltas = new int[4];
        this.backwardDeltas = new int[4];

        forwardDeltas[0] = (from.getRed() - to.getRed()) / steps;
        forwardDeltas[1] = (from.getGreen() - to.getGreen()) / steps;
        forwardDeltas[2] = (from.getBlue() - to.getBlue()) / steps;
        forwardDeltas[3] = (from.getAlpha() - to.getAlpha()) / steps;

        backwardDeltas[0] = (to.getRed() - from.getRed()) / steps;
        backwardDeltas[1] = (to.getGreen() - from.getGreen()) / steps;
        backwardDeltas[2] = (to.getBlue() - from.getBlue()) / steps;
        backwardDeltas[3] = (to.getAlpha() - from.getAlpha()) / steps;

        this.steps = steps;

        this.component = component;
        //this.component.addMouseListener(this);
        timer = new Timer(interval, this);
        component.setBackground(from);
    }

    private Color nextColor() {
        int rValue = from.getRed() - alpha * forwardDeltas[0];
        int gValue = from.getGreen() - alpha * forwardDeltas[1];
        int bValue = from.getBlue() - alpha * forwardDeltas[2];
        int aValue = from.getAlpha() - alpha * forwardDeltas[3];

        return new ColorUIResource(new Color(rValue, gValue, bValue, aValue));
    }

    private Color previousColor() {
        int rValue = to.getRed() - (steps - alpha) * backwardDeltas[0];
        int gValue = to.getGreen() - (steps - alpha) * backwardDeltas[1];
        int bValue = to.getBlue() - (steps - alpha) * backwardDeltas[2];
        int aValue = to.getAlpha() - (steps - alpha) * backwardDeltas[3];

        return new ColorUIResource(new Color(rValue, gValue, bValue, aValue));
    }

    @Override
    public void mousePressed(MouseEvent me) {
       if (!me.getComponent().isEnabled()) {
            return;
        }
        alpha = steps - 1;
        forward = false;
        this.stopTimer();
        //timer.start(); //TODO TEST IT
        alpha = 0;
        forward = true;
        //timer.start();
        //TODO test this in the future but this is the
        //solution when the button return the status pressed because the
        //!!!! This solution fix the bug that when open a modal dialog the button stayed paint pressed !!!!
        // !!!! TEST !!!!
        this.component.setBackground(this.from);
    }

    @Override
    public void mouseExited(MouseEvent me) {
        if (!me.getComponent().isEnabled()) {
            return;
        }
        if (timer.isRunning()) {
            timer.stop();
        }
        alpha = steps - 1;
        forward = false;
        timer.start();
        //this.component.setBackground(this.from);
    }

    @Override
    public void mouseEntered(MouseEvent me) {
        if (!me.getComponent().isEnabled()) {
            return;
        }
        alpha = 0;
        forward = true;
        this.stopTimer();
        timer.start();
    }

    /**
     * This method is mouse hover event core, which contains all logic
     */
    @Override
    public void actionPerformed(ActionEvent ae) {
        if (!component.isEnabled()) {
            //if (timer.isRunning()) {
                /*if ((component instanceof JButton) &&
                        wrapperInformationsButton != null) {
                    System.out.println("component button set color");
                    JButton buttonComponent = (JButton) component;
                    wrapperInformationsButton.setOriginValues(buttonComponent);
                }*/
              //  timer.stop();
            //}
            timer.stop();
            return;
        }
        if (forward) {
            component.setBackground(nextColor());
            ++alpha;
        } else {
            component.setBackground(previousColor());
            --alpha;
        }
        if (alpha == steps + 1 || alpha == -1) {
            this.stopTimer();
            if(alpha == -1){
                this.component.setBackground(this.from);
            }
        }

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        //do nothing this is util only implements interface MouseMotions
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        //do nothing this is util only implements interface MouseMotions
        this.stopTimer();
    }

    @Override
    public void mouseReleased(MouseEvent me) {
        //do nothing
        this.stopTimer();
/*
        if ((component instanceof JButton) &&
                wrapperInformationsButton != null) {
            JButton buttonComponent = (JButton) component;
            wrapperInformationsButton.setOriginValues(buttonComponent);
        }*/
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        //do nothing
        this.stopTimer();
/*
        if ((component instanceof JButton) &&
                wrapperInformationsButton != null) {
            JButton buttonComponent = (JButton) component;
            wrapperInformationsButton.setOriginValues(buttonComponent);
        }*/
    }

    /**
     * Include inside the function the logic to disable the timer
     * with all control on null object.
     *
     * !! DONT USE THIS METHOD IN OTHER PLACE WHEN IS CHECKED THE COMPONENT IS DISABLED
     * !! THIS METHOD IS ONLY TO CHECK IF THE TIMER IS A VALID INSTANCE.
     * !! Fro example: if you insert this method inside the actionPerformed, you will introduce the bug inside
     * button when the button have been disabled after click.
     */
    protected void stopTimer(){
        if (component != null && component.isEnabled()) {
            if (timer != null && timer.isRunning()) {
            /*    if ((component instanceof JButton) &&
                        wrapperInformationsButton != null) {
                    JButton buttonComponent = (JButton) component;
                    wrapperInformationsButton.setOriginValues(buttonComponent);
                }*/
                timer.stop();
            }
        }
    }

    @Override
    public boolean isRunning() {
        if(timer != null){
            return timer.isRunning();
        }
        return false;
    }

    /**
     * @deprecated This propriety will be remove in the version 1.2, the solution now was resolved to MaterialButtonUI
     * API.
     */
    @Deprecated
    private class WrapperInformationsButton {

        private Color background;
        private Color foreground;
        private Color defaultBackground;
        private Color defaultForeground;
        private Color disabledForeground;
        private Color disabledBackground;

        public WrapperInformationsButton(JButton button) {
            if (!(button.getUI() instanceof MaterialButtonUI)) {
                throw new RuntimeException("UI button's not instance of MaterialButtonUI");
            }
            MaterialButtonUI materialButtonUI = (MaterialButtonUI) button.getUI();
            this.background = materialButtonUI.getBackground();
            this.foreground = materialButtonUI.getForeground();
            this.disabledBackground = materialButtonUI.getDisabledBackground();
            this.disabledForeground = materialButtonUI.getDisabledForeground();
            if (materialButtonUI.isDefaultButton()) {
                this.defaultBackground = materialButtonUI.getDefaultBackground();
                this.defaultForeground = materialButtonUI.getDefaultForeground();
            }

        }

        public synchronized void setOriginValues(JButton button) {
            if (button == null || !(button.getUI() instanceof MaterialButtonUI)) {
                String messsage;
                if (button == null) {
                    messsage = "Button component null";
                } else {
                    messsage = "UI button's not instance of MaterialButtonUI";
                }
                throw new RuntimeException(messsage);
            }
            MaterialButtonUI materialButtonUI = (MaterialButtonUI) button.getUI();
            materialButtonUI.setBackground(this.background);
            materialButtonUI.setForeground(this.foreground);
            materialButtonUI.setDisabledBackground(this.disabledBackground);
            materialButtonUI.setDisabledForeground(this.disabledForeground);
            if (materialButtonUI.isDefaultButton()) {
                if (this.defaultBackground == null || this.defaultForeground == null) {
                    throw new RuntimeException("Value defaultBackground or/and defaultForeground is/are null");
                }
                materialButtonUI.setDefaultBackground(this.defaultBackground);
                materialButtonUI.setDefaultForeground(this.defaultForeground);
            }
            button.repaint();
        }
    }
}
