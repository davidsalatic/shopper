package com.shopper.auth.service;

import com.shopper.auth.dto.RegistrationDto;
import com.shopper.exception.InvalidEmailFormatException;
import com.shopper.exception.InvalidPasswordFormatException;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

@RunWith(SpringRunner.class)
public class AuthValidationServiceTests {

    @Mock
    private AuthService authService;

    @InjectMocks
    private AuthValidationService authValidationService;

    @Test(expected = InvalidEmailFormatException.class)
    public void register_invalid_email_format_throw_exception() {
        final String INVALID_EMAIL = "email.domain";
        RegistrationDto registrationDto = new RegistrationDto();
        registrationDto.setEmail(INVALID_EMAIL);

        authValidationService.register(registrationDto);

        verify(authService, never()).register(any(RegistrationDto.class));
    }

    // TODO implement
    @Ignore
    @Test(expected = InvalidPasswordFormatException.class)
    public void register_invalid_password_format_throw_exception() {

    }

    // TODO implement
    @Ignore
    @Test
    public void register_valid_email_and_password_format_pass_validation() {

    }

}
