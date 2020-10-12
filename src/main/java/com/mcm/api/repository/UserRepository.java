/**
 * 
 */
package com.mcm.api.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.mcm.api.entity.Department;
import com.mcm.api.entity.User;

/**
 * @author parulsharma
 *
 */
public interface UserRepository extends CrudRepository<User, String> {
	
	public List<User> findByDepartmentAndLogintype(Department department, String loginType);

	public User findByUserid(String userid);

	public User findByUseridAndPassword(String userid, String password);

}
