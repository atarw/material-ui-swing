package integration.gui.mock.component;

import jiconfont.icons.google_material_design_icons.GoogleMaterialDesignIcons;
import mdlaf.MaterialLookAndFeel;
import mdlaf.themes.MaterialTheme;
import mdlaf.utils.MaterialColors;
import mdlaf.utils.MaterialImageFactory;

import javax.swing.*;

public class ToolBarButtonsCodeContainer extends JPanel {

    private JButton runCode;
    private JButton stopCode;
    private JButton consoleCode;
    private MaterialTheme theme;

    public ToolBarButtonsCodeContainer() {
        LookAndFeel lookAndFeel = UIManager.getLookAndFeel();
        if(lookAndFeel instanceof MaterialLookAndFeel){
            theme = ((MaterialLookAndFeel)lookAndFeel).getTheme();
        }
        initView();
    }

    private void initView(){
        initComponent();
        initAction();
    }

    private void initComponent(){
        this.runCode = new JButton(MaterialImageFactory.getInstance().getImage(
                GoogleMaterialDesignIcons.PLAY_ARROW,
                MaterialColors.COSMO_GREEN
        ));
        this.stopCode = new JButton(MaterialImageFactory.getInstance().getImage(
                GoogleMaterialDesignIcons.STOP,
                MaterialColors.COSMO_RED
        ));
        this.consoleCode = new JButton(MaterialImageFactory.getInstance().getImage(
                GoogleMaterialDesignIcons.CODE,
                MaterialColors.ORANGE_500
        ));
        runCode.setFocusable(false);
        stopCode.setFocusable(false);
        consoleCode.setFocusable(false);
        super.add(runCode);
        super.add(stopCode);
        super.add(consoleCode);
    }

    private void initAction(){ }
}
