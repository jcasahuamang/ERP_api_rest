package com.tech.application.rest.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.tech.application.rest.models.entity.RepAlmaSaldoCierre;

@Repository
public interface IRepAlmaSaldoCierreDao extends JpaRepository<RepAlmaSaldoCierre, Integer>{


	@Query(value="{call usp_rpt_alma_saldocierre(:usuario,:compania,:ano,:mes,:almacen)}",nativeQuery=true)
	public List<RepAlmaSaldoCierre>  execProcRptAlmaSaldoCierre(
					@Param("usuario") String usuario,
					@Param("compania") Integer compania,
					@Param("ano") Integer ano,
					@Param("mes") Integer mes,
					@Param("almacen") Integer almacen);

	
	
}

