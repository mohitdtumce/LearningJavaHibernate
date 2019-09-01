package com.herokuapp.mohitdtumce;

import com.herokuapp.mohitdtumce.models.UserCredentials;

public class QuickSnapMain {

	public static void main(String[] args) {
		DatabaseUtils.addUserCredentials("mohitdtumce", "mohitdtumce@gmail.com", "Pass@123");
		UserCredentials userCredentials = DatabaseUtils.fetchUserCredentials("mohitdtumce");
		System.out.println(userCredentials.getUser() + userCredentials.getEmail() + userCredentials.getPassword());
	}
}
