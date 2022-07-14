package pl.myproject.Exceptions;

import org.springframework.http.HttpStatus;

public class FamilyDataValidationException extends HttpException{

    public FamilyDataValidationException() {
        super(HttpStatus.BAD_REQUEST,"Provided family data does not match!");
    }


}
