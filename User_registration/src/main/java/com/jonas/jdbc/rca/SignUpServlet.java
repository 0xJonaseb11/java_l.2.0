// SignupServlet.java
package com.jonas.jdbc.rca;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/SignUpServlet")
public class SignUpServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String role = request.getParameter("role");

//		if (RegistrationValidator.validateUsername(username) &&
//				RegistrationValidator.validateEmail(email) &&
//				RegistrationValidator.validatePassword(password)) {


			User user = new User(username, email, password, role);

			UserDao userDao = new UserDao();
			userDao.insert(user);

			response.sendRedirect("login.jsp");
//		} else {
//			response.sendRedirect("registration-failure.jsp");
//		}
	}
}
