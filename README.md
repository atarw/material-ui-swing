# Material-UI-Swing
[![](https://img.shields.io/jitpack/v/vincenzopalazzo/material-ui-swing.svg?color=yellow&style=for-the-badge)](https://jitpack.io/#vincenzopalazzo/material-ui-swing)
![](https://img.shields.io/github/last-commit/vincenzopalazzo/material-ui-swing.svg?style=for-the-badge)
[![Website](https://img.shields.io/website/http/vincenzopalazzo.github.io/material-ui-swing-donations.svg?style=for-the-badge&up_color=yellow&up_message=Donation)](https://vincenzopalazzo.github.io/material-ui-swing-donations)

## Description
A modern, Material Design UI for Java Swing

Skins JComponents to have a Material Design Look and Feel. Most components are responsive, with hover effects, and click effects (no ripple unfortunately). Fonts included.

Check `src/MaterialUISwingDemo.java` for a slightly longer example of how to use this library (an explanation of what everything means/does).
For a real-world example of usage, see [here](https://github.com/atarw/washer-chess).

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
  Look the example inside the test/java/integration/gui/mock
  
 ## StackOverflow
We are using the StackOverflow to help the community, if you need the help, you can write a post
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

# Status
![GitHub issues](https://img.shields.io/github/issues/vincenzopalazzo/material-ui-swing.svg?style=for-the-badge)
![GitHub pull requests](https://img.shields.io/github/issues-pr/vincenzopalazzo/material-ui-swing.svg?style=for-the-badge)

# Screenshot
![](https://i.imgur.com/K3RwlRy.png)
Other screenshot you can found  [here](https://github.com/vincenzopalazzo/material-ui-swing/releases)
