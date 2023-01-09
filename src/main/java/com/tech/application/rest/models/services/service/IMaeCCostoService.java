package com.tech.application.rest.models.services.service;

import java.util.List;

import com.tech.application.rest.models.entity.MaeCCosto;

public interface IMaeCCostoService {

	public MaeCCosto BuscarById(Integer id);

	public List<MaeCCosto> BuscarAllByCompania(Integer compania);

	public List<MaeCCosto> BuscarByCompaniaNombre(Integer compania,String nombre);


	public MaeCCosto BuscarDefaultByCompania(Integer compania);
	
	public MaeCCosto save(MaeCCosto ccosto);
	
	public void delete(Integer id);
	
	public int execProcValidaDeleteCCosto(String usuario,Integer cliente,Integer ccosto);
	
}
