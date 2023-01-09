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

import com.tech.application.rest.models.entity.MaeAlmacen;
import com.tech.application.rest.models.entity.Pais;
import com.tech.application.rest.models.services.IPaisService;

import com.tech.application.rest.models.services.service.IMaeAlmacenService;
import com.tech.application.rest.models.services.serviceimpl.ExcelExportServiceImpl;

@CrossOrigin(origins= "*")
@RestController
@RequestMapping("/almacen")
public class MaeAlmacenController {

	@Autowired
	private IMaeAlmacenService maeAlmacenService;
	
	@Autowired
	private IPaisService paisService;
	
	@Autowired
	private ExcelExportServiceImpl excelExportService;	
	
	@GetMapping("/{id}")
	public ResponseEntity<?> BuscarById(@PathVariable Integer id) {
		MaeAlmacen almacen= null;
		Map<String, Object> response = new HashMap<>();
		
		try {
			almacen = maeAlmacenService.BuscarById(id);
		} catch(DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		if(almacen.getId() == null) {
			response.put("mensaje", "El Almacén : ".concat(id.toString().concat(" no existe en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<MaeAlmacen>(almacen,HttpStatus.OK);		
	}	
	

	@GetMapping("/lista/{compania}")
	public ResponseEntity<?> BuscarAllByCompania(@PathVariable Integer compania){
		List<MaeAlmacen> almacen = null;
		Map<String, Object> response = new HashMap<>();		
		
		try {
			almacen = maeAlmacenService.BuscarAllByCompania(compania);
		} catch(DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		return new ResponseEntity<List<MaeAlmacen>>(almacen,HttpStatus.OK);
	}		
	
	/*************************************************/
	
	@GetMapping("/listaByNombre/{compania}/{nombre}")
	public ResponseEntity<?> BuscarByCompaniaNombre(@PathVariable Integer compania,@PathVariable String nombre){
		List<MaeAlmacen> almacen = null;
		Map<String, Object> response = new HashMap<>();		
		
		try {
			almacen = maeAlmacenService.BuscarByCompaniaNombre(compania,nombre);
		} catch(DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		return new ResponseEntity<List<MaeAlmacen>>(almacen,HttpStatus.OK);
	}
	
	/*****************************************************************/
	@GetMapping("/default/{compania}")
	public ResponseEntity<?> BuscarDefaultByCompania(@PathVariable Integer compania){
		MaeAlmacen almacen = null;
		Map<String, Object> response = new HashMap<>();		
		
		try {
			almacen = maeAlmacenService.BuscarDefaultByCompania(compania);
		} catch(DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		return new ResponseEntity<MaeAlmacen>(almacen,HttpStatus.OK);
	}		
	
	/*************************************************************************************************/
	@PostMapping("")
	public ResponseEntity<?> create(@RequestBody MaeAlmacen almacen) {
		MaeAlmacen almacenNew = null;
		Map<String, Object> response = new HashMap<>();
		
		try {
			almacenNew = maeAlmacenService.save(almacen);
		}catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar el insert en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("mensaje", "El Almacén ha sido creada con exito!");		
		response.put("Almacen", almacenNew);
		return new ResponseEntity<Map<String, Object>>(response,HttpStatus.CREATED);
	}	
	
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@RequestBody MaeAlmacen almacen,@PathVariable Integer id) {
		MaeAlmacen almacenActual = maeAlmacenService.BuscarById(id);
		MaeAlmacen almacenUpdated = null;
		Map<String, Object> response = new HashMap<>();
		
		if(almacenActual == null) {
			response.put("mensaje", "Error: no se pudo editar, El Almacén : ".concat(id.toString().concat(" no existe en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.NOT_FOUND);
		}
		try {
			almacenActual.setIdCompania(almacen.getIdCompania());
			almacenActual.setNombre(almacen.getNombre());
			almacenActual.setTipo(almacen.getTipo());
			almacenActual.setDireccion(almacen.getDireccion());
			almacenActual.setIndVirtual(almacen.getIndVirtual());
			almacenActual.setIdPais(almacen.getIdPais());
			almacenActual.setEstado(almacen.getEstado());
			
			almacenUpdated = maeAlmacenService.save(almacenActual);
			
		}catch(DataAccessException e) {
			response.put("mensaje", "Error al actualizar el almacen en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "El Almacén ha sido actualizado con exito!");		
		response.put("Almacén", almacenUpdated);
		return new ResponseEntity<Map<String, Object>>(response,HttpStatus.CREATED);
	}	
	
	/*************  ELIMINACION *******************************************************************/
	
	@GetMapping("valdelete/{usuario}/{cliente}/{almacen}")
	public int getValidaDeleteCompania(@PathVariable String usuario,@PathVariable Integer cliente,@PathVariable Integer almacen){
		int numero = maeAlmacenService.execProcValidaDeleteAlmacen(usuario,cliente,almacen);
		return numero;
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable Integer id) {
		Map<String, Object> response = new HashMap<>();
		
		try {
			maeAlmacenService.delete(id);			
		}catch(DataAccessException e) {
			response.put("mensaje", "Error al eliminar el almacen en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "El almacen ha sido eliminado con exito!");		
		return new ResponseEntity<Map<String, Object>>(response,HttpStatus.OK);		
	}		
	
	/*************  EXPORTACION EN EXCEL*******************************************************************/
	@GetMapping("/descargar/excel/lista/{compania}")
	public ResponseEntity<Resource> ExportaExcelAllByCompania(@PathVariable Integer compania){
		
		String filename = "ListaAlmacenes.xlsx";
		
		List<MaeAlmacen> almacen = null;
		List<Pais> pais = null;

		almacen = maeAlmacenService.BuscarAllByCompania(compania);	
		pais = paisService.findAll();
		
		InputStreamResource file = new InputStreamResource(excelExportService.exportExcelAlmacenAllByCompania(almacen,pais));

	    return ResponseEntity.ok()
		        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + filename)
		        .contentType(MediaType.parseMediaType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"))
		        .body(file);

	}
	
}
