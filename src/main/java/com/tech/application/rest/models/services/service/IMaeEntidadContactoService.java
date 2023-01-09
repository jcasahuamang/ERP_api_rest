package com.tech.application.rest.models.services.service;

import java.util.List;

import com.tech.application.rest.models.entity.MaeEntidadContacto;

public interface IMaeEntidadContactoService {

	public MaeEntidadContacto BuscarById(Integer id);

	public List<MaeEntidadContacto> BuscarAllByEntidad(Integer entidad);
	
	public List<MaeEntidadContacto> BuscarAllByCompania(Integer compania);
	
	public List<MaeEntidadContacto> BuscarByEntidadNombre(Integer entidad,String nombre);


	public MaeEntidadContacto save(MaeEntidadContacto maeEntidadContacto);
	
	public void delete(Integer id);

	public Iterable<MaeEntidadContacto> saveAll(List<MaeEntidadContacto> entidadContactoEntities);
	
	public void deleteAll(List<MaeEntidadContacto> entidadContactoEntities);	
	
}
