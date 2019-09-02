package com.herokuapp.mohitdtumce.commons.utils;

import com.herokuapp.mohitdtumce.CommonUtils;
import com.herokuapp.mohitdtumce.commons.entities.UserCredentials;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public class CommonDatabaseUtils {
	static UserCredentials userCredentialsObj = null;
	static Session sessionObj = null;
	private static SessionFactory sessionFactoryObj = null;

	public static SessionFactory buildSessionFactory(String packageName, String configFileName) throws IOException, URISyntaxException, ClassNotFoundException {
		System.out.println("Defining Configurations");
		Configuration configObj = new Configuration();
		System.out.println("Adding Annotated Classes from package: " + packageName);
		for (Class cls : CommonUtils.getEntityClassesFromPackage(packageName)) {
			configObj.addAnnotatedClass(cls);
		}
		configObj.configure(configFileName);

		ServiceRegistry serviceRegistryObj = new StandardServiceRegistryBuilder().applySettings(configObj.getProperties()).build();

		sessionFactoryObj = configObj.buildSessionFactory(serviceRegistryObj);
		System.out.println("Successfully Created SessionFactory Object");
		return sessionFactoryObj;
	}

	public static UserCredentials fetchUserCredentials(String username) {
		try {
			sessionObj = buildSessionFactory("com.herokuapp.mohitdtumce.commons.entities", "common_utils.cfg.xml").openSession();
			sessionObj.beginTransaction();
			String hql = "FROM UserCredentials UC WHERE UC.userName = \'" + username + "\'";
			Query query = sessionObj.createQuery(hql);
			List<UserCredentials> userCredentials = query.list();
			sessionFactoryObj.close();
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

	public static void addUserCredentials(String username, String password) {
		try {
			sessionObj = buildSessionFactory("com.herokuapp.mohitdtumce.commons.entities", "common_utils.cfg.xml").openSession();
			sessionObj.beginTransaction();
			System.out.println("Inside Transaction");
			userCredentialsObj = new UserCredentials();
			userCredentialsObj.setUserName(username);
			userCredentialsObj.setPassword(password);
			sessionObj.save(userCredentialsObj);
			sessionObj.getTransaction().commit();
			System.out.println("Transaction Committed");
			sessionFactoryObj.close();
		} catch (HibernateException exception) {
			System.out.println("Unable to create session");
			exception.printStackTrace();
		} catch (Exception exception) {
			System.out.println("Inside Parent Exception Catcher");
			exception.printStackTrace();
		}
	}
}
