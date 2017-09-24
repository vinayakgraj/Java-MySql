package SqlQuery;

import java.sql.*;

import com.mysql.jdbc.PreparedStatement;


public class DeleteRow {

	private int sno ;

	public DeleteRow(int sno) {
		
		this.sno = sno;
		
		Connection conn = null;
		PreparedStatement Stmt = null;
		
		try {
		String myDriver = "org.gjt.mm.mysql.Driver";
	    String myUrl = "jdbc:mysql://127.0.0.1:3306/Feedback";
	    Class.forName(myDriver);
		conn = DriverManager.getConnection(myUrl, "root", "zing77");
		  
		String del = "DELETE FROM feedback_2 WHERE sno= ?";
	    Stmt = (PreparedStatement) conn.prepareStatement(del);
	    Stmt.setInt(1,sno);
	    Stmt.execute();
	    conn.close();
		  
		  
		  
		  
		  
		  
	
		}catch(SQLException se){
			//Handle errors for JDBC
			se.printStackTrace();
			}catch(Exception e){
			//Handle errors for Class.forName
			e.printStackTrace();
			}finally{
			//finally block used to close resources
			try{
			  if(Stmt!=null)
			     conn.close();
			}catch(SQLException se){
			}// do nothing
			try{
			  if(conn!=null)
			     conn.close();
			}catch(SQLException se){
			  se.printStackTrace();
			}//end finally try
			}
		System.out.println("deleted");
	}
}
