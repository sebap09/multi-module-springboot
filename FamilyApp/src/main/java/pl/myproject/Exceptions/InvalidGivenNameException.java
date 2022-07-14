package pl.myproject.Exceptions;

import org.springframework.http.HttpStatus;

public class InvalidGivenNameException extends HttpException {
    public InvalidGivenNameException() {
        super(HttpStatus.BAD_REQUEST,"Given name cannot be null nor empty!");
    }


}
