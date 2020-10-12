/**
 *
 */
package com.mcm.api.repository;

import java.math.BigDecimal;
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

	int countByStatusAndDuedateLessThan(String string, BigDecimal currentTimeMillis);

	Optional<Cases> findById(String id);

}
