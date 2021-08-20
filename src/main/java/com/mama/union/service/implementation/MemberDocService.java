package com.mama.union.service.implementation;

import com.mama.union.entity.DAO.MemberDoc;
import com.mama.union.repositories.MemberDocRepository;
import com.mama.union.service.AbstrBaseService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MemberDocService extends AbstrBaseService<MemberDoc> {

    private final MemberDocRepository repository;

    public MemberDocService(MemberDocRepository repository) {
        this.repository = repository;
    }

    public List<MemberDoc> getAll() {
        List<MemberDoc> list = new ArrayList<>();
        repository.findAll().forEach(list::add);
        return list;
    }

    public MemberDoc getById(Long id) {
        Optional<MemberDoc> opt = repository.findById(id);
        if(!opt.isPresent()){
            throw new IllegalArgumentException("No member's doc found");
        }
        return opt.get();
    }

    public MemberDoc create(MemberDoc item) {
        return repository.save(item);
    }

    public MemberDoc update(Long id, MemberDoc item) {
        MemberDoc orig = getById(id);
        orig.setNum(item.getNum());
        orig.setCreated(item.getCreated());
        orig.setFinished(item.getFinished());
        orig.setCompleted(item.getCompleted());
        orig.setPerson(item.getPerson());
        return repository.save(orig);
    }

    public MemberDoc delete(Long id) {
        MemberDoc item = getById(id);
        repository.deleteById(id);
        return item;
    }
}
