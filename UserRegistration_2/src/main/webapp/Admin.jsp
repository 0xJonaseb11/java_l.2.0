<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Admin Page</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
        }

        .container {
            max-width: 800px;
            margin: 50px auto;
            background-color: #fff;
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        h2 {
            color: #333;
        }

        p {
            color: #666;
        }

        form {
            margin-top: 20px;
        }

        label {
            display: block;
            margin-bottom: 8px;
        }

        input, select {
            width: 100%;
            padding: 8px;
            margin-bottom: 15px;
            box-sizing: border-box;
        }

        input[type="submit"] {
            background-color: #4caf50;
            color: #fff;
            cursor: pointer;
        }

        input[type="submit"]:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>

    <div class="container">
        <h2>Welcome, Admin!</h2>
        <p>This is the Admin page. You have access to additional features and functionalities.</p>
        <h2>Add a student</h2>

        <form action="RegisterStudent" method="post">
            <label for="name">Name:</label>
            <input type="text" id="name" name="name" required>

            <label for="class">Class:</label>
            <input type="text" id="class" name="class" required>

            <label for="age">Age:</label>
            <input type="number" id="age" name="age" required>

            <input type="submit" value="Add Student">
        </form>
    </div>

</body>
</html>
