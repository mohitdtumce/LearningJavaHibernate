package com.herokuapp.mohitdtumce;

import com.herokuapp.mohitdtumce.models.UserCredentials;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.service.ServiceRegistry;

import java.util.List;

public class DatabaseUtils {
	static UserCredentials userCredentialsObj = null;
	static Session sessionObj = null;
	private static SessionFactory sessionFactoryObj = null;

	public static SessionFactory buildSessionFactory() {
		Configuration configObj = new Configuration();
		configObj.addAnnotatedClass(com.herokuapp.mohitdtumce.models.UserCredentials.class);
		configObj.configure("hibernate.cfg.xml");

		ServiceRegistry serviceRegistryObj = new StandardServiceRegistryBuilder().applySettings(configObj.getProperties()).build();

		sessionFactoryObj = configObj.buildSessionFactory(serviceRegistryObj);
		return sessionFactoryObj;
	}

	public static UserCredentials fetchUserCredentials(String username) {
		try {
			sessionObj = buildSessionFactory().openSession();
			sessionObj.beginTransaction();
			String hql = "FROM UserCredentials UC WHERE UC.user = \'" + username + "\'";
			Query query = sessionObj.createQuery(hql);
			List<UserCredentials> userCredentials = query.list();
			if (userCredentials == null || userCredentials.size() == 0) {
				return null;
			} else {
				return userCredentials.get(0);
			}
		} catch (HibernateException exception) {
			System.out.println("Unable to create session");
			exception.printStackTrace();
		} catch (Exception exception) {
			System.out.println("Inside Parent Exception Catcher");
			exception.printStackTrace();
		}
		return null;
	}

	public static void addUserCredentials(String username, String email, String password) {
		try {
			sessionObj = buildSessionFactory().openSession();
			sessionObj.beginTransaction();
			userCredentialsObj = new UserCredentials();
			userCredentialsObj.setUser(username);
			userCredentialsObj.setEmail(email);
			userCredentialsObj.setPassword(password);
			sessionObj.save(userCredentialsObj);
			sessionObj.getTransaction().commit();
		} catch (HibernateException exception) {
			System.out.println("Unable to create session");
			exception.printStackTrace();
		} catch (Exception exception) {
			System.out.println("Inside Parent Exception Catcher");
			exception.printStackTrace();
		}
	}

	public static void shutDown() {
		sessionFactoryObj.close();
	}
}
