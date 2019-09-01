package com.herokuapp.mohitdtumce;

import java.io.Console;

public class User {
	enum UserType {
		GUEST, LOGGED_IN
	}

	private UserType userType;

	public User() {
		this.userType = UserType.GUEST;
	}

	public boolean validateUser() {
		Console console = System.console();
		String username = console.readLine();
		String password = console.readPassword().toString();

		return true;
	}


}
