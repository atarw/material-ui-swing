package mdlaf.components.menu;

import javax.swing.*;
import java.awt.*;

/**
 * @author https://github.com/vincenzopalazzo
 */
public class MaterialMenuArrowIcon implements Icon {
    @Override
    public void paintIcon(Component c, Graphics g, int x, int y) {
        JMenuItem b = (JMenuItem) c;
        ButtonModel model = b.getModel();

        g.translate(x, y);
        if (!model.isEnabled()) {
            g.setColor(UIManager.getColor(""));
        } else {
            if (model.isArmed() || (c instanceof JMenu && model.isSelected())) {
                g.setColor(UIManager.getColor("Menu[arrowIcon].hoverColor"));
            } else {
                g.setColor(UIManager.getColor("Menu[arrowIcon].color"));
            }
        }
        int[] xPoints = {0, 3, 3, 0};
        int[] yPoints = {0, 3, 4, 7};
        g.fillPolygon(xPoints, yPoints, 4);
        g.drawPolygon(xPoints, yPoints, 4);
        g.translate(-x, -y);
    }
    @Override
    public int getIconWidth() {
        return UIManager.getInt("Menu[arrowIcon].width");
    }

    @Override
    public int getIconHeight() {
        return UIManager.getInt("Menu[arrowIcon].height");
    }
}
