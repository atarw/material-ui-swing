package integration.gui.mock.component;

import javax.swing.*;

public class ToolBarCompilerComponent extends JPanel {

  private JComboBox<String> compilerCommand =
      new JComboBox<>(
          new String[] {
            "JAVAC", "GRADLE", "Maven",
          });

  public ToolBarCompilerComponent() {
    initView();
  }

  private void initView() {
    initComponent();
  }

  private void initComponent() {
    super.add(compilerCommand);
  }
}
