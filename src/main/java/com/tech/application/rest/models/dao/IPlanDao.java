package com.tech.application.rest.models.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.tech.application.rest.models.entity.Plan;

@Repository
public interface IPlanDao extends JpaRepository<Plan, Integer>{

	Optional<Plan> findByNombre(String nombre);
	
	boolean existsByNombre(String nombre);
}
