package mdlaf.themes;

import mdlaf.utils.MaterialColors;

import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.FontUIResource;

/**
 * @author https://github.com/vincenzopalazzo
 */
public interface MaterialTheme {

    void installTheme();

    String getName();

    ColorUIResource getBackgroundPrimary();

    ColorUIResource getHighlightBackgroundPrimary();

    ColorUIResource getTextColor();

    ColorUIResource getDisableTextColor();

    ColorUIResource getButtonBackgroundColor();

    ColorUIResource getButtonTextColor();

    ColorUIResource getButtonBackgroundColorMouseHover();

    ColorUIResource getButtonDefaultBackgroundColor();

    ColorUIResource getButtonDefaultTextColor();

    ColorUIResource getButtonDefaultBackgroundColorMouseHover();

    ColorUIResource getMenuBackground();

    ColorUIResource getMenuTextColor();

    ColorUIResource getMenuBackgroundMouseHover();

    ColorUIResource getMenuDisableBackground();

    FontUIResource getFontBold();

    FontUIResource getFontItalic();

    FontUIResource getFontRegular();

    FontUIResource getFontMedium();
}
