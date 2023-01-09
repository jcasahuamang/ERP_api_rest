package com.tech.application.rest.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.tech.application.rest.models.entity.MaeAlmacen;

@Repository
public interface IMaeAlmacenDao extends JpaRepository<MaeAlmacen, Integer> {

	@Query(nativeQuery = true, 
			value= "select id_compania,id_almacen,nombre,tipo,direccion,ind_virtual,id_pais,estado from mae_almacen\r\n"
			+ "where id_almacen = :id")
	public MaeAlmacen BuscarById(@Param("id") Integer id);

	@Query(nativeQuery = true, 
			value= "select id_compania,id_almacen,nombre,tipo,direccion,ind_virtual,id_pais,estado from mae_almacen\r\n"
			+ "where id_compania = :compania")
	public List<MaeAlmacen> BuscarAllByCompania(@Param("compania") Integer compania);
	
	@Query(nativeQuery = true, 
			value= "select id_compania,id_almacen,nombre,tipo,direccion,ind_virtual,id_pais,estado from mae_almacen\r\n"
			+ "where id_compania = :compania and nombre like concat('%',:nombre,'%')")
	public List<MaeAlmacen> BuscarByCompaniaNombre(@Param("compania") Integer compania,
														@Param("nombre") String nombre);
	
	@Query(nativeQuery = true, 
			value= "select id_compania,id_almacen,nombre,tipo,direccion,ind_virtual,id_pais,estado from mae_almacen\r\n"
			+ "where id_compania = :compania and coalesce(estado,0) = 1 order by id_almacen limit 1")
	public MaeAlmacen BuscarDefaultByCompania(@Param("compania") Integer compania);
	
	@Query(value="{call usp_valida_delete_almacen(:usuario,:cliente,:almacen)}",nativeQuery=true)
	public int execProcValidaDeleteAlmacen(
					@Param("usuario") String usuario,
					@Param("cliente") Integer cliente,
					@Param("almacen") Integer almacen);	
	
}
