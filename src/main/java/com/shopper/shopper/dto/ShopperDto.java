package com.shopper.shopper.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ShopperDto {

    private String id;
    private String firstName;
    private String lastName;
    private String email;
}
