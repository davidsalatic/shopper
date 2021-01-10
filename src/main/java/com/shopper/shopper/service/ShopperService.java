package com.shopper.shopper.service;

import com.shopper.auth.dto.RegistrationDto;
import com.shopper.shopper.dto.ShopperDto;

public interface ShopperService {

    ShopperDto getById(String id);

    ShopperDto createUser(RegistrationDto registrationDto);
}
