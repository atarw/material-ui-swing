package mdlaf.demo;

import mdlaf.MaterialLookAndFeel;
import mdlaf.demo.actions.ActionsMenuBar;
import mdlaf.utils.MaterialColors;

import javax.swing.*;
import mdlaf.demo.views.MaterialDemoSwingDialogInfo;
import mdlaf.demo.views.MaterialDemoSwingFrame;

/**
 * @author https://github.com/vincenzopalazzo
 */
public class MaterialDemoSwingApp {

    private static final MaterialDemoSwingApp SINGLETON = new MaterialDemoSwingApp();

    public static MaterialDemoSwingApp getIstance() {
        return SINGLETON;
    }

    private MaterialDemoSwingApp() {
    }

    static {
        try {
            UIManager.setLookAndFeel(new MaterialLookAndFeel());
            UIManager.put("Menu.background", MaterialColors.COSMO_BLUE);
            UIManager.put("Menu.foreground", MaterialColors.COSMO_MEDIUM_GRAY);
            UIManager.put("Menu.selectionBackground", MaterialColors.LIGHT_BLUE_500);
            UIManager.put("Menu.selectionForeground",MaterialColors.COSMO_DARK_GRAY);
            UIManager.put("Menu.disabledForeground", MaterialColors.COSMO_LIGTH_BLUE);
            UIManager.put("Menu[MouseOver].enable", true);

            UIManager.put("MenuBar.background", MaterialColors.COSMO_BLUE);
            UIManager.put("MenuBar.foreground", MaterialColors.COSMO_MEDIUM_GRAY);

            UIManager.put("MenuItem.disabledForeground", MaterialColors.COSMO_LIGTH_BLUE);
            UIManager.put("MenuItem.selectionBackground", MaterialColors.LIGHT_BLUE_500);
            UIManager.put("MenuItem.selectionForeground", MaterialColors.COSMO_DARK_GRAY);
            UIManager.put("MenuItem.background", MaterialColors.COSMO_BLUE);
            UIManager.put("MenuItem.foreground", MaterialColors.COSMO_MEDIUM_GRAY);
            
            
            
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
    }

    //Init view component application
    private MaterialDemoSwingFrame frame = new MaterialDemoSwingFrame();
    private MaterialDemoSwingDialogInfo dialogInfo = new MaterialDemoSwingDialogInfo(frame, "Developers", true);

    //Init actions component
    private ActionsMenuBar actionsMenuBar = new ActionsMenuBar();
    
    
    

    public MaterialDemoSwingDialogInfo getDialogInfo() {
        return dialogInfo;
    }

    public MaterialDemoSwingFrame getFrame() {
        return frame;
    }

    public ActionsMenuBar getActionsMenuBar() {
        return actionsMenuBar;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                SINGLETON.frame.init();
            }
        });
    }
}
