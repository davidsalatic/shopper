package com.shopper.auth.service;

import com.shopper.auth.dto.RegistrationDto;
import com.shopper.user.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
public class AuthServiceImplTests {

    @Mock
    private UserService userService;

    @InjectMocks
    private AuthServiceImpl authService;

    @Test
    public void register() {
        final String EMAIL = "john.doe@mail.com";
        final String PASSWORD = "Password12";
        RegistrationDto registrationDto = new RegistrationDto();
        registrationDto.setEmail(EMAIL);
        registrationDto.setPassword(PASSWORD);

        authService.register(registrationDto);

        verify(userService).createUser(registrationDto);
    }
}
