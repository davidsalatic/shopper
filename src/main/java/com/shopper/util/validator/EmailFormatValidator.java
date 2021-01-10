package com.shopper.util.validator;

import org.apache.commons.validator.EmailValidator;

public class EmailFormatValidator {

    public static boolean isValidFormat(String email) {
        return EmailValidator.getInstance().isValid(email);
    }
}
