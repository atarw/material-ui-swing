package mdlaf.themes.exceptions;

/**
 * @author https://github.com/vincenzopalazzo
 */
public class MaterialChangeThemeException extends RuntimeException{

    public MaterialChangeThemeException() {
        super();
    }

    public MaterialChangeThemeException(String message) {
        super(message);
    }

    public MaterialChangeThemeException(String message, Throwable cause) {
        super(message, cause);
    }

    public MaterialChangeThemeException(Throwable cause) {
        super(cause);
    }

    protected MaterialChangeThemeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
