package com.mama.union.utils.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;

@Target({METHOD, FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = EducationValidation.class)
@Documented
public @interface Education {

    String message() default "{com.mama.union.utils.validation.educations.message}";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
