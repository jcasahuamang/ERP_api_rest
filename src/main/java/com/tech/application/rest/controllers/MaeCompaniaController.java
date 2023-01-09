package com.tech.application.rest.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;

import org.springframework.beans.factory.annotation.Autowired;
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


import com.tech.application.rest.models.entity.MaeCompania;

import com.tech.application.rest.models.entity.Pais;
import com.tech.application.rest.models.services.IPaisService;
import com.tech.application.rest.models.services.service.IMaeCompaniaService;
import com.tech.application.rest.models.services.serviceimpl.ExcelExportServiceImpl;


@CrossOrigin(origins= "*")
@RestController
@RequestMapping("/compania")
public class MaeCompaniaController {

	@Autowired
	private IMaeCompaniaService maeCompaniaService;
	
	@Autowired
	private IPaisService paisService;
	
	@Autowired
	private ExcelExportServiceImpl excelExportService;	

/*
	@GetMapping("/{id}")
	public Optional<MaeCompania> BuscarById(@PathVariable Integer id){
		return maeCompaniaService.BuscarById(id);
	}	
	*/
	@GetMapping("/{id}")
	public ResponseEntity<?> BuscarById(@PathVariable Integer id) {
		MaeCompania compania= null;
		Map<String, Object> response = new HashMap<>();
		
		try {
			compania = maeCompaniaService.BuscarById(id);
		} catch(DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		if(compania.getId() == null) {
			response.put("mensaje", "La compañia : ".concat(id.toString().concat(" no existe en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<MaeCompania>(compania,HttpStatus.OK);		
	}
	
	/*
	@GetMapping("/lista/{cliente}")
	public ResponseEntity<MaeCompania> BuscarAllByCliente(@PathVariable Integer cliente){
		List<MaeCompania> compania = maeCompaniaService.BuscarAllByCliente(cliente);
		return new ResponseEntity(compania,HttpStatus.OK);

	}	
	*/
	@GetMapping("/lista/{cliente}")
	public ResponseEntity<?> BuscarAllByCliente(@PathVariable Integer cliente){
		List<MaeCompania> compania= null;
		Map<String, Object> response = new HashMap<>();		
		
		try {
			compania = maeCompaniaService.BuscarAllByCliente(cliente);
		} catch(DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		if(compania.size() <=0) {
			response.put("mensaje", "No existen registros con el cliente ".concat(cliente.toString().concat(" en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.NOT_FOUND);
		}		
		return new ResponseEntity<List<MaeCompania>>(compania,HttpStatus.OK);
	}		
	
	/*************************************************/

	@GetMapping("/listaByNombreLegal/{cliente}/{nombreLegal}")
	public ResponseEntity<?> BuscarAllByClienteNombreLegal(@PathVariable Integer cliente,@PathVariable String nombreLegal){
		List<MaeCompania> compania= null;
		Map<String, Object> response = new HashMap<>();		
		
		try {
			compania = maeCompaniaService.BuscarByClienteNombreLegal(cliente,nombreLegal);
		} catch(DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		/*
		if(compania.size() <=0) {
			response.put("mensaje", "No existen registros con el cliente ".concat(cliente.toString().concat(" en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.NOT_FOUND);
		}		
		*/
		return new ResponseEntity<List<MaeCompania>>(compania,HttpStatus.OK);
	}		
	

	@GetMapping("/listaByNombreComercial/{cliente}/{nombreComercial}")
	public ResponseEntity<?> BuscarAllByClienteNombreComercial(@PathVariable Integer cliente,@PathVariable String nombreComercial){
		List<MaeCompania> compania= null;
		Map<String, Object> response = new HashMap<>();		
		
		try {
			compania = maeCompaniaService.BuscarByClienteNombreComercial(cliente,nombreComercial);
		} catch(DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		/*
		if(compania.size() <=0) {
			response.put("mensaje", "No existen registros con el cliente ".concat(cliente.toString().concat(" en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.NOT_FOUND);
		}		
		*/
		return new ResponseEntity<List<MaeCompania>>(compania,HttpStatus.OK);
	}		
	/*************************************************/
	@GetMapping("/existenomlegal/{cliente}/{nombreLegal}")
	public Boolean existeByClienteNombreLegal(@PathVariable Integer cliente,@PathVariable String nombreLegal){
		List<MaeCompania> compania = maeCompaniaService.BuscarByClienteNombreLegal(cliente,nombreLegal);

		if(compania.size() > 0) {
			//1L
			return true;
		}else {
			//0L
			return false;
		}
	}
	
	@GetMapping("/existenomcomercial/{cliente}/{nombreComercial}")
	public Boolean existeByClienteNombreComercial(@PathVariable Integer cliente,@PathVariable String nombreComercial){
		List<MaeCompania> compania = maeCompaniaService.BuscarByClienteNombreComercial(cliente,nombreComercial);

		if(compania.size() > 0) {
			//1L
			return true;
		}else {
			//0L
			return false;
		}
	}	
	/*****************************************************************/
	@GetMapping("/default/{cliente}")
	public ResponseEntity<?> BuscarDefaultByCliente(@PathVariable Integer cliente){
		MaeCompania compania= null;
		Map<String, Object> response = new HashMap<>();		
		
		try {
			compania = maeCompaniaService.BuscarDefaultByCliente(cliente);
		} catch(DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		if(compania.getId() == null) {
			response.put("mensaje", "No existen registros con el cliente ".concat(cliente.toString().concat(" en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.NOT_FOUND);
		}		
		return new ResponseEntity<MaeCompania>(compania,HttpStatus.OK);
	}		
	
	/*************************************************************************************************/
	@PostMapping("")
	public ResponseEntity<?> create(@RequestBody MaeCompania compania) {
		MaeCompania companniaNew = null;
		Map<String, Object> response = new HashMap<>();
		
		try {
			companniaNew = maeCompaniaService.save(compania);
			
			int numero = maeCompaniaService.execProcCompaniaConfigura(companniaNew.getId());
			
		}catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar el insert en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("mensaje", "La compania ha sido creada con exito!");		
		response.put("Compania", companniaNew);
		return new ResponseEntity<Map<String, Object>>(response,HttpStatus.CREATED);
	}	
	
	
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@RequestBody MaeCompania compania,@PathVariable Integer id) {
		MaeCompania companiaActual = maeCompaniaService.BuscarById(id);
		MaeCompania companiaUpdated = null;
		Map<String, Object> response = new HashMap<>();
		
		if(companiaActual == null) {
			response.put("mensaje", "Error: no se pudo editar, La compania : ".concat(id.toString().concat(" no existe en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.NOT_FOUND);
		}
		try {
			companiaActual.setIdCliente(compania.getIdCliente());
			companiaActual.setNombreLegal(compania.getNombreLegal());
			companiaActual.setNombreComercial(compania.getNombreComercial());
			companiaActual.setNumeroRegLegal(compania.getNumeroRegLegal());
			companiaActual.setTelefono1(compania.getTelefono1());
			companiaActual.setTelefono2(compania.getTelefono2());
			companiaActual.setWebpage(compania.getWebpage());
			companiaActual.setIdPais(compania.getIdPais());
			companiaActual.setEstado(compania.getEstado());
			
			companiaUpdated = maeCompaniaService.save(companiaActual);
			
		}catch(DataAccessException e) {
			response.put("mensaje", "Error al actualizar la compañia en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "La compañia ha sido actualizado con exito!");		
		response.put("Compañia", companiaUpdated);
		return new ResponseEntity<Map<String, Object>>(response,HttpStatus.CREATED);
	}
	
	/*************  ELIMINACION *******************************************************************/
	
	@GetMapping("valdelete/{usuario}/{cliente}/{compania}")
	public int getValidaDeleteCompania(@PathVariable String usuario,@PathVariable Integer cliente,@PathVariable Integer compania){
		int numero = maeCompaniaService.execProcValidaDeleteCompania(usuario,cliente,compania);

		return numero;
	}
	
	//@DeleteMapping("/delete/{usuario}/{cliente}/{compania}")
	@GetMapping("/delete/{usuario}/{cliente}/{compania}")
	public ResponseEntity<?> delete(@PathVariable String usuario,@PathVariable Integer cliente,@PathVariable Integer compania) {
		Map<String, Object> response = new HashMap<>();
		
		try {
			int numero = maeCompaniaService.execProcDeleteCompania(usuario,cliente,compania);			
		}catch(DataAccessException e) {
			response.put("mensaje", "Error al eliminar la compañia en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "La compañia ha sido eliminado con exito!");		
		return new ResponseEntity<Map<String, Object>>(response,HttpStatus.OK);		
	}	
	
	/*************  EXPORTACION EN EXCEL*******************************************************************/
	
	@GetMapping("/descargar/excel/lista/{cliente}")
	public ResponseEntity<Resource> ExportaExcelAllByCliente(@PathVariable Integer cliente){
		
		String filename = "ListaCompanias.xlsx";
		
		List<MaeCompania> compania= null;
		List<Pais> pais = null;

		compania = maeCompaniaService.BuscarAllByCliente(cliente);	
		pais = paisService.findAll();
		
		InputStreamResource file = new InputStreamResource(excelExportService.exportExcelCompaniaAllByCliente(compania,pais));
		/*
	    return ResponseEntity.ok()
		        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + filename)
		        .contentType(MediaType.parseMediaType("application/vnd.ms-excel"))
		        .body(file);
	    */
	    return ResponseEntity.ok()
		        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + filename)
		        .contentType(MediaType.parseMediaType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"))
		        .body(file);
	    
	}		
	
}
