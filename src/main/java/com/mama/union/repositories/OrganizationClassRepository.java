package com.mama.union.repositories;

import com.mama.union.entity.DAO.OrganizationClass;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrganizationClassRepository extends CrudRepository<OrganizationClass, Long> {
}
