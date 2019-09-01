package com.herokuapp.mohitdtumce;

import com.herokuapp.mohitdtumce.user.main.User;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		System.out.println("Welcome to QuickSnap");
		System.out.println("1. Login\n2. Sign-up\nEnter your choice: ");
		Scanner scanner = new Scanner(System.in);
		int choice = scanner.nextInt();
		switch (choice) {
			case 1:
				System.out.println("Login");
				User user = new User();
				break;
			case 2:
				System.out.println("Sign-up");
				break;
			default:
				System.out.println("Incorrect Choice");
		}

	}
}
