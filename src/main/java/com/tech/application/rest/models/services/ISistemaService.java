package com.tech.application.rest.models.services;

import java.util.List;
import java.util.Optional;

import com.tech.application.rest.models.entity.Sistema;

public interface ISistemaService {

	public Sistema findById(Integer id);
	
	Optional<Sistema> findByCodigo(String codigo);

	
	boolean existsByCodigo(String codigo);
	
	public List<Sistema> findAll();
	
	public Sistema save(Sistema sistema);
	public void delete(Integer id);
	
}
