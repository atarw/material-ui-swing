/**
 * MIT License
 * <p>
 * Copyright (c) 2018-2020 atharva washimkar, Vincenzo Palazzo vincenzopalazzo1996@gmail.com
 * <p>
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * <p>
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 * <p>
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package mdlaf.components.filechooser;

import javax.swing.*;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.metal.MetalFileChooserUI;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 * @author https://github.com/vincenzopalazzo
 * @author https://github.com/atarw
 */
public class MaterialFileChooserUI extends MetalFileChooserUI {

    protected MaterialFileChooserEvents lifeCycleEvent;

    public MaterialFileChooserUI(JFileChooser fileChooser) {
        super(fileChooser);
        lifeCycleEvent = new MaterialFileChooserEvents();
    }

    public static ComponentUI createUI(JComponent c) {
        return new MaterialFileChooserUI((JFileChooser) c);
    }

    @Override
    public void installUI(JComponent c) {
        super.installUI(c);
        JFileChooser fileChooser = (JFileChooser) c;
        //MaterialFileChooserUI ui = (MaterialFileChooserUI) fileChooser.getUI ();
        //all this before were ui.uninstallIcon
        this.uninstallIcons(fileChooser);
        this.uninstallComponents(fileChooser);
        this.clearIconCache();
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

        this.uninstallIcons(fileChooser);
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
    protected void installListeners(JFileChooser fc) {
        super.installListeners(fc);
        fc.addPropertyChangeListener(lifeCycleEvent);
    }

    /**
     * Uninstalls the listeners.
     *
     * param fc the file chooser
     */
    @Override
    protected void uninstallListeners(JFileChooser fc) {
        fc.removePropertyChangeListener(lifeCycleEvent);
        super.uninstallListeners(fc);
    }

    @Override
    public void paint(Graphics g, JComponent c) {
        super.paint(g, c);
    }

    @Override
    protected FilterComboBoxRenderer createFilterComboBoxRenderer() {
        return new MetalFileChooserUI.FilterComboBoxRenderer(){
            @Override
            public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

                setBorder((UIManager.getBorder("ComboBox.borderItems")));
                if (isSelected) {
                    setForeground(UIManager.getColor("ComboBox[item].selectionForeground"));
                } else {
                    setForeground(UIManager.getColor("ComboBox.foreground"));
                }
                setBackground(isSelected || cellHasFocus ?
                        UIManager.getColor("ComboBox.selectedInDropDownBackground") :
                        UIManager.getColor("ComboBox.background"));

                return this;
            }
        };
    }


    protected class MaterialFileChooserEvents implements PropertyChangeListener {

        protected static final String CLOSE_EVENT = "JFileChooserDialogIsClosingProperty";

        /**
         * This method gets called when a bound property is changed.
         *
         * param evt A PropertyChangeEvent object describing the event source
         *            and the property that has changed.
         */
        @Override
        public void propertyChange(PropertyChangeEvent evt) {
            if(evt.getPropertyName().equals(CLOSE_EVENT)){
                getFileChooser().updateUI();
            }
        }
    }
}
