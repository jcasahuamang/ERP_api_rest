package com.tech.application.rest.models.entity.shared;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class SubMenuModulo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_funcion;
	
	private Integer id_modulo;
	private Integer id_funcion_sup;
	private Integer num_nivel;
	private String des_funcion;
	private String des_url;
	private String des_icono;
	private String ind_detalle;
	private Integer ind_baja;
	private Integer nro_detalle;
	
	public Integer getId_funcion() {
		return id_funcion;
	}
	public void setId_funcion(Integer id_funcion) {
		this.id_funcion = id_funcion;
	}
	public Integer getId_modulo() {
		return id_modulo;
	}
	public void setId_modulo(Integer id_modulo) {
		this.id_modulo = id_modulo;
	}
	public Integer getId_funcion_sup() {
		return id_funcion_sup;
	}
	public void setId_funcion_sup(Integer id_funcion_sup) {
		this.id_funcion_sup = id_funcion_sup;
	}
	public Integer getNum_nivel() {
		return num_nivel;
	}
	public void setNum_nivel(Integer num_nivel) {
		this.num_nivel = num_nivel;
	}
	public String getDes_funcion() {
		return des_funcion;
	}
	public void setDes_funcion(String des_funcion) {
		this.des_funcion = des_funcion;
	}
	public String getDes_url() {
		return des_url;
	}
	public void setDes_url(String des_url) {
		this.des_url = des_url;
	}
	public String getDes_icono() {
		return des_icono;
	}
	public void setDes_icono(String des_icono) {
		this.des_icono = des_icono;
	}
	public String getInd_detalle() {
		return ind_detalle;
	}
	public void setInd_detalle(String ind_detalle) {
		this.ind_detalle = ind_detalle;
	}
	public Integer getInd_baja() {
		return ind_baja;
	}
	public void setInd_baja(Integer ind_baja) {
		this.ind_baja = ind_baja;
	}
	public Integer getNro_detalle() {
		return nro_detalle;
	}
	public void setNro_detalle(Integer nro_detalle) {
		this.nro_detalle = nro_detalle;
	}
	
	public SubMenuModulo() {
	
	}

	
}
