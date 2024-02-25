<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registration of employees</title>
</head>
<body>

<form action="RegistrationController" method="post">
<div><label for="name">FirstName</label><input type="text" name="fname" id="name"></div>
<div><label for="ln">LastName</label><input type="text" name="lname" id="name"></div>
<div><label for="email">Email</label><input type="text" name="email" id="email"></div>
<div><label for="position">Position</label><input type="text" name="position" id="position"></div>
<div><label for="mobile">Mobile</label><input type="text" name="mobile" id="mobile"></div>
<input type="submit" name="Register">
</form>

<h2>Registered employee</h2>

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
<td><c:out value="${employee.id}"/></td>
<td><c:out value="${employee.firstName}"/></td>
<td><c:out value="${employee.lastName}"/></td>
<td><c:out value="${employee.email}"/></td>
<td><c:out value="${employee.position}"/></td>
<td><c:out value="${employee.mobile}"/></td>

</tr>
</c:forEach>

</table>
</body>
</html>