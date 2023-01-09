package com.tech.application.rest.models.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="MAE_ENTIDAD_CONTACTO")
public class MaeEntidadContacto {

	@Column(name="id_entidad",nullable=false)
	private Integer idEntidad;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_contacto",nullable=false)	
	private Integer id;
	
	@Column(name="nombre_completo",nullable=true,length=250)			
	private String nombreCompleto;
	
	
	@Column(name="telefono1",nullable=true,length=50)			
	private String telefono1;
	
	@Column(name="email",nullable=true,length=250)			
	private String email;
	
	@Column(name="cargo",nullable=true,length=250)			
	private String cargo;
	
	public MaeEntidadContacto() {

	}

	public MaeEntidadContacto(Integer idEntidad, String nombreCompleto, String telefono1, String email, String cargo) {
		this.idEntidad = idEntidad;
		this.nombreCompleto = nombreCompleto;
		this.telefono1 = telefono1;
		this.email = email;
		this.cargo = cargo;
	}

	public Integer getIdEntidad() {
		return idEntidad;
	}

	public void setIdEntidad(Integer idEntidad) {
		this.idEntidad = idEntidad;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombreCompleto() {
		return nombreCompleto;
	}

	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}


	public String getTelefono1() {
		return telefono1;
	}

	public void setTelefono1(String telefono1) {
		this.telefono1 = telefono1;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}	
}
