package com.tech.application.rest.models.dao;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tech.application.rest.models.entity.Pais;

@Repository
public interface IPaisDao extends JpaRepository<Pais,Integer>{


	Optional<Pais> findByNombre(String nombre);
	
	boolean existsByNombre(String nombre);
	
	
}
