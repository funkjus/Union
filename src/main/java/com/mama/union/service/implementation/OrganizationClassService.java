package com.mama.union.service.implementation;

import com.mama.union.entity.DAO.OrganizationClass;
import com.mama.union.repositories.OrganizationClassRepository;
import com.mama.union.service.AbstrBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrganizationClassService extends AbstrBaseService<OrganizationClass> {

    private final OrganizationClassRepository repository;

    public OrganizationClassService(OrganizationClassRepository repository) {
        this.repository = repository;
    }

    public List<OrganizationClass> getAll() {
        List<OrganizationClass> list = new ArrayList<>();
        repository.findAll().forEach(list::add);
        return list;
    }

    public OrganizationClass getById(Long id) {
        Optional<OrganizationClass> opt = repository.findById(id);
        if(!opt.isPresent()){
            throw new IllegalArgumentException("No organization found");
        }
        return opt.get();
    }

    public OrganizationClass create(OrganizationClass item) {
        return repository.save(item);
    }

    public OrganizationClass update(Long id, OrganizationClass item) {
        OrganizationClass orig = getById(id);
        merge(orig, item);
        return repository.save(orig);
    }

    public OrganizationClass delete(Long id) {
        OrganizationClass item = getById(id);
        repository.deleteById(id);
        return item;
    }
}
