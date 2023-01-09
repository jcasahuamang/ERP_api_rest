package com.tech.application.rest.models.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.tech.application.rest.models.entity.Sistema;

@Repository
public interface ISistemaDao extends JpaRepository<Sistema, Integer> {
	
	Optional<Sistema> findByCodigo(String codigo);
	
	boolean existsByCodigo(String codigo);
}
