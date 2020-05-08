package mdlaf.utils;

public class Utils {

    public static boolean isJavaVersionUnderJava9(){
        return System.getProperty("java.version").startsWith("1.");
    }

    private Utils(){}
}
