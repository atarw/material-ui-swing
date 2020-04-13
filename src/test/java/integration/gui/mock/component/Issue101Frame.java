package integration.gui.mock.component;


import mdlaf.themes.JMarsDarkTheme;
import mdlaf.utils.MaterialColors;

import javax.swing.*;

public class Issue101Frame extends JFrame {

    private static final long serialVersionUID = 1L;

    static {
        try {

            UIManager.setLookAndFeel(new mdlaf.MaterialLookAndFeel(new JMarsDarkTheme()));
            //UIManager.setLookAndFeel(new MetalLookAndFeel());
            //UIManager.setLookAndFeel(new NimbusLookAndFeel());
            UIManager.put("Button.mouseHoverEnable", false); // Because the test are more difficulte with effect mouse
            JDialog.setDefaultLookAndFeelDecorated(true);
            JFrame.setDefaultLookAndFeelDecorated(false); // not support yet

        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
    }

    public static void main(String args[]) {
        Issue101Frame frame = new Issue101Frame();

        JPanel p = new JPanel(null);
        p.setBounds(50, 50, 200, 200);
        p.setBorder(BorderFactory.createLineBorder(MaterialColors.COSMO_GREEN));

        JLabel l = new JLabel("Some text", SwingConstants.CENTER);
        p.add(l, null);
        l.setBounds(0, 50, 200, 21);
        frame.setTitle("Label issue example");
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        frame.getContentPane().add(p, null);
        frame.setBounds(0, 0, 300, 300);
        frame.setVisible(true);
    }
}
