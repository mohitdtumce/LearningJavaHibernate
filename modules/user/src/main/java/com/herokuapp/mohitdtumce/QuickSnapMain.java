package com.herokuapp.mohitdtumce;

import com.herokuapp.mohitdtumce.commons.entities.UserCredentials;
import com.herokuapp.mohitdtumce.commons.utils.CommonDatabaseUtils;

public class QuickSnapMain {

	public static void main(String[] args) throws Exception {
		CommonDatabaseUtils.addUserCredentials("mohitsharma.r", "Pass@123");
		UserCredentials userCredentials = CommonDatabaseUtils.fetchUserCredentials("mohit.sharma");
		if (userCredentials != null)
			System.out.println(userCredentials.getUserName() + userCredentials.getPassword());

	}
}
