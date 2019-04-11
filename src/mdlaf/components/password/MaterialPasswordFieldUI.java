package mdlaf.components.password;

import mdlaf.utils.MaterialDrawingUtils;
import mdlaf.utils.MaterialFonts;

import javax.swing.*;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicPasswordFieldUI;
import javax.swing.plaf.basic.BasicTextFieldUI;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 * @contributor https://github.com/vincenzopalazzo
 */
public class MaterialPasswordFieldUI extends BasicPasswordFieldUI implements FocusListener, PropertyChangeListener {

	private boolean drawLine;
	private Color activeBackground;
	private Color activeForeground;
	private Color inactiveBackground;
	private Color inactiveForeground;

	public MaterialPasswordFieldUI() {
		this(true);
	}

	public MaterialPasswordFieldUI(boolean drawLine) {
		super();
		this.drawLine = drawLine;
	}

	public static ComponentUI createUI(JComponent c) {
		return new MaterialPasswordFieldUI();
	}

	@Override
	/**
	 * This method not override because non paint correct in the JFileChooser
	 * @fixed by https://github.com/vincenzopalazzo
	 */
	public void installUI(JComponent c) {
		super.installUI(c);
		JPasswordField passwordField = (JPasswordField) c;
		passwordField.setEchoChar('\u2022');
	}

	@Override
	protected void installDefaults() {
		super.installDefaults();
		installMyDefaults();
	}

	@Override
	protected void uninstallDefaults() {
		getComponent().setBorder(null);
		super.uninstallDefaults();
	}

	@Override
	protected void installListeners() {
		super.installListeners();
		getComponent().addFocusListener(this);
		getComponent().addPropertyChangeListener(this);
	}

	@Override
	protected void uninstallListeners() {
		getComponent().removeFocusListener(this);
		super.uninstallListeners();
	}

	private void installMyDefaults() {
		this.activeBackground = UIManager.getColor("PasswordField.selectionBackground");
		this.activeForeground = UIManager.getColor("PasswordField.selectionForeground");
		this.inactiveBackground = UIManager.getColor("PasswordField.inactiveBackground");
		this.inactiveForeground = UIManager.getColor("PasswordField.inactiveForeground");
		getComponent().setFont(UIManager.getFont("PasswordField.font"));

		getComponent().setSelectionColor(getComponent().hasFocus() && getComponent().isEnabled() ? activeBackground : inactiveBackground);
		getComponent().setSelectedTextColor(getComponent().hasFocus() && getComponent().isEnabled() ? activeForeground : inactiveForeground);
		getComponent().setForeground(getComponent().hasFocus() && getComponent().isEnabled() ? activeForeground : inactiveForeground);
		getComponent().setBorder(UIManager.getBorder("PasswordField.border"));
	}
	@Override
	protected void paintBackground(Graphics g) {
		super.paintBackground(MaterialDrawingUtils.getAliasedGraphics(g));
	}


	@Override
	public void focusGained(FocusEvent e) {
		changeColorOnFocus(true);
	}

	@Override
	public void focusLost(FocusEvent e) {
		changeColorOnFocus(false);
	}

	//TODO refactoring for recicle code
	private void changeColorOnFocus(boolean hasFocus) {
		JPasswordField c = (JPasswordField) getComponent();
		if(c == null){
			return;
		}
		/*c.setSelectionColor(hasFocus ? activeBackground : inactiveBackground);
		c.setForeground(hasFocus ? activeForeground : inactiveForeground);
		c.setSelectedTextColor(hasFocus ? activeForeground : inactiveForeground);*/
		if(hasFocus && (activeBackground != null) && (activeForeground != null)){
			c.setSelectionColor(activeBackground);
			c.setForeground(activeForeground);
			c.setSelectedTextColor(activeForeground);
		}

		if(!hasFocus && (inactiveBackground != null) && (inactiveForeground != null)){
			c.setSelectionColor(inactiveBackground);
			c.setForeground(inactiveForeground);
			c.setSelectedTextColor(inactiveForeground);
		}
		if(c.getGraphics() != null){
			c.paint(c.getGraphics());
		}
	}
/*
	@Override
	protected void installKeyboardActions() {
		super.installKeyboardActions();

		Action selectAll = new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(getComponent() != null){
					getComponent().selectAll();
				}
			}
		};

		Action delete = new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (getComponent().getSelectedText() != null) {
					int pos = getComponent().getCaretPosition() - 1;

					if (pos >= 0) {
						getComponent().select(pos, pos + 1);
						getComponent().replaceSelection("");
					}
				} else {
					getComponent().replaceSelection("");
				}
			}
		};

		Action left = new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(getComponent() != null){
					getComponent().setCaretPosition(Math.max(0, getComponent().getCaretPosition() - 1));
				}
			}
		};

		Action right = new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(getComponent() != null){
					getComponent().setCaretPosition(Math.min(getComponent().getText().length(), getComponent().getCaretPosition() + 1));
				}
			}
		};

		Action enter = new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(getComponent() != null){
					((JPasswordField) getComponent()).postActionEvent();
				}
			}
		};

		// note getMenuShortcutKeyMask() is deprecated in Java 10 - change to getMenuShortcutKeyMaskEx()
		getComponent().getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_A, Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()), "selectAll");
		getComponent().getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_BACK_SPACE, 0), "delete");
		getComponent().getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0), "left");
		getComponent().getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0), "right");
		getComponent().getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "enter");

		getComponent().getActionMap().put("selectAll", selectAll);
		getComponent().getActionMap().put("delete", delete);
		getComponent().getActionMap().put("left", left);
		getComponent().getActionMap().put("right", right);
		getComponent().getActionMap().put("enter", enter);
	}
*/
	@Override
	/**
	 *This method drive a line button on JTextField
	 * @fixed by https://github.com/vincenzopalazzo
	 */
	public void paintSafely(Graphics g) {
		JPasswordField c = (JPasswordField) getComponent();
		super.paintSafely(g);
		if (drawLine) {
			int x = c.getInsets().left;
			int y = c.getInsets().top;
			int w = c.getWidth() - c.getInsets().left - c.getInsets().right;
			g.setColor(c.getSelectionColor());

			g.fillRect(x, c.getHeight() - y, w, 1);
		}

	}

	@Override
	public void propertyChange(PropertyChangeEvent pce) {
		super.propertyChange(pce);

		if (pce.getPropertyName().equals("selectionColor")) {
			Color newColor = (Color) pce.getNewValue();
			if (!newColor.equals(activeBackground) && !newColor.equals(inactiveBackground)) {
				this.activeBackground = newColor;
				getComponent().repaint();
			}
		}

		if (pce.getPropertyName().equals("selectedTextColor")) {
			Color newColor = (Color) pce.getNewValue();
			if (!newColor.equals(activeForeground) && !newColor.equals(inactiveForeground)) {
				this.activeForeground = newColor;
				getComponent().repaint();
			}
		}
		if (pce.getPropertyName().equals("background")) {
			getComponent().repaint();
		}

	}

}