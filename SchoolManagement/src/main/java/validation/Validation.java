package validation;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {
public static boolean validateEmail(String email) {
	Pattern emailPattern=Pattern.compile(email,Pattern.CASE_INSENSITIVE);
    String regex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";

    Pattern pattern = Pattern.compile(regex);
    Matcher matcher = pattern.matcher(email);

    if (matcher.matches()) {
    	return true;
    } else {
    	return false;
    }
	
}
public static boolean validatePhoneNumber(String phoneNumber) {
	String regex = "^\\+(?:[0-9] ?){6,14}[0-9]$";

    Pattern pattern = Pattern.compile(regex);
    Matcher matcher = pattern.matcher(phoneNumber);

    if (matcher.matches()) {
        System.out.println("Valid phone number");
        return true;
    } else {
        System.out.println("Invalid phone number");
        return false;
    }
}
public boolean validatePassword(String password) {

    String passwordRegex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$";
    return password.matches(passwordRegex);
}
public boolean isValidUsername(String username) {
    String usernameRegex = "^[a-zA-Z0-9_]{3,20}$";
    return username.matches(usernameRegex);
}

}
