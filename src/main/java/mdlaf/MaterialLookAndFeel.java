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
import mdlaf.components.textfield.MaterialTextFieldUI;
import mdlaf.components.textpane.MaterialTextPaneUI;
import mdlaf.components.togglebutton.MaterialToggleButtonUI;
import mdlaf.components.toolbar.MaterialToolBarUI;
import mdlaf.components.tooltip.MaterialToolTipUI;
import mdlaf.components.tree.MaterialTreeUI;
import mdlaf.utils.MaterialBorders;
import mdlaf.utils.MaterialColors;
import mdlaf.utils.MaterialFonts;
import mdlaf.utils.MaterialImages;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.UIDefaults;
import javax.swing.UIManager;
import javax.swing.plaf.metal.MetalLookAndFeel;
import java.awt.Color;

public class MaterialLookAndFeel extends MetalLookAndFeel {

	private static final String buttonUI = MaterialButtonUI.class.getCanonicalName ();
	private static final String textfieldUI = MaterialTextFieldUI.class.getCanonicalName ();
	private static final String passwordFieldUI = MaterialPasswordFieldUI.class.getCanonicalName ();
	private static final String tableUI = MaterialTableUI.class.getCanonicalName ();
	private static final String tableHeaderUI = MaterialTableHeaderUI.class.getCanonicalName ();
	private static final String treeUI = MaterialTreeUI.class.getCanonicalName ();
	private static final String spinnerUI = MaterialSpinnerUI.class.getCanonicalName ();
	private static final String panelUI = MaterialPanelUI.class.getCanonicalName ();
	private static final String labelUI = MaterialLabelUI.class.getCanonicalName ();
	private static final String menuItemUI = MaterialMenuItemUI.class.getCanonicalName ();
	private static final String menuBarUI = MaterialMenuBarUI.class.getCanonicalName ();
	private static final String menuUI = MaterialMenuUI.class.getCanonicalName ();
	private static final String checkBoxUI = MaterialCheckBoxUI.class.getCanonicalName ();
	private static final String radioButtonUI = MaterialRadioButtonUI.class.getCanonicalName ();
	private static final String tabbedPaneUI = MaterialTabbedPaneUI.class.getCanonicalName ();
	private static final String toggleButtonUI = MaterialToggleButtonUI.class.getCanonicalName ();
	private static final String scrollBarUI = MaterialScrollBarUI.class.getCanonicalName ();
	private static final String comboBoxUI = MaterialComboBoxUI.class.getCanonicalName ();
	private static final String popupMenuUI = MaterialPopupMenuUI.class.getCanonicalName ();
	private static final String toolbarUI = MaterialToolBarUI.class.getCanonicalName ();
	private static final String sliderUI = MaterialSliderUI.class.getCanonicalName ();
	private static final String progressBarUI = MaterialProgressBarUI.class.getCanonicalName ();
	private static final String radioButtonMenuItemUI = MaterialRadioButtonMenuItemUI.class.getCanonicalName ();
	private static final String checkBoxMenuItemUI = MaterialCheckBoxMenuItemUI.class.getCanonicalName ();
	private static final String textPaneUI = MaterialTextPaneUI.class.getCanonicalName ();
	private static final String editorPane = MaterialTextPaneUI.class.getCanonicalName ();
	private static final String separatorUI = MaterialSeparatorUI.class.getCanonicalName ();
	private static final String fileChooserUI = MaterialFileChooserUI.class.getCanonicalName ();
	private static final String toolTipUI = MaterialToolTipUI.class.getCanonicalName ();

	@Override
	public String getName () {
		return "Material Look And Feel";
	}

	@Override
	public String getID () {
		return "MaterialLookAndFeel";
	}

	@Override
	public String getDescription () {
		return "A modern Material Design UI for Java Swing";
	}

	@Override
	public boolean isNativeLookAndFeel () {
		return false;
	}

	@Override
	public boolean isSupportedLookAndFeel () {
		return true;
	}

	@Override
	protected void initClassDefaults (UIDefaults table) {
		super.initClassDefaults (table);
		table.put ("ButtonUI", buttonUI);
		table.put ("TextFieldUI", textfieldUI);
		table.put ("PasswordFieldUI", passwordFieldUI);
		table.put ("TableUI", tableUI);
		table.put ("TableHeaderUI", tableHeaderUI);
		table.put ("TreeUI", treeUI);
		table.put ("SpinnerUI", spinnerUI);
		table.put ("PanelUI", panelUI);
		table.put ("LabelUI", labelUI);
		table.put ("MenuItemUI", menuItemUI);
		table.put ("MenuBarUI", menuBarUI);
		table.put ("MenuUI", menuUI);
		table.put ("CheckBoxUI", checkBoxUI);
		table.put ("RadioButtonUI", radioButtonUI);
		table.put ("TabbedPaneUI", tabbedPaneUI);
		table.put ("ToggleButtonUI", toggleButtonUI);
		table.put ("ScrollBarUI", scrollBarUI);
		table.put ("ComboBoxUI", comboBoxUI);
		table.put ("PopupMenuUI", popupMenuUI);
		table.put ("ToolBarUI", toolbarUI);
		table.put ("SliderUI", sliderUI);
		table.put ("ProgressBarUI", progressBarUI);
		table.put ("RadioButtonMenuItemUI", radioButtonMenuItemUI);
		table.put ("CheckBoxMenuItemUI", checkBoxMenuItemUI);
		table.put ("TextPaneUI", textPaneUI);
		table.put ("EditorPaneUI", editorPane);
		table.put ("SeparatorUI", separatorUI);
		table.put ("FileChooserUI", fileChooserUI);
		table.put ("ToolTipUI", toolTipUI);
	}

	@Override
	protected void initComponentDefaults (UIDefaults table) {
		super.initComponentDefaults (table);

		table.put ("Button.highlight", MaterialColors.GRAY_200);
		table.put ("Button.opaque", true);
		table.put ("Button.border", BorderFactory.createEmptyBorder (7, 17, 7, 17));
		table.put ("Button.background", MaterialColors.WHITE);
		table.put ("Button.foreground", Color.BLACK);
		table.put ("Button.font", MaterialFonts.MEDIUM);

		table.put ("CheckBox.font", MaterialFonts.REGULAR);
		table.put ("CheckBox.background", Color.WHITE);
		table.put ("CheckBox.foreground", Color.BLACK);
		table.put ("CheckBox.icon", new ImageIcon (MaterialImages.UNCHECKED_BOX));
		table.put ("CheckBox.selectedIcon", new ImageIcon (MaterialImages.PAINTED_CHECKED_BOX));

		table.put ("ComboBox.font", MaterialFonts.REGULAR);
		table.put ("ComboBox.background", Color.WHITE);
		table.put ("ComboBox.foreground", Color.BLACK);
		table.put ("ComboBox.border", BorderFactory.createCompoundBorder (MaterialBorders.LIGHT_LINE_BORDER, BorderFactory.createEmptyBorder (0, 5, 0, 0)));
		table.put ("ComboBox.buttonBackground", MaterialColors.GRAY_300);
		table.put ("ComboBox.selectionBackground", Color.WHITE);
		table.put ("ComboBox.selectionForeground", Color.BLACK);
		table.put ("ComboBox.selectedInDropDownBackground", MaterialColors.GRAY_200);

		table.put ("Label.font", MaterialFonts.REGULAR);
		table.put ("Label.background", Color.WHITE);
		table.put ("Label.foreground", Color.BLACK);
		table.put ("Label.border", BorderFactory.createEmptyBorder ());

		table.put ("Menu.font", MaterialFonts.BOLD);
		table.put ("Menu.border", BorderFactory.createEmptyBorder (5, 5, 5, 5));
		table.put ("Menu.background", Color.WHITE);
		table.put ("Menu.foreground", Color.BLACK);
		table.put ("Menu.opaque", true);
		table.put ("Menu.selectionBackground", MaterialColors.GRAY_200);
		table.put ("Menu.selectionForeground", Color.BLACK);
		table.put ("Menu.disabledForeground", new Color (0, 0, 0, 100));
		table.put ("Menu.menuPopupOffsetY", 3);

		table.put ("MenuBar.font", MaterialFonts.BOLD);
		table.put ("MenuBar.background", Color.WHITE);
		table.put ("MenuBar.border", MaterialBorders.LIGHT_SHADOW_BORDER);
		table.put ("MenuBar.foreground", Color.BLACK);

		table.put ("MenuItem.disabledForeground", new Color (0, 0, 0, 100));
		table.put ("MenuItem.selectionBackground", MaterialColors.GRAY_200);
		table.put ("MenuItem.selectionForeground", Color.BLACK);
		table.put ("MenuItem.font", MaterialFonts.MEDIUM);
		table.put ("MenuItem.background", Color.WHITE);
		table.put ("MenuItem.foreground", Color.BLACK);
		table.put ("MenuItem.border", BorderFactory.createEmptyBorder (5, 0, 5, 0));

		table.put ("OptionPane.background", Color.WHITE);
		table.put ("OptionPane.border", MaterialBorders.DEFAULT_SHADOW_BORDER);
		table.put ("OptionPane.font", MaterialFonts.REGULAR);

		table.put ("Panel.font", MaterialFonts.REGULAR);
		table.put ("Panel.background", Color.WHITE);
		table.put ("Panel.border", BorderFactory.createEmptyBorder ());

		table.put ("PopupMenu.border", MaterialBorders.LIGHT_LINE_BORDER);
		table.put ("PopupMenu.background", Color.WHITE);
		table.put ("PopupMenu.foreground", Color.BLACK);

		table.put ("RadioButton.font", MaterialFonts.REGULAR);
		table.put ("RadioButton.background", Color.WHITE);
		table.put ("RadioButton.foreground", Color.BLACK);
		table.put ("RadioButton.icon", new ImageIcon (MaterialImages.RADIO_BUTTON_OFF));
		table.put ("RadioButton.selectedIcon", new ImageIcon (MaterialImages.RADIO_BUTTON_ON));

		table.put ("Spinner.font", MaterialFonts.REGULAR);
		table.put ("Spinner.background", Color.WHITE);
		table.put ("Spinner.foreground", Color.BLACK);
		table.put ("Spinner.border", MaterialBorders.LIGHT_LINE_BORDER);
		table.put ("Spinner.arrowButtonBackground", MaterialColors.GRAY_200);
		table.put ("Spinner.arrowButtonBorder", BorderFactory.createEmptyBorder ());

		table.put ("ScrollBar.font", MaterialFonts.REGULAR);
		table.put ("ScrollBar.track", MaterialColors.GRAY_200);
		table.put ("ScrollBar.thumb", MaterialColors.GRAY_300);
		table.put ("ScrollBar.thumbDarkShadow", MaterialColors.GRAY_300);
		table.put ("ScrollBar.thumbHighlight", MaterialColors.GRAY_300);
		table.put ("ScrollBar.thumbShadow", MaterialColors.GRAY_300);
		table.put ("ScrollBar.arrowButtonBackground", MaterialColors.GRAY_300);
		table.put ("ScrollBar.arrowButtonBorder", BorderFactory.createEmptyBorder ());

		table.put ("ScrollPane.background", Color.WHITE);
		table.put ("ScrollPane.border", BorderFactory.createEmptyBorder ());
		table.put ("ScrollPane.font", MaterialFonts.REGULAR);

		table.put ("Slider.font", MaterialFonts.REGULAR);
		table.put ("Slider.background", Color.WHITE);
		table.put ("Slider.foreground", MaterialColors.LIGHT_BLUE_400);
		table.put ("Slider.trackColor", Color.BLACK);
		table.put ("Slider.border", BorderFactory.createCompoundBorder (MaterialBorders.LIGHT_LINE_BORDER, BorderFactory.createEmptyBorder (20, 20, 20, 20)));

		table.put ("SplitPane.border", BorderFactory.createEmptyBorder ());
		table.put ("SplitPane.background", Color.WHITE);
		table.put ("SplitPane.dividerSize", 5);
		table.put ("SplitPaneDivider.border", BorderFactory.createEmptyBorder ());

		table.put ("TabbedPane.font", MaterialFonts.REGULAR);
		table.put ("TabbedPane.background", Color.WHITE);
		table.put ("TabbedPane.foreground", Color.BLACK);
		table.put ("TabbedPane.border", BorderFactory.createEmptyBorder ());
		table.put ("TabbedPane.shadow", null);
		table.put ("TabbedPane.darkShadow", null);
		table.put ("TabbedPane.highlight", MaterialColors.GRAY_200);
		table.put ("TabbedPane.borderHighlightColor", MaterialColors.GRAY_300);

		table.put ("Table.selectionBackground", MaterialColors.GRAY_100);
		table.put ("Table.selectionForeground", Color.BLACK);
		table.put ("Table.background", Color.WHITE);
		table.put ("Table.font", MaterialFonts.REGULAR);
		table.put ("Table.border", MaterialBorders.LIGHT_LINE_BORDER);
		table.put ("Table.gridColor", MaterialColors.GRAY_200);
		table.put ("TableHeader.background", MaterialColors.GRAY_200);
		table.put ("TableHeader.font", MaterialFonts.BOLD);
		table.put ("TableHeader.cellBorder", BorderFactory.createCompoundBorder (MaterialBorders.LIGHT_LINE_BORDER, BorderFactory.createEmptyBorder (5, 5, 5, 5)));

		table.put ("TextArea.background", MaterialColors.GRAY_200);
		table.put ("TextArea.border", BorderFactory.createEmptyBorder ());
		table.put ("TextArea.foreground", Color.BLACK);

		table.put ("TextField.inactiveForeground", MaterialColors.GRAY_800);
		table.put ("TextField.inactiveBackground", MaterialColors.GRAY_200);
		table.put ("TextField.selectionBackground", MaterialColors.LIGHT_BLUE_400);
		table.put ("TextField.selectionForeground", Color.BLACK);

		table.put ("ToggleButton.border", BorderFactory.createEmptyBorder ());
		table.put ("ToggleButton.font", MaterialFonts.REGULAR);
		table.put ("ToggleButton.background", Color.WHITE);
		table.put ("ToggleButton.foreground", Color.BLACK);
		table.put ("ToggleButton.icon", new ImageIcon (MaterialImages.TOGGLE_BUTTON_OFF));
		table.put ("ToggleButton.selectedIcon", new ImageIcon (MaterialImages.TOGGLE_BUTTON_ON));

		table.put ("ToolBar.font", MaterialFonts.REGULAR);
		table.put ("ToolBar.background", Color.WHITE);
		table.put ("ToolBar.foreground", Color.BLACK);
		table.put ("ToolBar.border", MaterialBorders.LIGHT_SHADOW_BORDER);
		table.put ("ToolBar.dockingBackground", MaterialColors.LIGHT_GREEN_A100);
		table.put ("ToolBar.floatingBackground", MaterialColors.GRAY_200);

		table.put ("Tree.font", MaterialFonts.REGULAR);
		table.put ("Tree.selectionForeground", Color.BLACK);
		table.put ("Tree.foreground", Color.BLACK);
		table.put ("Tree.selectionBackground", MaterialColors.GRAY_200);
		table.put ("Tree.background", Color.WHITE);
		table.put ("Tree.closedIcon", new ImageIcon (MaterialImages.RIGHT_ARROW));
		table.put ("Tree.openIcon", new ImageIcon (MaterialImages.DOWN_ARROW));
		table.put ("Tree.selectionBorderColor", null);

		table.put ("RadioButtonMenuItem.foreground", Color.BLACK);
		table.put ("RadioButtonMenuItem.selectionForeground", Color.BLACK);
		//If it changes the background of the menuitem it must change this too, irrespective of its setting
		table.put ("RadioButtonMenuItem.background", UIManager.getColor ("MenuItem.background"));
		table.put ("RadioButtonMenuItem.selectionBackground", MaterialColors.GRAY_200);
		table.put ("RadioButtonMenuItem.border", BorderFactory.createEmptyBorder (5, 5, 5, 5));
		table.put ("RadioButtonMenuItem.checkIcon", new ImageIcon (MaterialImages.RADIO_BUTTON_OFF));
		table.put ("RadioButtonMenuItem.selectedCheckIcon", new ImageIcon (MaterialImages.RADIO_BUTTON_ON));

		//If it changes the background of the menuitem it must change this too, irrespective of its setting
		table.put ("CheckBoxMenuItem.background", UIManager.getColor ("MenuItem.background"));
		table.put ("CheckBoxMenuItem.selectionBackground", MaterialColors.GRAY_200);
		table.put ("CheckBoxMenuItem.foreground", Color.BLACK);
		table.put ("CheckBoxMenuItem.selectionForeground", Color.BLACK);
		table.put ("CheckBoxMenuItem.border", BorderFactory.createEmptyBorder (5, 5, 5, 5));
		table.put ("CheckBoxMenuItem.checkIcon", new ImageIcon (MaterialImages.UNCHECKED_BOX));
		table.put ("CheckBoxMenuItem.selectedCheckIcon", new ImageIcon (MaterialImages.PAINTED_CHECKED_BOX));

		table.put ("TextPane.border", MaterialBorders.LIGHT_LINE_BORDER);
		table.put ("TextPane.background", MaterialColors.GRAY_50);
		table.put ("TextPane.selectionBackground", MaterialColors.LIGHT_BLUE_200);
		table.put ("TextPane.inactiveForeground", MaterialColors.GRAY_500);
		table.put ("TextPane.font", MaterialFonts.REGULAR);

		table.put ("EditorPane.border", MaterialBorders.LIGHT_LINE_BORDER);
		table.put ("EditorPane.background", MaterialColors.GRAY_50);
		table.put ("EditorPane.selectionBackground", MaterialColors.LIGHT_BLUE_200);
		table.put ("EditorPane.inactiveForeground", MaterialColors.GRAY_500);
		table.put ("EditorPane.font", MaterialFonts.REGULAR);

		table.put ("Separator.background", MaterialColors.GRAY_300);
		table.put ("Separator.foreground", MaterialColors.GRAY_300);

		table.put ("ToolTip.background", MaterialColors.GRAY_500);
		table.put ("ToolTip.foreground", MaterialColors.GRAY_50);
		table.put ("ToolTip.border", BorderFactory.createEmptyBorder (5, 5, 5, 5));

		table.put ("ColorChooser.background ", MaterialColors.WHITE);
		table.put ("ColorChooser.foreground ", MaterialColors.BLACK);
	}
}
