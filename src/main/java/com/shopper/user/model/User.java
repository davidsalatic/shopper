package com.shopper.user.model;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import static com.shopper.util.idgenerator.IdGenerator.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "app_user")
public class User {

    @Id
    @GeneratedValue(generator = ID_GENERATOR)
    @GenericGenerator(name = ID_GENERATOR, strategy = "com.shopper.util.idgenerator.IdGenerator")
    private String id;

    private String email;
    private String password;
}
