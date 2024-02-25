package com.rca.app;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegisterServletController
 */
public class RegisterServletController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServletController() {
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
		String userName= request.getParameter("username");
		String email= request.getParameter("email");
		String password = request.getParameter("password");
		// Hashing the password
		String hashedPassword = PasswordHasher.hashPassword(password);
		String role = request.getParameter("role");
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/javaUserDb";
            String userN = "root";
            String pass = "";
            Connection con = DriverManager.getConnection(url, userN, pass);
            PreparedStatement ps = con.prepareStatement("INSERT INTO users (userName,email,password,role) VALUES (?,?,?,?)");
            ps.setString(1, userName);
            ps.setString(2, email);
            ps.setString(3, hashedPassword);
            ps.setString(4, role);
            
            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Data inserted successfully!");
                
             // Redirect based on user role
                if ("admin".equalsIgnoreCase(role)) {
                    // Redirect to admin.jsp
                    RequestDispatcher dispatcher = request.getRequestDispatcher("Admin.jsp");
                    dispatcher.forward(request, response);
                } else if ("guest".equalsIgnoreCase(role)) {
                    // Redirect to guest.jsp
                    RequestDispatcher dispatcher = request.getRequestDispatcher("Guest.jsp");
                    dispatcher.forward(request, response);
                }
                
            } else {
                System.out.println("Failed to insert data.");
            }

		}catch (Exception e) {
			System.out.println(e);
		}
	}

}
