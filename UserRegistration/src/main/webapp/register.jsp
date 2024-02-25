<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register!</title>
<link rel="stylesheet" type="text/css" href="styles.css">
</head>
<body>
	<div class="container">
		<h2>User Registration</h2>

		<form action="RegisterServletController" method="post">
			<label for="username">Username:</label> <input type="text"
				id="username" name="username" required><br> <label
				for="email">Email:</label> <input type="email" id="email"
				name="email" required><br> <label for="password">Password:</label>
			<input type="password" id="password" name="password" required><br>

			<label for="role">Role:</label> <select id="role" name="role"
				required>
				<option value="guest">Guest</option>
				<option value="admin">Admin</option>
			</select><br> <input type="submit" value="Register">
		</form>

		<p>
			Already have an account? <a href="login.jsp">Login</a>
		</p>
	</div>

</body>
</html>