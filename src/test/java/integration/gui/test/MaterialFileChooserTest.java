package integration.gui.test;

import org.assertj.swing.fixture.JFileChooserFixture;
import org.assertj.swing.fixture.JMenuItemFixture;
import org.assertj.swing.fixture.JTextComponentFixture;
import org.junit.Test;


/**
 * @author https://github.com/vincenzopalazzo
 */
public class MaterialFileChooserTest extends AbstractTestGUI{

//    @Test
    //TODO how work this?
    public void testShowSaveState(){
        JMenuItemFixture menuItem = frame.menuItem("menuItemJFileChooser");
        menuItem.click();
        JFileChooserFixture fileChooser = frame.fileChooser("fileChooserAction");
       // JTextComponentFixture text = fileChooser.fileNameTextBox();
        //text.click();
    }
}
