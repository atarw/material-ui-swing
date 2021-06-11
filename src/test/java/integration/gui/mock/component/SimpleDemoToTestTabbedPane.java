package integration.gui.mock.component;

import java.awt.*;
import javax.swing.*;
import mdlaf.MaterialLookAndFeel;

public class SimpleDemoToTestTabbedPane extends JFrame {

  static {
    try {
      UIManager.setLookAndFeel(new MaterialLookAndFeel());
      UIManager.put("TabbedPane[MouseHover].enable", false);
    } catch (UnsupportedLookAndFeelException e) {
      e.printStackTrace();
    }
  }

  private DemoPanelWithTabbedPane demoPanelTabbedPane = new DemoPanelWithTabbedPane();

  public void init() {
    setLayout(new BorderLayout());
    add(demoPanelTabbedPane, BorderLayout.CENTER);

    setSize(new Dimension(600, 400));
    setLocationRelativeTo(null);
    setVisible(true);

    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }

  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          @Override
          public void run() {
            SimpleDemoToTestTabbedPane demo = new SimpleDemoToTestTabbedPane();
            demo.init();
          }
        });
  }
}
