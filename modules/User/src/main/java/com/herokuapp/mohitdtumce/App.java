package com.herokuapp.mohitdtumce;

import com.herokuapp.mohitdtumce.models.UserCredentials;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 * Hello world!
 */
public class App {

	static UserCredentials userCredentialsObj;
	static Session sessionObj;
	static SessionFactory sessionFactoryObj;

	private static SessionFactory buildSessionFactory() {
		// Creating Configuration Instance & Passing Hibernate Configuration File
		Configuration configObj = new Configuration();
		configObj.addAnnotatedClass(com.herokuapp.mohitdtumce.models.UserCredentials.class);
		configObj.configure("hibernate.cfg.xml");

		// Since Hibernate Version 4.x, ServiceRegistry Is Being Used
		ServiceRegistry serviceRegistryObj = new StandardServiceRegistryBuilder().applySettings(configObj.getProperties()).build();

		// Creating Hibernate SessionFactory Instance
		sessionFactoryObj = configObj.buildSessionFactory(serviceRegistryObj);
		return sessionFactoryObj;
	}

	public static void main(String[] args) {
		try {
			sessionObj = buildSessionFactory().openSession();
			sessionObj.beginTransaction();
			userCredentialsObj = new UserCredentials();
			userCredentialsObj.setUser("burningdzir");
			userCredentialsObj.setEmail("mohitdtumc@gmail.com");
			userCredentialsObj.setPassword("pass@123");
			sessionObj.save(userCredentialsObj);
			sessionObj.getTransaction().commit();
		} catch (HibernateException exception) {
			System.out.println("Unable to create session");
			exception.printStackTrace();
		} catch (Exception exception) {
			System.out.println("Inside exception catcher parent");
			exception.printStackTrace();
		}
		System.out.println("Hello World!");
	}
}
