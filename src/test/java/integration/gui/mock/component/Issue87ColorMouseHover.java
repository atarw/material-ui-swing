/*
 * MIT License
 *
 * Copyright (c) 2019-2020 Vincenzo Palazzo vincenzopalazzo1996@gmail.com
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package integration.gui.mock.component;

import mdlaf.MaterialLookAndFeel;
import mdlaf.animation.MaterialUIMovement;
import mdlaf.themes.MaterialLiteTheme;
import mdlaf.utils.MaterialColors;

import javax.swing.*;
import javax.swing.plaf.ColorUIResource;

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
