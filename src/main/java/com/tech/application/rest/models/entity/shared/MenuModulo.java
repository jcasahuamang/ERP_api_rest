package com.tech.application.rest.models.entity.shared;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class MenuModulo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_modulo;
	private String des_grupo_menu;
	private String des_grupo;
	private String des_icono;
	
	
	public Integer getId_modulo() {
		return id_modulo;
	}

	public void setId_modulo(Integer id_modulo) {
		this.id_modulo = id_modulo;
	}

	public String getDes_grupo_menu() {
		return des_grupo_menu;
	}

	public void setDes_grupo_menu(String des_grupo_menu) {
		this.des_grupo_menu = des_grupo_menu;
	}

	public String getDes_grupo() {
		return des_grupo;
	}

	public void setDes_grupo(String des_grupo) {
		this.des_grupo = des_grupo;
	}

	public String getDes_icono() {
		return des_icono;
	}

	public void setDes_icono(String des_icono) {
		this.des_icono = des_icono;
	}

	public MenuModulo() {
	}
}