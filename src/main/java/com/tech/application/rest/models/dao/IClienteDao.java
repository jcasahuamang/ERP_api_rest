package com.tech.application.rest.models.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import com.tech.application.rest.models.entity.Cliente;

@Repository
public interface IClienteDao extends JpaRepository<Cliente, Integer>{

	Optional<Cliente> findByUsuario(String usuario);
	Optional<Cliente> findByEmail(String email);
	

	@Query(nativeQuery = true, value= "select id_cliente,usuario,clave,correo,primer_nombre,segundo_nombre,apellidos,id_pais,estado,null plan, null sistema from sis_cliente\r\n"
			+ "where correo = :email")
	public Cliente BuscarByEmailCreado(@Param("email") String email);
	
	
	boolean existsByUsuario(String usuario);
	boolean existsByEmail(String email);
	
	@Procedure(name = "usp_save_cliente")
	public void execProcSaveCliente(String usuario, String password,String email,
			String primerNombre,
			String segundoNombre,
			String apellidos,
			Integer id_pais, Integer estado,Integer plan,Integer sistema);
		
	
}
