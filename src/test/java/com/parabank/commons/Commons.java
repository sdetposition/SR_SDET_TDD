package com.parabank.commons;

import java.util.Random;

import com.parabank.BaseTest;

public class Commons extends BaseTest {
	
	public String user;
	public static String pwd;

	private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

	public static String generateRandomString(int length) {
		Random random = new Random();
		StringBuilder sb = new StringBuilder(length);

		for (int i = 0; i < length; i++) {
			int index = random.nextInt(CHARACTERS.length());
			sb.append(CHARACTERS.charAt(index));
		}
		
		return sb.toString();
	}
}
