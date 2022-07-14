package pl.myproject.Exceptions;

import org.springframework.http.HttpStatus;

public class InvalidMemberFamilyNameException extends HttpException {
    public InvalidMemberFamilyNameException() {
        super(HttpStatus.BAD_REQUEST,"Member family name cannot be null nor empty!");
    }


}
