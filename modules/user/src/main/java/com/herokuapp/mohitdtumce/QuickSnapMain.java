package com.herokuapp.mohitdtumce;

import com.herokuapp.mohitdtumce.commons.entities.UserCredentials;
import com.herokuapp.mohitdtumce.commons.utils.CommonDatabaseUtils;

public class QuickSnapMain {

	public static void main(String[] args) throws Exception {
		String userName = "mohitdtumce";
		String userPassword = "Pass@345";
		String hashedPassword = CommonHashingUtils.hashUserPassword(userPassword);
		CommonDatabaseUtils.addUserCredentials(userName, hashedPassword);
		UserCredentials userCredentials = CommonDatabaseUtils.fetchUserCredentials("mohitsharma");
		if (userCredentials != null) {
			System.out.println(CommonHashingUtils.validatePasswordMatch("Pass@123", userCredentials.getPassword()));
			System.out.println(userCredentials.getUserName() + userCredentials.getPassword());
		}

	}
}
