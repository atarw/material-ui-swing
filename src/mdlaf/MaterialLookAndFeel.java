/*
 * MIT License
 *
 * Copyright (c) 2018 atharva washimkar, Vincent Palazzo
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
package mdlaf;

import mdlaf.components.button.MaterialButtonUI;
import mdlaf.components.checkbox.MaterialCheckBoxUI;
import mdlaf.components.checkboxmenuitem.MaterialCheckBoxMenuItemUI;
import mdlaf.components.combobox.MaterialComboBoxUI;
import mdlaf.components.filechooser.MaterialFileChooserUI;
import mdlaf.components.label.MaterialLabelUI;
import mdlaf.components.menu.MaterialMenuUI;
import mdlaf.components.menubar.MaterialMenuBarUI;
import mdlaf.components.menuitem.MaterialMenuItemUI;
import mdlaf.components.panel.MaterialPanelUI;
import mdlaf.components.password.MaterialPasswordFieldUI;
import mdlaf.components.popupmenu.MaterialPopupMenuUI;
import mdlaf.components.progressbar.MaterialProgressBarUI;
import mdlaf.components.radiobutton.MaterialRadioButtonUI;
import mdlaf.components.radiobuttonmenuitem.MaterialRadioButtonMenuItemUI;
import mdlaf.components.scrollbar.MaterialScrollBarUI;
import mdlaf.components.separator.MaterialSeparatorUI;
import mdlaf.components.slider.MaterialSliderUI;
import mdlaf.components.spinner.MaterialSpinnerUI;
import mdlaf.components.tabbedpane.MaterialTabbedPaneUI;
import mdlaf.components.table.MaterialTableHeaderUI;
import mdlaf.components.table.MaterialTableUI;
import mdlaf.components.taskpane.MaterialTaskPaneUI;
import mdlaf.components.textfield.MaterialTextFieldUI;
import mdlaf.components.textpane.MaterialTextPaneUI;
import mdlaf.components.togglebutton.MaterialToggleButtonUI;
import mdlaf.components.toolbar.MaterialToolBarUI;
import mdlaf.components.tooltip.MaterialToolTipUI;
import mdlaf.components.tree.MaterialTreeUI;
import mdlaf.shadows.DropShadowBorder;
import mdlaf.utils.*;

import javax.swing.*;
import javax.swing.plaf.metal.MetalLookAndFeel;
import java.awt.*;

public class MaterialLookAndFeel extends MetalLookAndFeel {

    private static final String buttonUI = MaterialButtonUI.class.getCanonicalName();
    private static final String textfieldUI = MaterialTextFieldUI.class.getCanonicalName();
    private static final String passwordFieldUI = MaterialPasswordFieldUI.class.getCanonicalName();
    private static final String tableUI = MaterialTableUI.class.getCanonicalName();
    private static final String tableHeaderUI = MaterialTableHeaderUI.class.getCanonicalName();
    private static final String treeUI = MaterialTreeUI.class.getCanonicalName();
    private static final String spinnerUI = MaterialSpinnerUI.class.getCanonicalName();
    private static final String panelUI = MaterialPanelUI.class.getCanonicalName();
    private static final String labelUI = MaterialLabelUI.class.getCanonicalName();
    private static final String menuItemUI = MaterialMenuItemUI.class.getCanonicalName();
    private static final String menuBarUI = MaterialMenuBarUI.class.getCanonicalName();
    private static final String menuUI = MaterialMenuUI.class.getCanonicalName();
    private static final String checkBoxUI = MaterialCheckBoxUI.class.getCanonicalName();
    private static final String radioButtonUI = MaterialRadioButtonUI.class.getCanonicalName();
    private static final String tabbedPaneUI = MaterialTabbedPaneUI.class.getCanonicalName();
    private static final String toggleButtonUI = MaterialToggleButtonUI.class.getCanonicalName();
    private static final String scrollBarUI = MaterialScrollBarUI.class.getCanonicalName();
    private static final String comboBoxUI = MaterialComboBoxUI.class.getCanonicalName();
    private static final String popupMenuUI = MaterialPopupMenuUI.class.getCanonicalName();
    private static final String toolbarUI = MaterialToolBarUI.class.getCanonicalName();
    private static final String sliderUI = MaterialSliderUI.class.getCanonicalName();
    private static final String progressBarUI = MaterialProgressBarUI.class.getCanonicalName();
    private static final String radioButtonMenuItemUI = MaterialRadioButtonMenuItemUI.class.getCanonicalName();
    private static final String checkBoxMenuItemUI = MaterialCheckBoxMenuItemUI.class.getCanonicalName();
    private static final String textPaneUI = MaterialTextPaneUI.class.getCanonicalName();
    private static final String editorPane = MaterialTextPaneUI.class.getCanonicalName();
    private static final String separatorUI = MaterialSeparatorUI.class.getCanonicalName();
    private static final String fileChooserUI = MaterialFileChooserUI.class.getCanonicalName();
    private static final String toolTipUI = MaterialToolTipUI.class.getCanonicalName();
    private static final String taskPaneUI = MaterialTaskPaneUI.class.getCanonicalName();


    @Override
    public String getName() {
        return "Material Look And Feel";
    }

    @Override
    public String getID() {
        return "MaterialLookAndFeel";
    }

    @Override
    public String getDescription() {
        return "A modern Material Design UI for Java Swing";
    }

    @Override
    public boolean isNativeLookAndFeel() {
        return false;
    }

    @Override
    public boolean isSupportedLookAndFeel() {
        return true;
    }

    @Override
    protected void initClassDefaults(UIDefaults table) {
        super.initClassDefaults(table);
        table.put("ButtonUI", buttonUI);
        table.put("TextFieldUI", textfieldUI);
        table.put("PasswordFieldUI", passwordFieldUI);
        table.put("TableUI", tableUI);
        table.put("TableHeaderUI", tableHeaderUI);
        table.put("TreeUI", treeUI);
        table.put("SpinnerUI", spinnerUI);
        table.put("PanelUI", panelUI);
        table.put("LabelUI", labelUI);
        table.put("MenuItemUI", menuItemUI);
        table.put("MenuBarUI", menuBarUI);
        table.put("MenuUI", menuUI);
        table.put("CheckBoxUI", checkBoxUI);
        table.put("RadioButtonUI", radioButtonUI);
        table.put("TabbedPaneUI", tabbedPaneUI);
        table.put("ToggleButtonUI", toggleButtonUI);
        table.put("ScrollBarUI", scrollBarUI);
        table.put("ComboBoxUI", comboBoxUI);
        table.put("PopupMenuUI", popupMenuUI);
        table.put("ToolBarUI", toolbarUI);
        table.put("SliderUI", sliderUI);
        table.put("ProgressBarUI", progressBarUI);
        table.put("RadioButtonMenuItemUI", radioButtonMenuItemUI);
        table.put("CheckBoxMenuItemUI", checkBoxMenuItemUI);
        table.put("TextPaneUI", textPaneUI);
        table.put("EditorPaneUI", editorPane);
        table.put("SeparatorUI", separatorUI);
        table.put("FileChooserUI", fileChooserUI);
        table.put("ToolTipUI", toolTipUI);
        // java swingx
        table.put("swingx/TaskPaneUI", taskPaneUI);
    }

    @Override
    protected void initComponentDefaults(UIDefaults table) {
        super.initComponentDefaults(table);

        table.put("Button.highlight", MaterialColors.GRAY_400);
        table.put("Button.opaque", false);
        table.put("Button.border", BorderFactory.createEmptyBorder(7, 17, 7, 17));
        table.put("Button.background", MaterialColors.GRAY_200);
        table.put("Button.foreground", Color.BLACK);
        table.put("Button.font", MaterialFontFactory.getIstance().getFont(MaterialFontFactory.BOLD));
        table.put("Button.mouseHoverColor", MaterialColors.GRAY_500);
        table.put("Button.mouseHoverEnable", true);

        table.put("CheckBox.font", MaterialFontFactory.getIstance().getFont(MaterialFontFactory.BOLD));
        table.put("CheckBox.background", Color.WHITE);
        table.put("CheckBox.foreground", Color.BLACK);
        table.put("CheckBox.icon", new ImageIcon(MaterialImageFactory.getIstance().getImage(MaterialImageFactory.UNCHECKED_BOX)));
        table.put("CheckBox.selectedIcon", new ImageIcon(MaterialImageFactory.getIstance().getImage(MaterialImageFactory.PAINTED_BLACK_CHECKED_BOX)));

        table.put("ComboBox.font", MaterialFontFactory.getIstance().getFont(MaterialFontFactory.REGULAR));
        table.put("ComboBox.background", Color.WHITE);
        table.put("ComboBox.foreground", Color.BLACK);
        table.put("ComboBox.border", BorderFactory.createCompoundBorder(MaterialBorders.LIGHT_LINE_BORDER, BorderFactory.createEmptyBorder(0, 5, 0, 0)));
        table.put("ComboBox.buttonBackground", MaterialColors.GRAY_300);
        table.put("ComboBox.selectionBackground", Color.WHITE);
        table.put("ComboBox.selectionForeground", Color.BLACK);
        table.put("ComboBox.selectedInDropDownBackground", MaterialColors.GRAY_200);

        table.put("Label.font", MaterialFontFactory.getIstance().getFont(MaterialFontFactory.REGULAR));
        table.put("Label.background", Color.WHITE);
        table.put("Label.foreground", Color.BLACK);
        table.put("Label.border", BorderFactory.createEmptyBorder());

        table.put("Menu.font", MaterialFontFactory.getIstance().getFont(MaterialFontFactory.REGULAR));
        table.put("Menu.border", BorderFactory.createEmptyBorder(5, 5, 5, 5));
        table.put("Menu.background", Color.WHITE);
        table.put("Menu.foreground", Color.BLACK);
        table.put("Menu.opaque", true);
        table.put("Menu.selectionBackground", MaterialColors.GRAY_200);
        table.put("Menu.selectionForeground", MaterialColors.BLACK);
        table.put("Menu.disabledForeground", new Color(0, 0, 0, 100));
        table.put("Menu.menuPopupOffsetY", 3);

        table.put("MenuBar.font", MaterialFontFactory.getIstance().getFont(MaterialFontFactory.BOLD));
        table.put("MenuBar.background", Color.WHITE);
        table.put("MenuBar.border", MaterialBorders.LIGHT_SHADOW_BORDER);
        table.put("MenuBar.foreground", MaterialColors.BLACK);

        table.put("MenuItem.disabledForeground", new Color(0, 0, 0, 100));
        table.put("MenuItem.selectionBackground", MaterialColors.GRAY_200);
        table.put("MenuItem.selectionForeground", Color.BLACK);
        table.put("MenuItem.font", MaterialFontFactory.getIstance().getFont(MaterialFontFactory.MEDIUM));
        table.put("MenuItem.background", Color.WHITE);
        table.put("MenuItem.foreground", Color.BLACK);
        table.put("MenuItem.border", BorderFactory.createEmptyBorder(5, 0, 5, 0));

        table.put("OptionPane.background", Color.WHITE);
        table.put("OptionPane.border", MaterialBorders.DEFAULT_SHADOW_BORDER);
        table.put("OptionPane.font", MaterialFontFactory.getIstance().getFont(MaterialFontFactory.REGULAR));

        table.put("Panel.font", MaterialFontFactory.getIstance().getFont(MaterialFontFactory.REGULAR));
        table.put("Panel.background", Color.WHITE);
        table.put("Panel.border", BorderFactory.createEmptyBorder());

        table.put("PopupMenu.border", MaterialBorders.LIGHT_LINE_BORDER);
        table.put("PopupMenu.background", Color.WHITE);
        table.put("PopupMenu.foreground", Color.BLACK);

        table.put("RadioButton.font", MaterialFontFactory.getIstance().getFont(MaterialFontFactory.REGULAR));
        table.put("RadioButton.background", Color.WHITE);
        table.put("RadioButton.foreground", Color.BLACK);
        table.put("RadioButton.icon", new ImageIcon(MaterialImageFactory.getIstance().getImage(MaterialImageFactory.RADIO_BUTTON_OFF)));
        table.put("RadioButton.selectedIcon", new ImageIcon(MaterialImageFactory.getIstance().getImage(MaterialImageFactory.RADIO_BUTTON_ON)));

        table.put("Spinner.font", MaterialFontFactory.getIstance().getFont(MaterialFontFactory.REGULAR));
        table.put("Spinner.background", Color.WHITE);
        table.put("Spinner.foreground", Color.BLACK);
        table.put("Spinner.border", MaterialBorders.LIGHT_LINE_BORDER);
        table.put("Spinner.arrowButtonBackground", MaterialColors.GRAY_200);
        table.put("Spinner.arrowButtonBorder", BorderFactory.createEmptyBorder());

        table.put("ScrollBar.font", MaterialFontFactory.getIstance().getFont(MaterialFontFactory.REGULAR));
        table.put("ScrollBar.track", MaterialColors.GRAY_200);
        table.put("ScrollBar.thumb", MaterialColors.GRAY_300);
        table.put("ScrollBar.thumbDarkShadow", MaterialColors.GRAY_300);
        table.put("ScrollBar.thumbHighlight", MaterialColors.GRAY_300);
        table.put("ScrollBar.thumbShadow", MaterialColors.GRAY_300);
        table.put("ScrollBar.arrowButtonBackground", MaterialColors.GRAY_300);
        table.put("ScrollBar.arrowButtonBorder", BorderFactory.createEmptyBorder());

        table.put("ScrollPane.background", Color.WHITE);
        table.put("ScrollPane.border", BorderFactory.createEmptyBorder());
        table.put("ScrollPane.font", MaterialFontFactory.getIstance().getFont(MaterialFontFactory.REGULAR));

        table.put("Slider.font", MaterialFontFactory.getIstance().getFont(MaterialFontFactory.REGULAR));
        table.put("Slider.background", Color.WHITE);
        table.put("Slider.foreground", MaterialColors.LIGHT_BLUE_400);
        table.put("Slider.trackColor", Color.BLACK);
        table.put("Slider.border", BorderFactory.createCompoundBorder(MaterialBorders.LIGHT_LINE_BORDER, BorderFactory.createEmptyBorder(20, 20, 20, 20)));

        table.put("SplitPane.border", BorderFactory.createEmptyBorder());
        table.put("SplitPane.background", MaterialColors.WHITE);
        table.put("SplitPane.dividerSize", 5);
        table.put("SplitPaneDivider.border", BorderFactory.createEmptyBorder());

        table.put("TabbedPane.font", MaterialFontFactory.getIstance().getFont(MaterialFontFactory.REGULAR));
        table.put("TabbedPane.background", Color.WHITE);
        table.put("TabbedPane.foreground", Color.BLACK);
        table.put("TabbedPane.border", BorderFactory.createEmptyBorder());
        table.put("TabbedPane.shadow", null);
        table.put("TabbedPane.darkShadow", null);
        table.put("TabbedPane.highlight", MaterialColors.GRAY_200);
        table.put("TabbedPane.borderHighlightColor", MaterialColors.GRAY_300);

        table.put("Table.selectionBackground", MaterialColors.GRAY_100);
        table.put("Table.selectionForeground", MaterialColors.BLACK);
        table.put("Table.background", MaterialColors.WHITE);
        table.put("Table.foreground", MaterialColors.BLACK);
        table.put("Table.font", MaterialFontFactory.getIstance().getFont(MaterialFontFactory.REGULAR));
        table.put("Table.border", MaterialBorders.LIGHT_LINE_BORDER);
        table.put("Table.gridColor", MaterialColors.GRAY_200);
        table.put("TableHeader.background", MaterialColors.GRAY_200);
        table.put("TableHeader.font", MaterialFontFactory.getIstance().getFont(MaterialFontFactory.BOLD));
        table.put("TableHeader.cellBorder", BorderFactory.createCompoundBorder(MaterialBorders.LIGHT_LINE_BORDER, BorderFactory.createEmptyBorder(5, 5, 5, 5)));

        table.put("TextArea.background", MaterialColors.GRAY_200);
        table.put("TextArea.border", BorderFactory.createEmptyBorder());
        table.put("TextArea.foreground", Color.BLACK);

        table.put("ToggleButton.border", BorderFactory.createEmptyBorder());
        table.put("ToggleButton.font", MaterialFontFactory.getIstance().getFont(MaterialFontFactory.REGULAR));
        table.put("ToggleButton.background", MaterialColors.WHITE);
        table.put("ToggleButton.foreground", MaterialColors.BLACK);
        table.put("ToggleButton.icon", new ImageIcon(MaterialImageFactory.getIstance().getImage(MaterialImageFactory.TOGGLE_BUTTON_OFF)));
        table.put("ToggleButton.selectedIcon", new ImageIcon(MaterialImageFactory.getIstance().getImage(MaterialImageFactory.TOGGLE_BUTTON_ON)));

        table.put("ToolBar.font", MaterialFontFactory.getIstance().getFont(MaterialFontFactory.REGULAR));
        table.put("ToolBar.background", Color.WHITE);
        table.put("ToolBar.foreground", Color.BLACK);
        table.put("ToolBar.border", MaterialBorders.LIGHT_SHADOW_BORDER);
        table.put("ToolBar.dockingBackground", MaterialColors.LIGHT_GREEN_A100);
        table.put("ToolBar.floatingBackground", MaterialColors.GRAY_200);

        table.put("Tree.font", MaterialFontFactory.getIstance().getFont(MaterialFontFactory.REGULAR));
        table.put("Tree.selectionForeground", MaterialColors.BLACK);
        table.put("Tree.foreground", MaterialColors.BLACK);
        table.put("Tree.selectionBackground", MaterialColors.GRAY_200);
        table.put("Tree.background", MaterialColors.WHITE);
        table.put("Tree.closedIcon", new ImageIcon(MaterialImageFactory.getIstance().getImage(MaterialImageFactory.RIGHT_ARROW)));
        table.put("Tree.openIcon", new ImageIcon(MaterialImageFactory.getIstance().getImage(MaterialImageFactory.DOWN_ARROW)));
        table.put("Tree.selectionBorderColor", null);

        table.put("RadioButtonMenuItem.foreground", MaterialColors.BLACK);
        table.put("RadioButtonMenuItem.selectionForeground", MaterialColors.BLACK);

        //If it changes the background of the menuitem it must change this too, irrespective of its setting
        table.put("RadioButtonMenuItem.background", UIManager.getColor("MenuItem.background"));
        table.put("RadioButtonMenuItem.selectionBackground", MaterialColors.GRAY_200);
        table.put("RadioButtonMenuItem.border", BorderFactory.createEmptyBorder(5, 5, 5, 5));
        table.put("RadioButtonMenuItem.checkIcon", new ImageIcon(MaterialImageFactory.getIstance().getImage(MaterialImageFactory.RADIO_BUTTON_OFF)));
        table.put("RadioButtonMenuItem.selectedCheckIcon", new ImageIcon(MaterialImageFactory.getIstance().getImage(MaterialImageFactory.RADIO_BUTTON_ON)));

        //If it changes the background of the menuitem it must change this too, irrespective of its setting
        table.put("CheckBoxMenuItem.background", UIManager.getColor("MenuItem.background"));
        table.put("CheckBoxMenuItem.selectionBackground", MaterialColors.GRAY_200);
        table.put("CheckBoxMenuItem.foreground", MaterialColors.BLACK);
        table.put("CheckBoxMenuItem.selectionForeground", MaterialColors.BLACK);
        table.put("CheckBoxMenuItem.border", BorderFactory.createEmptyBorder(5, 5, 5, 5));
        table.put("CheckBoxMenuItem.checkIcon", new ImageIcon(MaterialImageFactory.getIstance().getImage(MaterialImageFactory.UNCHECKED_BOX)));
        table.put("CheckBoxMenuItem.selectedCheckIcon", new ImageIcon(MaterialImageFactory.getIstance().getImage(MaterialImageFactory.PAINTED_BLACK_CHECKED_BOX)));

        table.put("TextPane.border", MaterialBorders.LIGHT_LINE_BORDER);
        table.put("TextPane.background", MaterialColors.GRAY_50);
        table.put("TextPane.selectionBackground", MaterialColors.LIGHT_BLUE_200);
        table.put("TextPane.inactiveForeground", MaterialColors.GRAY_500);
        table.put("TextPane.font", MaterialFontFactory.getIstance().getFont(MaterialFontFactory.ITALIC));

        table.put("EditorPane.border", MaterialBorders.LIGHT_LINE_BORDER);
        table.put("EditorPane.background", MaterialColors.GRAY_50);
        table.put("EditorPane.selectionBackground", MaterialColors.LIGHT_BLUE_200);
        table.put("EditorPane.inactiveForeground", MaterialColors.GRAY_500);
        table.put("EditorPane.font", MaterialFontFactory.getIstance().getFont(MaterialFontFactory.REGULAR));

        table.put("Separator.background", MaterialColors.GRAY_300);
        table.put("Separator.foreground", MaterialColors.GRAY_300);

        table.put("ToolTip.background", MaterialColors.GRAY_500);
        table.put("ToolTip.foreground", MaterialColors.GRAY_50);
        table.put("ToolTip.border", BorderFactory.createEmptyBorder(5, 5, 5, 5));

        table.put("TextField.inactiveForeground", MaterialColors.GRAY_800);
        table.put("TextField.inactiveBackground", MaterialColors.GRAY_200);
        table.put("TextField.selectionBackground", MaterialColors.LIGHT_BLUE_400);
        table.put("TextField.selectionForeground", MaterialColors.BLACK);

        table.put("TitledBorder.border",
                new DropShadowBorder(MaterialColors.BLACK, 10, 4, (float) 0.2, 8,
                        true, true, true, true));
        table.put("TitledBorder.font", MaterialFonts.BOLD);

        table.put("TaskPane.font", MaterialFonts.MEDIUM);
        table.put("TaskPane.titleBackgroundGradientStart", MaterialColors.GRAY_300);
        table.put("TaskPane.titleBackgroundGradientEnd", MaterialColors.GRAY_500);
        table.put("TaskPane.titleOver", MaterialColors.LIGHT_BLUE_500);
        table.put("TaskPane.specialTitleOver", MaterialColors.LIGHT_BLUE_500);
        table.put("TaskPane.background", MaterialColors.LIGHT_BLUE_500);
        table.put("TaskPane.foreground", MaterialColors.BLACK);
        table.put("TaskPane.borderColor", MaterialColors.LIGHT_BLUE_500);
        table.put("TaskPane.border", MaterialBorders.DEFAULT_SHADOW_BORDER);
        table.put("TaskPane.contentBackground", MaterialColors.GRAY_50);
        table.put("TaskPane.yesCollassed", new ImageIcon(MaterialImageFactory.getIstance().getImage(MaterialImageFactory.YES_COLLASSED)));
        table.put("TaskPane.noCollassed",   new ImageIcon(MaterialImageFactory.getIstance().getImage(MaterialImageFactory.NO_COLLASSED)));

    }
}
