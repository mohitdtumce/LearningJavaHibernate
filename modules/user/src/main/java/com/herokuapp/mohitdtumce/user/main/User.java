package com.herokuapp.mohitdtumce.user.main;


public class User {
	private UserType userType;

	public User() {
		this.userType = UserType.GUEST;
	}

	enum UserType {
		GUEST, LOGGED_IN
	}



}
