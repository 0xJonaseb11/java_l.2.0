package Users;

public class UserModel {
int id;
String email;
String username;
String password;
String role;
public String getRole() {
	return role;
}
public void setRole(String role) {
	this.role = role;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getString() {
	return role;
}
public void setString(String role) {
	this.role = role;
}
public int getId() {
	return this.id;
}
public void setId(int id) {
	this.id=id;
}
public UserModel(String email, String username, String password, String role) {
	super();
	this.email = email;
	this.username = username;
	this.password = password;
	this.role = role;
}
public UserModel() {
	super();
}
public UserModel(String username, String email, String hashedPassword) {
	this.email = email;
	this.username = username;
	this.password = hashedPassword;
	this.role="admin";
	// TODO Auto-generated constructor stub
}


}
