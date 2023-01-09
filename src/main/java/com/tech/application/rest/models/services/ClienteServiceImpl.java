package com.tech.application.rest.models.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.tech.application.rest.models.dao.IClienteDao;
import com.tech.application.rest.models.entity.Cliente;

@Service
public class ClienteServiceImpl implements IClienteService{
	
	@Autowired
	private IClienteDao clienteDao;
	
	@Override
	@Transactional(readOnly = true)
	public Cliente findById(Integer id) {
		return clienteDao.findById(id).orElse(null);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Cliente> findByUsuario(String usuario) {
        return clienteDao.findByUsuario(usuario);
	}
	
	@Override
	@Transactional(readOnly = true)
	public Optional<Cliente> findByEmail(String email) {
        return clienteDao.findByEmail(email);
	}
	
	@Override
	public Cliente BuscarByEmailCreado(String email) {
        return clienteDao.BuscarByEmailCreado(email);
	}
	

	@Override
	@Transactional(readOnly = true)
	public boolean existsByUsuario(String usuario) {
        return clienteDao.existsByUsuario(usuario);		
	}

	@Override
	@Transactional(readOnly = true)
	public boolean existsByEmail(String email) {
        return clienteDao.existsByEmail(email);		
	}

	@Override
	@Transactional(readOnly = true)
	public List<Cliente> finAll() {
		return (List<Cliente>)clienteDao.findAll();
	}

	@Override
	@Transactional
	public Cliente save(Cliente cliente) {
		return clienteDao.save(cliente);
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		clienteDao.deleteById(id);
	
	}

	@Override
	@Transactional
	public Cliente execProcSaveCliente(String usuario, String password,String email,String primerNombre,String segundoNombre,String apellidos,
			Integer id_pais, Integer estado,Integer plan,Integer sistema) {
		clienteDao.execProcSaveCliente(usuario,password,email,primerNombre,segundoNombre,apellidos,id_pais,estado,plan,sistema);
		
		return clienteDao.BuscarByEmailCreado(email);
	}
	
}
