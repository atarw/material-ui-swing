package mdlaf.utils;

import javax.swing.*;
import java.awt.event.MouseListener;

/**
 * @author https://github.com/vincenzopalazzo
 */
public class MaterialManagerListener {

    /**
     * Look this if you would change this function
     * https://bugs.java.com/bugdatabase/view_bug.do?bug_id=4380536
     */
    public static void removeAllMouseListener(JButton button){
        if(button == null){
            throw new IllegalArgumentException("Argument is null");
        }
        for(MouseListener mouseListener : button.getListeners(MouseListener.class)){
            button.removeMouseListener(mouseListener);
        }
    }
}
