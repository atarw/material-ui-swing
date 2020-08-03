package integration.gui.mock.component;

import javax.swing.*;

public class ChooseValueComponentViewPanel extends JPanel {

    String[] framework = { "Flutter", "React", "Angular", "Swing" };
    String[] alternative = { "JavaFX", "Vue v3"};
    private JComboBox comboBoxEnabled;
    private JComboBox comboBoxDisabled;
    private JCheckBox checkBoxEnabled;
    private JCheckBox checkBoxDisabled;
    private JRadioButton radioButtonEnabled;
    private JRadioButton radioButtonDisabled;
    private JToggleButton toggleButtonEnable;
    private JToggleButton toggleButtonDisabled;

    public ChooseValueComponentViewPanel() {
        intiView();
    }

    private void intiView() {
        initComponent();
        initLayout();
        initAction();
    }

    private void initComponent() {
        comboBoxEnabled = new JComboBox(framework);
        comboBoxDisabled = new JComboBox(alternative);
        comboBoxDisabled.setEnabled(false);

        checkBoxEnabled = new JCheckBox("Is Morning");
        checkBoxDisabled = new JCheckBox("Is Night");
        checkBoxDisabled.setEnabled(false);

        radioButtonEnabled = new JRadioButton("Is Morning");
        radioButtonDisabled = new JRadioButton("Is Night");
        radioButtonDisabled.setEnabled(false);

        toggleButtonEnable = new JToggleButton("Is Morning");
        toggleButtonDisabled = new JToggleButton("Is Night");
        toggleButtonDisabled.setEnabled(false);
    }

    private void initLayout(){
        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);

        layout.setVerticalGroup(
                layout.createSequentialGroup()
                        .addComponent(comboBoxEnabled, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(10)
                        .addComponent(comboBoxDisabled, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(10)
                        .addComponent(checkBoxEnabled, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(10)
                        .addComponent(checkBoxDisabled, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(10)
                        .addComponent(radioButtonEnabled, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(10)
                        .addComponent(radioButtonDisabled, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(10)
                        .addComponent(toggleButtonEnable, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(10)
                        .addComponent(toggleButtonDisabled, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
        );

        layout.setHorizontalGroup(
                layout.createParallelGroup()
                        .addComponent(comboBoxEnabled, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(10)
                        .addComponent(comboBoxDisabled, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(10)
                        .addComponent(checkBoxEnabled, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(10)
                        .addComponent(checkBoxDisabled, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(10)
                        .addComponent(radioButtonEnabled, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(10)
                        .addComponent(radioButtonDisabled, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(10)
                        .addComponent(toggleButtonEnable, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(10)
                        .addComponent(toggleButtonDisabled, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
        );
    }

    private void initAction() {

    }
}
