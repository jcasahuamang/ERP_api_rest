package com.tech.application.rest.models.services.service;

import java.util.List;

import com.tech.application.rest.models.entity.MaeSede;

public interface IMaeSedeService {


	public MaeSede BuscarById(Integer id);

	public List<MaeSede> BuscarAllByCompania(Integer compania);

	public List<MaeSede> BuscarByCompaniaNombre(Integer compania,String nombre);


	public MaeSede BuscarDefaultByCompania(Integer compania);
	
	public MaeSede save(MaeSede sede);
	
	public void delete(Integer id);
	
	public int execProcValidaDeleteSede(String usuario,Integer cliente,Integer sede);	
}
