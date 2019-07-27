package integration.gui.mock;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author https://github.com/vincenzopalazzo
 */
public class ContainerAction{

    private Action enableButtonDisabled = new ActionEnableButtonDisabled();
    private ActionListener listenerTextField = new ActionListenerTextField();
    private ActionListener listenerPasswordField = new ActionListenerPasswordField();
    private Action actionFileChooser = new ActionOpenFileChooser();

    public Action getActionFileChooser() {
        return actionFileChooser;
    }

    public Action getEnableButtonDisabled() {
        return enableButtonDisabled;
    }

    public ActionListener getListenerTextField() {
        return listenerTextField;
    }

    public ActionListener getListenerPasswordField() {
        return listenerPasswordField;
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

    private class ActionListenerTextField implements ActionListener{

        private String textOne = "Hello this is an test with AssertJ";
        private String textTwoo = "Hello this is Material-UI-Swing look and feel";

        @Override
        public void actionPerformed(ActionEvent e) {
            JTextField textField = (JTextField) e.getSource();
            String attualText = textField.getText();
            if(attualText.contains(textOne)){
                textField.setText(textTwoo);
            }else {
                textField.setText(textOne);
            }
        }
    }

    private class ActionListenerPasswordField implements ActionListener{

        private String textOne = "The password field not empty";

        @Override
        public void actionPerformed(ActionEvent e) {
            JPasswordField passwField = (JPasswordField) e.getSource();
            String attualText = passwField.getText();
            if(attualText.isEmpty()){
                passwField.setText(textOne);
            }else {
                passwField.setText("");
            }
        }
    }

    private class ActionOpenFileChooser extends AbstractAction{

        public ActionOpenFileChooser() {
            putValue(Action.NAME, "Chooser");
        }

        @Override
        public void actionPerformed(ActionEvent e) {

            int returnVal = DemoGUITest.getInstance().getFileChooser().showSaveDialog(DemoGUITest.getInstance());

        }
    }
}
