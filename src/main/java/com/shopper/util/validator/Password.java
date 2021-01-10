package com.shopper.util.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Documented
@Constraint(validatedBy = PasswordFormatValidator.class)
@Retention(RetentionPolicy.RUNTIME)
public @interface Password {
    String message() default "Weak password format";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
