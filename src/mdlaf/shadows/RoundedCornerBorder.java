package mdlaf.shadows;

import mdlaf.utils.MaterialColors;

import javax.swing.*;
import javax.swing.border.AbstractBorder;
import java.awt.*;
import java.awt.geom.Area;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;
import java.util.Objects;

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
/*
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
    }*/
    //TODO this is the bug
    protected static final int ARC = 12;

    @Override
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        int r = ARC;
        int w = width - 1;
        int h = height - 1;

        Area round = new Area(new RoundRectangle2D.Float(x, y, w, h, r, r));
        if (c instanceof JPopupMenu) {
            g2.setPaint(c.getBackground());
            g2.fill(round);
        } else {
            Container parent = c.getParent();
            if (Objects.nonNull(parent)) {
                g2.setPaint(parent.getBackground());
                Area corner = new Area(new Rectangle2D.Float(x, y, width, height));
                corner.subtract(round);
                g2.fill(corner);
            }
        }
        g2.setPaint(c.getForeground());
        g2.draw(round);
        g2.dispose();
    }

    @Override
    public Insets getBorderInsets(Component c) {
        return new Insets(4, 8, 4, 8);
    }

    @Override
    public Insets getBorderInsets(Component c, Insets insets) {
        insets.set(4, 8, 4, 8);
        return insets;
    }

}