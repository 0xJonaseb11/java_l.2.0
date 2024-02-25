package controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.Student;
import services.StudentServices;

import java.io.IOException;

/**
 * Servlet implementation class CodingController
 */
public class CodingController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	StudentServices services= StudentServices.getInstance();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CodingController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		request.getRequestDispatcher("WEB-INF/form.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
 if(request.getParameter("name")==null) {
		doGet(request, response);
 }
 int id=Integer.parseInt(request.getParameter("id"));
 String name=request.getParameter("name");
 String email=request.getParameter("email");
 
 Student student=new Student(id,name,email);
 
 services.addStudent(student); 
 request.getRequestDispatcher("WEB-INF/form.jsp").forward(request, response);
	}

}
