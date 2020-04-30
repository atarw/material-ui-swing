package integration.gui.mock.component;

import com.jhlabs.image.LightFilter;
import mdlaf.animation.MaterialUIMovement;
import mdlaf.utils.MaterialColors;

import javax.swing.*;
import java.awt.*;

/**
 * @author https://github.com/vincenzopalazzo
 */

public class DemoPanelWithTabbedPane extends JPanel {

    protected JTabbedPane tabbedPane;
    protected JButton deprecatedButton;
    protected JButton actualButton;
    protected JLabel informationLabel;
    protected JButton openTabbedPane;

    public DemoPanelWithTabbedPane() {
        this.initView();
    }

    public void initView(){
        initComponent();
        initAction();

        setVisible(true);
    }

    public void initComponent(){
        deprecatedButton = new JButton("Deprecrate hide");
        this.setDimensionButton(deprecatedButton);

        actualButton = new JButton("Correct Hide");
        this.setDimensionButton(actualButton);

        informationLabel = new JLabel("This component is developer to test\nthe move hover on the Tabbed pane");

        tabbedPane = new JTabbedPane();
        JPanel panelDeprecated = new JPanel(new BorderLayout());
        panelDeprecated.add(deprecatedButton, BorderLayout.CENTER);
        JPanel panelCurrent = new JPanel(new BorderLayout());
        panelCurrent.add(actualButton, BorderLayout.CENTER);
        tabbedPane.addTab("Deprecated Hide", panelDeprecated);
        tabbedPane.addTab("Current", panelCurrent);
        tabbedPane.addTab("Ex Disable", new JPanel());
        tabbedPane.setEnabledAt(2, false);

        openTabbedPane = new JButton("Open TabbedPane");
        this.setDimensionButton(openTabbedPane);

        super.setLayout(new BorderLayout());

        super.add(informationLabel, BorderLayout.CENTER);
        super.add(openTabbedPane, BorderLayout.SOUTH);
    }

    public void initAction(){
        openTabbedPane.addActionListener(event -> this.openDialog());
        actualButton.addActionListener(event -> this.hideTabbedPane(false));
        deprecatedButton.addActionListener(event -> this.hideTabbedPane(true));
    }

    public void hideTabbedPane(boolean deprecatedFuntion){
        if(deprecatedFuntion){
            tabbedPane.hide();
        }else{
            tabbedPane.setVisible(false);
        }
    }

    private void openDialog() {
        this.tabbedPane.setVisible(true);
        JDialog dialog = new JDialog();
        dialog.setContentPane(tabbedPane);
        dialog.setSize(new Dimension(1000, 300));
        dialog.setLocationRelativeTo(this);
        dialog.setVisible(true);

        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
    }

    private void setDimensionButton(JButton button){
        button.setSize(new Dimension(20, 5));
        button.setMinimumSize(new Dimension(20, 5));
        button.setMaximumSize(new Dimension(20, 5));
        button.setBackground(MaterialColors.PINK_500);
        button.addMouseListener(MaterialUIMovement.getMovement(button, MaterialColors.PINK_300));
        button.setForeground(MaterialColors.COSMO_LIGTH_GRAY);
    }
}
