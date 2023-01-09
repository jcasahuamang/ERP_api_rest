package com.tech.application.rest.models.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class RepAlmaSaldoCierre {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)	
	@Column
	private Integer id_compania;
	
	@Column
	private String nombre_legal;
	
	@Column
	private Integer ano_cierre;
	
	@Column
	private Integer mes_cierre;
	
	@Column
	private Integer id_almacen;
	
	@Column
	private String nom_almacen;
	
	@Column
	private Integer id_cierre;
	
	@Column
	private String usuario;
	
	@Column
	private Date fec_cierre;
	
	@Column
	private Integer id_producto;
	
	@Column
	private String desc_producto;
	
	@Column
	private String uni_medida;
	
	@Column
	private Double cantidad;
	
	public RepAlmaSaldoCierre() {
	}

	public RepAlmaSaldoCierre(Integer id_compania, String nombre_legal, Integer ano_cierre, Integer mes_cierre,
			Integer id_almacen, String nom_almacen, Integer id_cierre, String usuario, Date fec_cierre,
			Integer id_producto, String desc_producto, String uni_medida, Double cantidad) {

		this.id_compania = id_compania;
		this.nombre_legal = nombre_legal;
		this.ano_cierre = ano_cierre;
		this.mes_cierre = mes_cierre;
		this.id_almacen = id_almacen;
		this.nom_almacen = nom_almacen;
		this.id_cierre = id_cierre;
		this.usuario = usuario;
		this.fec_cierre = fec_cierre;
		this.id_producto = id_producto;
		this.desc_producto = desc_producto;
		this.uni_medida = uni_medida;
		this.cantidad = cantidad;
	}

	public Integer getId_compania() {
		return id_compania;
	}

	public void setId_compania(Integer id_compania) {
		this.id_compania = id_compania;
	}

	public String getNombre_legal() {
		return nombre_legal;
	}

	public void setNombre_legal(String nombre_legal) {
		this.nombre_legal = nombre_legal;
	}

	public Integer getAno_cierre() {
		return ano_cierre;
	}

	public void setAno_cierre(Integer ano_cierre) {
		this.ano_cierre = ano_cierre;
	}

	public Integer getMes_cierre() {
		return mes_cierre;
	}

	public void setMes_cierre(Integer mes_cierre) {
		this.mes_cierre = mes_cierre;
	}

	public Integer getId_almacen() {
		return id_almacen;
	}

	public void setId_almacen(Integer id_almacen) {
		this.id_almacen = id_almacen;
	}

	public String getNom_almacen() {
		return nom_almacen;
	}

	public void setNom_almacen(String nom_almacen) {
		this.nom_almacen = nom_almacen;
	}

	public Integer getId_cierre() {
		return id_cierre;
	}

	public void setId_cierre(Integer id_cierre) {
		this.id_cierre = id_cierre;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public Date getFec_cierre() {
		return fec_cierre;
	}

	public void setFec_cierre(Date fec_cierre) {
		this.fec_cierre = fec_cierre;
	}

	public Integer getId_producto() {
		return id_producto;
	}

	public void setId_producto(Integer id_producto) {
		this.id_producto = id_producto;
	}

	public String getDesc_producto() {
		return desc_producto;
	}

	public void setDesc_producto(String desc_producto) {
		this.desc_producto = desc_producto;
	}

	public String getUni_medida() {
		return uni_medida;
	}

	public void setUni_medida(String uni_medida) {
		this.uni_medida = uni_medida;
	}

	public Double getCantidad() {
		return cantidad;
	}

	public void setCantidad(Double cantidad) {
		this.cantidad = cantidad;
	}	
	
	
	
}
