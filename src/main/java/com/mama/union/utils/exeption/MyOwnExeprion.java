package com.mama.union.utils.exeption;

import lombok.Data;
import org.springframework.validation.ObjectError;

import java.util.List;

@Data
public class MyOwnExeprion extends RuntimeException{

    private final List<ObjectError> errorsList;

    public MyOwnExeprion(List<ObjectError> errors){
        this.errorsList = errors;
    }

}
