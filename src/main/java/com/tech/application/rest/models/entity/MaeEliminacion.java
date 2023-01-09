package com.tech.application.rest.models.entity;


public class MaeEliminacion {

	private Integer codigo;
	private String descripcion;
	
	public MaeEliminacion() {
		
	}
	
	public MaeEliminacion(Integer codigo, String descripcion) {
		this.codigo = codigo;
		this.descripcion = descripcion;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
	
	
}
