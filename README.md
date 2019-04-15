# Material UI for swing
[![](https://img.shields.io/jitpack/v/vincenzopalazzo/material-ui-swing.svg?color=yellow&style=for-the-badge)](https://jitpack.io/#vincenzopalazzo/material-ui-swing)
![](https://img.shields.io/github/last-commit/vincenzopalazzo/material-ui-swing.svg?style=for-the-badge)
## Community
[![Gitter chat](https://img.shields.io/gitter/room/vincenzopalazzo/material-ui-swing.svg?style=for-the-badge)](https://gitter.im/material-ui-swing/community?utm_source=badge&utm_medium=badge&utm_campaign=pr-badge)

## Site for Donations
[![Website](https://img.shields.io/website/http/vincenzopalazzo.github.io/material-ui-swing-donations.svg?style=for-the-badge&up_color=yellow&up_message=Donation)](https://vincenzopalazzo.github.io/material-ui-swing-donations)

# "Will undergo changes soon"

#Description
A modern, Material Design UI for Java Swing

Skins JComponents to have a Material Design Look and Feel. Most components are responsive, with hover effects, and click effects (no ripple unfortunately). Fonts included.

# Support for android components

Yes, you understand, this theme in addition to changing the look and fell also supports Android components (those possible to implement)

What does it support?

It supports the Toast component of android and here it is called MaterialToast you can find the documentation [here](https://github.com/vincenzopalazzo/android-toasts-for-swing/releases/tag/v1.0) and in the demo an example is included.

![scree](https://preview.ibb.co/mRUdQK/screen_presentazione.png)
![scree](https://preview.ibb.co/dqFRKp/addToast.png)

# Some Examples using MaterialToast

````java
import mdlaf.*;
import mdlaf.animation.*;
import javax.swing.*;
import java.awt.*;

public class MaterialUISwingDemo {

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

		//Using MaterialToast
		JButton buttonTwoo = new JButton();
		class ActionToastTest extends AbstractAction{

		    	JComponent component;

            		public ActionToastTest(JComponent component){
                	this.component = component;
               		 putValue(Action.NAME, "Test Toast");
                	putValue(Action.SHORT_DESCRIPTION, "Test Toast");
            	}

            	@Override
            	public void actionPerformed(ActionEvent e) {
              	  MaterialTost.makeText(frame, "This is a message in a toast component", MaterialTost.NORMAL).display();
           	 }
        }
        buttonTwoo.setAction(new ActionToastTest(pn));

		// on hover, button will change to a light gray
		MaterialUIMovement.add (button, MaterialColors.GRAY_100);

		frame.pack ();
		frame.setVisible (true);
	}
}
````

Check `src/MaterialUISwingDemo.java` for a slightly longer example of how to use this library (an explanation of what everything means/does).
For a real-world example of usage, see [here](https://github.com/atarw/washer-chess).

# Misc
If there's a component that isn't supported, don't hesitate to open an issue! I can usually code something up for you in a couple of days 😀

# License
![License](https://img.shields.io/github/license/vincenzopalazzo/material-ui-swing.svg?style=for-the-badge)

