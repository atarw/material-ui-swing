import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.UIManager;

import java.awt.Color;

public class MaterialButton extends JButton {
  
  private MaterialUIMovement animate;
  
  private void configureSettings (Color background, Color foreground, Color hover) {
    this.setBackground (background);
    this.setForeground (foreground);
    
    animate = new MaterialUIMovement (hover, 5, 1000 / 30);
    animate.add (this);
    
    this.setFocusPainted (false);
    this.setUI (new MaterialButtonUI ());
  }
  
  public MaterialButton (String text) {
    this (text, UIManager.getColor ("Button.background"), UIManager.getColor ("Button.foreground"), UIManager.getColor ("Button.highlight"));
  }
  
  public MaterialButton (Icon icon) {
    this (icon, UIManager.getColor ("Button.background"), UIManager.getColor ("Button.foreground"), UIManager.getColor ("Button.highlight"));
  }
  
  public MaterialButton (Icon icon, Color background, Color foreground, Color hover) {
    super (icon);
    configureSettings (background, foreground, hover);
  }
  
  public MaterialButton (String text, Color background, Color foreground, Color hover) {
    super (text);
    configureSettings (background, foreground, hover);
  }
}