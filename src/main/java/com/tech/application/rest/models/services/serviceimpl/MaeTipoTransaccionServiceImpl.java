package com.tech.application.rest.models.services.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.tech.application.rest.models.dao.IMaeTipoTransaccionDao;
import com.tech.application.rest.models.entity.MaeTipoTransaccion;
import com.tech.application.rest.models.services.service.IMaeTipoTransaccionService;

@Service
public class MaeTipoTransaccionServiceImpl implements IMaeTipoTransaccionService{

	@Autowired
	private IMaeTipoTransaccionDao maeTipoTransaccionDao;

	@Override
	@Transactional(readOnly = true)	
	public MaeTipoTransaccion BuscarById(Integer id){
		return maeTipoTransaccionDao.BuscarById(id);
	}

	@Override
	@Transactional(readOnly = true)	
	public List<MaeTipoTransaccion> BuscarAllByCompania(Integer compania) {
        return maeTipoTransaccionDao.BuscarAllByCompania(compania);
	}

	@Override
	@Transactional(readOnly = true)	
	public List<MaeTipoTransaccion> BuscarByCompaniaNombre(Integer compania,String nombre){
        return maeTipoTransaccionDao.BuscarByCompaniaNombre(compania,nombre);
	}


	@Override
	@Transactional
	public MaeTipoTransaccion save(MaeTipoTransaccion tipoTransaccion) {
		return maeTipoTransaccionDao.save(tipoTransaccion);
	}
	
	@Override
	@Transactional
	public void delete(Integer id) {
		maeTipoTransaccionDao.deleteById(id);
	}	
	
	@Override
	public int execProcValidaDeleteTransaccion(String usuario,Integer cliente,Integer transaccion) {
		return maeTipoTransaccionDao.execProcValidaDeleteTransaccion(usuario,cliente,transaccion);
	}
	
	@Override
	public int execProcDeleteTransaccion(String usuario,Integer cliente,Integer transaccion) {
		return maeTipoTransaccionDao.execProcDeleteTransaccion(usuario,cliente,transaccion);
	}
	
}
