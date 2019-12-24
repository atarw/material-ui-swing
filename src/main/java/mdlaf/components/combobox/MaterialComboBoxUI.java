package mdlaf.components.combobox;

import mdlaf.animation.MaterialUIMovement;
import mdlaf.utils.MaterialBorders;
import mdlaf.utils.MaterialDrawingUtils;
import mdlaf.utils.MaterialManagerListener;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicArrowButton;
import javax.swing.plaf.basic.BasicComboBoxUI;
import java.awt.*;
import java.awt.event.*;
import java.util.concurrent.ForkJoinPool;


/**
 * @author https://github.com/vincenzopalazzo
 * @author https://github.com/atarw
 */
public class MaterialComboBoxUI extends BasicComboBoxUI {

	public static ComponentUI createUI(JComponent c) {
		return new MaterialComboBoxUI();
	}

	protected Color background;
	protected FocusListener focusListener;
	protected int arc = 12; //default value

	public MaterialComboBoxUI() {
		focusListener = new FocusListenerColor();
	}

	@Override
	public void installUI(JComponent c) {
		super.installUI(c);

		comboBox.setFont(UIManager.getFont("ComboBox.font"));
		background = UIManager.getColor("ComboBox.background");
		comboBox.setBackground(background);
		comboBox.setForeground(UIManager.getColor("ComboBox.foreground"));
		comboBox.setBorder(UIManager.getBorder("ComboBox.border"));
		comboBox.setLightWeightPopupEnabled(true);
		comboBox.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		comboBox.setFocusable(UIManager.getBoolean("ComboBox.focusable"));

		this.arc = UIManager.getInt("ComboBox.arc");
	}

	@Override
	public void uninstallUI(JComponent c) {

		// comboBox.setFont(null);
		comboBox.setBackground(null);
		comboBox.setForeground(null);
		comboBox.setBorder(null);
		comboBox.setLightWeightPopupEnabled(true);
		comboBox.setCursor(null);
		comboBox.setRenderer(null);
		comboBox.setEditor(null);

		comboBox.removeFocusListener(focusListener);
		MaterialManagerListener.removeAllMaterialMouseListener(comboBox);

		super.uninstallUI(comboBox);
	}

	@Override
	protected JButton createArrowButton() {
		Icon icon = UIManager.getIcon("ComboBox.buttonIcon");
		JButton button;
		if (icon != null) {
			button = new JButton(icon);
		} else {
			button = new BasicArrowButton(SwingConstants.SOUTH);
		}
		this.configureLocalArrowButton(button);
		return button;
	}

	@Override
	public void configureArrowButton() {
		super.configureArrowButton();
		this.configureLocalArrowButton(arrowButton);
	}



	@Override
	public void unconfigureArrowButton() {
		MaterialManagerListener.removeAllMaterialMouseListener(arrowButton);
		super.unconfigureArrowButton();
	}

	@Override
	protected void uninstallListeners() {
		if(this.comboBox.isFocusable()){
			this.comboBox.removeFocusListener(focusListener);
		}
		super.uninstallListeners();
	}

	@Override
	public void update(Graphics g, JComponent c) {
		//super.update(g, c);
		g = MaterialDrawingUtils.getAliasedGraphics(g);
		g.setColor(c.getBackground());
		g.fillRoundRect(0, 0, comboBox.getWidth(), comboBox.getHeight(), arc, arc);
		paint(g, c);
		this.configureLocalArrowButton(arrowButton);
	}

	@Override
	protected ListCellRenderer createRenderer() {
		return new MaterialComboBoxRenderer();
	}

	@Override
	protected ComboBoxEditor createEditor() {
		return new MaterialComboBoxEditor();
	}

	@Override
	protected FocusListener createFocusListener() {
		if(comboBox.isFocusable()){
			comboBox.addFocusListener(focusListener);
		}
		return super.createFocusListener();
	}

	protected void configureLocalArrowButton(JButton arrowButton){
		MaterialManagerListener.removeAllMaterialMouseListener(arrowButton);
		arrowButton.setOpaque(true);
		arrowButton.setBackground(UIManager.getColor("ComboBox.buttonBackground"));
		if (UIManager.getBoolean("ComboBox.mouseHoverEnabled")) {
			arrowButton.addMouseListener(MaterialUIMovement.getMovement(arrowButton, UIManager.getColor("ComboBox.mouseHoverColor")));
		}
		arrowButton.setBorder(UIManager.getBorder("ComboBox[button].border"));
	}

	protected class FocusListenerColor implements FocusListener {

		private Border focus;
		private Border unfocus;

		public FocusListenerColor() {
			focus = MaterialBorders.roundedLineColorBorder(UIManager.getColor("ComboBox.focusColor"), arc);
			unfocus = MaterialBorders.roundedLineColorBorder(UIManager.getColor("ComboBox.unfocusColor"), arc);
		}

		@Override
		public void focusGained(FocusEvent e) {
			if (e.getComponent() == null) {
				return;
			}
			JComboBox cb = (JComboBox) e.getComponent();
			if (focus != null) {
				cb.setBorder(focus);
				cb.repaint();
			}
		}

		@Override
		public void focusLost(FocusEvent e) {
			if (e.getComponent() == null) {
				return;
			}
			JComboBox cb = (JComboBox) e.getComponent();
			if (unfocus != null) {
				cb.setBorder(unfocus);
				cb.repaint();
			}
		}
	}
}
