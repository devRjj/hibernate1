package com.test;


import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtilsWithXML {
	private static SessionFactory sessionFactory;

	private HibernateUtilsWithXML() {
		//to prevent instantiation from outside the class
	}
	
	public static SessionFactory getSessionFactory() {
		if(sessionFactory == null) {
			sessionFactory = createSessionFactory();
		}
		
		return sessionFactory;
	}

	private static SessionFactory createSessionFactory() {
		try {
			// Create the SessionFactory from hibernate.cfg.xml
			Configuration configuration = new Configuration().configure();
			return configuration.buildSessionFactory();
		} catch (Exception e) {
			e.printStackTrace();
            throw new RuntimeException("There was an error building the sessionFactory", e);
		}
	}
}
