package com.addapta.calendar.persistence.BO;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.addapta.calendar.persistence.entity.Rol;
import com.addapta.calendar.persistence.hibernateUtil.HibernateUtil;

public class RolBO {
	
	public void alta(Rol r) {
		
		Session   session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
					
		session.save(r);
		transaction.commit();
		session.close();
		
		
	}

}
