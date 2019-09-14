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


}
