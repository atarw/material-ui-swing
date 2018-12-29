package mdlaf.components.textfield;

import mdlaf.utils.MaterialDrawingUtils;
import mdlaf.utils.MaterialFonts;
import java.awt.*;
import java.awt.event.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.*;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicTextFieldUI;

/**
 * @author https://github.com/vincenzopalazzo
 */

public class MaterialTextFieldUI extends BasicTextFieldUI implements FocusListener, PropertyChangeListener {

    private boolean drawLine;
    private Color activeBackground;
    private Color activeForeground;
    private Color inactiveBackground;
    private Color inactiveForeground;

    public MaterialTextFieldUI() {
        this(true);
    }

    public MaterialTextFieldUI(boolean drawLine) {
        super();
        this.drawLine = drawLine;
    }

    public static ComponentUI createUI(JComponent c) {
        return new MaterialTextFieldUI();
    }

    @Override
    /**
     * This method not override because non paint correct in the JFileChooser
     * @fixed by https://github.com/vincenzopalazzo
     */
    public void installUI(JComponent c) {
        super.installUI(c);
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
        this.activeBackground = UIManager.getColor("TextField.selectionBackground");
        this.activeForeground = UIManager.getColor("TextField.selectionForeground");
        this.inactiveBackground = UIManager.getColor("TextField.inactiveBackground");
        this.inactiveForeground = UIManager.getColor("TextField.inactiveForeground");
        getComponent().setFont(MaterialFonts.REGULAR);
        getComponent().setSelectionColor(getComponent().hasFocus() && getComponent().isEnabled() ? activeBackground : inactiveBackground);
        getComponent().setSelectedTextColor(getComponent().hasFocus() && getComponent().isEnabled() ? activeForeground : inactiveForeground);
        getComponent().setForeground(getComponent().hasFocus() && getComponent().isEnabled() ? activeForeground : inactiveForeground);
        getComponent().setBorder(BorderFactory.createEmptyBorder(3, 5, 2,5));
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

    private void changeColorOnFocus(boolean hasFocus) {
        JTextField c = (JTextField) getComponent();
        c.setSelectionColor(hasFocus ? activeBackground : inactiveBackground);
        c.setForeground(hasFocus ? activeForeground : inactiveForeground);
        c.setSelectedTextColor(hasFocus ? activeForeground : inactiveForeground);
        c.paint(c.getGraphics());
    }

    @Override
    protected void installKeyboardActions() {
        super.installKeyboardActions();

        Action selectAll = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getComponent().selectAll();
            }
        };

        Action delete = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (getComponent().getSelectedText() == null) {
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
                getComponent().setCaretPosition(Math.max(0, getComponent().getCaretPosition() - 1));
            }
        };

        Action right = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getComponent().setCaretPosition(Math.min(getComponent().getText().length(), getComponent().getCaretPosition() + 1));
            }
        };

        Action enter = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ((JTextField) getComponent()).postActionEvent();
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

    @Override
    /**
     *This metod drive a line button on JTextField
     * @fixed by https://github.com/vincenzopalazzo
     */
    public void paintSafely(Graphics g) {
        JTextField c = (JTextField) getComponent();
        super.paintSafely(g);
        if (drawLine) {
            int x = c.getInsets().left;
            int y = c.getInsets().top;
            int w = c.getWidth() - c.getInsets().left - c.getInsets().right;
            g.setColor(c.getSelectionColor());

            g.fillRect(x, c.getHeight() - y - 1, w, 2);
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


