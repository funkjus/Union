package com.mama.union.controllers;

import com.mama.union.entity.DAO.OrganizationClass;
import com.mama.union.service.implementation.OrganizationClassService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/organizations")
public class OrganizationController {

    private final OrganizationClassService organizationClassService;

    public OrganizationController(OrganizationClassService organizationClassService) {
        this.organizationClassService = organizationClassService;
    }

    public <T> List<T> all() {
        return null;
    }

    public OrganizationClass byId(Long id) {
        return null;
    }

    public OrganizationClass create(OrganizationClass item) {
        return null;
    }

    public OrganizationClass update(Long id, OrganizationClass item) {
        return null;
    }

    public OrganizationClass delete(Long id) {
        return null;
    }
}
