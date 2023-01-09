package com.tech.application.rest.models.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class RepMaeTabla {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)		
	@Column
	private Integer nro;

	@Column
	private Integer id_compania;
	
	@Column
	private String des_empresa;
	
	@Column
	private String tipo_tabla;
	
	@Column
	private String des_tipo_tabla;
	
	@Column
	private String codigo;
	
	@Column
	private String des_codigo;
	
	@Column	
	private Float valor_ini;
	
	@Column	
	private Float valor_fin;
	
	@Column
	private String ind_visible;

	public RepMaeTabla() {

	}

	public RepMaeTabla(Integer nro, Integer id_compania, String des_empresa, String tipo_tabla, String des_tipo_tabla,
			String codigo, String des_codigo, Float valor_ini, Float valor_fin, String ind_visible) {
		this.nro = nro;
		this.id_compania = id_compania;
		this.des_empresa = des_empresa;
		this.tipo_tabla = tipo_tabla;
		this.des_tipo_tabla = des_tipo_tabla;
		this.codigo = codigo;
		this.des_codigo = des_codigo;
		this.valor_ini = valor_ini;
		this.valor_fin = valor_fin;
		this.ind_visible = ind_visible;
	}

	public Integer getNro() {
		return nro;
	}

	public void setNro(Integer nro) {
		this.nro = nro;
	}

	public Integer getId_compania() {
		return id_compania;
	}

	public void setId_compania(Integer id_compania) {
		this.id_compania = id_compania;
	}

	public String getDes_empresa() {
		return des_empresa;
	}

	public void setDes_empresa(String des_empresa) {
		this.des_empresa = des_empresa;
	}

	public String getTipo_tabla() {
		return tipo_tabla;
	}

	public void setTipo_tabla(String tipo_tabla) {
		this.tipo_tabla = tipo_tabla;
	}

	public String getDes_tipo_tabla() {
		return des_tipo_tabla;
	}

	public void setDes_tipo_tabla(String des_tipo_tabla) {
		this.des_tipo_tabla = des_tipo_tabla;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDes_codigo() {
		return des_codigo;
	}

	public void setDes_codigo(String des_codigo) {
		this.des_codigo = des_codigo;
	}

	public Float getValor_ini() {
		return valor_ini;
	}

	public void setValor_ini(Float valor_ini) {
		this.valor_ini = valor_ini;
	}

	public Float getValor_fin() {
		return valor_fin;
	}
	
	public void setValor_fin(Float valor_fin) {
		this.valor_fin = valor_fin;
	}

	public String getInd_visible() {
		return ind_visible;
	}

	public void setInd_visible(String ind_visible) {
		this.ind_visible = ind_visible;
	}

	
	
	
}
