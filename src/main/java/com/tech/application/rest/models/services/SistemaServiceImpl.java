package com.tech.application.rest.models.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tech.application.rest.models.dao.ISistemaDao;
import com.tech.application.rest.models.entity.Sistema;

@Service
public class SistemaServiceImpl implements ISistemaService{
	@Autowired
	private ISistemaDao sistemaDao;
	
	@Override
	@Transactional(readOnly = true)
	public Sistema findById(Integer id) {
		return sistemaDao.findById(id).orElse(null);
	}
	
	@Override
	@Transactional(readOnly = true)
	public Optional<Sistema> findByCodigo(String codigo) {
        return sistemaDao.findByCodigo(codigo);
	}
	
	@Override
	@Transactional(readOnly = true)
	public boolean existsByCodigo(String codigo) {
        return sistemaDao.existsByCodigo(codigo);		
	}	
	
	@Override
	@Transactional(readOnly = true)
	public List<Sistema> findAll() {
		return (List<Sistema>)sistemaDao.findAll();
	}

	@Override
	@Transactional
	public Sistema save(Sistema sistema) {
		return sistemaDao.save(sistema);
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		sistemaDao.deleteById(id);
	
	}
}
