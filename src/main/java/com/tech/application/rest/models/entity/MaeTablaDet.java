package com.tech.application.rest.models.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="MAE_TABLA_DET")
public class MaeTablaDet {

	@Column(name="id_tabla",nullable=false)
	private Integer idTabla;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_tabla_det",nullable=false)	
	private Integer id;
	
	@Column(name="codigo",nullable=false,length=5)			
	private String codigo;	
	
	@Column(name="nombre",nullable=false,length=250)			
	private String nombre;	
	
	@Column(name="valor_ini",nullable=true)			
	private Float valorIni;	
	
	@Column(name="valor_fin",nullable=true)			
	private Float valorFin;		

	@Column(name="ind_visible",nullable=true,length=2)			
	private String indVisible;

	public MaeTablaDet() {
	}	
	
	public MaeTablaDet(Integer idTabla, String codigo, String nombre, Float valorIni, Float valorFin,
			String indVisible) {
		this.idTabla = idTabla;
		this.codigo = codigo;
		this.nombre = nombre;
		this.valorIni = valorIni;
		this.valorFin = valorFin;
		this.indVisible = indVisible;
	}
	
    public static MaeTablaDet dtoToEntity(MaeTablaDet detalle){
    	MaeTablaDet detalleEntity = new MaeTablaDet();
    	
    	detalleEntity.setIdTabla(detalle.getIdTabla());
    	detalleEntity.setId(detalle.getId());
    	detalleEntity.setCodigo(detalle.getCodigo());
    	detalleEntity.setNombre(detalle.getNombre());    	
    	detalleEntity.setValorIni(detalle.getValorIni());
    	detalleEntity.setValorFin(detalle.getValorFin());
    	detalleEntity.setIndVisible(detalle.getIndVisible());    	
        return detalleEntity;
    }

	public Integer getIdTabla() {
		return idTabla;
	}

	public void setIdTabla(Integer idTabla) {
		this.idTabla = idTabla;
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

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Float getValorIni() {
		return valorIni;
	}

	public void setValorIni(Float valorIni) {
		this.valorIni = valorIni;
	}

	public Float getValorFin() {
		return valorFin;
	}

	public void setValorFin(Float valorFin) {
		this.valorFin = valorFin;
	}

	public String getIndVisible() {
		return indVisible;
	}

	public void setIndVisible(String indVisible) {
		this.indVisible = indVisible;
	}	
	
	
}
