package com.shopper.auth.service;

import com.shopper.auth.dto.RegistrationDto;
import com.shopper.exception.InvalidEmailFormatException;
import com.shopper.exception.InvalidPasswordFormatException;
import com.shopper.shopper.dto.ShopperDto;
import com.shopper.util.validator.EmailFormatValidator;
import com.shopper.util.validator.PasswordFormatValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
@RequiredArgsConstructor
public class AuthValidationService implements AuthService {

    private final AuthService authServiceImpl;

    @Override
    public ShopperDto register(RegistrationDto registrationDto) {
        validateEmailFormat(registrationDto.getEmail());
        validatePasswordFormat(registrationDto.getPassword());
        return authServiceImpl.register(registrationDto);
    }

    private void validateEmailFormat(String email) {
        if (!EmailFormatValidator.isValidFormat(email)) {
            throw new InvalidEmailFormatException(email);
        }
    }

    private void validatePasswordFormat(String password) {
        if (!PasswordFormatValidator.isValidFormat(password)) {
            throw new InvalidPasswordFormatException(password);
        }
    }
}
