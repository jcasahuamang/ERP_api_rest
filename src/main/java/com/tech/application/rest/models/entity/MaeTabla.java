package com.tech.application.rest.models.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="MAE_TABLA")
public class MaeTabla {

	@Column(name="id_compania",nullable=false)
	private Integer idCompania;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_tabla",nullable=false)	
	private Integer id;
	
	@Column(name="tipo_tabla",nullable=false,length=15)			
	private String tipoTabla;
	
	@Column(name="nombre",nullable=false,length=250)			
	private String nombre;
	

	@Column(name="ind_sistema",nullable=true,length=2)			
	private String indSistema;

	public MaeTabla() {
	}	
	
	public MaeTabla(Integer idCompania, String tipoTabla, String nombre, String indSistema) {
		this.idCompania = idCompania;
		this.tipoTabla = tipoTabla;
		this.nombre = nombre;
		this.indSistema = indSistema;
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

	public String getTipoTabla() {
		return tipoTabla;
	}

	public void setTipoTabla(String tipoTabla) {
		this.tipoTabla = tipoTabla;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getIndSistema() {
		return indSistema;
	}

	public void setIndSistema(String indSistema) {
		this.indSistema = indSistema;
	}	
	
	
	
}
