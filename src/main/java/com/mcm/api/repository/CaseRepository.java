/**
 *
 */
package com.mcm.api.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.mcm.api.entity.Cases;

/**
 * @author rohansharma
 *
 */
public interface CaseRepository extends CrudRepository<Cases, String> {
	public List<Cases> findByDepartmentid(String departmentId);
	
	@Query("select c.id,d.department,c.departmentid,c.status FROM Cases c left join Department d on c.departmentid=d.id")
	public List<Object> findByDepartment();

	//Optional<Cases> findByIdAndTeamid(String id, String teamid);

	int countByStatusAndDuedateLessThan(String string, long currentTimeMillis);

	Optional<Cases> findById(String id);

}
