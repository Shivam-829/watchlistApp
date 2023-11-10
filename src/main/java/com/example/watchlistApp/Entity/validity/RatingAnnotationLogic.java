package com.example.watchlistApp.Entity.validity;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

//import javax.validation.ConstraintValidator;
//import javax.validation.ConstraintValidatorContext;

public class RatingAnnotationLogic implements ConstraintValidator<Rating, Float>{

    @Override
    public boolean isValid(Float value, ConstraintValidatorContext context) {
        // TODO Auto-generated method stub
        return value > 5 && value <= 10;
    }

}
