package integration.gui.mock;

import mdlaf.MaterialLookAndFeel;

import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.WindowConstants;

/**
 * @author https://github.com/vincenzopalazzo
 */
//TODO import this into DEMoGUITest
public class SwitchThemeDemo extends JFrame implements ComponentListener,ActionListener {

    // Variables declaration
    private JMenuItem audioMenuItem;
    private JMenuItem boardMenuItem;
    private JMenuItem exitMenuItem;
    private JMenuItem clientsMenuItem;
    private JMenuItem acryl;
    private JMenuItem hifi;
    private JMenuItem aero;
    private JMenuItem aluminium;
    private JMenuItem bernstein;
    private JMenuItem   fast;
    private JMenuItem graphite;
    private JMenuItem luna;
    private JMenuItem mcwin;
    private JMenuItem material;

    private JMenuItem noire;
    private JMenuItem smart;
    private JMenuBar boardMenuBar;

    private JMenuItem messengerMenuItem;
    private JMenu openMenu;
    private JMenu saveMenu;
    private JMenu themesMenu;
    private JMenuItem saveMessengerMenuItem;
    private JMenuItem saveWhiteboardMenuItem;
    private JMenu userMenu;


    JLayeredPane layerpane;


    /** Creates new form discussionBoard
     * @param connection */
    public SwitchThemeDemo()
    {

        initComponents();
        setLocationRelativeTo(null);
        addComponentListener(this);

    }

    private void initComponents() {

        boardMenuBar = new JMenuBar();
        openMenu = new JMenu();
        themesMenu = new JMenu();
        messengerMenuItem = new JMenuItem();
        boardMenuItem = new JMenuItem();
        audioMenuItem = new JMenuItem();
        saveMenu = new JMenu();
        saveMessengerMenuItem = new JMenuItem();
        saveWhiteboardMenuItem = new JMenuItem();
        userMenu = new JMenu();
        clientsMenuItem = new JMenuItem();
        exitMenuItem = new JMenuItem();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());
        setResizable(false);
        setTitle("Discussion Board");

        openMenu.setText("Open");
        saveMenu.setText("Save");
        themesMenu.setText("Themes");
        acryl = new JMenuItem("Acryl");
        hifi = new JMenuItem("HiFi");
        aero = new JMenuItem("Aero");
        aluminium = new JMenuItem("Aluminium");
        bernstein = new JMenuItem("Bernstein");
        fast = new JMenuItem("Fast");
        graphite = new JMenuItem("Graphite");
        luna = new JMenuItem("Luna");
        mcwin = new JMenuItem("MCwin");
        noire = new JMenuItem("Noire");
        smart = new JMenuItem("Smart");
        material = new JMenuItem("Material");


        hifi.addActionListener(this);
        acryl.addActionListener(this);
        aero.addActionListener(this);
        aluminium.addActionListener(this);
        bernstein.addActionListener(this);
        fast.addActionListener(this);
        graphite.addActionListener(this);
        luna.addActionListener(this);
        mcwin.addActionListener(this);
        noire.addActionListener(this);
        smart.addActionListener(this);
        material.addActionListener(this);

        messengerMenuItem.setText("Messenger");
        openMenu.add(messengerMenuItem);
        openMenu.add(boardMenuItem);
        audioMenuItem.setText("Audio Messenger");
        openMenu.add(audioMenuItem);
        exitMenuItem.setText("Exit");
        exitMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                exitMenuItemActionPerformed(evt);
            }
        });
        openMenu.add(exitMenuItem);

        boardMenuBar.add(openMenu);

        saveMessengerMenuItem.setText("Messenger");

        saveMenu.add(saveMessengerMenuItem);

        saveWhiteboardMenuItem.setText("Whiteboard");

        saveMenu.add(saveWhiteboardMenuItem);

        boardMenuBar.add(saveMenu);

        userMenu.setText("Users");
        clientsMenuItem.setText("Current Session");

        userMenu.add(clientsMenuItem);
        themesMenu.add(acryl);
        themesMenu.add(hifi);
        themesMenu.add(aero);
        themesMenu.add(aluminium);
        themesMenu.add(bernstein);
        themesMenu.add(fast);
        themesMenu.add(graphite);
        themesMenu.add(luna);
        themesMenu.add(mcwin);
        themesMenu.add(noire);
        themesMenu.add(smart);
        themesMenu.add(material);
        boardMenuBar.add(userMenu);
        boardMenuBar.add(themesMenu);
        saveMessengerMenuItem.setEnabled(false);
        saveWhiteboardMenuItem.setEnabled(false);

        setJMenuBar(boardMenuBar);
        setSize(1024, 740);
        setVisible(true);
    }

    protected void exitMenuItemActionPerformed(ActionEvent evt) {
        System.exit(0);
    }
    @Override
    public void componentHidden(ComponentEvent arg0) {

    }

    @Override
    public void componentMoved(ComponentEvent e) {

    }

    @Override
    public void componentResized(ComponentEvent arg0) {

    }

    @Override
    public void componentShown(ComponentEvent arg0) {

    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        try
        {

            if(e.getSource()==hifi)
            {
                UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
                SwingUtilities.updateComponentTreeUI(getRootPane());
                UIManager.setLookAndFeel("com.jtattoo.plaf.hifi.HiFiLookAndFeel");
                enableTheme();
                hifi.setEnabled(false);
            }
            else if(e.getSource()==acryl)
            {
                UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
                SwingUtilities.updateComponentTreeUI(getRootPane());
                UIManager.setLookAndFeel("com.jtattoo.plaf.acryl.AcrylLookAndFeel");
                enableTheme();
                acryl.setEnabled(false);
            }
            else if(e.getSource()==aero)
            {
                UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
                SwingUtilities.updateComponentTreeUI(getRootPane());
                UIManager.setLookAndFeel("com.jtattoo.plaf.aero.AeroLookAndFeel");
                enableTheme();
                aero.setEnabled(false);
            }
            else if(e.getSource()==aluminium)
            {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                SwingUtilities.updateComponentTreeUI(getRootPane());
                UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");
                enableTheme();
                aluminium.setEnabled(false);
            }
            else if(e.getSource()==bernstein)
            {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                SwingUtilities.updateComponentTreeUI(getRootPane());
                UIManager.setLookAndFeel("com.jtattoo.plaf.bernstein.BernsteinLookAndFeel");
                enableTheme();
                bernstein.setEnabled(false);
            }
            else if(e.getSource()==fast)
            {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                SwingUtilities.updateComponentTreeUI(getRootPane());
                UIManager.setLookAndFeel("com.jtattoo.plaf.fast.FastLookAndFeel");
                enableTheme();
                fast.setEnabled(false);
            }
            else if(e.getSource()==graphite)
            {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                SwingUtilities.updateComponentTreeUI(getRootPane());
                UIManager.setLookAndFeel("com.jtattoo.plaf.graphite.GraphiteLookAndFeel");
                enableTheme();
                graphite.setEnabled(false);
            }
            else if(e.getSource()==luna)
            {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                SwingUtilities.updateComponentTreeUI(getRootPane());
                UIManager.setLookAndFeel("com.jtattoo.plaf.luna.LunaLookAndFeel");
                enableTheme();
                luna.setEnabled(false);
            }
            else if(e.getSource()==mcwin)
            {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                SwingUtilities.updateComponentTreeUI(getRootPane());
                UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
                enableTheme();
                mcwin.setEnabled(false);
            }

            else if(e.getSource()==noire)
            {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                SwingUtilities.updateComponentTreeUI(getRootPane());
                UIManager.setLookAndFeel("com.jtattoo.plaf.noire.NoireLookAndFeel");
                enableTheme();
                noire.setEnabled(false);
            }
            else if(e.getSource()==smart)
            {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                SwingUtilities.updateComponentTreeUI(getRootPane());
                UIManager.setLookAndFeel("com.jtattoo.plaf.smart.SmartLookAndFeel");
                enableTheme();
                smart.setEnabled(false);
            }
            else if(e.getSource()==material)
            {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                SwingUtilities.updateComponentTreeUI(getRootPane());
                UIManager.setLookAndFeel(MaterialLookAndFeel.class.getCanonicalName());
                enableTheme();
                material.setEnabled(false);
            }
            SwingUtilities.updateComponentTreeUI(getRootPane());
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }
    private void enableTheme()
    {
        acryl.setEnabled(true);
        hifi.setEnabled(true);
        aero.setEnabled(true);
        aluminium.setEnabled(true);
        bernstein.setEnabled(true);
        fast.setEnabled(true);
        graphite.setEnabled(true);
        luna.setEnabled(true);
        mcwin.setEnabled(true);
        noire.setEnabled(true);
        smart.setEnabled(true);
        material.setEnabled(true);
    }

    public static void main(String []ar)
    {
        try
        {
            UIManager.setLookAndFeel("com.jtattoo.plaf.acryl.AcrylLookAndFeel");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        new SwitchThemeDemo();
    }
}