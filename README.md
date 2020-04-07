# Material-UI-Swing
[![Maven Central](https://img.shields.io/maven-central/v/io.github.vincenzopalazzo/material-ui-swing?color=%237cc4f4&style=for-the-badge)](https://search.maven.org/search?q=g:%22io.github.vincenzopalazzo%22%20AND%20a:%22material-ui-swing%22)
![GitHub last commit](https://img.shields.io/github/last-commit/vincenzopalazzo/material-ui-swing?color=%237cc4f4&style=for-the-badge)
![GitHub All Releases](https://img.shields.io/github/downloads/vincenzopalazzo/material-ui-swing/total?color=%234caf50&style=for-the-badge)

<div align="center">
<img src="https://raw.githubusercontent.com/vincenzopalazzo/material-ui-swing-donations/master/images/iconMaterialOfficial.png" />
</div>

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
     MaterialLookAndFeel.changeTheme(new MaterialOceanicTheme());
 }
```
  Look the example inside the test/java/integration/gui/mock

 ## Stack Overflow
We don't have much time to write detailed documentation, but if you want to get help, post a question on Stack Overflow with the tags `material-ui-swing`, `java`, `material`, `swing`, `look-and-feel`.

 ## Repository

 _Maven_

 ```
<dependency>
  <groupId>io.github.vincenzopalazzo</groupId>
  <artifactId>material-ui-swing</artifactId>
  <version>1.1.1_pre-release_6.1</version>
</dependency>
 ```

 _Gradle_

```
implementation 'io.github.vincenzopalazzo:material-ui-swing:1.1.1_pre-release_6.1'
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

### Sponsors
Support this project

[![Donation](https://img.shields.io/website/http/vincenzopalazzo.github.io/material-ui-swing-donations.svg?style=for-the-badge&up_color=yellow&up_message=Donation)](https://vincenzopalazzo.github.io/material-ui-swing-donations)
![Custom badge](https://img.shields.io/endpoint?style=for-the-badge&url=https%3A%2F%2Fshieldsio-patreon.herokuapp.com%2Fmaterialuiswing)

_Donors_
- [lilili87222](https://github.com/lilili87222)
- Arizona State University

# Status
![GitHub issues](https://img.shields.io/github/issues/vincenzopalazzo/material-ui-swing.svg?style=for-the-badge)
![GitHub pull requests](https://img.shields.io/github/issues-pr/vincenzopalazzo/material-ui-swing.svg?style=for-the-badge)

# Screenshot
## MaterialLiteTheme
![](https://i.ibb.co/MBypNKV/Selection-082.png)

## MaterialOceanicTheme
![](https://i.ibb.co/1TzSXWk/Selection-083.png)

## JMarsDarkTheme
![Selection_071](https://i.ibb.co/TRp9wDx/Selection-084.png)

Other screenshot you can found  [here](https://github.com/vincenzopalazzo/material-ui-swing/releases)

## Built with

- **[jIconFont-Swing](https://jiconfont.github.io/swing)**: jIconFont-Swing is a API to provide icons generated by any IconFont. These icons can be used in Swing. 

## Performance

![](https://www.yourkit.com/images/yklogo.png)

From version 1.1.1 the material-ui-swing library will be support also to YourKit and now th library will 
start to work also to increase the performance.

Stay tuned that the future version 1.1.1 official will be more optimize.

The Yourkit is used also by Google, Microsoft, PayPal, ecc.


- **YourKit**: it supports open source projects with innovative and intelligent tools
for monitoring and profiling Java and .NET applications.
YourKit is the creator of <a href="https://www.yourkit.com/java/profiler/">YourKit Java Profiler</a>,
<a href="https://www.yourkit.com/.net/profiler/">YourKit .NET Profiler</a>,
and <a href="https://www.yourkit.com/youmonitor/">YourKit YouMonitor</a>.
