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
import com.tech.application.rest.models.entity.MaeTablaDet;
import com.tech.application.rest.models.entity.configurations.TablaGeneral;
import com.tech.application.rest.models.services.service.IMaeCCostoService;
import com.tech.application.rest.models.services.service.IMaeTablaDetService;
import com.tech.application.rest.models.services.serviceimpl.ExcelExportServiceImpl;

@CrossOrigin(origins= "*")
@RestController
@RequestMapping("/ccosto")
public class MaeCCostoController {
	
	@Autowired
	private IMaeCCostoService maeCCostoService;
	
	@Autowired
	private IMaeTablaDetService maeTablaDetService;
	
	@Autowired
	private ExcelExportServiceImpl excelExportService;	
		
	
	@GetMapping("/{id}")
	public ResponseEntity<?> BuscarById(@PathVariable Integer id) {
		MaeCCosto ccosto= null;
		Map<String, Object> response = new HashMap<>();
		
		try {
			ccosto = maeCCostoService.BuscarById(id);
		} catch(DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		if(ccosto.getId() == null) {
			response.put("mensaje", "El Centro de Costo : ".concat(id.toString().concat(" no existe en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<MaeCCosto>(ccosto,HttpStatus.OK);		
	}
	
	
	@GetMapping("/lista/{compania}")
	public ResponseEntity<?> BuscarAllByCompania(@PathVariable Integer compania){
		List<MaeCCosto> ccosto= null;
		Map<String, Object> response = new HashMap<>();		
		
		try {
			ccosto = maeCCostoService.BuscarAllByCompania(compania);
		} catch(DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
			
		}

		return new ResponseEntity<List<MaeCCosto>>(ccosto,HttpStatus.OK);
	}		
	
	/*************************************************/
	
	@GetMapping("/listaByNombre/{compania}/{nombre}")
	public ResponseEntity<?> BuscarByCompaniaNombre(@PathVariable Integer compania,@PathVariable String nombre){
		List<MaeCCosto> ccosto = null;
		Map<String, Object> response = new HashMap<>();		
		
		try {
			ccosto = maeCCostoService.BuscarByCompaniaNombre(compania,nombre);
		} catch(DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		return new ResponseEntity<List<MaeCCosto>>(ccosto,HttpStatus.OK);
	}

	/*****************************************************************/
	@GetMapping("/default/{compania}")
	public ResponseEntity<?> BuscarDefaultByCompania(@PathVariable Integer compania){
		MaeCCosto ccosto = null;
		Map<String, Object> response = new HashMap<>();		
		
		try {
			ccosto = maeCCostoService.BuscarDefaultByCompania(compania);
		} catch(DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
			
		}

		return new ResponseEntity<MaeCCosto>(ccosto,HttpStatus.OK);
	}		

	/*************************************************************************************************/
	@PostMapping("")
	public ResponseEntity<?> create(@RequestBody MaeCCosto ccosto) {
		MaeCCosto ccostoNew = null;
		Map<String, Object> response = new HashMap<>();
		
		try {
			ccostoNew = maeCCostoService.save(ccosto);
		}catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar el insert en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("mensaje", "El centro de costo ha sido creada con exito!");		
		response.put("CCosto", ccostoNew);
		return new ResponseEntity<Map<String, Object>>(response,HttpStatus.CREATED);
	}	
	
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@RequestBody MaeCCosto ccosto,@PathVariable Integer id) {
		MaeCCosto ccostoActual = maeCCostoService.BuscarById(id);
		MaeCCosto ccostoUpdated = null;
		Map<String, Object> response = new HashMap<>();
		
		if(ccostoActual == null) {
			response.put("mensaje", "Error: no se pudo editar, El CCosto : ".concat(id.toString().concat(" no existe en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.NOT_FOUND);
		}
		try {
			ccostoActual.setIdCompania(ccosto.getIdCompania());
			ccostoActual.setNombre(ccosto.getNombre());
			ccostoActual.setTipo(ccosto.getTipo());
			ccostoActual.setCodigoUnidadSuperior(ccosto.getCodigoUnidadSuperior());
			ccostoActual.setEstado(ccosto.getEstado());
			
			ccostoUpdated = maeCCostoService.save(ccostoActual);
			
		}catch(DataAccessException e) {
			response.put("mensaje", "Error al actualizar el centro de costo en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "El Centro de costo ha sido actualizado con exito!");		
		response.put("CCosto", ccostoUpdated);
		return new ResponseEntity<Map<String, Object>>(response,HttpStatus.CREATED);
	}
	
	/*************  ELIMINACION *******************************************************************/
	
	@GetMapping("valdelete/{usuario}/{cliente}/{ccosto}")
	public int getValidaDeleteCompania(@PathVariable String usuario,@PathVariable Integer cliente,@PathVariable Integer ccosto){
		int numero = maeCCostoService.execProcValidaDeleteCCosto(usuario,cliente,ccosto);
		return numero;
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable Integer id) {
		Map<String, Object> response = new HashMap<>();
		
		try {
			maeCCostoService.delete(id);			
		}catch(DataAccessException e) {
			response.put("mensaje", "Error al eliminar el centro de costo en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "El Centro de Costo ha sido eliminado con exito!");		
		return new ResponseEntity<Map<String, Object>>(response,HttpStatus.OK);		
	}		
	
	/*************  EXPORTACION EN EXCEL*******************************************************************/
	
	@GetMapping("/descargar/excel/lista/{compania}")
	public ResponseEntity<Resource> ExportaExcelAllByCompania(@PathVariable Integer compania){
		
		String filename = "ListaCCostos.xlsx";
		
		List<MaeCCosto> ccosto = null;
		List<MaeTablaDet> tipo = null;

		TablaGeneral tabla = new TablaGeneral();
		String tipoTabla = tabla.getTipoTabla("SIS_TIPCCOS");
		
		ccosto = maeCCostoService.BuscarAllByCompania(compania);	
		tipo = maeTablaDetService.BuscarByCompaniaTipo(compania,tipoTabla);
		
		InputStreamResource file = new InputStreamResource(excelExportService.exportExcelCCostoAllByCompania(ccosto,tipo));

	    return ResponseEntity.ok()
		        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + filename)
		        .contentType(MediaType.parseMediaType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"))
		        .body(file);

	}
	
}
