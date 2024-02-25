package student;

import jakarta.servlet.ServletException;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import validation.Validation;

import java.io.IOException;
import java.util.List;

import Users.UserModel;
import Users.UserService;

/**
 * Servlet implementation class Student
 */
public class Student extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Student() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		System.out.print(session.toString());
		String id=String.valueOf(session.getAttribute("id"));
		
	    if(id==null||id.isEmpty()||id=="null") {
	    	request.setAttribute("error","Please login to continue");
	    	request.getRequestDispatcher("login").forward(request, response);
;	    }
	    else {
	    	
        UserModel user=UserService.getUserById(id);
        if(user==null) {
        	response.sendRedirect("login");
        }
        
        else {
        	
            List <UserModel> users=UserService.getAllUsers();
            request.setAttribute("list", users);
        	
        	List <StudentModel> students=StudentService.getAllStudents();
        	request.setAttribute("students", students);
        	request.getRequestDispatcher("/home.jsp").forward(request, response);
        }
	    
	    }
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession();
		System.out.print(session.toString());
		String id=String.valueOf(session.getAttribute("id"));
		
	    if(id==null||id.isEmpty()||id=="null") {
	    	request.setAttribute("error","Please login to continue");
	    	response.sendRedirect("login");
;	    }
	    else {
	    	
        UserModel user=UserService.getUserById(id);
        if(user==null) {
        	response.sendRedirect("login");
        }
        else if(user.getRole()!="admin") {
        	request.setAttribute("error", "Not authorized");
        	request.getRequestDispatcher("home.jsp").forward(request, response);
        }
        else {
        	
        	String name=request.getParameter("name");
        	String email=request.getParameter("email");
        	int age=Integer.parseInt(request.getParameter("age"));
        	String phoneNumber=request.getParameter("mobile");
        	String school=request.getParameter("email");
        	if(Validation.validateEmail(email)&&Validation.validatePhoneNumber(phoneNumber)) {
        		
        		StudentModel registeredStudent=new StudentModel(name,age,school,email,phoneNumber);
        	    List <UserModel> users=UserService.getAllUsers();
                request.setAttribute("list", users);
            	
            	List <StudentModel> students=StudentService.getAllStudents();
            	request.setAttribute("students", students);
            	request.getRequestDispatcher("/home.jsp").forward(request, response);
        		request.getRequestDispatcher("/home.jsp").forward(request, response);
        	}
        	else if(Validation.validateEmail(email)) {
        		request.setAttribute("error", "Invalid Phone number");
        		request.getRequestDispatcher("/home.jsp").forward(request, response);
        	}
        	else {
        		request.setAttribute("error", "Invalid Email");
        		request.getRequestDispatcher("/home.jsp").forward(request, response);
        	}
        
        	
        }
	    
	    }
	}

}
