package integration.gui.mock;

import mdlaf.components.button.MaterialButtonUI;

import javax.swing.*;

/**
 * @author https://github.com/vincenzopalazzo
 */
public class JButtonNoMouseHoverNative extends JButton {

    public JButtonNoMouseHoverNative() {
    }

    public JButtonNoMouseHoverNative(Icon icon) {
        super(icon);
    }

    public JButtonNoMouseHoverNative(String text) {
        super(text);
    }

    public JButtonNoMouseHoverNative(Action a) {
        super(a);
    }

    public JButtonNoMouseHoverNative(String text, Icon icon) {
        super(text, icon);
    }

    @Override
    protected void init(String text, Icon icon) {
        super.init(text, icon);
        System.out.println("called ****");
        setUI(new JButtonNoMouseHoverUI());
    }

    private static class JButtonNoMouseHoverUI extends MaterialButtonUI{

        @Override
        public void installUI(JComponent c) {
            mouseHoverEnabled = false;
            super.installUI(c);
        }
    }
}
