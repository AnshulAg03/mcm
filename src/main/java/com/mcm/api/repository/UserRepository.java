/**
 * 
 */
package com.mcm.api.repository;

import org.springframework.data.repository.CrudRepository;

import com.mcm.api.entity.User;

/**
 * @author parulsharma
 *
 */
public interface UserRepository extends CrudRepository<User, String> {

}
