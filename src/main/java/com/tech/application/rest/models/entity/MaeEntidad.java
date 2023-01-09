package com.tech.application.rest.models.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="MAE_ENTIDAD")
public class MaeEntidad {

	@Column(name="id_compania",nullable=false)
	private Integer idCompania;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_entidad",nullable=false)	
	private Integer id;
	
	@Column(name="nombre_primero",nullable=true,length=50)			
	private String nombrePrimero;
	
	@Column(name="nombre_segundo",nullable=true,length=50)			
	private String nombreSegundo;	
	
	@Column(name="apellido_paterno",nullable=true,length=50)			
	private String apellidoPaterno;	

	@Column(name="apellido_materno",nullable=true,length=50)			
	private String apellidoMaterno;	
	
	@Column(name="nombre_legal",nullable=true,length=250)			
	private String nombreLegal;		
	
	@Column(name="nombre_comercial",nullable=true,length=250)			
	private String nombreComercial;			

	@Column(name="tipo_documento",nullable=true,length=5)			
	private String tipoDocumento;			
	
	@Column(name="numero_documento",nullable=true,length=50)			
	private String numeroDocumento;			
	
	@Column(name="webpage",nullable=true,length=250)			
	private String webpage;			
	
	@Column(name="email",nullable=true,length=250)			
	private String email;			
	
	@Column(name="telefono1",nullable=true,length=50)			
	private String telefono1;			
	
	@Column(name="telefono2",nullable=true,length=50)			
	private String telefono2;			
	
	@Column(name="codigo_habido",nullable=true,length=5)			
	private String codigoHabido;			
	
	@Column(name="id_pais",nullable=false)
	private Integer idPais;	
	
	@Column(name="estado",nullable=false)
	private Integer estado;

	public MaeEntidad() {

	}

	public MaeEntidad(Integer idCompania, String nombrePrimero, String nombreSegundo, String apellidoPaterno,
			String apellidoMaterno, String nombreLegal, String nombreComercial, String tipoDocumento,
			String numeroDocumento, String webpage, String email, String telefono1, String telefono2,
			String codigoHabido, Integer idPais, Integer estado) {
		this.idCompania = idCompania;
		this.nombrePrimero = nombrePrimero;
		this.nombreSegundo = nombreSegundo;
		this.apellidoPaterno = apellidoPaterno;
		this.apellidoMaterno = apellidoMaterno;
		this.nombreLegal = nombreLegal;
		this.nombreComercial = nombreComercial;
		this.tipoDocumento = tipoDocumento;
		this.numeroDocumento = numeroDocumento;
		this.webpage = webpage;
		this.email = email;
		this.telefono1 = telefono1;
		this.telefono2 = telefono2;
		this.codigoHabido = codigoHabido;
		this.idPais = idPais;
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

	public String getNombrePrimero() {
		return nombrePrimero;
	}

	public void setNombrePrimero(String nombrePrimero) {
		this.nombrePrimero = nombrePrimero;
	}

	public String getNombreSegundo() {
		return nombreSegundo;
	}

	public void setNombreSegundo(String nombreSegundo) {
		this.nombreSegundo = nombreSegundo;
	}

	public String getApellidoPaterno() {
		return apellidoPaterno;
	}

	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}

	public String getApellidoMaterno() {
		return apellidoMaterno;
	}

	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}

	public String getNombreLegal() {
		return nombreLegal;
	}

	public void setNombreLegal(String nombreLegal) {
		this.nombreLegal = nombreLegal;
	}

	public String getNombreComercial() {
		return nombreComercial;
	}

	public void setNombreComercial(String nombreComercial) {
		this.nombreComercial = nombreComercial;
	}

	public String getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public String getNumeroDocumento() {
		return numeroDocumento;
	}

	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}

	public String getWebpage() {
		return webpage;
	}

	public void setWebpage(String webpage) {
		this.webpage = webpage;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefono1() {
		return telefono1;
	}

	public void setTelefono1(String telefono1) {
		this.telefono1 = telefono1;
	}

	public String getTelefono2() {
		return telefono2;
	}

	public void setTelefono2(String telefono2) {
		this.telefono2 = telefono2;
	}

	public String getCodigoHabido() {
		return codigoHabido;
	}

	public void setCodigoHabido(String codigoHabido) {
		this.codigoHabido = codigoHabido;
	}

	public Integer getIdPais() {
		return idPais;
	}

	public void setIdPais(Integer idPais) {
		this.idPais = idPais;
	}

	public Integer getEstado() {
		return estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}
	
	
	
	
}
