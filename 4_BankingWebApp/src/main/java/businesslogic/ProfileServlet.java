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
import javax.servlet.http.HttpSession;

public class ProfileServlet extends HttpServlet {
	
	Connection con;
	Statement stmt;
	PreparedStatement pstmt;
	ResultSet rs;
	
	String drivername;
	String dblocation;
	String dbusername;
	String dbuserpwd;
       
 
    public ProfileServlet() {
        super();
       
    }

	public void init(ServletConfig config) throws ServletException {
		ServletContext ctx = config.getServletContext();
		
		drivername = ctx.getInitParameter("dbdriver");
		dblocation= ctx.getInitParameter("dbloc");
		dbusername = ctx.getInitParameter("dbuser");
		dbuserpwd = ctx.getInitParameter("dbpwd");
		
		
		
	}
	
	public ServletConfig getServletConfig() {
		return null;
	}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		
		//retrieving value passed by login authentication servlet by storing it into the session
		
		HttpSession sid= request.getSession(false);
		
		if (sid!=null) {
			String username = (String)sid.getAttribute("unkey");
			String userpwd = (String)sid.getAttribute("unpwd");
			out.println("<center><font color=green>");
			out.println("<a href=logout>LOGOUT</a></font></center>");
			
			out.println("<center><font color=green> Welcome to your profile Dear " +username+"</font></center>" );

			//use jdbc code to build profile page
			
			try {

	            Class.forName(drivername);
	        } catch (ClassNotFoundException e) {
	            throw new RuntimeException(e);
	        }

	        try {

	            con = DriverManager.getConnection(dblocation,dbusername,dbuserpwd);
	            
	            String searchquery = "SELECT cname,cage,cgender,caddress,cemail, cusername,cuserpass from tblbankuser WHERE cusername =? AND cuserpass =?";
	            pstmt = con.prepareStatement(searchquery,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
	            
	            pstmt.setString(1,username);
	            pstmt.setString(2, userpwd);
	            
	            rs= pstmt.executeQuery();
	            
	            if(rs.next()) {
	            	
	            	String name = rs.getString("cname");
	        		String age = rs.getString("cage");
	        		String gender = rs.getString("cgender");
	        		String address = rs.getString("caddress");
	        		String email = rs.getString("cemail");
	        		
	        		out.println("<center><font color=green> Name: "+name+"<br>");
	        		out.println("Age: "+age+"<br>");
	        		out.println("Gender: "+gender+"<br>");
	        		out.println("Address: "+address+"<br>");
	        		out.println("Email: "+email+"<br>");
	        		out.println("</font></center>" );

	              
	            }
	        }catch (SQLException e) {
	            e.printStackTrace();
	        	
	        }
			
		}else {
			out.println("<center><font color=red> protected resource...session id required</font></center>");
			RequestDispatcher redirect = request.getRequestDispatcher("login.html");
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
