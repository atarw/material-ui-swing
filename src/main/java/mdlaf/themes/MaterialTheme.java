package mdlaf.themes;

import mdlaf.utils.MaterialColors;

import javax.swing.*;
import javax.swing.plaf.BorderUIResource;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.FontUIResource;

/**
 * @author https://github.com/vincenzopalazzo
 */
public interface MaterialTheme {

    void installTheme();

    void installUIDefault(UIDefaults table);

    String getName();

    //Getter for global constant
    ColorUIResource getBackgroundPrimary();

    ColorUIResource getHighlightBackgroundPrimary();

    ColorUIResource getTextColor();

    ColorUIResource getDisableTextColor();

    //getter for button propriety
    ColorUIResource getButtonBackgroundColor();

    ColorUIResource getButtonTextColor();

    ColorUIResource getButtonBackgroundColorMouseHover();

    ColorUIResource getButtonDefaultBackgroundColor();

    ColorUIResource getButtonDefaultTextColor();

    ColorUIResource getButtonDefaultBackgroundColorMouseHover();

    ColorUIResource getButtonDisabledBackground();

    ColorUIResource getButtonDisabledForeground();

    ColorUIResource getButtonFocusColor();

    ColorUIResource getButtonDisableTextColor();

    ColorUIResource getButtonDefaultFocusColor();

    ColorUIResource getButtonBorderColor();

    BorderUIResource getButtonBorder();

    FontUIResource getButtonFont();

    boolean getMouseHoverButtonEnable();

    boolean getButtonFocusable();

    boolean getButtonBorderEnable();

    boolean getButtonBorderEnableToAll();

    ColorUIResource getMenuBackground();

    ColorUIResource getMenuTextColor();

    ColorUIResource getMenuBackgroundMouseHover();

    ColorUIResource getMenuDisableBackground();

    FontUIResource getFontBold();

    FontUIResource getFontItalic();

    FontUIResource getFontRegular();

    FontUIResource getFontMedium();


}
