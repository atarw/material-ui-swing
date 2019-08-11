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
package mdlaf;

import mdlaf.components.rootpane.MaterialRootPaneUI;
import mdlaf.components.internalframe.MaterialInternalFrameUI;
import mdlaf.components.button.MaterialButtonUI;
import mdlaf.components.checkbox.MaterialCheckBoxUI;
import mdlaf.components.checkboxmenuitem.MaterialCheckBoxMenuItemUI;
import mdlaf.components.combobox.MaterialComboBoxUI;
import mdlaf.components.editorpane.MaterialEditorPaneUI;
import mdlaf.components.filechooser.MaterialFileChooserUI;
import mdlaf.components.formattertextfield.MaterialFormattedTextFieldUI;
import mdlaf.components.label.MaterialLabelUI;
import mdlaf.components.list.MaterialListUI;
import mdlaf.components.menu.MaterialMenuUI;
import mdlaf.components.menubar.MaterialMenuBarUI;
import mdlaf.components.menuitem.MaterialMenuItemUI;
import mdlaf.components.optionpane.MaterialOptionPaneUI;
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
import mdlaf.components.splitpane.MaterialSplitPaneUI;
import mdlaf.components.tabbedpane.MaterialTabbedPaneUI;
import mdlaf.components.table.MaterialTableHeaderUI;
import mdlaf.components.table.MaterialTableUI;
import mdlaf.components.taskpane.MaterialTaskPaneUI;
import mdlaf.components.textarea.MaterialTextAreaUI;
import mdlaf.components.textfield.MaterialTextFieldUI;
import mdlaf.components.textpane.MaterialTextPaneUI;
import mdlaf.components.togglebutton.MaterialToggleButtonUI;
import mdlaf.components.toolbar.MaterialToolBarUI;
import mdlaf.components.tooltip.MaterialToolTipUI;
import mdlaf.components.tree.MaterialTreeUI;
import mdlaf.themes.MaterialLiteTheme;
import mdlaf.themes.MaterialTheme;
import mdlaf.themes.exceptions.MaterialChangeThemeException;
import mdlaf.utils.MaterialBorders;
import mdlaf.utils.MaterialColors;
import mdlaf.utils.MaterialFontFactory;
import mdlaf.utils.MaterialImageFactory;

import sun.awt.SunToolkit;
import javax.swing.*;
import javax.swing.plaf.BorderUIResource;
import javax.swing.plaf.FontUIResource;
import javax.swing.plaf.basic.BasicLookAndFeel;
import javax.swing.plaf.metal.MetalLookAndFeel;
import javax.swing.text.DefaultEditorKit;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.lang.reflect.Method;

/**
 * @contributor https://github.com/vincenzopalazzo
 */
public class MaterialLookAndFeel extends BasicLookAndFeel {

    protected BasicLookAndFeel basicLookAndFeel;
    protected MaterialTheme theme;

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
    private static final String separatorUI = MaterialSeparatorUI.class.getCanonicalName();
    private static final String fileChooserUI = MaterialFileChooserUI.class.getCanonicalName();
    private static final String toolTipUI = MaterialToolTipUI.class.getCanonicalName();
    private static final String taskPaneUI = MaterialTaskPaneUI.class.getCanonicalName();
    private static final String formattedTextFieldUI = MaterialFormattedTextFieldUI.class.getCanonicalName();
    private static final String listUI = MaterialListUI.class.getCanonicalName();
    private static final String internalFrameUI = MaterialInternalFrameUI.class.getCanonicalName();
    private static final String textAreaUI = MaterialTextAreaUI.class.getCanonicalName();
    private static final String editorPane = MaterialEditorPaneUI.class.getCanonicalName();
    private static final String rootPane = MaterialRootPaneUI.class.getCanonicalName();
    private static final String optionPaneUI = MaterialOptionPaneUI.class.getCanonicalName();
    //TODO not allineated this component with master
    private static final String splitPaneUI = MaterialSplitPaneUI.class.getCanonicalName();

    public static void changeTheme(MaterialTheme theme){
        if(theme == null){
            throw new IllegalArgumentException("Theme null");
        }
        BasicLookAndFeel blaf = (BasicLookAndFeel) UIManager.getLookAndFeel();
        if(blaf instanceof MaterialLookAndFeel){
            MaterialLookAndFeel materialLookAndFeel = (MaterialLookAndFeel) blaf;
            UIManager.removeAuxiliaryLookAndFeel(materialLookAndFeel);
            theme.installTheme();
            materialLookAndFeel.setTheme(theme);
            try {
                UIManager.setLookAndFeel(materialLookAndFeel);
            } catch (UnsupportedLookAndFeelException e) {
                throw new MaterialChangeThemeException("Exception generated when I change the theme\nError exception is: " + e.getLocalizedMessage());
            }
            return;
        }

        throw new MaterialChangeThemeException("The look and feel setted not is MaterialLookAnfFeel");
    }

    public MaterialLookAndFeel() {
        this(new MaterialLiteTheme());
    }

    public MaterialLookAndFeel(MaterialTheme theme) {
        this.theme = theme;
        theme.installTheme();
        try {
            basicLookAndFeel = new MetalLookAndFeel();
            UIManager.LookAndFeelInfo info = new MaterialLookAndFeelInfo(getName(), getClass().getCanonicalName());
            UIManager.installLookAndFeel(info);
        } catch (Exception ignore) {
            ignore.printStackTrace();
        }
    }

    @Override
    public String getName() {
        return "Material Look And Feel with: " + theme.getName();
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
    public boolean getSupportsWindowDecorations() {
        return true;
    }

    @Override
    protected void initClassDefaults(UIDefaults table) {
        super.initClassDefaults(table);
        table.put(MaterialButtonUI.UI_KEY, buttonUI);
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
        table.put("SeparatorUI", separatorUI);
        table.put("FileChooserUI", fileChooserUI);
        table.put("ToolTipUI", toolTipUI);
        table.put("FormattedTextFieldUI", formattedTextFieldUI);
        table.put("ListUI", listUI);
        table.put("TextAreaUI", textAreaUI);
        table.put("EditorPaneUI", editorPane);
        table.put("InternalFrameUI", internalFrameUI);
        table.put("RootPaneUI", rootPane);
        table.put("OptionPaneUI", optionPaneUI);
        table.put("SplitPaneUI", splitPaneUI);
        // java swingx
        table.put("swingx/TaskPaneUI", taskPaneUI);
    }

    @Override
    protected void initComponentDefaults(UIDefaults table) {
        super.initComponentDefaults(table);

        table.put("Button.highlight", MaterialColors.GRAY_400);
        table.put("Button.opaque", false);
        table.put("Button.border", BorderFactory.createEmptyBorder(7, 17, 7, 17));
        table.put("Button.background", theme.getButtonBackgroundColor());
        table.put("Button.foreground", theme.getButtonTextColor());
        table.put("Button[Default].background", theme.getButtonDefaultBackgroundColor());
        table.put("Button[Default].foreground", theme.getButtonDefaultTextColor());
        table.put("Button.disabledBackground", MaterialColors.COSMO_DARK_GRAY);
        table.put("Button.disabledForeground", MaterialColors.BLACK);
        table.put("Button.font", theme.getFontBold());
        table.put("Button[Default].mouseHoverColor", theme.getButtonDefaultBackgroundColorMouseHover());
        table.put("Button.mouseHoverColor", theme.getButtonBackgroundColorMouseHover());
        table.put("Button.mouseHoverEnable", true);
        table.put("Button.mouseHoverBorder", false); //if is true -> the mouse hover effect change the color to OnlyBorder, if false to all button
        table.put("Button.focusable", true);
        table.put("Button[focus].color", MaterialColors.GRAY_900);
        table.put("Button.disabledText", MaterialColors.GRAY_600);
        table.put("Button[Default].shadowPixel", 3);
        table.put("Button[Default].shadowEnable", false);
        table.put("Button[Default][focus].color", MaterialColors.GRAY_200);
        table.put("Button[border].enable", true);
        table.put("Button[border].color", MaterialColors.COSMO_MEDIUM_GRAY);
        table.put("Button[border].toAll", false); //if is true the border do have all button if if false the border do have only button without icon

        table.put("CheckBox.font", theme.getFontRegular());
        table.put("CheckBox.background", theme.getBackgroundPrimary());
        table.put("CheckBox.foreground", theme.getTextColor());
        table.put("CheckBox.disabledText", theme.getDisableTextColor());
        table.put("CheckBox.icon", new ImageIcon(MaterialImageFactory.getInstance().getImage(MaterialImageFactory.UNCHECKED_BLACK_BOX)));
        table.put("CheckBox.selectedIcon", new ImageIcon(MaterialImageFactory.getInstance().getImage(MaterialImageFactory.CHECKED_BLACK_BOX)));

        table.put("ComboBox.font", theme.getFontRegular());
        table.put("ComboBox.background", theme.getBackgroundPrimary());
        table.put("ComboBox.foreground", theme.getTextColor());
        table.put("ComboBox.border", MaterialBorders.roundedLineColorBorder(MaterialColors.COSMO_BLACK));
        table.put("ComboBox.borderItems", BorderFactory.createEmptyBorder(1, 2, 0, 1));
        table.put("ComboBox.buttonBackground", theme.getBackgroundPrimary());
        table.put("ComboBox[button].border", BorderFactory.createLineBorder(theme.getBackgroundPrimary()));
        table.put("ComboBox.disabledBackground", MaterialColors.WHITE);
        table.put("ComboBox.disabledForeground", theme.getDisableTextColor());
        table.put("ComboBox.selectionBackground", MaterialColors.WHITE);
        table.put("ComboBox.selectionForeground", theme.getTextColor());
        table.put("ComboBox.selectedInDropDownBackground", MaterialColors.COSMO_LIGTH_BLUE);
        table.put("ComboBox.mouseHoverColor", theme.getButtonBackgroundColorMouseHover());
        table.put("ComboBox.unfocusColor", theme.getTextColor());
        table.put("ComboBox.focusColor", theme.getHighlightBackgroundPrimary());
        table.put("ComboBox.mouseHoverEnabled", false);

        table.put("Label.font", MaterialFontFactory.getInstance().getFont(MaterialFontFactory.REGULAR));
        table.put("Label.background", theme.getBackgroundPrimary());
        table.put("Label.foreground", theme.getTextColor());
        table.put("Label.opaque", true);
        table.put("Label[disabled].font", MaterialFontFactory.getInstance().getFont(MaterialFontFactory.ITALIC));
        table.put("Label[disabled].background", theme.getBackgroundPrimary());
        //table.put("Label[disabled].foreground", MaterialColors.COSMO_STRONG_GRAY);
        table.put("Label.disabledForeground", MaterialColors.COSMO_STRONG_GRAY);
        table.put("Label.border", BorderFactory.createEmptyBorder());

        table.put("Menu.font", new FontUIResource(MaterialFontFactory.getInstance().getFont(MaterialFontFactory.REGULAR)));
        table.put("Menu.border", new BorderUIResource(BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        table.put("Menu.background", theme.getMenuBackground());
        table.put("Menu.foreground", theme.getMenuTextColor());
        table.put("Menu.opaque", true);
        table.put("Menu.selectionBackground", theme.getMenuBackgroundMouseHover());
        table.put("Menu.selectionForeground", theme.getMenuTextColor());
        table.put("Menu.disabledForeground", theme.getMenuDisableBackground());
        table.put("Menu.menuPopupOffsetY", 3);
        table.put("Menu[MouseOver].enable", true); //TODO adding into master

        table.put("MenuBar.font", MaterialFontFactory.getInstance().getFont(MaterialFontFactory.BOLD));
        table.put("MenuBar.background", theme.getMenuBackground());
        table.put("MenuBar.border", MaterialBorders.LIGHT_SHADOW_BORDER);
        table.put("MenuBar.foreground", theme.getMenuTextColor());

        table.put("MenuItem.disabledForeground", MaterialColors.TRANSPANENT);
        table.put("MenuItem.selectionBackground", MaterialColors.GRAY_200);
        table.put("MenuItem.selectionForeground", MaterialColors.BLACK);
        table.put("MenuItem.font", MaterialFontFactory.getInstance().getFont(MaterialFontFactory.MEDIUM));
        table.put("MenuItem.background", theme.getMenuBackground());
        table.put("MenuItem.foreground", theme.getMenuTextColor());
        table.put("MenuItem.border", BorderFactory.createEmptyBorder(5, 0, 5, 0));

        table.put("Panel.font", MaterialFontFactory.getInstance().getFont(MaterialFontFactory.REGULAR));
        table.put("Panel.background", theme.getBackgroundPrimary());
        table.put("Panel.border", BorderFactory.createEmptyBorder());

        table.put("PopupMenu.border", MaterialBorders.LIGHT_LINE_BORDER);
        table.put("PopupMenu.background", theme.getBackgroundPrimary());
        table.put("PopupMenu.foreground", MaterialColors.BLACK);

        table.put("RadioButton.font", MaterialFontFactory.getInstance().getFont(MaterialFontFactory.REGULAR));
        table.put("RadioButton.background", theme.getBackgroundPrimary());
        table.put("RadioButton.foreground", theme.getTextColor());
        table.put("RadioButton.icon", new ImageIcon(MaterialImageFactory.getInstance().getImage(MaterialImageFactory.RADIO_BUTTON_BLACK_OFF)));
        table.put("RadioButton.selectedIcon", new ImageIcon(MaterialImageFactory.getInstance().getImage(MaterialImageFactory.RADIO_BUTTON_BLACK_ON)));
        table.put("RadioButton.disabledText", theme.getDisableTextColor());

        table.put("Spinner.font", MaterialFontFactory.getInstance().getFont(MaterialFontFactory.REGULAR));
        table.put("Spinner.background", theme.getBackgroundPrimary());
        table.put("Spinner.foreground", theme.getTextColor());
        table.put("Spinner.border", MaterialBorders.LIGHT_LINE_BORDER);
        table.put("Spinner.arrowButtonBackground", MaterialColors.GRAY_200);
        table.put("Spinner.arrowButtonBorder", BorderFactory.createEmptyBorder());
        table.put("Spinner.mouseHoverEnabled", true);
        table.put("Spinner.mouseHoverColor", theme.getButtonBackgroundColorMouseHover());

        table.put("ScrollBar.font", MaterialFontFactory.getInstance().getFont(MaterialFontFactory.REGULAR));
        table.put("ScrollBar.track", MaterialColors.GRAY_200);
        table.put("ScrollBar.thumb", MaterialColors.GRAY_500);
        table.put("ScrollBar.thumbDarkShadow", MaterialColors.GRAY_500);
        table.put("ScrollBar.thumbHighlight", MaterialColors.GRAY_500);
        table.put("ScrollBar.thumbShadow", MaterialColors.GRAY_500);
        table.put("ScrollBar.arrowButtonBackground", MaterialColors.GRAY_200);
        table.put("ScrollBar.enableArrow", true);
        table.put("ScrollBar.arrowButtonBorder", BorderFactory.createEmptyBorder());
        table.put("ScrollBar.width", 14);
        table.put("ScrollBar[MouseHover].enable", true);
        table.put("ScrollBar[MouseHover].color", MaterialColors.bleach(theme.getButtonBackgroundColorMouseHover(), 0.5f));
        //table.put("ScrollBar[MouseHover].color", theme.getButtonBackgroundColorMouseHover());
        table.put("ScrollBar[OnClick].color", theme.getButtonBackgroundColorMouseHover());

        table.put("ScrollPane.background", theme.getBackgroundPrimary());
        table.put("ScrollPane.border", BorderFactory.createEmptyBorder());
        table.put("ScrollPane.font", MaterialFontFactory.getInstance().getFont(MaterialFontFactory.REGULAR));

        table.put("Slider.font", MaterialFontFactory.getInstance().getFont(MaterialFontFactory.REGULAR));
        table.put("Slider.background", theme.getBackgroundPrimary());
        table.put("Slider.foreground", theme.getTextColor());
        table.put("Slider.trackColor", MaterialColors.BLACK);
        table.put("Slider[halo].color", MaterialColors.bleach(MaterialColors.LIGHT_BLUE_400, 0.5f)); //TODO new fix
        table.put("Slider.border", BorderFactory.createCompoundBorder(MaterialBorders.LIGHT_LINE_BORDER, BorderFactory.createEmptyBorder(20, 20, 20, 20)));

        table.put("SplitPane.border", BorderFactory.createEmptyBorder());
        table.put("SplitPane.background", theme.getBackgroundPrimary());
        table.put("SplitPane.dividerSize", 5);
        table.put("SplitPaneDivider.border", BorderFactory.createEmptyBorder());
        table.put("SplitPaneDivider.background", theme.getBackgroundPrimary());

        table.put("TabbedPane.font", new FontUIResource(MaterialFontFactory.getInstance().getFont(MaterialFontFactory.REGULAR)));
        table.put("TabbedPane.background", theme.getBackgroundPrimary());
        table.put("TabbedPane.foreground", theme.getTextColor());
        table.put("TabbedPane.border", new BorderUIResource(BorderFactory.createEmptyBorder()));
        table.put("TabbedPane.shadow", null);
        table.put("TabbedPane.darkShadow", null);
        table.put("TabbedPane.highlight", MaterialColors.GRAY_200);
        table.put("TabbedPane.borderHighlightColor", MaterialColors.GRAY_300);
        table.put("TabbedPane[focus].colorLine", MaterialColors.COSMO_BLUE);
        table.put("TabbedPane[MouseHover].enable", true);

        table.put("Table.selectionBackground", MaterialColors.COSMO_LIGTH_BLUE);
        table.put("Table.selectionForeground", theme.getTextColor());
        table.put("Table.background", theme.getBackgroundPrimary());
        table.put("Table.foreground", theme.getTextColor());
        table.put("Table.font", theme.getFontRegular());
        table.put("Table.border", MaterialBorders.LIGHT_LINE_BORDER);
        table.put("Table.gridColor", MaterialColors.GRAY_200);
        table.put("Table.focusable", false);
        table.put("Table.opaque", false);
        table.put("Table.alternateRowColor", true);
        table.put("Table.alternateRowBackground", MaterialColors.GRAY_300);
        table.put("Table[row].height", 4);
        table.put("Table[CheckBox].checked", new ImageIcon(MaterialImageFactory.getInstance().getImage(MaterialImageFactory.CHECKED_BLACK_BOX)));
        table.put("Table[CheckBox].unchecked", new ImageIcon(MaterialImageFactory.getInstance().getImage(MaterialImageFactory.UNCHECKED_BLACK_BOX)));

        table.put("TableHeader.background", MaterialColors.GRAY_200);
        table.put("TableHeader.foreground", theme.getTextColor());
        table.put("TableHeader.border", MaterialBorders.DEFAULT_SHADOW_BORDER);
        table.put("TableHeader.font", theme.getFontBold());
        table.put("TableHeader.cellBorder", BorderFactory.createCompoundBorder(MaterialBorders.LIGHT_LINE_BORDER, BorderFactory.createEmptyBorder(5, 5, 5, 5)));

        table.put("TextArea.background", MaterialColors.GRAY_200);
        table.put("TextArea.border", BorderFactory.createEmptyBorder());
        table.put("TextArea.foreground", MaterialColors.BLACK);
        table.put("TextArea.font", theme.getFontBold());

        table.put("ToggleButton.border", BorderFactory.createEmptyBorder());
        table.put("ToggleButton.font", theme.getFontRegular());
        table.put("ToggleButton.background", theme.getBackgroundPrimary());
        table.put("ToggleButton.select", MaterialColors.WHITE);
        table.put("ToggleButton.foreground", theme.getTextColor());
        table.put("ToggleButton.disabledText", theme.getDisableTextColor());
        table.put("ToggleButton.icon", new ImageIcon(MaterialImageFactory.getInstance().getImage(MaterialImageFactory.TOGGLE_BUTTON_BLACK_OFF)));
        table.put("ToggleButton.selectedIcon", new ImageIcon(MaterialImageFactory.getInstance().getImage(MaterialImageFactory.TOGGLE_BUTTON_BLACK_ON)));

        table.put("ToolBar.font", theme.getFontRegular());
        table.put("ToolBar.background", theme.getBackgroundPrimary());
        table.put("ToolBar.foreground", theme.getTextColor());
        table.put("ToolBar.border", MaterialBorders.LIGHT_SHADOW_BORDER);
        table.put("ToolBar.dockingBackground", MaterialColors.LIGHT_GREEN_A100);
        table.put("ToolBar.floatingBackground", MaterialColors.GRAY_200);

        table.put("Tree.font", theme.getFontRegular());
        table.put("Tree.selectionForeground", theme.getHighlightBackgroundPrimary());
        table.put("Tree.foreground", theme.getBackgroundPrimary());
        table.put("Tree.selectionBackground", MaterialColors.GRAY_200);
        table.put("Tree.background", theme.getBackgroundPrimary());
        table.put("Tree.selectionBorderColor", MaterialColors.GRAY_200);
        table.put("Tree.collapsedIcon", null);
        table.put("Tree.expandedIcon", null);
        table.put("Tree.closedIcon", new ImageIcon(MaterialImageFactory.getInstance().getImage(MaterialImageFactory.RIGHT_ARROW)));
        table.put("Tree.openIcon", new ImageIcon(MaterialImageFactory.getInstance().getImage(MaterialImageFactory.DOWN_ARROW)));
        table.put("Tree.leafIcon", null);

        table.put("RadioButtonMenuItem.foreground", theme.getTextColor());
        table.put("RadioButtonMenuItem.selectionForeground", MaterialColors.BLACK);
        table.put("RadioButtonMenuItem.background", theme.getMenuBackground());
        table.put("RadioButtonMenuItem.selectionBackground", theme.getMenuBackgroundMouseHover());
        table.put("RadioButtonMenuItem.border", BorderFactory.createEmptyBorder(5, 0, 5, 0));
        table.put("RadioButtonMenuItem.checkIcon", new ImageIcon(MaterialImageFactory.getInstance().getImage(MaterialImageFactory.RADIO_BUTTON_BLACK_OFF)));
        table.put("RadioButtonMenuItem.selectedCheckIcon", new ImageIcon(MaterialImageFactory.getInstance().getImage(MaterialImageFactory.RADIO_BUTTON_BLACK_ON)));

        table.put("CheckBoxMenuItem.background", theme.getMenuBackground());
        table.put("CheckBoxMenuItem.selectionBackground", theme.getMenuBackgroundMouseHover());
        table.put("CheckBoxMenuItem.foreground", theme.getTextColor());
        table.put("CheckBoxMenuItem.selectionForeground", theme.getTextColor());
        table.put("CheckBoxMenuItem.border", BorderFactory.createEmptyBorder(5, 0, 5, 0));
        table.put("CheckBoxMenuItem.checkIcon", new ImageIcon(MaterialImageFactory.getInstance().getImage(MaterialImageFactory.UNCHECKED_BLACK_BOX)));
        table.put("CheckBoxMenuItem.selectedCheckIcon", new ImageIcon(MaterialImageFactory.getInstance().getImage(MaterialImageFactory.CHECKED_BLACK_BOX)));

        table.put("TextPane.border", MaterialBorders.LIGHT_LINE_BORDER);
        table.put("TextPane.background", MaterialColors.GRAY_50);
        table.put("TextPane.foreground", MaterialColors.BLACK);
        table.put("TextPane.selectionBackground", MaterialColors.LIGHT_BLUE_200);
        table.put("TextPane.inactiveForeground", MaterialColors.GRAY_500);
        table.put("TextPane.font", MaterialFontFactory.getInstance().getFont(MaterialFontFactory.ITALIC));
        //table.put("TextPane.focusInputMap", multilineInputMap);

        table.put("EditorPane.border", MaterialBorders.LIGHT_LINE_BORDER);
        table.put("EditorPane.background",theme.getBackgroundPrimary());
        table.put("EditorPane.selectionBackground", theme.getHighlightBackgroundPrimary());
        table.put("EditorPane.inactiveForeground", theme.getTextColor());
        table.put("EditorPane.font", theme.getFontRegular());
        //table.put("EditorPane.focusInputMap", multilineInputMap);

        table.put("Separator.background", MaterialColors.GRAY_300);
        table.put("Separator.foreground", MaterialColors.GRAY_300);

        table.put("ToolTip.background", MaterialColors.GRAY_500);
        table.put("ToolTip.foreground", MaterialColors.GRAY_50);
        table.put("ToolTip.border", BorderFactory.createEmptyBorder(5, 5, 5, 5));

        table.put("TextField.background", MaterialColors.GRAY_100);
        table.put("TextField.foreground", theme.getTextColor());
        table.put("TextField.inactiveForeground", MaterialColors.GRAY_800);
        table.put("TextField.inactiveBackground", MaterialColors.GRAY_100);
        table.put("TextField.selectionBackground", MaterialColors.LIGHT_BLUE_400);
        table.put("TextField.selectionForeground", MaterialColors.BLACK);
        table.put("TextField[Line].inactiveColor", MaterialColors.BLACK);
        table.put("TextField[Line].activeColor", theme.getHighlightBackgroundPrimary());
        table.put("TextField.border", BorderFactory.createEmptyBorder(3, 5, 2, 5));
        table.put("TextField.focusInputMap", fieldInputMap); //deprecated

        table.put("PasswordField.background", MaterialColors.GRAY_100);
        table.put("PasswordField.foreground", theme.getTextColor());
        table.put("PasswordField.inactiveForeground", MaterialColors.GRAY_800);
        table.put("PasswordField.inactiveBackground", MaterialColors.GRAY_200);
        table.put("PasswordField.selectionBackground", MaterialColors.LIGHT_BLUE_400);
        table.put("PasswordField.selectionForeground", MaterialColors.BLACK);
        table.put("PasswordField[Line].inactiveColor", MaterialColors.BLACK);
        table.put("PasswordField[Line].activeColor", theme.getHighlightBackgroundPrimary());
        table.put("PasswordField.border", BorderFactory.createEmptyBorder(3, 5, 2, 5));
        table.put("PasswordField.focusInputMap", fieldInputMap);

        table.put("TitledBorder.border", MaterialBorders.LIGHT_LINE_BORDER);
        table.put("TitledBorder.font", theme.getFontMedium());

        table.put("TaskPane.font", theme.getFontMedium());
        table.put("TaskPane.titleBackgroundGradientStart", MaterialColors.GRAY_300);
        table.put("TaskPane.titleBackgroundGradientEnd", MaterialColors.GRAY_500);
        table.put("TaskPane.titleOver", MaterialColors.LIGHT_BLUE_500);
        table.put("TaskPane.specialTitleOver", MaterialColors.LIGHT_BLUE_500);
        table.put("TaskPane.background", MaterialColors.GRAY_300);
        table.put("TaskPane.foreground", theme.getTextColor());
        table.put("TaskPane.borderColor", MaterialColors.LIGHT_BLUE_500);
        table.put("TaskPane.border", MaterialBorders.DEFAULT_SHADOW_BORDER);
        table.put("TaskPane.contentBackground", MaterialColors.GRAY_100);
        table.put("TaskPane.yesCollapsed", new ImageIcon(MaterialImageFactory.getInstance().getImage(MaterialImageFactory.YES_COLLAPSED)));
        table.put("TaskPane.noCollapsed", new ImageIcon(MaterialImageFactory.getInstance().getImage(MaterialImageFactory.NO_COLLAPSED)));

        table.put("FormattedTextField.inactiveForeground", MaterialColors.GRAY_800);
        table.put("FormattedTextField.inactiveBackground", MaterialColors.GRAY_200);
        table.put("FormattedTextField.selectionBackground", MaterialColors.LIGHT_BLUE_400);
        table.put("FormattedTextField.selectionForeground", MaterialColors.BLACK);
        table.put("FormattedTextField.border", BorderFactory.createEmptyBorder(3, 5, 2, 5));

        table.put("List.background", theme.getBackgroundPrimary());
        table.put("List.foreground", theme.getTextColor());
        table.put("List.border", MaterialBorders.LIGHT_SHADOW_BORDER);
        table.put("List.font", theme.getFontMedium());
        table.put("List.selectionBackground", theme.getHighlightBackgroundPrimary());
        table.put("List.selectionForeground", theme.getTextColor());
        table.put("List.focusable", true);

        table.put("RootPane.frameBorder", BorderFactory.createEmptyBorder());
        table.put("RootPane.background", theme.getBackgroundPrimary());
        table.put("RootPane.plainDialogBorder", MaterialBorders.LIGHT_SHADOW_BORDER);
        table.put("RootPane.informationDialogBorder", MaterialBorders.LIGHT_SHADOW_BORDER);
        table.put("RootPane.errorDialogBorder", MaterialBorders.LIGHT_SHADOW_BORDER);
        table.put("RootPane.fileChooserDialogBorder", MaterialBorders.LIGHT_SHADOW_BORDER);
        table.put("RootPane.questionDialogBorder", MaterialBorders.LIGHT_SHADOW_BORDER);
        table.put("RootPane.warningDialogBorder", MaterialBorders.LIGHT_SHADOW_BORDER);
        table.put("RootPane.colorChooserDialogBorder", MaterialColors.WHITE);

        table.put("InternalFrame.maximizeIcon", new ImageIcon(MaterialImageFactory.getInstance().getImage(MaterialImageFactory.MAXIMIZE_WINDOWS)));
        table.put("InternalFrame.minimizeIcon", new ImageIcon(MaterialImageFactory.getInstance().getImage(MaterialImageFactory.MINIIMIZE_WINDOWS)));
        table.put("InternalFrame.closeIcon", new ImageIcon(MaterialImageFactory.getInstance().getImage(MaterialImageFactory.CLOSE_WINDOWS_BLACK)));
        table.put("InternalFrame.iconifyIcon", new ImageIcon(MaterialImageFactory.getInstance().getImage(MaterialImageFactory.ICONIFY_WINDOWS)));
        table.put("InternalFrame.activeTitleBackground", MaterialColors.COSMO_BLACK);
        table.put("InternalFrame.activeTitleForeground", MaterialColors.BLACK);
        table.put("InternalFrame.inactiveTitleBackground", MaterialColors.COSMO_BLACK);
        table.put("InternalFrame.inactiveTitleForeground", MaterialColors.BLACK);
        table.put("InternalFrame.titleFont", theme.getFontBold());
        table.put("InternalFrame.background", MaterialColors.LIGHT_BLUE_500);
        table.put("InternalFrame.border", MaterialBorders.DEFAULT_SHADOW_BORDER);

        table.put("Material.activeCaption", theme.getBackgroundPrimary());
        table.put("Material.inactiveCaption",theme.getBackgroundPrimary());
        table.put("Material.activeCaptionText", theme.getTextColor());
        table.put("Material.inactiveCaptionText", MaterialColors.GRAY_700);
        table.put("Material.activeCaptionBorder", MaterialBorders.LIGHT_LINE_BORDER);
        table.put("Material.inactiveCaptionBorder", MaterialBorders.LIGHT_LINE_BORDER);

        table.put("OptionPane.background", theme.getBackgroundPrimary());
        table.put("OptionPane.border", BorderFactory.createEmptyBorder());
        table.put("OptionPane.font", MaterialFontFactory.getInstance().getFont(MaterialFontFactory.REGULAR));
        table.put("OptionPane.enableIcon", false);
        table.put("OptionPaneUI.warningIcon", new ImageIcon(MaterialImageFactory.getInstance().getImage(MaterialImageFactory.WARNING)));
        table.put("OptionPaneUI.errorIcon", new ImageIcon(MaterialImageFactory.getInstance().getImage(MaterialImageFactory.ERROR)));
        table.put("OptionPaneUI.questionIcon", new ImageIcon(MaterialImageFactory.getInstance().getImage(MaterialImageFactory.QUESTION)));
        table.put("OptionPaneUI.informationIcon", new ImageIcon(MaterialImageFactory.getInstance().getImage(MaterialImageFactory.INFORMATION)));
        table.put("OptionPane.errorDialog.titlePane.background", theme.getBackgroundPrimary());
        table.put("OptionPane.errorDialog.titlePane.foreground", theme.getTextColor());
        table.put("OptionPane.errorDialog.titlePane.shadow", MaterialColors.COSMO_STRONG_GRAY);
        table.put("OptionPane.questionDialog.titlePane.background", theme.getBackgroundPrimary());
        table.put("OptionPane.questionDialog.titlePane.foreground", theme.getTextColor());
        table.put("OptionPane.questionDialog.titlePane.shadow", MaterialColors.COSMO_STRONG_GRAY);
        table.put("OptionPane.warningDialog.titlePane.background", theme.getBackgroundPrimary());
        table.put("OptionPane.warningDialog.titlePane.foreground", theme.getTextColor());
        table.put("OptionPane.warningDialog.titlePane.shadow", MaterialColors.COSMO_STRONG_GRAY);

        table.put("FileChooser[icons].computer", new ImageIcon(MaterialImageFactory.getInstance().getImage(MaterialImageFactory.COMPUTER_BLACK)));
        table.put("FileChooser[icons].directory", new ImageIcon(MaterialImageFactory.getInstance().getImage(MaterialImageFactory.FOLDER_BLACK)));
        table.put("FileChooser[icons].file", new ImageIcon(MaterialImageFactory.getInstance().getImage(MaterialImageFactory.FILE_BLACK)));
        table.put("FileChooser[icons].floppyDrive", new ImageIcon(MaterialImageFactory.getInstance().getImage(MaterialImageFactory.FLOPPY_DRIVE_BLACK)));
        table.put("FileChooser[icons].hardDrive", new ImageIcon(MaterialImageFactory.getInstance().getImage(MaterialImageFactory.HARD_DRIVE_BLACK)));
        table.put("FileChooser[icons].home", new ImageIcon(MaterialImageFactory.getInstance().getImage(MaterialImageFactory.HOME_BLACK)));
        table.put("FileChooser[icons].list", new ImageIcon(MaterialImageFactory.getInstance().getImage(MaterialImageFactory.LIST_BLACK)));
        table.put("FileChooser[icons].details", new ImageIcon(MaterialImageFactory.getInstance().getImage(MaterialImageFactory.DETAILS_BLACK)));
        table.put("FileChooser[icons].newFolder", new ImageIcon(MaterialImageFactory.getInstance().getImage(MaterialImageFactory.NEW_FOLDER_BLACK)));
        table.put("FileChooser[icons].upFolder", new ImageIcon(MaterialImageFactory.getInstance().getImage(MaterialImageFactory.BACK_ARROW_BLACK)));

        table.put("ProgressBar.border", MaterialBorders.LIGHT_LINE_BORDER);
        table.put("ProgressBar.background", MaterialColors.COSMO_LIGTH_BLUE);
        table.put("ProgressBar.foreground", MaterialColors.COSMO_BLUE);
        //table.put("ProgressBar.horizontalSize", MaterialColors.COSMO_BLUE);
        table.put("ProgressBar.verticalSize", 1);
    }

    @Override
    public UIDefaults getDefaults() {
        try {
            final Method superMethod = BasicLookAndFeel.class.getDeclaredMethod("getDefaults");
            superMethod.setAccessible(true);
            final UIDefaults defaults = (UIDefaults) superMethod.invoke(basicLookAndFeel);
            initClassDefaults(defaults);
            initComponentDefaults(defaults);
            theme.installTheme();
            defaults.put("OptionPane.warningIcon", new ImageIcon(MaterialImageFactory.getInstance().getImage(MaterialImageFactory.WARNING)));
            defaults.put("OptionPane.errorIcon", new ImageIcon(MaterialImageFactory.getInstance().getImage(MaterialImageFactory.ERROR)));
            defaults.put("OptionPane.questionIcon", new ImageIcon(MaterialImageFactory.getInstance().getImage(MaterialImageFactory.QUESTION)));
            defaults.put("OptionPane.informationIcon", new ImageIcon(MaterialImageFactory.getInstance().getImage(MaterialImageFactory.INFORMATION)));
            return defaults;
        } catch (Exception ignore) {
            //do nothing
            ignore.printStackTrace();
        }
        return super.getDefaults();
    }

    @Override
    public void uninitialize() {
        call("uninitialize");
    }


    public MaterialTheme getTheme() {
        return theme;
    }

    public void setTheme(MaterialTheme theme) {
        this.theme = theme;
    }

    public static int getFocusAcceleratorKeyMask() {
        Toolkit tk = Toolkit.getDefaultToolkit();
        if (tk instanceof SunToolkit) {
            return ((SunToolkit) tk).getFocusAcceleratorKeyMask();
        }
        return ActionEvent.ALT_MASK;
    }

    protected void call(String method) {
        try {
            final Method superMethod = BasicLookAndFeel.class.getDeclaredMethod(method);
            superMethod.setAccessible(true);
            superMethod.invoke(basicLookAndFeel);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /*Shortcut for filed input*/
    Object fieldInputMap = new UIDefaults.LazyInputMap(new Object[]{
            "ctrl C", DefaultEditorKit.copyAction,
            "ctrl V", DefaultEditorKit.pasteAction,
            "ctrl X", DefaultEditorKit.cutAction,
            "COPY", DefaultEditorKit.copyAction,
            "PASTE", DefaultEditorKit.pasteAction,
            "CUT", DefaultEditorKit.cutAction,
            "control INSERT", DefaultEditorKit.copyAction,
            "shift INSERT", DefaultEditorKit.pasteAction,
            "shift DELETE", DefaultEditorKit.cutAction,
            "shift LEFT", DefaultEditorKit.selectionBackwardAction,
            "shift KP_LEFT", DefaultEditorKit.selectionBackwardAction,
            "shift RIGHT", DefaultEditorKit.selectionForwardAction,
            "shift KP_RIGHT", DefaultEditorKit.selectionForwardAction,
            "ctrl LEFT", DefaultEditorKit.previousWordAction,
            "ctrl KP_LEFT", DefaultEditorKit.previousWordAction,
            "ctrl RIGHT", DefaultEditorKit.nextWordAction,
            "ctrl KP_RIGHT", DefaultEditorKit.nextWordAction,
            "ctrl shift LEFT", DefaultEditorKit.selectionPreviousWordAction,
            "ctrl shift KP_LEFT", DefaultEditorKit.selectionPreviousWordAction,
            "ctrl shift RIGHT", DefaultEditorKit.selectionNextWordAction,
            "ctrl shift KP_RIGHT", DefaultEditorKit.selectionNextWordAction,
            "ctrl A", DefaultEditorKit.selectAllAction,
            "HOME", DefaultEditorKit.beginLineAction,
            "END", DefaultEditorKit.endLineAction,
            "shift HOME", DefaultEditorKit.selectionBeginLineAction,
            "shift END", DefaultEditorKit.selectionEndLineAction,
            "BACK_SPACE", DefaultEditorKit.deletePrevCharAction,
            "shift BACK_SPACE", DefaultEditorKit.deletePrevCharAction,
            "ctrl H", DefaultEditorKit.deletePrevCharAction,
            "DELETE", DefaultEditorKit.deleteNextCharAction,
            "ctrl DELETE", DefaultEditorKit.deleteNextWordAction,
            "ctrl BACK_SPACE", DefaultEditorKit.deletePrevWordAction,
            "RIGHT", DefaultEditorKit.forwardAction,
            "LEFT", DefaultEditorKit.backwardAction,
            "KP_RIGHT", DefaultEditorKit.forwardAction,
            "KP_LEFT", DefaultEditorKit.backwardAction,
            "ENTER", JTextField.notifyAction,
            "ctrl BACK_SLASH", "unselect"/*DefaultEditorKit.unselectAction*/,
            "control shift O", "toggle-componentOrientation"/*DefaultEditorKit.toggleComponentOrientation*/
    });


    /*Shortcut for multiline input*/
    Object multilineInputMap = new UIDefaults.LazyInputMap(new Object[]{
            "ctrl C", DefaultEditorKit.copyAction,
            "ctrl V", DefaultEditorKit.pasteAction,
            "ctrl X", DefaultEditorKit.cutAction,
            "COPY", DefaultEditorKit.copyAction,
            "PASTE", DefaultEditorKit.pasteAction,
            "CUT", DefaultEditorKit.cutAction,
            "control INSERT", DefaultEditorKit.copyAction,
            "shift INSERT", DefaultEditorKit.pasteAction,
            "shift DELETE", DefaultEditorKit.cutAction,
            "shift LEFT", DefaultEditorKit.selectionBackwardAction,
            "shift KP_LEFT", DefaultEditorKit.selectionBackwardAction,
            "shift RIGHT", DefaultEditorKit.selectionForwardAction,
            "shift KP_RIGHT", DefaultEditorKit.selectionForwardAction,
            "ctrl LEFT", DefaultEditorKit.previousWordAction,
            "ctrl KP_LEFT", DefaultEditorKit.previousWordAction,
            "ctrl RIGHT", DefaultEditorKit.nextWordAction,
            "ctrl KP_RIGHT", DefaultEditorKit.nextWordAction,
            "ctrl shift LEFT", DefaultEditorKit.selectionPreviousWordAction,
            "ctrl shift KP_LEFT", DefaultEditorKit.selectionPreviousWordAction,
            "ctrl shift RIGHT", DefaultEditorKit.selectionNextWordAction,
            "ctrl shift KP_RIGHT", DefaultEditorKit.selectionNextWordAction,
            "ctrl A", DefaultEditorKit.selectAllAction,
            "HOME", DefaultEditorKit.beginLineAction,
            "END", DefaultEditorKit.endLineAction,
            "shift HOME", DefaultEditorKit.selectionBeginLineAction,
            "shift END", DefaultEditorKit.selectionEndLineAction,

            "UP", DefaultEditorKit.upAction,
            "KP_UP", DefaultEditorKit.upAction,
            "DOWN", DefaultEditorKit.downAction,
            "KP_DOWN", DefaultEditorKit.downAction,
            "PAGE_UP", DefaultEditorKit.pageUpAction,
            "PAGE_DOWN", DefaultEditorKit.pageDownAction,
            "shift PAGE_UP", "selection-page-up",
            "shift PAGE_DOWN", "selection-page-down",
            "ctrl shift PAGE_UP", "selection-page-left",
            "ctrl shift PAGE_DOWN", "selection-page-right",
            "shift UP", DefaultEditorKit.selectionUpAction,
            "shift KP_UP", DefaultEditorKit.selectionUpAction,
            "shift DOWN", DefaultEditorKit.selectionDownAction,
            "shift KP_DOWN", DefaultEditorKit.selectionDownAction,
            "ENTER", DefaultEditorKit.insertBreakAction,
            "BACK_SPACE", DefaultEditorKit.deletePrevCharAction,
            "shift BACK_SPACE", DefaultEditorKit.deletePrevCharAction,
            "ctrl H", DefaultEditorKit.deletePrevCharAction,
            "DELETE", DefaultEditorKit.deleteNextCharAction,
            "ctrl DELETE", DefaultEditorKit.deleteNextWordAction,
            "ctrl BACK_SPACE", DefaultEditorKit.deletePrevWordAction,
            "RIGHT", DefaultEditorKit.forwardAction,
            "LEFT", DefaultEditorKit.backwardAction,
            "KP_RIGHT", DefaultEditorKit.forwardAction,
            "KP_LEFT", DefaultEditorKit.backwardAction,
            "TAB", DefaultEditorKit.insertTabAction,
            "ctrl BACK_SLASH", "unselect"/*DefaultEditorKit.unselectAction*/,
            "ctrl HOME", DefaultEditorKit.beginAction,
            "ctrl END", DefaultEditorKit.endAction,
            "ctrl shift HOME", DefaultEditorKit.selectionBeginAction,
            "ctrl shift END", DefaultEditorKit.selectionEndAction,
            "ctrl T", "next-link-action",
            "ctrl shift T", "previous-link-action",
            "ctrl SPACE", "activate-link-action",
            "control shift O", "toggle-componentOrientation"/*DefaultEditorKit.toggleComponentOrientation*/
    });
}
