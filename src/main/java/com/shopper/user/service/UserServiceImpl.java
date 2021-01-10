package com.shopper.user.service;

import com.shopper.auth.dto.RegistrationDto;
import com.shopper.user.dto.UserDto;
import com.shopper.user.model.User;
import com.shopper.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public UserDto getById(String id) {
        User user = userRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        return convertToDto(user);
    }

    @Override
    public UserDto createUser(RegistrationDto registrationDto) {
        boolean emailExists = userRepository.existsByEmail(registrationDto.getEmail());
        if (emailExists) {
            throw new EntityExistsException();
        }
        User savedUser = userRepository.save(User.builder()
                .email(registrationDto.getEmail())
                .password(registrationDto.getPassword()) // TODO encrypt password
                .build());
        return convertToDto(savedUser);
    }

    private UserDto convertToDto(User user) {
        return UserDto.builder()
                .id(user.getId())
                .email(user.getEmail())
                .build();
    }
}
