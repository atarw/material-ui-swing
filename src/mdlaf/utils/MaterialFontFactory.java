package mdlaf.utils;

import sun.awt.OSInfo;

import java.util.Properties;

/**
 * @author https://github.com/vincenzopalazzo
 */
public class MaterialFontFactory {

    private static final String[] SISTEM_SUPPORTED = {"linux", "windows", "osx"};

    private static MaterialFontFactory SINGLETON;

    public static MaterialFontFactory getIstance(){
        if(SINGLETON == null){
            SINGLETON = new MaterialFontFactory();
        }
        return SINGLETON;
    }

    private Properties properties;

    private MaterialFontFactory(){
        loadOsPropries();
    }

    private void loadOsPropries(){
        String os = System.getProperty("os.name", "generic").toLowerCase();
        String pathProperties = "/resources/config/font-" + os + ".properties";
        if(isOsSupportted(os)){
            //TODO load specific os
            return;
        }
        //TODO load file default
    }

    private boolean isOsSupportted(String os) {
        for (int i = 0; i < SISTEM_SUPPORTED.length; i++){
            if (os.equals(SISTEM_SUPPORTED[i])){
                return true;
            }
        }
        return false;
    }
}
