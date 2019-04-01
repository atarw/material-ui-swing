package mdlaf.demo;

import mdlaf.MaterialLookAndFeel;
import mdlaf.demo.actions.ActionsMenuBar;
import mdlaf.demo.views.MaterialDemoSwingDialogInfo;
import mdlaf.demo.views.MaterialDemoSwingFrame;

import javax.swing.*;

/**
 * @author https://github.com/vincenzopalazzo
 */
public class MaterialDemoSwingApp {

    private static final MaterialDemoSwingApp SINGLETON = new MaterialDemoSwingApp();

    public static MaterialDemoSwingApp getIstance(){
        return SINGLETON;
    }

    private MaterialDemoSwingApp(){}

    static {
        try {
            UIManager.setLookAndFeel(new MaterialLookAndFeel());
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
    }

    //Init view component application
    private MaterialDemoSwingFrame frame = new MaterialDemoSwingFrame();
    private MaterialDemoSwingDialogInfo dialogInfo = new MaterialDemoSwingDialogInfo(frame, "Developer", true);

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

    public static void main(String[] args){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                SINGLETON.frame.init();
            }
        });
    }
}
