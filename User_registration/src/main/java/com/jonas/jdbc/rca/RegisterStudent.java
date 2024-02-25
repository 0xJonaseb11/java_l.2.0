package com.jonas.jdbc.rca;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
@WebServlet("/")
public class RegisterStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private StudentDao studentDao;

	public void init() {
		studentDao = new StudentDao();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();

		try {
			switch (action) {
			case "/new":
				showNewForm(request, response);
				break;
			case "/insert":
				insertStudent(request, response);
				break;
			case "/delete":
				deleteStudent(request, response);
				break;
			case "/edit":
				showEditForm(request, response);
				break;
			case "/update":
				updateStudent(request, response);
				break;
			default:
				listStudent(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	private void listStudent(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Student> result = studentDao.getAllStudents();

		request.setAttribute("result", result);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/index.jsp");
		dispatcher.forward(request, response);
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/studentRegister.jsp");
		dispatcher.forward(request, response);
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Student existingStudent = studentDao.getStudent(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/studentRegister.jsp");
		request.setAttribute("student", existingStudent);
		dispatcher.forward(request, response);

	}

	private void insertStudent(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		String name = request.getParameter("name");
		int age;
		try {
			age = Integer.parseInt(request.getParameter("age"));
		} catch (NumberFormatException e) {
			response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid age format");
			return;
		}

		String dobString = request.getParameter("dob");
		LocalDate dobLocalDate = LocalDate.parse(dobString);
		Date dob = Date.valueOf(dobLocalDate);

		String school = request.getParameter("school");
		String code = request.getParameter("code");
		String email = request.getParameter("email");
		String mobile = request.getParameter("mobile");
//		if (RegistrationValidator.validateEmail(email) &&
//				RegistrationValidator.validatePhone(mobile) &&
//				RegistrationValidator.validateUsername(name)) {

			Student student = new Student(0, name, age, dob, school, code, email, mobile);
			studentDao.insert(student);

			response.sendRedirect("list");
//		} else {
//			response.sendRedirect("registration-failure.jsp");
//		}

	}

	private void updateStudent(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		int age;
		try {
			age = Integer.parseInt(request.getParameter("age"));
		} catch (NumberFormatException e) {
			response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid age format");
			return;
		}

		String dobString = request.getParameter("dob");
		LocalDate dobLocalDate = LocalDate.parse(dobString);
		Date dob = Date.valueOf(dobLocalDate);

		String school = request.getParameter("school");
		String code = request.getParameter("code");
		String email = request.getParameter("email");
		String mobile = request.getParameter("mobile");

//		if (RegistrationValidator.validateEmail(email) &&
//				RegistrationValidator.validatePhone(mobile) &&
//				RegistrationValidator.validateUsername(name)) {

			Student student = new Student(id, name, age, dob, school, code, email, mobile);
			studentDao.updateStudent(student);

			response.sendRedirect("list");
//		} else {
//			response.sendRedirect("registration-failure.jsp");
//		}

	}

	private void deleteStudent(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		studentDao.deleteStudent(id);
		response.sendRedirect("list");
	}

}
