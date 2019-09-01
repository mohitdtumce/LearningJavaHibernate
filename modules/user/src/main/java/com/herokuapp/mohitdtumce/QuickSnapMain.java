package com.herokuapp.mohitdtumce;

import com.herokuapp.mohitdtumce.models.UserCredentials;
import com.herokuapp.mohitdtumce.utils.CommonDatabaseUtils;

public class QuickSnapMain {

	public static void main(String[] args) {
		CommonDatabaseUtils.addUserCredentials("mohitdtumce", "mohitdtumce@gmail.com", "Pass@123");
		UserCredentials userCredentials = CommonDatabaseUtils.fetchUserCredentials("mohitdtumce");
		System.out.println(userCredentials.getUser() + userCredentials.getEmail() + userCredentials.getPassword());
	}
}
