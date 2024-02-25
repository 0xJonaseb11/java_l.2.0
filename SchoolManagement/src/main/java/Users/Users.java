package Users;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import student.StudentModel;
import student.StudentService;

import java.io.IOException;
import java.util.List;

/**
 * Servlet implementation class Users
 */
public class Users extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Users() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession();
		System.out.print(session.toString());
		String id=String.valueOf(session.getAttribute("id"));
		
	    if(id==null||id.isEmpty()||id=="null") {
	    	response.sendRedirect("login");
;	    }
	    else {
        UserModel user=UserService.getUserById(id);
        if(user==null) {
        	response.sendRedirect("login");
        }
        List <UserModel> users=UserService.getAllUsers();
        request.setAttribute("list", users);
   
    	List <StudentModel> students=StudentService.getAllStudents();
    	System.out.print("students");
    	request.setAttribute("students", students);
    	
    	request.getRequestDispatcher("/home.jsp").forward(request, response);
	    }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
