package integration.gui.mock.component;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.WindowEvent;
import java.beans.PropertyVetoException;

import javax.swing.BorderFactory;
import javax.swing.JDesktopPane;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.WindowConstants;

public class IssueExample {
    static {
        try {
            UIManager.setLookAndFeel(new mdlaf.MaterialLookAndFeel(new mdlaf.themes.MaterialLiteTheme()));
            UIManager.put("Button.mouseHoverEnable", false);
            JDialog.setDefaultLookAndFeelDecorated(true);
            JFrame.setDefaultLookAndFeelDecorated(false);
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        MainFrameExample frame = new MainFrameExample();
        frame.setVisible(true);
    }
}

class MainFrameExample extends JFrame {
    private static final long serialVersionUID = 1L;

    protected JDesktopPane thisDesktopPane = new JDesktopPane();

    protected int prevWidth = 0;
    protected int prevHeight = 0;

    protected MainFrameExample() {
        this.getContentPane().setLayout(new BorderLayout());

        JPanel p = new JPanel(new BorderLayout());
        p.setBorder(BorderFactory.createLoweredBevelBorder());
        JScrollPane scrollPane = new JScrollPane(thisDesktopPane);
        p.add(scrollPane, BorderLayout.CENTER);
        this.getContentPane().add(p, BorderLayout.CENTER);

        try {
            jbInit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void jbInit() throws Exception {
        this.setTitle("Test internal frame");
        setSize(new Dimension(800, 600));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent e) {
                System.exit(0);
            }

            public void windowOpened(WindowEvent e) {

                InternalFrameExample frame1 = new InternalFrameExample(1);
                thisDesktopPane.add(frame1, JDesktopPane.DEFAULT_LAYER);
                try {
                    frame1.setTitle("Internal 1");
                    frame1.setBounds(0, 0, 500, 150);
                    frame1.setVisible(true);
                    frame1.setSelected(true);
                } catch (PropertyVetoException e1) {
                    e1.printStackTrace();
                }

                InternalFrameExample frame2 = new InternalFrameExample(2);
                thisDesktopPane.add(frame2, JDesktopPane.DEFAULT_LAYER);
                try {
                    frame2.setTitle("Move me over Internal 1");
                    frame2.setBounds(100, 0, 500, 150);
                    frame2.setVisible(true);
                    frame2.setSelected(true);
                } catch (PropertyVetoException e1) {
                    e1.printStackTrace();
                }
            }
        });
    }

    class InternalFrameExample extends JInternalFrame {
        static final long serialVersionUID = 1;

        public InternalFrameExample(int nb) {
            super();
            setResizable(true);
            setMaximizable(true);
            setIconifiable(true);
            setClosable(true);
            setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

            setPreferredSize(new Dimension(500, 150));
            getContentPane().setLayout(null);
            JTextField f1 = new JTextField();
            f1.setText("Text-" + nb);
            f1.setBounds(0, 0, 500, 21);
            getContentPane().add(f1, null);
            pack();
        }
    }
}
