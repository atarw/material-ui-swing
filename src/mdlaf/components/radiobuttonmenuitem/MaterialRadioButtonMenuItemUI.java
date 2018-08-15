package mdlaf.components.radiobuttonmenuitem;

import mdlaf.resources.MaterialBorders;
import mdlaf.resources.MaterialColors;
import mdlaf.resources.MaterialDrawingUtils;
import mdlaf.resources.MaterialImages;

import javax.swing.*;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicRadioButtonMenuItemUI;
import java.awt.*;

/**
 * 
 * @author https://github.com/vincenzopalazzo
 *
 */

public class MaterialRadioButtonMenuItemUI extends BasicRadioButtonMenuItemUI {

    public static ComponentUI createUI(JComponent c){
        return new MaterialRadioButtonMenuItemUI();
    }

    @Override
    public void installUI(JComponent c) {
        super.installUI(c);
        JRadioButtonMenuItem j = (JRadioButtonMenuItem) c;
        j.setBackground(MaterialColors.WHITE);
        j.setBorder(UIManager.getBorder ("MenuItem.border"));
    }

    @Override
    public void paint(Graphics g, JComponent c) {
        super.paint(MaterialDrawingUtils.getAliasedGraphics(g), c);
    }

    @Override
    protected void paintMenuItem(Graphics g, JComponent c, Icon checkIcon, Icon arrowIcon, Color background, Color foreground, int defaultTextIconGap) {
        JRadioButtonMenuItem j = (JRadioButtonMenuItem) c;
        if(j.isSelected()){
            super.paintMenuItem(MaterialDrawingUtils.getAliasedGraphics(g), c, new ImageIcon(MaterialImages.RADIO_BUTTON_ON), arrowIcon,  background, foreground, defaultTextIconGap);
            return;
        }
        super.paintMenuItem(MaterialDrawingUtils.getAliasedGraphics(g), c, new ImageIcon(MaterialImages.RADIO_BUTTON_OFF), arrowIcon,  background, foreground, defaultTextIconGap);
    }
}
