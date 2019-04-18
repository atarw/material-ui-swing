package mdlaf.components.internalframe;

import mdlaf.animation.MaterialUIMovement;
import mdlaf.utils.MaterialColors;
import mdlaf.utils.MaterialManagerListener;

import javax.swing.*;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import java.awt.*;

/**
 * @author https://github.com/vincenzopalazzo
 */
public class MaterialInternalFrameTitlePane extends BasicInternalFrameTitlePane {

    public MaterialInternalFrameTitlePane(JInternalFrame f) {
        super(f);
    }

    @Override
    protected void installDefaults() {
        super.installDefaults();
    }

    @Override
    protected void paintBorder(Graphics g) {
        int w = getWidth();
        int h = getHeight();

        Color top = UIManager.getColor("InternalFrameTitlePane.borderColorTop");
        Color left = UIManager.getColor("InternalFrameTitlePane.borderColorLeft");
        Color bottom = UIManager.getColor("InternalFrameTitlePane.borderColorBottom");
        if (frame.isSelected()) {
            top = UIManager.getColor("InternalFrameTitlePane.selected.borderColorTop");
            left = UIManager.getColor("InternalFrameTitlePane.selected.borderColorLeft");
            bottom = UIManager.getColor("InternalFrameTitlePane.selected.borderColorBottom");
        }

        g.setColor(MaterialColors.GRAY_50);
        g.drawLine(2, 0, w, 0);
        g.setColor(left);
        g.drawLine(0, 1, 0, h);
        g.setColor(bottom);
        g.drawLine(2, h, w, h);
    }

    @Override
    protected void createButtons() {
        super.createButtons();

        MaterialManagerListener.removeAllMouseListener(closeButton);
        closeButton.setBorder(null);
        closeButton.setOpaque(false);
        closeButton.addMouseListener(MaterialUIMovement.getMovement(closeButton, MaterialColors.COSMO_LIGHT_RED));

        MaterialManagerListener.removeAllMouseListener(maxButton);
        maxButton.setBorder(null);
        maxButton.setOpaque(false);
        maxButton.addMouseListener(MaterialUIMovement.getMovement(closeButton, MaterialColors.COSMO_LIGTH_BLUE));

        MaterialManagerListener.removeAllMouseListener(iconButton);
        iconButton.setBorder(null);
        iconButton.setOpaque(false);
    }
}
