# Material-UI-Swing

## material-ui-swing-1.1.1-rc2

**Bugs Fixed**
- [InternalFrame + TextComponent drawing issue](https://github.com/vincenzopalazzo/material-ui-swing/issues/98)
- [Added support to JSplitPane from MaterialTheming](https://github.com/vincenzopalazzo/material-ui-swing/issues/102)
- [Implemented example for TitledBorder with material style](https://github.com/vincenzopalazzo/material-ui-swing/issues/104)
- [Added new style of the Disabled TextComponent](https://github.com/vincenzopalazzo/material-ui-swing/issues/105)
- [The mouse hover effect work wrong with disabled action on click](https://github.com/vincenzopalazzo/material-ui-swing/issues/107)
- [MouseHover event on JComboBox with Label.setOpaque(false)]()
- [Wrong Layout inside JTabbedPane when resize it]()
- [Support SpliPane with MaterialTheming](https://github.com/vincenzopalazzo/material-ui-swing/issues/102)
- [Remove call to setOpaque from MaterialLabelUI](https://github.com/vincenzopalazzo/material-ui-swing/issues/101)
- [Possibility to add the personal color to Tab disabled into JTabbedPane](https://github.com/vincenzopalazzo/material-ui-swing/issues/113)
- [Mouse hover bug when the component did disabled after click](https://github.com/vincenzopalazzo/material-ui-swing/issues/107)
- [MaterialButtonUI.java depends on JavaFX](https://github.com/atarw/material-ui-swing/issues/95)
- [Nested JTree view paint wrong](https://github.com/atarw/material-ui-swing/pull/103)
- [Font but with screen zoom](https://github.com/atarw/material-ui-swing/pull/99)
- [Added Caret Foreground color](https://github.com/atarw/material-ui-swing/pull/102)
- JOptionPane Without icons: Fixed position text
- JOptionPane white point on the corner with Dark theme.
- [Dialog bug when drag it with mouse](https://github.com/vincenzopalazzo/material-ui-swing/issues/128)
- [Tree Control - Changed Selection Look](https://github.com/vincenzopalazzo/material-ui-swing/issues/127)
- [Secondary Buttons Retain "Hover" Look After Being Clicked - 1.1.1_01](https://github.com/vincenzopalazzo/material-ui-swing/issues/126)
- [Button Loses Border - ver 1.1.1_01](https://github.com/vincenzopalazzo/material-ui-swing/issues/125)
- [Dialog Title Bar - Title is Cut Off in 1.1.1_02](https://github.com/vincenzopalazzo/material-ui-swing/issues/124)
- [Task Pane - Title Bar text Color Does not Observe Theme Settings](https://github.com/vincenzopalazzo/material-ui-swing/issues/123)
- [Infinite Loop Encountered in JMARS in mouseMoved Event](https://github.com/vincenzopalazzo/material-ui-swing/issues/122)
- [Button Tabbing - Visual Effect](https://github.com/vincenzopalazzo/material-ui-swing/issues/120)
- [MaterialRootPaneUI resize problem ](https://github.com/vincenzopalazzo/material-ui-swing/issues/117)
- [The mouse hover effect work wrong with disabled action on click](https://github.com/vincenzopalazzo/material-ui-swing/issues/107)
- [Table header no headers split](https://github.com/vincenzopalazzo/material-ui-swing/issues/103)
- [Resize window problem it compare when I change l&f](https://github.com/vincenzopalazzo/material-ui-swing/issues/100)
- [Can't load /imgs/white/minimize.png](https://github.com/atarw/material-ui-swing/issues/106)
- [Problem with resizing JDialog](https://github.com/atarw/material-ui-swing/issues/105)
- Refactoring MouseHover event (Class MaterialUITime)
- Refactoring JSpinner arrow button and introducing new icon inside the arrow (also, the icons are add inside the theme system)
- Fix stack overflow exception inside the JSpinner. The bug is only inside the version 1.1.1-rc1 of the library.
- Added a different method to load a personal font with MaterialFontFactory and now the dimension fot with JDK8 with calculate with JDKo optimizing
to fix pixel bug in JDK8 but the dimension is setting static with JDK version >=9.
- Fixed rolloverBorder on JToolBar.
- Fixed bugs in sub menu background.
- Refactoring JComboBox, now is possible change the arch of the bord easy.
- Apply anti-aliasing to some component
- [JToggleButton icon font missed](https://github.com/vincenzopalazzo/material-ui-swing/issues/136)
- [Support configurable Tab inside JTabbedPane](https://github.com/vincenzopalazzo/material-ui-swing/issues/136)
- Fixed line position inside the JTabbedPane when (LEFT, RIGHT)


**JToggleButton Second Style without icons**

From the version 1.1.1 official of the library, it was released the second style of
the component JToggleButton without icon, this feature was proposed from the
[issue 95 of the vincenzopalazzo/material-ui-swing branch](https://github.com/vincenzopalazzo/material-ui-swing/issues/95)
and an is disabled by default, and simple demo for enable this style [is here]().

A screenshots of the new style are

![](https://i.ibb.co/LCJRyVr/Selection-004.png)
![](https://i.ibb.co/qCNMVKV/Selection-006.png)

**Material Title Style implementation**

Inside [this issue](https://github.com/vincenzopalazzo/material-ui-swing/issues/104) is described how implement the TitledBorder inside the your application

This is an screenshot

![](https://user-images.githubusercontent.com/17150045/72810116-378f8880-3c5d-11ea-975b-4c5611076c9a.png)

You can example this with this code

```
containerList.setBorder(javax.swing.BorderFactory.createTitledBorder(MaterialBorders.DEFAULT_SHADOW_BORDER, "my titled border", javax.swing.border.TitledBorder.LEFT, TitledBorder.BELOW_TOP, new java.awt.Font("NotoSans", Font.BOLD, 11))); // NOI18N
list.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
```
Is possible change the border main from MaterialTheming, an example you can declare the border type inside the method installBorders().

```
protected void installBorders(){
   //other proprieties

   super.borderTitledBorder = MaterialBorders.LIGHT_LINE_BORDER;
}
```

also is possible change the color of the title text with MaterialTheming, this is an example of code

```
protected void installColor() {
    //Other proprieties
    super.colorTextTitledBorder = textColor;
}
```

**JavaDoc**

Inside the version 1.1.1 was released the first javadoc of the library, the interesting thing is the first javadoc of MaterialTheming, you can find it [here](TODO)

## JSpinner style configuration supported by MaterialTheming

With the version 1.1.1 you can change the style to JSeparator with this propriety inside the AbstractMaterialTheming

```
    public ColorUIResource backgroundSeparator;

    public ColorUIResource foregroundSeparator;

```

This proprieties have setter and getter methods.

## JTabbledPane Style

Now is possible set the color to the text when the tab is disabled, this is the new effect:

**MaterialLiteTheme**

![](https://i.ibb.co/drFVYHn/Selection-034.png)


**MaterialOceanicTheme**

![](https://i.ibb.co/bX21M5G/Selection-033.png)


**JMarsDarkTheme**

![](https://i.ibb.co/k16jGqv/Selection-032.png)

Also, you can found othe information inside the answer to this [issue](https://github.com/vincenzopalazzo/material-ui-swing/issues/113#issuecomment-585725423)

## Used [IconFontSwing](https://jiconfont.github.io/) library for add other icons

The versions > to 1.1.1_beta includes the library [IconFontSwing](https://jiconfont.github.io/), with him is possible include the [Google material icons]() with personal color and personal dimension, is possible used the IconFontSwing API to create the icon but the class [MaterialImageFactory]() have the possibility to cashad the utilized icon, so if you use 1000 "settings" icons, the MaterialImageFactory returned the same object reference.
MaterialImageFactory create the identifier of the class with this rules: NAME_ICONS + DIMENSION_ICONS + COLOR_ICON.

The API for use the library IconFontSwing with MaterialImageFactory are described here:

https://github.com/vincenzopalazzo/material-ui-swing/blob/c37a9830f092b2ae7ed001dba044bf5931eaaa26/src/main/java/mdlaf/utils/MaterialImageFactory.java#L192-L202

an example method call is `MaterialImageFactory.getInstance().getImage(GoogleMaterialDesignIcons.KEYBOARD_ARROW_RIGHT, DIMENSION, COLOR);`

but there are default value for DIMENSION and COLOR

- DIMENSION default is 20.

- COLOR default is BLACK.

So with this method call
 `MaterialImageFactory.getInstance().getImage(GoogleMaterialDesignIcons.KEYBOARD_ARROW_RIGHT);`

 You obtain GoogleMaterialDesignIcons.KEYBOARD_ARROW_RIGHT with dimension = 20 and color= black

 You can consult the API class GoogleMaterialDesignIcons [here](https://jiconfont.github.io/googlematerialdesignicons).
 
 You can consult the API class IconFontSwing [here](https://jiconfont.github.io/swing/).
