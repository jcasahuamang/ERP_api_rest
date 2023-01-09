package com.tech.application.rest.models.services.service;

import java.util.List;


import com.tech.application.rest.models.entity.RepMaeTabla;

public interface IRepMaeTablaService {

	public List<RepMaeTabla>  execProcRptMaeTabla(String usuario,Integer compania);
}
