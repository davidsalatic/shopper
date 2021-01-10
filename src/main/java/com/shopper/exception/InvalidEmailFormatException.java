package com.shopper.exception;

import lombok.Getter;

@Getter
public class InvalidEmailFormatException extends RuntimeException {

    private final String email;

    public InvalidEmailFormatException(String email) {
        super();
        this.email = email;
    }
}
