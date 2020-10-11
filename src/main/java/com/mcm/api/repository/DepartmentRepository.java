package com.mcm.api.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mcm.api.entity.Department;

@Repository
public interface DepartmentRepository extends CrudRepository<Department, String> {

}
