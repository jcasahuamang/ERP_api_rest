package com.tech.application.rest.models.services.service;

import java.util.List;


import com.tech.application.rest.models.entity.RepMaeEntidad;

public interface IRepMaeEntidadService {

	
	public List<RepMaeEntidad>  execProcRptMaeEntidad(String usuario,Integer compania);
	
}
