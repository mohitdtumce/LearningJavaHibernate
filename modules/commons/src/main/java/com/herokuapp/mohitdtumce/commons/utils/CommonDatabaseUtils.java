package com.herokuapp.mohitdtumce.commons.utils;

import com.herokuapp.mohitdtumce.CommonUtils;
import com.herokuapp.mohitdtumce.commons.entities.UserCredentials;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;

public class CommonDatabaseUtils {
	static UserCredentials userCredentialsObj = null;
	static Session sessionObj = null;

	public static UserCredentials fetchUserCredentials(String username) {
		try {
			sessionObj = CommonUtils.buildSessionFactory("com.herokuapp.mohitdtumce.commons.entities", "common_utils.cfg.xml").openSession();
			sessionObj.beginTransaction();
			String hql = "FROM UserCredentials UC WHERE UC.userName = \'" + username + "\'";
			Query query = sessionObj.createQuery(hql);
			List<UserCredentials> userCredentials = query.list();
			CommonUtils.shutDownConnection();
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
			sessionObj = CommonUtils.buildSessionFactory("com.herokuapp.mohitdtumce.commons.entities", "common_utils.cfg.xml").openSession();
			sessionObj.beginTransaction();
			System.out.println("Inside Transaction");
			userCredentialsObj = new UserCredentials();
			userCredentialsObj.setUserName(username);
			userCredentialsObj.setPassword(password);
			sessionObj.save(userCredentialsObj);
			sessionObj.getTransaction().commit();
			System.out.println("Transaction Committed");
			CommonUtils.shutDownConnection();
		} catch (HibernateException exception) {
			System.out.println("Unable to create session");
			exception.printStackTrace();
		} catch (Exception exception) {
			System.out.println("Inside Parent Exception Catcher");
			exception.printStackTrace();
		}
	}
}
