package com.mcm.api.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mcm.api.entity.CaseTeamMapping;

@Repository
public interface CaseTeamMappingRepository extends CrudRepository<CaseTeamMapping, String>{

}
