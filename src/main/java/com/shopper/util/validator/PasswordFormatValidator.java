package com.shopper.util.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordFormatValidator implements
        ConstraintValidator<Password, String> {

    private final Pattern PASSWORD_FORMAT_REGEX = Pattern.compile("^(?=.*\\d)(?=.*[^a-zA-Z])(?=.*[a-z])(?=.*[A-Z])\\S{8,}$");

    @Override
    public boolean isValid(String password, ConstraintValidatorContext constraintValidatorContext) {
        Matcher passwordMatcher = PASSWORD_FORMAT_REGEX.matcher(password);
        return passwordMatcher.matches();
    }
}
