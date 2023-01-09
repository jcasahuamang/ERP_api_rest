package com.tech.application.rest.models.services.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tech.application.rest.models.dao.IMaeSedeDao;
import com.tech.application.rest.models.entity.MaeSede;
import com.tech.application.rest.models.services.service.IMaeSedeService;

@Service
public class MaeSedeServiceImpl implements IMaeSedeService{
	
	@Autowired
	private IMaeSedeDao maeSedeDao;
	
	@Override
	@Transactional(readOnly = true)	
	public MaeSede BuscarById(Integer id){
		return maeSedeDao.BuscarById(id);
	}

	@Override
	@Transactional(readOnly = true)	
	public List<MaeSede> BuscarAllByCompania(Integer compania) {
        return maeSedeDao.BuscarAllByCompania(compania);
	}

	@Override
	@Transactional(readOnly = true)	
	public List<MaeSede> BuscarByCompaniaNombre(Integer compania,String nombre){
        return maeSedeDao.BuscarByCompaniaNombre(compania,nombre);
	}

	@Override
	@Transactional(readOnly = true)	
	public MaeSede BuscarDefaultByCompania(Integer compania) {
        return maeSedeDao.BuscarDefaultByCompania(compania);
	}

	@Override
	@Transactional
	public MaeSede save(MaeSede sede) {
		return maeSedeDao.save(sede);
	}
	
	@Override
	@Transactional
	public void delete(Integer id) {
		maeSedeDao.deleteById(id);
	}
	
	@Override
	public int execProcValidaDeleteSede(String usuario,Integer cliente,Integer sede) {
		return maeSedeDao.execProcValidaDeleteSede(usuario,cliente,sede);
	}
	
}
