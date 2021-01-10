package com.shopper.util;

import com.shopper.util.validator.PasswordFormatValidator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
public class PasswordFormatValidatorTests {

    @InjectMocks
    private PasswordFormatValidator passwordFormatValidator;

    @Test
    public void isValid_no_digit_return_false() {
        assertFalse(passwordFormatValidator.isValid("Password", null));
    }

    @Test
    public void isValid_no_lower_case_return_false() {
        assertFalse(passwordFormatValidator.isValid("PASSWORD12", null));
    }

    @Test
    public void isValid_no_upper_case_return_false() {
        assertFalse(passwordFormatValidator.isValid("password12", null));
    }

    @Test
    public void isValid_too_short_return_false() {
        assertFalse(passwordFormatValidator.isValid("Pass12", null));
    }

    @Test
    public void isValid_valid_format_return_true() {
        assertTrue(passwordFormatValidator.isValid("Password12", null));
    }
}
