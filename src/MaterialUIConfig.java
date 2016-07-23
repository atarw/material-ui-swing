import javax.swing.UIManager;
import javax.swing.BorderFactory;
import javax.swing.UnsupportedLookAndFeelException;

/*
All values below are configurable. To customize a certain UI component, replace the second parameter with the border, color, font, etc. object of your choosing.
There are more UIManager settings available not configured below. A complete list can be found here: http://alvinalexander.com/java/java-uimanager-color-keys-list

The values have been set to the default light theme. A dark theme is also available by default in the GUITheme class.

If you wish to use the default value for a certain setting, simply remove the line corresponding to
unwanted change.
*/

public class MaterialUIConfig {
  public static void configureUI () {
    UIManager.put ("Button.font", GUITheme.LIGHT_THEME.getBold ());
    UIManager.put("RadioButton.font", GUITheme.LIGHT_THEME.getLight ());
    UIManager.put("CheckBox.font", GUITheme.LIGHT_THEME.getLight ());
    UIManager.put("ComboBox.font", GUITheme.LIGHT_THEME.getLight ());
    UIManager.put("Label.font", GUITheme.LIGHT_THEME.getLight ());
    UIManager.put("MenuBar.font", GUITheme.LIGHT_THEME.getBold ());
    UIManager.put("MenuItem.font", GUITheme.LIGHT_THEME.getRegular ());
    UIManager.put("Menu.font", GUITheme.LIGHT_THEME.getBold ());
    UIManager.put("OptionPane.font", GUITheme.LIGHT_THEME.getLight ());
    UIManager.put("Panel.font", GUITheme.LIGHT_THEME.getLight ());
    UIManager.put("ScrollPane.font", GUITheme.LIGHT_THEME.getLight ());
    UIManager.put("Table.font", GUITheme.LIGHT_THEME.getLight ());
    UIManager.put("TableHeader.font", GUITheme.LIGHT_THEME.getLight ());
    UIManager.put("TextField.font", GUITheme.LIGHT_THEME.getLight ());
    UIManager.put("TextArea.font", GUITheme.LIGHT_THEME.getRegular ());

    UIManager.put ("Panel.background", GUITheme.LIGHT_THEME.getCard ());
    UIManager.put ("Panel.border", BorderFactory.createEmptyBorder ());

    UIManager.put ("MenuItem.background", GUITheme.LIGHT_THEME.getCard ());
    UIManager.put ("MenuItem.border", BorderFactory.createEmptyBorder ());
    UIManager.put ("MenuItem.disabledForeground", GUITheme.LIGHT_THEME.getMenuDisabledText ());
    UIManager.put ("MenuItem.selectionBackground", GUITheme.LIGHT_THEME.getMenuSelectionBackground ());
    UIManager.put("MenuItem.selectionForeground", GUITheme.LIGHT_THEME.getMenuSelectionText ());
    UIManager.put ("MenuItem.foreground", GUITheme.LIGHT_THEME.getMenuSelectionText ());

    UIManager.put("PopupMenu.border", BorderFactory.createLineBorder (GUITheme.LIGHT_THEME.getMenuSelectionBackground (), 1));
    UIManager.put("PopupMenu.background", GUITheme.LIGHT_THEME.getCard ());
    UIManager.put("Menu.border", BorderFactory.createEmptyBorder ());
    UIManager.put("Menu.selectionBackground", GUITheme.LIGHT_THEME.getMenuSelectionBackground ());
    UIManager.put("Menu.selectionForeground", GUITheme.LIGHT_THEME.getMenuSelectionText ());
    UIManager.put("Menu.disabledForeground", GUITheme.LIGHT_THEME.getMenuDisabledText ());
    UIManager.put ("Menu.background", GUITheme.LIGHT_THEME.getCard ());
    UIManager.put("Menu.foreground", GUITheme.LIGHT_THEME.getMenuSelectionText ());
    UIManager.put("Menu.opaque", true);
    UIManager.put("Menu.menuPopupOffsetY", 10);

    UIManager.put("MenuBar.background", GUITheme.LIGHT_THEME.getCard ());
    UIManager.put ("MenuBar.border", GUITheme.LIGHT_THEME.getMenuBorder ());

    UIManager.put ("SplitPane.border", BorderFactory.createEmptyBorder ());
    UIManager.put ("SplitPane.background", GUITheme.LIGHT_THEME.getCard ());
    UIManager.put ("SplitPane.dividerSize", 5);
    UIManager.put ("SplitPaneDivider.border", BorderFactory.createEmptyBorder ());

    UIManager.put ("ScrollPane.background", GUITheme.LIGHT_THEME.getCard ());
    UIManager.put ("ScrollPane.border", BorderFactory.createEmptyBorder ());

    UIManager.put ("TextArea.background", GUITheme.LIGHT_THEME.getInactiveTextbox ());
    UIManager.put ("TextArea.border", BorderFactory.createEmptyBorder ());
    UIManager.put ("TextArea.foreground", GUITheme.LIGHT_THEME.getTextboxText ());

    UIManager.put ("OptionPane.background", GUITheme.LIGHT_THEME.getCard ());
    UIManager.put ("OptionPane.border", GUITheme.LIGHT_THEME.getDefaultBorder ());

    UIManager.put ("Button.background", GUITheme.LIGHT_THEME.getInactiveBorderlessButtonBackground ());
    UIManager.put ("Button.foreground", GUITheme.LIGHT_THEME.getBorderlessButtonText ());
    UIManager.put ("Button.highlight", GUITheme.LIGHT_THEME.getActiveBorderlessButtonBackground ());
    UIManager.put ("Button.border", GUITheme.LIGHT_THEME.getDefaultBorder ());

    try {
      UIManager.setLookAndFeel (UIManager.getCrossPlatformLookAndFeelClassName ());
    }
    catch (UnsupportedLookAndFeelException e) {}
    catch (ClassNotFoundException e) {}
    catch (InstantiationException e) {}
    catch (IllegalAccessException e) {}
  }
}
