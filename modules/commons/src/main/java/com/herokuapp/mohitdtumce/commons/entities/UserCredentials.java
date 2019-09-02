package com.herokuapp.mohitdtumce.commons.entities;

import com.herokuapp.mohitdtumce.commons.constants.Constants;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = Constants.USER_CREDENTIALS_TABLE)
public class UserCredentials {

	@Id
	@Column(name = "user_name", nullable = false)
	private String userName;

	@Column(name = "passwd", nullable = false)
	private String password;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
