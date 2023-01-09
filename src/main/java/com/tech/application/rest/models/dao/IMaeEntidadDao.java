package com.tech.application.rest.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.tech.application.rest.models.entity.MaeEntidad;

@Repository
public interface IMaeEntidadDao extends JpaRepository<MaeEntidad, Integer>  {

	@Query(nativeQuery = true, 
			value= "select id_compania,id_entidad,nombre_primero,nombre_segundo,apellido_paterno,apellido_materno,nombre_legal,"
					+ "nombre_comercial,tipo_documento,numero_documento,webpage,email,telefono1,telefono2,codigo_habido,id_pais,estado "
					+ "from mae_entidad\r\n"
			+ "where id_entidad = :id")
	public MaeEntidad BuscarById(@Param("id") Integer id);

	@Query(nativeQuery = true, 
			value= "select id_compania,id_entidad,nombre_primero,nombre_segundo,apellido_paterno,apellido_materno,nombre_legal,"
					+ "nombre_comercial,tipo_documento,numero_documento,webpage,email,telefono1,telefono2,codigo_habido,id_pais,estado "
					+ "from mae_entidad\r\n"
			+ "where id_compania = :compania")
	public List<MaeEntidad> BuscarAllByCompania(@Param("compania") Integer compania);
	
	@Query(nativeQuery = true, 
			value= "select id_compania,id_entidad,nombre_primero,nombre_segundo,apellido_paterno,apellido_materno,nombre_legal,"
					+ "nombre_comercial,tipo_documento,numero_documento,webpage,email,telefono1,telefono2,codigo_habido,id_pais,estado "
					+ "from mae_entidad\r\n"
			+ "where id_compania = :compania and "
			+ " concat_ws('',nombre_primero,nombre_segundo,apellido_paterno,apellido_materno,nombre_legal,nombre_comercial) like concat('%',:nombre,'%')")
	public List<MaeEntidad> BuscarByCompaniaNombre(@Param("compania") Integer compania,
														@Param("nombre") String nombre);


	@Query(value="{call usp_valida_delete_entidad(:usuario,:cliente,:entidad)}",nativeQuery=true)
	public int execProcValidaDeleteEntidad(
					@Param("usuario") String usuario,
					@Param("cliente") Integer cliente,
					@Param("entidad") Integer entidad);
	

	@Query(value="{call usp_delete_entidad(:usuario,:cliente,:entidad)}",nativeQuery=true)
	public int execProcDeleteEntidad(
					@Param("usuario") String usuario,
					@Param("cliente") Integer cliente,
					@Param("entidad") Integer entidad);
	
	
}
