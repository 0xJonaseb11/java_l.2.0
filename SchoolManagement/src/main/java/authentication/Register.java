package authentication;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import security.PasswordHasher;
import Users.UserModel;
import Users.UserService;

public class Register extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // No implementation for now
    	 List <UserModel> users=UserService.getAllUsers();
         req.setAttribute("list", users);
         
         
         req.getRequestDispatcher("/home.jsp").forward(req, resp);
    	
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      
        

        String userName = req.getParameter("username");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String role = req.getParameter("role");
        if(userName.isEmpty()||email.isEmpty()||password.isEmpty()) {
        	req.getRequestDispatcher("/signup.jsp").forward(req, resp);
        }
        else {
        	  // Hashing the password
            String hashedPassword = PasswordHasher.hashPassword(password);

            HttpSession session=req.getSession();
            if(role==null||role.isEmpty()) {
            	 UserModel registeredUser=new UserModel(userName,email,hashedPassword);
                 
     			UserService.addUser(registeredUser);
     			List <UserModel> users=UserService.getAllUsers();
    			req.setAttribute("list", users);
    			session.setAttribute("id", registeredUser.getId());
    			req.getRequestDispatcher("/home.jsp").forward(req, resp);
            }
            else {
            	 UserModel registeredUser=new UserModel(userName,email,hashedPassword,role);
                 
     			UserService.addUser(registeredUser);
     			List <UserModel> users=UserService.getAllUsers();
    			req.setAttribute("list", users);
    			session.setAttribute("id", registeredUser.getId());
    			req.getRequestDispatcher("/home.jsp").forward(req, resp);
            }
             
           
			
        }

      
    }
}