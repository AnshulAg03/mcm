/**
 * 
 */
package com.mcm.api.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.mcm.api.entity.Cases;

/**
 * @author rohansharma
 *
 */
public interface CaseRepository extends CrudRepository<Cases, String> {
	public List<Cases> findByDepartmentid(String departmentId);
}
