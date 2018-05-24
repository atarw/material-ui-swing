package mdlaf;

import mdlaf.button.MaterialButtonUI;
import mdlaf.password.MaterialPasswordFieldUI;
import mdlaf.table.MaterialTableHeaderUI;
import mdlaf.table.MaterialTableUI;
import mdlaf.textfield.MaterialTextFieldUI;

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

	@Override

	public String getName () {
		return "mdlaf.MaterialLookAndFeel";
	}

	@Override
	public String getID () {
		return "mdlaf.MaterialLookAndFeel";
	}

	@Override
	public String getDescription () {
		return "A modern, Material Design UI for Java Swing";
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
	}

	@Override
	protected void initSystemColorDefaults (UIDefaults table) {
		super.initSystemColorDefaults (table);
	}

	@Override
	protected void initComponentDefaults (UIDefaults table) {
		super.initComponentDefaults (table);

		System.setProperty ("awt.useSystemAAFontSettings", "on");
		System.setProperty ("swing.aatext", "true");
		System.setProperty ("sun.java2d.xrender", "true");

		table.put ("RadioButton.font", MaterialFonts.REGULAR);
		table.put ("CheckBox.font", MaterialFonts.REGULAR);
		table.put ("ComboBox.font", MaterialFonts.REGULAR);
		table.put ("Label.font", MaterialFonts.REGULAR);
		table.put ("MenuBar.font", MaterialFonts.BOLD);
		table.put ("MenuItem.font", MaterialFonts.MEDIUM);
		table.put ("Menu.font", MaterialFonts.BOLD);
		table.put ("OptionPane.font", MaterialFonts.REGULAR);
		table.put ("Panel.font", MaterialFonts.REGULAR);
		table.put ("ScrollPane.font", MaterialFonts.REGULAR);
		table.put ("TextArea.font", MaterialFonts.REGULAR);

		table.put ("Panel.background", Color.WHITE);
		table.put ("Panel.border", BorderFactory.createEmptyBorder ());

		table.put ("MenuItem.background", Color.WHITE);
		table.put ("MenuItem.border", BorderFactory.createEmptyBorder (5, 5, 5, 5));
		table.put ("MenuItem.disabledForeground", new Color (0, 0, 0, 100));
		table.put ("MenuItem.selectionBackground", MaterialColors.LIGHT_GRAY);
		table.put ("MenuItem.selectionForeground", Color.BLACK);
		table.put ("MenuItem.foreground", Color.BLACK);

		table.put ("PopupMenu.border", BorderFactory.createLineBorder (MaterialColors.LIGHT_GRAY, 1));
		table.put ("PopupMenu.background", Color.WHITE);

		table.put ("Menu.border", BorderFactory.createEmptyBorder (5, 5, 5, 5));
		table.put ("Menu.selectionBackground", MaterialColors.LIGHT_GRAY);
		table.put ("Menu.selectionForeground", Color.BLACK);
		table.put ("Menu.disabledForeground", new Color (0, 0, 0, 100));
		table.put ("Menu.background", Color.WHITE);
		table.put ("Menu.foreground", Color.BLACK);
		table.put ("Menu.opaque", true);
		table.put ("Menu.menuPopupOffsetY", 10);

		table.put ("MenuBar.background", Color.WHITE);
		table.put ("MenuBar.border", MaterialBorders.LIGHT_SHADOW_BORDER);

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
