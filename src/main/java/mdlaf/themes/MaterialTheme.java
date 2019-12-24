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

import sun.swing.ImageIconUIResource;

import javax.swing.*;
import javax.swing.plaf.BorderUIResource;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.FontUIResource;
import javax.swing.plaf.InsetsUIResource;
import java.awt.*;

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

    ColorUIResource getButtonColorHighlight();

    BorderUIResource getButtonBorder();

    FontUIResource getButtonFont();

    boolean getMouseHoverButtonEnable();

    boolean getButtonFocusable();

    boolean getButtonBorderEnable();

    boolean getButtonBorderEnableToAll();

    boolean getOpaqueButton();

    int getArcButton();

    //-----------------------------------
    //Proprieties JCheckBox

    ImageIconUIResource getUnselectedCheckBoxIcon();

    ImageIconUIResource getSelectedCheckBoxIcon();

    //-----------------------------------
    //Proprieties JComboBox

    ColorUIResource getSelectedInDropDownBackgroundComboBox();

    ColorUIResource getSelectedForegroundComboBox();

    BorderUIResource getBorderComboBox();

    boolean getMouseHoverEnableComboBox();

    boolean getLightWeightPopupEnabledComboBox();

    boolean getFocusableComboBox();

    int getArchBorderComboBox();

    //-----------------------------------
    //Proprieties All component inside the menu
    ColorUIResource getMenuBackground();

    ColorUIResource getMenuTextColor();

    ColorUIResource getMenuBackgroundMouseHover();

    ColorUIResource getMenuDisableBackground();

    BorderUIResource getBorderMenu();

    BorderUIResource getBorderMenuBar();

    boolean getMouseHoverEnableMenu();

    Icon getMenuArrowIcon();

    ColorUIResource getMenuArrowHoverColor();

    int getMenuArrowHeight();

    int getMenuArrowWidth();

    //-----------------------------------
    //Proprieties JRadioButton
    ImageIconUIResource getUnselectedRadioButtonIcon();

    ImageIconUIResource getSelectedRadioButtonIcon();

    //-----------------------------------
    //Proprieties JPopupMenu
    BorderUIResource getBorderPopupMenu();

    //-----------------------------------
    //Proprieties JSpinner
    ColorUIResource getArrowButtonBackgroundSpinner();

    ColorUIResource getMouseHoverButtonColorSpinner();

    BorderUIResource getBorderSpinner();

    BorderUIResource getArrowButtonBorderSpinner();

    boolean getMouseHoverEnableSpinner();

    //-----------------------------------
    //Proprieties JPanel JScrollPane
    BorderUIResource getBorderPanel();

    //---------------------------------------------------
    //Proprieties JScrollBar
    ColorUIResource getTrackColorScrollBar();

    ColorUIResource getThumbColorScrollBar();

    ColorUIResource getThumbDarkShadowColorScrollBar();

    ColorUIResource getThumbHighlightColorScrollBar();

    ColorUIResource getThumbShadowColorScrollBar();

    ColorUIResource getMouseHoverColorScrollBar();

    ColorUIResource getArrowButtonColorScrollBar();

    ColorUIResource getArrowButtonOnClickColorScrollBar();

    BorderUIResource getArrowButtonBorderScrollBar();

    boolean getMouseHoverEnableScrollBar();

    boolean getEnableArrowScrollBar();

    //---------------------------------------------------
    //Proprieties JSlider
    ColorUIResource getTrackColorSlider();

    ColorUIResource getHaloColorSlider();

    BorderUIResource getBorderSlider();

    //---------------------------------------------------
    //Proprieties JTabbedPane
    ColorUIResource getHighlightColorTabbedPane();

    ColorUIResource getBorderHighlightColorTabbedPane();

    ColorUIResource getFocusColorLineTabbedPane();

    ColorUIResource getDisableColorTabTabbedPane();

    InsetsUIResource getTabInsetsTabbedPane();

    InsetsUIResource getSelectedTabInsetsTabbedPane();

    boolean getMouseHoverEnableTabbedPane();

    int getLinePositionYTabbedPane();

    int getLinePositionXTabbedPane();

    int getLineWithTabbedPane();

    int getLineHeightTabbedPane();

    int getLineArchTabbedPane();

    int getIndentTabbedPane();

    int getSpacerTabbedPane();

    //---------------------------------------------------
    //Proprieties JTable
    ColorUIResource getBackgroundTable();

    ColorUIResource getForegroundTable();

    ColorUIResource getSelectionBackgroundTable();

    ColorUIResource getSelectionForegroundTable();

    ColorUIResource getGridColorTable();

    ColorUIResource getAlternateRowBackgroundTable();

    BorderUIResource getBorderTable();

    ImageIconUIResource getUnselectedCheckBoxIconTable();

    ImageIconUIResource getSelectedCheckBoxIconTable();

    ImageIconUIResource getUnselectedCheckBoxIconSelectionRowTable();

    ImageIconUIResource getSelectedCheckBoxIconSelectionRowTable();

    boolean getTableFocusable();

    boolean getTableOpaque();

    boolean getAlternateRowColorEnableTable();

    int getHeightRowTable();

    //JTableHeader
    ColorUIResource getBackgroundTableHeader();

    ColorUIResource getForegroundTableHeader();

    BorderUIResource getBorderTableHeader();

    BorderUIResource getCellBorderTableHeader();

    //---------------------------------------------------
    //Proprieties JToolBar
    ColorUIResource getDockingBackgroundToolBar();

    ColorUIResource getFloatingBackgroundToolBar();

    BorderUIResource getBorderToolBar();

    //---------------------------------------------------
    //Proprieties JTree
    ColorUIResource getSelectionForegroundTree();

    ColorUIResource getSelectionBackgroundTree();

    ColorUIResource getSelectionBorderColorTree();

    ImageIconUIResource getClosedIconTree();

    ImageIconUIResource getOpenIconTree();

    //---------------------------------------------------
    //Proprieties JTextField and JPasswordField
    ColorUIResource getBackgroundTextField();

    ColorUIResource getInactiveForegroundTextField();

    ColorUIResource getInactiveBackgroundTextField();

    ColorUIResource getSelectionBackgroundTextField();

    ColorUIResource getSelectionForegroundTextField();

    ColorUIResource getInactiveColorLineTextField();

    ColorUIResource getActiveColorLineTextField();

    BorderUIResource getBorderTextField();

    char getEchoCharPasswordField();

    //---------------------------------------------------
    //Proprieties JXTaskPane
    ColorUIResource getTitleBackgroundGradientStartTaskPane();

    ColorUIResource getTitleBackgroundGradientEndTaskPane();

    ColorUIResource getTitleOverTaskPane();

    ColorUIResource getSpecialTitleOverTaskPane();

    ColorUIResource getBackgroundTaskPane();

    ColorUIResource getBorderColorTaskPane();

    ColorUIResource getContentBackgroundTaskPane();

    BorderUIResource getBorderTaskPane();

    ImageIconUIResource getYesCollapsedTaskPane();

    ImageIconUIResource getNoCollapsedTaskPane();

    //---------------------------------------------------
    //Proprieties JList
    ColorUIResource getSelectionBackgroundList();

    ColorUIResource getSelectionForegroundList();

    BorderUIResource getFocusCellHighlightBorder();

    BorderUIResource getBorderItemList();

    BorderUIResource getBorderList();

    //---------------------------------------------------
    //Proprieties JRootPane
    BorderUIResource getBorderFrameRootPane();

    BorderUIResource getBorderDialogRootPane();

    //---------------------------------------------------
    //Proprieties JOptionPane
    ColorUIResource getBackgroundOptionPane();

    ImageIconUIResource getWarningIconOptionPane();

    ImageIconUIResource getErrorIconIconOptionPane();

    ImageIconUIResource getQuestionIconOptionPane();

    ImageIconUIResource getInformationIconOptionPane();

    boolean getEnableIconOptionPane();

    //---------------------------------------------------
    //Proprieties JFileChooser
    ImageIconUIResource getIconComputerFileChooser();

    ImageIconUIResource getIconDirectoryFileChooser();

    ImageIconUIResource getIconFileFileChooser();

    ImageIconUIResource getIconFloppyDriveFileChooser();

    ImageIconUIResource getIconHardDriveFileChooser();

    ImageIconUIResource getIconHomeFileChooser();

    ImageIconUIResource getIconListFileChooser();

    ImageIconUIResource getIconDetailsFileChooser();

    ImageIconUIResource getIconNewFolderFileChooser();

    ImageIconUIResource getIconUpFolderFileChooser();

    //---------------------------------------------------
    //Proprieties JProgressBar
    ColorUIResource getBackgroundProgressBar();

    ColorUIResource getForegroundProgressBar();

    BorderUIResource getBorderProgressBar();

    //All type of font supported to the theme
    FontUIResource getFontBold();

    FontUIResource getFontItalic();

    FontUIResource getFontRegular();

    FontUIResource getFontMedium();


    //Setter
    void setBackgroundPrimary(ColorUIResource backgroundPrimary);

    void setHighlightBackgroundPrimary(ColorUIResource highlightBackgroundPrimary);

    void setTextColor(ColorUIResource textColor);

    public void setDisableTextColor(ColorUIResource disableTextColor);

    public void setButtonBackgroundColor(ColorUIResource buttonBackgroundColor);

    public void setButtonTextColor(ColorUIResource buttonTextColor);

    public void setButtonBackgroundColorMouseHover(ColorUIResource buttonBackgroundColorMouseHover);

    public void setButtonDefaultBackgroundColor(ColorUIResource buttonDefaultBackgroundColor);

    public void setButtonDefaultTextColor(ColorUIResource buttonDefaultTextColor);

    public void setButtonDefaultBackgroundColorMouseHover(ColorUIResource buttonDefaultBackgroundColorMouseHover);

    public void setButtonDisabledBackground(ColorUIResource buttonDisabledBackground);

    public void setButtonDisabledForeground(ColorUIResource buttonDisabledForeground);

    public void setButtonFocusColor(ColorUIResource buttonFocusColor);

    public void setButtonDefaultFocusColor(ColorUIResource buttonDefaultFocusColor);

    public void setButtonBorderColor(ColorUIResource buttonBorderColor);

    public void setButtonColorHighlight(ColorUIResource buttonColorHighlight);

    public void setButtonBorder(BorderUIResource buttonBorder);

    public void setUnselectedCheckBoxIcon(ImageIconUIResource unselectedCheckBoxIcon);

    public void setSelectedCheckBoxIcon(ImageIconUIResource selectedCheckBoxIcon);

    public void setSelectedInDropDownBackgroundComboBox(ColorUIResource selectedInDropDownBackgroundComboBox);

    public void setSelectedForegroundComboBox(ColorUIResource selectedForegroundComboBox);

    public void setMenuBackground(ColorUIResource menuBackground);

    public void setMenuTextColor(ColorUIResource menuTextColor);

    public void setMenuBackgroundMouseHover(ColorUIResource menuBackgroundMouseHover);

    public void setMenuDisableBackground(ColorUIResource menuDisableBackground);

    public void setBorderMenu(BorderUIResource borderMenu);

    public void setBorderMenuBar(BorderUIResource borderMenuBar);

    public void setUnselectedRadioButtonIcon(ImageIconUIResource unselectedRadioButtonIcon);

    public void setSelectedRadioButtonIcon(ImageIconUIResource selectedRadioButtonIcon);

    public void setBorderPopupMenu(BorderUIResource borderPopupMenu);

    public void setArrowButtonBackgroundSpinner(ColorUIResource arrowButtonBackgroundSpinner);

    public void setMouseHoverButtonColorSpinner(ColorUIResource mouseHoverButtonColorSpinner);

    public void setBorderSpinner(BorderUIResource borderSpinner);

    public void setArrowButtonBorderSpinner(BorderUIResource arrowButtonBorderSpinner);

    public void setBorderPanel(BorderUIResource borderPanel);

    public void setTrackColorScrollBar(ColorUIResource trackColorScrollBar);

    public void setThumbColorScrollBar(ColorUIResource thumbColorScrollBar);

    public void setThumbDarkShadowColorScrollBar(ColorUIResource thumbDarkShadowColorScrollBar);

    public void setThumbHighlightColorScrollBar(ColorUIResource thumbHighlightColorScrollBar);

    public void setThumbShadowColorScrollBar(ColorUIResource thumbShadowColorScrollBar);

    public void setMouseHoverColorScrollBar(ColorUIResource mouseHoverColorScrollBar);

    public void setArrowButtonColorScrollBar(ColorUIResource arrowButtonColorScrollBar);

    public void setArrowButtonOnClickColorScrollBar(ColorUIResource arrowButtonOnClickColorScrollBar);

    public void setArrowButtonBorderScrollBar(BorderUIResource arrowButtonBorderScrollBar);

    public void setTrackColorSlider(ColorUIResource trackColorSlider);

    public void setHaloColorSlider(ColorUIResource haloColorSlider);

    public void setBorderSlider(BorderUIResource borderSlider);

    public void setHighlightColorTabbedPane(ColorUIResource highlightColorTabbedPane);

    public void setBorderHighlightColorTabbedPane(ColorUIResource borderHighlightColorTabbedPane);

    public void setFocusColorLineTabbedPane(ColorUIResource focusColorLineTabbedPane);

    public void setDisableColorTabTabbedPane(ColorUIResource disableColorTabTabbedPane);

    public void setTabInsetsTabbedPane(InsetsUIResource tabInsetsTabbedPane);

    public void setSelectedTabInsetsTabbedPane(InsetsUIResource selectedTabInsetsTabbedPane);

    public void setBackgroundTable(ColorUIResource backgroundTable);

    public void setBackgroundTableHeader(ColorUIResource backgroundTableHeader);

    public void setForegroundTable(ColorUIResource foregroundTable);

    public void setForegroundTableHeader(ColorUIResource foregroundTableHeader);

    public void setSelectionBackgroundTable(ColorUIResource selectionBackgroundTable);

    public void setSelectionForegroundTable(ColorUIResource selectionForegroundTable);

    public void setGridColorTable(ColorUIResource gridColorTable);

    public void setAlternateRowBackgroundTable(ColorUIResource alternateRowBackgroundTable);

    public void setBorderTable(BorderUIResource borderTable);

    public void setBorderTableHeader(BorderUIResource borderTableHeader);

    public void setCellBorderTableHeader(BorderUIResource cellBorderTableHeader);

    public void setUnselectedCheckBoxIconTable(ImageIconUIResource unselectedCheckBoxIconTable);

    public void setSelectedCheckBoxIconTable(ImageIconUIResource selectedCheckBoxIconTable);

    public void setUnselectedCheckBoxIconSelectionRowTable(ImageIconUIResource unselectedCheckBoxIconSelectionRowTable);

    public void setSelectedCheckBoxIconSelectionRowTable(ImageIconUIResource selectedCheckBoxIconSelectionRowTable);

    public void setDockingBackgroundToolBar(ColorUIResource dockingBackgroundToolBar);

    public void setFloatingBackgroundToolBar(ColorUIResource floatingBackgroundToolBar);

    public void setBorderToolBar(BorderUIResource borderToolBar);

    public void setSelectionForegroundTree(ColorUIResource selectionForegroundTree);

    public void setSelectionBackgroundTree(ColorUIResource selectionBackgroundTree);

    public void setSelectionBorderColorTree(ColorUIResource selectionBorderColorTree);

    public void setClosedIconTree(ImageIconUIResource closedIconTree);

    public void setOpenIconTree(ImageIconUIResource openIconTree);

    public void setBackgroundTextField(ColorUIResource backgroundTextField);

    public void setInactiveForegroundTextField(ColorUIResource inactiveForegroundTextField);

    public void setInactiveBackgroundTextField(ColorUIResource inactiveBackgroundTextField);

    public void setSelectionBackgroundTextField(ColorUIResource selectionBackgroundTextField);

    public void setSelectionForegroundTextField(ColorUIResource selectionForegroundTextField);

    public void setInactiveColorLineTextField(ColorUIResource inactiveColorLineTextField);

    public void setActiveColorLineTextField(ColorUIResource activeColorLineTextField);

    public void setBorderTextField(BorderUIResource borderTextField);

    public void setTitleBackgroundGradientStartTaskPane(ColorUIResource titleBackgroundGradientStartTaskPane);

    public void setTitleBackgroundGradientEndTaskPane(ColorUIResource titleBackgroundGradientEndTaskPane);

    public void setTitleOverTaskPane(ColorUIResource titleOverTaskPane);

    public void setSpecialTitleOverTaskPane(ColorUIResource specialTitleOverTaskPane);

    public void setBackgroundTaskPane(ColorUIResource backgroundTaskPane);

    public void setBorderColorTaskPane(ColorUIResource borderColorTaskPane);

    public void setContentBackgroundTaskPane(ColorUIResource contentBackgroundTaskPane);

    public void setBorderTaskPane(BorderUIResource borderTaskPane);

    public void setYesCollapsedTaskPane(ImageIconUIResource yesCollapsedTaskPane);

    public void setNoCollapsedTaskPane(ImageIconUIResource noCollapsedTaskPane);

    public void setSelectionBackgroundList(ColorUIResource selectionBackgroundList);

    public void setSelectionForegroundList(ColorUIResource selectionForegroundList);

    public void setFocusCellHighlightBorder(BorderUIResource focusCellHighlightBorder);

    public void setBorderItemList(BorderUIResource borderItemList);

    public void setBorderList(BorderUIResource borderList);

    public void setBorderFrameRootPane(BorderUIResource borderFrameRootPane);

    public void setBorderDialogRootPane(BorderUIResource borderDialogRootPane);

    public void setBackgroundOptionPane(ColorUIResource backgroundOptionPane);

    public void setWarningIconOptionPane(ImageIconUIResource warningIconOptionPane);

    public void setErrorIconIconOptionPane(ImageIconUIResource errorIconIconOptionPane);

    public void setQuestionIconOptionPane(ImageIconUIResource questionIconOptionPane);

    public void setInformationIconOptionPane(ImageIconUIResource informationIconOptionPane);

    public void setIconComputerFileChooser(ImageIconUIResource iconComputerFileChooser);

    public void setIconDirectoryFileChooser(ImageIconUIResource iconDirectoryFileChooser);

    public void setIconFileFileChooser(ImageIconUIResource iconFileFileChooser);

    public void setIconFloppyDriveFileChooser(ImageIconUIResource iconFloppyDriveFileChooser);

    public void setIconHardDriveFileChooser(ImageIconUIResource iconHardDriveFileChooser);

    public void setIconHomeFileChooser(ImageIconUIResource iconHomeFileChooser);

    public void setIconListFileChooser(ImageIconUIResource iconListFileChooser);

    public void setIconDetailsFileChooser(ImageIconUIResource iconDetailsFileChooser);

    public void setIconNewFolderFileChooser(ImageIconUIResource iconNewFolderFileChooser);

    public void setIconUpFolderFileChooser(ImageIconUIResource iconUpFolderFileChooser);

    public void setBackgroundProgressBar(ColorUIResource backgroundProgressBar);

    public void setForegroundProgressBar(ColorUIResource foregroundProgressBar);

    public void setBorderComboBox(BorderUIResource borderComboBox);

    public void setBorderProgressBar(BorderUIResource borderProgressBar);

    public void setFontBold(FontUIResource fontBold);

    public void setFontItalic(FontUIResource fontItalic);

    public void setFontRegular(FontUIResource fontRegular);

    public void setFontMedium(FontUIResource fontMedium);

}
