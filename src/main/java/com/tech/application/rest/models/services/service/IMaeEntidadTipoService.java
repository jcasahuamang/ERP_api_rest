package com.tech.application.rest.models.services.service;

import java.util.List;

import com.tech.application.rest.models.entity.MaeEntidadTipo;

public interface IMaeEntidadTipoService {
	
	public MaeEntidadTipo BuscarById(Integer id);

	public List<MaeEntidadTipo> BuscarAllByEntidad(Integer entidad);


	public MaeEntidadTipo save(MaeEntidadTipo entidadTipo);
	
	public void delete(Integer id);

	public Iterable<MaeEntidadTipo> saveAll(List<MaeEntidadTipo> entidadTipoEntities);
	
	public void deleteAll(List<MaeEntidadTipo> entidadTipoEntities);
	
}
