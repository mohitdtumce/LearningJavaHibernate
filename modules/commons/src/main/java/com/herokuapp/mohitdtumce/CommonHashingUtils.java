package com.herokuapp.mohitdtumce;

import org.mindrot.jbcrypt.BCrypt;

public class CommonHashingUtils {

	public static String hashUserPassword(String userPassword) {
		String salt = BCrypt.gensalt(12);
		return BCrypt.hashpw(userPassword, salt);
	}

	public static boolean validatePasswordMatch(String userPassword, String storedPassword) {
		return BCrypt.checkpw(userPassword, storedPassword);
	}
}
