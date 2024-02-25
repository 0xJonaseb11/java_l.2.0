	package com.rca.app;
	
	import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
	
	/**
	 * Servlet implementation class LoginServletController
	 */
	public class LoginServletController extends HttpServlet {
		private static final long serialVersionUID = 1L;
	       
	    /**
	     * @see HttpServlet#HttpServlet()
	     */
	    public LoginServletController() {
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
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			// Hashed Password
			String hashedPassword = PasswordHasher.hashPassword(password);
			
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				String url = "jdbc:mysql://localhost:3306/javaUserDb";
	            String userN = "root";
	            String pass = "";
	            Connection con = DriverManager.getConnection(url, userN, pass);
	            
	            PreparedStatement ps = con.prepareStatement("SELECT * FROM users WHERE email= ? AND password = ?");
	            ps.setString(1, email);
	            ps.setString(2, hashedPassword);	
	            ResultSet resultSet= ps.executeQuery();
	            
	            if (resultSet.next()) {
	                String userRole = resultSet.getString("role");
	                if ("admin".equalsIgnoreCase(userRole)) {
	                    response.sendRedirect("Admin.jsp");
	                } else {
	                    response.sendRedirect("Guest.jsp");
	                }
	            } else {
	                System.out.println("User not registered or incorrect credentials");
	            }
	            
			}catch (Exception e) {
				System.out.println(e);
			}
		}
	
	}
