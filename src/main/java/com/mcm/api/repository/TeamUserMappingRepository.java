package com.mcm.api.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mcm.api.entity.Team;
import com.mcm.api.entity.TeamUserMapping;
import com.mcm.api.entity.User;

@Repository
public interface TeamUserMappingRepository extends CrudRepository<TeamUserMapping, String>{

	Iterable<TeamUserMapping> findAllByUser(User user);

	Iterable<TeamUserMapping> findAllByTeam(Team team);

}
