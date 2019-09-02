package com.herokuapp.mohitdtumce;

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

public class CommonHibernateUtils {
	public static SessionFactory sessionFactoryObj = null;

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

	public static SessionFactory buildSessionFactory(String packageName, String configFileName) throws IOException, URISyntaxException, ClassNotFoundException {
		System.out.println("Defining Configurations");
		Configuration configObj = new Configuration();
		System.out.println("Adding Annotated Classes from package: " + packageName);
		for (Class cls : CommonHibernateUtils.getEntityClassesFromPackage(packageName)) {
			configObj.addAnnotatedClass(cls);
		}
		configObj.configure(configFileName);

		ServiceRegistry serviceRegistryObj = new StandardServiceRegistryBuilder().applySettings(configObj.getProperties()).build();

		sessionFactoryObj = configObj.buildSessionFactory(serviceRegistryObj);
		System.out.println("Successfully Created SessionFactory Object");
		return sessionFactoryObj;
	}

	public static void shutDownConnection() {
		sessionFactoryObj.close();
	}
}
