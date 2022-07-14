package pl.myproject.Exceptions;

import org.springframework.http.HttpStatus;

public class InvalidFamilyNameException extends HttpException {
    public InvalidFamilyNameException() {
        super(HttpStatus.BAD_REQUEST,"Family name cannot be null nor empty!");
    }


}
