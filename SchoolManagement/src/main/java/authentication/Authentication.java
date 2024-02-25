package authentication;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import security.PasswordHasher;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import Users.UserModel;
import Users.UserService;

@WebServlet("/login")
public class Authentication extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	HttpSession session=req.getSession();
    	
    	
		String id=String.valueOf(session.getAttribute("id"));
		System.out.print(id);
		
	    if(id==null||id.isBlank()||id=="null") {
	    	req.getRequestDispatcher("/login.jsp").forward(req, resp);
	    }
	    else {
	    	List <UserModel> users=UserService.getAllUsers();
	        req.setAttribute("list", users);
	    	req.getRequestDispatcher("/home.jsp").forward(req, resp);
	    }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        HttpSession session=req.getSession();

        String email = req.getParameter("email");
        String password = req.getParameter("password");
       
        
       

        // Hashed Password
        String hashedPassword = PasswordHasher.hashPassword(password);

        try {
            // Use try-with-resources to automatically close resources
 
           String url = "jdbc:postgresql://localhost:5432/school_users"; // Change this URL according to your database configuration
             String userN = "school"; // Change this to your database username
            String pass = "12345678";
            // Change this to your database password
            
            try (Connection con = DriverManager.getConnection(url, userN, pass)) {
                String sql = "SELECT * FROM users WHERE email=? AND password=?";
                try (PreparedStatement ps = con.prepareStatement(sql)) {
                    ps.setString(1, email);
                    ps.setString(2, hashedPassword);

                    try (ResultSet resultSet = ps.executeQuery()) {
                        if (resultSet.next()) {
                            String userRole = resultSet.getString("role");
                            if ("admin".equalsIgnoreCase(userRole)) {
                                session.setAttribute("id", resultSet.getInt("user_id"));
                                List <UserModel> users=UserService.getAllUsers();
                    	        req.setAttribute("list", users);
                    	    	req.getRequestDispatcher("/home.jsp").forward(req, resp);
                                
                                
                                System.out.println("User logged in");
                            } else {
                                resp.sendRedirect("guest.jsp");
                                System.out.println("User logged in");
                            }
                        } else {
                        	req.setAttribute("error","Invalid email or password");
                        	System.out.println("User not registered or incorrect credentials"); 
                        	req.getRequestDispatcher("/login.jsp").forward(req, resp);
                        }
                    }
                }
            }
        } catch (SQLException e) {
            // Log the exception or handle it appropriately
            e.printStackTrace();
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Internal Server Error");
        }
    }
}