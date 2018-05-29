package com.addapta.calendar.persistence.BO;

import java.util.Date;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.addapta.calendar.persistence.entity.Cita;
import com.addapta.calendar.persistence.hibernateUtil.HibernateUtil;

public class CitaBO {

	
public void create(Cita c) {
		
		Session   session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
					
		session.save(c);
		transaction.commit();
		session.close();
		
		
	}

public void delete(Cita c) {
	
	Session   session = HibernateUtil.getSessionFactory().openSession();
	Transaction transaction = session.beginTransaction();
				
	session.remove(c);
	transaction.commit();
	session.close();
	
	
}
	
public void update(Cita c) {
	
	Session   session = HibernateUtil.getSessionFactory().openSession();
	Transaction transaction = session.beginTransaction();
				
	session.update(c);
	transaction.commit();
	session.close();
	
	
}

public  List <Cita> selection(){
	
	Session session = HibernateUtil.getSessionFactory().openSession();		
	Query hqlQuery = session.createQuery("FROM  Cita");			
	List<Cita> list = hqlQuery.getResultList();	
	return list;
}

public List <Cita> selectByDate(Date start, Date end){
	
	Session session = HibernateUtil.getSessionFactory().openSession();		
	Query hqlQuery = session.createQuery("FROM  Cita  WHERE fechaInicio  >= (:condicion1) AND fechaInicio < (:condicion2)"
			+ " OR fechaFin >= (:condicion1) AND fechaFin < (:condicion2) ");
	hqlQuery.setParameter("condicion1", start);
	hqlQuery.setParameter("condicion2", end);
	List<Cita> list = hqlQuery.getResultList();	
	return list;
	
}
	
}
