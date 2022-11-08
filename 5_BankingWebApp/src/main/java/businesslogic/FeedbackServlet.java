package businesslogic;
import model.Feedback;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DbOps;
import model.Feedback;

public class FeedbackServlet extends HttpServlet {
	
	String drivername;
	String dblocation;
	String dbusername;
	String dbuserpwd;   
   
    public FeedbackServlet() {
        super();
        
    }

	
	public void init(ServletConfig config) throws ServletException {
		ServletContext ctx = config.getServletContext();
		
		drivername = ctx.getInitParameter("dbdriver");
		dblocation= ctx.getInitParameter("dbloc");
		dbusername = ctx.getInitParameter("dbuser");
		dbuserpwd = ctx.getInitParameter("dbpwd");
		
		
	}

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fid= request.getParameter("txtfeedid");
		String fname= request.getParameter("txtfeedname");
		String fmsg= request.getParameter("txtfeedmsg");
		
		Feedback feedobj = new Feedback();
		
		feedobj.setFeedid(Integer.parseInt(fid));
		feedobj.setFeedname(fname);
		feedobj.setFeedmessage(fmsg);
		
		DbOps dbops= new DbOps(drivername, dblocation, dbusername, dbuserpwd ) ;
				
		int st=dbops.insertrcr(feedobj);	
		
		if(st>=1) {
			RequestDispatcher redirect = request.getRequestDispatcher("success.jsp");
			redirect.forward(request,response);
		}
		else {
			RequestDispatcher redirect = request.getRequestDispatcher("error.jsp");
			redirect.forward(request,response);
		}
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
