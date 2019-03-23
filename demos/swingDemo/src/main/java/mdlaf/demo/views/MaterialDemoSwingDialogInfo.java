package mdlaf.demo.views;

import javax.swing.*;
import java.awt.*;

/**
 * @author https://github.com/vincenzopalazzo
 */
public class MaterialDemoSwingDialogInfo extends JDialog {

    public MaterialDemoSwingDialogInfo(Frame owner, String title, boolean modal) {
        super(owner, title, modal);
    }

    public void init(){
        initComponent();

        setLocationRelativeTo(this.getOwner());
        pack();
        setVisible(true);
    }

    public void initComponent(){
        JTabbedPane tabbedPane = new JTabbedPane();
        this.add(tabbedPane);
    }
}
