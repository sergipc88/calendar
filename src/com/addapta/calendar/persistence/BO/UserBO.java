package com.addapta.calendar.persistence.BO;

import java.util.Iterator;
import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.omg.PortableInterceptor.USER_EXCEPTION;

import com.addapta.calendar.persistence.entity.Pagina;
import com.addapta.calendar.persistence.entity.Rol;
import com.addapta.calendar.persistence.entity.User;
import com.addapta.calendar.persistence.hibernateUtil.HibernateUtil;

public class UserBO {
	
	
	public User alta(User u) {
	
	Session   session = HibernateUtil.getSessionFactory().openSession();
	Transaction transaction = session.beginTransaction();
				
	session.save(u);
	transaction.commit();
	session.close();
	
	return u;
}
	
	
	
	public boolean recoveryUser(User u) {
		
		boolean bOk = true;
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		String queryString = "FROM User WHERE usuario = (:condicion)";
		
		try {
			Query hqlQuery = session.createQuery(queryString);
			hqlQuery.setParameter("condicion", u.getUsuario());
			u = (User) hqlQuery.getSingleResult();
		} catch (NoResultException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			
			bOk = false;
		}
		
		
		
		
	
		return bOk; 
	}
	
public boolean recoveryMail(User u) {
		
		boolean bOk = true;
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		String queryString = "FROM User WHERE mail = (:condicion)";
		
		try {
			Query hqlQuery = session.createQuery(queryString);
			hqlQuery.setParameter("condicion", u.getMail());
			u = (User) hqlQuery.getSingleResult();
		} catch (NoResultException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			
			bOk = false;
		}
							
		return bOk; 
	}


	public boolean validation(User u) {
		
		boolean bOk = true;
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		String queryString = "FROM User WHERE usuario = (:condicion) AND pass =(:condicion2)";
		
		try {
			Query hqlQuery = session.createQuery(queryString);
			hqlQuery.setParameter("condicion", u.getUsuario());
			hqlQuery.setParameter("condicion2", u.getPass());
			u = (User) hqlQuery.getSingleResult();
		} catch (NoResultException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			
			bOk = false;
		}
							
		return bOk; 
	}
	
public User recuperarUserValidado(User u) {
		
		boolean bOk = true;
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		String queryString = "FROM User WHERE usuario = (:condicion) AND pass =(:condicion2)";
			Query hqlQuery = session.createQuery(queryString);
			hqlQuery.setParameter("condicion", u.getUsuario());
			hqlQuery.setParameter("condicion2", u.getPass());
			u = (User) hqlQuery.getSingleResult();
		
							
		return u; 
	}


public boolean recoveryWeb(User u, String url) {

	
	boolean bOk = true;
	Session session = HibernateUtil.getSessionFactory().openSession();
	 @SuppressWarnings("unchecked")
	List<Object[]> results = session.createNativeQuery(
		    "SELECT pagina.NombrePagina, user_rol.User_id FROM user_rol \r\n" + 
		    "INNER JOIN rol_pagina ON rol_pagina.Rol_id = user_rol.roles_id \r\n" + 
		    "INNER JOIN pagina ON pagina.id = rol_pagina.listaWeb_id\r\n" + 
		    "WHERE user_rol.User_id = 1 AND pagina.NombrePagina ="+"'"+url+"'" )
		.list();
	 
	if(results == null || results.isEmpty()) {
		bOk = false;
	}else {}
	 
	 

						
	return bOk; 
}		
}
