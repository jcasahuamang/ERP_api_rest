package com.tech.application.rest.models.services.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tech.application.rest.models.dao.IMaeEntidadDao;
import com.tech.application.rest.models.entity.MaeEntidad;
import com.tech.application.rest.models.services.service.IMaeEntidadService;

@Service
public class MaeEntidadServiceImpl implements IMaeEntidadService{

	@Autowired
	private IMaeEntidadDao maeEntidadDao;
	
	@Override
	@Transactional(readOnly = true)	
	public MaeEntidad BuscarById(Integer id){
		return maeEntidadDao.BuscarById(id);
	}

	@Override
	@Transactional(readOnly = true)	
	public List<MaeEntidad> BuscarAllByCompania(Integer compania) {
        return maeEntidadDao.BuscarAllByCompania(compania);
	}

	@Override
	@Transactional(readOnly = true)	
	public List<MaeEntidad> BuscarByCompaniaNombre(Integer compania,String nombre){
        return maeEntidadDao.BuscarByCompaniaNombre(compania,nombre);
	}


	@Override
	@Transactional
	public MaeEntidad save(MaeEntidad maeEntidad) {
		return maeEntidadDao.save(maeEntidad);
	}
	
	@Override
	@Transactional
	public void delete(Integer id) {
		maeEntidadDao.deleteById(id);
	}
	
	@Override
	public int execProcValidaDeleteEntidad(String usuario,Integer cliente,Integer entidad) {
		return maeEntidadDao.execProcValidaDeleteEntidad(usuario,cliente,entidad);
	}
	
	@Override
	public int execProcDeleteEntidad(String usuario,Integer cliente,Integer entidad) {
		return maeEntidadDao.execProcDeleteEntidad(usuario,cliente,entidad);
	}
	
}
