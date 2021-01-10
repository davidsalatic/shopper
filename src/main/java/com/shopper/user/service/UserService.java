package com.shopper.user.service;

import com.shopper.auth.dto.RegistrationDto;
import com.shopper.user.dto.UserDto;

public interface UserService {

    UserDto getById(String id);

    UserDto createUser(RegistrationDto registrationDto);
}
