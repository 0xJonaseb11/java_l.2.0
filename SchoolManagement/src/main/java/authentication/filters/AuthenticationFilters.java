package authentication.filters;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import Users.UserService;
import Users.UserModel;

@WebFilter("/AuthenticationFilters")
public class AuthenticationFilters extends HttpFilter implements Filter {
       
    public AuthenticationFilters() {
        super();
    }

    public void destroy() {
        // Cleanup code, if needed
    }

    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        HttpSession session=request.getSession();
    	
    	
		String id=String.valueOf(session.getAttribute("id"));
		System.out.print(id);
		
	    if(id==null||id.isBlank()||id=="null") {
	    	response.sendRedirect("/login.jsp");
	    }
	    UserModel user=UserService.getUserById(id);
        // Check if the user is authenticated
	    if(user==null) {
	    	response.sendRedirect("/login.jsp");
	    }
	    else if(user.getRole()!="admin") {
	    	response.sendRedirect("/guest.jsp");
	    }
         else {
            // User is authenticated, proceed with the request
            chain.doFilter(request, response);
        }
    }

    public void init(FilterConfig fConfig) throws ServletException {
        // Initialization code, if needed
    }
}
