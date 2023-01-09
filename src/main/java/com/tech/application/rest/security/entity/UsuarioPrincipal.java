package com.tech.application.rest.security.entity;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UsuarioPrincipal implements UserDetails {
	
	private String primer_nombre;
	private String segundo_nombre;
	private String apellidos;
	
	private String nombreUsuario;
	private String email;	
	private String password;
	private Long id_cliente;
	private Integer tipo;
	private Integer estado;

	private Collection<? extends GrantedAuthority> authorities;

	public UsuarioPrincipal(String primer_nombre, String segundo_nombre, String apellidos, String nombreUsuario,
			String email, String password, Long id_cliente, Integer tipo, Integer estado,
			Collection<? extends GrantedAuthority> authorities) {

		this.primer_nombre = primer_nombre;
		this.segundo_nombre = segundo_nombre;
		this.apellidos = apellidos;
		this.nombreUsuario = nombreUsuario;
		this.email = email;
		this.password = password;
		this.id_cliente = id_cliente;
		this.tipo = tipo;
		this.estado = estado;
		this.authorities = authorities;
	}

	public static UsuarioPrincipal build(Usuario usuario) {
		
		List<GrantedAuthority> authorities = 
				usuario.getRoles().stream().map(rol -> new SimpleGrantedAuthority(rol
						.getRolNombre().name())).collect(Collectors.toList());
		
			return new UsuarioPrincipal(usuario.getPrimer_nombre(),
										usuario.getSegundo_nombre(),
										usuario.getApellidos(),
										usuario.getNombreUsuario(),
										usuario.getEmail(),
										usuario.getPassword(),
										usuario.getId_cliente(),
										usuario.getTipo(),
										usuario.getEstado(),
										authorities);
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return authorities;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return nombreUsuario;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

	public String getPrimer_nombre() {
		return primer_nombre;
	}

	public String getSegundo_nombre() {
		return segundo_nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public String getEmail() {
		return email;
	}

	public Long getId_cliente() {
		return id_cliente;
	}

	public Integer getTipo() {
		return tipo;
	}

	public Integer getEstado() {
		return estado;
	}
	
	
}
