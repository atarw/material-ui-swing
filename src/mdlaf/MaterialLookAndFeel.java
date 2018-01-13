package mdlaf;

import mdlaf.button.MaterialButtonUI;
import mdlaf.textfield.MaterialTextFieldUI;

import javax.swing.BorderFactory;
import javax.swing.UIDefaults;
import javax.swing.border.Border;
import javax.swing.plaf.basic.BasicLookAndFeel;
import java.awt.Color;

public class MaterialLookAndFeel extends BasicLookAndFeel {

	private static final String buttonUI = MaterialButtonUI.class.getCanonicalName ();
	private static final String textfieldUI = MaterialTextFieldUI.class.getCanonicalName ();

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
	}

	@Override
	protected void initSystemColorDefaults (UIDefaults table) {
		super.initSystemColorDefaults (table);
	}

	@Override
	protected void initComponentDefaults (UIDefaults table) {
		super.initComponentDefaults (table);

		table.put ("Button.font", MaterialFonts.MEDIUM);
		table.put ("RadioButton.font", MaterialFonts.LIGHT);
		table.put ("CheckBox.font", MaterialFonts.LIGHT);
		table.put ("ComboBox.font", MaterialFonts.LIGHT);
		table.put ("Label.font", MaterialFonts.LIGHT);
		table.put ("MenuBar.font", MaterialFonts.BOLD);
		table.put ("MenuItem.font", MaterialFonts.MEDIUM);
		table.put ("Menu.font", MaterialFonts.BOLD);
		table.put ("OptionPane.font", MaterialFonts.LIGHT);
		table.put ("Panel.font", MaterialFonts.LIGHT);
		table.put ("ScrollPane.font", MaterialFonts.LIGHT);
		table.put ("Table.font", MaterialFonts.LIGHT);
		table.put ("TableHeader.font", MaterialFonts.LIGHT);
		table.put ("TextField.font", MaterialFonts.MEDIUM);
		table.put ("TextArea.font", MaterialFonts.MEDIUM);

		Border menuBorder = new DropShadowBorder (Color.BLACK, 0, 5, 0.3f, 12, true, true, true, true);
		Border defaultBorder = new DropShadowBorder (Color.BLACK, 5, 5, 0.3f, 12, true, true, true, true);

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
		table.put ("MenuBar.border", menuBorder);

		table.put ("SplitPane.border", BorderFactory.createEmptyBorder ());
		table.put ("SplitPane.background", Color.WHITE);
		table.put ("SplitPane.dividerSize", 5);
		table.put ("SplitPaneDivider.border", BorderFactory.createEmptyBorder ());

		table.put ("ScrollPane.background", Color.WHITE);
		table.put ("ScrollPane.border", BorderFactory.createEmptyBorder ());

		table.put ("TextField.background", MaterialColors.LIGHT_BLUE);

		table.put ("TextArea.background", MaterialColors.LIGHT_GRAY);
		table.put ("TextArea.border", BorderFactory.createEmptyBorder ());
		table.put ("TextArea.foreground", Color.BLACK);

		table.put ("OptionPane.background", Color.WHITE);
		table.put ("OptionPane.border", defaultBorder);

		table.put ("Button.background", MaterialColors.LIGHT_BLUE);
		table.put ("Button.foreground", Color.WHITE);
		table.put ("Button.highlight", MaterialColors.LIGHT_GRAY);
		//table.put ("Button.border", BorderFactory.createEmptyBorder (10, 10, 10, 10));
	}
}
