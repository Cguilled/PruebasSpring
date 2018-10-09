package com.atos.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.atos.hibernate.Roles;

@Repository("rolesdao")
@Scope("prototype")
public class RolesDAO {

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	protected Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	public Roles findById(Integer id) {
		try {
			Roles instance = (Roles) getCurrentSession().get(
					"com.atos.hibernate.Roles", id);
			return instance;
		} catch (RuntimeException re) {
			throw re;
		}
	}

	public List findAll() {
		try {
			String queryString = "from Roles";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			throw re;
		}
	}


	public static RolesDAO getFromApplicationContext(ApplicationContext ctx) {
		return (RolesDAO) ctx.getBean("RolesDAO");
	}
	
	
}