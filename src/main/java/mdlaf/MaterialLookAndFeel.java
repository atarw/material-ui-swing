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

import mdlaf.components.colorchooser.MaterialColorChooser;
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
import javax.swing.plaf.basic.BasicLookAndFeel;
import javax.swing.plaf.metal.MetalLookAndFeel;
import javax.swing.text.DefaultEditorKit;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.lang.reflect.Method;

/**
 * @author https://github.com/vincenzopalazzo
 * @author https://github.com/atarw
 */
public class MaterialLookAndFeel extends MetalLookAndFeel {

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
	private static final String colorChooserUI = MaterialColorChooser.class.getCanonicalName();
	//TODO not allineated this component with master
	private static final String splitPaneUI = MaterialSplitPaneUI.class.getCanonicalName();

	public static void changeTheme(MaterialTheme theme) {
		if (theme == null) {
			throw new IllegalArgumentException("Theme null");
		}
		BasicLookAndFeel blaf = (BasicLookAndFeel) UIManager.getLookAndFeel();
		if (blaf instanceof MaterialLookAndFeel) {
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
		table.put("ColorChooserUI", colorChooserUI);
		// java swingx
		table.put("swingx/TaskPaneUI", taskPaneUI);
	}

	@Override
	protected void initComponentDefaults(UIDefaults table) {
		super.initComponentDefaults(table);

		//The shadow on JButton is not active because the shadow effect I don't like me
		table.put("Button.highlight", theme.getButtonColorHighlight());
		table.put("Button.opaque", theme.getOpaqueButton());
		table.put("Button.background", theme.getButtonBackgroundColor());
		table.put("Button.border", theme.getButtonBorder());
		table.put("Button.arc", theme.getArcButton());
		table.put("Button.foreground", theme.getButtonTextColor());
		table.put("Button[Default].background", theme.getButtonDefaultBackgroundColor());
		table.put("Button[Default].foreground", theme.getButtonDefaultTextColor());
		table.put("Button.disabledBackground", theme.getButtonDisabledBackground());
		table.put("Button.disabledForeground", theme.getButtonDisabledForeground());
		table.put("Button.font", theme.getButtonFont());
		table.put("Button[Default].mouseHoverColor", theme.getButtonDefaultBackgroundColorMouseHover());
		table.put("Button.mouseHoverColor", theme.getButtonBackgroundColorMouseHover());
		table.put("Button.mouseHoverEnable", theme.getMouseHoverButtonEnable());
		table.put("Button.mouseHoverBorder", false); //if is true -> the mouse hover effect change the color to OnlyBorder, if false to all button
		table.put("Button.focusable", theme.getButtonFocusable());
		table.put("Button[focus].color", theme.getButtonFocusColor());
		table.put("Button.disabledText", theme.getButtonDisableTextColor());
		table.put("Button[Default].shadowPixel", 3);
		table.put("Button[Default].shadowEnable", false);
		table.put("Button[Default][focus].color", theme.getButtonDefaultFocusColor());
		table.put("Button[border].enable", theme.getButtonBorderEnable());
		table.put("Button[border].color", theme.getButtonBorderColor());
		table.put("Button[border].toAll", theme.getButtonBorderEnableToAll()); //if is true -> the border do have all button if if false the border do have only button without icon

		table.put("CheckBox.font", theme.getFontRegular());
		table.put("CheckBox.background", theme.getBackgroundPrimary());
		table.put("CheckBox.foreground", theme.getTextColor());
		table.put("CheckBox.disabledText", theme.getDisableTextColor());
		table.put("CheckBox.icon", theme.getUnselectedCheckBoxIcon());
		table.put("CheckBox.selectedIcon", theme.getSelectedCheckBoxIcon());

		table.put("ComboBox.font", theme.getFontRegular());
		table.put("ComboBox.background", theme.getBackgroundPrimary());
		table.put("ComboBox.foreground", theme.getTextColor());
		table.put("ComboBox.border", theme.getBorderComboBox());
		table.put("ComboBox.borderItems", new BorderUIResource(BorderFactory.createEmptyBorder(1, 2, 0, 1)));
		table.put("ComboBox.buttonBackground", theme.getBackgroundPrimary());
		table.put("ComboBox[button].border", BorderFactory.createLineBorder(theme.getBackgroundPrimary()));
		table.put("ComboBox.disabledBackground", theme.getBackgroundPrimary());
		table.put("ComboBox.disabledForeground", theme.getDisableTextColor());
		table.put("ComboBox.selectionBackground", theme.getBackgroundPrimary());
		table.put("ComboBox.selectionForeground", theme.getTextColor());
		table.put("ComboBox[item].selectionForeground", theme.getSelectedForegroundComboBox());
		table.put("ComboBox.selectedInDropDownBackground", theme.getSelectedInDropDownBackgroundComboBox());
		table.put("ComboBox.mouseHoverColor", theme.getButtonBackgroundColorMouseHover());
		table.put("ComboBox.unfocusColor", theme.getTextColor());
		table.put("ComboBox.focusColor", theme.getHighlightBackgroundPrimary());
		table.put("ComboBox.mouseHoverEnabled", theme.getMouseHoverEnableComboBox());
		table.put("ComboBox.arc", theme.getArchBorderComboBox());
		table.put("ComboBox.focusable", theme.getFocusableComboBox());
		table.put("ComboBox.lightWeightPopupEnabled", theme.getLightWeightPopupEnabledComboBox());

		table.put("Label.font", theme.getFontRegular());
		table.put("Label.background", theme.getBackgroundPrimary());
		table.put("Label.foreground", theme.getTextColor());
		table.put("Label.opaque", true);
		table.put("Label.disabledForeground", theme.getDisableTextColor());
		table.put("Label.border", new BorderUIResource(BorderFactory.createEmptyBorder()));

		table.put("Menu.font", theme.getFontRegular());
		table.put("Menu.border", theme.getBorderMenu());
		table.put("Menu.background", theme.getMenuBackground());
		table.put("Menu.foreground", theme.getMenuTextColor());
		table.put("Menu.opaque", true);
		table.put("Menu.selectionBackground", theme.getMenuBackgroundMouseHover());
		table.put("Menu.selectionForeground", theme.getMenuTextColor());
		table.put("Menu.disabledForeground", theme.getMenuDisableBackground());
		table.put("Menu.acceleratorSelectionForeground", theme.getMenuTextColor());
		table.put("Menu.menuPopupOffsetY", 3);
		table.put("Menu[MouseOver].enable", theme.getMouseHoverEnableMenu());
		table.put("Menu.arrowIcon", theme.getMenuArrowIcon());
		table.put("Menu[arrowIcon].hoverColor", theme.getMenuArrowHoverColor());
		table.put("Menu[arrowIcon].color", theme.getMenuTextColor());
		table.put("Menu[arrowIcon].height", theme.getMenuArrowHeight());
		table.put("Menu[arrowIcon].width", theme.getMenuArrowWidth());

		table.put("MenuBar.font", MaterialFontFactory.getInstance().getFont(MaterialFontFactory.BOLD));
		table.put("MenuBar.background", theme.getMenuBackground());
		table.put("MenuBar.border", theme.getBorderMenuBar());
		table.put("MenuBar.foreground", theme.getMenuTextColor());

		table.put("MenuItem.disabledForeground", theme.getDisableTextColor());
		table.put("MenuItem.selectionBackground", theme.getMenuBackgroundMouseHover());
		table.put("MenuItem.selectionForeground", theme.getTextColor());
		table.put("MenuItem.font", theme.getFontRegular());
		table.put("MenuItem.background", theme.getMenuBackground());
		table.put("MenuItem.foreground", theme.getMenuTextColor());
		table.put("MenuItem.border", theme.getBorderMenu());
		//table.put("MenuItem.arrowIcon", MaterialImageFactory.getInstance().getImage(MaterialImageFactory.FILE_WHITE));

		table.put("Panel.font", theme.getFontRegular());
		table.put("Panel.background", theme.getBackgroundPrimary());
		table.put("Panel.border", theme.getBorderPanel());

		table.put("PopupMenu.border", theme.getBorderPopupMenu());
		table.put("PopupMenu.background", theme.getBackgroundPrimary());
		table.put("PopupMenu.foreground", theme.getTextColor());

		table.put("RadioButton.font", theme.getFontRegular());
		table.put("RadioButton.background", theme.getBackgroundPrimary());
		table.put("RadioButton.foreground", theme.getTextColor());
		table.put("RadioButton.icon", theme.getUnselectedRadioButtonIcon());
		table.put("RadioButton.selectedIcon", theme.getSelectedRadioButtonIcon());
		table.put("RadioButton.disabledText", theme.getDisableTextColor());

		table.put("Spinner.font", theme.getFontRegular());
		table.put("Spinner.background", theme.getBackgroundPrimary());
		table.put("Spinner.foreground", theme.getTextColor());
		table.put("Spinner.border", theme.getBorderSpinner());
		table.put("Spinner.arrowButtonBackground", theme.getArrowButtonBackgroundSpinner());
		table.put("Spinner.arrowButtonBorder", theme.getArrowButtonBorderSpinner());
		table.put("Spinner.mouseHoverEnabled", theme.getMouseHoverEnableSpinner());
		table.put("Spinner.mouseHoverColor", theme.getMouseHoverButtonColorSpinner());

		table.put("ScrollBar.font", theme.getFontRegular());
		table.put("ScrollBar.track", theme.getTrackColorScrollBar());
		table.put("ScrollBar.thumb", theme.getThumbColorScrollBar());
		table.put("ScrollBar.thumbDarkShadow", theme.getThumbDarkShadowColorScrollBar());
		table.put("ScrollBar.thumbHighlight", theme.getThumbHighlightColorScrollBar());
		table.put("ScrollBar.thumbShadow", theme.getThumbShadowColorScrollBar());
		table.put("ScrollBar.arrowButtonBackground", theme.getArrowButtonOnClickColorScrollBar());
		table.put("ScrollBar.enableArrow", theme.getEnableArrowScrollBar());
		table.put("ScrollBar.arrowButtonBorder", theme.getArrowButtonBorderScrollBar());
		table.put("ScrollBar.width", 14);
		table.put("ScrollBar[MouseHover].enable", theme.getMouseHoverEnableScrollBar());
		table.put("ScrollBar[MouseHover].color", theme.getMouseHoverColorScrollBar());
		//table.put("ScrollBar[MouseHover].color", theme.getButtonBackgroundColorMouseHover());
		table.put("ScrollBar[OnClick].color", theme.getArrowButtonOnClickColorScrollBar());

		table.put("ScrollPane.background", theme.getBackgroundPrimary());
		table.put("ScrollPane.border", theme.getBorderPanel());
		table.put("ScrollPane.font", theme.getFontRegular());

		table.put("Slider.font", theme.getFontRegular());
		table.put("Slider.background", theme.getBackgroundPrimary());
		table.put("Slider.foreground", theme.getHighlightBackgroundPrimary());
		table.put("Slider.trackColor", theme.getTrackColorSlider());
		table.put("Slider[halo].color", theme.getHaloColorSlider());
		table.put("Slider.border", theme.getBorderSlider());

		table.put("SplitPane.border", theme.getBorderPanel());
		table.put("SplitPane.background", theme.getBackgroundPrimary());
		table.put("SplitPane.dividerSize", 5);
		table.put("SplitPaneDivider.border", new BorderUIResource(BorderFactory.createEmptyBorder()));
		table.put("SplitPaneDivider.background", theme.getBackgroundPrimary());

		table.put("TabbedPane.font", theme.getFontRegular());
		table.put("TabbedPane.background", theme.getBackgroundPrimary());
		table.put("TabbedPane.tabAreaBackground", theme.getBackgroundPrimary());
		table.put("TabbedPane.foreground", theme.getTextColor());
		table.put("TabbedPane.selectionForeground", theme.getFocusColorLineTabbedPane());
		table.put("TabbedPane.contentAreaColor", theme.getButtonTextColor());
		table.put("TabbedPane.disableContentAreaColor", theme.getDisableColorTabTabbedPane());
		table.put("TabbedPane.border", theme.getBorderPanel());
		table.put("TabbedPane.shadow", theme.getBackgroundPrimary());
		table.put("TabbedPane.darkShadow", theme.getBackgroundPrimary());
		table.put("TabbedPane.highlight", theme.getDisableTextColor());
		table.put("TabbedPane.selected", theme.getTextColor());
		table.put("TabbedPane.light", theme.getBackgroundPrimary());
		table.put("TabbedPane.borderHighlightColor", theme.getBorderHighlightColorTabbedPane());
		table.put("TabbedPane[focus].colorLine", theme.getFocusColorLineTabbedPane());
		table.put("TabbedPane[MouseHover].enable", theme.getMouseHoverEnableTabbedPane());
		table.put("TabbedPane.spacer", theme.getSpacerTabbedPane());
		table.put("TabbedPane.indent", theme.getIndentTabbedPane());
		table.put("TabbedPane.tabInsets", theme.getTabInsetsTabbedPane());
		table.put("TabbedPane.selectedTabPadInsets", theme.getSelectedTabInsetsTabbedPane());
		table.put("TabbedPane.linePositionY", theme.getLinePositionYTabbedPane());
		table.put("TabbedPane.linePositionX", theme.getLinePositionXTabbedPane());
		table.put("TabbedPane.lineWidth", theme.getLineWithTabbedPane());
		table.put("TabbedPane.lineHeight", theme.getLineHeightTabbedPane());
		table.put("TabbedPane.lineArch", theme.getLineArchTabbedPane());

		table.put("Table.selectionBackground", theme.getSelectionBackgroundTable());
		table.put("Table.selectionForeground", theme.getSelectionForegroundTable());
		table.put("Table.background", theme.getBackgroundTable());
		table.put("Table.foreground", theme.getForegroundTable());
		table.put("Table.font", theme.getFontRegular());
		table.put("Table.border", theme.getBorderTable());
		table.put("Table.gridColor", theme.getGridColorTable());
		table.put("Table.focusable", theme.getTableFocusable());
		table.put("Table.opaque", theme.getTableOpaque());
		table.put("Table.alternateRowColor", theme.getAlternateRowColorEnableTable());
		table.put("Table.alternateRowBackground", theme.getAlternateRowBackgroundTable());
		table.put("Table[row].height", theme.getHeightRowTable());
		table.put("Table[CheckBox].checked", theme.getSelectedCheckBoxIconTable());
		table.put("Table[CheckBox].unchecked", theme.getUnselectedCheckBoxIconTable());
		table.put("Table[CheckBox].selectionChecked", theme.getSelectedCheckBoxIconSelectionRowTable());
		table.put("Table[CheckBox].selectionUnchecked", theme.getUnselectedCheckBoxIconSelectionRowTable());
		table.put("Table.focusCellHighlightBorder", new BorderUIResource(BorderFactory.createEmptyBorder()));

		table.put("TableHeader.background", theme.getBackgroundTableHeader());
		table.put("TableHeader.foreground", theme.getForegroundTableHeader());
		table.put("TableHeader.border", theme.getBorderTableHeader());
		table.put("TableHeader.font", theme.getFontBold());
		table.put("TableHeader.cellBorder", theme.getCellBorderTableHeader());

		table.put("TextArea.background", theme.getBackgroundTextField());
		table.put("TextArea.border", theme.getBorderTextField());
		table.put("TextArea.selectionBackground", theme.getSelectionBackgroundTextField());
		table.put("TextArea.selectionForeground", theme.getSelectionForegroundTextField());
		table.put("TextArea.foreground", theme.getTextColor());
		table.put("TextArea.font", theme.getFontBold());

		table.put("ToggleButton.border", BorderFactory.createEmptyBorder());
		table.put("ToggleButton.font", theme.getFontRegular());
		table.put("ToggleButton.background", theme.getBackgroundPrimary());
		table.put("ToggleButton.select", theme.getHighlightBackgroundPrimary());
		table.put("ToggleButton.foreground", theme.getTextColor());
		table.put("ToggleButton.disabledText", theme.getDisableTextColor());
		table.put("ToggleButton.icon", MaterialImageFactory.getInstance().getImage(MaterialImageFactory.TOGGLE_BUTTON_BLACK_OFF));
		table.put("ToggleButton.selectedIcon", MaterialImageFactory.getInstance().getImage(MaterialImageFactory.TOGGLE_BUTTON_BLACK_ON));

		table.put("ToolBar.font", theme.getFontRegular());
		table.put("ToolBar.background", theme.getBackgroundPrimary());
		table.put("ToolBar.foreground", theme.getTextColor());
		table.put("ToolBar.border", theme.getBorderToolBar());
		table.put("ToolBar.dockingBackground", theme.getDockingBackgroundToolBar());
		table.put("ToolBar.floatingBackground", theme.getFloatingBackgroundToolBar());

		table.put("Tree.font", theme.getFontRegular());
		table.put("Tree.selectionForeground", theme.getHighlightBackgroundPrimary());
		table.put("Tree.foreground", theme.getTextColor());
		table.put("Tree.selectionBackground", theme.getSelectionBackgroundTree());
		table.put("Tree.background", theme.getBackgroundPrimary());
		table.put("Tree.selectionBorderColor", theme.getSelectionBorderColorTree());
		table.put("Tree.collapsedIcon", null);
		table.put("Tree.expandedIcon", null);
		table.put("Tree.closedIcon", theme.getClosedIconTree());
		table.put("Tree.openIcon", theme.getOpenIconTree());
		table.put("Tree.leafIcon", null);

		table.put("RadioButtonMenuItem.foreground", theme.getTextColor());
		table.put("RadioButtonMenuItem.selectionForeground", theme.getTextColor());
		table.put("RadioButtonMenuItem.background", theme.getMenuBackground());
		table.put("RadioButtonMenuItem.selectionBackground", theme.getMenuBackgroundMouseHover());
		table.put("RadioButtonMenuItem.border", theme.getBorderMenu());
		table.put("RadioButtonMenuItem.checkIcon", theme.getUnselectedRadioButtonIcon());
		table.put("RadioButtonMenuItem.selectedCheckIcon", theme.getSelectedRadioButtonIcon());

		table.put("CheckBoxMenuItem.background", theme.getMenuBackground());
		table.put("CheckBoxMenuItem.selectionBackground", theme.getMenuBackgroundMouseHover());
		table.put("CheckBoxMenuItem.foreground", theme.getTextColor());
		table.put("CheckBoxMenuItem.selectionForeground", theme.getTextColor());
		table.put("CheckBoxMenuItem.border", theme.getBorderMenu());
		table.put("CheckBoxMenuItem.checkIcon", theme.getUnselectedCheckBoxIconTable());
		table.put("CheckBoxMenuItem.selectedCheckIcon", theme.getSelectedCheckBoxIconTable());

		table.put("TextPane.border", theme.getBorderPanel());
		table.put("TextPane.background", theme.getBackgroundTextField());
		table.put("TextPane.foreground", theme.getTextColor());
		table.put("TextPane.selectionBackground", theme.getHighlightBackgroundPrimary());
		table.put("TextPane.inactiveForeground", theme.getDisableTextColor());
		table.put("TextPane.font", theme.getFontItalic());
		table.put("TextPane.focusInputMap", multilineInputMap);

		table.put("EditorPane.border", theme.getBorderPanel());
		table.put("EditorPane.background", theme.getBackgroundTextField());
		table.put("EditorPane.foreground", theme.getTextColor());
		table.put("EditorPane.selectionBackground", theme.getSelectionBackgroundTextField());
		table.put("EditorPane.inactiveForeground", theme.getSelectionForegroundTextField());
		table.put("EditorPane.font", theme.getFontRegular());
		table.put("EditorPane.focusInputMap", multilineInputMap);

		table.put("Separator.background", MaterialColors.GRAY_300);
		table.put("Separator.foreground", MaterialColors.GRAY_300);

		table.put("ToolTip.background", MaterialColors.GRAY_500);
		table.put("ToolTip.foreground", MaterialColors.GRAY_50);
		table.put("ToolTip.border", BorderFactory.createEmptyBorder(5, 5, 5, 5));

		table.put("TextField.background", theme.getBackgroundTextField());
		table.put("TextField.foreground", theme.getTextColor());
		table.put("TextField.font", theme.getFontRegular());
		table.put("TextField.inactiveForeground", theme.getInactiveForegroundTextField());
		table.put("TextField.inactiveBackground", theme.getInactiveBackgroundTextField());
		table.put("TextField.selectionBackground", theme.getSelectionBackgroundTextField());
		table.put("TextField.selectionForeground", theme.getSelectionForegroundTextField());
		table.put("TextField[Line].inactiveColor", theme.getInactiveColorLineTextField());
		table.put("TextField[Line].activeColor", theme.getActiveColorLineTextField());
		table.put("TextField.border", theme.getBorderTextField());
		table.put("TextField.focusInputMap", fieldInputMap);

		table.put("PasswordField.background", theme.getBackgroundTextField());
		table.put("PasswordField.foreground", theme.getTextColor());
		table.put("PasswordField.inactiveForeground", theme.getInactiveForegroundTextField());
		table.put("PasswordField.inactiveBackground", theme.getInactiveBackgroundTextField());
		table.put("PasswordField.selectionBackground", theme.getSelectionBackgroundTextField());
		table.put("PasswordField.selectionForeground", theme.getSelectionForegroundTextField());
		table.put("PasswordField[Line].inactiveColor", theme.getInactiveColorLineTextField());
		table.put("PasswordField[Line].activeColor", theme.getActiveColorLineTextField());
		table.put("PasswordField.border", theme.getBorderTextField());
		table.put("PasswordField.echoChar", theme.getEchoCharPasswordField());
		table.put("PasswordField.focusInputMap", fieldInputMap);

		table.put("TitledBorder.border", MaterialBorders.LIGHT_LINE_BORDER);
		table.put("TitledBorder.font", theme.getFontMedium());

		table.put("TaskPane.font", theme.getFontMedium());
		table.put("TaskPane.titleBackgroundGradientStart", theme.getTitleBackgroundGradientStartTaskPane());
		table.put("TaskPane.titleBackgroundGradientEnd", theme.getTitleBackgroundGradientEndTaskPane());
		table.put("TaskPane.titleOver", theme.getTitleOverTaskPane());
		table.put("TaskPane.specialTitleOver", theme.getSpecialTitleOverTaskPane());
		table.put("TaskPane.background", theme.getBackgroundTaskPane());
		table.put("TaskPane.foreground", theme.getTextColor());
		table.put("TaskPane.borderColor", theme.getBorderColorTaskPane());
		table.put("TaskPane.border", theme.getBorderTaskPane());
		table.put("TaskPane.contentBackground", theme.getContentBackgroundTaskPane());
		table.put("TaskPane.yesCollapsed", theme.getYesCollapsedTaskPane());
		table.put("TaskPane.noCollapsed", theme.getNoCollapsedTaskPane());

		table.put("FormattedTextField.background", theme.getBackgroundTextField());
		table.put("FormattedTextField.foreground", theme.getTextColor());
		table.put("FormattedTextField.inactiveForeground", theme.getInactiveForegroundTextField());
		table.put("FormattedTextField.inactiveBackground", theme.getInactiveBackgroundTextField());
		table.put("FormattedTextField.selectionBackground", theme.getSelectionBackgroundTextField());
		table.put("FormattedTextField.selectionForeground", theme.getSelectionForegroundTextField());
		table.put("FormattedTextField.border", theme.getBorderTextField());

		table.put("List.background", theme.getBackgroundPrimary());
		table.put("List.foreground", theme.getTextColor());
		table.put("List.border", MaterialBorders.LIGHT_SHADOW_BORDER);
		table.put("List.font", theme.getFontMedium());
		table.put("List.selectionBackground", theme.getSelectionBackgroundList());
		table.put("List.selectionForeground", theme.getSelectionForegroundList());
		table.put("List.focusCellHighlightBorder", theme.getFocusCellHighlightBorder());
		table.put("List[item].border", theme.getBorderItemList());
		table.put("List.focusable", true);

		table.put("RootPane.frameBorder", theme.getBorderFrameRootPane());
		table.put("RootPane.background", theme.getBackgroundPrimary());
		table.put("RootPane.plainDialogBorder", theme.getBorderDialogRootPane());
		table.put("RootPane.informationDialogBorder", theme.getBorderDialogRootPane());
		table.put("RootPane.errorDialogBorder", theme.getBorderDialogRootPane());
		table.put("RootPane.fileChooserDialogBorder", theme.getBorderDialogRootPane());
		table.put("RootPane.questionDialogBorder", theme.getBorderDialogRootPane());
		table.put("RootPane.warningDialogBorder", theme.getBorderDialogRootPane());
		table.put("RootPane.colorChooserDialogBorder", theme.getBackgroundPrimary());

		//TODO not supported yet
		//TODO exist an bug inside the icon
		table.put("InternalFrame.maximizeIcon", MaterialImageFactory.getInstance().getImage(MaterialImageFactory.MAXIMIZE_WINDOWS_WHITE));
		table.put("InternalFrame.minimizeIcon", MaterialImageFactory.getInstance().getImage(MaterialImageFactory.MINIMIZE_WINDOWS_WHITE));
		table.put("InternalFrame.closeIcon", MaterialImageFactory.getInstance().getImage(MaterialImageFactory.CLOSE_WINDOWS_WHITE));
		table.put("InternalFrame.iconifyIcon", MaterialImageFactory.getInstance().getImage(MaterialImageFactory.ICONIFY_WINDOWS_WHITE));
		table.put("InternalFrame.activeTitleBackground", MaterialColors.COSMO_BLACK);
		table.put("InternalFrame.activeTitleForeground", MaterialColors.BLACK);
		table.put("InternalFrame.inactiveTitleBackground", MaterialColors.COSMO_BLACK);
		table.put("InternalFrame.inactiveTitleForeground", MaterialColors.BLACK);
		table.put("InternalFrame.titleFont", theme.getFontBold());
		table.put("InternalFrame.background", MaterialColors.LIGHT_BLUE_500);
		table.put("InternalFrame.border", MaterialBorders.DEFAULT_SHADOW_BORDER);

		//This is for change the TitlePane
		table.put("Material.activeCaption", theme.getMenuBackground());
		table.put("Material.inactiveCaption", theme.getMenuBackground());
		table.put("Material.activeCaptionText", theme.getTextColor());
		table.put("Material.inactiveCaptionText", theme.getDisableTextColor());
		table.put("Material.activeCaptionBorder", MaterialBorders.LIGHT_LINE_BORDER);
		table.put("Material.inactiveCaptionBorder", MaterialBorders.LIGHT_LINE_BORDER);

		table.put("OptionPane.background", theme.getBackgroundPrimary());
		table.put("OptionPane.foreground", theme.getTextColor());
		table.put("OptionPane.border", BorderFactory.createEmptyBorder());
		table.put("OptionPane.font", theme.getFontRegular());
		table.put("OptionPane.enableIcon", theme.getEnableIconOptionPane());
		table.put("OptionPaneUI.warningIcon", theme.getWarningIconOptionPane());
		table.put("OptionPaneUI.errorIcon", theme.getErrorIconIconOptionPane());
		table.put("OptionPaneUI.questionIcon", theme.getQuestionIconOptionPane());
		table.put("OptionPaneUI.informationIcon", theme.getInformationIconOptionPane());
		table.put("OptionPane.errorDialog.titlePane.background", theme.getBackgroundPrimary());
		table.put("OptionPane.errorDialog.titlePane.foreground", theme.getTextColor());
		table.put("OptionPane.errorDialog.titlePane.shadow", MaterialColors.COSMO_STRONG_GRAY);
		table.put("OptionPane.questionDialog.titlePane.background", theme.getBackgroundPrimary());
		table.put("OptionPane.questionDialog.titlePane.foreground", theme.getTextColor());
		table.put("OptionPane.questionDialog.titlePane.shadow", MaterialColors.COSMO_STRONG_GRAY);
		table.put("OptionPane.warningDialog.titlePane.background", theme.getBackgroundPrimary());
		table.put("OptionPane.warningDialog.titlePane.foreground", theme.getTextColor());
		table.put("OptionPane.warningDialog.titlePane.shadow", MaterialColors.COSMO_STRONG_GRAY);
		table.put("OptionPane.messageForeground", theme.getTextColor());

		table.put("FileChooser[icons].computer", theme.getIconComputerFileChooser());
		table.put("FileChooser[icons].directory", theme.getIconDirectoryFileChooser());
		table.put("FileChooser[icons].file", theme.getIconFileFileChooser());
		table.put("FileChooser[icons].floppyDrive", theme.getIconFloppyDriveFileChooser());
		table.put("FileChooser[icons].hardDrive", theme.getIconHardDriveFileChooser());
		table.put("FileChooser[icons].home", theme.getIconHomeFileChooser());
		table.put("FileChooser[icons].list", theme.getIconListFileChooser());
		table.put("FileChooser[icons].details", theme.getIconDetailsFileChooser());
		table.put("FileChooser[icons].newFolder", theme.getIconNewFolderFileChooser());
		table.put("FileChooser[icons].upFolder", theme.getIconUpFolderFileChooser());

		table.put("ProgressBar.border", theme.getBorderProgressBar());
		table.put("ProgressBar.background", theme.getBackgroundProgressBar());
		table.put("ProgressBar.foreground", theme.getForegroundProgressBar());
		//table.put("ProgressBar.horizontalSize", MaterialColors.COSMO_BLUE);
		table.put("ProgressBar.verticalSize", 1);

		table.put("ColorChooser.background", theme.getBackgroundPrimary());
		table.put("ColorChooser.foreground", theme.getTextColor());
		table.put("ColorChooser.border", theme.getBorderPanel());

		theme.installUIDefault(table);
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
			defaults.put("OptionPane.warningIcon", MaterialImageFactory.getInstance().getImage(MaterialImageFactory.WARNING));
			defaults.put("OptionPane.errorIcon", MaterialImageFactory.getInstance().getImage(MaterialImageFactory.ERROR));
			defaults.put("OptionPane.questionIcon", MaterialImageFactory.getInstance().getImage(MaterialImageFactory.QUESTION));
			defaults.put("OptionPane.informationIcon", MaterialImageFactory.getInstance().getImage(MaterialImageFactory.INFORMATION));
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
