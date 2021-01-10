package com.shopper.shopper.service;

import com.shopper.auth.dto.RegistrationDto;
import com.shopper.shopper.dto.ShopperDto;
import com.shopper.shopper.model.Shopper;
import com.shopper.shopper.repository.ShopperRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;

@Service
@RequiredArgsConstructor
public class ShopperServiceImpl implements ShopperService {

    private final ShopperRepository shopperRepository;

    @Override
    public ShopperDto getById(String id) {
        Shopper shopper = shopperRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        return convertToDto(shopper);
    }

    @Override
    public ShopperDto createUser(RegistrationDto registrationDto) {
        boolean emailExists = shopperRepository.existsByEmail(registrationDto.getEmail());
        if (emailExists) {
            throw new EntityExistsException();
        }
        Shopper savedShopper = shopperRepository.save(Shopper.builder()
                .email(registrationDto.getEmail())
                .password(registrationDto.getPassword()) // TODO encrypt password
                .build());
        return convertToDto(savedShopper);
    }

    private ShopperDto convertToDto(Shopper shopper) {
        return ShopperDto.builder()
                .id(shopper.getId())
                .firstName(shopper.getFirstName())
                .lastName(shopper.getLastName())
                .email(shopper.getEmail())
                .build();
    }
}
