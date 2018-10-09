package com.atos.hibernate.modelo;

import java.util.List;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import com.atos.dao_ext.UsuarioDAO_EXT;
import com.atos.hibernate.Usuarios;

@Component("gestion_usuarios")
@Scope("prototype")
public class Gestion_Usuarios implements IGestion_Usuarios {

	private UsuarioDAO_EXT usuariosdao;

	@Override
	@Transactional(readOnly = true)
	public List<Usuarios> consultar_Todos() {
		return usuariosdao.consultar_all();
	}

	@Override
	@Transactional(readOnly = true)

	public Usuarios consultar_Das(String das) {
		
		return usuariosdao.findById(das);

	}

	public Usuarios consultar_Correo(String correo) {

		return usuariosdao.findById(correo);

	}

	@Override
	@Transactional(readOnly = true)
	public Usuarios consultar_Login(String das, String password) {
		
		Usuarios usu = usuariosdao.findById(das);
		Usuarios usu2 = null;

		if (usu != null) {

			if (usu.getDas().equals(das) && usu.getPassword().equals(password)) {

				return usu;

			} else {
				return usu2;
			}

		} else {
			return usu2;
		}

	}

	@Override
	@Transactional
	public Usuarios consultar_conRol(String correo) {

		return usuariosdao.consultar_ConRol(correo);
	}

	@Override
	@Transactional
	public void alta_Usuario(Usuarios usuario) {
		usuariosdao.save(usuario);
	}

	@Override
	@Transactional
	public void baja_Usuario(Usuarios usuario) {
		usuariosdao.attachDirty(usuario);
	}

	@Override
	@Transactional
	public void modificacion_Usuario(Usuarios usuario) {
		usuariosdao.attachDirty(usuario);
	}

	public UsuarioDAO_EXT getUsuariosdao() {
		return usuariosdao;
	}

	public void setUsuariosdao(UsuarioDAO_EXT usuariosdao) {
		this.usuariosdao = usuariosdao;
	}

	

}
