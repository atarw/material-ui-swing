import javax.swing.*;
import java.awt.*;

public class MaterialUISwingDemo {
  
  public static void main (String [] args) {
    MaterialLookAndFeel ui = new MaterialLookAndFeel (GUITheme.LIGHT_THEME);
    
    /*try {
     UIManager.setLookAndFeel (ui.getName ());
     }
     catch (UnsupportedLookAndFeelException e) {}
     catch (ClassNotFoundException e) {}
     catch (InstantiationException e) {}
     catch (IllegalAccessException e) {}*/
    
    JFrame frame = new JFrame ("Material Design UI for Swing by atharva washimkar");
    frame.setMinimumSize (new Dimension (300, 300));
    JButton button = new MaterialButton ("TEST");
    
    frame.add (button, BorderLayout.WEST);
    frame.setVisible (true);
  }
}