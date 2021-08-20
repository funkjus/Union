package com.mama.union.service.implementation;

import com.mama.union.entity.DAO.EducationClass;
import com.mama.union.repositories.EducationClassRepository;
import com.mama.union.service.AbstrBaseService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EducationClassService extends AbstrBaseService<EducationClass> {

    private final EducationClassRepository repository;

    public EducationClassService(EducationClassRepository repository) {
        this.repository = repository;
    }

    public List<EducationClass> getAll() {
        List<EducationClass> list = new ArrayList<>();
        repository.findAll().forEach(list::add);
        return list;
    }

    public EducationClass getById(Long id) {
        Optional<EducationClass> opt = repository.findById(id);
        if (!opt.isPresent()) {
            throw new IllegalArgumentException("No EducationClass found");
        }
        return opt.get();
    }

    public EducationClass create(EducationClass item) {
        return repository.save(item);
    }

    public EducationClass update(Long id, EducationClass item) {
        EducationClass orig = getById(id);
        merge(orig, item);
        return repository.save(orig);
    }

    public EducationClass delete(Long id) {
        EducationClass item = getById(id);
        repository.deleteById(id);
        return item;
    }

    public Map<String, EducationClass> getEducation () {
        Map<String, EducationClass> education = new HashMap<>();
        for (EducationClass e : getAll()) {
            education.put(e.getName(), e);
        }
        return education;
    }
}
