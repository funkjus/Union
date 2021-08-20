package com.mama.union.repositories;

import com.mama.union.entity.DAO.JobDoc;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobDocRepository extends CrudRepository<JobDoc, Long> {
}
