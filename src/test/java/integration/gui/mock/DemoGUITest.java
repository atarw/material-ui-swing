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

import mdlaf.MaterialLookAndFeel;
import mdlaf.utils.MaterialColors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import javax.swing.plaf.basic.BasicButtonUI;
import javax.swing.plaf.basic.BasicLookAndFeel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Map;

/**
 * @author https://github.com/vincenzopalazzo
 */
public class DemoGUITest extends JFrame {

    private static final Logger LOGGER = LoggerFactory.getLogger(DemoGUITest.class);

    static {
        try {
            UIManager.setLookAndFeel(new MaterialLookAndFeel(new PersonalToggleButtonTheme()));
            UIManager.put("Button.mouseHoverEnable", false); //Because the test are more difficulte with effect mouse hover
            JDialog.setDefaultLookAndFeelDecorated(true);
            JFrame.setDefaultLookAndFeelDecorated(false); //not support yet
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
    private JButtonNoMouseHoverNative buttonDefault = new JButtonNoMouseHoverNative("Ok");
    private JButton buttonUndo = new JButton("Undo");
    private JButton buttonDisabled = new JButton("I'm disabled");
    private JButtonNoMouseHoverNative buttonNormal = new JButtonNoMouseHoverNative("I'm a pure jbutton");
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
    private JMenuItem material = new JMenuItem("Material");
    private JMenuItem materialDark = new JMenuItem("Material Oceanic");
    private JMenuItem jmarsDark = new JMenuItem("Jmars Dark");
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


    public JMenuItem getMaterialDark() {
        return materialDark;
    }

    public void initComponent() {

        tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
        tabbedPane.setTabPlacement(JTabbedPane.RIGHT);

        for (Map.Entry<Object, Object> entry : UIManager.getDefaults().entrySet()) {
            Object key = entry.getKey();
            if (key instanceof String) {
                String keyString = (String) key;
                if (keyString.contains("TabbedPane")) {
                    LOGGER.debug("Key: " + keyString + " value: " + entry.getValue());
                }
            }
        }
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

        enableButton.setEnabled(false);
        enableButton.setAction(new AbstractAction("Enable") {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton button = (JButton) e.getSource();
                if(button.isEnabled()){
                    personalButton.setEnabled(true);
                    button.setEnabled(false);
                }
            }
        });

        personalButton.setUI(new PersonalButtonUI());
        personalButton.setAction(new AbstractAction("Disable") {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton button = (JButton) e.getSource();

                if(button.isEnabled()){
                    BasicButtonUI buttonUI = (BasicButtonUI) button.getUI();
                    if(buttonUI instanceof PersonalButtonUI){
                        Color newColor = JColorChooser.showDialog(personalButtonUIPanel, "New Color", Color.WHITE);
                        button.setEnabled(false);
                        PersonalButtonUI personalButtonUI = (PersonalButtonUI) button.getUI();
                        personalButtonUI.setColorDisableBackground(newColor);
                        enableButton.setEnabled(true);
                    }else{
                        JOptionPane.showMessageDialog(personalButtonUIPanel, "The ButtonUI isn't a PersonalButtonUI instance");
                    }

                }
            }
        });


        initLayoutContentPanelOne();
        initLayoutContentPanelTwo();
        initLayoutContentPanelThree();
        initLayoutContentPanelFour();


        this.getRootPane().setDefaultButton(buttonDefault);

        tabbedPane.add(panelOne, "Panel One");
        tabbedPane.add(panelTwo, "Panel two");
        tabbedPane.add(panelToggleButton, "ToggleButtons");
        tabbedPane.add(personalButtonUIPanel, "ButtonUI");
        tabbedPane.add(new JPanel(), "Panel 5");
        tabbedPane.add(new JPanel(), "Panel 6");
        tabbedPane.add(new JPanel(), "Panel 7");
        tabbedPane.add(new JPanel(), "Panel 8");
        tabbedPane.add(new JPanel(), "Panel 9");
        this.setContentPane(tabbedPane);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void initJMenuBar() {

        menuItemJFileChooser.setName("menuItemJFileChooser");
        menuFile.add(menuItemJFileChooser);
        menuFile.setName("nameFile");

        material.setAction(containerAction.getActionChangeTheme("Material lite"));
        metal.setAction(containerAction.getActionChangeTheme("Nimbus"));
        gtk.setAction(containerAction.getActionChangeTheme("GTK"));
        materialDark.setAction(containerAction.getActionChangeTheme("Material Oceanic"));
        jmarsDark.setAction(containerAction.getActionChangeTheme("JMars Dark"));
        styleToggleButton.setAction(containerAction.getActionChangeTheme("ThemeToggleButton"));

        themesMenu.add(material);
        themesMenu.add(metal);
        themesMenu.add(materialDark);
        themesMenu.add(jmarsDark);
        themesMenu.add(gtk);
        themesMenu.add(styleToggleButton);

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


    public synchronized void reloadUI() {
        SwingUtilities.updateComponentTreeUI(this);
    }

    public synchronized void changeThemeWith(BasicLookAndFeel lookAndFeel) {
        try {
            // UIManager.getLookAndFeel().uninitialize();
            UIManager.setLookAndFeel(lookAndFeel);
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
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
