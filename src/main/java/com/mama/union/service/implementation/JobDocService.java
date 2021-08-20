package com.mama.union.service.implementation;

import com.mama.union.entity.DAO.JobDoc;
import com.mama.union.repositories.JobDocRepository;
import com.mama.union.service.AbstrBaseService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class JobDocService extends AbstrBaseService<JobDoc> {

    private final JobDocRepository repository;

    public JobDocService(JobDocRepository repository) {
        this.repository = repository;
    }

    public List<JobDoc> getAll() {
        List<JobDoc> list = new ArrayList<>();
        repository.findAll().forEach(list::add);
        return list;
    }

    public JobDoc getById(Long id) {
        Optional<JobDoc> opt = repository.findById(id);
        if(!opt.isPresent()){
            throw new IllegalArgumentException("Not JobDoc found");
        }
        return opt.get();
    }

    public JobDoc create(JobDoc item) {
        return repository.save(item);
    }

    public JobDoc update(Long id, JobDoc item) {
        JobDoc orig = getById(id);
        merge(orig, item);
        return repository.save(orig);
    }

    public JobDoc delete(Long id) {
        JobDoc item = getById(id);
        repository.deleteById(id);
        return item;
    }
}
