package com.tech.application.rest.models.services.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tech.application.rest.models.dao.IMaeEntidadContactoDao;
import com.tech.application.rest.models.entity.MaeEntidadContacto;
import com.tech.application.rest.models.entity.MaeTablaDet;
import com.tech.application.rest.models.services.service.IMaeEntidadContactoService;


@Service
public class MaeEntidadContactoServiceImpl implements IMaeEntidadContactoService{

	@Autowired
	private IMaeEntidadContactoDao maeEntidadContactoDao;
	
	@Override
	@Transactional(readOnly = true)	
	public MaeEntidadContacto BuscarById(Integer id){
		return maeEntidadContactoDao.BuscarById(id);
	}

	@Override
	@Transactional(readOnly = true)	
	public List<MaeEntidadContacto> BuscarAllByEntidad(Integer entidad) {
        return maeEntidadContactoDao.BuscarAllByEntidad(entidad);
	}
	
	@Override
	@Transactional(readOnly = true)	
	public List<MaeEntidadContacto> BuscarAllByCompania(Integer compania) {
        return maeEntidadContactoDao.BuscarAllByCompania(compania);
	}
	

	@Override
	@Transactional(readOnly = true)	
	public List<MaeEntidadContacto> BuscarByEntidadNombre(Integer entidad,String nombre){
        return maeEntidadContactoDao.BuscarByEntidadNombre(entidad,nombre);
	}


	@Override
	@Transactional
	public MaeEntidadContacto save(MaeEntidadContacto maeEntidadContacto) {
		return maeEntidadContactoDao.save(maeEntidadContacto);
	}
	
	@Override
	@Transactional
	public void delete(Integer id) {
		maeEntidadContactoDao.deleteById(id);
	}

	@Override
	@Transactional
	public Iterable<MaeEntidadContacto> saveAll(List<MaeEntidadContacto> entidadContactoEntities){
		return maeEntidadContactoDao.saveAll(entidadContactoEntities);
	}	
	
	@Override
	@Transactional
	public void deleteAll(List<MaeEntidadContacto> entidadContactoEntities){
		maeEntidadContactoDao.deleteAll(entidadContactoEntities);
	}	
	
}
