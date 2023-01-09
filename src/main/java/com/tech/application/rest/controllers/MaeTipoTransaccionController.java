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

import com.tech.application.rest.models.entity.MaeCCosto;
import com.tech.application.rest.models.entity.MaeEntidad;
import com.tech.application.rest.models.entity.MaeTablaDet;
import com.tech.application.rest.models.entity.MaeTipoTransaccion;
import com.tech.application.rest.models.entity.configurations.TablaGeneral;
import com.tech.application.rest.models.services.service.IMaeEntidadService;
import com.tech.application.rest.models.services.service.IMaeTablaDetService;
import com.tech.application.rest.models.services.service.IMaeTipoTransaccionService;
import com.tech.application.rest.models.services.serviceimpl.ExcelExportServiceImpl;

@CrossOrigin(origins= "*")
@RestController
@RequestMapping("/tipotransaccion")
public class MaeTipoTransaccionController {

	@Autowired
	private IMaeTipoTransaccionService maeTipoTransaccionService;
	
	@Autowired
	private IMaeTablaDetService maeTablaDetService;
	
	@Autowired
	private ExcelExportServiceImpl excelExportService;	

	
	@GetMapping("/{id}")
	public ResponseEntity<?> BuscarById(@PathVariable Integer id) {
		MaeTipoTransaccion maeTipoTransaccion= null;
		Map<String, Object> response = new HashMap<>();
		
		try {
			maeTipoTransaccion = maeTipoTransaccionService.BuscarById(id);
		} catch(DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
			
		}

		if(maeTipoTransaccion == null) {		
			response.put("mensaje", "El Tipo de transaccion : ".concat(id.toString().concat(" no existe en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<MaeTipoTransaccion>(maeTipoTransaccion,HttpStatus.OK);		
	}
	
	@GetMapping("/lista/{compania}")
	public ResponseEntity<?> BuscarAllByCompania(@PathVariable Integer compania){
		List<MaeTipoTransaccion> maeTipoTransaccion= null;
		Map<String, Object> response = new HashMap<>();		
		
		try {
			maeTipoTransaccion = maeTipoTransaccionService.BuscarAllByCompania(compania);
		} catch(DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		return new ResponseEntity<List<MaeTipoTransaccion>>(maeTipoTransaccion,HttpStatus.OK);
	}		
	
	/*************************************************/
	
	@GetMapping("/listaByNombre/{compania}/{nombre}")
	public ResponseEntity<?> BuscarByCompaniaNombre(@PathVariable Integer compania,@PathVariable String nombre){
		List<MaeTipoTransaccion> maeTipoTransaccion = null;
		Map<String, Object> response = new HashMap<>();		
		
		try {
			maeTipoTransaccion = maeTipoTransaccionService.BuscarByCompaniaNombre(compania,nombre);
		} catch(DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		return new ResponseEntity<List<MaeTipoTransaccion>>(maeTipoTransaccion,HttpStatus.OK);
	}	

	/*************************************************************************************************/
	@PostMapping("")
	public ResponseEntity<?> create(@RequestBody MaeTipoTransaccion tipoTransaccion) {
		MaeTipoTransaccion tipoTransaccionNew = null;
		Map<String, Object> response = new HashMap<>();
		
		try {
			tipoTransaccionNew = maeTipoTransaccionService.save(tipoTransaccion);
		}catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar el insert en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("mensaje", "El tipo de transaccion ha sido creado con exito!");		
		response.put("Tipo", tipoTransaccionNew);
//		return new ResponseEntity<Map<String, Object>>(response,HttpStatus.CREATED);
		return new ResponseEntity<MaeTipoTransaccion>(tipoTransaccionNew,HttpStatus.CREATED);
	}	
	
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@RequestBody MaeTipoTransaccion tipoTransaccion,@PathVariable Integer id) {
		MaeTipoTransaccion tipoTransaccionActual = maeTipoTransaccionService.BuscarById(id);
		MaeTipoTransaccion tipoTransaccionUpdated = null;
		Map<String, Object> response = new HashMap<>();
		
		if(tipoTransaccionActual == null) {
			response.put("mensaje", "Error: no se pudo editar, El tipo : ".concat(id.toString().concat(" no existe en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.NOT_FOUND);
		}
		try {
			tipoTransaccionActual.setIdCompania(tipoTransaccion.getIdCompania());
			tipoTransaccionActual.setNombre(tipoTransaccion.getNombre());
			tipoTransaccionActual.setAbreviatura(tipoTransaccion.getAbreviatura());
			tipoTransaccionActual.setTipo(tipoTransaccion.getTipo());			
			tipoTransaccionActual.setIndSalini(tipoTransaccion.getIndSalini());			
			tipoTransaccionActual.setIndInterno(tipoTransaccion.getIndInterno());			
			tipoTransaccionActual.setIndExterno(tipoTransaccion.getIndExterno());			
			tipoTransaccionActual.setEstado(tipoTransaccion.getEstado());			
			
			tipoTransaccionUpdated = maeTipoTransaccionService.save(tipoTransaccionActual);
			
		}catch(DataAccessException e) {
			response.put("mensaje", "Error al actualizar el tipo de transaccion en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "El tipo ha sido actualizado con exito!");		
		response.put("Tipo", tipoTransaccionUpdated);
		return new ResponseEntity<Map<String, Object>>(response,HttpStatus.CREATED);
	}
	
	/*************  ELIMINACION *******************************************************************/
	@GetMapping("valdelete/{usuario}/{cliente}/{transaccion}")
	public int getValidaDeleteEntidad(@PathVariable String usuario,@PathVariable Integer cliente,@PathVariable Integer transaccion){
		int numero = maeTipoTransaccionService.execProcValidaDeleteTransaccion(usuario,cliente,transaccion);

		return numero;
	}
	/*
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable Integer id) {
		Map<String, Object> response = new HashMap<>();
		
		try {
			maeTipoTransaccionService.delete(id);			
		}catch(DataAccessException e) {
			response.put("mensaje", "Error al eliminar el tipo en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "El tipo ha sido eliminado con exito!");		
		return new ResponseEntity<Map<String, Object>>(response,HttpStatus.OK);		
	}			
	*/

	@GetMapping("/delete/{usuario}/{cliente}/{transaccion}")
	public ResponseEntity<?> delete(@PathVariable String usuario,@PathVariable Integer cliente,@PathVariable Integer transaccion) {
		Map<String, Object> response = new HashMap<>();
		
		try {
			int numero = maeTipoTransaccionService.execProcDeleteTransaccion(usuario,cliente,transaccion);			
		}catch(DataAccessException e) {
			response.put("mensaje", "Error al eliminar la compañia en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "El tipo de transaccion ha sido eliminado con exito!");		
		return new ResponseEntity<Map<String, Object>>(response,HttpStatus.OK);		
	}	
	
	/*************  EXPORTACION EN EXCEL*******************************************************************/
	
	@GetMapping("/descargar/excel/lista/{compania}")
	public ResponseEntity<Resource> ExportaExcelAllByCompania(@PathVariable Integer compania){
		
		String filename = "ListaTransacciones.xlsx";
		
		List<MaeTipoTransaccion> transaccion = null;
		List<MaeTablaDet> tipo = null;

		TablaGeneral tabla = new TablaGeneral();
		String tipoTabla = tabla.getTipoTabla("SIS_TMOVALM");
		
		transaccion = maeTipoTransaccionService.BuscarAllByCompania(compania);	
		tipo = maeTablaDetService.BuscarByCompaniaTipo(compania,tipoTabla);
		
		InputStreamResource file = new InputStreamResource(excelExportService.exportExcelTipoTransaccionAllByCompania(transaccion,tipo));

	    return ResponseEntity.ok()
		        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + filename)
		        .contentType(MediaType.parseMediaType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"))
		        .body(file);

	}
	
}
