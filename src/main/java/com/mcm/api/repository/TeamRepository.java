package com.mcm.api.repository;

import org.springframework.data.repository.CrudRepository;

import com.mcm.api.entity.Team;

public interface TeamRepository extends CrudRepository<Team, String> {

}
