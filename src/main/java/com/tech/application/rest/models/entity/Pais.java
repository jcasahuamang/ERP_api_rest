package com.tech.application.rest.models.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="SIS_PAIS")
public class Pais{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_pais",nullable=false)	
	private Integer id;
	
	@Column(name="nombre",nullable=false,unique=true,length=250)
	private String nombre;

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
	
	public Pais() {}
	
	public Pais(@NotBlank String nombre) {
		this.nombre = nombre;
	}
	
}