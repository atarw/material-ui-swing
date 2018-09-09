package main.java.mdlaf.components.toast;

import mdlaf.utils.MaterialColors;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.geom.RoundRectangle2D;

/**
 * See also: https://github.com/vincenzopalazzo/android-toasts-for-swing
 * @author https://github.com/vincenzopalazzo
 */

public class MaterialTost extends JDialog {

    private static final long serialVersionUID = -1602907470843951525L;

    /**
     * The Constant SHORT Set the shortest amount of time to display the toast
     */
    public static final int SHORT = 3000;
    /**
     * The Constant SHORT Set the longest time to display the toast
     */
    public static final int LONG = 6000;
    /**
     * The Constant ERROR Set the color red to display the toast
     */
    public static final Color ERROR = MaterialColors.RED_700;
    /**
     * The Constant SUCCES Set the color green to display the toast
     */
    public static final Color SUCCESS = MaterialColors.GREEN_500;
    /**
     * The Constant NORMAL Set the color GRAY to display the toast
     */
    public static final Color NORMAL = MaterialColors.GRAY_800;
    /**
     * The Constant DOWN Set the position tost on the top
     */
    public static final int TOP = 1;
    /**
     * The Constant DOWN Set the position tost on the bottom
     */
    public static final int BOTTOM = 0;

    private final float MAX_OPACITY = 0.8f;
    private final float OPACITY_INCREMENT = 0.05f;
    private final int FADE_REFRESH_RATE = 20;
    private final int WINDOW_RADIUS = 15;
    private final int CHARACTER_LENGTH_MULTIPLIER = 10;
    private final int DISTANCE_FROM_PARENT = 50;

    private JFrame mOwner;
    private String mText;
    private int mDuration;
    private int mPosition;
    private Color mBackgroundColor = (Color) UIManager.get("ToolTip.background");
    private Color mForegroundColor = (Color) UIManager.get("ToolTip.foreground");
    private Font mFont = (Font) UIManager.get("ToolTip.font");

    /**
     *
     * @param owner is the instance JFrame
     */
    public MaterialTost(JFrame owner) {
        super(owner);
        mOwner = owner;
    }

    private void createGUI() {
        setLayout(new GridBagLayout());
        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                setShape(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), WINDOW_RADIUS, WINDOW_RADIUS));
            }
        });

        setAlwaysOnTop(true);
        setUndecorated(true);
        setFocusableWindowState(false);
        setModalityType(ModalityType.MODELESS);
        setSize(mText.length() * CHARACTER_LENGTH_MULTIPLIER, 25);
        getContentPane().setBackground(mBackgroundColor);

        JLabel label = new JLabel(mText);
        label.setBackground(mBackgroundColor);
        label.setForeground(mForegroundColor);
        label.setFont(mFont);
        add(label);
    }

    private void fadeIn() {
        final Timer timer = new Timer(FADE_REFRESH_RATE, null);
        timer.setRepeats(true);
        timer.addActionListener(new ActionListener() {
            private float opacity = 0;

            @Override
            public void actionPerformed(ActionEvent e) {
                opacity += OPACITY_INCREMENT;
//                setOpacity(Math.min(opacity, MAX_OPACITY));
                if (opacity >= MAX_OPACITY) {
                    timer.stop();
                }
            }
        });

        timer.start();

        setLocation(getToastLocation());
        setVisible(true);
    }

    private void fadeOut() {
        final Timer timer = new Timer(FADE_REFRESH_RATE, null);
        timer.setRepeats(true);
        timer.addActionListener(new ActionListener() {
            private float opacity = MAX_OPACITY;

            @Override
            public void actionPerformed(ActionEvent e) {
                opacity -= OPACITY_INCREMENT;
//                setOpacity(Math.max(opacity, 0));
                if (opacity <= 0) {
                    timer.stop();
                    setVisible(false);
                    dispose();
                }
            }
        });

//        setOpacity(MAX_OPACITY);
        timer.start();
    }

    private Point getToastLocation() {
        Point ownerLoc = mOwner.getLocation();
        if(mPosition == TOP){
            int x = (int) (ownerLoc.getX() + ((mOwner.getWidth() - this.getWidth()) / 2));
            int y = (int) (ownerLoc.getY());
            return new Point(x, y);
        }
        int x = (int) (ownerLoc.getX() + ((mOwner.getWidth() - this.getWidth()) / 2));
        int y = (int) (ownerLoc.getY() + mOwner.getHeight() - DISTANCE_FROM_PARENT);
        return new Point(x, y);
    }

    public void setText(String text) {
        mText = text;
    }

    public void setDuration(int duration) {
        mDuration = duration;
    }

    @Override
    public void setForeground(Color foregroundColor) {
        mForegroundColor = foregroundColor;
    }

    /**
     *
     * @param owner is the istance JFrame
     * @param text It indicates the text that must contain the Toast
     * @return MaterialToast where you can call show for viewing
     */
    public static MaterialTost makeText(JFrame owner, String text) {
        return makeText(owner, text, SHORT, NORMAL, BOTTOM);
    }

    /**
     *
     * @param owner is the istance JFrame
     * @param text It indicates the text that must contain the Toast
     * @param style It indicates the color It is inidicate the color that must have the toast, using the constants that you find as the interface of the class
     * @return MaterialToast where you can call show for viewing
     */
    public static MaterialTost makeText(JFrame owner, String text, Color style) {
        return makeText(owner, text, SHORT, style, BOTTOM);
    }

    /**
     *
     * @param owner is the istance JFrame
     * @param text It indicates the text that must contain the Toast
     * @param duration It indicates the duration of displaying the toast, using the constants that you find as the interface of the class
     * @return MaterialToast where you can call show for viewing
     */
    public static MaterialTost makeText(JFrame owner, String text, int duration) {
        return makeText(owner, text, duration, NORMAL, BOTTOM);
    }

    /**
     *
     * @param owner is the istance JFrame
     * @param text It indicates the text that must contain the Toast
     * @param style It indicates the color It is inidicate the color that must have the toast, using the constants that you find as the interface of the class
     * @param duration It indicates the duration of displaying the toast, using the constants that you find as the interface of the class
     * @return MaterialToast where you can call show for viewing
     * @throws IllegalArgumentException
     */
    public static MaterialTost makeText(JFrame owner, String text, int duration, Color style, int position) {
        if(text == null ){
            throw new IllegalArgumentException("Text is null");
        }
        if((!style.equals(NORMAL) && !style.equals(ERROR) && !style.equals(SUCCESS))){
            throw new IllegalArgumentException("I do not support the color you have entered");
        }
        if((position != TOP && position != BOTTOM)){
            throw new IllegalArgumentException("I do not support the position you have entered");
        }
        if((duration != SHORT && duration != LONG)){
            throw new IllegalArgumentException("I do not support the duration you have entered");
        }
        MaterialTost toast = new MaterialTost(owner);
        toast.mText = text;
        toast.mDuration = duration;
        toast.mBackgroundColor = style;
        toast.mPosition = position;
        return toast;
    }

    public void display() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    createGUI();
                    fadeIn();
                    Thread.sleep(mDuration);
                    fadeOut();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }).start();
    }

}
