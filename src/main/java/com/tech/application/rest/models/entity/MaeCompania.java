package com.tech.application.rest.models.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="MAE_COMPANIA")
public class MaeCompania {

	

	@Column(name="id_cliente",nullable=false)
	private Integer idCliente;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_compania",nullable=false)	
	private Integer id;
	
	@Column(name="nombre_legal",nullable=false,unique=true,length=250)			
	private String nombreLegal;
	
	@Column(name="nombre_comercial",nullable=false,unique=true,length=250)
	private String nombreComercial;
	
	@Column(name="numero_reg_legal",nullable=true,length=50)
	private String numeroRegLegal;
	
	@Column(name="telefono1",nullable=true,length=50)
	private String telefono1;
	
	@Column(name="telefono2",nullable=true,length=50)
	private String telefono2;
	
	@Column(name="webpage",nullable=true,length=250)
	private String webpage;
	
	@Column(name="id_pais",nullable=false)
	private Integer idPais;

	@Column(name="estado",nullable=false)
	private Integer estado;
	
	
	public MaeCompania() {
	}

	public MaeCompania(Integer idCliente, String nombreLegal, String nombreComercial, String numeroRegLegal,
			String telefono1, String telefono2, String webpage, Integer idPais, Integer estado) {
		this.idCliente = idCliente;
		this.nombreLegal = nombreLegal;
		this.nombreComercial = nombreComercial;
		this.numeroRegLegal = numeroRegLegal;
		this.telefono1 = telefono1;
		this.telefono2 = telefono2;
		this.webpage = webpage;
		this.idPais = idPais;
		this.estado = estado;
	}



	public Integer getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombreLegal() {
		return nombreLegal;
	}

	public void setNombreLegal(String nombreLegal) {
		this.nombreLegal = nombreLegal;
	}

	public String getNombreComercial() {
		return nombreComercial;
	}

	public void setNombreComercial(String nombreComercial) {
		this.nombreComercial = nombreComercial;
	}

	public String getNumeroRegLegal() {
		return numeroRegLegal;
	}

	public void setNumeroRegLegal(String numeroRegLegal) {
		this.numeroRegLegal = numeroRegLegal;
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

	public String getWebpage() {
		return webpage;
	}

	public void setWebpage(String webpage) {
		this.webpage = webpage;
	}

	public Integer getIdPais() {
		return idPais;
	}

	public void setIdPais(Integer idPais) {
		this.idPais = idPais;
	}

	public Integer getEstado() {
		return estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}

	
}
