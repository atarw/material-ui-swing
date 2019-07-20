package integration.gui.mock;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * @author https://github.com/vincenzopalazzo
 */
public class ContainerAction{

    private Action enableButtonDisabled = new ActionEnableButtonDisabled();

    public Action getEnableButtonDisabled() {
        return enableButtonDisabled;
    }

    private class ActionEnableButtonDisabled extends AbstractAction{

        boolean enable = true;

        public ActionEnableButtonDisabled() {
            putValue(Action.NAME, "I'm disabled");
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            JButton buttonDisabled = (JButton) e.getSource();
            if(enable){
                buttonDisabled.setEnabled(false);
                enable = false;
                buttonDisabled.setText("i'm disabled");
            }else {
                buttonDisabled.setEnabled(true);
                buttonDisabled.setText("i'm enabled");
                enable = true;
            }
        }
    }
}
