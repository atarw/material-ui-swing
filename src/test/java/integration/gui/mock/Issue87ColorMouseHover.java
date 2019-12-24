package integration.gui.mock;

import mdlaf.MaterialLookAndFeel;
import mdlaf.animation.MaterialUIMovement;
import mdlaf.themes.MaterialLiteTheme;
import mdlaf.utils.MaterialColors;

import javax.swing.*;
import javax.swing.plaf.ColorUIResource;

/**
 * @author https://github.com/vincenzopalazzo
 */
public class Issue87ColorMouseHover extends JDialog {

        /**
         * Creates new form NewJDialog
         */
        public Issue87ColorMouseHover(java.awt.Frame parent, boolean modal) {
            super(parent, modal);
            initComponents();
        }

        private void initComponents() {


            setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
            this.getContentPane().setBackground(new ColorUIResource(45, 48, 56));
            JButton jButton1 = new javax.swing.JButton();
            jButton1.setBorder(BorderFactory.createLineBorder(new ColorUIResource(45, 48, 56)));
            jButton1.setBackground(new ColorUIResource(45, 48, 56));
            jButton1.setForeground(MaterialColors.COSMO_LIGTH_GRAY);
            jButton1.addMouseListener(MaterialUIMovement.getMovement(jButton1, new ColorUIResource(23, 137, 134)));
            jButton1.setText("Test Button");
            jButton1.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jButton1ActionPerformed(evt);
                }
            });

            javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
            getContentPane().setLayout(layout);
            layout.setHorizontalGroup(
                    layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                    .addGap(166, 166, 166)
                                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addContainerGap(136, Short.MAX_VALUE))
            );
            layout.setVerticalGroup(
                    layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                    .addGap(191, 191, 191)
                                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addContainerGap(184, Short.MAX_VALUE))
            );

            pack();
        }

        private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
            // TODO add your handling code here:
        }

        /**
         * @param args the command line arguments
         */
        public static void main(String args[]) {
            try {
                MaterialLookAndFeel material = new MaterialLookAndFeel(new MaterialLiteTheme());
                UIManager.setLookAndFeel(material);
            } catch (Exception ex) {
                java.util.logging.Logger.getLogger(Issue87ColorMouseHover.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }

            /* Create and display the dialog */
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    Issue87ColorMouseHover dialog = new Issue87ColorMouseHover(new javax.swing.JFrame(), true);
                    dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                        @Override
                        public void windowClosing(java.awt.event.WindowEvent e) {
                            System.exit(0);
                        }
                    });
                    dialog.setVisible(true);
                }
            });
        }
}
