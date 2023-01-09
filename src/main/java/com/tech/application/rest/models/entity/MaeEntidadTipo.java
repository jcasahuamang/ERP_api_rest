package com.tech.application.rest.models.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="MAE_ENTIDAD_TIPO")
public class MaeEntidadTipo {

	@Column(name="id_entidad",nullable=false)
	private Integer idEntidad;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_tipo",nullable=false)	
	private Integer id;
	
	@Column(name="codigo",nullable=true,length=5)			
	private String codigo;

	public MaeEntidadTipo() {
	}

	public MaeEntidadTipo(Integer idEntidad, String codigo) {
		this.idEntidad = idEntidad;
		this.codigo = codigo;
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

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	
	
	
	
}
