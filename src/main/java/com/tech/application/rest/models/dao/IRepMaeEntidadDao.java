package com.tech.application.rest.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.tech.application.rest.models.entity.RepMaeEntidad;

@Repository
public interface IRepMaeEntidadDao extends JpaRepository<RepMaeEntidad, Integer>{


	@Query(value="{call usp_rpt_mae_entidad(:usuario,:compania)}",nativeQuery=true)
	public List<RepMaeEntidad>  execProcRptMaeEntidad(
					@Param("usuario") String usuario,
					@Param("compania") Integer compania);
	
}
