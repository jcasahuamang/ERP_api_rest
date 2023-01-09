package com.tech.application.rest.models.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="MAE_SEDE")
public class MaeSede {


	@Column(name="id_compania",nullable=false)
	private Integer idCompania;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_sede",nullable=false)	
	private Integer id;
	
	@Column(name="nombre",nullable=true,length=250)			
	private String nombre;
	
	@Column(name="direccion",nullable=true,length=250)			
	private String direccion;	
	

	@Column(name="telefono1",nullable=true,length=50)
	private String telefono1;
	
	@Column(name="telefono2",nullable=true,length=50)
	private String telefono2;
	
	
	@Column(name="id_pais",nullable=false)
	private Integer idPais;	
	
	@Column(name="estado",nullable=false)
	private Integer estado;

	
	public MaeSede() {
	}
		
	public MaeSede(Integer idCompania, String nombre, String direccion, String telefono1, String telefono2,
			Integer idPais, Integer estado) {
		this.idCompania = idCompania;
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono1 = telefono1;
		this.telefono2 = telefono2;
		this.idPais = idPais;
		this.estado = estado;
	}

	public Integer getIdCompania() {
		return idCompania;
	}

	public void setIdCompania(Integer idCompania) {
		this.idCompania = idCompania;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
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
