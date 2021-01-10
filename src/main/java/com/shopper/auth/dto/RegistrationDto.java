package com.shopper.auth.dto;

import com.shopper.util.validator.Email;
import com.shopper.util.validator.Password;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class RegistrationDto {
    @NotBlank
    @Email
    private String email;
    @NotBlank
    @Password
    private String password;
}
