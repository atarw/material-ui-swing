package mdlaf.components.filechooser;

import mdlaf.utils.MaterialDrawingUtils;
import mdlaf.utils.MaterialImages;

import javax.swing.*;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.metal.MetalFileChooserUI;
import java.awt.Graphics;

public class MaterialFileChooserUI extends MetalFileChooserUI {

	public MaterialFileChooserUI (JFileChooser fileChooser) {
		super (fileChooser);
	}

	public static ComponentUI createUI (JComponent c) {
		return new MaterialFileChooserUI ((JFileChooser) c);
	}

	@Override
	public void installUI (JComponent c) {
		super.installUI (c);
		JFileChooser fileChooser = (JFileChooser) c;
		MaterialFileChooserUI ui = (MaterialFileChooserUI) fileChooser.getUI ();

		ui.uninstallIcons (fileChooser);
		ui.uninstallComponents (fileChooser);
		ui.clearIconCache ();

		ui.computerIcon = UIManager.getIcon("FileChooser[icons].computer");
		ui.directoryIcon = UIManager.getIcon("FileChooser[icons].directory");
		ui.fileIcon = UIManager.getIcon("FileChooser[icons].file");
		ui.floppyDriveIcon = UIManager.getIcon("FileChooser[icons].floppyDrive");
		ui.hardDriveIcon = UIManager.getIcon("FileChooser[icons].hardDrive");

		ui.homeFolderIcon = UIManager.getIcon("FileChooser[icons].home");
		ui.listViewIcon = UIManager.getIcon("FileChooser[icons].list");
		ui.detailsViewIcon = UIManager.getIcon("FileChooser[icons].details");
		ui.newFolderIcon = UIManager.getIcon("FileChooser[icons].newFolder");
		ui.upFolderIcon = UIManager.getIcon("FileChooser[icons].upFolder");

		ui.openButtonText = "OPEN";
		ui.cancelButtonText = "CANCEL";
		ui.helpButtonText = "HELP";
		ui.saveButtonText = "SAVE";
		ui.directoryOpenButtonText = "OPEN";
		ui.updateButtonText = "UPDATE";

		ui.installComponents (fileChooser);
	}

	@Override
	public void paint (Graphics g, JComponent c) {
		super.paint (MaterialDrawingUtils.getAliasedGraphics (g), c);
	}
}
