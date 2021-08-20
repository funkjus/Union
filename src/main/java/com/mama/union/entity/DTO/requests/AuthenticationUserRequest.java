package com.mama.union.entity.DTO.requests;

import lombok.Data;

@Data
public class AuthenticationUserRequest {
    private String email;
    private String password;
}
