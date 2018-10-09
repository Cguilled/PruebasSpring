package com.atos.hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "usuarios")
public class Usuarios {
	private String das;
	private String nombre;
	private String apellidos;
	private String correo;
	private String password;
	private Roles roles;

	public Usuarios() {
		super();
	}

	public Usuarios(String correo, String password) {
		super();
		this.correo = correo;
		this.password = password;
	}

	

	public Usuarios(String das, String nombre, String apellidos, String correo, String password, Roles roles) {
		super();
		this.das = das;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.correo = correo;
		this.password = password;
		this.roles = roles;
	}

	@Column(name = "nombre", nullable = false, length = 20)
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Column(name = "apellido", nullable = false, length = 100)
	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	@Id
	@Column(name = "das", unique = true, nullable = false, length = 7)
	public String getDas() {
		return das;
	}

	
	public void setDas(String das) {
		this.das = das;
	}

	@Column(name = "correo", unique = true, nullable = false, length = 50)
	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	@Column(name = "password", nullable = false, length = 20)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "codigo_rol")
	public Roles getRoles() {
		return roles;
	}

	public void setRoles(Roles roles) {
		this.roles = roles;
	}

	
	

}
