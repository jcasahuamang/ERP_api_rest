package com.tech.application.rest.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
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

import com.tech.application.rest.models.entity.MaeEntidadTipo;
import com.tech.application.rest.models.entity.MaeTablaDet;
import com.tech.application.rest.models.services.service.IMaeEntidadTipoService;

@CrossOrigin(origins= "*")
@RestController
@RequestMapping("/entidadTipo")
public class MaeEntidadTipoController {

	@Autowired
	private IMaeEntidadTipoService maeEntidadTipoService;
	
	@GetMapping("/{id}")
	public ResponseEntity<?> BuscarById(@PathVariable Integer id) {
		MaeEntidadTipo maeEntidadTipo= null;
		Map<String, Object> response = new HashMap<>();
		
		try {
			maeEntidadTipo = maeEntidadTipoService.BuscarById(id);
		} catch(DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
//		if(maeEntidad.getId() == null) {
		if(maeEntidadTipo == null) {		
			response.put("mensaje", "El Tipo: ".concat(id.toString().concat(" no existe en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<MaeEntidadTipo>(maeEntidadTipo,HttpStatus.OK);		
	}
	
	@GetMapping("/lista/{entidad}")
	public ResponseEntity<?> BuscarAllByEntidad(@PathVariable Integer entidad){
		List<MaeEntidadTipo> maeEntidadTipo = null;
		Map<String, Object> response = new HashMap<>();		
		
		try {
			maeEntidadTipo = maeEntidadTipoService.BuscarAllByEntidad(entidad);
		} catch(DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		return new ResponseEntity<List<MaeEntidadTipo>>(maeEntidadTipo,HttpStatus.OK);
	}		

	/*************************************************************************************************/
	@PostMapping("")
	public ResponseEntity<?> create(@RequestBody MaeEntidadTipo entidadTipo) {
		MaeEntidadTipo entidadTipoNew = null;
		Map<String, Object> response = new HashMap<>();
		
		try {
			entidadTipoNew = maeEntidadTipoService.save(entidadTipo);
		}catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar el insert en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("mensaje", "El Tipo ha sido creado con exito!");		
		response.put("EntidadTipo", entidadTipoNew);
		return new ResponseEntity<Map<String, Object>>(response,HttpStatus.CREATED);
	}	
	
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@RequestBody MaeEntidadTipo entidadTipo,@PathVariable Integer id) {
		MaeEntidadTipo entidadTipoActual = maeEntidadTipoService.BuscarById(id);
		MaeEntidadTipo entidadTipoUpdated = null;
		Map<String, Object> response = new HashMap<>();
		
		if(entidadTipoActual == null) {
			response.put("mensaje", "Error: no se pudo editar, El Tipo de Auxiliar : ".concat(id.toString().concat(" no existe en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.NOT_FOUND);
		}
		try {
			entidadTipoActual.setIdEntidad(entidadTipo.getIdEntidad());
			entidadTipoActual.setCodigo(entidadTipo.getCodigo());
			
			entidadTipoUpdated = maeEntidadTipoService.save(entidadTipoActual);
			
		}catch(DataAccessException e) {
			response.put("mensaje", "Error al actualizar la sede en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "El tipo de auxiliar ha sido actualizado con exito!");		
		response.put("EntidadTipo", entidadTipoUpdated);
		return new ResponseEntity<Map<String, Object>>(response,HttpStatus.CREATED);
	}
	
	@PutMapping("/saveAll")
	public ResponseEntity<?> updateAll(@RequestBody List<MaeEntidadTipo> entidadTipo) {
		  Map<String, Object> response = new HashMap<>();
		  List<MaeEntidadTipo> entidadTipoEntities = new ArrayList<>();

		    for (MaeEntidadTipo detalle : entidadTipo) {
		    	entidadTipoEntities.add(detalle);		    	
		    }
		
		if (entidadTipoEntities == null) {
			response.put("mensaje", "Error: no se pudo editar, El detalle de la tabla no se pudo armar");
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.NOT_FOUND);
		}
		try {
		    Iterable<MaeEntidadTipo> persistedTipo = maeEntidadTipoService.saveAll(entidadTipoEntities);	
		    
		}catch(DataAccessException e) {
			response.put("mensaje", "Error al actualizar la tabla en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "El tipo ha sido actualizado con exito!");		
		return new ResponseEntity<Map<String, Object>>(response,HttpStatus.CREATED);
	}

	
	/*************  ELIMINACION *******************************************************************/

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable Integer id) {
		Map<String, Object> response = new HashMap<>();
		
		try {
			maeEntidadTipoService.delete(id);			
		}catch(DataAccessException e) {
			response.put("mensaje", "Error al eliminar el tipo de entidad en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "El tipo ha sido eliminado con exito!");		
		return new ResponseEntity<Map<String, Object>>(response,HttpStatus.OK);		
	}		
	
	@PutMapping("/deleteAll")
	public ResponseEntity<?> deleteAll(@RequestBody List<MaeEntidadTipo> entidadTipo) {
		  Map<String, Object> response = new HashMap<>();
		  List<MaeEntidadTipo> entidadTipoEntities = new ArrayList<>();

		    for (MaeEntidadTipo detalle : entidadTipo) {
		    	entidadTipoEntities.add(detalle);		    	
		    }
		
		if (entidadTipoEntities == null) {
			response.put("mensaje", "Error: no se pudo editar, El detalle de la tabla no se pudo armar");
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.NOT_FOUND);
		}
		try {
			maeEntidadTipoService.deleteAll(entidadTipoEntities);	
		    
		}catch(DataAccessException e) {
			response.put("mensaje", "Error al eliminar la tabla en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "El tipo ha sido eliminado con exito!");		
		return new ResponseEntity<Map<String, Object>>(response,HttpStatus.CREATED);
	}
	
}
