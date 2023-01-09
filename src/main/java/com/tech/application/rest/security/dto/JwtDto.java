package com.tech.application.rest.security.dto;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;

public class JwtDto {

	private String token;
	private String bearer = "Bearer";
	private Integer idCliente;
	private Integer idUsuario;
	private String nombreUsuario;
	private String nombreCompleto;
	private Collection<? extends GrantedAuthority> authorities;
	
	public JwtDto(String token,Integer idCliente,Integer idUsuario, String nombreUsuario, 
			String primerNombre,String segundoNombre,String apellidos,
			Collection<? extends GrantedAuthority> authorities) {
		this.token = token;
		this.idCliente = idCliente;
		this.idUsuario = idUsuario;
		this.nombreUsuario = nombreUsuario;
		if (segundoNombre.isEmpty()) {
			this.nombreCompleto = primerNombre.concat(" ").concat(apellidos);			
		}else {
			this.nombreCompleto = primerNombre.concat(" ").concat(segundoNombre).concat(" ").concat(apellidos);			
		}
		this.authorities = authorities;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getBearer() {
		return bearer;
	}

	public void setBearer(String bearer) {
		this.bearer = bearer;
	}

		
	public Integer getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	
	public String getNombreCompleto() {
		return nombreCompleto;
	}

	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}

	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
		this.authorities = authorities;
	}
	
	
}
