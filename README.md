# Material-UI-Swing
[![Donation](https://img.shields.io/website/http/vincenzopalazzo.github.io/material-ui-swing-donations.svg?style=for-the-badge&up_color=yellow&up_message=Donation)](https://vincenzopalazzo.github.io/material-ui-swing-donations)

A modern, Material Design UI for Java Swing

Skins JComponents to have a Material Design Look and Feel. Most components are responsive, with hover effects, and click effects (no ripple unfortunately). Fonts included.

Screenshot in action below (chessboard not included 😛):

## Screenshot
![Screenshot](http://i.imgur.com/WsprAM6.png?1)

Other screenshot you can found  [here](https://github.com/vincenzopalazzo/material-ui-swing/releases)

# Usage
Go to the releases (or just the `target/classes` folder in the repo) and download the latest version of `material-ui-swing.jar`. The OSGi version is available under `target`. Add it to your project's build path (e.g. for IntelliJ [this](https://www.jetbrains.com/help/idea/import-project-from-existing-sources-libraries-page.html) might help), and you're all set!

## Example

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

		// on hover, button will change to a light gray
		MaterialUIMovement.add (button, MaterialColors.GRAY_100);

		frame.pack ();
		frame.setVisible (true);
	}
}
````

Check `src/main/java/MaterialUISwingDemo.java` for a slightly longer example of how to use this library (and an explanation of what everything means/does).
For a real-world example of usage, see [here](https://github.com/atarw/washer-chess).

## Version 1.0.0

This look and feel implement an method for theming personal, don't use the MetalTheme but implements
the complete system.

For the moment not is scheduler a documentations and this is considered a version alpha, if you want to
try the implement a theme for this look and feel, you can extend the abstract class AbstractMaterialTheme implement
the methods abstract, for more info look theme mlaf.thmes.MaterialLiteTheme

For a change the theme to runtime you can use this code
```
 if (UIManager.getLookAndFeel() instanceof MaterialLookAndFeel){
     MaterialLookAndFeel.changeTheme(new MaterialDarkTheme());
 }
```
  Look the example [here](https://github.com/vincenzopalazzo/material-ui-swing/tree/masternow/src/test/java/integration/gui/mock) 
  
The theming system is projected by [@vincenzopalazzo](https://github.com/vincenzopalazzo)
  
## Stack Overflow
We are using the Stack Overflow to help the community because we don't have much time to write detailed documentation, but remember we worked hard to build a customizable look-and-feel. 
If you need the help, you can write a post
with these tags
  
 **java**, **material**, **swing**, **look-and-feel**
 
 ps:we use these until we have one of our own

## License
![License](https://img.shields.io/github/license/vincenzopalazzo/material-ui-swing.svg?style=for-the-badge)


_**List of projects with Material-UI-Swing theme**_
- [JMars Beta](https://JMars.mars.asu.edu)

_Send me a mail if you use material-ui-swing so I add the your project at the list_

## Community
[![Gitter chat](https://img.shields.io/gitter/room/vincenzopalazzo/material-ui-swing.svg?style=for-the-badge)](https://gitter.im/material-ui-swing/community?utm_source=badge&utm_medium=badge&utm_campaign=pr-badge)

[A fork of this project exists](https://github.com/vincenzopalazzo/material-ui-swing) and is maintained by [@vincenzopalazzo](https://github.com/vincenzopalazzo), which implements some Android components not found in the traditional Java Swing library.
