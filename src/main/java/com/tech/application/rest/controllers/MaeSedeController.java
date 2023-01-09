package com.tech.application.rest.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.tech.application.rest.models.entity.MaeSede;
import com.tech.application.rest.models.entity.Pais;
import com.tech.application.rest.models.services.IPaisService;

import com.tech.application.rest.models.services.service.IMaeSedeService;
import com.tech.application.rest.models.services.serviceimpl.ExcelExportServiceImpl;

@CrossOrigin(origins= "*")
@RestController
@RequestMapping("/sede")
public class MaeSedeController {

	@Autowired
	private IMaeSedeService maeSedeService;
	
	@Autowired
	private IPaisService paisService;
	
	@Autowired
	private ExcelExportServiceImpl excelExportService;	
	
	@GetMapping("/{id}")
	public ResponseEntity<?> BuscarById(@PathVariable Integer id) {
		MaeSede sede= null;
		Map<String, Object> response = new HashMap<>();
		
		try {
			sede = maeSedeService.BuscarById(id);
		} catch(DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		if(sede.getId() == null) {
			response.put("mensaje", "La Sede : ".concat(id.toString().concat(" no existe en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<MaeSede>(sede,HttpStatus.OK);		
	}
	
	@GetMapping("/lista/{compania}")
	public ResponseEntity<?> BuscarAllByCompania(@PathVariable Integer compania){
		List<MaeSede> sede= null;
		Map<String, Object> response = new HashMap<>();		
		
		try {
			sede = maeSedeService.BuscarAllByCompania(compania);
		} catch(DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		/*
		if(sede.size() <=0) {
			response.put("mensaje", "No existen registros para esta Compañia ".concat(compania.toString().concat(" en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.NOT_FOUND);
		}		*/
		return new ResponseEntity<List<MaeSede>>(sede,HttpStatus.OK);
	}		
	
	/*************************************************/
	
	@GetMapping("/listaByNombre/{compania}/{nombre}")
	public ResponseEntity<?> BuscarByCompaniaNombre(@PathVariable Integer compania,@PathVariable String nombre){
		List<MaeSede> sede = null;
		Map<String, Object> response = new HashMap<>();		
		
		try {
			sede = maeSedeService.BuscarByCompaniaNombre(compania,nombre);
		} catch(DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		return new ResponseEntity<List<MaeSede>>(sede,HttpStatus.OK);
	}
	
	/*****************************************************************/
	@GetMapping("/default/{compania}")
	public ResponseEntity<?> BuscarDefaultByCompania(@PathVariable Integer compania){
		MaeSede sede= null;
		Map<String, Object> response = new HashMap<>();		
		
		try {
			sede = maeSedeService.BuscarDefaultByCompania(compania);
		} catch(DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		/*if(sede.getId() == null) {
			response.put("mensaje", "No existen registros con la compañia ".concat(compania.toString().concat(" en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.NOT_FOUND);
		}		*/
		return new ResponseEntity<MaeSede>(sede,HttpStatus.OK);
	}		
	
	/*************************************************************************************************/
	@PostMapping("")
	public ResponseEntity<?> create(@RequestBody MaeSede sede) {
		MaeSede sedeNew = null;
		Map<String, Object> response = new HashMap<>();
		
		try {
			sedeNew = maeSedeService.save(sede);
		}catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar el insert en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("mensaje", "La compania ha sido creada con exito!");		
		response.put("Sede", sedeNew);
		return new ResponseEntity<Map<String, Object>>(response,HttpStatus.CREATED);
	}	
	
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@RequestBody MaeSede sede,@PathVariable Integer id) {
		MaeSede sedeActual = maeSedeService.BuscarById(id);
		MaeSede sedeUpdated = null;
		Map<String, Object> response = new HashMap<>();
		
		if(sedeActual == null) {
			response.put("mensaje", "Error: no se pudo editar, La Sede : ".concat(id.toString().concat(" no existe en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.NOT_FOUND);
		}
		try {
			sedeActual.setIdCompania(sede.getIdCompania());
			sedeActual.setNombre(sede.getNombre());
			sedeActual.setDireccion(sede.getDireccion());
			sedeActual.setTelefono1(sede.getTelefono1());
			sedeActual.setTelefono2(sede.getTelefono2());
			sedeActual.setIdPais(sede.getIdPais());
			sedeActual.setEstado(sede.getEstado());
			
			sedeUpdated = maeSedeService.save(sedeActual);
			
		}catch(DataAccessException e) {
			response.put("mensaje", "Error al actualizar la sede en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "La compañia ha sido actualizado con exito!");		
		response.put("Sede", sedeUpdated);
		return new ResponseEntity<Map<String, Object>>(response,HttpStatus.CREATED);
	}
	
	/*************  ELIMINACION *******************************************************************/
	
	@GetMapping("valdelete/{usuario}/{cliente}/{sede}")
	public int getValidaDeleteCompania(@PathVariable String usuario,@PathVariable Integer cliente,@PathVariable Integer sede){
		int numero = maeSedeService.execProcValidaDeleteSede(usuario,cliente,sede);
		return numero;
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable Integer id) {
		Map<String, Object> response = new HashMap<>();
		
		try {
			maeSedeService.delete(id);			
		}catch(DataAccessException e) {
			response.put("mensaje", "Error al eliminar la sede en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "La sede ha sido eliminado con exito!");		
		return new ResponseEntity<Map<String, Object>>(response,HttpStatus.OK);		
	}		
	
	/*************  EXPORTACION EN EXCEL*******************************************************************/
	
	@GetMapping("/descargar/excel/lista/{compania}")
	public ResponseEntity<Resource> ExportaExcelAllByCompania(@PathVariable Integer compania){
		
		String filename = "ListaSedes.xlsx";
		
		List<MaeSede> sede = null;
		List<Pais> pais = null;

		sede = maeSedeService.BuscarAllByCompania(compania);	
		pais = paisService.findAll();
		
		InputStreamResource file = new InputStreamResource(excelExportService.exportExcelSedeAllByCompania(sede,pais));

	    return ResponseEntity.ok()
		        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + filename)
		        .contentType(MediaType.parseMediaType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"))
		        .body(file);

	}
	
}
