package com.tech.application.rest.models.services.service;

import java.util.List;


import com.tech.application.rest.models.entity.RepAlmaSaldoCierre;

public interface IRepAlmacenService {

	
	public List<RepAlmaSaldoCierre>  execProcRptAlmaSaldoCierre(String usuario,Integer compania,Integer ano,Integer mes,Integer almacen);
	
}
