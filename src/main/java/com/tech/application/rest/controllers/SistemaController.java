package com.tech.application.rest.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tech.application.rest.models.entity.Cliente;
import com.tech.application.rest.models.entity.EmailRequest;
import com.tech.application.rest.models.entity.EmailResponse;
import com.tech.application.rest.models.entity.Modulo;
import com.tech.application.rest.models.entity.Pais;
import com.tech.application.rest.models.entity.Plan;
import com.tech.application.rest.models.entity.Sistema;
import com.tech.application.rest.models.services.IClienteService;
import com.tech.application.rest.models.services.IModuloService;
import com.tech.application.rest.models.services.IPaisService;
import com.tech.application.rest.models.services.IPlanService;
import com.tech.application.rest.models.services.ISistemaService;
import com.tech.application.rest.models.services.serviceimpl.EmailServiceImpl;

@CrossOrigin(origins= "*")
@RestController
@RequestMapping("/sistema")
public class SistemaController {

	@Autowired
	private IClienteService clienteService;
	@Autowired
	private IPaisService paisService;
	@Autowired
	private IPlanService planService;
	
	@Autowired
	private IModuloService moduloService;

	@Autowired
	private ISistemaService sistemaService;
	
	@Autowired
	PasswordEncoder passwordEncoder;

	/************************** GET ALL***************************************************/
	/*
	 @GetMapping("/clientes")
	public List<Cliente> index(){
		return clienteService.finAll();
	}
	*/
	@GetMapping("/paises")
	public List<Pais> indexPais(){
		return paisService.findAll();
	}

	@GetMapping("/planes")
	public List<Plan> indexPlan(){
		return planService.findAll();
	}
	
	@GetMapping("/modulos")
	public List<Modulo> indexModulo(){
		return moduloService.findAll();
	}
	
	@GetMapping("/sistemas")
	public List<Sistema> indexSistema(){
		return sistemaService.findAll();
	}	
	
	/***************************** POST CREATE ***********************************************/
	@PostMapping("/clientes")
	public ResponseEntity<?> create(@Valid @RequestBody Cliente cliente,BindingResult bindingResult) {
		
		Map<String, Object> response = new HashMap<>();
		
		if (bindingResult.hasErrors()) {
			response.put("mensaje", "Verifique los valores ingresados");
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.BAD_REQUEST);
		}

		if (clienteService.existsByUsuario(cliente.getUsuario())) {
			response.put("mensaje", "El usuario ya se encuentra registrado");
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.BAD_REQUEST);						
		}
		//Solo por ahora comentado
		/*
		if (clienteService.existsByEmail(cliente.getEmail())) {
			response.put("mensaje", "El email ya se encuentra registrado");
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.BAD_REQUEST);						
		}		
		*/

		Cliente clienteNew = new Cliente(cliente.getUsuario(),
				passwordEncoder.encode(cliente.getPassword()),
										cliente.getEmail(),
										cliente.getPrimerNombre(),
										cliente.getSegundoNombre(),
										cliente.getApellidos(),
										cliente.getId_pais(),
										cliente.getEstado(),
										cliente.getPlan(),
										cliente.getSistema());
		try {
			//clienteService.save(clienteNew);
			clienteNew = clienteService.execProcSaveCliente(clienteNew.getUsuario(),clienteNew.getPassword(),clienteNew.getEmail(),
					clienteNew.getPrimerNombre(),clienteNew.getSegundoNombre(),clienteNew.getApellidos(),
					clienteNew.getId_pais(),clienteNew.getEstado(),cliente.getPlan(),cliente.getSistema());

		}catch (DataAccessException e) {
			response.put("mensaje", "Error al registrar en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("mensaje", "El Cliente se registro con exito!");		
		response.put("Cliente", clienteNew);
		return new ResponseEntity<Map<String, Object>>(response,HttpStatus.CREATED);
	}
	
	/*****************************************/
	/*
	 @PostMapping("/paises")
	public ResponseEntity<?> createPais(@Valid @RequestBody Pais pais,BindingResult bindingResult){
		Map<String, Object> response = new HashMap<>();
		
		if (bindingResult.hasErrors()) {
			response.put("mensaje", "Verifique los valores ingresados");
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.BAD_REQUEST);
		}
		if (paisService.existsByNombre(pais.getNombre())) {
			response.put("mensaje", "El Pais ya se encuentra registrado");
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.BAD_REQUEST);						
		}		
		
		Pais paisNew = new Pais(pais.getNombre());
		try {
			paisService.save(paisNew);
		}catch(DataAccessException e) {
			response.put("mensaje", "Error al registrar en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);			
		}
		
		response.put("mensaje", "El Pais se registro con exito!");		
		response.put("Pais", paisNew);
		return new ResponseEntity<Map<String, Object>>(response,HttpStatus.CREATED);
	}
	*/
	
	/*****************************************/
	/*
	 @PostMapping("/planes")
	public ResponseEntity<?> createPlan(@Valid @RequestBody Plan plan,BindingResult bindingResult){
		Map<String, Object> response = new HashMap<>();
		
		if (bindingResult.hasErrors()) {
			response.put("mensaje", "Verifique los valores ingresados");
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.BAD_REQUEST);
		}
		if (planService.existsByNombre(plan.getNombre())) {
			response.put("mensaje", "El Plan ya se encuentra registrado");
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.BAD_REQUEST);						
		}
		
		Plan planNew = new Plan(plan.getNombre(),plan.getFree(),plan.getEstado());
		try {
			planService.save(planNew);
		}catch(DataAccessException e) {
			response.put("mensaje", "Error al registrar en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);			
		}
		response.put("mensaje", "El Plan se registro con exito!");		
		response.put("Plan", planNew);
		return new ResponseEntity<Map<String, Object>>(response,HttpStatus.CREATED);
	}
	*/
	/*****************************************/
	/* 
	 @PostMapping("/modulos")
	public ResponseEntity<?> createModulo(@Valid @RequestBody Modulo modulo,BindingResult bindingResult){
		Map<String, Object> response = new HashMap<>();
		
		if (bindingResult.hasErrors()) {
			response.put("mensaje", "Verifique los valores ingresados");
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.BAD_REQUEST);
		}
		if (moduloService.existsByCodigo(modulo.getCodigo())) {
			response.put("mensaje", "El Modulo ya se encuentra registrado");
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.BAD_REQUEST);						
		}
		
		Modulo moduloNew = new Modulo(modulo.getCodigo(),modulo.getNombre());
		try {
			moduloService.save(moduloNew);
		}catch(DataAccessException e) {
			response.put("mensaje", "Error al registrar en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);			
		}
		response.put("mensaje", "El Modulo se registro con exito!");		
		response.put("Modulo", moduloNew);
		return new ResponseEntity<Map<String, Object>>(response,HttpStatus.CREATED);
	}
	*/
	
}
