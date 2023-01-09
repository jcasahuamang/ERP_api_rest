package com.tech.application.rest.models.services.service;

import java.util.List;

import com.tech.application.rest.models.entity.MaeAlmacen;

public interface IMaeAlmacenService {

	
	public MaeAlmacen BuscarById(Integer id);

	public List<MaeAlmacen> BuscarAllByCompania(Integer compania);

	public List<MaeAlmacen> BuscarByCompaniaNombre(Integer compania,String nombre);


	public MaeAlmacen BuscarDefaultByCompania(Integer compania);
	
	public MaeAlmacen save(MaeAlmacen almacen);
	
	public void delete(Integer id);
	
	public int execProcValidaDeleteAlmacen(String usuario,Integer cliente,Integer almacen);	
	
}
