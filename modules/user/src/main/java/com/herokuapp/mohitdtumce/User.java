package com.herokuapp.mohitdtumce;


public class User {
	private UserType userType;

	public User() {
		this.userType = UserType.GUEST;
	}

	enum UserType {
		GUEST, LOGGED_IN
	}

//	public static boolean validateUser() {
//		Console console = System.console();
//		String username = console.readLine();
//		String providedPassword = console.readPassword().toString();
//
//		UserCredentials userCredentials = CommonDatabaseUtils.fetchUserCredentials(username);
//		if (userCredentials != null && userCredentials.getPassword() == providedPassword) {
//			System.out.println("Valid User");
//			return true;
//		}
//		return false;
//	}


}
