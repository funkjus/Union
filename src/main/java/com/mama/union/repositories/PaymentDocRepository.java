package com.mama.union.repositories;

import com.mama.union.entity.DAO.PaymentDoc;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentDocRepository extends CrudRepository<PaymentDoc, Long> {
}
