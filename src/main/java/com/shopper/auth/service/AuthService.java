package com.shopper.auth.service;

import com.shopper.auth.dto.RegistrationDto;
import com.shopper.user.dto.UserDto;

public interface AuthService {
    UserDto register(RegistrationDto registrationDto);
}
