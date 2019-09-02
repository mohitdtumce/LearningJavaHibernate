package com.herokuapp.mohitdtumce.user.main;


import com.herokuapp.mohitdtumce.user.constants.UserType;

public class User {
	private UserType userType;
	private String userName;

	public User() {
		this.userType = UserType.GUEST_USER;
		this.userName = "Anonymous";
	}

	public User(String userName) {
		this.userType = UserType.LOGGED_IN;
		this.userName = userName;
	}

}
