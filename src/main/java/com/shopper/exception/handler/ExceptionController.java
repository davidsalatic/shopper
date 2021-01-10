package com.shopper.exception.handler;

import com.shopper.exception.InvalidEmailFormatException;
import com.shopper.exception.InvalidPasswordFormatException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;

import static org.springframework.http.HttpStatus.*;

@RestControllerAdvice
@Slf4j
public class ExceptionController {

    @ResponseStatus(NOT_FOUND)
    @ExceptionHandler(EntityNotFoundException.class)
    public String handleEntityNotFoundException(EntityNotFoundException exception) {
        return "Entity not found";
    }

    @ResponseStatus(BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public String handleMethodArgumentNotValidException(MethodArgumentNotValidException exception) {
        log.error(exception.getMessage());
        return "Invalid arguments";
    }

    @ResponseStatus(BAD_REQUEST)
    @ExceptionHandler(InvalidEmailFormatException.class)
    public String handleInvalidEmailFormatException(InvalidEmailFormatException exception) {
        log.error("Invalid email format '{}'", exception.getEmail());
        return "Invalid email format";
    }

    @ResponseStatus(BAD_REQUEST)
    @ExceptionHandler(InvalidPasswordFormatException.class)
    public String handleInvalidPasswordFormatException(InvalidPasswordFormatException exception) {
        log.error("Invalid password format '{}'", exception.getPassword());
        return "Invalid password format";
    }

    @ResponseStatus(CONFLICT)
    @ExceptionHandler(EntityExistsException.class)
    public String handleEntityExistsException(EntityExistsException exception) {
        return "Entity already exists";
    }
}
