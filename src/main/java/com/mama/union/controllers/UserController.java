package com.mama.union.controllers;

import com.mama.union.entity.DAO.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController{

    public <T> List<T> all() {
        return null;
    }

    public User byId(Long id) {
        return null;
    }

    public User create(User item) {
        return null;
    }

    public User update(Long id, User item) {
        return null;
    }

    public User delete(Long id) {
        return null;
    }
}
