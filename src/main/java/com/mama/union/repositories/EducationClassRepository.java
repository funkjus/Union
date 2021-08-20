package com.mama.union.repositories;

import com.mama.union.entity.DAO.EducationClass;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EducationClassRepository extends CrudRepository<EducationClass, Long> {
}
