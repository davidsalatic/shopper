package com.shopper.exception;

import lombok.Getter;

@Getter
public class InvalidPasswordFormatException extends RuntimeException {

    private final String password;

    public InvalidPasswordFormatException(String password) {
        super();
        this.password = password;
    }
}
