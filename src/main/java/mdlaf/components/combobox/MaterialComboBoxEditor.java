package mdlaf.components.combobox;

import mdlaf.utils.MaterialColors;

import javax.swing.*;
import javax.swing.plaf.basic.BasicComboBoxEditor;
import java.awt.*;

/**
 * @author https://github.com/vincenzopalazzo
 */
public class MaterialComboBoxEditor extends BasicComboBoxEditor {

    @Override
    public Component getEditorComponent() {
        Component component = super.getEditorComponent();
        component.setForeground(UIManager.getColor("ComboBox.selectionForeground"));
        component.setForeground(MaterialColors.RED_800);
        return component;
    }
}
