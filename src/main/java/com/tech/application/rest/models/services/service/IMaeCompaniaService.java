package com.tech.application.rest.models.services.service;
import java.util.List;

import com.tech.application.rest.models.entity.MaeCompania;

public interface IMaeCompaniaService {

	public MaeCompania BuscarById(Integer id);
	public List<MaeCompania> BuscarAllByCliente(Integer cliente);

	public List<MaeCompania> BuscarByClienteNombreLegal(Integer cliente,String nombreLegal);

	public List<MaeCompania> BuscarByClienteNombreComercial(Integer cliente,String nombreComercial);

	public MaeCompania BuscarDefaultByCliente(Integer cliente);
	
	public MaeCompania save(MaeCompania compania);
	
	public void delete(Integer id);

	public int execProcValidaDeleteCompania(String usuario,Integer cliente,Integer compania);	
	public int execProcDeleteCompania(String usuario,Integer cliente,Integer compania);	
	
	public int execProcCompaniaConfigura(Integer compania);	
	
}
