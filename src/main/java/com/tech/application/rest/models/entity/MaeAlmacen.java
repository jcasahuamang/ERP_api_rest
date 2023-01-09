package com.tech.application.rest.models.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="MAE_ALMACEN")
public class MaeAlmacen {

	@Column(name="id_compania",nullable=false)
	private Integer idCompania;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_almacen",nullable=false)	
	private Integer id;	
	
	@Column(name="nombre",nullable=false,length=250)			
	private String nombre;
	
	@Column(name="tipo",nullable=true,length=5)			
	private String tipo;

	@Column(name="direccion",nullable=true,length=250)			
	private String direccion;	
	
	@Column(name="ind_virtual",nullable=true,length=2)			
	private String indVirtual;		
	
	@Column(name="id_pais",nullable=false)
	private Integer idPais;	
	
	@Column(name="estado",nullable=false)
	private Integer estado;
	
	public MaeAlmacen() {
	}

	public MaeAlmacen(Integer idCompania, String nombre, String tipo, String direccion, String indVirtual,
			Integer idPais, Integer estado) {
		super();
		this.idCompania = idCompania;
		this.nombre = nombre;
		this.tipo = tipo;
		this.direccion = direccion;
		this.indVirtual = indVirtual;
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

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getIndVirtual() {
		return indVirtual;
	}

	public void setIndVirtual(String indVirtual) {
		this.indVirtual = indVirtual;
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
