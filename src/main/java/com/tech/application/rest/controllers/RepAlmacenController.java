package com.tech.application.rest.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.tech.application.rest.models.entity.RepAlmaSaldoCierre;
import com.tech.application.rest.models.services.service.IRepAlmacenService;

@CrossOrigin(origins= "*")
@RestController
@RequestMapping("/almareporte")
public class RepAlmacenController {

	@Autowired
	private IRepAlmacenService repAlmacenService;
	

	@GetMapping("/saldocierre/{usuario}/{compania}/{ano}/{mes}/{almacen}")
	public ResponseEntity<?> RptAlmaSaldoCierre(@PathVariable String usuario,@PathVariable Integer compania,
			@PathVariable Integer ano,@PathVariable Integer mes,@PathVariable Integer almacen){

		List<RepAlmaSaldoCierre> reporte= null;
		Map<String, Object> response = new HashMap<>();		
		
		try {
			reporte = repAlmacenService.execProcRptAlmaSaldoCierre(usuario,compania,ano,mes,almacen);
		} catch(DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		return new ResponseEntity<List<RepAlmaSaldoCierre>>(reporte,HttpStatus.OK);
	}		
	
}
