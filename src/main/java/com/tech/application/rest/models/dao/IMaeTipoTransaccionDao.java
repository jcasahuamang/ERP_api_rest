package com.tech.application.rest.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.tech.application.rest.models.entity.MaeTipoTransaccion;

@Repository
public interface IMaeTipoTransaccionDao extends JpaRepository<MaeTipoTransaccion, Integer>{

	@Query(nativeQuery = true, 
			value= "select id_compania,id_tipo,nombre,abreviatura,tipo,ind_salini,ind_interno,ind_externo, estado "
					+ "from mae_tipo_transaccion\r\n"
			+ "where id_tipo = :id")
	public MaeTipoTransaccion BuscarById(@Param("id") Integer id);

	@Query(nativeQuery = true, 
			value= "select id_compania,id_tipo,nombre,abreviatura,tipo,ind_salini,ind_interno,ind_externo, estado "
					+ "from mae_tipo_transaccion\r\n"
			+ "where id_compania = :compania")
	public List<MaeTipoTransaccion> BuscarAllByCompania(@Param("compania") Integer compania);
	
	@Query(nativeQuery = true, 
			value= "select id_compania,id_tipo,nombre,abreviatura,tipo,ind_salini,ind_interno,ind_externo, estado "
					+ "from mae_tipo_transaccion\r\n"
			+ "where id_compania = :compania and "
			+ " coalesce(nombre,'') like concat('%',:nombre,'%') ")
	public List<MaeTipoTransaccion> BuscarByCompaniaNombre(@Param("compania") Integer compania,
														@Param("nombre") String nombre);

	@Query(value="{call usp_valida_delete_tipotransa(:usuario,:cliente,:transaccion)}",nativeQuery=true)
	public int execProcValidaDeleteTransaccion(
					@Param("usuario") String usuario,
					@Param("cliente") Integer cliente,
					@Param("transaccion") Integer transaccion);
	

	@Query(value="{call usp_delete_tipotransa(:usuario,:cliente,:transaccion)}",nativeQuery=true)
	public int execProcDeleteTransaccion(
					@Param("usuario") String usuario,
					@Param("cliente") Integer cliente,
					@Param("transaccion") Integer transaccion);
	
}
