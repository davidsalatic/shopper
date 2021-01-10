package com.shopper.auth.service;

import com.shopper.auth.dto.RegistrationDto;
import com.shopper.shopper.dto.ShopperDto;

public interface AuthService {
    ShopperDto register(RegistrationDto registrationDto);
}
