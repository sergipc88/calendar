package com.addapta.calendar.persistence.hibernateUtil;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.addapta.calendar.persistence.entity.Calendario;
import com.addapta.calendar.persistence.entity.Cita;
import com.addapta.calendar.persistence.entity.Pagina;
import com.addapta.calendar.persistence.entity.Rol;
import com.addapta.calendar.persistence.entity.User;





public class HibernateUtil {
	private static StandardServiceRegistry registry;
	private static SessionFactory sessionFactory;

	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			try {
				registry = new StandardServiceRegistryBuilder().configure().build();
				MetadataSources sources = new MetadataSources(registry);
				sources.addAnnotatedClass(User.class);
				sources.addAnnotatedClass(Rol.class);
				sources.addAnnotatedClass(Pagina.class);
				sources.addAnnotatedClass(Cita.class);
				sources.addAnnotatedClass(Calendario.class);
				Metadata metadata = sources.getMetadataBuilder().build();
				sessionFactory = metadata.getSessionFactoryBuilder().build();
			} catch (Exception e) {
				e.printStackTrace();
				if (registry != null) {
					StandardServiceRegistryBuilder.destroy(registry);
				}
			}
		}
		return sessionFactory;
	}
}