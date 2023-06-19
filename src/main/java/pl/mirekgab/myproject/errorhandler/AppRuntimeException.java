package pl.mirekgab.myproject.errorhandler;

public class AppRuntimeException extends RuntimeException {

    public AppRuntimeException(String message) {
        super(message);
    }
}
