package com.tech.application.rest.models.services.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tech.application.rest.models.dao.IRepMaeEntidadDao;
import com.tech.application.rest.models.entity.RepMaeEntidad;
import com.tech.application.rest.models.services.service.IRepMaeEntidadService;

@Service
public class RepMaeEntidadServiceImpl implements IRepMaeEntidadService{

	@Autowired
	private IRepMaeEntidadDao RepMaeEntidadDao;

	@Override
	public List<RepMaeEntidad> execProcRptMaeEntidad(String usuario,Integer compania) {
		return RepMaeEntidadDao.execProcRptMaeEntidad(usuario,compania);
	}
	
}
