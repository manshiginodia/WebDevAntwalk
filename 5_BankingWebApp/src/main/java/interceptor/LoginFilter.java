package interceptor;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;


public class LoginFilter extends HttpFilter implements Filter {
       
	String buser;
    
    public LoginFilter() {
        super();
        
    }

	
	public void destroy() {
		
	}

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("Filter 1: Login filter/registration");
		PrintWriter out= response.getWriter();
		response.setContentType("text/html");
		
		String un =request.getParameter("txtuname");
		
		if(buser.equals(un)) {
			out.println("<center>you are blocked for a while " + buser+"</center>");
		}
		
		else{
			chain.doFilter(request, response);
		}
	}

	
	public void init(FilterConfig Config) throws ServletException {
		ServletContext ctx= Config.getServletContext();
		buser = ctx.getInitParameter("blockeduser");
	}

}
