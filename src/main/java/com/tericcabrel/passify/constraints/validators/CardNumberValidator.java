package com.tericcabrel.passify.constraints.validators;

import com.tericcabrel.passify.constraints.CardNumber;
import com.tericcabrel.passify.utils.LuhnAlgorithm;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CardNumberValidator implements ConstraintValidator<CardNumber, String> {
    private String cardNumberType;

    @Override
    public void initialize(CardNumber constraintAnnotation) {
        this.cardNumberType = constraintAnnotation.value();
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        boolean isValid = LuhnAlgorithm.check(s) && cardNumberType.equals("VISA");

        // Override the default message
        // Eg: If i want to return a message based on the user language
        /* if ( !isValid ) {
            constraintValidatorContext.disableDefaultConstraintViolation();
            constraintValidatorContext.buildConstraintViolationWithTemplate(
                    "{com.tericcabrel.passify.constraints.CardNumber.message}"
            ).addConstraintViolation();
        }*/

        return isValid;
    }
}
