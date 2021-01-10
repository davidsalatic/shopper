package com.shopper.auth.service;

import com.shopper.auth.dto.RegistrationDto;
import com.shopper.user.dto.UserDto;
import com.shopper.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserService userService;

    @Override
    public UserDto register(RegistrationDto registrationDto) {
        return userService.createUser(registrationDto);
    }
}
