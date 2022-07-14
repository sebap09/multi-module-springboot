package pl.myproject.Exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerAdvice extends ResponseEntityExceptionHandler{

    @ExceptionHandler(value
            = { NoSuchFamilyIdException.class})
    public ResponseEntity<?> handleHttpExceptions(HttpException ex) {
        // log exception
        return ResponseEntity
                .status(ex.getHttpStatus())
                .body(ex.getMessage());
    }

}
