package com.mcm.api.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mcm.api.entity.TeamUserMapping;

@Repository
public interface TeamUserMappingRepository extends CrudRepository<TeamUserMapping, String>{

}
