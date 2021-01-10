package com.shopper.util;

import com.shopper.util.validator.EmailFormatValidator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
public class EmailFormatValidatorTests {

    @InjectMocks
    private EmailFormatValidator emailFormatValidator;

    @Test
    public void isValid_no_domain_return_false() {
        assertFalse(emailFormatValidator.isValid("email", null));
    }

    @Test
    public void isValid_no_monkey_character_return_false() {
        assertFalse(emailFormatValidator.isValid("email.domain.com", null));
    }

    @Test
    public void isValid_missing_atom_return_false() {
        assertFalse(emailFormatValidator.isValid("@domain.com", null));
    }

    @Test
    public void isValid_garbage_text_return_false() {
        assertFalse(emailFormatValidator.isValid("#@%^%#$@#$@#.com", null));
    }

    @Test
    public void isValid_pasted_from_address_book_return_false() {
        assertFalse(emailFormatValidator.isValid("John Doe <email@domain.com>", null));
    }

    @Test
    public void isValid_double_monkey_character_return_false() {
        assertFalse(emailFormatValidator.isValid("email@domain@domain.com", null));
    }

    @Test
    public void isValid_leading_dot_in_atom_return_false() {
        assertFalse(emailFormatValidator.isValid(".email@domain.com", null));
    }

    @Test
    public void isValid_trailing_dot_in_atom_return_false() {
        assertFalse(emailFormatValidator.isValid("email.@domain.com", null));
    }

    @Test
    public void isValid_multiple_dots_in_atom_return_false() {
        assertFalse(emailFormatValidator.isValid("email..email@domain.com", null));
    }

    @Test
    public void isValid_unicode_characters_in_atom_return_false() {
        assertFalse(emailFormatValidator.isValid("あいうえお@domain.com", null));
    }

    @Test
    public void isValid_leading_dot_in_domain_return_false() {
        assertFalse(emailFormatValidator.isValid("email@.domain.com", null));
    }

    @Test
    public void isValid_invalid_ip_format_return_false() {
        assertFalse(emailFormatValidator.isValid("email@111.222.333.44444", null));
    }

    @Test
    public void isValid_multiple_dots_in_domain_return_false() {
        assertFalse(emailFormatValidator.isValid("email@domain..com", null));
    }

    @Test
    public void isValid_valid_email_return_true() {
        assertTrue(emailFormatValidator.isValid("email@domain.com", null));
    }
}
