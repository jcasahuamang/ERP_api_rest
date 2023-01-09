package com.tech.application.rest.models.services.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tech.application.rest.models.dao.IUsuarioDao;
import com.tech.application.rest.models.entity.MaeUsuario;
import com.tech.application.rest.models.services.service.IUsuarioService;

@Service
public class UsuarioServiceImpl implements IUsuarioService{

	@Autowired
	private IUsuarioDao usuarioDao;

	@Override
	@Transactional(readOnly = true)
	public MaeUsuario findById(Integer id) {
		return usuarioDao.findById(id).orElse(null);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<MaeUsuario> findByUsuario(String usuario) {
        return usuarioDao.findByUsuario(usuario);
	}
	
	@Override
	@Transactional(readOnly = true)
	public Optional<MaeUsuario> findByEmail(String email) {
        return usuarioDao.findByEmail(email);
	}
	
	@Override
	public List<MaeUsuario> findAllByCliente(Integer cliente) {
        return usuarioDao.findAllByCliente(cliente);
	}
	
	@Override
	@Transactional(readOnly = true)
	public boolean existsByUsuario(String usuario) {
        return usuarioDao.existsByUsuario(usuario);		
	}

	@Override
	@Transactional(readOnly = true)
	public boolean existsByEmail(String email) {
        return usuarioDao.existsByEmail(email);		
	}

	@Override
	@Transactional(readOnly = true)
	public List<MaeUsuario> findAll() {
		return (List<MaeUsuario>)usuarioDao.findAll();
	}

	@Override
	@Transactional
	public MaeUsuario save(MaeUsuario usuario) {
		return usuarioDao.save(usuario);
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		usuarioDao.deleteById(id);
	
	}
}
