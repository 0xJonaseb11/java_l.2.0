<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Student List</title>
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

        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }

        th, td {
            padding: 12px;
            border: 1px solid #ddd;
            text-align: left;
        }

        th {
            background-color: #4caf50;
            color: white;
        }
    </style>
</head>
<body>

    <div class="container">
        <h2>Student List</h2>
        <table>
            <thead>
                <tr>
                    <th>Student_Id</th>
                    <th>Name</th>
                    <th>Class</th>
                    <th>Age</th>
                </tr>
            </thead>
            <tbody>
                <% 
                    try {
                        Class.forName("com.mysql.cj.jdbc.Driver");
                        String url = "jdbc:mysql://localhost:3306/classDb";
                        String userN = "root";
                        String pass = "";
                        Connection con = DriverManager.getConnection(url, userN, pass);
                        Statement stmt = con.createStatement();
                        ResultSet rs = stmt.executeQuery("SELECT * FROM student");

                        while (rs.next()) {
                            int studentId = rs.getInt("student_Id");
                            String studentName = rs.getString("name");
                            String studentClass = rs.getString("class");
                            int studentAge = rs.getInt("age");

                            out.println("<tr>");
                            out.println("<td>" + studentId + "</td>");
                            out.println("<td>" + studentName + "</td>");
                            out.println("<td>" + studentClass + "</td>");
                            out.println("<td>" + studentAge + "</td>");
                            out.println("</tr>");
                        }

                        // Close resources
                        rs.close();
                        stmt.close();
                        con.close();
                    } catch (ClassNotFoundException | SQLException e) {
                        e.printStackTrace();
                        out.println("<tr><td colspan='4'>An error occurred: " + e.getMessage() + "</td></tr>");
                    }
                %>
            </tbody>
        </table>
    </div>

</body>
</html>
