package com.herokuapp.mohitdtumce;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtils {
	private static SessionFactory sessionFactoryObj = null;

	public static SessionFactory buildSessionFactory() {
		Configuration configObj = new Configuration();
		configObj.addAnnotatedClass(com.herokuapp.mohitdtumce.models.UserCredentials.class);
		configObj.configure("hibernate.cfg.xml");

		ServiceRegistry serviceRegistryObj = new StandardServiceRegistryBuilder().applySettings(configObj.getProperties()).build();

		sessionFactoryObj = configObj.buildSessionFactory(serviceRegistryObj);
		return sessionFactoryObj;
	}

	public static void shutDown() {
		sessionFactoryObj.close();
	}
}
