/*
 * MIT License
 *
 * Copyright (c) 2018-2019 atharva washimkar,
 * Copyright (c) 2019 Vincent Palazzo vincenzopalazzodev@gmail.com
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
package mdlaf.components.filechooser;

import mdlaf.utils.MaterialDrawingUtils;

import javax.swing.*;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.metal.MetalFileChooserUI;
import java.awt.*;
import java.io.File;

/**
 * @author https://github.com/vincenzopalazzo
 * @author https://github.com/atarw
 */
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
		//MaterialFileChooserUI ui = (MaterialFileChooserUI) fileChooser.getUI ();
		//all this before were ui.uninstallIcon
		this.uninstallIcons (fileChooser);
		this.uninstallComponents (fileChooser);
		this.clearIconCache ();
		this.computerIcon = UIManager.getIcon("FileChooser[icons].computer");
		this.directoryIcon = UIManager.getIcon("FileChooser[icons].directory");
		this.fileIcon = UIManager.getIcon("FileChooser[icons].file");
		this.floppyDriveIcon = UIManager.getIcon("FileChooser[icons].floppyDrive");
		this.hardDriveIcon = UIManager.getIcon("FileChooser[icons].hardDrive");

		this.homeFolderIcon = UIManager.getIcon("FileChooser[icons].home");
		this.listViewIcon = UIManager.getIcon("FileChooser[icons].list");
		this.detailsViewIcon = UIManager.getIcon("FileChooser[icons].details");
		this.newFolderIcon = UIManager.getIcon("FileChooser[icons].newFolder");
		this.upFolderIcon = UIManager.getIcon("FileChooser[icons].upFolder");

		this.openButtonText = "OPEN";
		this.cancelButtonText = "CANCEL";
		this.helpButtonText = "HELP";
		this.saveButtonText = "SAVE";
		this.directoryOpenButtonText = "OPEN";
		this.updateButtonText = "UPDATE";

		this.installComponents(fileChooser);
	}

	@Override
	public void uninstallComponents(JFileChooser fc) {
		super.uninstallComponents(fc);
	}

	@Override
	public void uninstallUI(JComponent c) {

		JFileChooser fileChooser = (JFileChooser) c;

		this.uninstallIcons (fileChooser);
		this.uninstallComponents(fileChooser);
		this.uninstallListeners(fileChooser);
		this.uninstallStrings(fileChooser);
		super.uninstallUI(c);

		this.computerIcon = null;
		this.directoryIcon = null;
		this.fileIcon = null;
		this.floppyDriveIcon = null;
		this.hardDriveIcon = null;

		this.homeFolderIcon = null;
		this.listViewIcon = null;
		this.detailsViewIcon = null;
		this.newFolderIcon = null;
		this.upFolderIcon = null;

		this.openButtonText = null;
		this.cancelButtonText = null;
		this.helpButtonText = null;
		this.saveButtonText = null;
		this.directoryOpenButtonText = null;
		this.updateButtonText = null;
	}

	@Override
	public void paint (Graphics g, JComponent c) {
		super.paint (MaterialDrawingUtils.getAliasedGraphics (g), c);
	}
}
