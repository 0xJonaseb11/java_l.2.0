package com.rca.app;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegisterStudent
 */
public class RegisterStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterStudent() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		String name= request.getParameter("name");
		String studentClass= request.getParameter("class");
		int age =Integer.parseInt( request.getParameter("age"));
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/classDb";
            String userN = "root";
            String pass = "";
            Connection con = DriverManager.getConnection(url, userN, pass);
            PreparedStatement ps = con.prepareStatement("INSERT INTO student (name,class,age) VALUES (?,?,?)");
            ps.setString(1, name);
            ps.setString(2, studentClass);
            ps.setInt(3, age);
            
            
            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Student inserted successfully!");
                response.sendRedirect("StudentList.jsp");
            } else {
                System.out.println("Failed to insert data.");
            }

		}catch (Exception e) {
			System.out.println(e);
		}
	}

}
