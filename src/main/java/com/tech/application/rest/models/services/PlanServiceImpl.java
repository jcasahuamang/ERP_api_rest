package com.tech.application.rest.models.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.tech.application.rest.models.dao.IPlanDao;
import com.tech.application.rest.models.entity.Plan;

@Service
public class PlanServiceImpl implements IPlanService{

	@Autowired
	private IPlanDao planDao;
	
	@Override
	@Transactional(readOnly = true)
	public Plan findById(Integer id) {
		return planDao.findById(id).orElse(null);
	}
	
	@Override
	@Transactional(readOnly = true)
	public Optional<Plan> findByNombre(String nombre) {
        return planDao.findByNombre(nombre);
	}
	
	@Override
	@Transactional(readOnly = true)
	public boolean existsByNombre(String nombre) {
        return planDao.existsByNombre(nombre);		
	}	
	
	@Override
	@Transactional(readOnly = true)
	public List<Plan> findAll() {
		return (List<Plan>)planDao.findAll();
	}

	@Override
	@Transactional
	public Plan save(Plan plan) {
		return planDao.save(plan);
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		planDao.deleteById(id);
	
	}
	
}
