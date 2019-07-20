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


		ui.installComponents(fileChooser);
	}

	@Override
	public void paint (Graphics g, JComponent c) {
		super.paint (MaterialDrawingUtils.getAliasedGraphics (g), c);
	}
}
