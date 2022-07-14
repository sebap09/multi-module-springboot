package pl.myproject.Exceptions;

import org.springframework.http.HttpStatus;

public class NoSuchFamilyIdException extends HttpException{
    public NoSuchFamilyIdException() {
        super(HttpStatus.BAD_REQUEST, "There is no such family id!");
    }
}
