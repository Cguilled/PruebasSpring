package com.atos.spring.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.atos.hibernate.dto.Usuarios;
import com.atos.spring.service.UserService;

@Controller
public class ControladorLogin {

	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/doLogin", method = RequestMethod.POST)
	public String login(@RequestParam("username") String u, @RequestParam("password") String p, Model model) {
		Usuarios us = userService.login(u, p);
		if(us!=null)
			return "redirect:/xhtml/menuAdmin.xhtml";
		else
			return "redirect:/inicio.xhtml";
			
	}
	
}
