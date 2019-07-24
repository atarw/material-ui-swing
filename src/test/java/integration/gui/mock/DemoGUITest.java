package integration.gui.mock;

import mdlaf.MaterialLookAndFeel;
import mdlaf.utils.MaterialColors;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

/**
 * @author https://github.com/vincenzopalazzo
 */
public class DemoGUITest extends JFrame {

    static {
        try {
            UIManager.setLookAndFeel(new MaterialLookAndFeel());
            UIManager.put("Button.mouseHoverEnable", false); //Because the test are more difficulte with effect mouse hover
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
    }

    private GroupLayout layout;
    private JTabbedPane tabbedPane = new JTabbedPane();
    private JPanel panelOne = new JPanel();
    private JButton buttonDefault = new JButton("Ok");
    private JButton buttonUndo = new JButton("Undo");
    private JButton buttonDisabled = new JButton("I'm disabled");
    private JButton buttonNormal = new JButton("I'm a pure jbutton");
    private ContainerAction containerAction = new ContainerAction();
    private JTextField textFieldUsername = new JTextField();
    private JPasswordField passwordFiled = new JPasswordField();

    public void initComponent(){
        buttonDefault.setName("buttonDefault");
        buttonUndo.setName("buttonUndo");
        buttonUndo.setAction(containerAction.getEnableButtonDisabled());
        buttonDisabled.setName("buttonDisabled");
        buttonDisabled.setBackground(MaterialColors.COSMO_LIGHT_ORANGE);
        buttonDisabled.setAction(containerAction.getEnableButtonDisabled());
        buttonDisabled.setEnabled(true);
        buttonNormal.setName("buttonNormal");

        textFieldUsername.setName("usernameField");
        textFieldUsername.setText("Hello this is an test with AssertJ");
        textFieldUsername.addActionListener(containerAction.getListenerTextField());
        passwordFiled.setName("passwordField");
        passwordFiled.addActionListener(containerAction.getListenerPasswordField());

        initLayoutContentPanel();

        this.getRootPane().setDefaultButton(buttonDefault);

        tabbedPane.add(panelOne , "Panel One");
        this.setContentPane(tabbedPane);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void initLayoutContentPanel(){
        layout = new GroupLayout(panelOne);
        panelOne.setLayout(layout);

        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        //Init position component with group layaut
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addComponent(textFieldUsername)
                        .addComponent(passwordFiled)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(50)
                                .addComponent(buttonDefault, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(50)
                                .addComponent(buttonDisabled, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(50)
                                .addComponent(buttonNormal, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(50)
                                .addComponent(buttonUndo, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        )
        );

        layout.setVerticalGroup(
                layout.createSequentialGroup()
                        .addComponent(textFieldUsername, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(20)
                        .addComponent(passwordFiled, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(20)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(buttonDefault)
                                .addComponent(buttonDisabled)
                                .addComponent(buttonNormal)
                                .addComponent(buttonUndo)
                        )
        );
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                DemoGUITest demoGUITest = new DemoGUITest();
                demoGUITest.initComponent();
            }
        });
    }


}
