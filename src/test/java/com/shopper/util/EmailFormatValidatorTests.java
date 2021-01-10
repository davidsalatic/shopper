package com.shopper.util;

import com.shopper.util.validator.EmailFormatValidator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
public class EmailFormatValidatorTests {

    @Test
    public void isValid_no_domain_return_false() {
        assertFalse(EmailFormatValidator.isValidFormat("email"));
    }

    @Test
    public void isValid_no_monkey_character_return_false() {
        assertFalse(EmailFormatValidator.isValidFormat("email.domain.com"));
    }

    @Test
    public void isValid_missing_atom_return_false() {
        assertFalse(EmailFormatValidator.isValidFormat("@domain.com"));
    }

    @Test
    public void isValid_garbage_text_return_false() {
        assertFalse(EmailFormatValidator.isValidFormat("#@%^%#$@#$@#.com"));
    }

    @Test
    public void isValid_pasted_from_address_book_return_false() {
        assertFalse(EmailFormatValidator.isValidFormat("John Doe <email@domain.com>"));
    }

    @Test
    public void isValid_double_monkey_character_return_false() {
        assertFalse(EmailFormatValidator.isValidFormat("email@domain@domain.com"));
    }

    @Test
    public void isValid_leading_dot_in_atom_return_false() {
        assertFalse(EmailFormatValidator.isValidFormat(".email@domain.com"));
    }

    @Test
    public void isValid_trailing_dot_in_atom_return_false() {
        assertFalse(EmailFormatValidator.isValidFormat("email.@domain.com"));
    }

    @Test
    public void isValid_multiple_dots_in_atom_return_false() {
        assertFalse(EmailFormatValidator.isValidFormat("email..email@domain.com"));
    }

    @Test
    public void isValid_unicode_characters_in_atom_return_false() {
        assertFalse(EmailFormatValidator.isValidFormat("あいうえお@domain.com"));
    }

    @Test
    public void isValid_leading_dot_in_domain_return_false() {
        assertFalse(EmailFormatValidator.isValidFormat("email@.domain.com"));
    }

    @Test
    public void isValid_invalid_ip_format_return_false() {
        assertFalse(EmailFormatValidator.isValidFormat("email@111.222.333.44444"));
    }

    @Test
    public void isValid_multiple_dots_in_domain_return_false() {
        assertFalse(EmailFormatValidator.isValidFormat("email@domain..com"));
    }

    @Test
    public void isValid_valid_email_return_true() {
        assertTrue(EmailFormatValidator.isValidFormat("email@domain.com"));
    }
}
