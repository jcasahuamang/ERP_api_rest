package com.tech.application.rest.models.services.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tech.application.rest.models.dao.IMaeAlmacenDao;
import com.tech.application.rest.models.entity.MaeAlmacen;
import com.tech.application.rest.models.services.service.IMaeAlmacenService;

@Service
public class MaeAlmacenServiceImpl implements IMaeAlmacenService{

	@Autowired
	private IMaeAlmacenDao maeAlmacenDao;
	

	@Override
	@Transactional(readOnly = true)	
	public MaeAlmacen BuscarById(Integer id){
		return maeAlmacenDao.BuscarById(id);
	}

	@Override
	@Transactional(readOnly = true)	
	public List<MaeAlmacen> BuscarAllByCompania(Integer compania) {
        return maeAlmacenDao.BuscarAllByCompania(compania);
	}

	@Override
	@Transactional(readOnly = true)	
	public List<MaeAlmacen> BuscarByCompaniaNombre(Integer compania,String nombre){
        return maeAlmacenDao.BuscarByCompaniaNombre(compania,nombre);
	}

	@Override
	@Transactional(readOnly = true)	
	public MaeAlmacen BuscarDefaultByCompania(Integer compania) {
        return maeAlmacenDao.BuscarDefaultByCompania(compania);
	}

	@Override
	@Transactional
	public MaeAlmacen save(MaeAlmacen almacen) {
		return maeAlmacenDao.save(almacen);
	}
	
	@Override
	@Transactional
	public void delete(Integer id) {
		maeAlmacenDao.deleteById(id);
	}
	
	@Override
	public int execProcValidaDeleteAlmacen(String usuario,Integer cliente,Integer almacen) {
		return maeAlmacenDao.execProcValidaDeleteAlmacen(usuario,cliente,almacen);
	}
	
}
