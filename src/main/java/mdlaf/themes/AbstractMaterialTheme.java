package mdlaf.themes;


import javax.swing.*;
import javax.swing.plaf.BorderUIResource;
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

    //Button proprieties
    protected ColorUIResource buttonBackgroundColor;

    protected ColorUIResource buttonTextColor;

    protected ColorUIResource buttonBackgroundColorMouseHover;

    protected ColorUIResource buttonDefaultBackgroundColor;

    protected ColorUIResource buttonDefaultTextColor;

    protected ColorUIResource buttonDefaultBackgroundColorMouseHover;

    protected ColorUIResource buttonDisabledBackground;

    protected ColorUIResource buttonDisabledForeground;

    protected ColorUIResource buttonFocusColor;

    protected ColorUIResource buttonDefaultFocusColor;

    protected ColorUIResource buttonBorderColor;

    protected ColorUIResource menuBackground;

    protected ColorUIResource menuTextColor;

    protected ColorUIResource menuBackgroundMouseHover;

    protected ColorUIResource menuDisableBackground;


    protected FontUIResource fontBold;

    protected FontUIResource fontItalic;

    protected FontUIResource fontRegular;

    protected FontUIResource fontMedium;

    //Button setting
    protected BorderUIResource buttonBorder;

    // Abstract method

    public abstract void installTheme();

    public void installUIDefault(UIDefaults table){
        //do nothing
    }

    protected abstract void installColor();

    public abstract String getName();

    protected void installFonts(){

    }

    protected void installBorders(){
        //button border
        buttonBorder = new BorderUIResource(BorderFactory.createEmptyBorder(8, 12, 8, 12));
    }

    //getter
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

    //Getter for button

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

    public ColorUIResource getButtonDisabledBackground() {
        return buttonDisabledBackground;
    }

    public ColorUIResource getButtonDisabledForeground() {
        return buttonDisabledForeground;
    }

    public ColorUIResource getButtonDisableTextColor() {
        return this.getDisableTextColor();
    }

    public ColorUIResource getButtonFocusColor() {
        return buttonFocusColor;
    }

    public ColorUIResource getButtonDefaultFocusColor() {
        return buttonDefaultFocusColor;
    }

    public ColorUIResource getButtonBorderColor() {
        return buttonBorderColor;
    }

    public BorderUIResource getButtonBorder() {
        return buttonBorder;
    }

    public FontUIResource getButtonFont(){
        return getFontBold();
    }

    public boolean getMouseHoverButtonEnable(){
        return true;
    }

    public boolean getButtonFocusable(){
        return true;
    }

    public boolean getButtonBorderEnable(){
        return true;
    }

    public boolean getButtonBorderEnableToAll(){
        return false;
    }

    //Getter for menu
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
