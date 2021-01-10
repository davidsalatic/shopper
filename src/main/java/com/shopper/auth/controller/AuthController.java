package com.shopper.auth.controller;

import com.shopper.auth.dto.RegistrationDto;
import com.shopper.auth.service.AuthService;
import com.shopper.shopper.dto.ShopperDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/public/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public ShopperDto register(@Valid @RequestBody RegistrationDto registrationDto) {
        return authService.register(registrationDto);
    }
}
