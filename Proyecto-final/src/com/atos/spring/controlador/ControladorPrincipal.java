package com.atos.spring.controlador;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.security.core.GrantedAuthority;

@Controller
public class ControladorPrincipal {

	@RequestMapping(value = "/loginSuccess", method = RequestMethod.POST)
	public String entrar(Model model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		//authentication.getPrincipal(); //este seria tu objeto Usuarios
		
		//ojo con authentication.... null pointe exc
		boolean esAdmin = false;
		for(GrantedAuthority ga : authentication.getAuthorities()) {
			if(ga.getAuthority().equals("ADMIN"))
				esAdmin = true;
		}
		
		// no es obligatorio
		model.addAttribute("usuario",authentication.getName());
		
		if(esAdmin)
			return "/index";
		else
			return "/indexUser";
	}
	
}
