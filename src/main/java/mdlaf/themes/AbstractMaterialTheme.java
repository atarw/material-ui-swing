package mdlaf.themes;


import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.FontUIResource;

/**
 * @author https://github.com/vincenzopalazzo
 */
public abstract class AbstractMaterialTheme implements MaterialTheme{

    protected ColorUIResource backgroundPrimary;

    protected ColorUIResource highlightBackgroundPrimary;

    protected ColorUIResource textColor;

    protected ColorUIResource disableTextColor;

    protected ColorUIResource buttonBackgroundColor;

    protected ColorUIResource buttonTextColor;

    protected ColorUIResource buttonBackgroundColorMouseHover;

    protected ColorUIResource buttonDefaultBackgroundColor;

    protected ColorUIResource buttonDefaultTextColor;

    protected ColorUIResource buttonDefaultBackgroundColorMouseHover;

    protected ColorUIResource menuBackground;

    protected ColorUIResource menuTextColor;

    protected ColorUIResource menuBackgroundMouseHover;

    protected ColorUIResource menuDisableBackground;

    protected FontUIResource fontBold;

    protected FontUIResource fontItalic;

    protected FontUIResource fontRegular;

    protected FontUIResource fontMedium;

    public abstract void installTheme();

    protected abstract void installFont();

    protected abstract void installColor();

    public abstract String getName();

    public ColorUIResource getBackgroundPrimary() {
        return backgroundPrimary;
    }

    public ColorUIResource getHighlightBackgroundPrimary() {
        return highlightBackgroundPrimary;
    }

    public ColorUIResource getTextColor() {
        return textColor;
    }

    public ColorUIResource getDisableTextColor() {
        return disableTextColor;
    }

    public ColorUIResource getButtonBackgroundColor() {
        return buttonBackgroundColor;
    }

    public ColorUIResource getButtonTextColor() {
        return buttonTextColor;
    }

    public ColorUIResource getButtonBackgroundColorMouseHover() {
        return buttonBackgroundColorMouseHover;
    }

    public ColorUIResource getButtonDefaultBackgroundColor() {
        return buttonDefaultBackgroundColor;
    }

    public ColorUIResource getButtonDefaultTextColor() {
        return buttonDefaultTextColor;
    }

    public ColorUIResource getButtonDefaultBackgroundColorMouseHover() {
        return buttonDefaultBackgroundColorMouseHover;
    }

    public ColorUIResource getMenuBackground() {
        return menuBackground;
    }

    public ColorUIResource getMenuTextColor() {
        return menuTextColor;
    }

    public ColorUIResource getMenuBackgroundMouseHover() {
        return menuBackgroundMouseHover;
    }

    public ColorUIResource getMenuDisableBackground() {
        return menuDisableBackground;
    }

    public FontUIResource getFontBold() {
        return fontBold;
    }

    public FontUIResource getFontItalic() {
        return fontItalic;
    }

    public FontUIResource getFontRegular() {
        return fontRegular;
    }

    public FontUIResource getFontMedium() {
        return fontMedium;
    }
}
