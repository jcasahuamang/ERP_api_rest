package com.tech.application.rest.models.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="MAE_TIPO_TRANSACCION")
public class MaeTipoTransaccion {

	@Column(name="id_compania",nullable=false)
	private Integer idCompania;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_tipo",nullable=false)	
	private Integer id;
	
	@Column(name="nombre",nullable=true,length=250)			
	private String nombre;
	
	@Column(name="abreviatura",nullable=true,length=25)			
	private String abreviatura;	
	
	@Column(name="tipo",nullable=true,length=3)			
	private String tipo;	
	
	@Column(name="ind_salini",nullable=true,length=1)			
	private String indSalini;		
	
	@Column(name="ind_interno",nullable=true,length=1)			
	private String indInterno;			
	
	@Column(name="ind_externo",nullable=true,length=1)			
	private String indExterno;			
	
	@Column(name="estado",nullable=false)
	private Integer estado;

	public MaeTipoTransaccion() {

	}

	public MaeTipoTransaccion(Integer idCompania,String nombre, String abreviatura, String tipo,
			String indSalini, String indInterno, String indExterno, Integer estado) {
		this.idCompania = idCompania;
		this.nombre = nombre;
		this.abreviatura = abreviatura;
		this.tipo = tipo;
		this.indSalini = indSalini;
		this.indInterno = indInterno;
		this.indExterno = indExterno;
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

	public String getAbreviatura() {
		return abreviatura;
	}

	public void setAbreviatura(String abreviatura) {
		this.abreviatura = abreviatura;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getIndSalini() {
		return indSalini;
	}

	public void setIndSalini(String indSalini) {
		this.indSalini = indSalini;
	}

	public String getIndInterno() {
		return indInterno;
	}

	public void setIndInterno(String indInterno) {
		this.indInterno = indInterno;
	}

	public String getIndExterno() {
		return indExterno;
	}

	public void setIndExterno(String indExterno) {
		this.indExterno = indExterno;
	}

	public Integer getEstado() {
		return estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}
	
	
	
	
}
