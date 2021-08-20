package com.mama.union.utils.exeption;

import lombok.Getter;

@Getter
public class UserNotFoundExeption extends RuntimeException{

    public UserNotFoundExeption(Long userId){
        super("could not find user " + userId);
    }

    public UserNotFoundExeption(String userEmail){
        super("could not find user " + userEmail);
    }
}
