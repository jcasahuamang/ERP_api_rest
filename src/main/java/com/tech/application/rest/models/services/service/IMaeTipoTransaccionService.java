package com.tech.application.rest.models.services.service;

import java.util.List;

import com.tech.application.rest.models.entity.MaeTipoTransaccion;

public interface IMaeTipoTransaccionService {

	public MaeTipoTransaccion BuscarById(Integer id);

	public List<MaeTipoTransaccion> BuscarAllByCompania(Integer compania);

	public List<MaeTipoTransaccion> BuscarByCompaniaNombre(Integer compania,String nombre);

	public MaeTipoTransaccion save(MaeTipoTransaccion tipoTransaccion);
	
	public void delete(Integer id);
	

	public int execProcValidaDeleteTransaccion(String usuario,Integer cliente,Integer transaccion);	
	public int execProcDeleteTransaccion(String usuario,Integer cliente,Integer transaccion);	
	
	
}
