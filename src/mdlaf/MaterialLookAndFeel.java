package mdlaf;

import mdlaf.components.button.MaterialButtonUI;
import mdlaf.components.checkbox.MaterialCheckBoxUI;
import mdlaf.components.label.MaterialLabelUI;
import mdlaf.components.menu.MaterialMenuUI;
import mdlaf.components.menubar.MaterialMenuBarUI;
import mdlaf.components.menuitem.MaterialMenuItemUI;
import mdlaf.components.panel.MaterialPanelUI;
import mdlaf.components.password.MaterialPasswordFieldUI;
import mdlaf.components.spinner.MaterialSpinnerUI;
import mdlaf.components.table.MaterialTableHeaderUI;
import mdlaf.components.table.MaterialTableUI;
import mdlaf.components.textfield.MaterialTextFieldUI;
import mdlaf.components.tree.MaterialTreeUI;
import mdlaf.resources.MaterialBorders;
import mdlaf.resources.MaterialColors;
import mdlaf.resources.MaterialFonts;

import javax.swing.BorderFactory;
import javax.swing.UIDefaults;
import javax.swing.plaf.basic.BasicLookAndFeel;
import java.awt.Color;

public class MaterialLookAndFeel extends BasicLookAndFeel {

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
	}

	@Override
	protected void initSystemColorDefaults (UIDefaults table) {
		super.initSystemColorDefaults (table);
	}

	@Override
	protected void initComponentDefaults (UIDefaults table) {
		super.initComponentDefaults (table);

		table.put ("RadioButton.font", MaterialFonts.REGULAR);
		table.put ("ComboBox.font", MaterialFonts.REGULAR);
		table.put ("OptionPane.font", MaterialFonts.REGULAR);
		table.put ("ScrollPane.font", MaterialFonts.REGULAR);
		table.put ("TextArea.font", MaterialFonts.REGULAR);

		table.put ("MenuItem.disabledForeground", new Color (0, 0, 0, 100));
		table.put ("MenuItem.selectionBackground", MaterialColors.LIGHT_GRAY);
		table.put ("MenuItem.selectionForeground", Color.BLACK);

		table.put ("PopupMenu.border", BorderFactory.createLineBorder (MaterialColors.LIGHT_GRAY, 1));
		table.put ("PopupMenu.background", Color.WHITE);

		table.put ("Menu.selectionBackground", MaterialColors.LIGHT_GRAY);
		table.put ("Menu.selectionForeground", Color.BLACK);
		table.put ("Menu.disabledForeground", new Color (0, 0, 0, 100));
		table.put ("Menu.menuPopupOffsetY", 3);

		table.put ("SplitPane.border", BorderFactory.createEmptyBorder ());
		table.put ("SplitPane.background", Color.WHITE);
		table.put ("SplitPane.dividerSize", 5);
		table.put ("SplitPaneDivider.border", BorderFactory.createEmptyBorder ());

		table.put ("ScrollPane.background", Color.WHITE);
		table.put ("ScrollPane.border", BorderFactory.createEmptyBorder ());

		table.put ("TextArea.background", MaterialColors.LIGHT_GRAY);
		table.put ("TextArea.border", BorderFactory.createEmptyBorder ());
		table.put ("TextArea.foreground", Color.BLACK);

		table.put ("OptionPane.background", Color.WHITE);
		table.put ("OptionPane.border", MaterialBorders.DEFAULT_SHADOW_BORDER);

		table.put ("Button.highlight", MaterialColors.LIGHT_GRAY);
	}
}
