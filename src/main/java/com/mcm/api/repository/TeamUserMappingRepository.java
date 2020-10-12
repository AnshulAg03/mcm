package com.mcm.api.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mcm.api.entity.TeamUserMapping;
import com.mcm.api.entity.User;

@Repository
public interface TeamUserMappingRepository extends CrudRepository<TeamUserMapping, String>{

	Iterable<TeamUserMapping> findAllByUser(User user);

}
