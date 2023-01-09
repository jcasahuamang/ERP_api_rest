package com.tech.application.rest.models.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="MAE_CENTRO_COSTO")
public class MaeCCosto {

	@Column(name="id_compania",nullable=false)
	private Integer idCompania;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_costo",nullable=false)	
	private Integer id;
	
	
	@Column(name="nombre",nullable=true,length=250)			
	private String nombre;
	
	@Column(name="codigo_tipo",nullable=true,length=5)			
	private String Tipo;	

	@Column(name="codigo_unidad_superior",nullable=true,length=5)			
	private String codigoUnidadSuperior;		
	
	@Column(name="estado",nullable=false)
	private Integer estado;

	
	public MaeCCosto() {
	}	
	
	public MaeCCosto(Integer idCompania, String nombre, String Tipo, String codigoUnidadSuperior,
			Integer estado) {
		this.idCompania = idCompania;
		this.nombre = nombre;
		this.Tipo = Tipo;
		this.codigoUnidadSuperior = codigoUnidadSuperior;
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

	public String getTipo() {
		return Tipo;
	}

	public void setTipo(String Tipo) {
		this.Tipo = Tipo;
	}

	public String getCodigoUnidadSuperior() {
		return codigoUnidadSuperior;
	}

	public void setCodigoUnidadSuperior(String codigoUnidadSuperior) {
		this.codigoUnidadSuperior = codigoUnidadSuperior;
	}

	public Integer getEstado() {
		return estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}

	
}
