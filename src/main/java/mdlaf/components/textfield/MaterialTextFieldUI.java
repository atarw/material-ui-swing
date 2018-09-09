package mdlaf.components.textfield;

import mdlaf.utils.MaterialDrawingUtils;
import mdlaf.utils.MaterialFonts;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.UIManager;
import javax.swing.plaf.ComponentUI;
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

public class MaterialTextFieldUI extends BasicTextFieldUI implements FocusListener, PropertyChangeListener {

	private boolean drawLine;
	private Color activeBackground;
	private Color activeForeground;
	private Color inactiveBackground;
	private Color inactiveForeground;

	public MaterialTextFieldUI () {
		this (true);
	}

	public MaterialTextFieldUI (boolean drawLine) {
		super ();
		this.drawLine = drawLine;
	}

	public static ComponentUI createUI (JComponent c) {
		return new MaterialTextFieldUI ();
	}

	@Override
	public void installUI (JComponent c) {
		super.installUI (c);

		JTextField textField = (JTextField) c;
		textField.setOpaque (false);
		textField.setBorder (drawLine ?
		                     BorderFactory.createEmptyBorder (5, 2, 10, 0) :
		                     BorderFactory.createEmptyBorder (2, 2, 2, 2));

		textField.setFont (MaterialFonts.REGULAR);
		this.activeBackground = UIManager.getColor ("TextField.selectionBackground");
		this.activeForeground = UIManager.getColor ("TextField.selectionForeground");
		this.inactiveBackground = UIManager.getColor ("TextField.inactiveBackground");
		this.inactiveForeground = UIManager.getColor ("TextField.inactiveForeground");

		textField.setSelectionColor (c.hasFocus () && c.isEnabled () ? activeBackground : inactiveBackground);
		textField.setSelectedTextColor (c.hasFocus () && c.isEnabled () ? activeForeground : inactiveForeground);
		textField.setForeground (c.hasFocus () && c.isEnabled () ? activeForeground : inactiveForeground);
	}

	@Override
	protected void installListeners () {
		super.installListeners ();
		getComponent ().addFocusListener (this);
		getComponent ().addPropertyChangeListener (this);
	}

	@Override
	protected void installKeyboardActions () {
		super.installKeyboardActions ();

		Action selectAll = new AbstractAction () {
			@Override
			public void actionPerformed (ActionEvent e) {
				getComponent ().selectAll ();
			}
		};

		Action delete = new AbstractAction () {
			@Override
			public void actionPerformed (ActionEvent e) {
				if (getComponent ().getSelectedText () == null) {
					int pos = getComponent ().getCaretPosition () - 1;

					if (pos >= 0) {
						getComponent ().select (pos, pos + 1);
						getComponent ().replaceSelection ("");
					}
				}
				else {
					getComponent ().replaceSelection ("");
				}
			}
		};

		Action left = new AbstractAction () {
			@Override
			public void actionPerformed (ActionEvent e) {
				getComponent ().setCaretPosition (Math.max (0, getComponent ().getCaretPosition () - 1));
			}
		};

		Action right = new AbstractAction () {
			@Override
			public void actionPerformed (ActionEvent e) {
				getComponent ().setCaretPosition (Math.min (getComponent ().getText ().length (), getComponent ().getCaretPosition () + 1));
			}
		};

		Action enter = new AbstractAction () {
			@Override
			public void actionPerformed (ActionEvent e) {
				((JTextField) getComponent ()).postActionEvent ();
			}
		};

		// note getMenuShortcutKeyMask() is deprecated in Java 10 - change to getMenuShortcutKeyMaskEx()
		getComponent ().getInputMap ().put (KeyStroke.getKeyStroke (KeyEvent.VK_A, Toolkit.getDefaultToolkit ().getMenuShortcutKeyMask ()), "selectAll");
		getComponent ().getInputMap ().put (KeyStroke.getKeyStroke (KeyEvent.VK_BACK_SPACE, 0), "delete");
		getComponent ().getInputMap ().put (KeyStroke.getKeyStroke (KeyEvent.VK_LEFT, 0), "left");
		getComponent ().getInputMap ().put (KeyStroke.getKeyStroke (KeyEvent.VK_RIGHT, 0), "right");
		getComponent ().getInputMap ().put (KeyStroke.getKeyStroke (KeyEvent.VK_ENTER, 0), "enter");

		getComponent ().getActionMap ().put ("selectAll", selectAll);
		getComponent ().getActionMap ().put ("delete", delete);
		getComponent ().getActionMap ().put ("left", left);
		getComponent ().getActionMap ().put ("right", right);
		getComponent ().getActionMap ().put ("enter", enter);
	}

	@Override
	public void paintSafely (Graphics g) {
		JTextField c = (JTextField) getComponent ();
		g = MaterialDrawingUtils.getAliasedGraphics (g);

		if (drawLine) {
			int x = c.getInsets ().left;
			int y = c.getInsets ().top;
			int w = c.getWidth () - c.getInsets ().left - c.getInsets ().right;

			g.setColor (c.getSelectionColor ());
			g.fillRect (x, c.getHeight () - y, w, 2);
		}

		super.paintSafely (g);
	}

	@Override
	public void focusGained (FocusEvent e) {
		changeColorOnFocus (true);
	}

	@Override
	public void focusLost (FocusEvent e) {
		changeColorOnFocus (false);
	}

	private void changeColorOnFocus (boolean hasFocus) {
		JTextField c = (JTextField) getComponent ();

		c.setSelectionColor (hasFocus ? activeBackground : inactiveBackground);
		c.setForeground (hasFocus ? activeForeground : inactiveForeground);
		c.setSelectedTextColor (hasFocus ? activeForeground : inactiveForeground);

		c.paint (c.getGraphics ());
	}

	@Override
	public void propertyChange (PropertyChangeEvent pce) {
		super.propertyChange (pce);

		if (pce.getPropertyName ().equals ("selectionColor")) {
			Color newColor = (Color) pce.getNewValue ();

			if (!newColor.equals (activeBackground) && !newColor.equals (inactiveBackground)) {
				this.activeBackground = newColor;
				getComponent ().repaint ();
			}
		}

		if (pce.getPropertyName ().equals ("selectedTextColor")) {
			Color newColor = (Color) pce.getNewValue ();

			if (!newColor.equals (activeForeground) && !newColor.equals (inactiveForeground)) {
				this.activeForeground = newColor;
				getComponent ().repaint ();
			}
		}

		if (pce.getPropertyName ().equals ("background")) {
			getComponent ().repaint ();
		}
	}
}