package com.atos.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.atos.hibernate.dao.UsuariosDAO;
import com.atos.hibernate.dto.Usuarios;

@Service
public class UserService {
	//Inyecto un objecto de UsuariosDAO
	@Autowired 
	private UsuariosDAO usarios_dao;
	
	public Usuarios login(String u, String p) {
		return usarios_dao.findByDasAndPass(u, p);
	}


}
