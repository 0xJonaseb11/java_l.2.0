package com.rca.app;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexValidator {

    // Regular expression for validating an email address
    private static final String EMAIL_REGEX = "^[a-z]+\\d*@\\w+\\.\\w+$";

    // Regular expression for validating a password
    private static final String PASSWORD_REGEX = "^[a-zA-Z]+\\d+$";

    // Method to validate an email using the email regex
    public static boolean isValidEmail(String email) {
        Pattern pattern = Pattern.compile(EMAIL_REGEX);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    // Method to validate a password using the password regex
    public static boolean isValidPassword(String password) {
        Pattern pattern = Pattern.compile(PASSWORD_REGEX);
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }
}

