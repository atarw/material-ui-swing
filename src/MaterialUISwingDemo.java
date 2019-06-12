import mdlaf.MaterialLookAndFeel;
import mdlaf.animation.MaterialUIMovement;
import mdlaf.utils.MaterialColors;
import mdlaf.utils.MaterialImageFactory;
import mdlaf.utils.MaterialManagerListener;
import org.jdesktop.swingx.JXTaskPane;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class MaterialUISwingDemo {

    private static long beforeUsedMem;

    public MaterialUISwingDemo() {
        beforeUsedMem = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
    }

    public static void main(String[] args) {
        try {
            JDialog.setDefaultLookAndFeelDecorated(true);
            JFrame.setDefaultLookAndFeelDecorated(false);
            UIManager.setLookAndFeel(new MaterialLookAndFeel());
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

        JFrame frame = new JFrame("Material Design UI for Swing by atharva washimkar");
        frame.setMinimumSize(new Dimension(600, 400));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Test for fix the issue https://github.com/vincenzopalazzo/material-ui-swing/projects/1#card-21599924
        //frame.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));

        JMenuBar bar = new JMenuBar();
        JMenu menu1 = new JMenu("Option 1 (Animated)");
        JMenu menu2 = new JMenu("Option 2 (Not animated)");
        class ActionTestJFC extends AbstractAction {

            JComponent component;

            public ActionTestJFC(JComponent component) {
                this.component = component;
                putValue(Action.NAME, "Test JFileChooser (Animated)");
                putValue(Action.SHORT_DESCRIPTION, "Test JFileChooser");
            }

            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.showDialog(component, "Test OK");
            }
        }

        JMenuItem item1 = new JMenuItem("Item 1 (Animated)");
        item1.setAction(new ActionTestJFC(new JPanel()));
        JMenuItem item2 = new JMenuItem("Item 2 (Not animated)");

        //Test RadioButtonMenuItem
        JRadioButtonMenuItem jRadioButtonMenuItem = new JRadioButtonMenuItem();
        jRadioButtonMenuItem.setText("test RadioButtonMenuItem");
        menu1.add(jRadioButtonMenuItem);
        menu1.addSeparator();
        //TestCheckBoxMenuItem
        JCheckBoxMenuItem checkBoxMenuItem = new JCheckBoxMenuItem();
        checkBoxMenuItem.setText("test");
        menu1.add(checkBoxMenuItem);
        menu1.addSeparator();
        menu1.add(item1);
        menu2.add(item2);

        JMenuItem menuItemTestUno = new JMenuItem("Test distance");
        JMenuItem menuItemTestDue = new JMenuItem("Test distance");
        JMenuItem menuItemExit = new JMenuItem("Exit");

        menu1.addSeparator();
        menu1.add(menuItemExit);

        menu2.add(menuItemTestUno);
        menu2.add(checkBoxMenuItem);
        menu2.add(menuItemTestDue);
        menu2.add(jRadioButtonMenuItem);

        bar.add(menu1);
        bar.add(menu2);

        // configuring a simple JButton
        JButton button = new JButton("I'm Disabled");
        button.setEnabled(false);
        JPanel content = new JPanel();
        content.add(button);



        class ActionEnableButton extends AbstractAction{

            private JButton button;

            public ActionEnableButton(JButton button) {
                putValue(Action.NAME, "I can enable");
                this.button = button;
            }

            @Override
            public void actionPerformed(ActionEvent e) {
                if(button.isEnabled()){
                    button.setEnabled(false);
                    button.setText("I'm disable");
                }else{
                    button.setEnabled(true);
                    button.setText("I'm enable");
                }
            }
        }

        JButton abiliteButton = new JButton("I can enable");
        abiliteButton.setAction(new ActionEnableButton(button));
        abiliteButton.setBackground(MaterialColors.COSMO_BLUE);
        abiliteButton.setForeground(MaterialColors.WHITE);
        abiliteButton.addMouseListener(MaterialUIMovement.getMovement(abiliteButton, MaterialColors.COSMO_LIGTH_BLUE));
        content.add(abiliteButton);

        //Test a MaterialTitleBorder
        TitledBorder materialTitleBorder = new TitledBorder("Test Border");
        content.setBorder(materialTitleBorder);

        // add everything to the frame
        frame.add(bar, BorderLayout.PAGE_START);
        // frame.add (content, BorderLayout.CENTER);

        // start animating!
        // here, 'gray' is the color that the JComponent will transition to when the user hovers over it
        MaterialUIMovement.add(menu1, MaterialColors.GRAY_200);
        MaterialUIMovement.add(item1, MaterialColors.GRAY_200);

        // you can also pass in extra parameters indicating how many intermediate colors to display, as well as the "frame rate" of the animation
        // there will be 5 intermediate colors displayed in the transition from the original components color to the new one specified
        // the "frame rate" of the transition will be 1000 / 30, or 30 FPS
        // the animation will take 5 * 1000 / 30 = 166.666... milliseconds to complete
        MaterialUIMovement.add(button, MaterialColors.LIGHT_BLUE_500, 5, 1000 / 30);

        //
        content.add(new JCheckBox("checkbox"));
        content.add(new JComboBox<String>(new String[]{"a", "b", "c"}));
        content.add(new JLabel("label"));
        content.add(new JPasswordField("password"));
        content.add(new JRadioButton("radio button"));
        content.add(new JSlider(JSlider.HORIZONTAL, 0, 5, 2));
        content.add(new JSpinner(new SpinnerListModel(new String[]{"d", "e", "f"})));
        content.add(new JTable(new String[][]{{"a", "b", "c"}, {"d", "e", "f"}}, new String[]{"r", "e"}));
        content.add(new JTextField("text field"));
        content.add(new JToggleButton("toggle"));

        JToolBar tb = new JToolBar("toolbar");
        JButton button1 = new JButton("f");
        class ActionTest extends AbstractAction {

            public ActionTest() {
                putValue(Action.NAME, "f");
                putValue(Action.SHORT_DESCRIPTION, "Test tool tip");
            }

            @Override
            public void actionPerformed(ActionEvent e) {
                JDialog dialog = new JDialog();
                JPanel jPanel = new JPanel();
                jPanel.add(new JColorChooser());
                dialog.setContentPane(jPanel);
                dialog.setLocationRelativeTo(null);
                dialog.setVisible(true);
                dialog.pack();
            }
        }
        button1.setAction(new ActionTest());
        JButton button2 = new JButton("e");
        button1.setBackground(MaterialColors.LIGHT_BLUE_400);
        button1.setForeground(Color.WHITE);
        button2.setBackground(MaterialColors.LIGHT_BLUE_400);
        button2.setForeground(Color.WHITE);

        button1.addMouseListener(MaterialUIMovement.getMovement(button1, MaterialColors.LIGHT_BLUE_300));
        button2.addMouseListener(MaterialUIMovement.getMovement(button2, MaterialColors.LIGHT_BLUE_300));

        tb.add(button1);
        tb.addSeparator();
        tb.add(button2);
        tb.setFloatable(true);
        content.add(tb);

        JTree tree = new JTree(new String[]{"a", "b"});
        tree.setEditable(true);

        content.add(tree);
        JScrollPane sp = new JScrollPane(content);
        sp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        sp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        JPanel pn = new JPanel();
        JPanel panel3 = new JPanel();
        JTabbedPane tp = new JTabbedPane();
        tp.addTab("bleh1", pn);
        tp.addTab("bleh", sp);
        tp.addTab("Panel 3", panel3);

        frame.add(tp, BorderLayout.CENTER);

        //test progressBar
        JProgressBar progressBar = new JProgressBar();
        progressBar.setValue(6);
        progressBar.setMaximum(12);
        pn.add(progressBar);

        //test cange coloro maximum value progress bar
        progressBar = new JProgressBar();
        progressBar.setMaximum(5);
        progressBar.setValue(5);
        pn.add(progressBar);

        JTextPane textPane = new JTextPane();
        textPane.setText("Hi I'm super sayan");
        JTextPane textPane1 = new JTextPane();
        textPane1.setText("Hi I'm super sayan");
        textPane1.setEnabled(false);
        pn.add(textPane);
        pn.add(textPane1);

        JEditorPane editorPane = new JEditorPane();
        editorPane.setText("I added a second character for Arabic support, it is activated according to the locale");
        pn.add(editorPane);

        JButton buttonTwoo = new JButton();
        class ActionToastTest extends AbstractAction {

            JComponent component;

            public ActionToastTest(JComponent component) {
                this.component = component;
                putValue(Action.NAME, "Test Toast");
                putValue(Action.SHORT_DESCRIPTION, "Test Toast");
            }

            @Override
            public void actionPerformed(ActionEvent e) {
               JOptionPane pane = new JOptionPane();
               String message = "The componet toast is removed into project \n " +
                       "Because it carried unnecessary dependencies, but you can find the component here\n" +
                       "https://github.com/vincenzopalazzo/toasts-for-swing";
               pane.showMessageDialog(frame, message, "Info on Toast", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        buttonTwoo.setAction(new ActionToastTest(pn));
        buttonTwoo.setBackground(MaterialColors.PURPLE_600);
        buttonTwoo.setForeground(MaterialColors.GRAY_100);
        buttonTwoo.addMouseListener(MaterialUIMovement.getMovement(buttonTwoo, MaterialColors.PURPLE_300));
        pn.add(buttonTwoo);

        JButton bottoneConImmagine = new JButton();
        bottoneConImmagine.setIcon(new ImageIcon(MaterialImageFactory.getInstance().getImage(MaterialImageFactory.COMPUTER_BLACK)));
        pn.add(bottoneConImmagine);

        JButton buttonTestTextFieled = new JButton("Test JtexFiele");


        class AzioneTestJTexField extends AbstractAction {

            public AzioneTestJTexField() {
                putValue(Action.NAME, "testJtextFieled");
            }

            @Override
            public void actionPerformed(ActionEvent e) {
                JDialog dialog = new JDialog();
                dialog.add(new JComboBox<String>());
                dialog.add(new JSpinner());
                dialog.setSize(new Dimension(50, 50));
                dialog.setLocationRelativeTo(frame);
                dialog.setVisible(true);
            }
        }

        buttonTestTextFieled.setAction(new AzioneTestJTexField());

        pn.add(buttonTestTextFieled);

        JXTaskPane jxTaskPane = new JXTaskPane();
        jxTaskPane.setTitle("Material UI memory");
        jxTaskPane.setOpaque(false);
        JLabel memoryOccupedNow = new JLabel();

        jxTaskPane.add(memoryOccupedNow);

        //Test effect mouse over
        //Setting default
        JButton testButtonHoverOne = new JButton("Fly over me One");
        testButtonHoverOne.setEnabled(false);
        pn.add(testButtonHoverOne);

        //ModSetting
        JButton testButtonHoverTwo = new JButton("Fly over me Two");
        testButtonHoverTwo.setBackground(MaterialColors.LIGHT_BLUE_500);
        testButtonHoverTwo.setForeground(MaterialColors.WHITE);
        testButtonHoverTwo.addMouseListener(MaterialUIMovement.getMovement(testButtonHoverTwo, MaterialColors.LIGHT_BLUE_200));
        pn.add(testButtonHoverTwo);

        pn.add(jxTaskPane);
        // make everything visible to the world

        //Init Jtree in panel 3
        DefaultMutableTreeNode style = new DefaultMutableTreeNode("Style");
        DefaultMutableTreeNode color = new DefaultMutableTreeNode("color");
        DefaultMutableTreeNode font = new DefaultMutableTreeNode("font");
        style.add(color);
        style.add(font);
        DefaultMutableTreeNode red = new DefaultMutableTreeNode("red");
        DefaultMutableTreeNode blue = new DefaultMutableTreeNode("blue");
        DefaultMutableTreeNode black = new DefaultMutableTreeNode("black");
        DefaultMutableTreeNode green = new DefaultMutableTreeNode("green");
        color.add(red);
        color.add(blue);
        color.add(black);
        color.add(green);
        JTree jt = new JTree(style);
        panel3.add(jt);

        JButton buttonInfo = new JButton("Test INFO");
        buttonInfo.setBackground(MaterialColors.COSMO_GREEN);
        buttonInfo.setForeground(MaterialColors.COSMO_LIGTH_GRAY);
        buttonInfo.addMouseListener(MaterialUIMovement.getMovement(buttonInfo, MaterialColors.COSMO_LIGHT_GREEN));
        class InfoMessage extends AbstractAction {

            public InfoMessage() {
                putValue(Action.NAME, "Info option panel");
            }

            @Override
            public void actionPerformed(ActionEvent e) {

                JOptionPane optionPane = new JOptionPane();
                optionPane.showMessageDialog(frame, "This is message info", "Message info", JOptionPane.INFORMATION_MESSAGE);
            }
        }

        buttonInfo.setAction(new InfoMessage());

        panel3.add(buttonInfo);

        JButton buttonError = new JButton();
        buttonError.setBackground(MaterialColors.COSMO_RED);
        buttonError.setForeground(MaterialColors.COSMO_LIGTH_GRAY);
        buttonError.addMouseListener(MaterialUIMovement.getMovement(buttonError, MaterialColors.COSMO_LIGHT_RED));
        class ErrorMassage extends AbstractAction {

            public ErrorMassage() {
                putValue(Action.NAME, "Error option panel");
            }

            @Override
            public void actionPerformed(ActionEvent e) {

                JOptionPane optionPane = new JOptionPane();
                optionPane.showMessageDialog(frame, "This is message error", "Message error", JOptionPane.ERROR_MESSAGE);
            }
        }
        buttonError.setAction(new ErrorMassage());

        panel3.add(buttonError);

        JButton buttonQuestion = new JButton();
        buttonQuestion.setBackground(MaterialColors.COSMO_BLUE);
        buttonQuestion.setForeground(MaterialColors.COSMO_LIGTH_GRAY);
        buttonQuestion.addMouseListener(MaterialUIMovement.getMovement(buttonQuestion, MaterialColors.COSMO_LIGTH_BLUE));
        class QuesuionMessage extends AbstractAction {

            public QuesuionMessage() {
                putValue(Action.NAME, "Info question panel");
            }

            @Override
            public void actionPerformed(ActionEvent e) {

                JOptionPane optionPane = new JOptionPane();
                optionPane.showMessageDialog(frame, "This is message question", "Message question", JOptionPane.QUESTION_MESSAGE);
            }
        }

        buttonQuestion.setAction(new QuesuionMessage());

        frame.getRootPane().setDefaultButton(buttonQuestion);

        JButton buttonWarning = new JButton();
        buttonWarning.setOpaque(false);
        buttonWarning.setForeground(MaterialColors.COSMO_LIGTH_GRAY);
        buttonWarning.setBackground(MaterialColors.COSMO_ORANGE);
        buttonWarning.addMouseListener(MaterialUIMovement.getMovement(buttonWarning, MaterialColors.COSMO_LIGHT_ORANGE));
        class WarningMessage extends AbstractAction {

            public WarningMessage() {
                putValue(Action.NAME, "Info warning panel");
            }

            @Override
            public void actionPerformed(ActionEvent e) {

                JOptionPane optionPane = new JOptionPane();
                optionPane.showMessageDialog(frame, "This is message warning", "Message warning", JOptionPane.WARNING_MESSAGE);
            }

        }

        buttonWarning.setAction(new WarningMessage());

        panel3.add(buttonQuestion);
        panel3.add(buttonWarning);

        JSpinner spinnerDate = new JSpinner(new SpinnerDateModel());

        JSpinner spinnerNumbar = new JSpinner(new SpinnerNumberModel());

        ArrayList<Object> objectList = new ArrayList<>();
        objectList.add(new Object());
        objectList.add(new Object());
        objectList.add(new Object());
        JSpinner spinnerList = new JSpinner(new SpinnerListModel(objectList));

        panel3.add(spinnerDate);
        panel3.add(spinnerNumbar);
        panel3.add(spinnerList);

        JPanel panel4 = new JPanel();

        //String array to store weekdays
        String week[] = {"Monday", "Tuesday", "Wednesday",
                "Thursday", "Friday", "Saturday", "Sunday"};
        JList<String> listDay = new JList<>(week);

        JButton buttonOptionPane = new JButton("Click for open JOptionpane");
        class OpenOptionPane extends AbstractAction {
            public OpenOptionPane() {
                putValue(Action.NAME, "Click me for open JOptionpane");
            }

            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane op = new JOptionPane(null, JOptionPane.PLAIN_MESSAGE, JOptionPane.OK_CANCEL_OPTION);
                JDialog dialog = op.createDialog("Test Button principal");
                //dialog.setUndecorated(true);
                dialog.setVisible(true);
            }
        }
        buttonOptionPane.setAction(new OpenOptionPane());
        panel4.add(buttonOptionPane);
        panel4.add(listDay);

        //Test label disable
        JLabel labelDisable = new JLabel("I'm disabled");
        panel4.add(labelDisable);
        labelDisable.setEnabled(false);

        JButton buttonEnableLabel = new JButton("Enable lable");
        buttonEnableLabel.setBackground(MaterialColors.COSMO_BLACK);
        buttonEnableLabel.setForeground(MaterialColors.COSMO_LIGTH_GRAY);

        MaterialManagerListener.removeAllMaterialMouseListener(buttonEnableLabel);
        buttonEnableLabel.addMouseListener(MaterialUIMovement.getMovement(buttonEnableLabel, MaterialColors.COSMO_DARK_GRAY));

        class ActionEnableLabel extends AbstractAction{

            public ActionEnableLabel() {
                putValue(Action.NAME, "Enable label");
            }

            @Override
            public void actionPerformed(ActionEvent e) {
                if(labelDisable.isEnabled()){
                    labelDisable.setEnabled(false);
                    return;
                }
                labelDisable.setEnabled(true);
            }
        }

        buttonEnableLabel.setAction(new ActionEnableLabel());

        panel4.add(buttonEnableLabel);

        JCheckBox disabledCheckBox = new JCheckBox("I'm Disabled");
        disabledCheckBox.setEnabled(false);
        panel4.add(disabledCheckBox);

        JRadioButton radioDisabled = new JRadioButton("radio disabled");
        radioDisabled.setEnabled(false);
        panel4.add(radioDisabled);

        tp.addTab("Panel 4", panel4);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);

        long lastUsedMem = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        double megamemori = (lastUsedMem - beforeUsedMem) * 9.537 * Math.pow(10, -7);
        memoryOccupedNow.setText("Memory occuped after update: " + megamemori + " MB");

        //For testing
        //SwingUtilities.updateComponentTreeUI(frame);
    }
}
