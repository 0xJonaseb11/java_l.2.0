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
		<h1 class="text-3xl font-bold text-blue-600">Student Management</h1>
		<div class="mt-4">
			<a href="new"
				class="inline-block px-4 py-2 text-white bg-green-500 rounded">Add
				New Student</a> <a href="list"
				class="inline-block px-4 py-2 text-white bg-blue-500 rounded ml-2">List
				All Students</a> <a href="logout"
				class="inline-block px-4 py-2 text-white bg-red-500 rounded ml-2">Logout</a>
		</div>
	</div>

	<div class="max-w-4xl mx-auto bg-white p-8 shadow-md rounded-md mt-8">
		<table class="w-full border border-collapse border-gray-300">
			<caption class="text-lg font-bold mb-4">List of Students</caption>
			<thead>
				<tr>
					<th class="border p-2">ID</th>
					<th class="border p-2">Name</th>
					<th class="border p-2">Age</th>
					<th class="border p-2">DOB</th>
					<th class="border p-2">School</th>
					<th class="border p-2">Code</th>
					<th class="border p-2">Email</th>
					<th class="border p-2">Phone</th>
					<th class="border p-2">Actions</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="student" items="${result}">
					<tr>
						<td class="border p-2"><c:out value="${student.id}" /></td>
						<td class="border p-2"><c:out value="${student.name}" /></td>
						<td class="border p-2"><c:out value="${student.age}" /></td>
						<td class="border p-2"><c:out value="${student.dob}" /></td>
						<td class="border p-2"><c:out value="${student.school}" /></td>
						<td class="border p-2"><c:out value="${student.code}" /></td>
						<td class="border p-2"><c:out value="${student.email}" /></td>
						<td class="border p-2"><c:out value="${student.mobile}" /></td>
						<td class="border p-2"><a
							href="edit?id=<c:out value='${student.id}' />"
							class="text-blue-500 hover:underline mr-2">Edit</a> <a
							href="delete?id=<c:out value='${student.id}' />"
							class="text-red-500 hover:underline">Delete</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

</body>
</html>
