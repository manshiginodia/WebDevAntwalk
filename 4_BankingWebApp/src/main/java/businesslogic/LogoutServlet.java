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
import javax.servlet.http.HttpSession;


public class LogoutServlet extends HttpServlet {
	
    public LogoutServlet() {
        super();
        
    }

	public void init(ServletConfig config) throws ServletException {
		
	}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out =response.getWriter();
		HttpSession sid= request.getSession(false);
		if(sid!=null) {
			sid.invalidate();
			out.println("<center><font color=green> Logged out successfully</font></center>");
			RequestDispatcher redirect = request.getRequestDispatcher("login.html");
			redirect.include(request, response);
		}else {
			out.println("<center><font color=red> protected resource...session id required</font></center>");
			RequestDispatcher redirect = request.getRequestDispatcher("login.html");
			redirect.include(request, response);
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
