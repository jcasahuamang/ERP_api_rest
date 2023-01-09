package com.tech.application.rest.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.tech.application.rest.models.entity.MaeSede;

@Repository
public interface IMaeSedeDao extends JpaRepository<MaeSede, Integer> {

	@Query(nativeQuery = true, 
			value= "select id_compania,id_sede,nombre,direccion,telefono1,telefono2,id_pais,estado from mae_sede\r\n"
			+ "where id_sede = :id")
	public MaeSede BuscarById(@Param("id") Integer id);

	@Query(nativeQuery = true, 
			value= "select id_compania,id_sede,nombre,direccion,telefono1,telefono2,id_pais,estado from mae_sede\r\n"
			+ "where id_compania = :compania")
	public List<MaeSede> BuscarAllByCompania(@Param("compania") Integer compania);
	
	@Query(nativeQuery = true, 
			value= "select id_compania,id_sede,nombre,direccion,telefono1,telefono2,id_pais,estado from mae_sede\r\n"
			+ "where id_compania = :compania and nombre like concat('%',:nombre,'%')")
	public List<MaeSede> BuscarByCompaniaNombre(@Param("compania") Integer compania,
														@Param("nombre") String nombre);
	
	@Query(nativeQuery = true, 
			value= "select id_compania,id_sede,nombre,direccion,telefono1,telefono2,id_pais,estado from mae_sede\r\n"
			+ "where id_compania = :compania and coalesce(estado,0) = 1 order by id_sede limit 1")
	public MaeSede BuscarDefaultByCompania(@Param("compania") Integer compania);


	@Query(value="{call usp_valida_delete_sede(:usuario,:cliente,:sede)}",nativeQuery=true)
	public int execProcValidaDeleteSede(
					@Param("usuario") String usuario,
					@Param("cliente") Integer cliente,
					@Param("sede") Integer sede);
	
	
}
