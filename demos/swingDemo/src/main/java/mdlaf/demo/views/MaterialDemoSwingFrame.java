/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mdlaf.demo.views;

import javax.swing.BorderFactory;
import mdlaf.demo.MaterialDemoSwingApp;
import mdlaf.utils.MaterialBorders;
import mdlaf.utils.MaterialColors;

/**
 *
 * @author Vincenzo Palazzo
 */
public class MaterialDemoSwingFrame extends javax.swing.JFrame {

    public void init(){
        initComponents();
        initActions();
        
        initStyle();
        
        setLocationRelativeTo(null);
        pack();
        setVisible(true);
    }
    
    public void initActions(){
        menuItemDevelopers.setAction(MaterialDemoSwingApp.getIstance().getActionsMenuBar().getActionShowInfo());
        menuItemExit.setAction(MaterialDemoSwingApp.getIstance().getActionsMenuBar().getActionExit());
    }
    

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menuBarMaterial = new javax.swing.JMenuBar();
        menuFile = new javax.swing.JMenu();
        menuItemExit = new javax.swing.JMenuItem();
        menuInfo = new javax.swing.JMenu();
        menuItemDevelopers = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        menuFile.setText("FILE");

        menuItemExit.setText("jMenuItem1");
        menuFile.add(menuItemExit);

        menuBarMaterial.add(menuFile);

        menuInfo.setText("INFO");

        menuItemDevelopers.setText("jMenuItem1");
        menuInfo.add(menuItemDevelopers);

        menuBarMaterial.add(menuInfo);

        setJMenuBar(menuBarMaterial);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 822, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 414, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar menuBarMaterial;
    private javax.swing.JMenu menuFile;
    private javax.swing.JMenu menuInfo;
    private javax.swing.JMenuItem menuItemDevelopers;
    private javax.swing.JMenuItem menuItemExit;
    // End of variables declaration//GEN-END:variables

    private void initStyle() {
       //Init style menu bar
       menuBarMaterial.setBackground(MaterialColors.COSMO_BLUE);
       menuBarMaterial.setForeground(MaterialColors.COSMO_MEDIUM_GRAY);
       menuBarMaterial.setBorder(BorderFactory.createEmptyBorder());
       
       //init style menu
       menuFile.setBackground(menuBarMaterial.getBackground());
       menuFile.setForeground(menuBarMaterial.getForeground());
       
       menuInfo.setBackground(menuBarMaterial.getBackground());
       menuInfo.setForeground(menuBarMaterial.getForeground());
       
     
    }
    
    
}
