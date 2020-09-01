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

import integration.gui.mock.component.*;
import integration.gui.mock.uiexample.button.ContainedButtonUI;
import io.materialtheme.darkstackoverflow.DarkStackOverflowTheme;
import mdlaf.MaterialLookAndFeel;
import mdlaf.themes.JMarsDarkTheme;
import mdlaf.themes.MaterialLiteTheme;
import mdlaf.themes.MaterialOceanicTheme;
import mdlaf.utils.MaterialColors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.plaf.basic.BasicButtonUI;
import javax.swing.plaf.basic.BasicLookAndFeel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;

/**
 * @author https://github.com/vincenzopalazzo
 */
public class DemoGUITest extends JFrame {

    private static final Logger LOGGER = LoggerFactory.getLogger(DemoGUITest.class);

    static {
        try {
            JDialog.setDefaultLookAndFeelDecorated(true);
            JFrame.setDefaultLookAndFeelDecorated(false); //not support yet
            UIManager.setLookAndFeel(new MaterialLookAndFeel(new MaterialLiteTheme()));

            //UIManager.setLookAndFeel(new MaterialLookAndFeel(new DarkStackOverflowTheme()));
            UIManager.put("Button.mouseHoverEnable", true); //Because the test are more difficulte with effect mouse hover
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
    }

    private static final DemoGUITest SINGLETON = new DemoGUITest();

    private GroupLayout layoutPanelOne;
    private GroupLayout layoutPanelTwo;
    private GroupLayout layoutPanelToggleButton;
    private JTabbedPane tabbedPane = new JTabbedPane();
    private JPanel panelOne = new JPanel();
    private JButton buttonDefault = new JButton("Ok");
    private JButton buttonUndo = new JButton("Disable TextField");
    private JButton buttonDisabled = new JButton("I'm disabled");
    private JButton buttonNormal = new JButton("I'm a pure jbutton");
    private ContainerAction containerAction = new ContainerAction();
    private JTextField textFieldUsername = new JTextField();
    private JPasswordField passwordFiled = new JPasswordField();
    private JMenuBar menuBar = new JMenuBar();
    private JMenuItem menuItemJFileChooser = new JMenuItem("Choose");
    private JMenu menuFile = new JMenu("File");
    private JMenu themesMenu = new JMenu("Themes");
    private JFileChooser fileChooser;
    private JPanel panelTwo = new JPanel();
    private JTable table = new JTable();
    private JMenuItem gtk = new JMenuItem("GTK");
    private JMenuItem metal = new JMenuItem("Metal");
    private JMenuItem material = new JMenuItem(new MaterialLookAndFeel().getName());
    private JMenuItem materialOceanic = new JMenuItem(new MaterialOceanicTheme().getName());
    private JMenuItem jmarsDark = new JMenuItem(new JMarsDarkTheme().getName());
    private JMenuItem darkstackoverflow = new JMenuItem("StackOverflowTheme");
    private JMenuItem styleToggleButton = new JMenuItem("ThemeToggleButton");

    //Panel ToggleButton without icon
    private JPanel panelToggleButton = new JPanel();
    private JToggleButton boldButton = new JToggleButton("B");
    private JToggleButton italicButton = new JToggleButton("I");
    private JToggleButton underlineButton = new JToggleButton("U");

    //Personal Button
    private JPanel personalButtonUIPanel = new JPanel();
    private GroupLayout layoutPanelPersonalButtonUI;
    private JButton personalButton = new JButton("Disable");
    private JButton enableButton = new JButton("Enable");


    private JMenu arrowMenuOne = new JMenu("Root Menu 1");
    private JMenu arrowMenuTwo = new JMenu("Root Menu 2");

    //Split panel bug
    private JSplitPane splitPane = new JSplitPane();

    JLabel labelSplitPane1 = new JLabel("Label one");
    JLabel labelSplitPane2 = new JLabel("Label two");
    JSpinner spinner = new JSpinner(new SpinnerListModel(new String[]{"d", "e", "f"}));
    //Mouse hover bug
    JPanel mouseHoverPanel = new JPanel();
    GroupLayout groupLayoutMouseHoverPanel;
    JButton buttonOneMouseHoverBug = new JButton();
    JButton buttonTwoMouseHoverBug = new JButton();

    //TabbedPane test mouse hover on Tab
    JPanel tabbedPanetest = new DemoPanelWithTabbedPane();

    private JToolBar toolBarEditor;

    private JPanel buttonsPanel;
    private JButton containedTypeButton;


    public JMenuItem getMaterialOceanic() {
        return materialOceanic;
    }

    public void initComponent() {
        tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
        tabbedPane.setTabPlacement(JTabbedPane.RIGHT);
        //tabbedPane.setTabPlacement(JTabbedPane.BOTTOM);
        buttonDefault.setName("buttonDefault");
        buttonUndo.setName("buttonUndo");

        //new Style for write the code
        //following this example of demo https://github.com/paul-hammant/swing_component_testing/blob/master/src/main/java/demo/Demo.java
        buttonUndo.addActionListener(event -> disableTextField());

        buttonDisabled.setName("buttonDisabled");
        buttonDisabled.setBackground(MaterialColors.COSMO_LIGHT_ORANGE);
        buttonDisabled.setAction(containerAction.getEnableButtonDisabled());
        buttonDisabled.setEnabled(true);
        buttonNormal.setName("buttonNormal");

        textFieldUsername.setName("usernameField");
        textFieldUsername.setToolTipText("Test tooltip");
        textFieldUsername.setText("Hello this is an test with AssertJ");
        textFieldUsername.addActionListener(containerAction.getListenerTextField());
        passwordFiled.setName("passwordField");
        passwordFiled.addActionListener(containerAction.getListenerPasswordField());
        passwordFiled.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void removeUpdate(DocumentEvent e) {
                disableOkButtonWithEmptyText();
            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                disableOkButtonWithEmptyText();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                disableOkButtonWithEmptyText();
            }
        });

        initJMenuBar();

        table = new JTable();
        table.setModel(new TableModelSecondPanel(new File(System.getProperty("user.home"))));

        enableButton.setEnabled(false);
        enableButton.setAction(new AbstractAction("Enable") {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton button = (JButton) e.getSource();
                if (button.isEnabled()) {
                    personalButton.setEnabled(true);
                    button.setEnabled(false);
                }
            }
        });
        personalButton.setToolTipText("This button have an personal UI");
        personalButton.setUI(new PersonalButtonUI());
        personalButton.setAction(new AbstractAction("Disable") {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton button = (JButton) e.getSource();

                if (button.isEnabled()) {
                    BasicButtonUI buttonUI = (BasicButtonUI) button.getUI();
                    if (buttonUI instanceof PersonalButtonUI) {
                        Color newColor = JColorChooser.showDialog(personalButtonUIPanel, "New Color", Color.WHITE);
                        button.setEnabled(false);
                        PersonalButtonUI personalButtonUI = (PersonalButtonUI) button.getUI();
                        personalButtonUI.setColorDisableBackground(newColor);
                        enableButton.setEnabled(true);
                    } else {
                        JOptionPane.showMessageDialog(personalButtonUIPanel, "The ButtonUI isn't a PersonalButtonUI instance");
                    }

                }
            }
        });

        this.toolBarEditor = new JToolBar();
        toolBarEditor.setLayout(new BorderLayout());

        ToolBarButtonsCodeContainer containerButtonsCode = new ToolBarButtonsCodeContainer();

        ToolBarCompilerComponent containerCompilerInfo = new ToolBarCompilerComponent();

        toolBarEditor.add(containerButtonsCode, BorderLayout.CENTER);
        toolBarEditor.add(containerCompilerInfo, BorderLayout.EAST);

        JPanel panelToolBar = new JPanel();
        panelToolBar.add(toolBarEditor);

        initStyleMouseHoverPanel();

        initLayoutContentPanelOne();
        initLayoutContentPanelTwo();
        initLayoutContentPanelThree();
        initLayoutContentPanelFour();
        initStyleSplitPanePanels();
        initLayoutMouseHoverPanelFive();
        initLayoutButtonsPanel();

        this.getRootPane().setDefaultButton(buttonDefault);

        tabbedPane.add(panelOne, "Panel One");
        tabbedPane.add(panelTwo, "Table Home Dir");
        tabbedPane.add(panelToggleButton, "ToggleButtons");
        tabbedPane.add(personalButtonUIPanel, "ButtonUI");
        tabbedPane.add(splitPane, "SplitPane");
        tabbedPane.add(mouseHoverPanel, "MouseHover Bug");
        tabbedPane.add(tabbedPanetest, "TabbedPane Test");
        tabbedPane.add(panelToolBar, "ToolBar");
        tabbedPane.add(new ChooseValueComponentViewPanel(), "Choose Component");
        tabbedPane.add(buttonsPanel, "Button Type");
        this.setContentPane(tabbedPane);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(new Dimension(800, 900));
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void initLayoutButtonsPanel() {
        buttonsPanel = new JPanel();
        containedTypeButton = new JButton();
        containedTypeButton.setText("ContainedButton");
        containedTypeButton.setUI(new ContainedButtonUI());

        GroupLayout layout = new GroupLayout(buttonsPanel);
        buttonsPanel.setLayout(layout);

        layout.setHorizontalGroup(
                layout.createParallelGroup()
                        .addGap(50)
                        .addComponent(containedTypeButton)
                        .addGap(25)
        );

        layout.setVerticalGroup(
                layout.createSequentialGroup()
                        .addComponent(containedTypeButton)
                        .addGap(25)
        );
    }

    private void disableOkButtonWithEmptyText() {
        String text = passwordFiled.getText();
        LOGGER.debug("text inside the password component: " + text);
        if (text.isEmpty()) {
            buttonDefault.setEnabled(false);
        } else {
            buttonDefault.setEnabled(true);
        }
    }

    private void disableTextField() {
        if (textFieldUsername.isEnabled()) {
            textFieldUsername.setEnabled(false);
            buttonUndo.setText("Enable TextField");
        } else {
            textFieldUsername.setEnabled(true);
            buttonUndo.setText("Disable TextField");
        }
        if (passwordFiled.isEnabled()) {
            passwordFiled.setEnabled(false);
        } else {
            passwordFiled.setEnabled(true);
        }
    }

    private void changeStateButtonMouseHover(ActionEvent event) {
        JButton button = (JButton) event.getSource();
        if (button.equals(buttonOneMouseHoverBug)) {
            if (button.isEnabled()) {
                button.setText("Disabled");
                button.setEnabled(false);
                buttonTwoMouseHoverBug.setEnabled(true);
                buttonTwoMouseHoverBug.setText("Enabled");
            }
        } else if (button.equals(buttonTwoMouseHoverBug)) {
            if (button.isEnabled()) {
                button.setText("Disabled");
                button.setEnabled(false);
                buttonOneMouseHoverBug.setEnabled(true);
                buttonOneMouseHoverBug.setText("Enabled");
            }
        }
    }

    public void initStyleSplitPanePanels() {
        JPanel panelLeaf = new JPanel();
        panelLeaf.setBorder(BorderFactory.createLineBorder(MaterialColors.AMBER_500));
        panelLeaf.add(labelSplitPane1);
        JPanel panelRight = new JPanel();
        panelRight.setBorder(BorderFactory.createLineBorder(MaterialColors.AMBER_500));
        panelRight.add(labelSplitPane2);
        panelLeaf.add(spinner);

        splitPane.setDividerLocation(200);
        splitPane.setLeftComponent(panelLeaf);
        splitPane.setRightComponent(panelRight);
    }

    public void initStyleMouseHoverPanel() {
        buttonOneMouseHoverBug = new JButton("Enable");
        buttonOneMouseHoverBug.setEnabled(true);
        buttonOneMouseHoverBug.setUI(new PersonalMouseHoverButtonUI());
        buttonTwoMouseHoverBug = new JButton("Disable");
        buttonTwoMouseHoverBug.setEnabled(false);
        buttonTwoMouseHoverBug.setUI(new PersonalMouseHoverButtonUI());
        buttonOneMouseHoverBug.addActionListener(event -> changeStateButtonMouseHover(event));
        buttonTwoMouseHoverBug.addActionListener(event -> changeStateButtonMouseHover(event));
    }

    public void initJMenuBar() {

        menuItemJFileChooser.setName("menuItemJFileChooser");
        menuFile.add(menuItemJFileChooser);
        menuFile.setName("nameFile");

        material.setAction(containerAction.getActionChangeTheme(new MaterialLiteTheme().getName()));
        metal.setAction(containerAction.getActionChangeTheme("Nimbus"));
        gtk.setAction(containerAction.getActionChangeTheme("GTK"));
        materialOceanic.setAction(containerAction.getActionChangeTheme(new MaterialOceanicTheme().getName()));
        jmarsDark.setAction(containerAction.getActionChangeTheme(new JMarsDarkTheme().getName()));
        darkstackoverflow.setAction(containerAction.getActionChangeTheme(new DarkStackOverflowTheme().getName()));
        styleToggleButton.setAction(containerAction.getActionChangeTheme("ThemeToggleButton"));

        themesMenu.add(material);
        themesMenu.add(materialOceanic);
        themesMenu.add(jmarsDark);
        themesMenu.add(darkstackoverflow);
        themesMenu.add(styleToggleButton);
        themesMenu.add(metal);
        themesMenu.add(gtk);

        addSubMenus(arrowMenuOne, 5);
        addSubMenus(arrowMenuTwo, 3);

        menuBar.add(menuFile);
        menuBar.add(themesMenu);
        menuBar.add(arrowMenuOne);
        menuBar.add(arrowMenuTwo);
        menuBar.setName("menuBar");
        this.setJMenuBar(menuBar);

        menuItemJFileChooser.setAction(containerAction.getActionFileChooser());
    }

    public void addSubMenus(JMenu parent, int number) {
        for (int i = 1; i <= number; i++) {
            JMenu menu = new JMenu("Sub Menu " + i);
            parent.add(menu);

            addSubMenus(menu, number - 1);
            addMenuItems(menu, number);
        }
    }

    public void addMenuItems(JMenu parent, int number) {
        for (int i = 1; i <= number; i++) {
            parent.add(new JMenuItem("Item " + i));
        }
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

        //Init position component with group layout
        layoutPanelTwo.setHorizontalGroup(
                layoutPanelTwo.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addComponent(table)
        );

        layoutPanelTwo.setVerticalGroup(
                layoutPanelTwo.createSequentialGroup()
                        .addComponent(table, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }

    public void initLayoutContentPanelThree() {
        layoutPanelToggleButton = new GroupLayout(panelToggleButton);
        panelToggleButton.setLayout(layoutPanelToggleButton);

        layoutPanelToggleButton.setAutoCreateGaps(true);
        layoutPanelToggleButton.setAutoCreateContainerGaps(true);

        //Init position component with group layout
        layoutPanelToggleButton.setHorizontalGroup(
                layoutPanelToggleButton.createSequentialGroup()
                        .addComponent(italicButton)
                        .addGap(0)
                        .addComponent(boldButton)
                        .addGap(0)
                        .addComponent(underlineButton)
                        .addGap(0)
        );

        layoutPanelToggleButton.setVerticalGroup(
                layoutPanelToggleButton.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(italicButton)
                        .addComponent(boldButton)
                        .addComponent(underlineButton)
        );
    }

    public void initLayoutContentPanelFour() {
        layoutPanelPersonalButtonUI = new GroupLayout(personalButtonUIPanel);
        personalButtonUIPanel.setLayout(layoutPanelPersonalButtonUI);

        layoutPanelPersonalButtonUI.setAutoCreateGaps(true);
        layoutPanelPersonalButtonUI.setAutoCreateContainerGaps(true);

        //Init position component with group layout
        layoutPanelPersonalButtonUI.setHorizontalGroup(
                layoutPanelPersonalButtonUI.createSequentialGroup()
                        .addGap(200)
                        .addComponent(personalButton)
                        .addGap(50)
                        .addComponent(enableButton)

        );

        layoutPanelPersonalButtonUI.setVerticalGroup(
                layoutPanelPersonalButtonUI.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(personalButton)
                        .addComponent(enableButton)

        );
    }

    public void initLayoutMouseHoverPanelFive() {
        groupLayoutMouseHoverPanel = new GroupLayout(mouseHoverPanel);
        mouseHoverPanel.setLayout(groupLayoutMouseHoverPanel);

        groupLayoutMouseHoverPanel.setAutoCreateGaps(true);
        groupLayoutMouseHoverPanel.setAutoCreateContainerGaps(true);

        //Init position component with group layout
        groupLayoutMouseHoverPanel.setHorizontalGroup(
                groupLayoutMouseHoverPanel.createSequentialGroup()
                        .addGap(200)
                        .addComponent(buttonOneMouseHoverBug)
                        .addGap(50)
                        .addComponent(buttonTwoMouseHoverBug)

        );

        groupLayoutMouseHoverPanel.setVerticalGroup(
                groupLayoutMouseHoverPanel.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(buttonOneMouseHoverBug)
                        .addComponent(buttonTwoMouseHoverBug)

        );
    }

    public synchronized void reloadUI() {
        SwingUtilities.updateComponentTreeUI(this);
    }

    public synchronized void changeThemeWith(String lookAndFeel) {
        try {
            // UIManager.getLookAndFeel().uninitialize();
            UIManager.setLookAndFeel(lookAndFeel);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public synchronized void changeThemeWith(BasicLookAndFeel lookAndFeel) {
        changeThemeWith(lookAndFeel.getClass().getCanonicalName());
    }

    public void enableTheme(JMenuItem menuItem) {
        menuItem.setEnabled(false);
        if (menuItem != material) {
            material.setEnabled(true);
        } else if (menuItem != gtk) {
            gtk.setEnabled(true);
        } else if (menuItem != metal) {
            metal.setEnabled(true);
        }
    }

    //getter and setter
    public JFileChooser getFileChooser() {
        fileChooser = new JFileChooser();
        fileChooser.setName("fileChooserAction");
        return fileChooser;
    }

    public JMenuItem getMaterial() {
        return material;
    }

    public JMenuItem getGtk() {
        return gtk;
    }

    public JMenuItem getMetal() {
        return metal;
    }

    public JMenuItem getStyleToggleButton() {
        return styleToggleButton;
    }

    public JMenuItem getJmarsDark() {
        return jmarsDark;
    }

    public JMenuItem getDarkStackOverflow() {
        return darkstackoverflow;
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
