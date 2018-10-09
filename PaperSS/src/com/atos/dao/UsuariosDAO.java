package com.atos.dao;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import com.atos.hibernate.Usuarios;

public class UsuariosDAO {

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	protected Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	public void save(Usuarios transientInstance) {
		try {
			getCurrentSession().save(transientInstance);
		} catch (RuntimeException re) {
			re.printStackTrace();
			throw re;
		}
	}

	public Usuarios findById(java.lang.String id) {
		try {
			Usuarios instance = (Usuarios) getCurrentSession().get("com.atos.hibernate.Usuarios", id);
			return instance;
		} catch (RuntimeException re) {
			throw re;
		}
	}

	public List findAll() {
		try {
			String queryString = "from Usuarios";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			throw re;
		}
	}

	public void attachDirty(Usuarios instance) {
		try {
			getCurrentSession().saveOrUpdate(instance);
		} catch (RuntimeException re) {
			throw re;
		}
	}

	public static UsuariosDAO getFromApplicationContext(ApplicationContext ctx) {
		return (UsuariosDAO) ctx.getBean("UsuariosDAO");
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	
}