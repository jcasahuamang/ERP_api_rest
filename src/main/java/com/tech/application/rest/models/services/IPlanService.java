package com.tech.application.rest.models.services;

import java.util.List;
import java.util.Optional;

import com.tech.application.rest.models.entity.Plan;

public interface IPlanService {

	public Plan findById(Integer id);
	
	Optional<Plan> findByNombre(String nombre);
	
	boolean existsByNombre(String nombre);
	
	public List<Plan> findAll();
	
	public Plan save(Plan plan);
	public void delete(Integer id);
}
