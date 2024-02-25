<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee Registration</title>
</head>
<body>
<form action="RegistrationController" method="post">
<div><label for="name">FirstName: </label><input type="text" name="fname" id="name"></div>
<div><label for="ln">LastName: </label><input type="text" name="lname" id="ln"></div>
<div><label for="email">Email: </label><input type="text" name="email" id="email"></div>
<div><label for="position">Position: </label><input type="text" name="position" id="position"></div>
<div><label for="mobile">Mobile: </label><input type="text" name="mobile" id="mobile"></div>
<input type="submit" value="Register">
</form>
<h2>Registered Employees</h2>
<table>
<tr>
<th>ID</th>
<th>FirstName</th>
<th>LastName</th>
<th>Email</th>
<th>Position</th>
<th>Mobile</th>
</tr>
<c:forEach var="employee" items="${employees}">
<tr>
<td><c:out value="${employee.id}" /></td>
<td><c:out value="${employee.firstName}" /></td>
<td><c:out value="${employee.lastName}" /></td>
<td><c:out value="${employee.email}" /></td>
<td><c:out value="${employee.position}" /></td>
<td><c:out value="${employee.mobile}" /></td>
</tr>
</table>
</body>
</html>









