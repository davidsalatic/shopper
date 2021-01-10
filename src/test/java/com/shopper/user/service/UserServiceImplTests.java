package com.shopper.user.service;

import com.shopper.auth.dto.RegistrationDto;
import com.shopper.user.dto.UserDto;
import com.shopper.user.model.User;
import com.shopper.user.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
public class UserServiceImplTests {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userService;

    private final String USER_ID = "user-id";
    private final String EMAIL = "john.doe@mail.com";

    @Test(expected = EntityNotFoundException.class)
    public void getById_non_existing_entity_for_id_throw_exception() {
        when(userRepository.findById(USER_ID)).thenReturn(Optional.empty());

        userService.getById(USER_ID);

        verify(userRepository).findById(USER_ID);
    }

    @Test
    public void getById_correct_id_return_converted_entity() {
        User user = new User();
        user.setId(USER_ID);
        user.setEmail(EMAIL);

        when(userRepository.findById(USER_ID)).thenReturn(Optional.of(user));

        UserDto userDto = userService.getById(USER_ID);

        assertEquals(userDto.getId(), user.getId());
        assertEquals(userDto.getEmail(), user.getEmail());
        verify(userRepository).findById(USER_ID);
    }

    @Test(expected = EntityExistsException.class)
    public void createUser_user_exists_throw_exception() {
        RegistrationDto registrationDto = new RegistrationDto();
        registrationDto.setEmail(EMAIL);

        when(userRepository.existsByEmail(registrationDto.getEmail())).thenReturn(true);

        userService.createUser(registrationDto);

        verify(userRepository, never()).save(any());
    }

    @Test
    public void createUser_email_does_not_exist_save_user() {
        RegistrationDto registrationDto = new RegistrationDto();
        registrationDto.setEmail(EMAIL);
        final String PASSWORD = "Password12";
        registrationDto.setPassword(PASSWORD);

        when(userRepository.existsByEmail(registrationDto.getEmail())).thenReturn(false);
        when(userRepository.save(any(User.class))).thenReturn(new User());

        userService.createUser(registrationDto);

        ArgumentCaptor<User> captor = ArgumentCaptor.forClass(User.class);
        verify(userRepository).save(captor.capture());

        User capturedUser = captor.getValue();
        assertEquals(registrationDto.getEmail(), capturedUser.getEmail());
        assertEquals(registrationDto.getPassword(), capturedUser.getPassword());
    }
}
