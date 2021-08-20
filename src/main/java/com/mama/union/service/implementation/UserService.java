package com.mama.union.service.implementation;

import com.mama.union.entity.DAO.User;
import com.mama.union.repositories.MemberDocRepository;
import com.mama.union.repositories.UserRepository;
import com.mama.union.service.AbstrBaseService;
import com.mama.union.utils.exeption.UserNotFoundExeption;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService extends AbstrBaseService<User> {

    private final UserRepository repository;

    public UserService(UserRepository repository, MemberDocRepository memberDocRepository) {
        this.repository = repository;
    }

    public List<User> getAll() {
        List<User> list = new ArrayList<>();
        repository.findAll().forEach(list::add);
        return list;
    }

    public User getById(Long id) {
        Optional<User> opt = repository.findById(id);
        if (!opt.isPresent()) {
            throw new UserNotFoundExeption(id);
        }
        return opt.get();
    }

    public User getByEmail(String email) {
        Optional<User> opt = repository.findByEmail(email);
        if (!opt.isPresent()) {
            throw new UserNotFoundExeption(email);
        }
        return opt.get();
    }

    public User create(User item) {
        return repository.save(item);
    }

    public User update(Long id, User item) {
        User orig = getById(id);
        merge(orig, item);
        return repository.save(orig);
    }

    public User delete(Long id) {
        User item = getById(id);
        repository.deleteById(id);
        return item;
    }
}
