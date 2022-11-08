package dao;

import java.sql.*;

import model.Feedback;

public class DbOps {

	Connection con;
	PreparedStatement pstmt;
	
	public String driver;
	public String dbloc;
	public String dbuser;
	public String dbpwd;
	public Feedback fobj;
	
	public DbOps(String driver, String dbloc, String dbuser, String dbpwd) {
		this.driver=driver;
		this.dbloc=dbloc;
		this.dbuser=dbuser;
		this.dbpwd=dbpwd;
		this.fobj =fobj;
		
		try {
			Class.forName(this.driver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			con =DriverManager.getConnection(dbloc,dbuser,dbpwd);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public int insertrcr(Feedback fobj) {
		this.fobj=fobj;
		
		int status=0;
		int fid = this.fobj.getFeedid();
		String fname = this.fobj.getFeedname();
		String fmsg = this.fobj.getFeedmessage();
		
		String insertquery = "INSERT INTO tblfeedback(feedid, feedname,feedmsg) VALUES (?,?,?)";
		
		try {
			pstmt = con.prepareStatement(insertquery,ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			pstmt.setInt(1, fid);		
			pstmt.setString(2,fname);
			pstmt.setString(3,fmsg);
			
			status= pstmt.executeUpdate();
		
		}catch(SQLException e) {
			e.printStackTrace();
		}
				
		return status;
		
	}
}
