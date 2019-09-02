package com.herokuapp.mohitdtumce.commons.models;

import com.herokuapp.mohitdtumce.commons.constants.UserState;

public class UserCredentialsInput {

	private UserState userState;
	private String userName;
	private String password;

	public UserCredentialsInput() {
		this.userState = UserState.USER_NOT_FOUND;
		this.userName = "Dummy";
		this.password = "Pass@123";
	}

	public UserCredentialsInput(String userName, String password) {
		this.userState = UserState.USER_NOT_FOUND;
		this.userName = userName;
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public UserState getUserState() {
		return userState;
	}

	public String getPassword() {
		return password;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setUserState(UserState userState) {
		this.userState = userState;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
