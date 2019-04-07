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
        /*For effect click, need create a timer ?*/
      /* if(e == null){
            throw new IllegalArgumentException("MouseEvent null");
        }
        setColorComponent(e, after);*/
    }

    @Override
    public void mousePressed(MouseEvent e) {
        /*For effect click, need create a timer ?*/
        if(e == null){
            throw new IllegalArgumentException("MouseEvent null");
        }
        setColorComponent(e, strongOnClick);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        /*For effect click, need create a timer ?*/
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

    /***
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
