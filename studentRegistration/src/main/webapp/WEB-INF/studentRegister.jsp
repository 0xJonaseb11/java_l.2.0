<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>JMV</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/tailwindcss@2.2.19/dist/tailwind.min.css">
</head>
<body class="bg-gray-100">

	<div class="text-center py-8">
		<h1 class="text-3xl font-bold text-blue-600">User Management</h1>
		<div class="mt-4">
			<a href="new"
				class="inline-block px-4 py-2 text-white bg-green-500 rounded">Add
				New User</a> <a href="list"
				class="inline-block px-4 py-2 text-white bg-blue-500 rounded ml-2">List
				All Students</a>
		</div>
	</div>

	<div class="max-w-md mx-auto bg-white p-8 shadow-md rounded-md mt-8">

		<c:choose>
			<c:when test="${student != null}">
				<form action="update" method="post">
					<input type="hidden" name="id"
						value="<c:out value='${student.id}' />" />
			</c:when>
			<c:otherwise>
				<form action="insert" method="post">
			</c:otherwise>
		</c:choose>

		<table class="w-full border border-collapse border-gray-300">
			<caption class="text-lg font-bold mb-4">
				<c:choose>
					<c:when test="${student != null}">
                        Edit Student
                    </c:when>
					<c:otherwise>
                        Add New Student
                    </c:otherwise>
				</c:choose>
			</caption>

			<c:if test="${student != null}">
				<input type="hidden" name="id"
					value="<c:out value='${student.id}' />" />
			</c:if>

			<tr>
				<th class="border p-2">Name:</th>
				<td class="border p-2"><input type="text" name="name"
					class="w-full border rounded p-2"
					value="<c:out value='${student.name}' />" /></td>
			</tr>
			<tr>
				<th class="border p-2">Age:</th>
				<td class="border p-2"><input type="number" name="age"
					class="w-full border rounded p-2"
					value="<c:out value='${student.age}' />" /></td>
			</tr>
			<tr>
				<th class="border p-2">DOB:</th>
				<td class="border p-2"><input type="date" name="dob"
					class="w-full border rounded p-2"
					value="<c:out value='${student.dob}' />" /></td>
			</tr>
			<tr>
				<th class="border p-2">School:</th>
				<td class="border p-2"><input type="text" name="school"
					class="w-full border rounded p-2"
					value="<c:out value='${student.school}' />" /></td>
			</tr>
			<tr>
				<th class="border p-2">Code:</th>
				<td class="border p-2"><input type="text" name="code"
					class="w-full border rounded p-2"
					value="<c:out value='${student.code}' />" /></td>
			</tr>
			<tr>
				<th class="border p-2">Email:</th>
				<td class="border p-2"><input type="email" name="email"
					class="w-full border rounded p-2"
					value="<c:out value='${student.email}' />" /></td>
			</tr>
			<tr>
				<th class="border p-2">Mobile:</th>
				<td class="border p-2"><input type="tel" name="mobile"
					class="w-full border rounded p-2"
					value="<c:out value='${student.mobile}' />" /></td>
			</tr>
			<tr>
				<td colspan="2" class="border p-2 text-center"><input
					type="submit" value="Save"
					class="px-4 py-2 bg-blue-500 text-white rounded cursor-pointer">
				</td>
			</tr>
		</table>
		</form>
	</div>

</body>
</html>
