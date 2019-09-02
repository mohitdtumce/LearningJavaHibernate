package com.herokuapp.mohitdtumce.commons.utils;

import com.herokuapp.mohitdtumce.commons.constants.Constants;
import com.herokuapp.mohitdtumce.commons.constants.UserState;
import com.herokuapp.mohitdtumce.commons.models.UserCredentials;
import com.herokuapp.mohitdtumce.commons.models.UserCredentialsInput;

import java.util.Scanner;

public class CommonUtils {

	private static UserCredentialsInput getUserCredentials() {
		Scanner scanner = new Scanner(System.in);

		String username = scanner.nextLine();
		String providedPassword = scanner.nextLine();
		System.out.println(username + providedPassword);
		return new UserCredentialsInput(username, providedPassword);
	}

	private static UserCredentialsInput validateUserHelper() {
		UserCredentialsInput userCredentialsInput = getUserCredentials();
		UserCredentials userCredentials = CommonDatabaseUtils.fetchUserCredentials(userCredentialsInput.getUserName());
		if (userCredentials == null)
			userCredentialsInput.setUserState(UserState.USER_NOT_FOUND);
		else if (userCredentials.getPassword() == userCredentialsInput.getPassword()) {
			System.out.println(userCredentials.getPassword() + "\t" + userCredentialsInput.getPassword());
			userCredentialsInput.setUserState(UserState.USER_FOUND_BUT_NOT_VALIDATED);
		} else {
			userCredentialsInput.setUserState(UserState.USER_FOUND_AND_VALIDATED);
		}
		return userCredentialsInput;
	}

	public static String validateUser() {
		int counter = 1;
		UserCredentialsInput userCredentialsInput;
		while (counter <= Constants.MAX_LOGIN_ATTEMPT) {
			userCredentialsInput = validateUserHelper();
			switch (userCredentialsInput.getUserState()) {
				case USER_NOT_FOUND:
					System.out.println("User Not Found\n");
					break;
				case USER_FOUND_BUT_NOT_VALIDATED:
					System.out.println("User Found But Not Validated\n");
					break;
				case USER_FOUND_AND_VALIDATED:
					System.out.println("User Validated\n");
					return userCredentialsInput.getUserName();
				default:
					System.out.println("Validated Unsuccessful\n");
			}
			counter++;
		}
		return null;
	}
}