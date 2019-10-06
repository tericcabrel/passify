package com.tericcabrel.passify.constraints.validators;

import com.tericcabrel.passify.constraints.CardExpiration;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class CardExpirationValidator implements ConstraintValidator<CardExpiration, String> {
    @Override
    public void initialize(CardExpiration constraintAnnotation) {

    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        boolean isValid = false;

        String[] array = s.split("-");

        if (array.length == 2 && array[0].length() == 2 && array[1].length() == 2) {
            String expireDateString = "01-" + array[0] + "-" + array[1];
            try {
                LocalDate expireDate = LocalDate.parse(expireDateString, DateTimeFormatter.ofPattern("dd-MM-yy"));
                LocalDate dateNow = LocalDate.now();

                isValid = expireDate.isAfter(dateNow);
            } catch (DateTimeParseException exception) {
                isValid  = false;
            }
        }

        // Override the default message
        // Eg: If i want to return a message based on the user language

        /*if ( !isValid ) {
            constraintValidatorContext.disableDefaultConstraintViolation();
            constraintValidatorContext.buildConstraintViolationWithTemplate(
                    "{com.tericcabrel.passify.constraints.CardExpiration.message}"
            ).addConstraintViolation();
        }*/

        return isValid;
    }
}
