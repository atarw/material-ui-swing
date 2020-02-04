# Material-UI-Swing 

## Version 1.1.1

**Bugs Fixed** 
- https://github.com/vincenzopalazzo/material-ui-swing/issues/98
- Added support to JSplitPane from MaterialTheming, this feature fixes the following issue https://github.com/vincenzopalazzo/material-ui-swing/issues/102
- Implemented example for TitledBorder with material style [https://github.com/vincenzopalazzo/material-ui-swing/issues/104](https://github.com/vincenzopalazzo/material-ui-swing/issues/104)
- [Added new style of the Disabled TextComponent](https://github.com/vincenzopalazzo/material-ui-swing/issues/105)
- [The mouse hover effect work wrong with disabled action on click](https://github.com/vincenzopalazzo/material-ui-swing/issues/107)

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

