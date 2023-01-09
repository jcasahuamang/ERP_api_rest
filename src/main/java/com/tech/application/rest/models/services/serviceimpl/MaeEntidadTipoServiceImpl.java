package com.tech.application.rest.models.services.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tech.application.rest.models.dao.IMaeEntidadContactoDao;
import com.tech.application.rest.models.dao.IMaeEntidadTipoDao;
import com.tech.application.rest.models.entity.MaeEntidadContacto;
import com.tech.application.rest.models.entity.MaeEntidadTipo;
import com.tech.application.rest.models.entity.MaeTablaDet;
import com.tech.application.rest.models.services.service.IMaeEntidadContactoService;
import com.tech.application.rest.models.services.service.IMaeEntidadTipoService;

@Service
public class MaeEntidadTipoServiceImpl implements IMaeEntidadTipoService{

	@Autowired
	private IMaeEntidadTipoDao maeEntidadTipoDao;
	
	@Override
	@Transactional(readOnly = true)	
	public MaeEntidadTipo BuscarById(Integer id){
		return maeEntidadTipoDao.BuscarById(id);
	}

	@Override
	@Transactional(readOnly = true)	
	public List<MaeEntidadTipo> BuscarAllByEntidad(Integer entidad) {
        return maeEntidadTipoDao.BuscarAllByEntidad(entidad);
	}

	@Override
	@Transactional
	public MaeEntidadTipo save(MaeEntidadTipo entidadTipo) {
		return maeEntidadTipoDao.save(entidadTipo);
	}
	
	@Override
	@Transactional
	public void delete(Integer id) {
		maeEntidadTipoDao.deleteById(id);
	}
	
	@Override
	@Transactional
	public Iterable<MaeEntidadTipo> saveAll(List<MaeEntidadTipo> entidadTipoEntities){
		return maeEntidadTipoDao.saveAll(entidadTipoEntities);
	}	
	
	@Override
	@Transactional
	public void deleteAll(List<MaeEntidadTipo> entidadTipoEntities){
		maeEntidadTipoDao.deleteAll(entidadTipoEntities);
	}	
	
}
