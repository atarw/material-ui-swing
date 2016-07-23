import javax.swing.Timer;
import javax.swing.JComponent;

import java.awt.Color;

import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionListener;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;

public class MaterialUIMovement {
  
  private Color fadeColor; // color to fade to
  private int steps; // number of steps to fade into fadeColor
  private int interval; // timer interval
  private Map <Color, List <Color>> backgroundColors = new HashMap <Color, List <Color>> ();
  
  private List <Color> getColors (Color background)
  {
    List <Color> o = backgroundColors.get (background);
    
    if (o != null) {
      return o;
    }
    
    List <Color> colors = new ArrayList <Color> (steps + 1);
    colors.add (background);
    
    int rDelta = (background.getRed () - fadeColor.getRed ()) / steps;
    int gDelta = (background.getGreen () - fadeColor.getGreen ()) / steps;
    int bDelta = (background.getBlue () - fadeColor.getBlue ()) / steps;
    int aDelta = (background.getAlpha () - fadeColor.getAlpha ()) / steps;
    
    for (int i = 1; i < steps; i++) {
      int rValue = background.getRed () - (i * rDelta);
      int gValue = background.getGreen () - (i * gDelta);
      int bValue = background.getBlue () - (i * bDelta);
      int aValue = background.getAlpha () - (i * aDelta);
      
      colors.add (new Color (rValue, gValue, bValue, aValue));
    }
    
    colors.add (fadeColor);
    backgroundColors.put (background, colors);
    
    return colors;
  }
  
  public MaterialUIMovement (Color fadeColor, int steps, int interval)
  {
    this.fadeColor = fadeColor;
    this.steps = steps;
    this.interval = interval;
  }
  
  public MaterialUIMovement add (JComponent component)
  {
    List <Color> colors = getColors (component.getBackground ());
    new MaterialUITimer (colors, component, interval);
    
    return this;
  }
  
  private class MaterialUITimer implements MouseListener /*, FocusListener*/, ActionListener {
    
    private List <Color> colors;
    private JComponent component;
    private Timer timer;
    private int alpha;
    private int increment;
    
    public void mousePressed (MouseEvent me) {
      alpha = steps;
      increment = -1;
      timer.start ();
      
      alpha = 0;
      increment = 1;
      timer.start ();
    }
    
    public void mouseReleased (MouseEvent me) {
      
    }
    
    public void mouseClicked (MouseEvent me) {
      
    }
    
    public void mouseExited (MouseEvent me) {
      alpha = steps;
      increment = -1;
      
      timer.start ();
    }
    
    public void mouseEntered (MouseEvent me) {
      alpha = 0;
      increment = 1;
      
      timer.start ();
    }
    
    public void actionPerformed(ActionEvent e) {
      alpha += increment;
      
      component.setBackground (colors.get (alpha));
      
      if (alpha == steps || alpha == 0) {
        timer.stop ();
      }
    }
    
    MaterialUITimer (List <Color> colors, JComponent component, int interval) {
      this.colors = colors;
      this.component = component;
      
      component.addMouseListener (this);
      timer = new Timer (interval, this);
    }
  }
}