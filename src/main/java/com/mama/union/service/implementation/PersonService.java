package com.mama.union.service.implementation;

import com.mama.union.entity.DAO.MemberDoc;
import com.mama.union.entity.DAO.Person;
import com.mama.union.repositories.PersonRepository;
import com.mama.union.service.AbstrBaseService;
import com.mama.union.utils.exeption.MyOwnExeprion;
import com.mama.union.utils.exeption.PersonNotFoundExeption;
import com.mama.union.utils.validation.PersonValidation;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.validation.DataBinder;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PersonService extends AbstrBaseService<Person> {

    private final PersonRepository repository;
    private final PersonValidation personValidation;

    public PersonService(PersonRepository repository, PersonValidation personValidation) {
        this.repository = repository;
        this.personValidation = personValidation;
    }

    public List<Person> getAll(Pageable pageable) {
        List<Person> list = new ArrayList<>();
        repository.findAll(pageable).getContent().forEach(list::add);
        return list;
    }

    public List<Person> getByFn(String fn, Pageable pageable) {
        List<Person> list = new ArrayList<>();
        repository.findByFnContaining(fn, pageable).getContent().forEach(list::add);
        return list;
    }

    public Person getById(Long id) {
        Optional<Person> opt = repository.findById(id);
        if (!opt.isPresent()) {
            throw new PersonNotFoundExeption(id);
        }
        return opt.get();
    }

    public Person create(Person person) {
        DataBinder dataBinder = new DataBinder(person);
        dataBinder.addValidators(personValidation);
        dataBinder.validate();
        if (dataBinder.getBindingResult().hasErrors()) {
            throw new MyOwnExeprion(dataBinder.getBindingResult().getAllErrors());
        }
        return repository.save(person);
    }

    public Person update(Long id, Person item) {
        Person orig = getById(id);
        orig.setFn(item.getFn());
        orig.setLn(item.getLn());
        orig.setBirth(item.getBirth());
        orig.setMaritalId(item.getMaritalId());
        orig.setUpdated(item.getUpdated());
        orig.setEducation(item.getEducation());
        List<MemberDoc> memberDoc = new ArrayList<>();
        if (item.getMemberDoc() != null && item.getMemberDoc().size() != 0) {
            for (MemberDoc m : item.getMemberDoc()) {
                memberDoc.add(m);
            }
        }
        orig.setMemberDoc(memberDoc);

//        merge(orig, item);
        return repository.save(orig);
    }

    public Person delete(Long id) {
        Person item = getById(id);
        repository.deleteById(id);
        return item;
    }

    public List<MemberDoc> getAllMemberDoc(Long id) {
        Person person = getById(id);
        List<MemberDoc> memberDocList = person.getMemberDoc();
        return memberDocList;
    }

}
