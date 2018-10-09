package com.atos.hibernate.modelo;

import java.util.List;
import com.atos.hibernate.Roles;

public interface IGestion_Roles {

	public List<Roles> consultar_Roles();
	
	public Roles consultar_ID(Integer id);

}