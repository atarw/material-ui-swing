package mdlaf.shadows;

import mdlaf.utils.MaterialColors;

import javax.swing.border.AbstractBorder;
import java.awt.*;
import java.awt.geom.Area;
import java.awt.geom.RoundRectangle2D;

/**
 * @author https://github.com/vincenzopalazzo
 */
public class RoundedCornerBorder extends AbstractBorder {

    private Color alphaZero;
    private Color colorLine;

    public RoundedCornerBorder() {
        alphaZero = new Color(0x0, true);
        colorLine = MaterialColors.LIGHT_BLUE_400;
    }

    public RoundedCornerBorder(Color colorLine) {
        this.colorLine = colorLine;
        alphaZero = new Color(0x0, true);
    }

    @Override
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        Shape border = getBorderShape(x, y, width - 1, height - 1);
        g2.setPaint(alphaZero);
        Area corner = new Area(new RoundRectangle2D.Double(x, y, width, height, 12, 12));
        corner.subtract(new Area(border));
        g2.fill(corner);
        g2.setPaint(colorLine);
        g2.draw(border);
        g2.dispose();
    }

    public Shape getBorderShape(int x, int y, int w, int h) {
        return new RoundRectangle2D.Double(x, y, w, h, 12, 12);
    }

    @Override
    public Insets getBorderInsets(Component c) {
        return new Insets(1, 6, 1, 6);
    }

    @Override
    public Insets getBorderInsets(Component c, Insets insets) {
        insets.set(3, 8, 3, 8);
        return insets;
    }
}