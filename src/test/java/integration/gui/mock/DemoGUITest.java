package integration.gui.mock;

import mdlaf.MaterialLookAndFeel;
import mdlaf.utils.MaterialColors;

import javax.swing.*;

/**
 * @author https://github.com/vincenzopalazzo
 */
public class DemoGUITest extends JFrame {

    static {
        try {
            UIManager.setLookAndFeel(new MaterialLookAndFeel());
            UIManager.put("Button.mouseHoverEnable", false); //Because the test are more difficulte with effect mouse hover
            JDialog.setDefaultLookAndFeelDecorated(true);
            JFrame.setDefaultLookAndFeelDecorated(true); //not support yet
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
    }

    private static final DemoGUITest SINGLETON = new DemoGUITest();

    private GroupLayout layoutPanelOne;
    private GroupLayout layoutPanelTwo;
    private JTabbedPane tabbedPane = new JTabbedPane();
    private JPanel panelOne = new JPanel();
    private JButton buttonDefault = new JButton("Ok");
    private JButton buttonUndo = new JButton("Undo");
    private JButton buttonDisabled = new JButton("I'm disabled");
    private JButton buttonNormal = new JButton("I'm a pure jbutton");
    private ContainerAction containerAction = new ContainerAction();
    private JTextField textFieldUsername = new JTextField();
    private JPasswordField passwordFiled = new JPasswordField();
    private JMenuBar menuBar = new JMenuBar();
    private JMenuItem menuItemJFileChooser = new JMenuItem("Choose");
    private JMenu menuFile = new JMenu("File");
    private JFileChooser fileChooser = new JFileChooser();
    private JPanel panelTwo = new JPanel();
    private JTable table = new JTable();

    public void initComponent() {
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

        initJMenuBar();

        table.setModel(new TableModelSecondPanel());

        initLayoutContentPanelOne();
        initLayoutContentPanelTwo();

        this.getRootPane().setDefaultButton(buttonDefault);

        tabbedPane.add(panelOne, "Panel One");
        tabbedPane.add(panelTwo, "Panel two");
        this.setContentPane(tabbedPane);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void initJMenuBar() {

        menuItemJFileChooser.setName("menuItemJFileChooser");
        menuFile.add(menuItemJFileChooser);
        menuFile.setName("nameFile");
        menuBar.add(menuFile);
        menuBar.setName("menuBar");
        this.setJMenuBar(menuBar);

        menuItemJFileChooser.setAction(containerAction.getActionFileChooser());
    }

    public void initLayoutContentPanelOne() {
        layoutPanelOne = new GroupLayout(panelOne);
        panelOne.setLayout(layoutPanelOne);

        layoutPanelOne.setAutoCreateGaps(true);
        layoutPanelOne.setAutoCreateContainerGaps(true);

        //Init position component with group layaut
        layoutPanelOne.setHorizontalGroup(
                layoutPanelOne.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addComponent(textFieldUsername)
                        .addComponent(passwordFiled)
                        .addGroup(layoutPanelOne.createSequentialGroup()
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

        layoutPanelOne.setVerticalGroup(
                layoutPanelOne.createSequentialGroup()
                        .addComponent(textFieldUsername, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(20)
                        .addComponent(passwordFiled, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(20)
                        .addGroup(layoutPanelOne.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(buttonDefault)
                                .addComponent(buttonDisabled)
                                .addComponent(buttonNormal)
                                .addComponent(buttonUndo)
                        )
        );
    }

    public void initLayoutContentPanelTwo() {
        layoutPanelTwo = new GroupLayout(panelTwo);
        panelTwo.setLayout(layoutPanelTwo);

        layoutPanelTwo.setAutoCreateGaps(true);
        layoutPanelTwo.setAutoCreateContainerGaps(true);

        //Init position component with group layaut
        layoutPanelTwo.setHorizontalGroup(
                layoutPanelTwo.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addComponent(table)
        );

        layoutPanelTwo.setVerticalGroup(
                layoutPanelTwo.createSequentialGroup()
                        .addComponent(table, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }

    //getter and setter
    public JFileChooser getFileChooser() {
        fileChooser.setName("fileChooserAction");
        return fileChooser;
    }

    public static DemoGUITest getInstance() {
        return SINGLETON;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                SINGLETON.initComponent();
            }
        });
    }


}
