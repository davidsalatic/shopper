package com.shopper.shopper.service;

import com.shopper.shopper.dto.ShopperDto;
import com.shopper.shopper.model.Shopper;
import com.shopper.shopper.repository.ShopperRepository;
import com.shopper.shopper.service.ShopperServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
public class ShopperServiceImplTests {

    @Mock
    private ShopperRepository shopperRepository;

    @InjectMocks
    private ShopperServiceImpl shopperService;

    private final String SHOPPER_ID = "shopper_id";
    private final String FIRST_NAME = "John";
    private final String LAST_NAME = "Doe";

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

        when(shopperRepository.findById(SHOPPER_ID)).thenReturn(Optional.of(shopper));

        ShopperDto shopperDto = shopperService.getById(SHOPPER_ID);

        assertEquals(shopperDto.getId(), shopper.getId());
        assertEquals(shopperDto.getFirstName(), shopper.getFirstName());
        assertEquals(shopperDto.getLastName(), shopper.getLastName());
        verify(shopperRepository).findById(SHOPPER_ID);
    }
}
