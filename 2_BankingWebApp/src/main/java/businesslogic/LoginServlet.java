package businesslogic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     public LoginServlet() {
        super();
            }

	public void init(ServletConfig config) throws ServletException {
	
	}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		//MIME : Multipurpose Internet main extension, it is a type of data to be exchanged between browser and server
		response.setContentType("text/html");
		
		// creation of PrintWriter obj which is used to display output on the browser
		PrintWriter out = response.getWriter();
		
		//collecting from data submitted via login.html from client to server
		String uname= request.getParameter("txtuname");
		String upwd = request.getParameter("txtpwd");
		
		//login validation login follow at server
		System.out.println(uname+" "+upwd);
		
		
		if(uname.equals("mack") && upwd.equals("mack")) {
			//out.println("<center><font color=green size=4> Logged in Successful</font></center>");
			RequestDispatcher redirect = request.getRequestDispatcher("service.html");
			redirect.forward(request, response);
			
		}else {
			out.println("<center><font color=red size=4>Username and/or Password Incorrect</font></center>");
			//RequestDispatcher redirect = request.getRequestDispatcher("login.html");
			//redirect.include(request, response);
	
			response.sendRedirect("https://www.google.com");
		}
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		service(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		service(request,response);
	}

}
