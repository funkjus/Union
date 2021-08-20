package com.mama.union.utils.exeption;

import lombok.Getter;

@Getter
public class PersonNotFoundExeption extends RuntimeException{

    public PersonNotFoundExeption(Long personId){
        super("could not find person " + personId);
    }

}
