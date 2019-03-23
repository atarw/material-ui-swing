package mdlaf.demo.actions;

import mdlaf.demo.MaterialDemoSwingApp;
import mdlaf.demo.views.MaterialDemoSwingDialogInfo;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

/**
 * @author https://github.com/vincenzopalazzo
 */
public class ActionsMenuBar {

    private Action actionExit = new ActionExit();
    private Action actionShowInfo = new ActionShowInfo();

    public Action getActionExit() {
        return actionExit;
    }

    public Action getActionShowInfo() {
        return actionShowInfo;
    }

    /**
     * This action close applications
     * @author https://github.com/vincenzopalazzo
     */
    private class ActionExit extends AbstractAction{

        public ActionExit() {
            putValue(Action.NAME, "Exit");
            putValue(Action.SHORT_DESCRIPTION, "Whit this button exit of the application");
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }

    /**
     * This actions show project informations
     *  @author https://github.com/vincenzopalazzo
     */
    private class  ActionShowInfo extends AbstractAction{

        public ActionShowInfo() {
            putValue(Action.NAME, "Info");
            putValue(Action.SHORT_DESCRIPTION, "Whit this button show info of the project");
            putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl I"));
            putValue(Action.MNEMONIC_KEY, KeyEvent.VK_I);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            MaterialDemoSwingApp.getIstance().getDialogInfo().init();
        }
    }
}
