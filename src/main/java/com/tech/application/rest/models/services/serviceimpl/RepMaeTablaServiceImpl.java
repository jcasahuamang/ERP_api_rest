package com.tech.application.rest.models.services.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tech.application.rest.models.dao.IRepMaeTablaDao;
import com.tech.application.rest.models.entity.RepMaeTabla;
import com.tech.application.rest.models.services.service.IRepMaeTablaService;

@Service
public class RepMaeTablaServiceImpl implements IRepMaeTablaService{

	@Autowired
	private IRepMaeTablaDao RepMaeTablaDao;
	
	@Override
	public List<RepMaeTabla> execProcRptMaeTabla(String usuario,Integer compania) {
		return RepMaeTablaDao.execProcRptMaeTabla(usuario,compania);
	}
	
}
