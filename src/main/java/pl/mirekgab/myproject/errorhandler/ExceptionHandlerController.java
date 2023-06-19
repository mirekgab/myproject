package pl.mirekgab.myproject.errorhandler;

import lombok.extern.java.Log;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Log
public class ExceptionHandlerController {

    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String handleRuntimeException(final RuntimeException ex) {
        log.info("myproject: "+ex.getMessage());
        return ex.getMessage();
    }
    @ExceptionHandler(AppRuntimeException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleAppRuntimeException(final RuntimeException ex) {
        log.info("myproject: "+ex.getMessage());
        return ex.getMessage();
    }

}
