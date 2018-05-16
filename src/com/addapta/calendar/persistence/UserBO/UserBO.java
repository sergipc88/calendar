package com.addapta.calendar.persistence.UserBO;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;

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
}
