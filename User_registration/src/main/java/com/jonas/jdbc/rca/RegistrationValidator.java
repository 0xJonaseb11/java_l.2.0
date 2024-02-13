package com.jonas.jdbc.rca;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegistrationValidator {

	private static final String EMAIL_REGEX = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
	private static final Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_REGEX);

	public static boolean validateEmail(String email) {
		Matcher matcher = EMAIL_PATTERN.matcher(email);
		return matcher.matches();
	}



	private static final String PHONE_REGEX = "^\\d{10}$";
	private static final Pattern PHONE_PATTERN = Pattern.compile(PHONE_REGEX);

	public static boolean validatePhone(String phone) {
		Matcher matcher = PHONE_PATTERN.matcher(phone);
		return matcher.matches();
	}




	private static final String USERNAME_REGEX = "^[a-zA-Z0-9_]{5,20}$";
	private static final Pattern USERNAME_PATTERN = Pattern.compile(USERNAME_REGEX);

	public static boolean validateUsername(String username) {
		Matcher matcher = USERNAME_PATTERN.matcher(username);
		return matcher.matches();
	}


	private static final String PASSWORD_REGEX = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8,20}$";
	private static final Pattern PASSWORD_PATTERN = Pattern.compile(PASSWORD_REGEX);

	public static boolean validatePassword(String password) {
		Matcher matcher = PASSWORD_PATTERN.matcher(password);
		return matcher.matches();
	}
}
