package pl.myproject.Exceptions;

import org.springframework.http.HttpStatus;

public class InvalidAgeException extends HttpException {

    public InvalidAgeException() {
        super(HttpStatus.BAD_REQUEST,"Age cannot be null nor negative value!");
    }


}
