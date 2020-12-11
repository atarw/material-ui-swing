/*
 * MIT License
 *
 * Copyright (c) 2019-2021 Vincent Palazzo vincenzopalazzodev@gmail.com
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

import mdlaf.components.menu.MaterialMenuArrowIcon;
import mdlaf.utils.MaterialBorders;
import mdlaf.utils.MaterialColors;
import mdlaf.utils.MaterialFontFactory;
import mdlaf.utils.MaterialImageFactory;
import mdlaf.utils.icons.MaterialIconFont;

import javax.swing.*;
import javax.swing.plaf.*;

/**
 * @author https://github.com/vincenzopalazzo
 */
public abstract class AbstractMaterialTheme implements MaterialTheme {

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
    //Proprieties JToggleButton
    protected IconUIResource unselectedIconToggleButton;

    protected IconUIResource selectedIconToggleButton;

    protected IconUIResource disabledUnselectedIconToggleButton;

    protected IconUIResource disabledSelectedIconToggleButton;

    protected boolean withoutIconToggleButton = false;

    protected ColorUIResource withoutIconSelectedBackgroundToggleButton;

    protected ColorUIResource withoutIconSelectedForegoundToggleButton;

    protected ColorUIResource withoutIconBackgroundToggleButton;

    protected ColorUIResource withoutIconForegroundToggleButton;

    protected BorderUIResource withoutIconSelectedBorderToggleButton;

    protected BorderUIResource withoutIconBorderToggleButton;


    //---------------------------------------------------
    //Proprieties JCheckBox
    protected IconUIResource unselectedCheckBoxIcon;

    protected IconUIResource selectedCheckBoxIcon;

    protected IconUIResource disabledUnselectedCheckBoxIcon;

    protected IconUIResource disabledSelectedCheckBoxIcon;

    //---------------------------------------------------
    //Proprieties JComboBox
    protected ColorUIResource selectedInDropDownBackgroundComboBox;

    protected ColorUIResource selectedForegroundComboBox;

    protected BorderUIResource borderComboBox;

    protected BorderUIResource borderItemComboBox;

    protected IconUIResource buttonIconComboBox;

    protected IconUIResource buttonSelectIconComboBox;

    protected IconUIResource buttonDisabledIconComboBox;

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
    protected IconUIResource unselectedRadioButtonIcon;

    protected IconUIResource selectedRadioButtonIcon;

    protected IconUIResource disabledUnselectedRadioButtonIcon;

    protected IconUIResource disabledSelectedRadioButtonIcon;

    //---------------------------------------------------
    //All type of font JPopupMenu
    protected BorderUIResource borderPopupMenu;

    //---------------------------------------------------
    //All type of font JSpinner
    protected ColorUIResource arrowButtonBackgroundSpinner;

    protected ColorUIResource mouseHoverButtonColorSpinner;

    protected BorderUIResource borderSpinner;

    protected BorderUIResource arrowButtonBorderSpinner;

    public IconUIResource previousButtonIconSpinner;

    public IconUIResource nextButtonIconSpinner;


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

    protected ColorUIResource disabledColorSlider;

    protected BorderUIResource borderSlider;

    //---------------------------------------------------
    //Proprieties JTabbedPane
    protected ColorUIResource highlightColorTabbedPane;

    protected ColorUIResource borderHighlightColorTabbedPane;

    protected ColorUIResource focusColorLineTabbedPane;

    protected ColorUIResource disableColorTabTabbedPane;

    protected InsetsUIResource tabInsetsTabbedPane;

    protected InsetsUIResource selectedTabInsetsTabbedPane;

    protected IconUIResource bottomIconTabbedPane;

    protected IconUIResource disabledBottomIconTabbedPane;

    protected IconUIResource topIconTabbedPane;

    protected IconUIResource leftIconTabbedPane;

    protected IconUIResource rightIconTabbedPane;

    protected IconUIResource disabledTopIconTabbedPane;

    protected IconUIResource disabledLeftIconTabbedPane;

    protected IconUIResource disabledRightIconTabbedPane;

    protected ColorUIResource colorIconTabbedPane;

    protected ColorUIResource colorDisabledIconTabbedPane;

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


    /**
     * Whent the Table row is unselected but the checkbox is uncheck
     */
    protected IconUIResource unselectedCheckBoxIconTable;

    /**
     * Whent the Table row is unselected but the checkbox is check
     */
    protected IconUIResource selectedCheckBoxIconTable;

    /**
     * Whent the Table row is selected but the checkbox is check
     */
    protected IconUIResource unselectedCheckBoxIconSelectionRowTable;


    /**
     * Whent the Table row is selected but the checkbox is check
     */
    protected IconUIResource selectedCheckBoxIconSelectionRowTable;

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

    protected IconUIResource closedIconTree;

    protected IconUIResource openIconTree;

    protected IconUIResource leafIconTree;

    protected BorderUIResource borderTree;

    //---------------------------------------------------
    //Proprieties JTextField and JPasswordField
    protected ColorUIResource backgroundTextField;

    protected ColorUIResource inactiveForegroundTextField;

    protected ColorUIResource inactiveBackgroundTextField;

    protected ColorUIResource selectionBackgroundTextField;

    protected ColorUIResource selectionForegroundTextField;

    protected ColorUIResource disabledBackgroudnTextField;

    protected ColorUIResource disabledForegroundTextField;

    protected ColorUIResource inactiveColorLineTextField;

    protected ColorUIResource activeColorLineTextField;

    protected BorderUIResource borderTextField;

    //---------------------------------------------------
    //Proprieties JXTaskPane
    protected ColorUIResource titleBackgroundGradientStartTaskPane;

    protected ColorUIResource titleBackgroundGradientEndTaskPane;

    protected ColorUIResource titleColorTaskPane;

    protected ColorUIResource titleOverTaskPane;

    protected ColorUIResource specialTitleOverTaskPane;

    protected ColorUIResource backgroundTaskPane;

    protected ColorUIResource borderColorTaskPane;

    protected ColorUIResource contentBackgroundTaskPane;

    protected BorderUIResource borderTaskPane;

    protected IconUIResource yesCollapsedTaskPane;

    protected IconUIResource noCollapsedTaskPane;

    protected int archTaskPane;

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

    protected IconUIResource warningIconOptionPane;

    protected IconUIResource errorIconIconOptionPane;

    protected IconUIResource questionIconOptionPane;

    protected IconUIResource informationIconOptionPane;

    //---------------------------------------------------
    //Proprieties JSplitPane

    protected ColorUIResource colorDividierSplitPane;

    protected ColorUIResource colorDividierFocusSplitPane;

    protected int sizeDividierSplitPane = 5;

    protected BorderUIResource dividierBorderSplitPane;

    //---------------------------------------------------
    //Proprieties JFileChooser
    protected IconUIResource iconComputerFileChooser;

    protected IconUIResource iconDirectoryFileChooser;

    protected IconUIResource iconFileFileChooser;

    protected IconUIResource iconFloppyDriveFileChooser;

    protected IconUIResource iconHardDriveFileChooser;

    protected IconUIResource iconHomeFileChooser;

    protected IconUIResource iconListFileChooser;

    protected IconUIResource iconDetailsFileChooser;

    protected IconUIResource iconNewFolderFileChooser;

    protected IconUIResource iconUpFolderFileChooser;

    //---------------------------------------------------
    //Proprieties JProgressBar
    protected ColorUIResource backgroundProgressBar;

    protected ColorUIResource foregroundProgressBar;

    protected BorderUIResource borderProgressBar;

    //---------------------------------------------------
    //Proprieties TitledBorder
    protected ColorUIResource colorTextTitledBorder;

    protected BorderUIResource borderTitledBorder;

    //---------------------------------------------------
    //Proprieties TitlePane
    protected IconUIResource iconCloseTitlePane;

    //---------------------------------------------------
    //All type of font supported to the look and feel
    protected FontUIResource fontBold;

    protected FontUIResource fontItalic;

    protected FontUIResource fontRegular;

    protected FontUIResource fontMedium;


    //---------------------------------------------------
    //Proprieties JSeparator
    protected ColorUIResource backgroundSeparator;

    protected ColorUIResource foregroundSeparator;

    //---------------------------------------------------
    //Proprieties JToolTip
    protected ColorUIResource backgroundToolTip;

    protected ColorUIResource foregroundToolTip;

    protected BorderUIResource borderToolTip;


    public void installTheme(){
        installColor();
        installDefaultColor();
        installFonts();
        installBorders();
        installIcons();
    }

    public void installUIDefault(UIDefaults table) {
        //do nothing
    }

    protected abstract void installColor();

    protected void installDefaultColor(){
        this.colorIconTabbedPane = textColor;
        this.colorDisabledIconTabbedPane = disableTextColor;

        this.backgroundTaskPane = backgroundPrimary;
        this.borderColorTaskPane = backgroundTaskPane;
        this.contentBackgroundTaskPane = backgroundPrimary;

        this.withoutIconSelectedBackgroundToggleButton = buttonBackgroundColorMouseHover;
        this.withoutIconBackgroundToggleButton = buttonBackgroundColor;
        this.colorTextTitledBorder = textColor;

        this.arrowButtonBackgroundSpinner = backgroundTextField;

        this.selectionBackgroundTree = this.backgroundPrimary;
        this.selectionBorderColorTree = this.backgroundPrimary;

        this.foregroundTable = textColor;
        this.foregroundTableHeader = textColor;
        this.selectionForegroundTable = textColor;

        this.arrowButtonColorScrollBar = buttonBackgroundColor;
        this.thumbDarkShadowColorScrollBar = thumbColorScrollBar;
        this.thumbHighlightColorScrollBar = thumbColorScrollBar;
        this.thumbShadowColorScrollBar = thumbColorScrollBar;
        this.arrowButtonOnClickColorScrollBar = buttonBackgroundColorMouseHover;
        this.mouseHoverColorScrollBar = thumbColorScrollBar;

        this.menuTextColor = textColor;
        this.menuDisableBackground = MaterialColors.TRANSPANENT;

        this.buttonDisabledForeground = disableTextColor;
        this.buttonDefaultTextColor = textColor;
        this.buttonTextColor = textColor;
        this.foregroundToolTip = textColor;

        this.disabledColorSlider = buttonDisabledBackground;

        this.dockingBackgroundToolBar = this.backgroundPrimary;
        this.floatingBackgroundToolBar = this.textColor;
    }

    protected void installFonts() {
        this.fontBold = MaterialFontFactory.getInstance().getFont(MaterialFontFactory.BOLD);
        this.fontItalic = MaterialFontFactory.getInstance().getFont(MaterialFontFactory.ITALIC);
        this.fontMedium = MaterialFontFactory.getInstance().getFont(MaterialFontFactory.MEDIUM);
        this.fontRegular = MaterialFontFactory.getInstance().getFont(MaterialFontFactory.REGULAR);
    }

    protected void installIcons() {
        this.iconComputerFileChooser = MaterialImageFactory.getInstance().getImage(
                MaterialIconFont.COMPUTER,
                textColor
        );
        this.iconDirectoryFileChooser = MaterialImageFactory.getInstance().getImage(
                MaterialIconFont.FOLDER,
                textColor
        );
        this.iconFileFileChooser = MaterialImageFactory.getInstance().getImage(
                MaterialIconFont.INSERT_DRIVE_FILE,
                textColor
        );
        this.iconFloppyDriveFileChooser = MaterialImageFactory.getInstance().getImage(
                MaterialIconFont.SAVE,
                textColor
        );
        this.iconHardDriveFileChooser = MaterialImageFactory.getInstance().getImage(
                MaterialIconFont.STORAGE,
                textColor
        );
        this.iconHomeFileChooser = MaterialImageFactory.getInstance().getImage(
                MaterialIconFont.HOME,
                textColor
        );
        this.iconListFileChooser = MaterialImageFactory.getInstance().getImage(
                MaterialIconFont.MENU,
                textColor
        );
        this.iconDetailsFileChooser = MaterialImageFactory.getInstance().getImage(
                MaterialIconFont.VIEW_MODULE,
                textColor
        );
        this.iconNewFolderFileChooser = MaterialImageFactory.getInstance().getImage(
                MaterialIconFont.CREATE_NEW_FOLDER,
                textColor
        );
        this.iconUpFolderFileChooser = MaterialImageFactory.getInstance().getImage(
                MaterialIconFont.ARROW_BACK,
                textColor
        );

        this.iconCloseTitlePane = MaterialImageFactory.getInstance().getImage(
                MaterialIconFont.CLOSE,
                25,
                textColor
        );

        this.previousButtonIconSpinner = MaterialImageFactory.getInstance().getImage(
                MaterialIconFont.ARROW_DROP_DOWN,
                textColor
        );

        this.nextButtonIconSpinner = MaterialImageFactory.getInstance().getImage(
                MaterialIconFont.ARROW_DROP_UP,
                textColor
        );

        this.selectedCheckBoxIcon = MaterialImageFactory.getInstance().getImage(
                MaterialIconFont.CHECK_BOX,
                highlightBackgroundPrimary
        );

        this.unselectedCheckBoxIcon = MaterialImageFactory.getInstance().getImage(
                MaterialIconFont.CHECK_BOX_OUTLINE_BLANK,
                textColor
        );

        this.disabledUnselectedCheckBoxIcon = MaterialImageFactory.getInstance().getImage(
                MaterialIconFont.CHECK_BOX_OUTLINE_BLANK,
                disableTextColor
        );

        this.disabledSelectedCheckBoxIcon = MaterialImageFactory.getInstance().getImage(
                MaterialIconFont.CHECK_BOX,
                disableTextColor
        );

        this.selectedCheckBoxIconSelectionRowTable = MaterialImageFactory.getInstance().getImage(
                MaterialIconFont.CHECK_BOX,
                highlightBackgroundPrimary
        );
        this.unselectedCheckBoxIconSelectionRowTable = MaterialImageFactory.getInstance().getImage(
                MaterialIconFont.CHECK_BOX_OUTLINE_BLANK,
                highlightBackgroundPrimary
        );

        this.selectedCheckBoxIconTable = MaterialImageFactory.getInstance().getImage(
                MaterialIconFont.CHECK_BOX,
                highlightBackgroundPrimary
        );
        this.unselectedCheckBoxIconTable = MaterialImageFactory.getInstance().getImage(
                MaterialIconFont.CHECK_BOX_OUTLINE_BLANK,
                highlightBackgroundPrimary
        );

        this.closedIconTree = MaterialImageFactory.getInstance().getImage(
                MaterialIconFont.KEYBOARD_ARROW_RIGHT,
                textColor
        );

        this.openIconTree = MaterialImageFactory.getInstance().getImage(
                MaterialIconFont.KEYBOARD_ARROW_DOWN,
                highlightBackgroundPrimary
        );

        //this.yesCollapsedTaskPane = MaterialImageFactory.getInstance().getImage(MaterialImageFactory.YES_COLLAPSED);
        this.noCollapsedTaskPane = MaterialImageFactory.getInstance().getImage(
                MaterialIconFont.KEYBOARD_ARROW_RIGHT
        );

        //this.noCollapsedTaskPane = MaterialImageFactory.getInstance().getImage(MaterialImageFactory.NO_COLLAPSED);
        this.yesCollapsedTaskPane = MaterialImageFactory.getInstance().getImage(
                MaterialIconFont.KEYBOARD_ARROW_DOWN
        );


        this.warningIconOptionPane = MaterialImageFactory.getInstance().getImage(MaterialImageFactory.WARNING);
        this.errorIconIconOptionPane = MaterialImageFactory.getInstance().getImage(MaterialImageFactory.ERROR);
        this.questionIconOptionPane = MaterialImageFactory.getInstance().getImage(MaterialImageFactory.QUESTION);
        this.informationIconOptionPane = MaterialImageFactory.getInstance().getImage(MaterialImageFactory.INFORMATION);

        this.leafIconTree = MaterialImageFactory.getInstance().getImage(
                MaterialImageFactory.BLANK
        );

        this.unselectedIconToggleButton = MaterialImageFactory.getInstance().getImage(
                MaterialIconFont.TOGGLE_OFF,
                26,
                textColor
        );
        this.selectedIconToggleButton = MaterialImageFactory.getInstance().getImage(
                MaterialIconFont.TOGGLE_ON,
                26,
                highlightBackgroundPrimary
        );

        this.disabledUnselectedIconToggleButton = MaterialImageFactory.getInstance().getImage(
                MaterialIconFont.TOGGLE_OFF,
                26,
                disableTextColor
        );
        this.disabledSelectedIconToggleButton = MaterialImageFactory.getInstance().getImage(
                MaterialIconFont.TOGGLE_ON,
                26,
                disableTextColor
        );

        this.selectedRadioButtonIcon = MaterialImageFactory.getInstance().getImage(
                MaterialIconFont.RADIO_BUTTON_CHECKED,
                highlightBackgroundPrimary
        );
        this.unselectedRadioButtonIcon = MaterialImageFactory.getInstance().getImage(
                MaterialIconFont.RADIO_BUTTON_UNCHECKED,
                textColor
        );

        this.disabledSelectedRadioButtonIcon = MaterialImageFactory.getInstance().getImage(
                MaterialIconFont.RADIO_BUTTON_CHECKED,
                disableTextColor
        );
        this.disabledUnselectedRadioButtonIcon = MaterialImageFactory.getInstance().getImage(
                MaterialIconFont.RADIO_BUTTON_UNCHECKED,
                disableTextColor
        );

        this.topIconTabbedPane = MaterialImageFactory.getInstance().getImage(
                MaterialIconFont.EXPAND_LESS,
                colorIconTabbedPane
        );

        this.disabledTopIconTabbedPane = MaterialImageFactory.getInstance().getImage(
                MaterialIconFont.EXPAND_LESS,
                colorDisabledIconTabbedPane
        );

        this.bottomIconTabbedPane = MaterialImageFactory.getInstance().getImage(
                MaterialIconFont.EXPAND_MORE,
                colorIconTabbedPane
        );

        this.disabledBottomIconTabbedPane = MaterialImageFactory.getInstance().getImage(
                MaterialIconFont.EXPAND_MORE,
                colorDisabledIconTabbedPane
        );

        this.leftIconTabbedPane = MaterialImageFactory.getInstance().getImage(
                MaterialIconFont.CHEVRON_LEFT,
                colorIconTabbedPane
        );

        this.disabledLeftIconTabbedPane = MaterialImageFactory.getInstance().getImage(
                MaterialIconFont.CHEVRON_LEFT,
                colorDisabledIconTabbedPane
        );

        this.rightIconTabbedPane = MaterialImageFactory.getInstance().getImage(
                MaterialIconFont.CHEVRON_RIGHT,
                colorIconTabbedPane
        );

        this.disabledRightIconTabbedPane = MaterialImageFactory.getInstance().getImage(
                MaterialIconFont.CHEVRON_RIGHT,
                colorDisabledIconTabbedPane
        );

        this.buttonIconComboBox = MaterialImageFactory.getInstance().getImage(
                MaterialIconFont.KEYBOARD_ARROW_DOWN,
                textColor
        );

        this.buttonSelectIconComboBox = MaterialImageFactory.getInstance().getImage(
                MaterialIconFont.KEYBOARD_ARROW_UP,
                textColor
        );

        this.buttonDisabledIconComboBox = MaterialImageFactory.getInstance().getImage(
                MaterialIconFont.KEYBOARD_ARROW_DOWN,
                disableTextColor
        );
    }

    protected void installBorders() {
        //button border
        this.buttonBorder = new BorderUIResource(BorderFactory.createEmptyBorder(8, 12, 8, 12));
        this.borderMenu = new BorderUIResource(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        this.borderMenuBar = MaterialBorders.LIGHT_SHADOW_BORDER;
        this.borderPopupMenu = MaterialBorders.LIGHT_LINE_BORDER;
        this.borderSpinner = new BorderUIResource(BorderFactory.createLineBorder(backgroundTextField));
        this.arrowButtonBorderSpinner = new BorderUIResource(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(arrowButtonBackgroundSpinner),
                BorderFactory.createEmptyBorder(2, 2, 2, 2)
        ));
        this.borderPanel = new BorderUIResource(BorderFactory.createEmptyBorder());
        this.arrowButtonBorderScrollBar = new BorderUIResource(BorderFactory.createEmptyBorder());
        this.borderSlider = new BorderUIResource(BorderFactory.createCompoundBorder(MaterialBorders.LIGHT_LINE_BORDER, BorderFactory.createEmptyBorder(15, 15, 15, 15)));
        this.cellBorderTableHeader = new BorderUIResource(BorderFactory.createCompoundBorder(
                MaterialBorders.LIGHT_LINE_BORDER,
                BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        this.borderToolBar = MaterialBorders.LIGHT_SHADOW_BORDER;
        this.borderTextField = new BorderUIResource(BorderFactory.createEmptyBorder(2, 2, 1, 2));
        this.borderTaskPane = new BorderUIResource(BorderFactory.createEmptyBorder(0, 1, 0, 1));

        this.focusCellHighlightBorder = new BorderUIResource(BorderFactory.createEmptyBorder());
        this.borderItemList = new BorderUIResource(BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(),
                BorderFactory.createEmptyBorder(2, 5, 2, 5)));

        this.tabInsetsTabbedPane = new InsetsUIResource(6, 10, 10, 10);
        this.selectedTabInsetsTabbedPane = new InsetsUIResource(6, 10, 10, 10);

        this.borderFrameRootPane = new BorderUIResource(BorderFactory.createEmptyBorder());
        this.borderDialogRootPane = MaterialBorders.LIGHT_SHADOW_BORDER;

        this.borderProgressBar = MaterialBorders.LIGHT_LINE_BORDER;

        this.withoutIconSelectedBorderToggleButton = new BorderUIResource(BorderFactory.createCompoundBorder(
                BorderFactory.createEmptyBorder(5, 10, 5, 10),
                BorderFactory.createLineBorder(withoutIconSelectedBackgroundToggleButton, 1)));

        this.withoutIconBorderToggleButton = new BorderUIResource(BorderFactory.createCompoundBorder(
                BorderFactory.createEmptyBorder(5, 10, 5, 10),
                BorderFactory.createLineBorder(withoutIconBackgroundToggleButton, 1)));

        this.dividierBorderSplitPane = new BorderUIResource(BorderFactory.createEmptyBorder());

        this.borderTree = new BorderUIResource(BorderFactory.createEmptyBorder(3, 2, 3, 2));

        this.borderComboBox = MaterialBorders.roundedLineColorBorder(this.textColor, this.getArchBorderComboBox());
        this.borderItemComboBox = new BorderUIResource(BorderFactory.createLineBorder(this.backgroundPrimary));
        this.borderList = MaterialBorders.DEFAULT_SHADOW_BORDER;

        this.borderToolTip = MaterialBorders.roundedLineColorBorder(this.backgroundToolTip, 4);
    }

    public abstract String getName();

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

    public FontUIResource getButtonFont() {
        return getFontBold();
    }

    public boolean getMouseHoverButtonEnable() {
        return true;
    }

    public boolean getButtonFocusable() {
        return true;
    }

    public boolean getButtonBorderEnable() {
        return true;
    }

    public boolean getButtonBorderEnableToAll() {
        return false;
    }

    @Override
    public int getArcButton() {
        return 0;
    }

    @Override
    public boolean getOpaqueButton() {
        return false;
    }

    //---------------------------------------------------
    //Proprieties JSeparator
    public ColorUIResource getBackgroundSeparator() {
        return backgroundSeparator;
    }

    public ColorUIResource getForegroundSeparator() {
        return foregroundSeparator;
    }

    //---------------------------------------------------
    //Proprieties JToolTip
    public ColorUIResource getBackgroundToolTip() {
        return backgroundToolTip;
    }

    public ColorUIResource getForegroundToolTip() {
        return foregroundToolTip;
    }

    public BorderUIResource getBorderToolTip() {
        return borderToolTip;
    }

    //Proprieties JCheckBox
    public IconUIResource getUnselectedCheckBoxIcon() {
        return unselectedCheckBoxIcon;
    }

    public IconUIResource getSelectedCheckBoxIcon() {
        return selectedCheckBoxIcon;
    }

    public IconUIResource getDisabledUnselectedCheckBoxIcon() {
        return disabledUnselectedCheckBoxIcon;
    }

    public IconUIResource getDisabledSelectedCheckBoxIcon() {
        return disabledSelectedCheckBoxIcon;
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

    public BorderUIResource getBorderItemComboBox() {
        return borderItemComboBox;
    }

    @Override
    public IconUIResource getButtonIconComboBox() {
        return buttonIconComboBox;
    }

    @Override
    public IconUIResource getButtonSelectIconComboBox() {
        return buttonSelectIconComboBox;
    }

    @Override
    public IconUIResource getButtonDisabledIconComboBox() {
        return buttonDisabledIconComboBox;
    }

    @Override
    public void setButtonDisabledIconComboBox(IconUIResource buttonDisabledIconComboBox) {
        this.buttonDisabledIconComboBox = buttonDisabledIconComboBox;
    }

    @Override
    public boolean getMouseHoverEnableComboBox() {
        return false;
    }

    @Override
    public boolean getLightWeightPopupEnabledComboBox() {
        return true;
    }

    @Override
    public boolean getFocusableComboBox() {
        return true;
    }

    @Override
    public int getArchBorderComboBox() {
        return 8;
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
    public Icon getMenuArrowIcon() {
        return new MaterialMenuArrowIcon();
    }

    @Override
    public ColorUIResource getMenuArrowHoverColor() {
        return textColor;
    }

    @Override
    public int getMenuArrowHeight() {
        return 8;
    }

    @Override
    public int getMenuArrowWidth() {
        return 4;
    }

    @Override
    public boolean getMouseHoverEnableMenu() {
        return true;
    }

    //get radiobutton
    public IconUIResource getUnselectedRadioButtonIcon() {
        return unselectedRadioButtonIcon;
    }

    public IconUIResource getSelectedRadioButtonIcon() {
        return selectedRadioButtonIcon;
    }

    public IconUIResource getDisabledUnselectedRadioButtonIcon() {
        return disabledUnselectedRadioButtonIcon;
    }

    public IconUIResource getDisabledSelectedRadioButtonIcon() {
        return disabledSelectedRadioButtonIcon;
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

    public IconUIResource getPreviousButtonIconSpinner() {
        return previousButtonIconSpinner;
    }

    public IconUIResource getNextButtonIconSpinner() {
        return nextButtonIconSpinner;
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

    public ColorUIResource getDisabledColorSlider() {
        return disabledColorSlider;
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

    public IconUIResource getDisabledBottomIconTabbedPane() {
        return disabledBottomIconTabbedPane;
    }

    public IconUIResource getDisabledTopIconTabbedPane() {
        return disabledTopIconTabbedPane;
    }

    public IconUIResource getDisabledLeftIconTabbedPane() {
        return disabledLeftIconTabbedPane;
    }

    public IconUIResource getDisabledRightIconTabbedPane() {
        return disabledRightIconTabbedPane;
    }

    public IconUIResource getBottomIconTabbedPane() {
        return bottomIconTabbedPane;
    }

    public IconUIResource getTopIconTabbedPane() {
        return topIconTabbedPane;
    }

    public IconUIResource getLeftIconTabbedPane() {
        return leftIconTabbedPane;
    }

    public IconUIResource getRightIconTabbedPane() {
        return rightIconTabbedPane;
    }

    public ColorUIResource getColorIconTabbedPane() {
        return colorIconTabbedPane;
    }

    public ColorUIResource getColorDisabledIconTabbedPane() {
        return colorDisabledIconTabbedPane;
    }

    @Override
    public int getLinePositionYTabbedPane() {
        return 56;
    }

    @Override
    public int getLinePositionXTabbedPane() {
        return 0;
    }

    @Override
    public int getLineWithTabbedPane() {
        return 5;
    }

    @Override
    public int getLineHeightTabbedPane() {
        return 3;
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
	public int getHeightTabTabbedPane() {
		return 18;
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

    public IconUIResource getUnselectedCheckBoxIconTable() {
        return unselectedCheckBoxIconTable;
    }

    public IconUIResource getSelectedCheckBoxIconTable() {
        return selectedCheckBoxIconTable;
    }

    public IconUIResource getUnselectedCheckBoxIconSelectionRowTable() {
        return unselectedCheckBoxIconSelectionRowTable;
    }

    public IconUIResource getSelectedCheckBoxIconSelectionRowTable() {
        return selectedCheckBoxIconSelectionRowTable;
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
        return 10;
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

    public ColorUIResource getDisabledBackgroudnTextField() {
        return disabledBackgroudnTextField;
    }

    public ColorUIResource getDisabledForegroundTextField() {
        return disabledForegroundTextField;
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

    public char getEchoCharPasswordField() {
        return '\u2022';
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

    public IconUIResource getClosedIconTree() {
        return closedIconTree;
    }

    public IconUIResource getOpenIconTree() {
        return openIconTree;
    }

    public IconUIResource getLeafIconTree() {
        return leafIconTree;
    }

    public BorderUIResource getBorderTree() {
        return borderTree;
    }
    //---------------------------------------------------
    //Proprieties JToggleButton

    public IconUIResource getUnselectedIconToggleButton() {
        return unselectedIconToggleButton;
    }

    public IconUIResource getSelectedIconToggleButton() {
        return selectedIconToggleButton;
    }

    public IconUIResource getDisabledUnselectedIconToggleButton() {
        return disabledUnselectedIconToggleButton;
    }

    public IconUIResource getDisabledSelectedIconToggleButton() {
        return disabledSelectedIconToggleButton;
    }

    public boolean isWithoutIconToggleButton() {
        return withoutIconToggleButton;
    }

    public ColorUIResource getWithoutIconSelectedBackgroundToggleButton() {
        return withoutIconSelectedBackgroundToggleButton;
    }

    public ColorUIResource getWithoutIconSelectedForegoundToggleButton() {
        return withoutIconSelectedForegoundToggleButton;
    }

    public ColorUIResource getWithoutIconBackgroundToggleButton() {
        return withoutIconBackgroundToggleButton;
    }

    public ColorUIResource getWithoutIconForegroundToggleButton() {
        return withoutIconForegroundToggleButton;
    }

    public BorderUIResource getWithoutIconSelectedBorderToggleButton() {
        return withoutIconSelectedBorderToggleButton;
    }

    public BorderUIResource getWithoutIconBorderToggleButton() {
        return withoutIconBorderToggleButton;
    }


    //---------------------------------------------------
    //Proprieties JXTaskPane
    public ColorUIResource getTitleBackgroundGradientStartTaskPane() {
        return titleBackgroundGradientStartTaskPane;
    }

    public ColorUIResource getTitleBackgroundGradientEndTaskPane() {
        return titleBackgroundGradientEndTaskPane;
    }

    public ColorUIResource getTitleColorTaskPane() {
        return titleColorTaskPane;
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

    public IconUIResource getYesCollapsedTaskPane() {
        return yesCollapsedTaskPane;
    }

    public IconUIResource getNoCollapsedTaskPane() {
        return noCollapsedTaskPane;
    }

    public boolean getMouseHoverEnableTaskPane() {
        return true;
    }

    @Override
    public int getArchTaskPane() {
        return archTaskPane;
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
    public IconUIResource getIconComputerFileChooser() {
        return iconComputerFileChooser;
    }

    public IconUIResource getIconDirectoryFileChooser() {
        return iconDirectoryFileChooser;
    }

    public IconUIResource getIconFileFileChooser() {
        return iconFileFileChooser;
    }

    public IconUIResource getIconFloppyDriveFileChooser() {
        return iconFloppyDriveFileChooser;
    }

    public IconUIResource getIconHardDriveFileChooser() {
        return iconHardDriveFileChooser;
    }

    public IconUIResource getIconHomeFileChooser() {
        return iconHomeFileChooser;
    }

    public IconUIResource getIconListFileChooser() {
        return iconListFileChooser;
    }

    public IconUIResource getIconDetailsFileChooser() {
        return iconDetailsFileChooser;
    }

    public IconUIResource getIconNewFolderFileChooser() {
        return iconNewFolderFileChooser;
    }

    public IconUIResource getIconUpFolderFileChooser() {
        return iconUpFolderFileChooser;
    }

    //---------------------------------------------------
    //Proprieties JOptionPane
    public ColorUIResource getBackgroundOptionPane() {
        return backgroundOptionPane;
    }

    public IconUIResource getWarningIconOptionPane() {
        return warningIconOptionPane;
    }

    public IconUIResource getErrorIconIconOptionPane() {
        return errorIconIconOptionPane;
    }

    public IconUIResource getQuestionIconOptionPane() {
        return questionIconOptionPane;
    }

    public IconUIResource getInformationIconOptionPane() {
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

    //---------------------------------------------------
    //Proprieties JSplitPane

    public ColorUIResource getColorDividierSplitPane() {
        return colorDividierSplitPane;
    }

    public ColorUIResource getColorDividierFocusSplitPane() {
        return colorDividierFocusSplitPane;
    }

    public int getSizeDividierSplitPane() {
        return sizeDividierSplitPane;
    }

    public BorderUIResource getDividierBorderSplitPane() {
        return dividierBorderSplitPane;
    }

    //---------------------------------------------------
    //Proprieties TitledBorder

    public ColorUIResource getColorTextTitledBorder() {
        return colorTextTitledBorder;
    }

    public BorderUIResource getBorderTitledBorder() {
        return borderTitledBorder;
    }

    //---------------------------------------------------
    //Proprieties TitledBorder
    public IconUIResource getIconCloseTitlePane() {
        return iconCloseTitlePane;
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

    //Setter
    public void setDisabledColorSlider(ColorUIResource disabledColorSlider) {
        this.disabledColorSlider = disabledColorSlider;
    }

    public void setDisabledUnselectedIconToggleButton(IconUIResource disabledUnselectedIconToggleButton) {
        this.disabledUnselectedIconToggleButton = disabledUnselectedIconToggleButton;
    }

    public void setDisabledSelectedIconToggleButton(IconUIResource disabledSelectedIconToggleButton) {
        this.disabledSelectedIconToggleButton = disabledSelectedIconToggleButton;
    }

    public void setDisabledUnselectedRadioButtonIcon(IconUIResource disabledUnselectedRadioButtonIcon) {
        this.disabledUnselectedRadioButtonIcon = disabledUnselectedRadioButtonIcon;
    }

    public void setDisabledSelectedRadioButtonIcon(IconUIResource disabledSelectedRadioButtonIcon) {
        this.disabledSelectedRadioButtonIcon = disabledSelectedRadioButtonIcon;
    }

    public void setDisabledUnselectedCheckBoxIcon(IconUIResource disabledUnselectedCheckBoxIcon) {
        this.disabledUnselectedCheckBoxIcon = disabledUnselectedCheckBoxIcon;
    }

    public void setDisabledSelectedCheckBoxIcon(IconUIResource disabledSelectedCheckBoxIcon) {
        this.disabledSelectedCheckBoxIcon = disabledSelectedCheckBoxIcon;
    }

    public void setButtonIconComboBox(IconUIResource buttonIconComboBox) {
        this.buttonIconComboBox = buttonIconComboBox;
    }

    public void setButtonSelectIconComboBox(IconUIResource buttonSelectIconComboBox) {
        this.buttonSelectIconComboBox = buttonSelectIconComboBox;
    }

    public void setBackgroundToolTip(ColorUIResource backgroundToolTip) {
        this.backgroundToolTip = backgroundToolTip;
    }

    public void setForegroundToolTip(ColorUIResource foregroundToolTip) {
        this.foregroundToolTip = foregroundToolTip;
    }

    public void setBorderToolTip(BorderUIResource borderToolTip) {
        this.borderToolTip = borderToolTip;
    }

    public void setDisabledBottomIconTabbedPane(IconUIResource disabledBottomIconTabbedPane) {
        this.disabledBottomIconTabbedPane = disabledBottomIconTabbedPane;
    }

    public void setDisabledTopIconTabbedPane(IconUIResource disabledTopIconTabbedPane) {
        this.disabledTopIconTabbedPane = disabledTopIconTabbedPane;
    }

    public void setDisabledLeftIconTabbedPane(IconUIResource disabledLeftIconTabbedPane) {
        this.disabledLeftIconTabbedPane = disabledLeftIconTabbedPane;
    }

    public void setDisabledRightIconTabbedPane(IconUIResource disabledRightIconTabbedPane) {
        this.disabledRightIconTabbedPane = disabledRightIconTabbedPane;
    }

    public void setBottomIconTabbedPane(IconUIResource bottomIconTabbedPane) {
        this.bottomIconTabbedPane = bottomIconTabbedPane;
    }

    public void setTopIconTabbedPane(IconUIResource topIconTabbedPane) {
        this.topIconTabbedPane = topIconTabbedPane;
    }

    public void setLeftIconTabbedPane(IconUIResource leftIconTabbedPane) {
        this.leftIconTabbedPane = leftIconTabbedPane;
    }

    public void setRightIconTabbedPane(IconUIResource rightIconTabbedPane) {
        this.rightIconTabbedPane = rightIconTabbedPane;
    }

    public void setColorIconTabbedPane(ColorUIResource colorIconTabbedPane) {
        this.colorIconTabbedPane = colorIconTabbedPane;
    }

    public void setColorDisabledIconTabbedPane(ColorUIResource colorDisabledIconTabbedPane) {
        this.colorDisabledIconTabbedPane = colorDisabledIconTabbedPane;
    }

    public void setPreviousButtonIconSpinner(IconUIResource previousButtonIconSpinner) {
        this.previousButtonIconSpinner = previousButtonIconSpinner;
    }

    public void setNextButtonIconSpinner(IconUIResource nextButtonIconSpinner) {
        this.nextButtonIconSpinner = nextButtonIconSpinner;
    }

    public void setBorderItemComboBox(BorderUIResource borderItemComboBox) {
        this.borderItemComboBox = borderItemComboBox;
    }

    public void setArchTaskPane(int archTaskPane) {
        this.archTaskPane = archTaskPane;
    }

    public void setTitleColorTaskPane(ColorUIResource titleColorTaskPane) {
        this.titleColorTaskPane = titleColorTaskPane;
    }

    public void setBackgroundSeparator(ColorUIResource backgroundSeparator) {
        this.backgroundSeparator = backgroundSeparator;
    }

    public void setForegroundSeparator(ColorUIResource foregroundSeparator) {
        this.foregroundSeparator = foregroundSeparator;
    }

    public void setLeafIconTree(IconUIResource leafIconTree) {
        this.leafIconTree = leafIconTree;
    }

    public void setBorderTree(BorderUIResource borderTree) {
        this.borderTree = borderTree;
    }

    public void setIconCloseTitlePane(IconUIResource iconCloseTitlePane) {
        this.iconCloseTitlePane = iconCloseTitlePane;
    }

    public void setDisabledBackgroudnTextField(ColorUIResource disabledBackgroudnTextField) {
        this.disabledBackgroudnTextField = disabledBackgroudnTextField;
    }

    public void setDisabledForegroundTextField(ColorUIResource disabledForegroundTextField) {
        this.disabledForegroundTextField = disabledForegroundTextField;
    }

    public void setColorTextTitledBorder(ColorUIResource colorTextTitledBorder) {
        this.colorTextTitledBorder = colorTextTitledBorder;
    }

    public void setBorderTitledBorder(BorderUIResource borderTitledBorder) {
        this.borderTitledBorder = borderTitledBorder;
    }

    public void setColorDividierSplitPane(ColorUIResource colorDividierSplitPane) {
        this.colorDividierSplitPane = colorDividierSplitPane;
    }

    public void setColorDividierFocusSplitPane(ColorUIResource colorDividierFocusSplitPane) {
        this.colorDividierFocusSplitPane = colorDividierFocusSplitPane;
    }

    public void setSizeDividierSplitPane(int sizeDividierSplitPane) {
        this.sizeDividierSplitPane = sizeDividierSplitPane;
    }

    public void setDividierBorderSplitPane(BorderUIResource dividierBorderSplitPane) {
        this.dividierBorderSplitPane = dividierBorderSplitPane;
    }

    public void setUnselectedIconToggleButton(IconUIResource unselectedIconToggleButton) {
        this.unselectedIconToggleButton = unselectedIconToggleButton;
    }

    public void setSelectedIconToggleButton(IconUIResource selectedIconToggleButton) {
        this.selectedIconToggleButton = selectedIconToggleButton;
    }

    public void setWithoutIconToggleButton(boolean withoutIconToggleButton) {
        this.withoutIconToggleButton = withoutIconToggleButton;
    }

    public void setWithoutIconSelectedBackgroundToggleButton(ColorUIResource withoutIconSelectedBackgroundToggleButton) {
        this.withoutIconSelectedBackgroundToggleButton = withoutIconSelectedBackgroundToggleButton;
    }

    public void setWithoutIconSelectedForegoundToggleButton(ColorUIResource withoutIconSelectedForegoundToggleButton) {
        this.withoutIconSelectedForegoundToggleButton = withoutIconSelectedForegoundToggleButton;
    }

    public void setWithoutIconBackgroundToggleButton(ColorUIResource withoutIconBackgroundToggleButton) {
        this.withoutIconBackgroundToggleButton = withoutIconBackgroundToggleButton;
    }

    public void setWithoutIconForegroundToggleButton(ColorUIResource withoutIconForegroundToggleButton) {
        this.withoutIconForegroundToggleButton = withoutIconForegroundToggleButton;
    }

    public void setWithoutIconSelectedBorderToggleButton(BorderUIResource withoutIconSelectedBorderToggleButton) {
        this.withoutIconSelectedBorderToggleButton = withoutIconSelectedBorderToggleButton;
    }

    public void setWithoutIconBorderToggleButton(BorderUIResource withoutIconBorderToggleButton) {
        this.withoutIconBorderToggleButton = withoutIconBorderToggleButton;
    }

    public void setBackgroundPrimary(ColorUIResource backgroundPrimary) {
        this.backgroundPrimary = backgroundPrimary;
    }

    public void setHighlightBackgroundPrimary(ColorUIResource highlightBackgroundPrimary) {
        this.highlightBackgroundPrimary = highlightBackgroundPrimary;
    }

    public void setTextColor(ColorUIResource textColor) {
        this.textColor = textColor;
    }

    public void setDisableTextColor(ColorUIResource disableTextColor) {
        this.disableTextColor = disableTextColor;
    }

    public void setButtonBackgroundColor(ColorUIResource buttonBackgroundColor) {
        this.buttonBackgroundColor = buttonBackgroundColor;
    }

    public void setButtonTextColor(ColorUIResource buttonTextColor) {
        this.buttonTextColor = buttonTextColor;
    }

    public void setButtonBackgroundColorMouseHover(ColorUIResource buttonBackgroundColorMouseHover) {
        this.buttonBackgroundColorMouseHover = buttonBackgroundColorMouseHover;
    }

    public void setButtonDefaultBackgroundColor(ColorUIResource buttonDefaultBackgroundColor) {
        this.buttonDefaultBackgroundColor = buttonDefaultBackgroundColor;
    }

    public void setButtonDefaultTextColor(ColorUIResource buttonDefaultTextColor) {
        this.buttonDefaultTextColor = buttonDefaultTextColor;
    }

    public void setButtonDefaultBackgroundColorMouseHover(ColorUIResource buttonDefaultBackgroundColorMouseHover) {
        this.buttonDefaultBackgroundColorMouseHover = buttonDefaultBackgroundColorMouseHover;
    }

    public void setButtonDisabledBackground(ColorUIResource buttonDisabledBackground) {
        this.buttonDisabledBackground = buttonDisabledBackground;
    }

    public void setButtonDisabledForeground(ColorUIResource buttonDisabledForeground) {
        this.buttonDisabledForeground = buttonDisabledForeground;
    }

    public void setButtonFocusColor(ColorUIResource buttonFocusColor) {
        this.buttonFocusColor = buttonFocusColor;
    }

    public void setButtonDefaultFocusColor(ColorUIResource buttonDefaultFocusColor) {
        this.buttonDefaultFocusColor = buttonDefaultFocusColor;
    }

    public void setButtonBorderColor(ColorUIResource buttonBorderColor) {
        this.buttonBorderColor = buttonBorderColor;
    }

    public void setButtonColorHighlight(ColorUIResource buttonColorHighlight) {
        this.buttonColorHighlight = buttonColorHighlight;
    }

    public void setButtonBorder(BorderUIResource buttonBorder) {
        this.buttonBorder = buttonBorder;
    }

    public void setUnselectedCheckBoxIcon(IconUIResource unselectedCheckBoxIcon) {
        this.unselectedCheckBoxIcon = unselectedCheckBoxIcon;
    }

    public void setSelectedCheckBoxIcon(IconUIResource selectedCheckBoxIcon) {
        this.selectedCheckBoxIcon = selectedCheckBoxIcon;
    }

    public void setSelectedInDropDownBackgroundComboBox(ColorUIResource selectedInDropDownBackgroundComboBox) {
        this.selectedInDropDownBackgroundComboBox = selectedInDropDownBackgroundComboBox;
    }

    public void setSelectedForegroundComboBox(ColorUIResource selectedForegroundComboBox) {
        this.selectedForegroundComboBox = selectedForegroundComboBox;
    }

    public void setBorderComboBox(BorderUIResource borderComboBox) {
        this.borderComboBox = borderComboBox;
    }

    public void setMenuBackground(ColorUIResource menuBackground) {
        this.menuBackground = menuBackground;
    }

    public void setMenuTextColor(ColorUIResource menuTextColor) {
        this.menuTextColor = menuTextColor;
    }

    public void setMenuBackgroundMouseHover(ColorUIResource menuBackgroundMouseHover) {
        this.menuBackgroundMouseHover = menuBackgroundMouseHover;
    }

    public void setMenuDisableBackground(ColorUIResource menuDisableBackground) {
        this.menuDisableBackground = menuDisableBackground;
    }

    public void setBorderMenu(BorderUIResource borderMenu) {
        this.borderMenu = borderMenu;
    }

    public void setBorderMenuBar(BorderUIResource borderMenuBar) {
        this.borderMenuBar = borderMenuBar;
    }

    public void setUnselectedRadioButtonIcon(IconUIResource unselectedRadioButtonIcon) {
        this.unselectedRadioButtonIcon = unselectedRadioButtonIcon;
    }

    public void setSelectedRadioButtonIcon(IconUIResource selectedRadioButtonIcon) {
        this.selectedRadioButtonIcon = selectedRadioButtonIcon;
    }

    public void setBorderPopupMenu(BorderUIResource borderPopupMenu) {
        this.borderPopupMenu = borderPopupMenu;
    }

    public void setArrowButtonBackgroundSpinner(ColorUIResource arrowButtonBackgroundSpinner) {
        this.arrowButtonBackgroundSpinner = arrowButtonBackgroundSpinner;
    }

    public void setMouseHoverButtonColorSpinner(ColorUIResource mouseHoverButtonColorSpinner) {
        this.mouseHoverButtonColorSpinner = mouseHoverButtonColorSpinner;
    }

    public void setBorderSpinner(BorderUIResource borderSpinner) {
        this.borderSpinner = borderSpinner;
    }

    public void setArrowButtonBorderSpinner(BorderUIResource arrowButtonBorderSpinner) {
        this.arrowButtonBorderSpinner = arrowButtonBorderSpinner;
    }

    public void setBorderPanel(BorderUIResource borderPanel) {
        this.borderPanel = borderPanel;
    }

    public void setTrackColorScrollBar(ColorUIResource trackColorScrollBar) {
        this.trackColorScrollBar = trackColorScrollBar;
    }

    public void setThumbColorScrollBar(ColorUIResource thumbColorScrollBar) {
        this.thumbColorScrollBar = thumbColorScrollBar;
    }

    public void setThumbDarkShadowColorScrollBar(ColorUIResource thumbDarkShadowColorScrollBar) {
        this.thumbDarkShadowColorScrollBar = thumbDarkShadowColorScrollBar;
    }

    public void setThumbHighlightColorScrollBar(ColorUIResource thumbHighlightColorScrollBar) {
        this.thumbHighlightColorScrollBar = thumbHighlightColorScrollBar;
    }

    public void setThumbShadowColorScrollBar(ColorUIResource thumbShadowColorScrollBar) {
        this.thumbShadowColorScrollBar = thumbShadowColorScrollBar;
    }

    public void setMouseHoverColorScrollBar(ColorUIResource mouseHoverColorScrollBar) {
        this.mouseHoverColorScrollBar = mouseHoverColorScrollBar;
    }

    public void setArrowButtonColorScrollBar(ColorUIResource arrowButtonColorScrollBar) {
        this.arrowButtonColorScrollBar = arrowButtonColorScrollBar;
    }

    public void setArrowButtonOnClickColorScrollBar(ColorUIResource arrowButtonOnClickColorScrollBar) {
        this.arrowButtonOnClickColorScrollBar = arrowButtonOnClickColorScrollBar;
    }

    public void setArrowButtonBorderScrollBar(BorderUIResource arrowButtonBorderScrollBar) {
        this.arrowButtonBorderScrollBar = arrowButtonBorderScrollBar;
    }

    public void setTrackColorSlider(ColorUIResource trackColorSlider) {
        this.trackColorSlider = trackColorSlider;
    }

    public void setHaloColorSlider(ColorUIResource haloColorSlider) {
        this.haloColorSlider = haloColorSlider;
    }

    public void setBorderSlider(BorderUIResource borderSlider) {
        this.borderSlider = borderSlider;
    }

    public void setHighlightColorTabbedPane(ColorUIResource highlightColorTabbedPane) {
        this.highlightColorTabbedPane = highlightColorTabbedPane;
    }

    public void setBorderHighlightColorTabbedPane(ColorUIResource borderHighlightColorTabbedPane) {
        this.borderHighlightColorTabbedPane = borderHighlightColorTabbedPane;
    }

    public void setFocusColorLineTabbedPane(ColorUIResource focusColorLineTabbedPane) {
        this.focusColorLineTabbedPane = focusColorLineTabbedPane;
    }

    public void setDisableColorTabTabbedPane(ColorUIResource disableColorTabTabbedPane) {
        this.disableColorTabTabbedPane = disableColorTabTabbedPane;
    }

    public void setTabInsetsTabbedPane(InsetsUIResource tabInsetsTabbedPane) {
        this.tabInsetsTabbedPane = tabInsetsTabbedPane;
    }

    public void setSelectedTabInsetsTabbedPane(InsetsUIResource selectedTabInsetsTabbedPane) {
        this.selectedTabInsetsTabbedPane = selectedTabInsetsTabbedPane;
    }

    public void setBackgroundTable(ColorUIResource backgroundTable) {
        this.backgroundTable = backgroundTable;
    }

    public void setBackgroundTableHeader(ColorUIResource backgroundTableHeader) {
        this.backgroundTableHeader = backgroundTableHeader;
    }

    public void setForegroundTable(ColorUIResource foregroundTable) {
        this.foregroundTable = foregroundTable;
    }

    public void setForegroundTableHeader(ColorUIResource foregroundTableHeader) {
        this.foregroundTableHeader = foregroundTableHeader;
    }

    public void setSelectionBackgroundTable(ColorUIResource selectionBackgroundTable) {
        this.selectionBackgroundTable = selectionBackgroundTable;
    }

    public void setSelectionForegroundTable(ColorUIResource selectionForegroundTable) {
        this.selectionForegroundTable = selectionForegroundTable;
    }

    public void setGridColorTable(ColorUIResource gridColorTable) {
        this.gridColorTable = gridColorTable;
    }

    public void setAlternateRowBackgroundTable(ColorUIResource alternateRowBackgroundTable) {
        this.alternateRowBackgroundTable = alternateRowBackgroundTable;
    }

    public void setBorderTable(BorderUIResource borderTable) {
        this.borderTable = borderTable;
    }

    public void setBorderTableHeader(BorderUIResource borderTableHeader) {
        this.borderTableHeader = borderTableHeader;
    }

    public void setCellBorderTableHeader(BorderUIResource cellBorderTableHeader) {
        this.cellBorderTableHeader = cellBorderTableHeader;
    }

    public void setUnselectedCheckBoxIconTable(IconUIResource unselectedCheckBoxIconTable) {
        this.unselectedCheckBoxIconTable = unselectedCheckBoxIconTable;
    }

    public void setSelectedCheckBoxIconTable(IconUIResource selectedCheckBoxIconTable) {
        this.selectedCheckBoxIconTable = selectedCheckBoxIconTable;
    }

    public void setUnselectedCheckBoxIconSelectionRowTable(IconUIResource unselectedCheckBoxIconSelectionRowTable) {
        this.unselectedCheckBoxIconSelectionRowTable = unselectedCheckBoxIconSelectionRowTable;
    }

    public void setSelectedCheckBoxIconSelectionRowTable(IconUIResource selectedCheckBoxIconSelectionRowTable) {
        this.selectedCheckBoxIconSelectionRowTable = selectedCheckBoxIconSelectionRowTable;
    }

    public void setDockingBackgroundToolBar(ColorUIResource dockingBackgroundToolBar) {
        this.dockingBackgroundToolBar = dockingBackgroundToolBar;
    }

    public void setFloatingBackgroundToolBar(ColorUIResource floatingBackgroundToolBar) {
        this.floatingBackgroundToolBar = floatingBackgroundToolBar;
    }

    public void setBorderToolBar(BorderUIResource borderToolBar) {
        this.borderToolBar = borderToolBar;
    }

    public void setSelectionForegroundTree(ColorUIResource selectionForegroundTree) {
        this.selectionForegroundTree = selectionForegroundTree;
    }

    public void setSelectionBackgroundTree(ColorUIResource selectionBackgroundTree) {
        this.selectionBackgroundTree = selectionBackgroundTree;
    }

    public void setSelectionBorderColorTree(ColorUIResource selectionBorderColorTree) {
        this.selectionBorderColorTree = selectionBorderColorTree;
    }

    public void setClosedIconTree(IconUIResource closedIconTree) {
        this.closedIconTree = closedIconTree;
    }

    public void setOpenIconTree(IconUIResource openIconTree) {
        this.openIconTree = openIconTree;
    }

    public void setBackgroundTextField(ColorUIResource backgroundTextField) {
        this.backgroundTextField = backgroundTextField;
    }

    public void setInactiveForegroundTextField(ColorUIResource inactiveForegroundTextField) {
        this.inactiveForegroundTextField = inactiveForegroundTextField;
    }

    public void setInactiveBackgroundTextField(ColorUIResource inactiveBackgroundTextField) {
        this.inactiveBackgroundTextField = inactiveBackgroundTextField;
    }

    public void setSelectionBackgroundTextField(ColorUIResource selectionBackgroundTextField) {
        this.selectionBackgroundTextField = selectionBackgroundTextField;
    }

    public void setSelectionForegroundTextField(ColorUIResource selectionForegroundTextField) {
        this.selectionForegroundTextField = selectionForegroundTextField;
    }

    public void setInactiveColorLineTextField(ColorUIResource inactiveColorLineTextField) {
        this.inactiveColorLineTextField = inactiveColorLineTextField;
    }

    public void setActiveColorLineTextField(ColorUIResource activeColorLineTextField) {
        this.activeColorLineTextField = activeColorLineTextField;
    }

    public void setBorderTextField(BorderUIResource borderTextField) {
        this.borderTextField = borderTextField;
    }

    public void setTitleBackgroundGradientStartTaskPane(ColorUIResource titleBackgroundGradientStartTaskPane) {
        this.titleBackgroundGradientStartTaskPane = titleBackgroundGradientStartTaskPane;
    }

    public void setTitleBackgroundGradientEndTaskPane(ColorUIResource titleBackgroundGradientEndTaskPane) {
        this.titleBackgroundGradientEndTaskPane = titleBackgroundGradientEndTaskPane;
    }

    public void setTitleOverTaskPane(ColorUIResource titleOverTaskPane) {
        this.titleOverTaskPane = titleOverTaskPane;
    }

    public void setSpecialTitleOverTaskPane(ColorUIResource specialTitleOverTaskPane) {
        this.specialTitleOverTaskPane = specialTitleOverTaskPane;
    }

    public void setBackgroundTaskPane(ColorUIResource backgroundTaskPane) {
        this.backgroundTaskPane = backgroundTaskPane;
    }

    public void setBorderColorTaskPane(ColorUIResource borderColorTaskPane) {
        this.borderColorTaskPane = borderColorTaskPane;
    }

    public void setContentBackgroundTaskPane(ColorUIResource contentBackgroundTaskPane) {
        this.contentBackgroundTaskPane = contentBackgroundTaskPane;
    }

    public void setBorderTaskPane(BorderUIResource borderTaskPane) {
        this.borderTaskPane = borderTaskPane;
    }

    public void setYesCollapsedTaskPane(IconUIResource yesCollapsedTaskPane) {
        this.yesCollapsedTaskPane = yesCollapsedTaskPane;
    }

    public void setNoCollapsedTaskPane(IconUIResource noCollapsedTaskPane) {
        this.noCollapsedTaskPane = noCollapsedTaskPane;
    }

    public void setSelectionBackgroundList(ColorUIResource selectionBackgroundList) {
        this.selectionBackgroundList = selectionBackgroundList;
    }

    public void setSelectionForegroundList(ColorUIResource selectionForegroundList) {
        this.selectionForegroundList = selectionForegroundList;
    }

    public void setFocusCellHighlightBorder(BorderUIResource focusCellHighlightBorder) {
        this.focusCellHighlightBorder = focusCellHighlightBorder;
    }

    public void setBorderItemList(BorderUIResource borderItemList) {
        this.borderItemList = borderItemList;
    }

    public void setBorderList(BorderUIResource borderList) {
        this.borderList = borderList;
    }

    public void setBorderFrameRootPane(BorderUIResource borderFrameRootPane) {
        this.borderFrameRootPane = borderFrameRootPane;
    }

    public void setBorderDialogRootPane(BorderUIResource borderDialogRootPane) {
        this.borderDialogRootPane = borderDialogRootPane;
    }

    public void setBackgroundOptionPane(ColorUIResource backgroundOptionPane) {
        this.backgroundOptionPane = backgroundOptionPane;
    }

    public void setWarningIconOptionPane(IconUIResource warningIconOptionPane) {
        this.warningIconOptionPane = warningIconOptionPane;
    }

    public void setErrorIconIconOptionPane(IconUIResource errorIconIconOptionPane) {
        this.errorIconIconOptionPane = errorIconIconOptionPane;
    }

    public void setQuestionIconOptionPane(IconUIResource questionIconOptionPane) {
        this.questionIconOptionPane = questionIconOptionPane;
    }

    public void setInformationIconOptionPane(IconUIResource informationIconOptionPane) {
        this.informationIconOptionPane = informationIconOptionPane;
    }

    public void setIconComputerFileChooser(IconUIResource iconComputerFileChooser) {
        this.iconComputerFileChooser = iconComputerFileChooser;
    }

    public void setIconDirectoryFileChooser(IconUIResource iconDirectoryFileChooser) {
        this.iconDirectoryFileChooser = iconDirectoryFileChooser;
    }

    public void setIconFileFileChooser(IconUIResource iconFileFileChooser) {
        this.iconFileFileChooser = iconFileFileChooser;
    }

    public void setIconFloppyDriveFileChooser(IconUIResource iconFloppyDriveFileChooser) {
        this.iconFloppyDriveFileChooser = iconFloppyDriveFileChooser;
    }

    public void setIconHardDriveFileChooser(IconUIResource iconHardDriveFileChooser) {
        this.iconHardDriveFileChooser = iconHardDriveFileChooser;
    }

    public void setIconHomeFileChooser(IconUIResource iconHomeFileChooser) {
        this.iconHomeFileChooser = iconHomeFileChooser;
    }

    public void setIconListFileChooser(IconUIResource iconListFileChooser) {
        this.iconListFileChooser = iconListFileChooser;
    }

    public void setIconDetailsFileChooser(IconUIResource iconDetailsFileChooser) {
        this.iconDetailsFileChooser = iconDetailsFileChooser;
    }

    public void setIconNewFolderFileChooser(IconUIResource iconNewFolderFileChooser) {
        this.iconNewFolderFileChooser = iconNewFolderFileChooser;
    }

    public void setIconUpFolderFileChooser(IconUIResource iconUpFolderFileChooser) {
        this.iconUpFolderFileChooser = iconUpFolderFileChooser;
    }

    public void setBackgroundProgressBar(ColorUIResource backgroundProgressBar) {
        this.backgroundProgressBar = backgroundProgressBar;
    }

    public void setForegroundProgressBar(ColorUIResource foregroundProgressBar) {
        this.foregroundProgressBar = foregroundProgressBar;
    }

    public void setBorderProgressBar(BorderUIResource borderProgressBar) {
        this.borderProgressBar = borderProgressBar;
    }

    public void setFontBold(FontUIResource fontBold) {
        this.fontBold = fontBold;
    }

    public void setFontItalic(FontUIResource fontItalic) {
        this.fontItalic = fontItalic;
    }

    public void setFontRegular(FontUIResource fontRegular) {
        this.fontRegular = fontRegular;
    }

    public void setFontMedium(FontUIResource fontMedium) {
        this.fontMedium = fontMedium;
    }
}
