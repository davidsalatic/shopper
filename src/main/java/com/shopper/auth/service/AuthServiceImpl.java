package com.shopper.auth.service;

import com.shopper.auth.dto.RegistrationDto;
import com.shopper.shopper.dto.ShopperDto;
import com.shopper.shopper.service.ShopperService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final ShopperService shopperService;

    @Override
    public ShopperDto register(RegistrationDto registrationDto) {
        return shopperService.createUser(registrationDto);
    }
}
