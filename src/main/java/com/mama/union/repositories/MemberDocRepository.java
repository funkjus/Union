package com.mama.union.repositories;

import com.mama.union.entity.DAO.MemberDoc;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberDocRepository extends CrudRepository<MemberDoc, Long> {
}
