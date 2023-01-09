package com.tech.application.rest.security.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="MAE_USUARIO")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_usuario",nullable=false)	
	private Long id;
	
	@Column(name="primer_nombre",nullable=false,length=250)			
	private String primer_nombre;
	
	@Column(name="segundo_nombre",nullable=true,length=250)		
	private String segundo_nombre;
	
	@Column(name="apellidos",nullable=false,length=250)			
	private String apellidos;

	
	@Column(name="usuario",nullable=false,unique=true,length=50)		
	private String nombreUsuario;

	
	@Column(name="correo",nullable=false,length=250)				
	private String email;	
	
	@Column(name="clave",nullable=false,length=250)			
	private String password;
	
	@Column(name="id_cliente",nullable=false)		
	private Long id_cliente;
	
	@Column(name="tipo",nullable=false)			
	private Integer tipo;
	
	@Column(name="estado",nullable=false)			
	private Integer estado;
    @NotNull
    @ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name="usuario_rol",joinColumns = @JoinColumn(name="usuario_id"),
				inverseJoinColumns = @JoinColumn(name = "rol_id"))
	private Set<Rol> roles = new HashSet<>();

	
	public Usuario() {
		
	}


	public Usuario(@NotNull String primer_nombre, String segundo_nombre, @NotNull String apellidos, @NotNull String nombreUsuario,
			@NotNull String email,@NotNull String password,@NotNull Long id_cliente,@NotNull Integer tipo,@NotNull Integer estado) {
		
		this.primer_nombre = primer_nombre;
		this.segundo_nombre = segundo_nombre;
		this.apellidos = apellidos;
		this.nombreUsuario = nombreUsuario;
		this.email = email;
		this.password = password;
		this.id_cliente = id_cliente;
		this.tipo = tipo;
		this.estado = estado;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getPrimer_nombre() {
		return primer_nombre;
	}


	public void setPrimer_nombre(String primer_nombre) {
		this.primer_nombre = primer_nombre;
	}


	public String getSegundo_nombre() {
		return segundo_nombre;
	}


	public void setSegundo_nombre(String segundo_nombre) {
		this.segundo_nombre = segundo_nombre;
	}


	public String getApellidos() {
		return apellidos;
	}


	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}


	public String getNombreUsuario() {
		return nombreUsuario;
	}


	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public Long getId_cliente() {
		return id_cliente;
	}


	public void setId_cliente(Long id_cliente) {
		this.id_cliente = id_cliente;
	}


	public Integer getTipo() {
		return tipo;
	}


	public void setTipo(Integer tipo) {
		this.tipo = tipo;
	}


	public Integer getEstado() {
		return estado;
	}


	public void setEstado(Integer estado) {
		this.estado = estado;
	}


	public Set<Rol> getRoles() {
		return roles;
	}


	public void setRoles(Set<Rol> roles) {
		this.roles = roles;
	}
	
	
	
	
	
}
