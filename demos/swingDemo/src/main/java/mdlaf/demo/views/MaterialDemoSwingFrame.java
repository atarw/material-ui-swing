package mdlaf.demo.views;

import mdlaf.animation.MaterialUIMovement;
import mdlaf.demo.MaterialDemoSwingApp;

import javax.swing.*;

/**
 * @author https://github.com/vincenzopalazzo
 */
public class MaterialDemoSwingFrame extends JFrame {

    private JMenuItem jMenuItemExit;
    private JMenuItem jMenuItemInfo;

    public void init(){
        initComponent();
        initActionsFrame();
        setLocationRelativeTo(null);
        pack();
        setVisible(true);
    }

    private void initComponent(){
        JMenuBar menuBar = new JMenuBar();
        this.add(menuBar);

        JMenu jMenuFile = new JMenu("File");
        JMenu jMenuInfo= new JMenu("INFO");
        jMenuItemExit = new JMenuItem();
        jMenuItemInfo = new JMenuItem();

        jMenuFile.add(jMenuItemExit);
        jMenuInfo.add(jMenuItemInfo);

        menuBar.add(jMenuFile);
        menuBar.add(jMenuInfo);
    }

    private void initActionsFrame(){
        jMenuItemExit.setAction(MaterialDemoSwingApp.getIstance().getActionsMenuBar().getActionExit());
        jMenuItemInfo.setAction(MaterialDemoSwingApp.getIstance().getActionsMenuBar().getActionShowInfo());
    }


}
