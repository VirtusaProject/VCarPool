package com.virtusa.carpool.util;

import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	public HibernateUtil() {

	}

	private static org.hibernate.SessionFactory factory = null;

	static {
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		factory = configuration.buildSessionFactory();

	}

	public static org.hibernate.SessionFactory getFactory() {
		return factory;
	}

}
