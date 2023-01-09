package com.tech.application.rest.models.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="SIS_PLANES")
public class Plan{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_plan",nullable=false)	
	private Integer id;
	
	@Column(name="nombre",nullable=false,unique=true,length=250)
	private String nombre;
	
	@Column(name="ind_free",nullable=true,unique=false,length=1)
	private String free;
	
	@Column(name="estado",nullable=true,unique=false)
	private Integer estado;
	
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

	public String getFree() {
		return free;
	}

	public void setFree(String free) {
		this.free = free;
	}

	public Integer getEstado() {
		return estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}
	
	public Plan() {
		
	}

	public Plan(@NotBlank String nombre,@NotBlank String free,@NotNull Integer estado) {
		this.nombre = nombre;
		this.free = free;
		this.estado = estado;
	}
	

	
	
}