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
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
    }

    private JTabbedPane tabbedPane = new JTabbedPane();
    private JPanel panelOne = new JPanel();
    private JButton buttonDefoult = new JButton("Ok");
    private JButton buttonUndo = new JButton("Undo");
    private JButton buttonDisabled = new JButton("I'm disabled");
    private JButton buttonNormal = new JButton("I'm a pure jbutton");
    private ContainerAction containerAction = new ContainerAction();

    public void initComponent(){
        buttonDefoult.setName("buttonDefoult");
        buttonUndo.setName("buttonUndo");
        buttonUndo.setAction(containerAction.getEnableButtonDisabled());
        buttonDisabled.setName("buttonDisabled");
        buttonDisabled.setBackground(MaterialColors.COSMO_LIGHT_ORANGE);
        buttonDisabled.setAction(containerAction.getEnableButtonDisabled());
        buttonDisabled.setEnabled(true);
        buttonNormal.setName("buttonNormal");

        panelOne.add(buttonUndo);
        panelOne.add(buttonDefoult);
        panelOne.add(buttonDisabled);
        panelOne.add(buttonNormal);

        this.getRootPane().setDefaultButton(buttonDefoult);

        tabbedPane.add(panelOne , "Panel One");
        this.setContentPane(tabbedPane);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
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
