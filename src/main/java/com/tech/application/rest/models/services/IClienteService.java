package com.tech.application.rest.models.services;

import java.util.List;
import java.util.Optional;

import com.tech.application.rest.models.entity.Cliente;

public interface IClienteService {

	public Cliente findById(Integer id);
	
	Optional<Cliente> findByUsuario(String usuario);
	Optional<Cliente> findByEmail(String email);
	
	public Cliente BuscarByEmailCreado(String email);
	
	boolean existsByUsuario(String usuario);
	boolean existsByEmail(String email);
	
	public List<Cliente> finAll();
	
	public Cliente save(Cliente cliente);
	public void delete(Integer id);
	
	public Cliente execProcSaveCliente(String usuario, String password,String email,
			String primerNombre,
			String segundoNombre,
			String apellidos,
			Integer id_pais, Integer estado,Integer plan,Integer sistema);
	
}
