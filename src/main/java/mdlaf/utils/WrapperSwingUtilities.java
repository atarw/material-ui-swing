package mdlaf.utils;

import javax.swing.*;
import java.awt.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class WrapperSwingUtilities {

    private static WrapperSwingUtilities SINGLETON;

    public static WrapperSwingUtilities getInstance() {
        if (SINGLETON == null) {
            SINGLETON = new WrapperSwingUtilities();
        }
        return SINGLETON;
    }

    protected Class wrapperClass;
    protected Method getClippedString;

    private WrapperSwingUtilities() {
        this.initMethodWithJavaVersion();
    }

    public void initMethodWithJavaVersion() {
        try {
            if (Utils.isJavaVersionUnderJava9()) {
                //I can load the method in Swing sun.swing.SwingUtilities2
                this.wrapperClass = Class.forName("sun.swing.SwingUtilities2");
                getClippedString = this.wrapperClass.getMethod("clipStringIfNecessary",
                               new Class[]{ JComponent.class, FontMetrics.class, String.class, int.class});
            }else{
                //I can load method from class javax.swing.plaf.basic.BasicGraphicsUtils
                this.wrapperClass = Class.forName("javax.swing.plaf.basic.BasicGraphicsUtils");
                getClippedString = this.wrapperClass.getMethod("getClippedString",
                        new Class[]{ JComponent.class, FontMetrics.class, String.class, int.class});
            }
        } catch (ClassNotFoundException | NoSuchMethodException e) {
            e.printStackTrace();
            throw new IllegalArgumentException(e.getCause());
        }
    }

    public String getClippedString(JComponent component, FontMetrics fontMetrics, String text, int availTextWidth){
        try {
            return (String) getClippedString.invoke(wrapperClass, component, fontMetrics, text, availTextWidth);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
            throw new IllegalArgumentException(e.getCause());
        }
    }

}
