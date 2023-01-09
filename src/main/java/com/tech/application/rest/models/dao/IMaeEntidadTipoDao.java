package com.tech.application.rest.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.tech.application.rest.models.entity.MaeEntidadTipo;

@Repository
public interface IMaeEntidadTipoDao extends JpaRepository<MaeEntidadTipo, Integer>{

	@Query(nativeQuery = true, 
			value= "select id_entidad,id_tipo,codigo from mae_entidad_tipo\r\n"
			+ "where id_tipo = :id")
	public MaeEntidadTipo BuscarById(@Param("id") Integer id);

	@Query(nativeQuery = true, 
			value= "select id_entidad,id_tipo,codigo from mae_entidad_tipo\r\n"
			+ "where id_entidad = :entidad")
	public List<MaeEntidadTipo> BuscarAllByEntidad(@Param("entidad") Integer entidad);
	

	
}
