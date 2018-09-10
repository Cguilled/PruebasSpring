package com.atos.spring.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.atos.hibernate.dao.UsuariosDAO;
import com.atos.hibernate.dto.Roles;
import com.atos.hibernate.dto.Usuarios;

@Service
public class UserService implements UserDetailsService {
	//Inyecto un objecto de UsuariosDAO
	@Autowired 
	private UsuariosDAO usuarios_dao;

	@Override
	public UserDetails loadUserByUsername(String das) throws UsernameNotFoundException {
		Usuarios usuario = usuarios_dao.findByDas(das);
		
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		//authorities a partir de roles
		Roles roles = usuario.getRoles();
		
		
		GrantedAuthority ga = new GrantedAuthority() {
			
			@Override
			public String getAuthority() {
				return roles.getDescripcionRol();
			}
		};
		authorities.add(ga);
	
		
		 

		UserDetails userDetails = (UserDetails)new org.springframework.security.core.userdetails.User(usuario.getDAS(),
				usuario.getPassword(), authorities);
		
		return userDetails;

	}
	
	


}
