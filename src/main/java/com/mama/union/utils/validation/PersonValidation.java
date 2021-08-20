package com.mama.union.utils.validation;


import com.mama.union.entity.DAO.Person;
import com.mama.union.service.implementation.EducationClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;

@Component
public class PersonValidation implements org.springframework.validation.Validator {

    @Autowired
    private Validator validator;

    private final EducationClassService educationService;

    public PersonValidation(@Autowired EducationClassService educationService) {
        this.educationService = educationService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return Person.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Set<ConstraintViolation<Object>> validates = validator.validate(target);
        for(ConstraintViolation<Object> constraintViolation : validates){
            String propPath = constraintViolation.getPropertyPath().toString();
            String message = constraintViolation.getMessage();
            errors.rejectValue(propPath, "", message);
        }

        Person p = (Person) target;

        if (educationService.getEducation().get(p.getEducation()) == null) {
            errors.rejectValue("education", "Введенное значение - " + p.getEducation() + " поля ","Name must be" + educationService.getEducation().keySet().toString());
        }
    }
}
