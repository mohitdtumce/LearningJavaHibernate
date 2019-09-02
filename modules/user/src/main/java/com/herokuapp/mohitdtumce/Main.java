package com.herokuapp.mohitdtumce;

import com.herokuapp.mohitdtumce.commons.utils.CommonUtils;
import com.herokuapp.mohitdtumce.user.main.User;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		System.out.println("Welcome to QuickSnap");
		System.out.println("1. Login\n2. Sign-up\n3. Exit\nEnter your choice: ");
		Scanner scanner = new Scanner(System.in);
		int choice = scanner.nextInt();
		switch (choice) {
			case 1:
				System.out.println("Login");
				String userName = CommonUtils.validateUser();
				if (userName == null) {
					System.out.println("You don't seem to be a valid user.\nWould you rather Sign-up instead?");
					System.out.println("1. Sign-up\n2. Exit\nEnter your choice: ");
				} else {
					User user = new User(userName);
				}
				break;
			case 2:
				System.out.println("Sign-up");
				break;
			default:
				System.out.println("Incorrect Choice");
		}

	}
}
