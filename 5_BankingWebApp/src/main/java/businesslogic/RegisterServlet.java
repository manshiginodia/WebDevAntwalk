package businesslogic;

import java.io.IOException;
import java.io.PrintWriter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class RegisterServlet extends HttpServlet {
	
	Connection con;
	Statement stmt;
	PreparedStatement pstmt;
	ResultSet rs;
	
	String drivername;
	String dblocation;
	String dbusername;
	String dbuserpwd;
	String sitelang,sitecountry;
 
    public RegisterServlet() {
        super();
        
    }

	public void init(ServletConfig config) throws ServletException {
	
		ServletContext ctx = config.getServletContext();
		
		drivername = ctx.getInitParameter("dbdriver");
		dblocation= ctx.getInitParameter("dbloc");
		dbusername = ctx.getInitParameter("dbuser");
		dbuserpwd = ctx.getInitParameter("dbpwd");
		
		
		sitelang = config.getInitParameter("reginitparam");
		sitecountry= config.getInitParameter("loginitparam");
		
		System.out.println("in registration servlet"+sitelang+" "+sitecountry);
		
		
		
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
		
		//System.out.println(name+" "+age+" "+gender+" "+address+" "+email+" "+username+" "+password+" "+cpassword);
	
	     PrintWriter out = response.getWriter();
		
		//we will connect backend app server with backend database server
	
		try {

            Class.forName(drivername);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        try {

            con = DriverManager.getConnection(dblocation,dbusername,dbuserpwd);
            
            String insertquery = "INSERT INTO tblbankuser VALUES(?,?,?,?,?,?,?)";

            pstmt = con.prepareStatement(insertquery,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
            //placing runtime text box value into sql query wild card before sending the query to the underlying database
            
            pstmt.setString(2,name);
            pstmt.setInt(3,Integer.parseInt(age));
            pstmt.setString(4,gender);
            pstmt.setString(5,address);
            pstmt.setString(6,username);
            pstmt.setString(7,email);
            pstmt.setString(8,password);
            
            //now send the query to backend database for insert to happen
            
            int status = pstmt.executeUpdate();
       
           
            if(status >0) {
            	out.println("<html><center><font color=green> Registration done. Please Login</font></center></html>");
            	RequestDispatcher redirect = request.getRequestDispatcher("login.html");
            	redirect.include(request, response);
     
            }else {
            	out.println("<html><center><font color=red> Something went wrong while registration. Please try again</font></center></html>");
            	RequestDispatcher redirect = request.getRequestDispatcher("register.html");
            	redirect.include(request, response);
            }
            
            
            
        } catch (SQLException e) {
            e.printStackTrace();
            out.println("<html><center><font color=red> Something went wrong while registration. Please try again</font></center></html>");
        	RequestDispatcher redirect = request.getRequestDispatcher("register.html");
        	redirect.include(request, response);
        	
        }

    }
			
		
		
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		service(request,response);
		}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		service(request,response);
	}

}
