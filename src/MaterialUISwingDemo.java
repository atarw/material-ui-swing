import mdlaf.MaterialLookAndFeel;
import mdlaf.MaterialUIMovement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

public class MaterialUISwingDemo {

	public static void main (String[] args) {
		try {
			UIManager.setLookAndFeel (new MaterialLookAndFeel ());
		}
		catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace ();
		}

		// basic instantiation of JFrame with various components, including a
		// JMenuBar with some menus and items, as well as a button
		JFrame frame = new JFrame ("Material Design UI for Swing by atharva washimkar");
		frame.setMinimumSize (new Dimension (600, 400));

		// configuring the JMenuBar as well as its menus and items
		JMenuBar bar = new JMenuBar ();
		JMenu menu1 = new JMenu ("Option 1 (Animated)");
		JMenu menu2 = new JMenu ("Option 2 (Not animated)");

		JMenuItem item1 = new JMenuItem ("Item 1 (Animated)");
		JMenuItem item2 = new JMenuItem ("Item 2 (Not animated)");

		menu1.add (item1);
		menu2.add (item2);

		bar.add (menu1);
		bar.add (menu2);

		// configuring a simple JButton
		JButton button = new JButton ("PRESS ME");
		button.setMaximumSize (new Dimension (200, 200));

		JPanel content = new JPanel ();
		content.add (button);

		// add everything to the frame
		frame.add (bar, BorderLayout.PAGE_START);
		frame.add (content, BorderLayout.CENTER);

		// start animating!
		// here, 'gray' is the color that the JComponent will transition to when the user hovers over it
		Color gray = new Color (230, 230, 230);
		MaterialUIMovement.add (menu1, gray);
		MaterialUIMovement.add (item1, gray);

		// you can also pass in extra parameters indicating how many intermediate colors to display, as well as the "frame rate" of the animation
		// there will be 5 intermediate colors displayed in the transition from the original component color to the new one specified
		// the "frame rate" of the transition will be 1000 / 30, or 30 FPS
		// the animation will take 5 * 1000 / 30 = 166.666... milliseconds to complete
		Color blue = new Color (34, 167, 240);
		MaterialUIMovement.add (button, blue, 5, 1000 / 30);

		// make everything visible to the world
		frame.pack ();
		frame.setVisible (true);
	}
}