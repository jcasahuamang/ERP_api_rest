package com.tech.application.rest.models.services.service;

import java.util.List;

import com.tech.application.rest.models.entity.MaeEntidad;

public interface IMaeEntidadService {

	public MaeEntidad BuscarById(Integer id);

	public List<MaeEntidad> BuscarAllByCompania(Integer compania);

	public List<MaeEntidad> BuscarByCompaniaNombre(Integer compania,String nombre);


	public MaeEntidad save(MaeEntidad maeEntidad);
	
	public void delete(Integer id);
	
	public int execProcValidaDeleteEntidad(String usuario,Integer cliente,Integer entidad);	
	public int execProcDeleteEntidad(String usuario,Integer cliente,Integer entidad);	
	
}
