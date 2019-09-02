package com.herokuapp.mohitdtumce;

import com.herokuapp.mohitdtumce.commons.entities.UserCredentials;
import com.herokuapp.mohitdtumce.commons.utils.CommonDatabaseUtils;

public class QuickSnapMain {

	public static void main(String[] args) {
		CommonDatabaseUtils.addUserCredentials("mohitsharma", "mohitsharma@gmail.com", "Pass@123");
		UserCredentials userCredentials = CommonDatabaseUtils.fetchUserCredentials("mohitdtumce");
		System.out.println(userCredentials.getUser() + userCredentials.getEmail() + userCredentials.getPassword());
	}
}
