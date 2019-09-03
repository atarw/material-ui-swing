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

    protected  int arch = 12; //default value
    protected Color colorLine;
    protected float withBorder = 1.2f;

    public RoundedCornerBorder() {
        colorLine = MaterialColors.LIGHT_BLUE_400;
    }

    public RoundedCornerBorder(Color colorLine) {
        this.colorLine = colorLine;
        //alphaZero = new Color(0x0, true);
    }

    public RoundedCornerBorder(Color colorLine, int arch) {
        this.colorLine = colorLine;
        this.arch = arch;
    }

    public RoundedCornerBorder(int arch, Color colorLine, float withBorder) {
        this.arch = arch;
        this.colorLine = colorLine;
        this.withBorder = withBorder;
    }

    @Override
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setStroke(new BasicStroke(withBorder));
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        int r = arch;
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
        g2.setPaint(colorLine);
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