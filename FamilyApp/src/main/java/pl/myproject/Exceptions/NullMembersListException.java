package pl.myproject.Exceptions;

import org.springframework.http.HttpStatus;

public class NullMembersListException extends HttpException {
    public NullMembersListException() {
        super(HttpStatus.BAD_REQUEST,"Family members list cannot be null!");
    }


}
