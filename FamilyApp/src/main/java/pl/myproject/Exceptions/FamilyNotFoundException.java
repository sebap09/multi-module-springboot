package pl.myproject.Exceptions;

import org.springframework.http.HttpStatus;

public class FamilyNotFoundException extends HttpException{
    public FamilyNotFoundException() {
        super(HttpStatus.NOT_FOUND, "There is no family with given id");
    }
}
