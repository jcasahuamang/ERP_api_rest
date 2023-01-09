package com.tech.application.rest.models.services.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tech.application.rest.models.dao.IRepAlmaSaldoCierreDao;
import com.tech.application.rest.models.entity.RepAlmaSaldoCierre;
import com.tech.application.rest.models.services.service.IRepAlmacenService;

@Service
public class RepAlmacenServiceImpl implements IRepAlmacenService {

	@Autowired
	private IRepAlmaSaldoCierreDao RepAlmaSaldoCierreDao;
	
	@Override                       
	public List<RepAlmaSaldoCierre> execProcRptAlmaSaldoCierre(String usuario,Integer compania,Integer ano,Integer mes,Integer almacen) {
		return RepAlmaSaldoCierreDao.execProcRptAlmaSaldoCierre(usuario,compania,ano,mes,almacen);
	}
	
}
