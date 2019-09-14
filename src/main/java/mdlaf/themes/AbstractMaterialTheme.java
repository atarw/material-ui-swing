/*
 * MIT License
 *
 * Copyright (c) 2019 Vincent Palazzo vincenzopalazzodev@gmail.com
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package mdlaf.themes;


import mdlaf.utils.MaterialBorders;
import sun.swing.ImageIconUIResource;

import javax.swing.*;
import javax.swing.plaf.BorderUIResource;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.FontUIResource;
import javax.swing.plaf.InsetsUIResource;

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

    protected ColorUIResource buttonColorHighlight;

    protected BorderUIResource buttonBorder;

    //---------------------------------------------------
    //Proprieties JCheckBox
    protected ImageIconUIResource unselectedCheckBoxIcon;

    protected ImageIconUIResource selectedCheckBoxIcon;

    //---------------------------------------------------
    //Proprieties JComboBox
    protected ColorUIResource selectedInDropDownBackgroundComboBox;

    protected ColorUIResource selectedForegroundComboBox;

    protected BorderUIResource borderComboBox;

    //---------------------------------------------------
    //Proprieties All component of the JMenu
    protected ColorUIResource menuBackground;

    protected ColorUIResource menuTextColor;

    protected ColorUIResource menuBackgroundMouseHover;

    protected ColorUIResource menuDisableBackground;

    protected BorderUIResource borderMenu;

    protected BorderUIResource borderMenuBar;

    //---------------------------------------------------
    //Proprieties JRadioButton
    protected ImageIconUIResource unselectedRadioButtonIcon;

    protected ImageIconUIResource selectedRadioButtonIcon;

    //---------------------------------------------------
    //All type of font JPopupMenu
    protected BorderUIResource borderPopupMenu;

    //---------------------------------------------------
    //All type of font JSpinner
    protected ColorUIResource arrowButtonBackgroundSpinner;

    protected ColorUIResource mouseHoverButtonColorSpinner;

    protected BorderUIResource borderSpinner;

    protected BorderUIResource arrowButtonBorderSpinner;

    //---------------------------------------------------
    //Proprieties JPanel
    protected BorderUIResource borderPanel;

    //---------------------------------------------------
    //Proprieties JScrollBar
    protected ColorUIResource trackColorScrollBar;

    protected ColorUIResource thumbColorScrollBar;

    protected ColorUIResource thumbDarkShadowColorScrollBar;

    protected ColorUIResource thumbHighlightColorScrollBar;

    protected ColorUIResource thumbShadowColorScrollBar;

    protected ColorUIResource mouseHoverColorScrollBar;

    protected ColorUIResource arrowButtonColorScrollBar;

    protected ColorUIResource arrowButtonOnClickColorScrollBar;

    protected BorderUIResource arrowButtonBorderScrollBar;

    //---------------------------------------------------
    //Proprieties JSlider
    protected ColorUIResource trackColorSlider;

    protected ColorUIResource haloColorSlider;

    protected BorderUIResource borderSlider;

    //---------------------------------------------------
    //Proprieties JTabbedPane
    protected ColorUIResource highlightColorTabbedPane;

    protected ColorUIResource borderHighlightColorTabbedPane;

    protected ColorUIResource focusColorLineTabbedPane;

    protected ColorUIResource disableColorTabTabbedPane;

    protected InsetsUIResource tabInsetsTabbedPane;

    protected InsetsUIResource selectedTabInsetsTabbedPane;

    //---------------------------------------------------
    //Proprieties JTable
    protected ColorUIResource backgroundTable;

    protected ColorUIResource backgroundTableHeader;

    protected ColorUIResource foregroundTable;

    protected ColorUIResource foregroundTableHeader;

    protected ColorUIResource selectionBackgroundTable;

    protected ColorUIResource selectionForegroundTable;

    protected ColorUIResource gridColorTable;

    protected ColorUIResource alternateRowBackgroundTable;

    protected BorderUIResource borderTable;

    protected BorderUIResource borderTableHeader;

    protected BorderUIResource cellBorderTableHeader;

    protected ImageIconUIResource unselectedCheckBoxIconTable;

    protected ImageIconUIResource selectedCheckBoxIconTable;


    //---------------------------------------------------
    //Proprieties JToolBar
    protected ColorUIResource dockingBackgroundToolBar;

    protected ColorUIResource floatingBackgroundToolBar;

    protected BorderUIResource borderToolBar;

    //---------------------------------------------------
    //Proprieties JTree
    protected ColorUIResource selectionForegroundTree;

    protected ColorUIResource selectionBackgroundTree;

    protected ColorUIResource selectionBorderColorTree;

    protected ImageIconUIResource closedIconTree;

    protected ImageIconUIResource openIconTree;

    //---------------------------------------------------
    //Proprieties JTextField and JPasswordField
    protected ColorUIResource backgroundTextField;

    protected ColorUIResource inactiveForegroundTextField;

    protected ColorUIResource inactiveBackgroundTextField;

    protected ColorUIResource selectionBackgroundTextField;

    protected ColorUIResource selectionForegroundTextField;

    protected ColorUIResource inactiveColorLineTextField;

    protected ColorUIResource activeColorLineTextField;

    protected BorderUIResource borderTextField;

    //---------------------------------------------------
    //Proprieties JXTaskPane
    protected ColorUIResource titleBackgroundGradientStartTaskPane;

    protected ColorUIResource titleBackgroundGradientEndTaskPane;

    protected ColorUIResource titleOverTaskPane;

    protected ColorUIResource specialTitleOverTaskPane;

    protected ColorUIResource backgroundTaskPane;

    protected ColorUIResource borderColorTaskPane;

    protected ColorUIResource contentBackgroundTaskPane;

    protected BorderUIResource borderTaskPane;

    protected ImageIconUIResource yesCollapsedTaskPane;

    protected ImageIconUIResource noCollapsedTaskPane;

    //---------------------------------------------------
    //Proprieties JList
    protected ColorUIResource selectionBackgroundList;

    protected ColorUIResource selectionForegroundList;

    protected BorderUIResource focusCellHighlightBorder;

    protected BorderUIResource borderItemList;

    protected BorderUIResource borderList;

    //---------------------------------------------------
    //Proprieties JRootPane
    protected BorderUIResource borderFrameRootPane;

    protected BorderUIResource borderDialogRootPane;

    //---------------------------------------------------
    //Proprieties JOptionPane
    protected ColorUIResource backgroundOptionPane;

    protected ImageIconUIResource warningIconOptionPane;

    protected ImageIconUIResource errorIconIconOptionPane;

    protected ImageIconUIResource questionIconOptionPane;

    protected ImageIconUIResource informationIconOptionPane;

    //---------------------------------------------------
    //Proprieties JFileChooser
    protected ImageIconUIResource iconComputerFileChooser;

    protected ImageIconUIResource iconDirectoryFileChooser;

    protected ImageIconUIResource iconFileFileChooser;

    protected ImageIconUIResource iconFloppyDriveFileChooser;

    protected ImageIconUIResource iconHardDriveFileChooser;

    protected ImageIconUIResource iconHomeFileChooser;

    protected ImageIconUIResource iconListFileChooser;

    protected ImageIconUIResource iconDetailsFileChooser;

    protected ImageIconUIResource iconNewFolderFileChooser;

    protected ImageIconUIResource iconUpFolderFileChooser;

    //---------------------------------------------------
    //Proprieties JProgressBar
    protected ColorUIResource backgroundProgressBar;

    protected ColorUIResource foregroundProgressBar;

    protected BorderUIResource borderProgressBar;

    //---------------------------------------------------
    //All type of font supported to the look and feel
    protected FontUIResource fontBold;

    protected FontUIResource fontItalic;

    protected FontUIResource fontRegular;

    protected FontUIResource fontMedium;


    // Abstract method
    public abstract void installTheme();

    public void installUIDefault(UIDefaults table){
        //do nothing
    }

    protected abstract void installColor();

    protected void installFonts(){
        //Install font default
    }

    protected abstract void installIcons();

    public abstract String getName();

    protected void installBorders(){
        //button border
        buttonBorder = new BorderUIResource(BorderFactory.createEmptyBorder(8, 12, 8, 12));
        borderMenu = new BorderUIResource(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        borderMenuBar = MaterialBorders.LIGHT_SHADOW_BORDER;
        borderPopupMenu = MaterialBorders.LIGHT_LINE_BORDER;
        borderSpinner = MaterialBorders.LIGHT_LINE_BORDER;
        arrowButtonBorderSpinner = new BorderUIResource(BorderFactory.createEmptyBorder());
        borderPanel = new BorderUIResource(BorderFactory.createEmptyBorder());
        arrowButtonBorderScrollBar = new BorderUIResource(BorderFactory.createEmptyBorder());
        borderSlider = new BorderUIResource(BorderFactory.createCompoundBorder(MaterialBorders.LIGHT_LINE_BORDER, BorderFactory.createEmptyBorder(15, 15, 15, 15)));
        cellBorderTableHeader = new BorderUIResource(BorderFactory.createCompoundBorder(
                                        MaterialBorders.LIGHT_LINE_BORDER,
                                        BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        borderToolBar = MaterialBorders.LIGHT_LINE_BORDER;
        borderTextField = new BorderUIResource(BorderFactory.createEmptyBorder(3, 5, 2, 5));
        borderTaskPane = borderPanel;
        focusCellHighlightBorder = new BorderUIResource(BorderFactory.createEmptyBorder());
        borderItemList = new BorderUIResource(BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(),
                                         BorderFactory.createEmptyBorder(2, 5, 2, 5)));

        tabInsetsTabbedPane = new InsetsUIResource(6, 10, 10, 10);
        selectedTabInsetsTabbedPane = new InsetsUIResource(6, 10, 10, 10);

        borderFrameRootPane = new BorderUIResource(BorderFactory.createEmptyBorder());
        borderDialogRootPane = MaterialBorders.LIGHT_SHADOW_BORDER;

        borderProgressBar = MaterialBorders.LIGHT_LINE_BORDER;
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

    public ColorUIResource getButtonColorHighlight() {
        return buttonColorHighlight;
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

    @Override
    public int getArcButton() {
        return 7;
    }

    @Override
    public boolean getOpaqueButton() {
        return false;
    }

    //Proprieties JCheckBox
    public ImageIconUIResource getUnselectedCheckBoxIcon() {
        return unselectedCheckBoxIcon;
    }

    public ImageIconUIResource getSelectedCheckBoxIcon() {
        return selectedCheckBoxIcon;
    }

    //Proprieties JComboBox
    public ColorUIResource getSelectedInDropDownBackgroundComboBox() {
        return selectedInDropDownBackgroundComboBox;
    }

    public ColorUIResource getSelectedForegroundComboBox() {
        return selectedForegroundComboBox;
    }

    public BorderUIResource getBorderComboBox() {
        return borderComboBox;
    }


    @Override
    public boolean getMouseHoverEnableComboBox() {
        return false;
    }

    @Override
    public int getArchBorderComboBox() {
        return 7;
    }

    //Getter for all component of the menu
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

    public BorderUIResource getBorderMenu() {
        return borderMenu;
    }

    public BorderUIResource getBorderMenuBar() {
        return borderMenuBar;
    }

    @Override
    public boolean getMouseHoverEnableMenu() {
        return true;
    }

    //get radiobutton
    public ImageIconUIResource getUnselectedRadioButtonIcon() {
        return unselectedRadioButtonIcon;
    }

    public ImageIconUIResource getSelectedRadioButtonIcon() {
        return selectedRadioButtonIcon;
    }

    // get for JPopupMenu
    public BorderUIResource getBorderPopupMenu() {
        return borderPopupMenu;
    }

    // get for JSpinner
    public ColorUIResource getArrowButtonBackgroundSpinner() {
        return arrowButtonBackgroundSpinner;
    }

    public ColorUIResource getMouseHoverButtonColorSpinner() {
        return mouseHoverButtonColorSpinner;
    }

    public BorderUIResource getBorderSpinner() {
        return borderSpinner;
    }

    public BorderUIResource getArrowButtonBorderSpinner() {
        return arrowButtonBorderSpinner;
    }

    @Override
    public boolean getMouseHoverEnableSpinner() {
        return true;
    }

    //get fro JPanel and JScrollPanel
    public BorderUIResource getBorderPanel() {
        return borderPanel;
    }

    //getter JScrollBar
    public ColorUIResource getTrackColorScrollBar() {
        return trackColorScrollBar;
    }

    public ColorUIResource getThumbColorScrollBar() {
        return thumbColorScrollBar;
    }

    public ColorUIResource getThumbDarkShadowColorScrollBar() {
        return thumbDarkShadowColorScrollBar;
    }

    public ColorUIResource getThumbHighlightColorScrollBar() {
        return thumbHighlightColorScrollBar;
    }

    public ColorUIResource getThumbShadowColorScrollBar() {
        return thumbShadowColorScrollBar;
    }

    public ColorUIResource getMouseHoverColorScrollBar() {
        return mouseHoverColorScrollBar;
    }

    public ColorUIResource getArrowButtonColorScrollBar() {
        return arrowButtonColorScrollBar;
    }

    public ColorUIResource getArrowButtonOnClickColorScrollBar() {
        return arrowButtonOnClickColorScrollBar;
    }

    public BorderUIResource getArrowButtonBorderScrollBar() {
        return arrowButtonBorderScrollBar;
    }

    @Override
    public boolean getMouseHoverEnableScrollBar() {
        return true;
    }

    @Override
    public boolean getEnableArrowScrollBar() {
        return false;
    }

    //get jslider
    public ColorUIResource getTrackColorSlider() {
        return trackColorSlider;
    }

    public ColorUIResource getHaloColorSlider() {
        return haloColorSlider;
    }

    public BorderUIResource getBorderSlider() {
        return borderSlider;
    }

    //get for JTabbedPane
    public ColorUIResource getHighlightColorTabbedPane() {
        return highlightColorTabbedPane;
    }

    public ColorUIResource getBorderHighlightColorTabbedPane() {
        return borderHighlightColorTabbedPane;
    }

    public ColorUIResource getFocusColorLineTabbedPane() {
        return focusColorLineTabbedPane;
    }

    public ColorUIResource getDisableColorTabTabbedPane() {
        return disableColorTabTabbedPane;
    }

    public InsetsUIResource getTabInsetsTabbedPane() {
        return tabInsetsTabbedPane;
    }

    public InsetsUIResource getSelectedTabInsetsTabbedPane() {
        return selectedTabInsetsTabbedPane;
    }

    @Override
    public int getLinePositionYTabbedPane() {
        return 50;
    }

    @Override
    public int getLinePositionXTabbedPane() {
        return 0;
    }

    @Override
    public int getLineWithTabbedPane() {
        return 2;
    }

    @Override
    public int getLineHeightTabbedPane() {
        return 5;
    }

    @Override
    public int getLineArchTabbedPane() {
        return 0;
    }

    @Override
    public int getIndentTabbedPane() {
        return 4;
    }

    @Override
    public int getSpacerTabbedPane() {
        return 20;
    }

    @Override
    public boolean getMouseHoverEnableTabbedPane() {
        return true;
    }

    //Getter for JTable
    public ColorUIResource getBackgroundTable() {
        return backgroundTable;
    }

    public ColorUIResource getForegroundTable() {
        return foregroundTable;
    }

    public ColorUIResource getSelectionBackgroundTable() {
        return selectionBackgroundTable;
    }

    public ColorUIResource getSelectionForegroundTable() {
        return selectionForegroundTable;
    }

    public ColorUIResource getGridColorTable() {
        return gridColorTable;
    }

    public ColorUIResource getAlternateRowBackgroundTable() {
        return alternateRowBackgroundTable;
    }

    public BorderUIResource getBorderTable() {
        return borderTable;
    }

    public ImageIconUIResource getUnselectedCheckBoxIconTable() {
        return unselectedCheckBoxIconTable;
    }

    public ImageIconUIResource getSelectedCheckBoxIconTable() {
        return selectedCheckBoxIconTable;
    }

    @Override
    public boolean getTableFocusable() {
        return true;
    }

    @Override
    public boolean getTableOpaque() {
        return false;
    }

    @Override
    public boolean getAlternateRowColorEnableTable() {
        return true;
    }

    @Override
    public int getHeightRowTable() {
        return 4;
    }

    public ColorUIResource getBackgroundTableHeader() {
        return backgroundTableHeader;
    }

    public ColorUIResource getForegroundTableHeader() {
        return foregroundTableHeader;
    }

    public BorderUIResource getBorderTableHeader() {
        return borderTableHeader;
    }

    public BorderUIResource getCellBorderTableHeader() {
        return cellBorderTableHeader;
    }

    //---------------------------------------------------
    //Proprieties JToolBar
    public ColorUIResource getDockingBackgroundToolBar() {
        return dockingBackgroundToolBar;
    }

    public ColorUIResource getFloatingBackgroundToolBar() {
        return floatingBackgroundToolBar;
    }

    public BorderUIResource getBorderToolBar() {
        return borderToolBar;
    }

    //---------------------------------------------------
    //Proprieties JTextField and JPasswordField
    public ColorUIResource getBackgroundTextField() {
        return backgroundTextField;
    }

    public ColorUIResource getInactiveForegroundTextField() {
        return inactiveForegroundTextField;
    }

    public ColorUIResource getInactiveBackgroundTextField() {
        return inactiveBackgroundTextField;
    }

    public ColorUIResource getSelectionBackgroundTextField() {
        return selectionBackgroundTextField;
    }

    public ColorUIResource getSelectionForegroundTextField() {
        return selectionForegroundTextField;
    }

    public ColorUIResource getInactiveColorLineTextField() {
        return inactiveColorLineTextField;
    }

    public ColorUIResource getActiveColorLineTextField() {
        return activeColorLineTextField;
    }

    public BorderUIResource getBorderTextField() {
        return borderTextField;
    }

    //---------------------------------------------------
    //Proprieties JTree
    public ColorUIResource getSelectionForegroundTree() {
        return selectionForegroundTree;
    }

    public ColorUIResource getSelectionBackgroundTree() {
        return selectionBackgroundTree;
    }

    public ColorUIResource getSelectionBorderColorTree() {
        return selectionBorderColorTree;
    }

    public ImageIconUIResource getClosedIconTree() {
        return closedIconTree;
    }

    public ImageIconUIResource getOpenIconTree() {
        return openIconTree;
    }

    //---------------------------------------------------
    //Proprieties JXTaskPane
    public ColorUIResource getTitleBackgroundGradientStartTaskPane() {
        return titleBackgroundGradientStartTaskPane;
    }

    public ColorUIResource getTitleBackgroundGradientEndTaskPane() {
        return titleBackgroundGradientEndTaskPane;
    }

    public ColorUIResource getTitleOverTaskPane() {
        return titleOverTaskPane;
    }

    public ColorUIResource getSpecialTitleOverTaskPane() {
        return specialTitleOverTaskPane;
    }

    public ColorUIResource getBackgroundTaskPane() {
        return backgroundTaskPane;
    }

    public ColorUIResource getBorderColorTaskPane() {
        return borderColorTaskPane;
    }

    public ColorUIResource getContentBackgroundTaskPane() {
        return contentBackgroundTaskPane;
    }

    public BorderUIResource getBorderTaskPane() {
        return borderTaskPane;
    }

    public ImageIconUIResource getYesCollapsedTaskPane() {
        return yesCollapsedTaskPane;
    }

    public ImageIconUIResource getNoCollapsedTaskPane() {
        return noCollapsedTaskPane;
    }

    //---------------------------------------------------
    //Proprieties JList
    public ColorUIResource getSelectionBackgroundList() {
        return selectionBackgroundList;
    }

    public ColorUIResource getSelectionForegroundList() {
        return selectionForegroundList;
    }

    public BorderUIResource getFocusCellHighlightBorder() {
        return focusCellHighlightBorder;
    }

    public BorderUIResource getBorderItemList() {
        return borderItemList;
    }

    public BorderUIResource getBorderList() {
        return borderList;
    }

    //---------------------------------------------------
    //Proprieties JRootPane
    public BorderUIResource getBorderFrameRootPane() {
        return borderFrameRootPane;
    }

    public BorderUIResource getBorderDialogRootPane() {
        return borderDialogRootPane;
    }

    //---------------------------------------------------
    //Proprieties JFileChooser
    public ImageIconUIResource getIconComputerFileChooser() {
        return iconComputerFileChooser;
    }

    public ImageIconUIResource getIconDirectoryFileChooser() {
        return iconDirectoryFileChooser;
    }

    public ImageIconUIResource getIconFileFileChooser() {
        return iconFileFileChooser;
    }

    public ImageIconUIResource getIconFloppyDriveFileChooser() {
        return iconFloppyDriveFileChooser;
    }

    public ImageIconUIResource getIconHardDriveFileChooser() {
        return iconHardDriveFileChooser;
    }

    public ImageIconUIResource getIconHomeFileChooser() {
        return iconHomeFileChooser;
    }

    public ImageIconUIResource getIconListFileChooser() {
        return iconListFileChooser;
    }

    public ImageIconUIResource getIconDetailsFileChooser() {
        return iconDetailsFileChooser;
    }

    public ImageIconUIResource getIconNewFolderFileChooser() {
        return iconNewFolderFileChooser;
    }

    public ImageIconUIResource getIconUpFolderFileChooser() {
        return iconUpFolderFileChooser;
    }

    //---------------------------------------------------
    //Proprieties JOptionPane
    public ColorUIResource getBackgroundOptionPane() {
        return backgroundOptionPane;
    }

    public ImageIconUIResource getWarningIconOptionPane() {
        return warningIconOptionPane;
    }

    public ImageIconUIResource getErrorIconIconOptionPane() {
        return errorIconIconOptionPane;
    }

    public ImageIconUIResource getQuestionIconOptionPane() {
        return questionIconOptionPane;
    }

    public ImageIconUIResource getInformationIconOptionPane() {
        return informationIconOptionPane;
    }

    @Override
    public boolean getEnableIconOptionPane() {
        return false;
    }

    //---------------------------------------------------
    //Proprieties JProgressBar
    public ColorUIResource getBackgroundProgressBar() {
        return backgroundProgressBar;
    }

    public ColorUIResource getForegroundProgressBar() {
        return foregroundProgressBar;
    }

    public BorderUIResource getBorderProgressBar() {
        return borderProgressBar;
    }

    //get fonts
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
