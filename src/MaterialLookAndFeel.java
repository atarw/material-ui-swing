import javax.swing.*;
import javax.swing.plaf.metal.*;

public class MaterialLookAndFeel extends MetalLookAndFeel {
  
  @Override
  public String getName () {
    return "Material Design";
  }
  
  @Override
  public String getID () {
    return "Material Design";
  }
  
  @Override
  public String getDescription () {
    return "A Material Design inspired Look and Feel by atharva washimkar";
  }
  
  @Override 
  public boolean getSupportsWindowDecorations () {
    return true;
  }
  
  @Override
  public boolean isNativeLookAndFeel () {
    return false;
  }
  
  @Override
  public boolean isSupportedLookAndFeel () {
    return true;
  }
  
  protected void initComponentDefaults (UIDefaults table) {
    super.initComponentDefaults (table);
  }
  
  public MaterialLookAndFeel (GUITheme theme) {
    super ();
    
    UIManager.put ("Button.font", theme.getBold ());
    UIManager.put("RadioButton.font", theme.getLight ());
    UIManager.put("CheckBox.font", theme.getLight ());
    UIManager.put("ComboBox.font", theme.getLight ());
    UIManager.put("Label.font", theme.getLight ());
    UIManager.put("MenuBar.font", theme.getBold ());
    UIManager.put("MenuItem.font", theme.getRegular ());
    UIManager.put("Menu.font", theme.getBold ());
    UIManager.put("OptionPane.font", theme.getLight ());
    UIManager.put("Panel.font", theme.getLight ());
    UIManager.put("ScrollPane.font", theme.getLight ());
    UIManager.put("Table.font", theme.getLight ());
    UIManager.put("TableHeader.font", theme.getLight ());
    UIManager.put("TextField.font", theme.getLight ());
    UIManager.put("TextArea.font", theme.getRegular ());
    
    UIManager.put ("Panel.background", theme.getCard ());
    UIManager.put ("Panel.border", BorderFactory.createEmptyBorder ());
    
    UIManager.put ("MenuItem.background", theme.getCard ());
    UIManager.put ("MenuItem.border", BorderFactory.createEmptyBorder ());
    UIManager.put ("MenuItem.disabledForeground", theme.getMenuDisabledText ());
    UIManager.put ("MenuItem.selectionBackground", theme.getMenuSelectionBackground ());
    UIManager.put("MenuItem.selectionForeground", theme.getMenuSelectionText ());
    UIManager.put ("MenuItem.foreground", theme.getMenuSelectionText ());
    
    UIManager.put("PopupMenu.border", BorderFactory.createLineBorder (theme.getMenuSelectionBackground (), 1));
    UIManager.put("PopupMenu.background", theme.getCard ());
    UIManager.put("Menu.border", BorderFactory.createEmptyBorder ());
    UIManager.put("Menu.selectionBackground", theme.getMenuSelectionBackground ());
    UIManager.put("Menu.selectionForeground", theme.getMenuSelectionText ());
    UIManager.put("Menu.disabledForeground", theme.getMenuDisabledText ());
    UIManager.put ("Menu.background", theme.getCard ());
    UIManager.put("Menu.foreground", theme.getMenuSelectionText ());
    UIManager.put("Menu.opaque", true);
    UIManager.put("Menu.menuPopupOffsetY", 10);
    
    UIManager.put("MenuBar.background", theme.getCard ());
    UIManager.put ("MenuBar.border", theme.getMenuBorder ());
    
    UIManager.put ("SplitPane.border", BorderFactory.createEmptyBorder ());
    UIManager.put ("SplitPane.background", theme.getCard ());
    UIManager.put ("SplitPane.dividerSize", 5);
    UIManager.put ("SplitPaneDivider.border", BorderFactory.createEmptyBorder ());
    
    UIManager.put ("ScrollPane.background", theme.getCard ());
    UIManager.put ("ScrollPane.border", BorderFactory.createEmptyBorder ());
    
    UIManager.put ("TextArea.background", theme.getInactiveTextbox ());
    UIManager.put ("TextArea.border", BorderFactory.createEmptyBorder ());
    UIManager.put ("TextArea.foreground", theme.getTextboxText ());
    
    UIManager.put ("OptionPane.background", theme.getCard ());
    UIManager.put ("OptionPane.border", theme.getDefaultBorder ());
    
    UIManager.put ("Button.background", theme.getInactiveBorderlessButtonBackground ());
    UIManager.put ("Button.foreground", theme.getBorderlessButtonText ());
    UIManager.put ("Button.highlight", theme.getActiveBorderlessButtonBackground ());
    UIManager.put ("Button.border", theme.getDefaultBorder ());
  }
}