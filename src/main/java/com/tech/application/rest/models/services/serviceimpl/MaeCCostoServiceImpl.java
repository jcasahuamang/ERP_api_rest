package com.tech.application.rest.models.services.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tech.application.rest.models.dao.IMaeCCostoDao;
import com.tech.application.rest.models.entity.MaeCCosto;
import com.tech.application.rest.models.services.service.IMaeCCostoService;

@Service
public class MaeCCostoServiceImpl implements IMaeCCostoService{

	@Autowired
	private IMaeCCostoDao maeCCostoDao;
	
	@Override
	@Transactional(readOnly = true)	
	public MaeCCosto BuscarById(Integer id){
		return maeCCostoDao.BuscarById(id);
	}

	@Override
	@Transactional(readOnly = true)	
	public List<MaeCCosto> BuscarAllByCompania(Integer compania) {
        return maeCCostoDao.BuscarAllByCompania(compania);
	}

	@Override
	@Transactional(readOnly = true)	
	public List<MaeCCosto> BuscarByCompaniaNombre(Integer compania,String nombre){
        return maeCCostoDao.BuscarByCompaniaNombre(compania,nombre);
	}

	@Override
	@Transactional(readOnly = true)	
	public MaeCCosto BuscarDefaultByCompania(Integer compania) {
        return maeCCostoDao.BuscarDefaultByCompania(compania);
	}

	@Override
	@Transactional
	public MaeCCosto save(MaeCCosto ccosto) {
		return maeCCostoDao.save(ccosto);
	}
	
	@Override
	@Transactional
	public void delete(Integer id) {
		maeCCostoDao.deleteById(id);
	}
	
	@Override
	public int execProcValidaDeleteCCosto(String usuario,Integer cliente,Integer ccosto) {
		return maeCCostoDao.execProcValidaDeleteCCosto(usuario,cliente,ccosto);
	}
	
}
