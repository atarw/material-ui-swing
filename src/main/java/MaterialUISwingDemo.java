import mdlaf.MaterialLookAndFeel;
import mdlaf.animation.MaterialUIMovement;
import mdlaf.utils.MaterialColors;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JEditorPane;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JProgressBar;
import javax.swing.JRadioButton;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;
import javax.swing.JTree;
import javax.swing.SpinnerListModel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;

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

		//Test RadioButtonMenuItem
		JRadioButtonMenuItem jRadioButtonMenuItem = new JRadioButtonMenuItem ();
		jRadioButtonMenuItem.setText ("prova RadioButtonMenuItem");
		menu1.add (jRadioButtonMenuItem);
		menu1.addSeparator ();
		//TestCheckBoxMenuItem
		JCheckBoxMenuItem checkBoxMenuItem = new JCheckBoxMenuItem ();
		checkBoxMenuItem.setText ("test");
		menu1.add (checkBoxMenuItem);
		menu1.addSeparator ();
		menu1.add (item1);
		menu2.add (item2);

		bar.add (menu1);
		bar.add (menu2);

		// configuring a simple JButton
		JButton button = new JButton ("PRESS ME");
		button.setBackground (MaterialColors.LIGHT_BLUE_400);
		button.setForeground (Color.WHITE);
		button.setMaximumSize (new Dimension (200, 200));

		JPanel content = new JPanel ();
		content.add (button);

		// add everything to the frame
		frame.add (bar, BorderLayout.PAGE_START);
		// frame.add (content, BorderLayout.CENTER);

		// start animating!
		// here, 'gray' is the color that the JComponent will transition to when the user hovers over it
		MaterialUIMovement.add (menu1, MaterialColors.GRAY_200);
		MaterialUIMovement.add (item1, MaterialColors.GRAY_200);

		// you can also pass in extra parameters indicating how many intermediate colors to display, as well as the "frame rate" of the animation
		// there will be 5 intermediate colors displayed in the transition from the original components color to the new one specified
		// the "frame rate" of the transition will be 1000 / 30, or 30 FPS
		// the animation will take 5 * 1000 / 30 = 166.666... milliseconds to complete
		MaterialUIMovement.add (button, MaterialColors.LIGHT_BLUE_500, 5, 1000 / 30);

		// other components
		content.add (new JCheckBox ("checkbox"));
		content.add (new JComboBox<String> (new String[]{"a", "b", "c"}));
		content.add (new JLabel ("label"));
		content.add (new JPasswordField ("password"));
		content.add (new JRadioButton ("radio button"));
		content.add (new JSlider (JSlider.HORIZONTAL, 0, 5, 2));
		content.add (new JSpinner (new SpinnerListModel (new String[]{"d", "e", "f"})));
		content.add (new JTable (new String[][]{{"a", "b", "c"}, {"d", "e", "f"}}, new String[]{"r", "e"}));
		content.add (new JTextField ("text field"));
		content.add (new JToggleButton ("toggle"));

		JToolBar tb = new JToolBar ("toolbar");
		JButton button1 = new JButton ("f");

		button1.setAction (new AbstractAction () {
			@Override
			public void actionPerformed (ActionEvent e) {
				putValue (Action.NAME, "f");
				putValue (Action.SHORT_DESCRIPTION, "Test tool tip");

				JDialog dialog = new JDialog ();
				JPanel jPanel = new JPanel ();
				jPanel.add (new JColorChooser ());
				dialog.setContentPane (jPanel);
				dialog.setLocationRelativeTo (null);
				dialog.setVisible (true);
				dialog.pack ();
			}
		});

		JButton button2 = new JButton ("e");
		button1.setBackground (MaterialColors.LIGHT_BLUE_400);
		button1.setForeground (Color.WHITE);
		button2.setBackground (MaterialColors.LIGHT_BLUE_400);
		button2.setForeground (Color.WHITE);
		tb.add (button1);
		tb.addSeparator ();
		tb.add (button2);
		tb.setFloatable (true);
		content.add (tb);

		JTree tree = new JTree (new String[]{"a", "b"});
		tree.setEditable (true);

		content.add (tree);

		JScrollPane sp = new JScrollPane (content);
		sp.setHorizontalScrollBarPolicy (JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		sp.setVerticalScrollBarPolicy (JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

		JPanel pn = new JPanel ();
		JTabbedPane tp = new JTabbedPane ();
		tp.addTab ("bleh", sp);
		tp.addTab ("bleh2", pn);

		frame.add (tp, BorderLayout.CENTER);

		//test progressBar
		JProgressBar progressBar = new JProgressBar ();
		progressBar.setValue (6);
		progressBar.setMaximum (12);
		pn.add (progressBar);

		//test cange coloro maximum value progress bar
		progressBar = new JProgressBar ();
		progressBar.setMaximum (5);
		progressBar.setValue (5);
		pn.add (progressBar);

		JTextPane textPane = new JTextPane ();
		textPane.setText ("Hi I'm super sayan");
		JTextPane textPane1 = new JTextPane ();
		textPane1.setText ("Hi I'm super sayan");
		textPane1.setEnabled (false);
		pn.add (textPane);
		pn.add (textPane1);

		JEditorPane editorPane = new JEditorPane ();
		editorPane.setText ("This theme is fantastic");
		pn.add (editorPane);

		// make everything visible to the world
		frame.pack ();
		frame.setVisible (true);

		JFileChooser fileChooser = new JFileChooser ();
		fileChooser.showOpenDialog (frame);
	}
}