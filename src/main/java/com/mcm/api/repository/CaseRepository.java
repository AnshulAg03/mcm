/**
 * 
 */
package com.mcm.api.repository;

import org.springframework.data.repository.CrudRepository;

import com.mcm.api.entity.Cases;

/**
 * @author rohansharma
 *
 */
public interface CaseRepository extends CrudRepository<Cases, String> {

}
