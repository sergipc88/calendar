package com.addapta.calendar.persistence.BO;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.addapta.calendar.persistence.entity.Calendario;
import com.addapta.calendar.persistence.hibernateUtil.HibernateUtil;

public class CalendarioBO {
	
public void create(Calendario c) {
		
		Session   session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
					
		session.save(c);
		transaction.commit();
		session.close();
		
		
	}

public  List <Calendario> selectCalendars(){
	
	Session session = HibernateUtil.getSessionFactory().openSession();		
	Query hqlQuery = session.createQuery("FROM  Calendario");			
	List<Calendario> list = hqlQuery.getResultList();	
	return list;
}

}
