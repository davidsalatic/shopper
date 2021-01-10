package com.shopper.shopper.model;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import static com.shopper.util.idgenerator.IdGenerator.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Shopper {

    @Id
    @GeneratedValue(generator = ID_GENERATOR)
    @GenericGenerator(name = ID_GENERATOR, strategy = "com.shopper.util.idgenerator.IdGenerator")
    private String id;

    private String firstName;
    private String lastName;
    private String email;
    private String password;
}
