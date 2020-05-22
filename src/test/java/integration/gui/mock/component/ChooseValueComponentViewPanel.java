package integration.gui.mock.component;

import javax.swing.*;

public class ChooseValueComponentViewPanel extends JPanel {

    String[] framework = { "Flutter", "React", "Angular", "Swing" };
    String[] alternative = { "JavaFX", "Vue v3"};
    private JComboBox enabled;
    private JComboBox disabled;

    public ChooseValueComponentViewPanel() {
        intiView();
    }

    private void intiView() {
        initComponent();
        initLayout();
        initAction();
    }

    private void initComponent() {
        enabled = new JComboBox(framework);
        disabled = new JComboBox(alternative);
        disabled.setEnabled(false);
    }

    private void initLayout(){
        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);

        layout.setVerticalGroup(
                layout.createSequentialGroup()
                        .addComponent(enabled, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(10)
                        .addComponent(disabled, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
        );

        layout.setHorizontalGroup(
                layout.createParallelGroup()
                        .addComponent(enabled, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(10)
                        .addComponent(disabled, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
        );
    }

    private void initAction() {

    }
}
