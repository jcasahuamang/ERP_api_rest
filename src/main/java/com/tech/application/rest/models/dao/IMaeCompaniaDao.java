package com.tech.application.rest.models.dao;

import java.util.List;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tech.application.rest.models.entity.MaeCompania;

@Repository
public interface IMaeCompaniaDao extends JpaRepository<MaeCompania, Integer>{

	
	@Query(nativeQuery = true, 
			value= "select id_cliente,id_compania,nombre_legal,nombre_comercial,numero_reg_legal,telefono1,telefono2,webpage,id_pais,estado from mae_compania\r\n"
			+ "where id_compania = :id")
	public MaeCompania BuscarById(@Param("id") Integer id);

	@Query(nativeQuery = true, 
			value= "select id_cliente,id_compania,nombre_legal,nombre_comercial,numero_reg_legal,telefono1,telefono2,webpage,id_pais,estado from mae_compania\r\n"
			+ "where id_cliente = :cliente")
	public List<MaeCompania> BuscarAllByCliente(@Param("cliente") Integer cliente);
	
	@Query(nativeQuery = true, 
			value= "select id_cliente,id_compania,nombre_legal,nombre_comercial,numero_reg_legal,telefono1,telefono2,webpage,id_pais,estado from mae_compania\r\n"
			+ "where id_cliente = :cliente and nombre_legal like concat('%',:nombreLegal,'%')")
	public List<MaeCompania> BuscarByClienteNombreLegal(@Param("cliente") Integer cliente,
														@Param("nombreLegal") String nombreLegal);
	
	@Query(nativeQuery = true, 
			value= "select id_cliente,id_compania,nombre_legal,nombre_comercial,numero_reg_legal,telefono1,telefono2,webpage,id_pais,estado from mae_compania\r\n"
			+ "where id_cliente = :cliente and nombre_comercial like concat('%',:nombreComercial,'%')")
	public List<MaeCompania> BuscarByClienteNombreComercial(@Param("cliente") Integer cliente,
														@Param("nombreComercial") String nombreComercial);
	
	@Query(nativeQuery = true, 
			value= "select id_cliente,id_compania,nombre_legal,nombre_comercial,numero_reg_legal,telefono1,telefono2,webpage,id_pais,estado from mae_compania\r\n"
			+ "where id_cliente = :cliente and coalesce(estado,0) = 1 order by id_compania limit 1")
	public MaeCompania BuscarDefaultByCliente(@Param("cliente") Integer cliente);
	
	
	@Query(value="{call usp_valida_delete_compania(:usuario,:cliente,:compania)}",nativeQuery=true)
	public int execProcValidaDeleteCompania(
					@Param("usuario") String usuario,
					@Param("cliente") Integer cliente,
					@Param("compania") Integer compania);
	

	@Query(value="{call usp_delete_compania(:usuario,:cliente,:compania)}",nativeQuery=true)
	public int execProcDeleteCompania(
					@Param("usuario") String usuario,
					@Param("cliente") Integer cliente,
					@Param("compania") Integer compania);
	
	
	
	@Query(value="{call usp_compania_configura(:compania)}",nativeQuery=true)
	public int execProcCompaniaConfigura(@Param("compania") Integer compania);	
	
	/*
	@Transactional
	@Procedure(procedureName ="call usp_compania_configura(:compania)")
	public void execProcCompaniaConfigura(@Param("compania") Integer compania);	
	*/
}
