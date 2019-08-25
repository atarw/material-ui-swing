package mdlaf.themes;

import mdlaf.utils.MaterialColors;
import sun.swing.ImageIconUIResource;

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

    boolean getMouseHoverEnableTabbedPane();

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

    //All type of font supported to the theme
    FontUIResource getFontBold();

    FontUIResource getFontItalic();

    FontUIResource getFontRegular();

    FontUIResource getFontMedium();


}
