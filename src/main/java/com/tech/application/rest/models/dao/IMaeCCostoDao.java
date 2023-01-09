package com.tech.application.rest.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.tech.application.rest.models.entity.MaeCCosto;

@Repository
public interface IMaeCCostoDao extends JpaRepository<MaeCCosto, Integer> {

	@Query(nativeQuery = true, 
			value= "select id_compania,id_costo,nombre,coalesce(codigo_tipo,'00')codigo_tipo,codigo_unidad_superior,estado from mae_centro_costo\r\n"
			+ "where id_costo = :id")
	public MaeCCosto BuscarById(@Param("id") Integer id);
	
	
	@Query(nativeQuery = true, 
			value= "select id_compania,id_costo,nombre,coalesce(codigo_tipo,'00')codigo_tipo,codigo_unidad_superior,estado from mae_centro_costo\r\n"
			+ "where id_compania = :compania") 
	public List<MaeCCosto> BuscarAllByCompania(@Param("compania") Integer compania);

	@Query(nativeQuery = true, 
			value= "select id_compania,id_costo,nombre,coalesce(codigo_tipo,'00')codigo_tipo,codigo_unidad_superior,estado from mae_centro_costo\r\n"
			+ "where id_compania = :compania and nombre like concat('%',:nombre,'%')")
	public List<MaeCCosto> BuscarByCompaniaNombre(@Param("compania") Integer compania,
														@Param("nombre") String nombre);
	
	@Query(nativeQuery = true, 
			value= "select id_compania,id_costo,nombre,coalesce(codigo_tipo,'00')codigo_tipo,codigo_unidad_superior,estado from mae_centro_costo\r\n"
			+ "where id_compania = :compania and coalesce(estado,0) = 1 order by id_costo limit 1")
	public MaeCCosto BuscarDefaultByCompania(@Param("compania") Integer compania);
	
	
	@Query(value="{call usp_valida_delete_ccosto(:usuario,:cliente,:ccosto)}",nativeQuery=true)
	public int execProcValidaDeleteCCosto(
					@Param("usuario") String usuario,
					@Param("cliente") Integer cliente,
					@Param("ccosto") Integer ccosto);
	
}
