package regression.mdlaf.utils;

import mdlaf.utils.MaterialImageFactory;
import mdlaf.utils.MaterialImageType;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.*;

/**
 * @author https://github.com/vincenzopalazzo
 */
public class MaterialImageFactoryTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(MaterialImageFactoryTest.class);

    @Before
    public void init(){}

    @Test
    public void testResourcesSvgNotNull(){
        InputStream inputStream = MaterialImageFactory.getInstance().getResourcesImage(MaterialImageFactory.UNCHECKED_BLACK_BOX, MaterialImageType.SVG);
        Assert.assertNotNull(inputStream);
    }

    @Test
    public void testResourcesPngNotNull() throws Exception{
        InputStream inputStream = MaterialImageFactory.getInstance().getResourcesImage(MaterialImageFactory.UNCHECKED_BLACK_BOX, MaterialImageType.PNG);
        Icon icon = new ImageIcon(ImageIO.read(inputStream));
        Assert.assertNotNull(inputStream);
        Assert.assertNotNull(icon);
    }

    @Test
    public void testResourcesSvgNull() throws Exception{
        InputStream inputStream = MaterialImageFactory.getInstance().getResourcesImage(MaterialImageFactory.RADIO_BUTTON_WHITE_OFF, MaterialImageType.SVG);
        Assert.assertNull(inputStream);
    }

    @Test
    public void testResourcesIconNotNull() throws Exception{
        Icon icon = new ImageIcon(MaterialImageFactory.getInstance().getImage(MaterialImageFactory.RADIO_BUTTON_WHITE_OFF));
        Assert.assertNotNull(icon);
    }
}
