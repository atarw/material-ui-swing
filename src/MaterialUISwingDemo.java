import mdlaf.MaterialLookAndFeel;
import mdlaf.animation.MaterialUIMovement;
import mdlaf.resources.MaterialColors;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JToolBar;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.sun.xml.internal.ws.org.objectweb.asm.Label;

import java.awt.BorderLayout;
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
		
		//configure JToolBar
		JToolBar toolBar = new JToolBar();
		toolBar.setRollover(true);
	    JButton buttonOne = new JButton("button");
	    toolBar.add(buttonOne);
	    toolBar.addSeparator();
	    toolBar.add(new JButton("button 2"));
	    toolBar.add(new JComboBox(new String[]{"A","B","C"}));
		content.add(toolBar);
		
		//Setting comboBox only
		JLabel labelCombo = new JLabel();
		labelCombo.setText("Combo");
		JComboBox<String> comboTest = new JComboBox<String>();
		comboTest.addItem("Prova uno");
		comboTest.addItem("Prova due");
		content.add(labelCombo);
		content.add(comboTest);
		
		//settin Slider
		JSlider slider = new JSlider();
		JSlider sliderVertical = new JSlider(JSlider.VERTICAL);
		content.add(slider);
		content.add(sliderVertical);

		// add everything to the frame
		frame.add (bar, BorderLayout.PAGE_START);
		frame.add (content, BorderLayout.CENTER);

		// start animating!
		// here, 'gray' is the color that the JComponent will transition to when the user hovers over it
		MaterialUIMovement.add (menu1, MaterialColors.GRAY_200);
		MaterialUIMovement.add (item1, MaterialColors.GRAY_200);

		// you can also pass in extra parameters indicating how many intermediate colors to display, as well as the "frame rate" of the animation
		// there will be 5 intermediate colors displayed in the transition from the original components color to the new one specified
		// the "frame rate" of the transition will be 1000 / 30, or 30 FPS
		// the animation will take 5 * 1000 / 30 = 166.666... milliseconds to complete
		MaterialUIMovement.add (button, MaterialColors.BLUE_400, 5, 1000 / 30);

		// make everything visible to the world
		frame.pack ();
		frame.setVisible (true);
	}
}