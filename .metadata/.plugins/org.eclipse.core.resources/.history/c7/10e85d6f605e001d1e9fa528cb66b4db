package businesslogic;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public RegisterServlet() {
        super();
        
    }

	public void init(ServletConfig config) throws ServletException {
	
	}
	
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		//collecting the form data from incoming register request having data of register.htlm
		String name = request.getParameter("txtname");
		String age = request.getParameter("txtage");
		String gender = request.getParameter("txtgender");
		String address = request.getParameter("txtaddr");
		String email = request.getParameter("txtemail");
		String username = request.getParameter("txtuname");
		String password = request.getParameter("txtpwd");
		String cpassword = request.getParameter("txtcpwd");
		
		System.out.println(name+" "+age+" "+gender+" "+address+" "+email+" "+username+" "+password+" "+cpassword);
	
		
		//we will connect backend app server with backend database server
		
	
	
	
	
	
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		service(request,response);
		}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		service(request,response);
	}

}
