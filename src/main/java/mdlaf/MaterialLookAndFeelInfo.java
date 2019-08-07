package mdlaf;

import javax.swing.*;

/**
 * @author https://github.com/vincenzopalazzo
 */
public class MaterialLookAndFeelInfo extends UIManager.LookAndFeelInfo {

    public MaterialLookAndFeelInfo(String name, String className) {
        super(name, className);
    }

    @Override
    public String toString() {
        return getName() + ": " + getClassName();
    }
}
