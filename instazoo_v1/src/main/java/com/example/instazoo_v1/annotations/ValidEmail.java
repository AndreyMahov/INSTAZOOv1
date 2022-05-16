package com.example.instazoo_v1.annotations;

import com.example.instazoo_v1.validators.EmailValidator;

import javax.validation.Constraint;
import java.lang.annotation.*;
import javax.validation.Payload;

@Target({ElementType.TYPE,ElementType.FIELD,ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = EmailValidator.class)
@Documented
public @interface ValidEmail {
    String message() default "Invalid email";

    Class<?>[] groups() default{};

    Class<? extends Payload>[] payload() default{};
}
