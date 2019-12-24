# Material-UI-Swing
[![Maven Central](https://img.shields.io/maven-central/v/io.github.vincenzopalazzo/material-ui-swing?color=%237cc4f4&style=for-the-badge)](https://search.maven.org/search?q=g:%22io.github.vincenzopalazzo%22%20AND%20a:%22material-ui-swing%22)
![GitHub All Releases](https://img.shields.io/github/downloads/atarw/material-ui-swing/total?style=for-the-badge)
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

This look and feel implements theming to change the color scheme of the Material UI. Currently this isn't completely stable, but if you want to implement a theme for this look and feel, you can extend and implement the abstract class `AbstractMaterialTheme` (look at `mdlaf.themes.MaterialLiteTheme` for an example).

To change the theme, use the below code:

```
 if (UIManager.getLookAndFeel() instanceof MaterialLookAndFeel){
     MaterialLookAndFeel.changeTheme(new MaterialDarkTheme());
 }
```

A working example is also found [here](https://github.com/vincenzopalazzo/material-ui-swing/tree/masternow/src/test/java/integration/gui/mock).

This theming system was implemented by [@vincenzopalazzo](https://github.com/vincenzopalazzo)
  
## Stack Overflow

We don't have much time to write detailed documentation, but if you want to get help, post a question on Stack Overflow with the tags `material-ui-swing`, `java`, `material`, `swing`, `look-and-feel`.

 ## Repository
 
 _Maven_
 
 ```
<dependency>
  <groupId>io.github.vincenzopalazzo</groupId>
  <artifactId>material-ui-swing</artifactId>
  <version>1.1.1_beta</version>
</dependency>
 ```

 _Gradle_
 
```
implementation 'io.github.vincenzopalazzo:material-ui-swing:1.1.1_beta'
``` 

Others version [here](https://search.maven.org/artifact/io.github.vincenzopalazzo/material-ui-swing)

## License
![License](https://img.shields.io/github/license/vincenzopalazzo/material-ui-swing.svg?style=for-the-badge)

_**List of projects with Material-UI-Swing theme**_
- [Krayon for SBGN](https://github.com/wiese42/krayon4sbgn)
- [JMars Beta](https://JMars.mars.asu.edu)

Contact us if you use this look and feel so we can add your project to the list 🙂

## Community
[![Gitter chat](https://img.shields.io/gitter/room/vincenzopalazzo/material-ui-swing.svg?style=for-the-badge)](https://gitter.im/material-ui-swing/community?utm_source=badge&utm_medium=badge&utm_campaign=pr-badge)

[A fork of this project exists](https://github.com/vincenzopalazzo/material-ui-swing) and is maintained by [@vincenzopalazzo](https://github.com/vincenzopalazzo), which implements some Android components not found in the traditional Java Swing library.

# Screenshot
## MaterialLiteTheme
![](https://i.ibb.co/mhjgBKJ/Selection-081.png)

## MaterialOceanicTheme
![](https://i.ibb.co/fdHTGf0/Selection-080.png)

## JMarsDarkTheme
![Selection_071](https://i.ibb.co/XFxkWKz/Selection-079.png)

Other screenshot you can found  [here](https://github.com/vincenzopalazzo/material-ui-swing/releases)