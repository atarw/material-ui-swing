package mdlaf.components.titleborder;

import mdlaf.shadows.DropShadowBorder;
import mdlaf.utils.MaterialColors;
import mdlaf.utils.MaterialFonts;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import java.awt.*;

/**
 * @author https://github.com/vincenzopalazzo
 */
public class MaterialTitleBorder implements Border{

    private TitledBorder titledBorder;

    public MaterialTitleBorder(String title){
        titledBorder = new TitledBorder(title);
        setBorder();
        setFont();
    }

    public MaterialTitleBorder(Border border){
        titledBorder = new TitledBorder(border);
        setFont();
    }

    private void setBorder() {
        Border border = BorderFactory.createTitledBorder(new DropShadowBorder(MaterialColors.BLACK, 3, 3, (float)0.5, 5, true, true, true, true));
        titledBorder.setBorder(border);
    }

    private void setFont(){
        titledBorder.setTitleFont(MaterialFonts.BOLD);
    }

    public void setTitle​(String title){
        titledBorder.setTitle(title);
    }

    public void setTitleColor​(Color titleColor){
        titledBorder.setTitleColor(titleColor);
    }

    public void setTitleFont​(Font titleFont){
        titledBorder.setTitleFont(titleFont);
    }

    public void setTitleJustification​(int titleJustification){
        titledBorder.setTitleJustification(titleJustification);
    }

    public void setTitlePosition​(int titlePosition){
        titledBorder.setTitlePosition(titlePosition);
    }

    public TitledBorder getTitledBorder() {
        return titledBorder;
    }

    @Override
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        titledBorder.paintBorder(c, g, x, y, width, height);
    }

    @Override
    public Insets getBorderInsets(Component c) {
        return titledBorder.getBorderInsets(c);
    }

    @Override
    public boolean isBorderOpaque() {
        return titledBorder.isBorderOpaque();
    }
}
