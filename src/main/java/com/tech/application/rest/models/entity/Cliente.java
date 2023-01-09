package com.tech.application.rest.models.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="SIS_CLIENTE")
@NamedStoredProcedureQueries({
	@NamedStoredProcedureQuery(name="usp_save_cliente", procedureName = "usp_save_cliente", 
	parameters =  {
			@StoredProcedureParameter(name="usuario", type = String.class, mode = ParameterMode.IN),
			@StoredProcedureParameter(name="password", type = String.class, mode = ParameterMode.IN),
			@StoredProcedureParameter(name="email", type = String.class, mode = ParameterMode.IN),
			@StoredProcedureParameter(name="primerNombre", type = String.class, mode = ParameterMode.IN),
			@StoredProcedureParameter(name="segundoNombre", type = String.class, mode = ParameterMode.IN),
			@StoredProcedureParameter(name="apellidos", type = String.class, mode = ParameterMode.IN),
			@StoredProcedureParameter(name="id_pais", type = Integer.class, mode = ParameterMode.IN),
			@StoredProcedureParameter(name="estado", type = Integer.class, mode = ParameterMode.IN),
			@StoredProcedureParameter(name="plan", type = Integer.class, mode = ParameterMode.IN),
			@StoredProcedureParameter(name="sistema", type = Integer.class, mode = ParameterMode.IN)		
	})	
})
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_cliente",nullable=false)	
	private Integer id;

	
	@Column(name="usuario",nullable=false,unique=true,length=50)		
	private String usuario;

	@Column(name="clave",nullable=false,length=250)			
	private String password;
	
	@Column(name="correo",nullable=false,unique=true,length=250)				
	private String email;	
	
	@Column(name="primer_nombre",nullable=true,length=250)				
	private String primerNombre;	
	
	@Column(name="segundo_nombre",nullable=true,length=250)				
	private String segundoNombre;	
	
	@Column(name="apellidos",nullable=true,length=250)				
	private String apellidos;	
	

	@Column(name="id_pais",nullable=false)		
	private Integer id_pais;
	
	public String getPrimerNombre() {
		return primerNombre;
	}

	public void setPrimerNombre(String primerNombre) {
		this.primerNombre = primerNombre;
	}

	public String getSegundoNombre() {
		return segundoNombre;
	}

	public void setSegundoNombre(String segundoNombre) {
		this.segundoNombre = segundoNombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	@Column(name="estado",nullable=false)		
	private Integer estado;

	private Integer plan;
	private Integer sistema;
	
	public Cliente() {
	}
	
	public Cliente(@NotBlank String usuario, @NotBlank String password, @NotBlank String email,
				String primerNombre,String segundoNombre,String apellidos,
			@NotNull Integer id_pais,@NotNull Integer estado,@NotNull Integer plan,@NotNull Integer sistema) {
		this.usuario = usuario;
		this.password = password;
		this.email = email;
		this.primerNombre = primerNombre;
		this.segundoNombre = segundoNombre;
		this.apellidos = apellidos;		
		this.id_pais = id_pais;
		this.estado = estado;
		this.plan = plan;
		this.sistema = sistema;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getId_pais() {
		return id_pais;
	}

	public void setId_pais(Integer id_pais) {
		this.id_pais = id_pais;
	}

	public Integer getEstado() {
		return estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}

	
	public Integer getPlan() {
		return plan;
	}

	public void setPlan(Integer plan) {
		this.plan = plan;
	}
	
	public Integer getSistema() {
		return sistema;
	}

	public void setSistema(Integer sistema) {
		this.sistema = sistema;
	}	

}
