package mdlaf.demo.views;

import mdlaf.animation.MaterialUIMovement;
import mdlaf.utils.MaterialBorders;
import mdlaf.utils.MaterialColors;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * @author https://github.com/vincenzopalazzo
 */
public class MaterialDemoSwingDialogInfo extends JDialog {

    public MaterialDemoSwingDialogInfo(Frame owner, String title, boolean modal) {
        super(owner, title, modal);
    }

    public void init() {
        try {
            initComponent();
        } catch (IOException e) {
            e.printStackTrace();
        }


        setLocationRelativeTo(this.getOwner());
        pack();
        setVisible(true);
    }

    public void initComponent() throws IOException {
        this.setLayout(new GridLayout(1, 2));
        JPanel panelVincet = new JPanel();
        JPanel panelAtarw = new JPanel();

        panelVincet.setLayout(new GridLayout(3, 1));
        panelVincet.setBorder(MaterialBorders.DEFAULT_SHADOW_BORDER);
        panelAtarw.setLayout(new GridLayout(3, 1));
        panelAtarw.setBorder(MaterialBorders.DEFAULT_SHADOW_BORDER);

        BufferedImage imageAtaw = ImageIO.read(getClass().getClassLoader().getResource("iconAtarw.jpeg"));
        BufferedImage imageVinz = ImageIO.read(getClass().getClassLoader().getResource("iconVinz.png"));
        panelVincet.add(new JLabel(new ImageIcon(imageVinz)), 1, 0);
        panelAtarw.add(new JLabel(new ImageIcon(imageAtaw)), 1, 0);
        panelVincet.add(new JLabel("vincenzopalazzo"), 1, 1);
        panelAtarw.add(new JLabel("atarw"), 1, 1);


        JButton profileVincent = new JButton();
        profileVincent.setBackground(MaterialColors.GRAY_700);
        profileVincent.setForeground(MaterialColors.GRAY_100);
        profileVincent.addMouseListener(MaterialUIMovement.getMovement(profileVincent, MaterialColors.GRAY_600));
        JButton profileAtarw = new JButton();
        profileAtarw.setBackground(MaterialColors.GRAY_700);
        profileAtarw.setForeground(MaterialColors.GRAY_100);
        profileAtarw.addMouseListener(MaterialUIMovement.getMovement(profileAtarw, MaterialColors.GRAY_600));

        BufferedImage imageGit = ImageIO.read(getClass().getClassLoader().getResource("githubIcon.png"));
        profileVincent.setIcon(new ImageIcon(imageGit));
        profileAtarw.setIcon(new ImageIcon(imageGit));
        profileVincent.setText("Github");
        profileAtarw.setText("Github");
        panelVincet.add(profileVincent, 1, 2);
        panelAtarw.add(profileAtarw, 1, 2);

        this.add(new JScrollPane(panelAtarw), 0, 0);
        this.add(new JScrollPane(panelVincet), 0, 1);
    }


}
