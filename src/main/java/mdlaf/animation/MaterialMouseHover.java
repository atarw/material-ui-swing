package mdlaf.animation;

import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

/**
 * Tag interface, all material-ui-swing mouse hover should be implement this interface
 *
 * @author https://github.com/vincenzopalazzo
 */
public interface MaterialMouseHover extends MouseListener, MouseMotionListener {

    boolean isRunning();
}
