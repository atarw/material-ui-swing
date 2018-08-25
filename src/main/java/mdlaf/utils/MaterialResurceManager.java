package main.java.mdlaf.utils;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * @author https://github.com/vincenzopalazzo
 */
public class MaterialResurceManager {

    private ResourceBundle resourceBundle;

    public void init(){
       // resourceBundle = ResourceBundle.getBundle("main.resources.fontsproperties.fonts", new Locale("ar", "MA")); //test
        resourceBundle = ResourceBundle.getBundle("main.resources.fontsproperties.fonts", Locale.getDefault());
    }

    public String getStringResource(String key) {
        return this.resourceBundle.getString(key);
    }
}
