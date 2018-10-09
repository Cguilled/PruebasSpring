package com.atos.hibernate;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "roles")
public class Roles {
	private Integer codRol;
	private String descRol;
	private Set<Usuarios> usuarios = new HashSet<Usuarios>(0);
	
	
	public Roles() {
		super();
	}
	
	public Roles(Integer codRol, String descRol) {
		super();
		this.codRol = codRol;
		this.descRol = descRol;
	}
	
	public Roles(Integer codRol, String descRol, Set<Usuarios> usuarios) {
		super();
		this.codRol = codRol;
		this.descRol = descRol;
		this.usuarios = usuarios;
	}
	
	@Id
	@Column(name = "codigo_rol", unique = true, nullable = false, precision = 11, scale = 0)
	public Integer getCodRol() {
		return codRol;
	}
	public void setCodRol(Integer codRol) {
		this.codRol = codRol;
	}
	@Column(name = "rol", length = 100)
	public String getDescRol() {
		return descRol;
	}
	public void setDescRol(String descRol) {
		this.descRol = descRol;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "roles")

	public Set<Usuarios> getUsuarios() {
		return this.usuarios;
	}

	public void setUsuarios(Set<Usuarios> usuarios) {
		this.usuarios = usuarios;
	}
	

}
