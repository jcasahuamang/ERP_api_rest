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

import com.tech.application.rest.models.entity.MaeEntidadContacto;
import com.tech.application.rest.models.services.service.IMaeEntidadContactoService;


@CrossOrigin(origins= "*")
@RestController
@RequestMapping("/entidadContacto")
public class MaeEntidadContactoController {

	@Autowired
	private IMaeEntidadContactoService maeEntidadContactoService;
	
	@GetMapping("/{id}")
	public ResponseEntity<?> BuscarById(@PathVariable Integer id) {
		MaeEntidadContacto maeEntidadContacto= null;
		Map<String, Object> response = new HashMap<>();
		
		try {
			maeEntidadContacto = maeEntidadContactoService.BuscarById(id);
		} catch(DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
//		if(maeEntidad.getId() == null) {
		if(maeEntidadContacto == null) {		
			response.put("mensaje", "La Contacto: ".concat(id.toString().concat(" no existe en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<MaeEntidadContacto>(maeEntidadContacto,HttpStatus.OK);		
	}
	
	@GetMapping("/lista/{entidad}")
	public ResponseEntity<?> BuscarAllByEntidad(@PathVariable Integer entidad){
		List<MaeEntidadContacto> maeEntidadContacto= null;
		Map<String, Object> response = new HashMap<>();		
		
		try {
			maeEntidadContacto = maeEntidadContactoService.BuscarAllByEntidad(entidad);
		} catch(DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		return new ResponseEntity<List<MaeEntidadContacto>>(maeEntidadContacto,HttpStatus.OK);
	}		
	
	/*************************************************/
	
	@GetMapping("/listaByNombre/{entidad}/{nombre}")
	public ResponseEntity<?> BuscarByEntidadNombre(@PathVariable Integer entidad,@PathVariable String nombre){
		List<MaeEntidadContacto> maeEntidadContacto = null;
		Map<String, Object> response = new HashMap<>();		
		
		try {
			maeEntidadContacto = maeEntidadContactoService.BuscarByEntidadNombre(entidad,nombre);
		} catch(DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<List<MaeEntidadContacto>>(maeEntidadContacto,HttpStatus.OK);
	}	
	
	/*************************************************************************************************/
	@PostMapping("")
	public ResponseEntity<?> create(@RequestBody MaeEntidadContacto entidadContacto) {
		MaeEntidadContacto entidadContactoNew = null;
		Map<String, Object> response = new HashMap<>();
		
		try {
			entidadContactoNew = maeEntidadContactoService.save(entidadContacto);
		}catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar el insert en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("mensaje", "El contacto del auxiliar ha sido creado con exito!");		
		response.put("EntidadContacto", entidadContactoNew);
		return new ResponseEntity<Map<String, Object>>(response,HttpStatus.CREATED);
	}	
	
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@RequestBody MaeEntidadContacto entidadContacto,@PathVariable Integer id) {
		MaeEntidadContacto entidadContactoActual = maeEntidadContactoService.BuscarById(id);
		MaeEntidadContacto entidadContactoUpdated = null;
		Map<String, Object> response = new HashMap<>();
		
		if(entidadContactoActual == null) {
			response.put("mensaje", "Error: no se pudo editar, El Contacto del Auxiliar : ".concat(id.toString().concat(" no existe en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.NOT_FOUND);
		}
		try {
			entidadContactoActual.setIdEntidad(entidadContacto.getIdEntidad());
			entidadContactoActual.setNombreCompleto(entidadContacto.getNombreCompleto());
			entidadContactoActual.setTelefono1(entidadContacto.getTelefono1());
			entidadContactoActual.setEmail(entidadContacto.getEmail());
			entidadContactoActual.setCargo(entidadContacto.getCargo());
			
			entidadContactoUpdated = maeEntidadContactoService.save(entidadContactoActual);
			
		}catch(DataAccessException e) {
			response.put("mensaje", "Error al actualizar la sede en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "El contacto del auxiliar ha sido actualizado con exito!");		
		response.put("EntidadContacto", entidadContactoUpdated);
		return new ResponseEntity<Map<String, Object>>(response,HttpStatus.CREATED);
	}
	
	@PutMapping("/saveAll")
	public ResponseEntity<?> updateAll(@RequestBody List<MaeEntidadContacto> entidadContacto) {
		  Map<String, Object> response = new HashMap<>();
		  List<MaeEntidadContacto> entidadContactoEntities = new ArrayList<>();

		    for (MaeEntidadContacto detalle : entidadContacto) {
		    	entidadContactoEntities.add(detalle);		    	
		    }
		
		if (entidadContactoEntities == null) {
			response.put("mensaje", "Error: no se pudo editar, El detalle de la tabla no se pudo armar");
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.NOT_FOUND);
		}
		try {
		    Iterable<MaeEntidadContacto> persistedContacto = maeEntidadContactoService.saveAll(entidadContactoEntities);	
		    
		}catch(DataAccessException e) {
			response.put("mensaje", "Error al actualizar la tabla en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "El contacto ha sido actualizado con exito!");		
		return new ResponseEntity<Map<String, Object>>(response,HttpStatus.CREATED);
	}
	
	/*************  ELIMINACION *******************************************************************/

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable Integer id) {
		Map<String, Object> response = new HashMap<>();
		
		try {
			maeEntidadContactoService.delete(id);			
		}catch(DataAccessException e) {
			response.put("mensaje", "Error al eliminar el contacto en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "El Contacto ha sido eliminado con exito!");		
		return new ResponseEntity<Map<String, Object>>(response,HttpStatus.OK);		
	}			
	
	@PutMapping("/deleteAll")
	public ResponseEntity<?> deleteAll(@RequestBody List<MaeEntidadContacto> entidadContacto) {
		  Map<String, Object> response = new HashMap<>();
		  List<MaeEntidadContacto> entidadContactoEntities = new ArrayList<>();

		    for (MaeEntidadContacto detalle : entidadContacto) {
		    	entidadContactoEntities.add(detalle);		    	
		    }
		
		if (entidadContactoEntities == null) {
			response.put("mensaje", "Error: no se pudo editar, El detalle de la tabla no se pudo armar");
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.NOT_FOUND);
		}
		try {
			maeEntidadContactoService.deleteAll(entidadContactoEntities);	
		    
		}catch(DataAccessException e) {
			response.put("mensaje", "Error al eliminar la tabla en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "El contacto ha sido eliminado con exito!");		
		return new ResponseEntity<Map<String, Object>>(response,HttpStatus.CREATED);
	}
	
}
