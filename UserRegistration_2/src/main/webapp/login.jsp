<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<link rel="stylesheet" type="text/css" href="styles.css">
</head>
<body>
<div class="container">
        <h2>Login</h2>

        <form action="LoginServletController" method="post">
            <label for="email">Email:</label>
            <input type="text" id="email" name="email" required><br>

            <label for="password">Password:</label>
            <input type="password" id="password" name="password" required><br>

            <input type="submit" value="Login">
        </form>

        <p>Don't have an account? <a href="register.jsp">Register</a></p>
    </div>

</body>
</html>