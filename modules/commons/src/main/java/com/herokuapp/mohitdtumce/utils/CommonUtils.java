package com.herokuapp.mohitdtumce.utils;

import com.herokuapp.mohitdtumce.models.UserCredentials;

import java.io.Console;

public class CommonUtils {
	public static boolean validateUser() {
		Console console = System.console();
		String username = console.readLine();
		String providedPassword = console.readPassword().toString();

		UserCredentials userCredentials = CommonDatabaseUtils.fetchUserCredentials(username);
		if (userCredentials != null && userCredentials.getPassword() == providedPassword) {
			System.out.println("Valid User");
			return true;
		}
		return false;
	}
}