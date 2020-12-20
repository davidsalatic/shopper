package com.shopper.shopper.controller;

import com.shopper.shopper.dto.ShopperDto;
import com.shopper.shopper.service.ShopperService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/secured/shoppers")
@RequiredArgsConstructor
public class ShopperController {

    private final ShopperService shopperService;

    @GetMapping("/{id}")
    public ShopperDto getById(@PathVariable String id) {
        return shopperService.getById(id);
    }
}
