package com.tech.application.rest.models.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tech.application.rest.models.dao.IPaisDao;
import com.tech.application.rest.models.entity.Pais;


@Service
public class PaisServiceImpl implements IPaisService{
	

	@Autowired
	private IPaisDao paisDao;

	@Override
	@Transactional(readOnly = true)
	public Pais findById(Integer id){		
		return paisDao.findById(id).orElse(null);
	}
	
	@Override
	@Transactional(readOnly = true)
	public Optional<Pais> findByNombre(String nombre){
		return paisDao.findByNombre(nombre);
	}
	
	@Override
	@Transactional(readOnly = true)
	public boolean existsByNombre(String nombre) {
		return paisDao.existsByNombre(nombre);
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<Pais> findAll(){
		return (List<Pais>)paisDao.findAll();
	}
	
	@Override
	@Transactional
	public Pais save(Pais pais) {
		return paisDao.save(pais);
	}
	
	@Override
	@Transactional
	public void delete(Integer id) {
		paisDao.deleteById(id);
	}
	
}
