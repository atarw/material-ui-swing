package mdlaf.components.list;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

/**
 * @author https://github.com/vincenzopalazzo
 */
class MaterialListCellRenderer extends DefaultListCellRenderer {


    @Override
    public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        Component component = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

        JLabel label = (JLabel) component;
        label.setBorder(UIManager.getBorder("List[item].border"));
        return component;
    }
}
