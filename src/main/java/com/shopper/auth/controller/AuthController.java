package com.shopper.auth.controller;

import com.shopper.auth.dto.RegistrationDto;
import com.shopper.auth.service.AuthService;
import com.shopper.shopper.dto.ShopperDto;
import com.shopper.shopper.service.ShopperService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/public/auth")
@RequiredArgsConstructor
public class AuthController {

    private final ShopperService shopperService;

    @PostMapping("/register")
    public ShopperDto register(@Valid @RequestBody RegistrationDto registrationDto) {
        return shopperService.createUser(registrationDto);
    }
}
