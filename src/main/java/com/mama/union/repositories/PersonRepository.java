package com.mama.union.repositories;

import com.mama.union.entity.DAO.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends PagingAndSortingRepository<Person, Long> {

    Page<Person> findAll (Pageable pagable);

    Page<Person> findByFnContaining(String title, Pageable pageable);

    List<Person> findByFnContaining(String title, Sort sort);


}
