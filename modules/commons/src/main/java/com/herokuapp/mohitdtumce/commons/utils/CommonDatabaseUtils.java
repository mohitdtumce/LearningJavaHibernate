package com.herokuapp.mohitdtumce.commons.utils;

import com.herokuapp.mohitdtumce.commons.entities.UserCredentials;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.io.File;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class CommonDatabaseUtils {
	static UserCredentials userCredentialsObj = null;
	static Session sessionObj = null;
	private static SessionFactory sessionFactoryObj = null;

	public static ArrayList<String> getClassNamesFromPackage(String packageName) throws IOException, URISyntaxException, ClassNotFoundException {
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		ArrayList<String> classNames = new ArrayList<>();
		packageName = packageName.replace(".", "/");
		URL packageUrl = classLoader.getResource(packageName);
		URI uri = new URI(packageUrl.toString());
		File folder = new File(uri.getPath());
		File[] files = folder.listFiles();
		for (File file : files) {
			String name = file.getName();
			name = name.substring(0, name.lastIndexOf('.'));
			classNames.add(name);
		}
		return classNames;
	}

	public static List<Class<?>> getEntityClassesFromPackage(String packageName) throws IOException, URISyntaxException, ClassNotFoundException {
		List<String> classNames = getClassNamesFromPackage(packageName);
		List<Class<?>> classes = new ArrayList<>();
		for (String className : classNames) {
			Class<?> cls = Class.forName(packageName + "." + className);
			Annotation[] annotations = cls.getAnnotations();
			for (Annotation annotation : annotations) {
				System.out.println(cls.getCanonicalName() + ": " + annotation.toString());
				if (annotation instanceof javax.persistence.Entity) {
					classes.add(cls);
				}
			}
		}
		return classes;
	}

	public static SessionFactory buildSessionFactory() throws IOException, URISyntaxException, ClassNotFoundException {
		Configuration configObj = new Configuration();
		for (Class cls : getEntityClassesFromPackage("com.herokuapp.mohitdtumce.commons.entities")) {
			configObj.addAnnotatedClass(cls);
		}
//		configObj.addAnnotatedClass(UserCredentials.class);
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
