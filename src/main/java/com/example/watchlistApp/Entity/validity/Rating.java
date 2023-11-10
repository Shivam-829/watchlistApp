package com.example.watchlistApp.Entity.validity;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = RatingAnnotationLogic.class)
public @interface Rating {
    String message() default "Please enter value b/w 5 and 10";

    Class<?>[]groups() default {};
    Class<? extends Payload>[] payload() default {};
}


