package com.herokuapp.mohitdtumce;

import com.herokuapp.mohitdtumce.models.UserCredentials;
import org.hibernate.HibernateException;
import org.hibernate.Session;

public class QuickSnapMain {

	static UserCredentials userCredentialsObj;
	static Session sessionObj;

	public static void main(String[] args) {
		try {
			sessionObj = HibernateUtils.buildSessionFactory().openSession();
			sessionObj.beginTransaction();
			userCredentialsObj = new UserCredentials();
			userCredentialsObj.setUser("burningdzire");
			userCredentialsObj.setEmail("mohitdtumce@gmail.com");
			userCredentialsObj.setPassword("pass@123");
			sessionObj.save(userCredentialsObj);
			sessionObj.getTransaction().commit();
		} catch (HibernateException exception) {
			System.out.println("Unable to create session");
			exception.printStackTrace();
		} catch (Exception exception) {
			System.out.println("Inside Parent Exception Catcher");
			exception.printStackTrace();
		}
		System.out.println("Hello World!");
	}
}
