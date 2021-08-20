package com.mama.union.controllers;

import com.mama.union.entity.DAO.JobDoc;
import com.mama.union.service.implementation.JobDocService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/jobs")
public class JobController{

    private final JobDocService jobDocService;

    public JobController(JobDocService jobDocService) {
        this.jobDocService = jobDocService;
    }

    public <T> List<T> all() {
        return null;
    }

    public JobDoc byId(Long id) {
        return null;
    }

    public JobDoc create(JobDoc item) {
        return null;
    }

    public JobDoc update(Long id, JobDoc item) {
        return null;
    }

    public JobDoc delete(Long id) {
        return null;
    }
}
