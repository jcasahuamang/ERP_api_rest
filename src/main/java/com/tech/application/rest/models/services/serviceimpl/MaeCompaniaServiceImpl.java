package com.tech.application.rest.models.services.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tech.application.rest.models.dao.IMaeCompaniaDao;
import com.tech.application.rest.models.entity.MaeCompania;
import com.tech.application.rest.models.services.service.IMaeCompaniaService;

@Service
public class MaeCompaniaServiceImpl implements IMaeCompaniaService{

	@Autowired
	private IMaeCompaniaDao maeCompaniaDao;
	
	@Override
	@Transactional(readOnly = true)	
	public MaeCompania BuscarById(Integer id){
		return maeCompaniaDao.BuscarById(id);
	}

	
	@Override
	@Transactional(readOnly = true)	
	public List<MaeCompania> BuscarAllByCliente(Integer cliente) {
        return maeCompaniaDao.BuscarAllByCliente(cliente);
	}
	
	@Override
	@Transactional(readOnly = true)	
	public List<MaeCompania> BuscarByClienteNombreLegal(Integer cliente,String nombreLegal){
        return maeCompaniaDao.BuscarByClienteNombreLegal(cliente,nombreLegal);
	}
	
	@Override
	@Transactional(readOnly = true)	
	public List<MaeCompania> BuscarByClienteNombreComercial(Integer cliente,String nombreComercial){
        return maeCompaniaDao.BuscarByClienteNombreComercial(cliente,nombreComercial);
	}	
	
	@Override
	@Transactional(readOnly = true)	
	public MaeCompania BuscarDefaultByCliente(Integer cliente) {
        return maeCompaniaDao.BuscarDefaultByCliente(cliente);
	}
	
	@Override
	@Transactional
	public MaeCompania save(MaeCompania compania) {
		return maeCompaniaDao.save(compania);
	}
	

	@Override
	@Transactional
	public void delete(Integer id) {
		maeCompaniaDao.deleteById(id);
	}
	
	@Override
	public int execProcValidaDeleteCompania(String usuario,Integer cliente,Integer compania) {
		return maeCompaniaDao.execProcValidaDeleteCompania(usuario,cliente,compania);
	}
	
	@Override
	public int execProcDeleteCompania(String usuario,Integer cliente,Integer compania) {
		return maeCompaniaDao.execProcDeleteCompania(usuario,cliente,compania);
	}
	
	@Override
	public int execProcCompaniaConfigura(Integer compania) {
		return maeCompaniaDao.execProcCompaniaConfigura(compania);
	}
	
	
}
