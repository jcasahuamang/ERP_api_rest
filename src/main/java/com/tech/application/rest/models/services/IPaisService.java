package com.tech.application.rest.models.services;

import java.util.List;
import java.util.Optional;

import com.tech.application.rest.models.entity.Pais;

public interface IPaisService {
	
	public Pais findById(Integer id);
	
	Optional<Pais> findByNombre(String nombre);
	
	boolean existsByNombre(String nombre);
	
	public List<Pais> findAll();
	
	public Pais save(Pais pais);
	public void delete(Integer id);

}
