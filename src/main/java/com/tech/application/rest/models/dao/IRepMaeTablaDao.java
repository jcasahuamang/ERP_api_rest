package com.tech.application.rest.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.tech.application.rest.models.entity.RepMaeTabla;

@Repository
public interface IRepMaeTablaDao extends JpaRepository<RepMaeTabla, Integer>{

	@Query(value="{call usp_rpt_mae_tabla(:usuario,:compania)}",nativeQuery=true)
	public List<RepMaeTabla>  execProcRptMaeTabla(
					@Param("usuario") String usuario,
					@Param("compania") Integer compania);
	
}
