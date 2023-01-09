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


import com.tech.application.rest.models.entity.MaeEntidad;
import com.tech.application.rest.models.entity.MaeEntidadContacto;
import com.tech.application.rest.models.entity.RepMaeEntidad;
import com.tech.application.rest.models.services.service.IMaeEntidadContactoService;
import com.tech.application.rest.models.services.service.IMaeEntidadService;
import com.tech.application.rest.models.services.service.IRepMaeEntidadService;
import com.tech.application.rest.models.services.serviceimpl.ExcelExportServiceImpl;

@CrossOrigin(origins= "*")
@RestController
@RequestMapping("/entidad")
public class MaeEntidadController {
	
	@Autowired
	private IMaeEntidadService maeEntidadService;
	
	@Autowired
	private IMaeEntidadContactoService maeEntidadContactoService;
	
	@Autowired
	private IRepMaeEntidadService repMaeEntidadService;
	
	@Autowired
	private ExcelExportServiceImpl excelExportService;	
	
	@GetMapping("/{id}")
	public ResponseEntity<?> BuscarById(@PathVariable Integer id) {
		MaeEntidad maeEntidad= null;
		Map<String, Object> response = new HashMap<>();
		
		try {
			maeEntidad = maeEntidadService.BuscarById(id);
		} catch(DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
//		if(maeEntidad.getId() == null) {
		if(maeEntidad == null) {		
			response.put("mensaje", "La Entidad : ".concat(id.toString().concat(" no existe en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<MaeEntidad>(maeEntidad,HttpStatus.OK);		
	}
	
	@GetMapping("/lista/{compania}")
	public ResponseEntity<?> BuscarAllByCompania(@PathVariable Integer compania){
		List<MaeEntidad> maeEntidad= null;
		Map<String, Object> response = new HashMap<>();		
		
		try {
			maeEntidad = maeEntidadService.BuscarAllByCompania(compania);
		} catch(DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		return new ResponseEntity<List<MaeEntidad>>(maeEntidad,HttpStatus.OK);
	}		
	
	/*************************************************/
	
	@GetMapping("/listaByNombre/{compania}/{nombre}")
	public ResponseEntity<?> BuscarByCompaniaNombre(@PathVariable Integer compania,@PathVariable String nombre){
		List<MaeEntidad> maeEntidad = null;
		Map<String, Object> response = new HashMap<>();		
		
		try {
			maeEntidad = maeEntidadService.BuscarByCompaniaNombre(compania,nombre);
		} catch(DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		return new ResponseEntity<List<MaeEntidad>>(maeEntidad,HttpStatus.OK);
	}	
	
	/*************************************************************************************************/
	@PostMapping("")
	public ResponseEntity<?> create(@RequestBody MaeEntidad entidad) {
		MaeEntidad entidadNew = null;
		Map<String, Object> response = new HashMap<>();
		
		try {
			entidadNew = maeEntidadService.save(entidad);
		}catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar el insert en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("mensaje", "El auxiliar ha sido creado con exito!");		
		response.put("Entidad", entidadNew);
//		return new ResponseEntity<Map<String, Object>>(response,HttpStatus.CREATED);
		return new ResponseEntity<MaeEntidad>(entidadNew,HttpStatus.CREATED);
	}	
	
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@RequestBody MaeEntidad entidad,@PathVariable Integer id) {
		MaeEntidad entidadActual = maeEntidadService.BuscarById(id);
		MaeEntidad entidadUpdated = null;
		Map<String, Object> response = new HashMap<>();
		
		if(entidadActual == null) {
			response.put("mensaje", "Error: no se pudo editar, El Auxiliar : ".concat(id.toString().concat(" no existe en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.NOT_FOUND);
		}
		try {
			entidadActual.setIdCompania(entidad.getIdCompania());
			entidadActual.setNombrePrimero(entidad.getNombrePrimero());
			entidadActual.setNombreSegundo(entidad.getNombreSegundo());
			entidadActual.setApellidoPaterno(entidad.getApellidoPaterno());
			entidadActual.setApellidoMaterno(entidad.getApellidoMaterno());
			entidadActual.setNombreLegal(entidad.getNombreLegal());
			entidadActual.setNombreComercial(entidad.getNombreComercial());
			entidadActual.setTipoDocumento(entidad.getTipoDocumento());
			entidadActual.setNumeroDocumento(entidad.getNumeroDocumento());
			entidadActual.setWebpage(entidad.getWebpage());
			entidadActual.setEmail(entidad.getEmail());
			entidadActual.setTelefono1(entidad.getTelefono1());
			entidadActual.setTelefono2(entidad.getTelefono2());
			entidadActual.setCodigoHabido(entidad.getCodigoHabido());
			entidadActual.setIdPais(entidad.getIdPais());
			entidadActual.setEstado(entidad.getEstado());
						
			entidadUpdated = maeEntidadService.save(entidadActual);
			
		}catch(DataAccessException e) {
			response.put("mensaje", "Error al actualizar la sede en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "El auxiliar ha sido actualizado con exito!");		
		response.put("Entidad", entidadUpdated);
		return new ResponseEntity<Map<String, Object>>(response,HttpStatus.CREATED);
	}
	
	/*************  ELIMINACION *******************************************************************/

	@GetMapping("valdelete/{usuario}/{cliente}/{entidad}")
	public int getValidaDeleteEntidad(@PathVariable String usuario,@PathVariable Integer cliente,@PathVariable Integer entidad){
		int numero = maeEntidadService.execProcValidaDeleteEntidad(usuario,cliente,entidad);

		return numero;
	}
	
	/*
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable Integer id) {
		Map<String, Object> response = new HashMap<>();
		
		try {
			maeEntidadService.delete(id);			
		}catch(DataAccessException e) {
			response.put("mensaje", "Error al eliminar la entidad en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "La entidad ha sido eliminado con exito!");		
		return new ResponseEntity<Map<String, Object>>(response,HttpStatus.OK);		
	}			
	*/

	@GetMapping("/delete/{usuario}/{cliente}/{entidad}")
	public ResponseEntity<?> delete(@PathVariable String usuario,@PathVariable Integer cliente,@PathVariable Integer entidad) {
		Map<String, Object> response = new HashMap<>();
		
		try {
			int numero = maeEntidadService.execProcDeleteEntidad(usuario,cliente,entidad);			
		}catch(DataAccessException e) {
			response.put("mensaje", "Error al eliminar la compañia en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "La Auxiliar ha sido eliminado con exito!");		
		return new ResponseEntity<Map<String, Object>>(response,HttpStatus.OK);		
	}	
	
	
	/*************  EXPORTACION EN EXCEL*******************************************************************/
	@GetMapping("/descargar/excel/lista/{compania}")
	public ResponseEntity<Resource> ExportaExcelAllByCompania(@PathVariable Integer compania){
		
		String filename = "ListaAuxiliares.xlsx";
		String usuario = "A";
		
		List<RepMaeEntidad> entidad = null;
		List<MaeEntidadContacto> contacto = null;		

		entidad = repMaeEntidadService.execProcRptMaeEntidad(usuario,compania);	
		contacto = maeEntidadContactoService.BuscarAllByCompania(compania);	
			
		InputStreamResource file = new InputStreamResource(excelExportService.exportExcelMaeEntidadAllByCompania(entidad,contacto));

	    return ResponseEntity.ok()
		        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + filename)
		        .contentType(MediaType.parseMediaType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"))
		        .body(file);

	}

	@GetMapping("/listaDPF/{compania}")
	public ResponseEntity<?> ExportaPDFByCompania(@PathVariable Integer compania){
		String usuario = "A";
		List<RepMaeEntidad> entidad = null;
		Map<String, Object> response = new HashMap<>();		
		
		try {
			entidad = repMaeEntidadService.execProcRptMaeEntidad(usuario,compania);				
		} catch(DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		return new ResponseEntity<List<RepMaeEntidad>>(entidad,HttpStatus.OK);
	}		
	
}
