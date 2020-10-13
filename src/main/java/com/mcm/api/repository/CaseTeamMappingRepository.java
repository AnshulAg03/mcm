package com.mcm.api.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mcm.api.entity.CaseTeamId;
import com.mcm.api.entity.CaseTeamMapping;
import com.mcm.api.entity.Cases;
import com.mcm.api.entity.Team;

@Repository
public interface CaseTeamMappingRepository extends CrudRepository<CaseTeamMapping, CaseTeamId>{
	List<CaseTeamMapping> findByCasesAndTeam(Cases caseid, Team teamid);
}
