package com.herokuapp.mohitdtumce.user.main;


import com.herokuapp.mohitdtumce.commons.utils.CommonUtils;
import com.herokuapp.mohitdtumce.user.constants.Constants;

public class User {
	private UserType userType;
	private String userName;

	public User() {
		this.userType = UserType.GUEST;
	}

	enum UserType {
		GUEST, LOGGED_IN
	}

	public void validateUser() {


	}

}
