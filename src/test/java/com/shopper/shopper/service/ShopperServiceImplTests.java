package com.shopper.shopper.service;

import com.shopper.auth.dto.RegistrationDto;
import com.shopper.shopper.dto.ShopperDto;
import com.shopper.shopper.model.Shopper;
import com.shopper.shopper.repository.ShopperRepository;
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
public class ShopperServiceImplTests {

    @Mock
    private ShopperRepository shopperRepository;

    @InjectMocks
    private ShopperServiceImpl shopperService;

    private final String SHOPPER_ID = "shopper_id";
    private final String FIRST_NAME = "John";
    private final String LAST_NAME = "Doe";
    private final String EMAIL = "john.doe@mail.com";
    private final String PASSWORD = "Password12";

    @Test(expected = EntityNotFoundException.class)
    public void getById_non_existing_entity_for_id_throw_exception() {
        when(shopperRepository.findById(SHOPPER_ID)).thenReturn(Optional.empty());

        shopperService.getById(SHOPPER_ID);

        verify(shopperRepository).findById(SHOPPER_ID);
    }

    @Test
    public void getById_correct_id_return_converted_entity() {
        Shopper shopper = new Shopper();
        shopper.setId(SHOPPER_ID);
        shopper.setFirstName(FIRST_NAME);
        shopper.setLastName(LAST_NAME);
        shopper.setEmail(EMAIL);

        when(shopperRepository.findById(SHOPPER_ID)).thenReturn(Optional.of(shopper));

        ShopperDto shopperDto = shopperService.getById(SHOPPER_ID);

        assertEquals(shopperDto.getId(), shopper.getId());
        assertEquals(shopperDto.getFirstName(), shopper.getFirstName());
        assertEquals(shopperDto.getLastName(), shopper.getLastName());
        assertEquals(shopperDto.getEmail(), shopper.getEmail());
        verify(shopperRepository).findById(SHOPPER_ID);
    }

    @Test(expected = EntityExistsException.class)
    public void createUser_user_exists_throw_exception() {
        RegistrationDto registrationDto = new RegistrationDto();
        registrationDto.setEmail(EMAIL);

        when(shopperRepository.existsByEmail(registrationDto.getEmail())).thenReturn(true);

        shopperService.createUser(registrationDto);

        verify(shopperRepository, never()).save(any());
    }

    @Test
    public void createUser_email_does_not_exist_save_user() {
        RegistrationDto registrationDto = new RegistrationDto();
        registrationDto.setEmail(EMAIL);
        registrationDto.setPassword(PASSWORD);

        when(shopperRepository.existsByEmail(registrationDto.getEmail())).thenReturn(false);
        when(shopperRepository.save(any(Shopper.class))).thenReturn(new Shopper());

        shopperService.createUser(registrationDto);

        ArgumentCaptor<Shopper> captor = ArgumentCaptor.forClass(Shopper.class);
        verify(shopperRepository).save(captor.capture());

        Shopper capturedShopper = captor.getValue();
        assertEquals(registrationDto.getEmail(), capturedShopper.getEmail());
        assertEquals(registrationDto.getPassword(), capturedShopper.getPassword());
    }
}
