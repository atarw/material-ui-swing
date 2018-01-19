# material-ui-swing
A modern, Material Design UI for Java Swing

Skins JComponents to have a Material Design Look and Feel. Most components are responsive, with hover effects, and click effects (no ripple unfortunately). Fonts included.

Screenshot in action below (chessboard not included 😛):

![Screenshot](http://i.imgur.com/WsprAM6.png?1)

# Some Examples

````java
import mdlaf.*;
import javax.swing.*;
import java.awt.*;

public class MaterialUIDemo2 {

	public static void main (String[] args) {
		try {
			UIManager.setLookAndFeel (new MaterialLookAndFeel ());
		}
		catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace ();
		}

		JFrame frame = new JFrame ("Material Design UI for Swing by atharva washimkar");
		frame.setMinimumSize (new Dimension (600, 400));

		JButton button = new JButton ("PRESS ME");
		button.setMaximumSize (new Dimension (200, 200));

		JPanel content = new JPanel ();
		content.add (button);
		frame.add (content, BorderLayout.CENTER);

		MaterialUIMovement animate2 = new MaterialUIMovement (new Color (34, 167, 240), 5, 1000 / 30);
		animate2.add (button);

		frame.pack ();
		frame.setVisible (true);
	}
}
````

Check `src/MaterialUISwingDemo.java` for a slightly longer example of how to use this library (and an explanation of what everything means/does).
For a real-world example of usage, see [here](https://github.com/atarw/washer-chess).

# Misc

If there's a component that isn't supported, don't hesitate to open an issue! I can usually code something up for you in a couple of days 😀
