package com.tech.application.rest.models.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class RepMaeEntidad {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)		
	@Column
	private Integer nro;

	@Column
	private Integer id_compania;
	
	@Column
	private String des_empresa;
	
	@Column
	private Integer id_entidad;	
	
	@Column
	private String nombre_primero;

	@Column
	private String nombre_segundo;
	
	@Column
	private String apellido_paterno;
	
	@Column
	private String apellido_materno;
	
	@Column
	private String nombre_legal;	

	@Column
	private String nombre_comercial;
	
	@Column
	private String tipo_documento;

	@Column
	private String des_tipo_doc;

	@Column
	private String numero_documento;

	@Column
	private String webpage;

	@Column
	private String email;

	@Column
	private String telefono1;

	@Column
	private String telefono2;	

	@Column
	private String pais;	

	@Column
	private String estado;

	@Column
	private String tipo_entidad;
	
	public RepMaeEntidad() {
	}

	public RepMaeEntidad(Integer id_compania, String des_empresa, Integer id_entidad, String nombre_primero,
			String nombre_segundo, String apellido_paterno, String apellido_materno, String nombre_legal,
			String nombre_comercial, String tipo_documento, String des_tipo_doc, String numero_documento,
			String webpage, String email, String telefono1, String telefono2, String pais, String estado,String tipo_entidad) {
		this.id_compania = id_compania;
		this.des_empresa = des_empresa;
		this.id_entidad = id_entidad;
		this.nombre_primero = nombre_primero;
		this.nombre_segundo = nombre_segundo;
		this.apellido_paterno = apellido_paterno;
		this.apellido_materno = apellido_materno;
		this.nombre_legal = nombre_legal;
		this.nombre_comercial = nombre_comercial;
		this.tipo_documento = tipo_documento;
		this.des_tipo_doc = des_tipo_doc;
		this.numero_documento = numero_documento;
		this.webpage = webpage;
		this.email = email;
		this.telefono1 = telefono1;
		this.telefono2 = telefono2;
		this.pais = pais;
		this.estado = estado;
		this.tipo_entidad = tipo_entidad;
	}

	public Integer getId_compania() {
		return id_compania;
	}

	public void setId_compania(Integer id_compania) {
		this.id_compania = id_compania;
	}

	public String getDes_empresa() {
		return des_empresa;
	}

	public void setDes_empresa(String des_empresa) {
		this.des_empresa = des_empresa;
	}

	public Integer getId_entidad() {
		return id_entidad;
	}

	public void setId_entidad(Integer id_entidad) {
		this.id_entidad = id_entidad;
	}

	public String getNombre_primero() {
		return nombre_primero;
	}

	public void setNombre_primero(String nombre_primero) {
		this.nombre_primero = nombre_primero;
	}

	public String getNombre_segundo() {
		return nombre_segundo;
	}

	public void setNombre_segundo(String nombre_segundo) {
		this.nombre_segundo = nombre_segundo;
	}

	public String getApellido_paterno() {
		return apellido_paterno;
	}

	public void setApellido_paterno(String apellido_paterno) {
		this.apellido_paterno = apellido_paterno;
	}

	public String getApellido_materno() {
		return apellido_materno;
	}

	public void setApellido_materno(String apellido_materno) {
		this.apellido_materno = apellido_materno;
	}

	public String getNombre_legal() {
		return nombre_legal;
	}

	public void setNombre_legal(String nombre_legal) {
		this.nombre_legal = nombre_legal;
	}

	public String getNombre_comercial() {
		return nombre_comercial;
	}

	public void setNombre_comercial(String nombre_comercial) {
		this.nombre_comercial = nombre_comercial;
	}

	public String getTipo_documento() {
		return tipo_documento;
	}

	public void setTipo_documento(String tipo_documento) {
		this.tipo_documento = tipo_documento;
	}

	public String getDes_tipo_doc() {
		return des_tipo_doc;
	}

	public void setDes_tipo_doc(String des_tipo_doc) {
		this.des_tipo_doc = des_tipo_doc;
	}

	public String getNumero_documento() {
		return numero_documento;
	}

	public void setNumero_documento(String numero_documento) {
		this.numero_documento = numero_documento;
	}

	public String getWebpage() {
		return webpage;
	}

	public void setWebpage(String webpage) {
		this.webpage = webpage;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefono1() {
		return telefono1;
	}

	public void setTelefono1(String telefono1) {
		this.telefono1 = telefono1;
	}

	public String getTelefono2() {
		return telefono2;
	}

	public void setTelefono2(String telefono2) {
		this.telefono2 = telefono2;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	public String getTipo_Entidad() {
		return tipo_entidad;
	}
	
	public void setTipo_Entidad(String tipo_entidad) {
		this.tipo_entidad = tipo_entidad;
	}
	
	
}
