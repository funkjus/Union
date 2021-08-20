package com.mama.union.service.implementation;

import com.mama.union.entity.DAO.PaymentDoc;
import com.mama.union.repositories.PaymentDocRepository;
import com.mama.union.service.AbstrBaseService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PaymentDocService extends AbstrBaseService<PaymentDoc> {

    private final PaymentDocRepository repository;

    public PaymentDocService(PaymentDocRepository repository) {
        this.repository = repository;
    }

    public List<PaymentDoc> getAll() {
        List<PaymentDoc> list = new ArrayList<>();
        repository.findAll().forEach(list::add);
        return list;
    }

    public PaymentDoc getById(Long id) {
        Optional<PaymentDoc> opt = repository.findById(id);
        if (!opt.isPresent()) {
            throw new IllegalArgumentException("No payment's found");
        }
        return opt.get();
    }

    public PaymentDoc create(PaymentDoc item) {
        return repository.save(item);
    }

    public PaymentDoc update(Long id, PaymentDoc item) {
        PaymentDoc orig = getById(id);
        merge(orig, item);
        return repository.save(orig);

    }

    public PaymentDoc delete(Long id) {
        PaymentDoc item = getById(id);
        repository.deleteById(id);
        return item;
    }
}
