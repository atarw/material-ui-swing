package mdlaf.components.list;

import javax.swing.*;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicListUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * @author https://github.com/vincenzopalazzo
 */
public class MaterialListUI extends BasicListUI {

    private JList list;

    @SuppressWarnings({"MethodOverridesStaticMethodOfSuperclass", "UnusedDeclaration"})
    public static ComponentUI createUI(JComponent c) {
        return new MaterialListUI();
    }

    @Override
    public void installUI(JComponent c) {
        super.installUI(c);

        list = (JList) c;
        list.setBackground(UIManager.getColor("List.background"));
        list.setForeground(UIManager.getColor("List.foreground"));
        list.setBorder(UIManager.getBorder("List.border"));
        list.setFont(UIManager.getFont("List.font"));
        list.setSelectionBackground(UIManager.getColor("List.selectionBackground"));
        list.setSelectionForeground(UIManager.getColor("List.selectionForeground"));
        list.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        list.setFocusable(UIManager.getBoolean("List.focusable"));



    }

    private void installKeyboarListner(){
        list.getInputMap().put(KeyStroke.getKeyStroke("UP"), "selectPreviousRow");
        list.getInputMap().put(KeyStroke.getKeyStroke("DOWN"), "selectNextRow");
    }

    @Override
    protected void installKeyboardActions() {
        super.installKeyboardActions();
        KeyStroke down = KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0);
        KeyStroke up = KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0);
        String actionMoveUp = "actionArrowMoveUpMaterial";
        String actionMoveDown = "actionArrowMoveDownMaterial";



        /*this.list.getInputMap().put(down, actionMoveDown);
        this.list.getInputMap().put(up, actionMoveUp);

        this.list.getActionMap().put(actionMoveDown, new ActionMoveWhitArrow(false));
        this.list.getActionMap().put(actionMoveUp, new ActionMoveWhitArrow(true));*/

    }

    @Override
    protected void selectPreviousIndex() {
        super.selectPreviousIndex();
    }

    @Override
    protected void selectNextIndex() {
        super.selectNextIndex();
    }

    private class ActionMoveWhitArrow extends AbstractAction{

        private boolean isUp;

        public ActionMoveWhitArrow(boolean isUp) {
            this.isUp = isUp;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if(isUp){
                System.out.println("Mannaiaaa");
                selectNextIndex();
            }else{
                selectPreviousIndex();
            }
        }
    }

    private class KeyboardEventArrow implements KeyListener{

        @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();
            if(key == KeyEvent.VK_UP){
                System.out.println("UP");
            }
            if(key == KeyEvent.VK_DOWN){
                System.out.println("DOWN");
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {

        }
    }
}
