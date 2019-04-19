package mdlaf.components.filechooser;

import mdlaf.utils.MaterialDrawingUtils;
import mdlaf.utils.MaterialImageFactory;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicFileChooserUI;
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

		ui.computerIcon = new ImageIcon (MaterialImageFactory.getInstance().getImage(MaterialImageFactory.COMPUTER));
		ui.directoryIcon = new ImageIcon (MaterialImageFactory.getInstance().getImage(MaterialImageFactory.FOLDER));
		ui.fileIcon = new ImageIcon (MaterialImageFactory.getInstance().getImage(MaterialImageFactory.FILE));
		ui.floppyDriveIcon = new ImageIcon (MaterialImageFactory.getInstance().getImage(MaterialImageFactory.FLOPPY_DRIVE));
		ui.hardDriveIcon = new ImageIcon (MaterialImageFactory.getInstance().getImage(MaterialImageFactory.HARD_DRIVE));

		ui.homeFolderIcon = new ImageIcon (MaterialImageFactory.getInstance().getImage(MaterialImageFactory.HOME));
		ui.listViewIcon = new ImageIcon (MaterialImageFactory.getInstance().getImage(MaterialImageFactory.LIST));
		ui.detailsViewIcon = new ImageIcon (MaterialImageFactory.getInstance().getImage(MaterialImageFactory.DETAILS));
		ui.newFolderIcon = new ImageIcon (MaterialImageFactory.getInstance().getImage(MaterialImageFactory.NEW_FOLDER));
		ui.upFolderIcon = new ImageIcon (MaterialImageFactory.getInstance().getImage(MaterialImageFactory.BACK_ARROW));

		ui.openButtonText = "OPEN";
		ui.cancelButtonText = "CANCEL";
		ui.helpButtonText = "HELP";
		ui.saveButtonText = "SAVE";
		ui.directoryOpenButtonText = "OPEN";
		ui.updateButtonText = "UPDATE";


		ui.installComponents(fileChooser);
	}

	@Override
	public void paint (Graphics g, JComponent c) {
		super.paint (MaterialDrawingUtils.getAliasedGraphics (g), c);
	}
}
