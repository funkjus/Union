package com.mama.union.utils.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;
import java.util.List;

public class EducationValidation implements ConstraintValidator<Education, String> {

    List<String> educations  = Arrays.asList("Высшее", "Среднее", "Низшее");

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return educations.contains(value);
    }
}
