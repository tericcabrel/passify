package com.tericcabrel.passify.constraints;

import com.tericcabrel.passify.constraints.validators.CardNumberValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.ElementType.TYPE_USE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({ FIELD, METHOD, PARAMETER, ANNOTATION_TYPE, TYPE_USE })
@Retention(RUNTIME)
@Constraint(validatedBy = CardNumberValidator.class)
@Documented
@Repeatable(CardNumber.List.class)
public @interface CardNumber {

    String message() default "{com.tericcabrel.passify.constraints.CardNumber.message}";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };

    String value();

    @Target({ FIELD, METHOD, PARAMETER, ANNOTATION_TYPE })
    @Retention(RUNTIME)
    @Documented
    @interface List {
        CardNumber[] value();
    }
}