package com.tech.application.rest.models.dao;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.tech.application.rest.models.entity.MaeEntidadContacto;

@Repository
public interface IMaeEntidadContactoDao extends JpaRepository<MaeEntidadContacto, Integer> {

	@Query(nativeQuery = true, 
			value= "select id_entidad,id_contacto,nombre_completo,telefono1,email,cargo from mae_entidad_contacto\r\n"
			+ "where id_contacto = :id")
	public MaeEntidadContacto BuscarById(@Param("id") Integer id);

	@Query(nativeQuery = true, 
			value= "select id_entidad,id_contacto,nombre_completo,telefono1,email,cargo from mae_entidad_contacto\r\n"
			+ "where id_entidad = :entidad")
	public List<MaeEntidadContacto> BuscarAllByEntidad(@Param("entidad") Integer entidad);
	
	@Query(nativeQuery = true, 
			value= "select id_entidad,id_contacto,nombre_completo,telefono1,email,cargo from mae_entidad_contacto\r\n"
			+ "where id_entidad in (select id_entidad from mae_entidad where id_compania = :compania) ")
	public List<MaeEntidadContacto> BuscarAllByCompania(@Param("compania") Integer compania);
	
	@Query(nativeQuery = true, 
			value= "select id_entidad,id_contacto,nombre_completo,telefono1,email,cargo from mae_entidad_contacto\r\n"
			+ "where id_entidad = :entidad and "
			+ " coalesce(nombre_completo,'')  like concat('%',:nombre,'%')")
	public List<MaeEntidadContacto> BuscarByEntidadNombre(@Param("entidad") Integer entidad,
														@Param("nombre") String nombre);
	
}
