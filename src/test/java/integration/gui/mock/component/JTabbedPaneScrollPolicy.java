package integration.gui.mock.component;

import java.awt.*;
import javax.swing.*;
import mdlaf.MaterialLookAndFeel;
import mdlaf.themes.JMarsDarkTheme;

public class JTabbedPaneScrollPolicy {

  static {
    try {
      UIManager.setLookAndFeel(new MaterialLookAndFeel(new JMarsDarkTheme()));
    } catch (UnsupportedLookAndFeelException e) {
      e.printStackTrace();
    }
  }

  static void add(JTabbedPane tabbedPane, String label) {
    JButton button = new JButton(label);
    tabbedPane.addTab(label, button);
  }

  public static void main(String args[]) {
    JFrame frame = new JFrame("Tabbed Pane Sample");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    JTabbedPane tabbedPane = new JTabbedPane();
    tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
    String titles[] = {"General", "Security", "Content", "Connection", "Programs", "Advanced"};
    for (int i = 0, n = titles.length; i < n; i++) {
      add(tabbedPane, titles[i]);
    }

    frame.add(tabbedPane, BorderLayout.CENTER);
    frame.setSize(400, 150);
    frame.setVisible(true);
  }
}
