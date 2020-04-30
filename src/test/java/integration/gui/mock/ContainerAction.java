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
package integration.gui.mock;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

import integration.gui.mock.component.PersonalToggleButtonTheme;
import mdlaf.MaterialLookAndFeel;
import mdlaf.themes.JMarsDarkTheme;
import mdlaf.themes.MaterialLiteTheme;
import mdlaf.themes.MaterialOceanicTheme;

/**
 * @author https://github.com/vincenzopalazzo
 */
public class ContainerAction {

    private Action enableButtonDisabled = new ActionEnableButtonDisabled();
    private ActionListener listenerTextField = new ActionListenerTextField();
    private ActionListener listenerPasswordField = new ActionListenerPasswordField();
    private Action actionFileChooser = new ActionOpenFileChooser();
    private Action actionChangeTheme;

    public Action getActionChangeTheme(String name) {
        return new ActionChangeTheme(name);
    }

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

    private class ActionEnableButtonDisabled extends AbstractAction {

        boolean enable = true;

        public ActionEnableButtonDisabled() {
            putValue(Action.NAME, "I'm disabled");
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            JButton buttonDisabled = (JButton) e.getSource();
            if (enable) {
                buttonDisabled.setEnabled(false);
                enable = false;
                buttonDisabled.setText("i'm disabled");
            } else {
                buttonDisabled.setEnabled(true);
                buttonDisabled.setText("i'm enabled");
                enable = true;
            }
        }
    }

    private class ActionListenerTextField implements ActionListener {

        private String textOne = "Hello this is an test with AssertJ";
        private String textTwoo = "Hello this is Material-UI-Swing look and feel";

        @Override
        public void actionPerformed(ActionEvent e) {
            JTextField textField = (JTextField) e.getSource();
            String attualText = textField.getText();
            if (attualText.contains(textOne)) {
                textField.setText(textTwoo);
            } else {
                textField.setText(textOne);
            }
        }
    }

    private class ActionListenerPasswordField implements ActionListener {

        private String textOne = "The password field not empty";

        @Override
        public void actionPerformed(ActionEvent e) {
            JPasswordField passwField = (JPasswordField) e.getSource();
            String actualText = passwField.getText();
            if (actualText.isEmpty()) {
                passwField.setText(textOne);
            } else {
                passwField.setText("");
            }
        }
    }

    private class ActionOpenFileChooser extends AbstractAction {

        public ActionOpenFileChooser() {
            putValue(Action.NAME, "Chooser");
        }

        @Override
        public void actionPerformed(ActionEvent e) {

            int returnVal = DemoGUITest.getInstance().getFileChooser().showSaveDialog(DemoGUITest.getInstance());

        }
    }

    private class ActionChangeTheme extends AbstractAction {

        public ActionChangeTheme(String nameTheme) {
            super(nameTheme);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                if(e.getSource() == DemoGUITest.getInstance().getMaterial()){
                    if (UIManager.getLookAndFeel() instanceof MaterialLookAndFeel){
                        MaterialLookAndFeel.changeTheme(new MaterialLiteTheme());
                    }else{
                        DemoGUITest.getInstance().changeThemeWith(new MaterialLookAndFeel());
                    }
                }else if(e.getSource() == DemoGUITest.getInstance().getMetal()){
                    DemoGUITest.getInstance().changeThemeWith(new NimbusLookAndFeel());
                }else if(e.getSource() == DemoGUITest.getInstance().getGtk()){
                    DemoGUITest.getInstance().changeThemeWith(UIManager.getCrossPlatformLookAndFeelClassName());
                }else if(e.getSource() == DemoGUITest.getInstance().getMaterialDark()){
                    if (UIManager.getLookAndFeel() instanceof MaterialLookAndFeel){
                        MaterialLookAndFeel.changeTheme(new MaterialOceanicTheme());
                    }else{
                        DemoGUITest.getInstance().changeThemeWith(new MaterialLookAndFeel(new MaterialOceanicTheme()));
                    }
                }else if(e.getSource() == DemoGUITest.getInstance().getJmarsDark()){
                    if (UIManager.getLookAndFeel() instanceof MaterialLookAndFeel){
                        MaterialLookAndFeel.changeTheme(new JMarsDarkTheme());
                    }else{
                        DemoGUITest.getInstance().changeThemeWith(new MaterialLookAndFeel(new JMarsDarkTheme()));
                    }
                }else if(e.getSource() == DemoGUITest.getInstance().getStyleToggleButton()){
                    if (UIManager.getLookAndFeel() instanceof MaterialLookAndFeel){
                        MaterialLookAndFeel.changeTheme(new PersonalToggleButtonTheme());
                    }else{
                        DemoGUITest.getInstance().changeThemeWith(new MaterialLookAndFeel(new PersonalToggleButtonTheme()));
                    }
                }
                DemoGUITest.getInstance().reloadUI();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}
