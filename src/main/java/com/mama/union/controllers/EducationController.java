package com.mama.union.controllers;

import com.mama.union.entity.DAO.EducationClass;
import com.mama.union.service.implementation.EducationClassService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/educations")
public class EducationController {

    private final EducationClassService service;

    public EducationController(EducationClassService service) {
        this.service = service;
    }


    @GetMapping
    @PreAuthorize("hasAuthority('person:read')")
    public List<EducationClass> all() {
        return service.getAll();
    }

    public EducationController byId(Long id) {
        return null;
    }

    public EducationController create(EducationController item) {
        return null;
    }

    public EducationController update(Long id, EducationController item) {
        return null;
    }

    public EducationController delete(Long id) {
        return null;
    }
}
