/*
 * MIT License
 *
 * Copyright (c) 2019-2020 Vincenzo Palazzo vincenzopalazzodev@gmail.com
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

import javax.swing.*;
import javax.swing.plaf.*;

/**
 * @author https://github.com/vincenzopalazzo
 */
@SuppressWarnings("all")
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

    IconUIResource getUnselectedCheckBoxIcon();

    IconUIResource getSelectedCheckBoxIcon();

    //-----------------------------------
    //Proprieties JComboBox

    ColorUIResource getSelectedInDropDownBackgroundComboBox();

    ColorUIResource getSelectedForegroundComboBox();

    BorderUIResource getBorderComboBox();

    BorderUIResource getBorderItemComboBox();


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
    IconUIResource getUnselectedRadioButtonIcon();

    IconUIResource getSelectedRadioButtonIcon();

    //-----------------------------------
    //Proprieties JPopupMenu
    BorderUIResource getBorderPopupMenu();

    //-----------------------------------
    //Proprieties JSpinner
    ColorUIResource getArrowButtonBackgroundSpinner();

    ColorUIResource getMouseHoverButtonColorSpinner();

    BorderUIResource getBorderSpinner();

    BorderUIResource getArrowButtonBorderSpinner();

    IconUIResource getPreviousButtonIconSpinner();

    IconUIResource getNextButtonIconSpinner();

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

    //set methods
    void setPreviousButtonIconSpinner(IconUIResource previousButtonIconSpinner);

    void setNextButtonIconSpinner(IconUIResource nextButtonIconSpinner);

    void setUnselectedIconToggleButton(IconUIResource unselectedIconToggleButton);

    void setSelectedIconToggleButton(IconUIResource selectedIconToggleButton);

    public void setWithoutIconToggleButton(boolean withoutIconToggleButton);

    public void setWithoutIconSelectedBackgroundToggleButton(ColorUIResource withoutIconSelectedBackgroundToggleButton);

    public void setWithoutIconSelectedForegoundToggleButton(ColorUIResource withoutIconSelectedForegoundToggleButton);

    public void setWithoutIconBackgroundToggleButton(ColorUIResource withoutIconBackgroundToggleButton);

    public void setWithoutIconForegroundToggleButton(ColorUIResource withoutIconForegroundToggleButton);

    public void setWithoutIconSelectedBorderToggleButton(BorderUIResource withoutIconSelectedBorderToggleButton);

    public void setWithoutIconBorderToggleButton(BorderUIResource withoutIconBorderToggleButton);

    IconUIResource getUnselectedIconToggleButton();

    IconUIResource getSelectedIconToggleButton();

    public boolean isWithoutIconToggleButton();

    public ColorUIResource getWithoutIconSelectedBackgroundToggleButton();

    public ColorUIResource getWithoutIconSelectedForegoundToggleButton();

    public ColorUIResource getWithoutIconBackgroundToggleButton();

    public ColorUIResource getWithoutIconForegroundToggleButton();

    public BorderUIResource getWithoutIconSelectedBorderToggleButton();

    public BorderUIResource getWithoutIconBorderToggleButton();

    //---------------------------------------------------
    //Proprieties JSlider
    ColorUIResource getTrackColorSlider();

    ColorUIResource getHaloColorSlider();

    BorderUIResource getBorderSlider();

    //---------------------------------------------------
    //Proprieties JTabbedPane
    IconUIResource getDisabledBottomIconTabbedPane();

    IconUIResource getDisabledTopIconTabbedPane();

    IconUIResource getDisabledLeftIconTabbedPane();

    IconUIResource getDisabledRightIconTabbedPane();

    ColorUIResource getHighlightColorTabbedPane();

    ColorUIResource getBorderHighlightColorTabbedPane();

    ColorUIResource getFocusColorLineTabbedPane();

    ColorUIResource getDisableColorTabTabbedPane();

    InsetsUIResource getTabInsetsTabbedPane();

    InsetsUIResource getSelectedTabInsetsTabbedPane();

    IconUIResource getBottomIconTabbedPane();

    IconUIResource getTopIconTabbedPane();

    IconUIResource getLeftIconTabbedPane();

    IconUIResource getRightIconTabbedPane();

    ColorUIResource getColorIconTabbedPane();

    ColorUIResource getColorDisabledIconTabbedPane();

    boolean getMouseHoverEnableTabbedPane();

    int getLinePositionYTabbedPane();

    int getLinePositionXTabbedPane();

    int getLineWithTabbedPane();

    int getLineHeightTabbedPane();

    int getLineArchTabbedPane();

    int getIndentTabbedPane();

    int getSpacerTabbedPane();

    int getHeightTabTabbedPane();
    //---------------------------------------------------
    //Proprieties JTable
    ColorUIResource getBackgroundTable();

    ColorUIResource getForegroundTable();

    ColorUIResource getSelectionBackgroundTable();

    ColorUIResource getSelectionForegroundTable();

    ColorUIResource getGridColorTable();

    ColorUIResource getAlternateRowBackgroundTable();

    BorderUIResource getBorderTable();

    IconUIResource getUnselectedCheckBoxIconTable();

    IconUIResource getSelectedCheckBoxIconTable();

    IconUIResource getUnselectedCheckBoxIconSelectionRowTable();

    IconUIResource getSelectedCheckBoxIconSelectionRowTable();

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
    //Proprieties JSeparator
    ColorUIResource getBackgroundSeparator();

    ColorUIResource getForegroundSeparator();

    //---------------------------------------------------
    //Proprieties JToolBar
    ColorUIResource getDockingBackgroundToolBar();

    ColorUIResource getFloatingBackgroundToolBar();

    BorderUIResource getBorderToolBar();

    //---------------------------------------------------
    //Proprieties JToolTip
    ColorUIResource getBackgroundToolTip();

    ColorUIResource getForegroundToolTip();

    BorderUIResource getBorderToolTip();

    //---------------------------------------------------
    //Proprieties JTree
    ColorUIResource getSelectionForegroundTree();

    ColorUIResource getSelectionBackgroundTree();

    ColorUIResource getSelectionBorderColorTree();

    IconUIResource getClosedIconTree();

    IconUIResource getOpenIconTree();

    IconUIResource getLeafIconTree();

    BorderUIResource getBorderTree();

    //---------------------------------------------------
    //Proprieties JTextField and JPasswordField
    ColorUIResource getBackgroundTextField();

    ColorUIResource getInactiveForegroundTextField();

    ColorUIResource getInactiveBackgroundTextField();

    ColorUIResource getSelectionBackgroundTextField();

    ColorUIResource getSelectionForegroundTextField();

    ColorUIResource getDisabledBackgroudnTextField();

    ColorUIResource getDisabledForegroundTextField();

    ColorUIResource getInactiveColorLineTextField();

    ColorUIResource getActiveColorLineTextField();

    BorderUIResource getBorderTextField();

    char getEchoCharPasswordField();

    //---------------------------------------------------
    //Proprieties JXTaskPane
    ColorUIResource getTitleBackgroundGradientStartTaskPane();

    ColorUIResource getTitleBackgroundGradientEndTaskPane();

    ColorUIResource getTitleColorTaskPane();

    ColorUIResource getTitleOverTaskPane();

    ColorUIResource getSpecialTitleOverTaskPane();

    ColorUIResource getBackgroundTaskPane();

    ColorUIResource getBorderColorTaskPane();

    ColorUIResource getContentBackgroundTaskPane();

    BorderUIResource getBorderTaskPane();

    IconUIResource getYesCollapsedTaskPane();

    IconUIResource getNoCollapsedTaskPane();

    boolean getMouseHoverEnableTaskPane();

    int getArchTaskPane();

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

    IconUIResource getWarningIconOptionPane();

    IconUIResource getErrorIconIconOptionPane();

    IconUIResource getQuestionIconOptionPane();

    IconUIResource getInformationIconOptionPane();

    boolean getEnableIconOptionPane();

    //---------------------------------------------------
    //Proprieties JFileChooser
    IconUIResource getIconComputerFileChooser();

    IconUIResource getIconDirectoryFileChooser();

    IconUIResource getIconFileFileChooser();

    IconUIResource getIconFloppyDriveFileChooser();

    IconUIResource getIconHardDriveFileChooser();

    IconUIResource getIconHomeFileChooser();

    IconUIResource getIconListFileChooser();

    IconUIResource getIconDetailsFileChooser();

    IconUIResource getIconNewFolderFileChooser();

    IconUIResource getIconUpFolderFileChooser();

    //---------------------------------------------------
    //Proprieties JProgressBar
    ColorUIResource getBackgroundProgressBar();

    ColorUIResource getForegroundProgressBar();

    BorderUIResource getBorderProgressBar();

    //---------------------------------------------------
    //Proprieties JSplitPane

    ColorUIResource getColorDividierSplitPane();

    ColorUIResource getColorDividierFocusSplitPane();

    int getSizeDividierSplitPane();

    BorderUIResource getDividierBorderSplitPane();

    //---------------------------------------------------
    //Proprieties TitledBorder
    ColorUIResource getColorTextTitledBorder();

    BorderUIResource getBorderTitledBorder();

    //---------------------------------------------------
    //Proprieties TitleBorder
    IconUIResource getIconCloseTitlePane();

    //All type of font supported to the theme
    FontUIResource getFontBold();

    FontUIResource getFontItalic();

    FontUIResource getFontRegular();

    FontUIResource getFontMedium();


    //Setter
    void setBackgroundToolTip(ColorUIResource backgroundToolTip);

    void setForegroundToolTip(ColorUIResource foregroundToolTip);

    void setBorderToolTip(BorderUIResource borderToolTip);

    void setDisabledBottomIconTabbedPane(IconUIResource disabledBottomIconTabbedPane);

    void setDisabledTopIconTabbedPane(IconUIResource disabledTopIconTabbedPane);

    void setDisabledLeftIconTabbedPane(IconUIResource disabledLeftIconTabbedPane);

    void setDisabledRightIconTabbedPane(IconUIResource disabledRightIconTabbedPane);

    void setBottomIconTabbedPane(IconUIResource bottomIconTabbedPane);

    void setTopIconTabbedPane(IconUIResource topIconTabbedPane);

    void setLeftIconTabbedPane(IconUIResource leftIconTabbedPane);

    void setRightIconTabbedPane(IconUIResource rightIconTabbedPane);

    void setColorIconTabbedPane(ColorUIResource colorIconTabbedPane);

    void setColorDisabledIconTabbedPane(ColorUIResource colorDisabledIconTabbedPane);

    void setArchTaskPane(int archTaskPane);

    void setTitleColorTaskPane(ColorUIResource titleColorTaskPane);

    void setLeafIconTree(IconUIResource leafIconTree);

    void setBackgroundSeparator(ColorUIResource backgroundSeparator);

    void setForegroundSeparator(ColorUIResource foregroundSeparator);

    void setBorderTree(BorderUIResource borderTree);

    void setIconCloseTitlePane(IconUIResource iconCloseTitlePane);

    void setDisabledBackgroudnTextField(ColorUIResource disabledBackgroudnTextField);

    void setDisabledForegroundTextField(ColorUIResource disabledForegroundTextField);

    void setColorTextTitledBorder(ColorUIResource colorTextTitledBorder);

    void setBorderTitledBorder(BorderUIResource borderTitledBorder);

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

    public void setUnselectedCheckBoxIcon(IconUIResource unselectedCheckBoxIcon);

    public void setSelectedCheckBoxIcon(IconUIResource selectedCheckBoxIcon);

    public void setSelectedInDropDownBackgroundComboBox(ColorUIResource selectedInDropDownBackgroundComboBox);

    public void setSelectedForegroundComboBox(ColorUIResource selectedForegroundComboBox);

    public void setMenuBackground(ColorUIResource menuBackground);

    public void setMenuTextColor(ColorUIResource menuTextColor);

    public void setMenuBackgroundMouseHover(ColorUIResource menuBackgroundMouseHover);

    public void setMenuDisableBackground(ColorUIResource menuDisableBackground);

    public void setBorderMenu(BorderUIResource borderMenu);

    public void setBorderMenuBar(BorderUIResource borderMenuBar);

    public void setUnselectedRadioButtonIcon(IconUIResource unselectedRadioButtonIcon);

    public void setSelectedRadioButtonIcon(IconUIResource selectedRadioButtonIcon);

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

    public void setUnselectedCheckBoxIconTable(IconUIResource unselectedCheckBoxIconTable);

    public void setSelectedCheckBoxIconTable(IconUIResource selectedCheckBoxIconTable);

    public void setUnselectedCheckBoxIconSelectionRowTable(IconUIResource unselectedCheckBoxIconSelectionRowTable);

    public void setSelectedCheckBoxIconSelectionRowTable(IconUIResource selectedCheckBoxIconSelectionRowTable);

    public void setDockingBackgroundToolBar(ColorUIResource dockingBackgroundToolBar);

    public void setFloatingBackgroundToolBar(ColorUIResource floatingBackgroundToolBar);

    public void setBorderToolBar(BorderUIResource borderToolBar);

    public void setSelectionForegroundTree(ColorUIResource selectionForegroundTree);

    public void setSelectionBackgroundTree(ColorUIResource selectionBackgroundTree);

    public void setSelectionBorderColorTree(ColorUIResource selectionBorderColorTree);

    public void setClosedIconTree(IconUIResource closedIconTree);

    public void setOpenIconTree(IconUIResource openIconTree);

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

    public void setYesCollapsedTaskPane(IconUIResource yesCollapsedTaskPane);

    public void setNoCollapsedTaskPane(IconUIResource noCollapsedTaskPane);

    public void setSelectionBackgroundList(ColorUIResource selectionBackgroundList);

    public void setSelectionForegroundList(ColorUIResource selectionForegroundList);

    public void setFocusCellHighlightBorder(BorderUIResource focusCellHighlightBorder);

    public void setBorderItemList(BorderUIResource borderItemList);

    public void setBorderList(BorderUIResource borderList);

    public void setBorderFrameRootPane(BorderUIResource borderFrameRootPane);

    public void setBorderDialogRootPane(BorderUIResource borderDialogRootPane);

    public void setBackgroundOptionPane(ColorUIResource backgroundOptionPane);

    public void setWarningIconOptionPane(IconUIResource warningIconOptionPane);

    public void setErrorIconIconOptionPane(IconUIResource errorIconIconOptionPane);

    public void setQuestionIconOptionPane(IconUIResource questionIconOptionPane);

    public void setInformationIconOptionPane(IconUIResource informationIconOptionPane);

    public void setIconComputerFileChooser(IconUIResource iconComputerFileChooser);

    public void setIconDirectoryFileChooser(IconUIResource iconDirectoryFileChooser);

    public void setIconFileFileChooser(IconUIResource iconFileFileChooser);

    public void setIconFloppyDriveFileChooser(IconUIResource iconFloppyDriveFileChooser);

    public void setIconHardDriveFileChooser(IconUIResource iconHardDriveFileChooser);

    public void setIconHomeFileChooser(IconUIResource iconHomeFileChooser);

    public void setIconListFileChooser(IconUIResource iconListFileChooser);

    public void setIconDetailsFileChooser(IconUIResource iconDetailsFileChooser);

    public void setIconNewFolderFileChooser(IconUIResource iconNewFolderFileChooser);

    public void setIconUpFolderFileChooser(IconUIResource iconUpFolderFileChooser);

    public void setBackgroundProgressBar(ColorUIResource backgroundProgressBar);

    public void setForegroundProgressBar(ColorUIResource foregroundProgressBar);

    public void setBorderComboBox(BorderUIResource borderComboBox);

    public void setBorderProgressBar(BorderUIResource borderProgressBar);

    public void setFontBold(FontUIResource fontBold);

    public void setFontItalic(FontUIResource fontItalic);

    public void setFontRegular(FontUIResource fontRegular);

    public void setFontMedium(FontUIResource fontMedium);

    public void setColorDividierSplitPane(ColorUIResource colorDividierSplitPane);

    public void setColorDividierFocusSplitPane(ColorUIResource colorDividierFocusSplitPane);

    public void setSizeDividierSplitPane(int sizeDividierSplitPane);

    public void setDividierBorderSplitPane(BorderUIResource dividierBorderSplitPane);

}
