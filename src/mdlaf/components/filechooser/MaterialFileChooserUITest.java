package mdlaf.components.filechooser;

import mdlaf.utils.MaterialDrawingUtils;
import mdlaf.utils.MaterialImages;

import javax.swing.*;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicFileChooserUI;
import java.awt.*;

/**
 * @author https://github.com/vincenzopalazzo
 */
public class MaterialFileChooserUITest extends BasicFileChooserUI {

    public MaterialFileChooserUITest(JFileChooser b) {
        super(b);
    }

    public static ComponentUI createUI (JComponent c) {
        return new MaterialFileChooserUI ((JFileChooser) c);
    }

    @Override
    public void installUI(JComponent c) {
        super.installUI(c);
        JFileChooser fileChooser = (JFileChooser) c;
        MaterialFileChooserUITest ui = (MaterialFileChooserUITest) fileChooser.getUI ();

        ui.uninstallIcons (fileChooser);
        ui.uninstallComponents (fileChooser);
        ui.clearIconCache ();

        ui.computerIcon = new ImageIcon (MaterialImages.COMPUTER);
        ui.directoryIcon = new ImageIcon (MaterialImages.FOLDER);
        ui.fileIcon = new ImageIcon (MaterialImages.FILE);
        ui.floppyDriveIcon = new ImageIcon (MaterialImages.FLOPPY_DRIVE);
        ui.hardDriveIcon = new ImageIcon (MaterialImages.HARD_DRIVE);

        ui.homeFolderIcon = new ImageIcon (MaterialImages.HOME);
        ui.listViewIcon = new ImageIcon (MaterialImages.LIST);
        ui.detailsViewIcon = new ImageIcon (MaterialImages.DETAILS);
        ui.newFolderIcon = new ImageIcon (MaterialImages.NEW_FOLDER);
        ui.upFolderIcon = new ImageIcon (MaterialImages.BACK_ARROW);

        ui.openButtonText = "OPEN";
        ui.cancelButtonText = "CANCEL";
        ui.helpButtonText = "HELP";
        ui.saveButtonText = "SAVE";
        ui.directoryOpenButtonText = "OPEN";
        ui.updateButtonText = "UPDATE";

        ui.installComponents (fileChooser);
    }

    @Override
    public void paint(Graphics g, JComponent c) {
        super.paint(MaterialDrawingUtils.getAliasedGraphics(g), c);
    }


}
